package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.domain.entity.PurviewEntity;
import io.github.nicheengine.aerial.domain.entity.RoleEntity;
import io.github.nicheengine.aerial.domain.entity.UserPurviewEntity;
import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nichetoolkit.mybatis.column.RestLoadParam;
import io.github.nichetoolkit.mybatis.column.RestUnionKey;
import io.github.nichetoolkit.rest.RestValue;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultIdModel;
import io.github.nichetoolkit.rice.RestIdModel;
import io.github.nichetoolkit.rice.RestInfoModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"id","operate"}, ignoreUnknown = true)
public class UserPurviewModel extends DefaultIdModel<UserPurviewModel, UserPurviewEntity, UserPurviewIndex> {
    private String workspaceId;
    private String userId;
    private String purviewId;
    private PurviewModel purview;

    public UserPurviewModel() {
    }

    public UserPurviewModel(UserPurviewIndex id) {
        super(id);
    }

    @Override
    public void initialize() {
        UserPurviewIndex.UserPurviewIndexBuilder<?, ?> builder = UserPurviewIndex.builder();
        if (GeneralUtils.isNotEmpty(purviewId)) {
            builder.purviewId(this.purviewId);
        } else if (GeneralUtils.isNotEmpty(this.purview)) {
            builder.purviewId(this.purview.getId());
        }
        builder.workspaceId(this.workspaceId).userId(this.userId);
        this.id = builder.build();
    }

    @Override
    public UserPurviewEntity toEntity() {
        return new UserPurviewEntity(this.id);
    }

}
