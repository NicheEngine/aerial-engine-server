package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nichetoolkit.mybatis.RestTable;
import io.github.nichetoolkit.mybatis.table.RestEntity;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoEntity;
import io.mybatis.provider.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@Entity.Table(value = "arl_user")
@RestEntity(value = "arl_user")
public class UserEntity extends RestInfoEntity<UserEntity, UserModel>  {
    private String workspaceId;
    private String username;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String id) {
        super(id);
    }

    @Override
    public UserModel toModel() {
        UserModel model = new UserModel();
        BeanUtils.copyNonnullProperties(this, model);
        return model;
    }
}
