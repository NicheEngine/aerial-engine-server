package io.github.nicheengine.aerial.filter;


import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
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
 * @see io.github.nichetoolkit.rice.RestFilter
 * @see lombok.experimental.SuperBuilder
 * @since Jdk1.8
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserFilter extends RestFilter {
    /* 工作空间查询 */
    private String workspaceId;
    /* 是否加载基础权限 */
    private boolean isLoadSuper;

    private boolean isLoadBase = true;

    private boolean isLoadDetail;

    public UserFilter toWorkspaceIdSql() {
        this.toWorkspaceIdSql("workspace_id");
        return this;
    }

    public UserFilter toWorkspaceIdSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.workspaceId)) {
            if (isLoadSuper) {
                SqlBuilders.equalOrNull(SQL_BUILDER, alias, this.workspaceId);
            } else {
                SqlBuilders.equal(SQL_BUILDER, alias, this.workspaceId);
            }
        }
        return this;
    }

    @Override
    public RestLoad[] toLoadArray() throws RestException {
        this.addLoadArray(RestLoad.of("loadBase",this.isLoadBase),RestLoad.of("loadDetail",this.isLoadDetail));
        return super.toLoadArray();
    }
}
