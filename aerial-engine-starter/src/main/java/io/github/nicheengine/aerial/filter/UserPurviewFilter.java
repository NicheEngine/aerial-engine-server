package io.github.nicheengine.aerial.filter;


import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultFilter;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.builder.SqlBuilders;
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
public class UserPurviewFilter extends UserRelevanceFilter<UserPurviewIndex> {
    /* 是否加载基础权限 */
    protected boolean isLoadPurview;

    @Override
    public UserPurviewFilter toWorkspaceIdSql() {
        this.toWorkspaceIdSql("workspace_id");
        return this;
    }

    @Override
    public UserPurviewFilter toWorkspaceIdSql(@NonNull String alias) {
        super.toWorkspaceIdSql(alias);
        return this;
    }

    @Override
    public UserPurviewFilter toUserIdSql() {
        this.toUserIdSql("user_id");
        return this;
    }

    @Override
    public UserPurviewFilter toUserIdSql(@NonNull String alias) {
        super.toUserIdSql(alias);
        return this;
    }

    @Override
    public RestLoad[] toLoadArray() throws RestException {
        this.addLoadArray(RestLoad.of("purviewEntity", this.isLoadPurview));
        return super.toLoadArray();
    }
}
