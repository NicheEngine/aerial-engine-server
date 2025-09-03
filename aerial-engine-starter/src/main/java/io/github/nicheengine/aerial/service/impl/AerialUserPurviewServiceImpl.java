package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.UserPurviewEntity;
import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nicheengine.aerial.domain.model.UserPurviewModel;
import io.github.nicheengine.aerial.filter.UserPurviewFilter;
import io.github.nicheengine.aerial.service.AerialUserPurviewService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.DefaultIdService;
import io.github.nichetoolkit.rice.RestInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <code>AerialUserPurviewServiceImpl</code>
 * <p>The aerial user purview service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.DefaultIdService
 * @see io.github.nicheengine.aerial.service.AerialUserPurviewService
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Slf4j
@Service
public class AerialUserPurviewServiceImpl extends DefaultIdService<UserPurviewModel, UserPurviewEntity, UserPurviewFilter, UserPurviewIndex,String> implements AerialUserPurviewService {

    @Override
    public String queryWhereSql(UserPurviewFilter filter) throws RestException {
        return filter.toWorkspaceIdSql().toUserIdSql().addSorts("workspace_id", "user_id").toSql();
    }
}
