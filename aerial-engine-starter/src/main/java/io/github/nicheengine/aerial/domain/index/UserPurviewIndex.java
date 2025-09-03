package io.github.nicheengine.aerial.domain.index;

import io.github.nicheengine.aerial.domain.entity.PurviewEntity;
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
public class UserPurviewIndex extends UserRelevance {
    @RestUnionKey
    @RestLoadKey(key = "purviewEntity", type = PurviewEntity.class)
    private String purviewId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserPurviewIndex that = (UserPurviewIndex) o;
        return Objects.equals(purviewId, that.purviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), purviewId);
    }
}
