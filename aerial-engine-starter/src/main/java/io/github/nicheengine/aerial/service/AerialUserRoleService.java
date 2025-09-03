package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nicheengine.aerial.domain.model.UserRoleModel;
import io.github.nicheengine.aerial.filter.UserRoleFilter;
import io.github.nichetoolkit.rice.service.FilterService;

public interface AerialUserRoleService extends FilterService<UserRoleModel, UserRoleFilter, UserRoleIndex, String> {
}
