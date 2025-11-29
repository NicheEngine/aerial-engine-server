package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.domain.entity.WorkspaceEntity;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoModel;
import io.github.nichetoolkit.rice.jsonb.PropertyUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceModel extends RestInfoModel<WorkspaceModel, WorkspaceEntity> {
    private String bindCode;
    private String platform;
    private Map<String, Object> properties;

    public WorkspaceModel() {
    }

    public WorkspaceModel(String id) {
        super(id);
    }

    @Override
    public WorkspaceEntity toEntity() {
        WorkspaceEntity entity = new WorkspaceEntity();
        BeanUtils.copyNonnullProperties(this, entity);
        entity.setProperties(PropertyUtils.toPropertiesJson(this.properties));
        return entity;
    }
}
