package io.github.nicheengine.aerial.domain.link;

import io.github.nicheengine.aerial.domain.entity.PurviewEntity;
import io.github.nicheengine.aerial.domain.entity.RoleEntity;
import io.github.nichetoolkit.mybatis.column.RestLoadParam;
import io.github.nichetoolkit.mybatis.column.RestUnionKey;
import io.github.nichetoolkit.mybatis.table.RestIdentity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@SuperBuilder
@RestIdentity
@NoArgsConstructor
public class UserRelevance implements Serializable {
    @RestUnionKey
    private String userId;
    @RestUnionKey
    private String workspaceId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserRelevance that = (UserRelevance) o;
        return Objects.equals(userId, that.userId) && Objects.equals(workspaceId, that.workspaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, workspaceId);
    }
}
