package io.github.nicheengine.aerial.filter;


import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;

/**
 * <code>UserFilter</code>
 * <p>The user filter class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see RestFilter
 * @see SuperBuilder
 * @since Jdk1.8
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserRoleFilter extends UserRelevanceFilter<UserRoleIndex> {
    /* 是否加载基础权限 */
    protected boolean isLoadRole;

    @Override
    public UserRoleFilter toWorkspaceIdSql() {
        this.toWorkspaceIdSql("workspace_id");
        return this;
    }

    @Override
    public UserRoleFilter toWorkspaceIdSql(@NonNull String alias) {
        super.toWorkspaceIdSql(alias);
        return this;
    }

    @Override
    public UserRoleFilter toUserIdSql() {
        this.toUserIdSql("user_id");
        return this;
    }

    @Override
    public UserRoleFilter toUserIdSql(@NonNull String alias) {
        super.toUserIdSql(alias);
        return this;
    }

    @Override
    public RestLoad[] toLoadArray() throws RestException {
        this.addLoadArray(RestLoad.of("roleEntity", this.isLoadRole));
        return super.toLoadArray();
    }
}
