package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nicheengine.aerial.domain.entity.UserlogEntity;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.domain.model.UserlogModel;
import io.github.nicheengine.aerial.filter.UserFilter;
import io.github.nicheengine.aerial.filter.UserlogFilter;
import io.github.nicheengine.aerial.service.AerialUserlogService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestIdService;
import org.springframework.stereotype.Service;

/**
 * <code>AerialUserlogServiceImpl</code>
 * <p>The aerial userlog service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.RestInfoService
 * @see io.github.nicheengine.aerial.service.AerialUserService
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Service
public class AerialUserlogServiceImpl extends RestIdService<UserlogModel, UserlogEntity, UserlogFilter> implements AerialUserlogService {

    @Override
    public String queryWhereSql(UserlogFilter filter) throws RestException {
        return filter.toUserlogSql().toTargetJsonbSql().toUserIdSql()
                .toNameSql("username").toTimeSql("logging_time")
                .toIdSql().addSorts("logging_time").toSql();
    }
}
