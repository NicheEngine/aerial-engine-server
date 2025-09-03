package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.PurviewEntity;
import io.github.nicheengine.aerial.domain.model.PurviewModel;
import io.github.nicheengine.aerial.filter.PurviewFilter;
import io.github.nicheengine.aerial.service.AerialPurviewService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.RestInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <code>AerialPurviewServiceImpl</code>
 * <p>The aerial purview service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.RestInfoService
 * @see io.github.nicheengine.aerial.service.AerialPurviewService
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Slf4j
@Service
public class AerialPurviewServiceImpl extends RestInfoService<PurviewModel, PurviewEntity, PurviewFilter> implements AerialPurviewService {

    @Override
    public String queryWhereSql(PurviewFilter filter) throws RestException {
        return filter.toWorkspaceIdSql().toTimeSql("create_time").toNameSql("name").toQuerySql(this, "logic").toIdSql().addSorts("id").toSql();
    }
}
