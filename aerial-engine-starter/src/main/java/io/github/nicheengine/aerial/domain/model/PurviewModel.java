package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.domain.entity.PurviewEntity;
import io.github.nichetoolkit.rest.RestValue;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rice.RestInfoModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurviewModel extends RestInfoModel<PurviewModel, PurviewEntity> implements RestValue<String,Long> {
    private String workspaceId;
    private String key;
    private Long value;

    public PurviewModel() {
    }

    public PurviewModel(String id) {
        super(id);
    }

    @Override
    public PurviewEntity toEntity() {
        PurviewEntity entity = new PurviewEntity();
        BeanUtils.copyNonnullProperties(this, entity);
        return entity;
    }

    @Override
    public String name() {
        return this.key;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Long getValue() {
        return this.value;
    }
}
