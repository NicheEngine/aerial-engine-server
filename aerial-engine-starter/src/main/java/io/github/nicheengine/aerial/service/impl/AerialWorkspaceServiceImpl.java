package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.WorkspaceEntity;
import io.github.nicheengine.aerial.domain.model.WorkspaceModel;
import io.github.nicheengine.aerial.service.AerialWorkspaceService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.RestInfoService;
import org.springframework.stereotype.Service;

/**
 * <code>AerialWorkspaceServiceImpl</code>
 * <p>The aerial workspace service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.RestInfoService
 * @see io.github.nicheengine.aerial.service.AerialWorkspaceService
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Service
public class AerialWorkspaceServiceImpl extends RestInfoService<WorkspaceModel, WorkspaceEntity, RestFilter> implements AerialWorkspaceService {

    @Override
    public String queryWhereSql(RestFilter filter) throws RestException {
        return filter.toTimeSql("create_time").toNameSql("name").toQuerySql(this, "logic").toIdSql().addSorts("id").toSql();
    }
}
