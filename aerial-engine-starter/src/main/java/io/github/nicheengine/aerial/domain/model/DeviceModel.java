package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.nicheengine.aerial.domain.entity.DeviceEntity;
import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoModel;
import io.github.nichetoolkit.rice.RestUserInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceModel extends RestInfoModel<DeviceModel, DeviceEntity> implements RestUserInfo<String> {
    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";

    public static final String LOGIN_USER_ID = "USER_ID_";

    public static final String LOGIN_USER_INFO = "LOGIN_USER_INFO";

    private String workspaceId;
    private String nickname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private List<RoleModel> roles;

    private List<PurviewModel> purviews;

    private List<String> roleKeys;

    private List<String> purviewKeys;

    private Long roleValue;

    private Long purviewValue;

    public DeviceModel() {
    }

    public DeviceModel(String id) {
        super(id);
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public void setUsername(String username) {
        this.name = username;
    }

    @JsonIgnore
    public String password() {
        return password;
    }

    @Override
    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        BeanUtils.copyNonnullProperties(this, entity);
        return entity;
    }
}
