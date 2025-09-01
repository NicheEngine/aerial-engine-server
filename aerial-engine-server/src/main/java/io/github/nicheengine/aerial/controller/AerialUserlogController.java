package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.UserlogModel;
import io.github.nicheengine.aerial.filter.UserlogFilter;
import io.github.nicheengine.aerial.service.AerialUserlogService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rice.RestPage;
import io.github.nichetoolkit.rice.stereotype.RestSkip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestSkip
@CrossOrigin
@RestController
@RequestMapping("/aerial/v1.0.0/userlog")
public class AerialUserlogController {

    private final AerialUserlogService userlogService;

    @Autowired
    public AerialUserlogController(AerialUserlogService userlogService) {
        this.userlogService = userlogService;
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<UserlogModel>> queryByFilter(@RequestBody UserlogFilter filter) throws RestException {
        RestPage<UserlogModel> restPage = userlogService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }

}
