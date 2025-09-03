package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.filter.UserFilter;
import io.github.nicheengine.aerial.service.AerialUserService;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestInfoService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <code>AerialUserServiceImpl</code>
 * <p>The aerial user service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.RestInfoService
 * @see io.github.nicheengine.aerial.service.AerialUserService
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Service
public class AerialUserServiceImpl extends RestInfoService<UserModel, UserEntity, UserFilter> implements AerialUserService {

    @Override
    public String queryWhereSql(UserFilter filter) throws RestException {
        return filter.toWorkspaceIdSql().toTimeSql("create_time").toNameSql("name").toQuerySql(this, "logic").toIdSql().addSorts("id").toSql();
    }

    @Override
    public void buildModel(UserEntity entity, UserModel model, RestLoad... isLoadArray) throws RestException {
        super.buildModel(entity, model, isLoadArray);
    }

    @Override
    public void buildModelList(Collection<UserEntity> entityList, List<UserModel> modelList, RestLoad... isLoadArray) throws RestException {
        super.buildModelList(entityList, modelList, isLoadArray);
    }
}
