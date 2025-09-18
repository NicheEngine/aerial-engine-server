package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.filter.UserFilter;
import io.github.nicheengine.aerial.service.AerialUserService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.userlog.stereotype.RestNotelog;
import io.github.nichetoolkit.rest.userlog.stereotype.RestUserlog;
import io.github.nichetoolkit.rice.RestPage;
import io.github.nichetoolkit.rice.stereotype.RestSkip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestSkip
@CrossOrigin
@RestController
@RestNotelog(loggingKey = "user", notelog ="用户服务")
@RequestMapping("/user/v1.0.0")
public class AerialUserController {

    private final AerialUserService userService;

    @Autowired
    public AerialUserController(AerialUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @RestUserlog(loggingType = LoggingType.CREATE, userlog = "用户数据创建")
    public RestResult<UserModel> create(@RequestBody UserModel userModel) throws RestException {
        return RestResult.success(userService.create(userModel));
    }

    @PostMapping("/update")
    @RestUserlog(loggingType = LoggingType.UPDATE, userlog = "用户数据更新")
    public RestResult<UserModel> update(@RequestBody UserModel user) throws RestException {
        return RestResult.success(userService.update(user));
    }

    @GetMapping("/query/{id}")
    public RestResult<UserModel> queryById(@PathVariable("id") String id) throws RestException {
        UserModel userModel = userService.queryById(id);
        return RestResult.success(userModel);
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<UserModel>> queryByFilter(@RequestBody UserFilter filter) throws RestException {
        RestPage<UserModel> restPage = userService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }

    @DeleteMapping("/delete/{id}")
    @RestUserlog(loggingType = LoggingType.DELETE_ID, userlog = "用户数据通过编号删除")
    public RestResult<?> deleteById(@PathVariable("id") String id) throws RestException {
        userService.deleteById(id);
        return RestResult.success();
    }

    @PostMapping("/delete/filter")
    @RestUserlog(loggingType = LoggingType.DELETE_FILTER, userlog = "用户数据通过过滤器删除")
    public RestResult<?> deleteByFilter(@RequestBody UserFilter filter) throws RestException {
        userService.deleteAllWithFilter(filter);
        return RestResult.success();
    }
}
