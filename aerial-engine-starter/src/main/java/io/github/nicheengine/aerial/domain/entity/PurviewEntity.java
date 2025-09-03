package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.model.PurviewModel;
import io.github.nichetoolkit.mybatis.column.RestLinkKey;
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
@Entity.Table(value = "arl_purview")
@RestEntity(value = "arl_purview")
public class PurviewEntity extends RestInfoEntity<PurviewEntity, PurviewModel>  {
    @RestLinkKey
    private String workspaceId;
    @RestUnionKey
    private String key;
    private Long value;

    public PurviewEntity() {
    }

    public PurviewEntity(String id) {
        super(id);
    }

    @Override
    public PurviewModel toModel() {
        PurviewModel model = new PurviewModel();
        BeanUtils.copyNonnullProperties(this, model);
        return model;
    }
}
