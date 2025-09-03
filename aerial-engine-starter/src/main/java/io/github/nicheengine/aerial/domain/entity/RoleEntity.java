package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.model.RoleModel;
import io.github.nicheengine.aerial.domain.model.WorkspaceModel;
import io.github.nichetoolkit.mybatis.column.RestUnionKey;
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
@Entity.Table(value = "arl_role")
@RestEntity(value = "arl_role")
public class RoleEntity extends RestInfoEntity<RoleEntity, RoleModel>  {
    @RestUnionKey
    private String key;
    private Long value;
    private Long complex;

    public RoleEntity() {
    }

    public RoleEntity(String id) {
        super(id);
    }

    @Override
    public RoleModel toModel() {
        RoleModel model = new RoleModel();
        BeanUtils.copyNonnullProperties(this, model);
        return model;
    }
}
