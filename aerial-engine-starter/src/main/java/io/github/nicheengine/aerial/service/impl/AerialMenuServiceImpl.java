package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.index.MenuIndex;
import io.github.nicheengine.aerial.domain.system.MenuEntity;
import io.github.nicheengine.aerial.domain.system.MenuModel;
import io.github.nicheengine.aerial.filter.MenuFilter;
import io.github.nicheengine.aerial.service.AerialMenuService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rice.DefaultIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <code>AerialMenuServiceImpl</code>
 * <p>The aerial menu service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.DefaultIdService
 * @see io.github.nicheengine.aerial.service.AerialMenuService
 * @see lombok.extern.slf4j.Slf4j
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Slf4j
@Service
public class AerialMenuServiceImpl extends DefaultIdService<MenuModel, MenuEntity, MenuFilter, MenuIndex, String> implements AerialMenuService {

    @Override
    public String queryWhereSql(MenuFilter filter) throws RestException {
        return filter.toChildrenSql().toWorkspaceIdSql().toRoleSql().toNameSql("name").addSorts("workspace_id", "name").toSql();
    }
}
