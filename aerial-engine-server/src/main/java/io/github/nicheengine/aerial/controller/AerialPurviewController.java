package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.PurviewModel;
import io.github.nicheengine.aerial.filter.PurviewFilter;
import io.github.nicheengine.aerial.service.AerialPurviewService;
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
@RestNotelog(loggingKey = "purview", notelog ="权限")
@RequestMapping("/aerial/v1.0.0/purview")
public class AerialPurviewController {

    private final AerialPurviewService purviewService;

    @Autowired
    public AerialPurviewController(AerialPurviewService purviewService) {
        this.purviewService = purviewService;
    }

    @PostMapping("/create")
    @RestUserlog(loggingType = LoggingType.CREATE, userlog = "权限数据创建")
    public RestResult<PurviewModel> create(@RequestBody PurviewModel purviewModel) throws RestException {
        return RestResult.success(purviewService.create(purviewModel));
    }

    @PostMapping("/update")
    @RestUserlog(loggingType = LoggingType.UPDATE, userlog = "权限数据更新")
    public RestResult<PurviewModel> update(@RequestBody PurviewModel purview) throws RestException {
        return RestResult.success(purviewService.update(purview));
    }

    @GetMapping("/query/{id}")
    public RestResult<PurviewModel> queryById(@PathVariable("id") String id) throws RestException {
        PurviewModel purviewModel = purviewService.queryById(id);
        return RestResult.success(purviewModel);
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<PurviewModel>> queryByFilter(@RequestBody PurviewFilter filter) throws RestException {
        RestPage<PurviewModel> restPage = purviewService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }
}
