package io.github.nicheengine.aerial.filter;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
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

import java.util.*;

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
    @JsonIgnore
    protected Set<String> roles;
    /* 是否加载基础路由 */
    protected boolean isLoadBase;
    /* 是否加载子路由 */
    protected boolean isLoadChildren;

    public List<String> getRoles() {
        if (GeneralUtils.isNotEmpty(roles)) {
            return new ArrayList<>(roles);
        }
        return null;
    }

    public void setRoles(String... roles) {
        this.roles = Optional.ofNullable(roles).map(propertyList -> new HashSet<>(Arrays.asList(propertyList))).orElse(null);
    }

    @JsonSetter
    public void setRoles(Collection<String> roles) {
        this.roles = Optional.ofNullable(roles).map(HashSet::new).orElse(null);
    }

    public void addRoles(String... roles) {
        if (GeneralUtils.isEmpty(this.roles)) {
            this.roles = Optional.ofNullable(roles).map(propertyList -> new HashSet<>(Arrays.asList(propertyList))).orElse(null);
        } else {
            Optional.ofNullable(roles).ifPresent(propertyList -> this.roles.addAll(Arrays.asList(propertyList)));
        }
    }

    public void addRoles(Collection<String> roles) {
        if (GeneralUtils.isEmpty(this.roles)) {
            this.roles = Optional.ofNullable(roles).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(roles).ifPresent(this.roles::addAll);
        }
    }

    public MenuFilter toRoleSql() {
        this.toRoleSql("role");
        return this;
    }

    public MenuFilter toRoleSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.roles)) {
            if (isLoadBase) {
                SqlBuilders.inOrNull(SQL_BUILDER, alias, this.roles);
            } else {
                SqlBuilders.in(SQL_BUILDER, alias, this.roles);
            }
        }
        return this;
    }

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

    @Override
    public RestLoad[] toLoadArray() throws RestException {
        this.addLoadArray(RestLoad.of("children", this.isLoadChildren));
        return super.toLoadArray();
    }
}
