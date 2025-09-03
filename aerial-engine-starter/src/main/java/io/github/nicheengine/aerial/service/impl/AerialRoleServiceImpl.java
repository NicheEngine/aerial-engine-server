package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.RoleEntity;
import io.github.nicheengine.aerial.domain.model.RoleModel;
import io.github.nicheengine.aerial.service.AerialRoleService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.RestInfoService;
import org.springframework.stereotype.Service;

/**
 * <code>AerialRoleServiceImpl</code>
 * <p>The aerial role service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.RestInfoService
 * @see io.github.nicheengine.aerial.service.AerialRoleService
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Service
public class AerialRoleServiceImpl extends RestInfoService<RoleModel, RoleEntity, RestFilter> implements AerialRoleService {

    @Override
    public String queryWhereSql(RestFilter filter) throws RestException {
        return filter.toTimeSql("create_time").toNameSql("name").toQuerySql(this, "logic").toIdSql().addSorts("id").toSql();
    }
}
