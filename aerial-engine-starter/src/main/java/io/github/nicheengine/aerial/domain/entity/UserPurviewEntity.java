package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nicheengine.aerial.domain.model.UserPurviewModel;
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
@RestEntity(value = "arl_user_purview")
@RestExcludes({"updateTime","createTime","logic"})
public class UserPurviewEntity extends DefaultIdEntity<UserPurviewEntity, UserPurviewModel, UserPurviewIndex>  {

    @RestLoadEntity
    private PurviewEntity purviewEntity;

    public UserPurviewEntity() {
    }

    public UserPurviewEntity(UserPurviewIndex id) {
        super(id);
    }

    @Override
    public UserPurviewModel toModel() {
        UserPurviewModel model = new UserPurviewModel();
        BeanUtils.copyNonnullProperties(this, model);
        if (GeneralUtils.isNotEmpty(this.id)) {
            model.setWorkspaceId(this.id.getWorkspaceId());
            model.setUserId(this.id.getUserId());
            model.setPurviewId(this.id.getPurviewId());
        }
        if (GeneralUtils.isNotEmpty(this.purviewEntity)) {
            model.setPurview(this.purviewEntity.toModel());
        }
        return model;
    }
}
