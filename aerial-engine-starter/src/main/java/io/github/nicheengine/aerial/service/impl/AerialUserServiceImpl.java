package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.filter.UserFilter;
import io.github.nicheengine.aerial.service.AerialUserService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestInfoService;
import org.springframework.stereotype.Service;

/**
 * <code>UserServiceImpl</code>
 * <p>The user service class.</p>
 * @see  RestInfoService
 * @see  Service
 * @author Cyan (snow22314@outlook.com)
 * @since Jdk1.8
 */
@Service
public class AerialUserServiceImpl extends RestInfoService<UserModel, UserEntity, UserFilter> implements AerialUserService {

    @Override
    public String queryWhereSql(UserFilter filter) throws RestException {
        return filter.toTimeSql("create_time").toNameSql("name").toQuerySql(this, "logic").toIdSql().addSorts("id").toSql();
    }
}
