package io.github.nicheengine.aerial.filter;


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
public class UserRelevanceFilter<I> extends DefaultFilter<I,String> {
    /* 工作空间查询 */
    protected String workspaceId;
    /* 工作空间查询 */
    protected String userId;


    public UserRelevanceFilter<?> toWorkspaceIdSql() {
        this.toWorkspaceIdSql("workspace_id");
        return this;
    }

    public UserRelevanceFilter<?> toWorkspaceIdSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.workspaceId)) {
            SqlBuilders.equal(SQL_BUILDER, alias, this.workspaceId);
        }
        return this;
    }

    public UserRelevanceFilter<?> toUserIdSql() {
        this.toUserIdSql("user_id");
        return this;
    }

    public UserRelevanceFilter<?> toUserIdSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.userId)) {
            SqlBuilders.equal(SQL_BUILDER, alias, this.userId);
        }
        return this;
    }
}
