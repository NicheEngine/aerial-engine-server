package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.domain.entity.UserRoleEntity;
import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultIdModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"id","operate"}, ignoreUnknown = true)
public class UserRoleModel extends DefaultIdModel<UserRoleModel, UserRoleEntity, UserRoleIndex> {
    private String workspaceId;
    private String userId;
    private String roleId;
    private RoleModel role;

    public UserRoleModel() {
    }

    public UserRoleModel(UserRoleIndex id) {
        super(id);
    }

    @Override
    public void initialize() {
        UserRoleIndex.UserRoleIndexBuilder<?, ?> builder = UserRoleIndex.builder();
        if (GeneralUtils.isNotEmpty(roleId)) {
            builder.roleId(this.roleId);
        } else if (GeneralUtils.isNotEmpty(this.role)) {
            builder.roleId(this.role.getId());
        }
        builder.workspaceId(this.workspaceId).userId(this.userId);
        this.id = builder.build();
    }

    @Override
    public UserRoleEntity toEntity() {
        return new UserRoleEntity(this.id);
    }

}
