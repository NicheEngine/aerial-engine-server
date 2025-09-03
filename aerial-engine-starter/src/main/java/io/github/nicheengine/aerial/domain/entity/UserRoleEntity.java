package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nicheengine.aerial.domain.model.UserRoleModel;
import io.github.nichetoolkit.mybatis.column.RestLoadEntity;
import io.github.nichetoolkit.mybatis.table.RestEntity;
import io.github.nichetoolkit.mybatis.table.RestExcludes;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultIdEntity;
import io.mybatis.provider.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@Entity.Table(value = "arl_user_role")
@RestEntity(value = "arl_user_role")
@RestExcludes({"updateTime","createTime","logic"})
public class UserRoleEntity extends DefaultIdEntity<UserRoleEntity, UserRoleModel, UserRoleIndex>  {

    @RestLoadEntity
    private RoleEntity roleEntity;

    public UserRoleEntity() {
    }

    public UserRoleEntity(UserRoleIndex id) {
        super(id);
    }

    @Override
    public UserRoleModel toModel() {
        UserRoleModel model = new UserRoleModel();
        BeanUtils.copyNonnullProperties(this, model);
        if (GeneralUtils.isNotEmpty(this.id)) {
            model.setWorkspaceId(this.id.getWorkspaceId());
            model.setUserId(this.id.getUserId());
            model.setRoleId(this.id.getRoleId());
        }
        if (GeneralUtils.isNotEmpty(this.roleEntity)) {
            model.setRole(this.roleEntity.toModel());
        }
        return model;
    }
}
