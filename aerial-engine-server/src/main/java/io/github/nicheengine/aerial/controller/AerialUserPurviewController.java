package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.UserPurviewModel;
import io.github.nicheengine.aerial.filter.UserPurviewFilter;
import io.github.nicheengine.aerial.service.AerialUserPurviewService;
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
@CrossOrigin
@RestController
@RestNotelog(loggingKey = "userPurview", notelog ="用户权限")
@RequestMapping("/aerial/v1.0.0/userPurview")
public class AerialUserPurviewController {

    private final AerialUserPurviewService userPurviewService;

    @Autowired
    public AerialUserPurviewController(AerialUserPurviewService userPurviewService) {
        this.userPurviewService = userPurviewService;
    }

    @PostMapping("/save")
    @RestUserlog(loggingType = LoggingType.SAVE, userlog = "用户权限数据创建")
    public RestResult<UserPurviewModel> save(@RequestBody UserPurviewModel userPurviewModel) throws RestException {
        return RestResult.success(userPurviewService.save(userPurviewModel));
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<UserPurviewModel>> queryByFilter(@RequestBody UserPurviewFilter filter) throws RestException {
        RestPage<UserPurviewModel> restPage = userPurviewService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }
}
