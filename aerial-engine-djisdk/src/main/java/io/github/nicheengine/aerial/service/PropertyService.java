package io.github.nicheengine.aerial.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.enums.GatewayThing;
import io.github.nicheengine.aerial.enums.PropertySetResult;
import io.github.nicheengine.aerial.enums.property.PropertySet;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.error.status.EngineErrorStatus;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.mqtt.property.PropertySetPublish;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

@Slf4j
public abstract class PropertyService {
    @Resource
    private PropertySetPublish propertySetPublish;

    @DjisdkVersion(exclude = GatewayThing.REMOTER_CONTROL)
    public PropertySetResult propertySet(GatewayManager gateway, PropertySet propertySet, AerialDjisdkModel request) throws RestException {
        checkCondition(gateway, propertySet, request);
        AerialDjisdkModel.ofVerify(request);
        Field[] fields = request.getClass().getDeclaredFields();
        Optional<Field> firstOptional = Arrays.stream(fields).findFirst();
        firstOptional.orElseThrow(() -> new AerialServerErrorException(EngineErrorStatus.AERIAL_DATA_ERROR));
        Field firstField = firstOptional.get();
        Valid valid = firstField.getDeclaredAnnotation(Valid.class);
        if (fields.length > 1 || GeneralUtils.isEmpty(valid)) {
            return propertySetPublish.publish(gateway.getGatewaySn(), request);
        }
        firstField.setAccessible(true);
        Type genericType = firstField.getGenericType();
        if (!(genericType instanceof Class)) {
            firstField.setAccessible(false);
            return propertySetPublish.publish(gateway.getGatewaySn(), request);
        }
        Map<String, Object> fieldValueMap = new HashMap<>();
        Class<?> fieldType = (Class<?>) genericType;
        try {
            Object child = firstField.get(request);
            for (Field field : fieldType.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(child);
                if (Objects.isNull(value)) {
                    continue;
                }
                JsonProperty jsonProperty = field.getDeclaredAnnotation(JsonProperty.class);
                String fieldName = Optional.ofNullable(jsonProperty).map(JsonProperty::value).orElse(field.getName());
                fieldValueMap.put(fieldName, value);
                field.setAccessible(false);
                PropertySetResult result = propertySetPublish.publish(
                        gateway.getGatewaySn(), Collections.singletonMap(propertySet.getProperty(), fieldValueMap));
                if (PropertySetResult.SUCCESS != result) {
                    return result;
                }
                fieldValueMap.clear();
            }
        } catch (IllegalAccessException exception) {
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_ERROR,exception);
        } finally {
            firstField.setAccessible(false);
        }
        return PropertySetResult.SUCCESS;
    }

    private void checkCondition(GatewayManager gateway, PropertySet propertySet, AerialDjisdkModel request) throws RestException {
        if (Objects.isNull(request) || propertySet.getType() != request.getClass()) {
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_PARAM_ERROR);
        }
        if (!propertySet.getSupportedDevices().contains(gateway.getGatewayThing())) {
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_DEVICE_UNREGISTERED);
        }
        if (propertySet.isDeprecated() || !gateway.getSdkVersion().isSupported(propertySet.getSince())) {
            throw new AerialServerErrorException(EngineErrorStatus.AERIAL_DEVICE_VERSION_UNSUPPORTED);
        }
    }
}
