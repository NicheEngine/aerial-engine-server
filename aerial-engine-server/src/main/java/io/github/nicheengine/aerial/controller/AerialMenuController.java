package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.domain.system.MenuModel;
import io.github.nicheengine.aerial.enums.RoleType;
import io.github.nicheengine.aerial.filter.MenuFilter;
import io.github.nicheengine.aerial.service.AerialMenuService;
import io.github.nicheengine.aerial.stereotype.RestRole;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.userlog.stereotype.RestNotelog;
import io.github.nichetoolkit.rest.userlog.stereotype.RestUserlog;
import io.github.nichetoolkit.rice.RestPage;
import io.github.nichetoolkit.rice.stereotype.RestUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j

@CrossOrigin
@RestController
@RestNotelog(loggingKey = "menu", notelog = "菜单")
@RequestMapping("/menu/v1.0.0")
public class AerialMenuController {

    private final AerialMenuService menuService;

    @Autowired
    public AerialMenuController(AerialMenuService menuService) {
        this.menuService = menuService;
    }

    @RestRole(role = RoleType.SUPER)
    @PostMapping("/save")
    @RestUserlog(loggingType = LoggingType.SAVE, userlog = "菜单数据创建")
    public RestResult<MenuModel> save(@RequestBody MenuModel menuModel) throws RestException {
        return RestResult.success(menuService.save(menuModel));
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<MenuModel>> queryByFilter(@RestUser UserModel localUser, @RequestBody MenuFilter filter) throws RestException {
        List<String> roleKeys = localUser.getRoleKeys();
        filter.setRoles(roleKeys);
        RestPage<MenuModel> restPage = menuService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }
}
