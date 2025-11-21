package io.github.nicheengine.aerial.domain.entity;

import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nichetoolkit.mybatis.RestTable;
import io.github.nichetoolkit.mybatis.column.RestLinkKey;
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
@RestEntity(value = "arl_user")
public class UserEntity extends RestInfoEntity<UserEntity, UserModel>  {
    @RestLinkKey
    private String workspaceId;
    private String nickname;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String id) {
        super(id);
    }

    public UserRoleIndex toUserRoleIndex() {
        return UserRoleIndex.builder().workspaceId(this.workspaceId)
                .userId(this.id).build();
    }

    public UserPurviewIndex toUserPurviewIndex() {
        return UserPurviewIndex.builder().workspaceId(this.workspaceId)
                .userId(this.id).build();
    }

    @Override
    public UserModel toModel() {
        UserModel model = new UserModel();
        BeanUtils.copyNonnullProperties(this, model);
        return model;
    }

}
