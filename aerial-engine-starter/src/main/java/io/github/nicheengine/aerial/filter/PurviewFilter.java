package io.github.nicheengine.aerial.filter;


import io.github.nichetoolkit.rest.util.GeneralUtils;
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
public class PurviewFilter extends RestFilter {
    /* 工作空间查询 */
    private String workspaceId;
    /* 是否加载基础权限 */
    protected boolean isLoadBase;

    public PurviewFilter toWorkspaceIdSql() {
        this.toWorkspaceIdSql("workspace_id");
        return this;
    }

    public PurviewFilter toWorkspaceIdSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.workspaceId)) {
            if (isLoadBase) {
                SqlBuilders.equalOrNull(SQL_BUILDER, alias, this.workspaceId);
            } else {
                SqlBuilders.equal(SQL_BUILDER, alias, this.workspaceId);
            }
        }
        return this;
    }
}
