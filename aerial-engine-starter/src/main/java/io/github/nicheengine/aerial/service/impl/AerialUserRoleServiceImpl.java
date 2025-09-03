package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.UserRoleEntity;
import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nicheengine.aerial.domain.model.UserRoleModel;
import io.github.nicheengine.aerial.filter.UserRoleFilter;
import io.github.nicheengine.aerial.service.AerialUserRoleService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.DefaultIdService;
import io.github.nichetoolkit.rice.RestInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <code>AerialUserRoleServiceImpl</code>
 * <p>The aerial user role service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.DefaultIdService
 * @see io.github.nicheengine.aerial.service.AerialUserRoleService
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Slf4j
@Service
public class AerialUserRoleServiceImpl extends DefaultIdService<UserRoleModel, UserRoleEntity, UserRoleFilter, UserRoleIndex, String> implements AerialUserRoleService {

    @Override
    public String queryWhereSql(UserRoleFilter filter) throws RestException {
        return filter.toWorkspaceIdSql().toUserIdSql().addSorts("workspace_id", "user_id").toSql();
    }
}
