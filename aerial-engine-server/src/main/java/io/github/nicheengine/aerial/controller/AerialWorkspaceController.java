package io.github.nicheengine.aerial.controller;

import io.github.nicheengine.aerial.domain.model.WorkspaceModel;
import io.github.nicheengine.aerial.service.AerialWorkspaceService;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestResult;
import io.github.nichetoolkit.rest.userlog.stereotype.RestNotelog;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.RestPage;
import io.github.nichetoolkit.rice.stereotype.RestSkip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RestNotelog(loggingKey = "workspace", notelog ="工作空间")
@RequestMapping("/aerial/v1.0.0/workspace")
public class AerialWorkspaceController {

    private final AerialWorkspaceService workspaceService;

    @Autowired
    public AerialWorkspaceController(AerialWorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

//    @PostMapping("/create")
//    @RestWorkspacelog(loggingType = LoggingType.CREATE, workspacelog = "用户数据创建")
//    public RestResult<WorkspaceModel> create(@RequestBody WorkspaceModel workspaceModel) throws RestException {
//        return RestResult.success(workspaceService.create(workspaceModel));
//    }
//
//    @PostMapping("/update")
//    @RestWorkspacelog(loggingType = LoggingType.UPDATE, workspacelog = "用户数据更新")
//    public RestResult<WorkspaceModel> update(@RequestBody WorkspaceModel workspace) throws RestException {
//        return RestResult.success(workspaceService.update(workspace));
//    }

    @GetMapping("/query/{id}")
    public RestResult<WorkspaceModel> queryById(@PathVariable("id") String id) throws RestException {
        WorkspaceModel workspaceModel = workspaceService.queryById(id);
        return RestResult.success(workspaceModel);
    }

    @PostMapping("/query/filter")
    public RestResult<RestPage<WorkspaceModel>> queryByFilter(@RequestBody RestFilter filter) throws RestException {
        RestPage<WorkspaceModel> restPage = workspaceService.queryAllWithFilter(filter);
        return RestResult.success(restPage);
    }
}
