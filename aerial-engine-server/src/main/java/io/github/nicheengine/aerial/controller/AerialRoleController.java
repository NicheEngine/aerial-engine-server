package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.RoleModel;
import io.github.nicheengine.aerial.service.AerialRoleService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.userlog.stereotype.RestNotelog;
import io.github.nichetoolkit.rest.userlog.stereotype.RestUserlog;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.RestPage;
import io.github.nichetoolkit.rice.stereotype.RestSkip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestSkip
@CrossOrigin
@RestController
@RestNotelog(loggingKey = "role", notelog ="角色")
@RequestMapping("/aerial/v1.0.0/role")
public class AerialRoleController {

    private final AerialRoleService roleService;

    @Autowired
    public AerialRoleController(AerialRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    @RestUserlog(loggingType = LoggingType.CREATE, userlog = "角色数据创建")
    public RestResult<RoleModel> create(@RequestBody RoleModel roleModel) throws RestException {
        return RestResult.success(roleService.create(roleModel));
    }

    @PostMapping("/update")
    @RestUserlog(loggingType = LoggingType.UPDATE, userlog = "角色数据更新")
    public RestResult<RoleModel> update(@RequestBody RoleModel role) throws RestException {
        return RestResult.success(roleService.update(role));
    }

    @GetMapping("/query/{id}")
    public RestResult<RoleModel> queryById(@PathVariable("id") String id) throws RestException {
        RoleModel roleModel = roleService.queryById(id);
        return RestResult.success(roleModel);
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<RoleModel>> queryByFilter(@RequestBody RestFilter filter) throws RestException {
        RestPage<RoleModel> restPage = roleService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }
}
