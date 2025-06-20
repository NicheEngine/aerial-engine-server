package io.github.nicheengine.aerial;

import io.github.nicheengine.aerial.error.AerialDeviceErrorException;
import io.github.nicheengine.aerial.error.AerialErrorStatus;
import io.github.nicheengine.aerial.error.AerialServerErrorException;
import io.github.nicheengine.aerial.manager.GatewayManager;
import io.github.nicheengine.aerial.stereotype.DjisdkVersion;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.stream.RestCollectors;
import io.github.nichetoolkit.rest.stream.RestStream;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rest.util.OptionalUtils;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor
public class AerialDjisdkModel implements Serializable {

    private final static Validator VALIDATOR;

    static {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            VALIDATOR = validatorFactory.getValidator();
        }
    }

    public AerialDjisdkModel verify() throws RestException {
        return this.verify(null);
    }

    public AerialDjisdkModel verify(GatewayManager gateway) throws RestException {
        Set<ConstraintViolation<AerialDjisdkModel>> violations = VALIDATOR.validate(this);
        if (GeneralUtils.isNotEmpty(gateway)) {
            Set<String> names = new HashSet<>();
            violations = RestStream.stream(violations).filter(violation -> {
                String[] splits = violation.getPropertyPath().toString().split("\\.");
                Class<AerialDjisdkModel> rootBeanClass = violation.getRootBeanClass();
                return filterProperty(gateway, rootBeanClass, splits, 0, true, names);
            }).collect(RestCollectors.toSet());
        }
        if (GeneralUtils.isNotEmpty(violations)) {
            String fieldNames = violations.stream().map(this::ofViolation).collect(Collectors.joining("; "));
            throw new AerialServerErrorException(AerialErrorStatus.AERIAL_PARAM_ERROR, this.getClass().getSimpleName(), fieldNames);
        }
        return this;

    }

    public AerialDjisdkModel verifyProperty(String fieldName, GatewayManager gateway) throws RestException {
        try {
            Field field = this.getClass().getDeclaredField(fieldName);
            DjisdkVersion djisdkVersion = field.getDeclaredAnnotation(DjisdkVersion.class);
            boolean supportPresent = gateway.isTypeSupport(djisdkVersion) && gateway.isVersionSupport(djisdkVersion);
            OptionalUtils.ofFalse(supportPresent, () -> new AerialDeviceErrorException(AerialErrorStatus.AERIAL_DEVICE_PROPERTY_UNSUPPORTED, this.getClass().getSimpleName(), fieldName));
        } catch (NoSuchFieldException exception) {
            throw new AerialDeviceErrorException(AerialErrorStatus.AERIAL_DEVICE_ERROR, exception);
        }
        return this;
    }

    private String ofViolation(ConstraintViolation<AerialDjisdkModel> violation) {
        return violation.getPropertyPath().toString() + violation.getMessage() + ", value: " + violation.getInvalidValue();
    }

    private boolean filterProperty(GatewayManager gateway, Class<?> type, String[] fields, int index, boolean propertyValid, Set<String> propertyNames) throws AerialDeviceErrorException {
        if (!propertyValid || index == fields.length) {
            return false;
        }
        String[] elements = Arrays.copyOf(fields, index + 1);
        String propertyName = String.join(".", elements);
        if (propertyNames.contains(propertyName)) {
            return false;
        }
        try {
            Field field = type.getDeclaredField(fields[index]);
            DjisdkVersion djisdkVersion = field.getAnnotation(DjisdkVersion.class);
            propertyValid = gateway.isPropertyValid(djisdkVersion);
            if (!propertyValid) {
                propertyNames.add(propertyName);
            }
            return filterProperty(gateway, field.getType(), fields, index + 1, propertyValid, propertyNames);
        } catch (NoSuchFieldException exception) {
            throw new AerialDeviceErrorException(AerialErrorStatus.AERIAL_DEVICE_ERROR, exception);
        }
    }
}