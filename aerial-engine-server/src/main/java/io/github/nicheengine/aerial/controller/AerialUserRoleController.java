package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.UserRoleModel;
import io.github.nicheengine.aerial.filter.UserRoleFilter;
import io.github.nicheengine.aerial.service.AerialUserRoleService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.userlog.stereotype.RestNotelog;
import io.github.nichetoolkit.rest.userlog.stereotype.RestUserlog;
import io.github.nichetoolkit.rice.RestPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RestNotelog(loggingKey = "userRole", notelog ="用户角色")
@RequestMapping("/aerial/v1.0.0/userRole")
public class AerialUserRoleController {

    private final AerialUserRoleService userRoleService;

    @Autowired
    public AerialUserRoleController(AerialUserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/save")
    @RestUserlog(loggingType = LoggingType.SAVE, userlog = "用户角色数据创建")
    public RestResult<UserRoleModel> save(@RequestBody UserRoleModel userRoleModel) throws RestException {
        return RestResult.success(userRoleService.save(userRoleModel));
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<UserRoleModel>> queryByFilter(@RequestBody UserRoleFilter filter) throws RestException {
        RestPage<UserRoleModel> restPage = userRoleService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }
}
