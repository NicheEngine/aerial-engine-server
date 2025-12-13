package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.AerialDeviceType;
import io.github.nicheengine.aerial.domain.model.DeviceModel;
import io.github.nicheengine.aerial.enums.BoundState;
import io.github.nicheengine.aerial.enums.CompatibleState;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceSubtype;
import io.github.nicheengine.aerial.enums.device.ThingType;
import io.github.nichetoolkit.mybatis.column.RestAlertKey;
import io.github.nichetoolkit.mybatis.column.RestLinkKey;
import io.github.nichetoolkit.mybatis.table.RestEntity;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Setter
@Getter
@SuperBuilder
@RestEntity(value = "arl_device")
public class DeviceEntity extends RestInfoEntity<DeviceEntity, DeviceModel>  {
    @RestLinkKey("workspaceId")
    private String workspaceId;
    @RestLinkKey("userId")
    private String userId;
    private String deviceSn;
    private String deviceName;
    @RestAlertKey
    private Integer thingType;
    @RestAlertKey
    private Integer deviceType;
    @RestAlertKey
    private Integer deviceSubtype;
    @RestAlertKey
    private Integer deviceDomain;
    private String deviceThing;
    private String deviceIndex;
    private String firmwareVersion;
    private String protocolVersion;
    @RestAlertKey
    private Boolean compatibleState;
    private String childSn;
    private Date boundTime;
    @RestAlertKey
    private Boolean boundState;
    private Date lastTime;
    private String iconNormal;
    private String iconSelect;

    private byte[] location;
    private String properties;

    public DeviceEntity() {
    }

    public DeviceEntity(String id) {
        super(id);
    }

    public void setThingType(ThingType thingType) {
        this.thingType = thingType.getKey();
    }

    public void setDeviceType(AerialDeviceType deviceType) {
        this.deviceType = deviceType.getKey();
    }

    public void setDeviceDomain(DeviceDomain deviceDomain) {
        this.deviceDomain = deviceDomain.getKey();
    }

    public void setDeviceSubtype(DeviceSubtype deviceSubtype) {
        this.deviceSubtype = deviceSubtype.getKey();
    }

    public void setCompatibleState(CompatibleState compatibleState) {
        this.compatibleState = compatibleState.getKey();
    }

    public void setBoundState(BoundState boundState) {
        this.boundState = boundState.getKey();
    }

    @Override
    public DeviceModel toModel() {
        DeviceModel model = new DeviceModel();
        BeanUtils.copyNonnullProperties(this, model);
        ThingType thingType = ThingType.parseKey(this.thingType);
        model.setThingType(thingType);
        model.setDeviceType(AerialDeviceType.parseKey(thingType,this.deviceType));
        return model;
    }

}
