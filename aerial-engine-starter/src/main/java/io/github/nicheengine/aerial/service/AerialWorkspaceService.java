package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.model.WorkspaceModel;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.service.FilterService;
import io.github.nichetoolkit.rice.service.NameService;
import io.github.nichetoolkit.rice.service.SingleService;

public interface AerialWorkspaceService extends FilterService<WorkspaceModel, RestFilter, String, String>, NameService<WorkspaceModel, String, String>, SingleService<WorkspaceModel, String, String> {
}
