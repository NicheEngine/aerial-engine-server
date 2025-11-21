package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.model.DeviceModel;
import io.github.nichetoolkit.mybatis.column.RestLinkKey;
import io.github.nichetoolkit.mybatis.table.RestEntity;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoEntity;
import io.mybatis.provider.Entity;
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
    private Integer deviceType;
    private Integer deviceSubtype;
    private Integer deviceDomain;
    private String deviceIndex;
    private String firmwareVersion;
    private String protocolVersion;
    private Integer compatibleStatus;
    private String childSn;
    private Date boundTime;
    private Integer boundStatus;
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

    @Override
    public DeviceModel toModel() {
        DeviceModel model = new DeviceModel();
        BeanUtils.copyNonnullProperties(this, model);
        return model;
    }

}
