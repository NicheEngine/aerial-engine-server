package io.github.nicheengine.aerial.filter;


import io.github.nicheengine.aerial.domain.index.MenuIndex;
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
public class MenuFilter extends DefaultFilter<MenuIndex,String> {
    /* 工作空间查询 */
    protected String workspaceId;
    /* 工作空间查询 */
    protected String role;
    /* 是否加载基础路由 */
    protected boolean isLoadBase;
    /* 是否加载子路由 */
    protected boolean isLoadChildren;

    public MenuFilter toChildrenSql() {
        this.toChildrenSql("parent");
        return this;
    }

    public MenuFilter toChildrenSql(@NonNull String alias){
        if (isLoadChildren) {
            SqlBuilders.isnull(SQL_BUILDER, alias);
        }
        return this;
    }

    public MenuFilter toWorkspaceIdSql() {
        this.toWorkspaceIdSql("workspace_id");
        return this;
    }

    public MenuFilter toWorkspaceIdSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.workspaceId)) {
            if (isLoadBase) {
                SqlBuilders.equalOrNull(SQL_BUILDER, alias, this.workspaceId);
            } else {
                SqlBuilders.equal(SQL_BUILDER, alias, this.workspaceId);
            }
        }
        return this;
    }

    public MenuFilter toRoleSql() {
        this.toWorkspaceIdSql("role");
        return this;
    }

    public MenuFilter toRoleSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.role)) {
            if (isLoadBase) {
                SqlBuilders.equalOrNull(SQL_BUILDER, alias, this.role);
            } else {
                SqlBuilders.equal(SQL_BUILDER, alias, this.role);
            }
        }
        return this;
    }

    @Override
    public RestLoad[] toLoadArray() throws RestException {
        this.addLoadArray(RestLoad.of("children", this.isLoadChildren));
        return super.toLoadArray();
    }
}
