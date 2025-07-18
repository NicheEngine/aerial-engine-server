package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoModel;
import io.github.nichetoolkit.rice.RestUserInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel extends RestInfoModel<UserModel, UserEntity> implements RestUserInfo<String> {
    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";

    public static final String LOGIN_USER_ID = "USER_ID_";

    public static final String LOGIN_USER_INFO = "LOGIN_USER_INFO";

    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

//    @Getter
//    @Setter
//    private PurviewType purviewType;

    public UserModel() {
    }

    public UserModel(String id) {
        super(id);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
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
