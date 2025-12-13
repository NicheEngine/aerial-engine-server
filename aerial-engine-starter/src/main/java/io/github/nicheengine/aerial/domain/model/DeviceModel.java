package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nicheengine.aerial.domain.entity.DeviceEntity;
import io.github.nicheengine.aerial.enums.BoundState;
import io.github.nicheengine.aerial.enums.CompatibleState;
import io.github.nicheengine.aerial.enums.device.*;
import io.github.nichetoolkit.jts.serialization.GeometryDeserializer;
import io.github.nichetoolkit.jts.serialization.GeometrySerializer;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoModel;
import io.github.nichetoolkit.rice.jsonb.PropertyUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.locationtech.jts.geom.Geometry;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceModel extends RestInfoModel<DeviceModel, DeviceEntity> {
    private String workspaceId;
    private String userId;
    private String deviceSn;
    private String deviceName;
    private ThingType thingType;
    private DeviceDomain deviceDomain;
    private AerialDeviceType deviceType;
    private DeviceSubtype deviceSubtype;
    private DeviceThing deviceThing;
    private ControlSource deviceIndex;
    private String firmwareVersion;
    private String protocolVersion;
    private CompatibleState compatibleState;
    private String childSn;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date boundTime;
    private BoundState boundState;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
    private String iconNormal;
    private String iconSelect;
    @JsonDeserialize(using = GeometryDeserializer.class)
    @JsonSerialize(using = GeometrySerializer.class)
    private Geometry location;

    private Map<String, Object> properties;

    public DeviceModel() {
    }

    public DeviceModel(String id) {
        super(id);
    }

    public void setDeviceThing(DeviceThing deviceThing) {
        this.deviceThing = deviceThing;
        this.deviceDomain = deviceThing.getDeviceDomain();
        this.deviceType = deviceThing.getDeviceType();
        this.deviceSubtype = deviceThing.getDeviceSubtype();
    }

    @Override
    public DeviceEntity toEntity() {
        DeviceEntity entity = new DeviceEntity();
        BeanUtils.copyNonnullProperties(this, entity);
        RestOptional.ofNullable(this.thingType).ifNotNull(entity::setThingType);
        RestOptional.ofNullable(this.deviceType).ifNotNull(entity::setDeviceType);
        RestOptional.ofNullable(this.deviceSubtype).ifNotNull(entity::setDeviceSubtype);
        RestOptional.ofNullable(this.deviceDomain).ifNotNull(entity::setDeviceDomain);
        RestOptional.ofNullable(this.compatibleState).ifNotNull(entity::setCompatibleState);
        RestOptional.ofNullable(this.boundState).ifNotNull(entity::setBoundState);
        entity.setProperties(PropertyUtils.toPropertiesJson(this.properties));
        return entity;
    }
}
