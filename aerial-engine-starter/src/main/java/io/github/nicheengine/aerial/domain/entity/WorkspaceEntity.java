package io.github.nicheengine.aerial.domain.entity;

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
@Entity.Table(value = "arl_workspace")
@RestEntity(value = "arl_workspace")
public class WorkspaceEntity extends RestInfoEntity<WorkspaceEntity, WorkspaceModel>  {
    @RestUnionKey
    private String bindCode;
    private String platform;

    public WorkspaceEntity() {
    }

    public WorkspaceEntity(String id) {
        super(id);
    }

    @Override
    public WorkspaceModel toModel() {
        WorkspaceModel model = new WorkspaceModel();
        BeanUtils.copyNonnullProperties(this, model);
        return model;
    }
}
