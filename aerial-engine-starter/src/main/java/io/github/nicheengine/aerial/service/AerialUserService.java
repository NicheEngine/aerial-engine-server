package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.model.UserModel;
import io.github.nicheengine.aerial.filter.UserFilter;
import io.github.nichetoolkit.rice.service.FilterService;
import io.github.nichetoolkit.rice.service.NameService;
import io.github.nichetoolkit.rice.service.SingleService;

public interface AerialUserService extends FilterService<UserModel, UserFilter, String, String>, NameService<UserModel, String, String>, SingleService<UserModel, String, String> {
}
