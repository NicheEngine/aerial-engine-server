package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.index.MenuIndex;
import io.github.nicheengine.aerial.domain.system.MenuEntity;
import io.github.nicheengine.aerial.domain.system.MenuModel;
import io.github.nicheengine.aerial.filter.MenuFilter;
import io.github.nicheengine.aerial.service.AerialMenuService;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void buildModel(MenuEntity entity, MenuModel model, RestLoad... isLoadArray) throws RestException {
        if (GeneralUtils.isNotEmpty(model)) {
            MenuFilter menuFilter = queryFilterCache.get();
            List<String> roles = menuFilter.getRoles();
            recursiveModels(model, model.getChildren(), roles);
        }
    }

    private void recursiveModels(MenuModel model, List<MenuModel> children, List<String> roles) {
        if (GeneralUtils.isNotEmpty(children)) {
            List<MenuModel> models = new ArrayList<>();
            for (MenuModel child : children) {
                if (GeneralUtils.isNotEmpty(child)) {
                    String role = child.getRole();
                    if (GeneralUtils.isEmpty(role) || roles.contains(role)) {
                        models.add(child);
                        recursiveModels(child, child.getChildren(), roles);
                    }
                }
            }
            model.setChildren(models);
        }

    }
}
