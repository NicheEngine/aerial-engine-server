package io.github.nicheengine.aerial.domain.index;

import io.github.nicheengine.aerial.domain.entity.RoleEntity;
import io.github.nicheengine.aerial.domain.link.UserRelevance;
import io.github.nichetoolkit.mybatis.column.RestLoadKey;
import io.github.nichetoolkit.mybatis.column.RestUnionKey;
import io.github.nichetoolkit.mybatis.table.RestIdentity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Setter
@Getter
@SuperBuilder
@RestIdentity
@NoArgsConstructor
public class UserRoleIndex extends UserRelevance {
    @RestUnionKey
    @RestLoadKey(key = "roleEntity", type = RoleEntity.class)
    private String roleId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserRoleIndex that = (UserRoleIndex) o;
        return Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleId);
    }
}
