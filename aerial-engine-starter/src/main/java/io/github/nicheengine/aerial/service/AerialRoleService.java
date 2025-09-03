package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.model.RoleModel;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.service.FilterService;
import io.github.nichetoolkit.rice.service.NameService;
import io.github.nichetoolkit.rice.service.SingleService;

public interface AerialRoleService extends FilterService<RoleModel, RestFilter, String, String>, NameService<RoleModel, String, String>, SingleService<RoleModel, String, String> {
}
