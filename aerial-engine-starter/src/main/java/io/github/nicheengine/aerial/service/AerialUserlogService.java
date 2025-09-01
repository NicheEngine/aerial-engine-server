package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.model.UserlogModel;
import io.github.nicheengine.aerial.filter.UserlogFilter;
import io.github.nichetoolkit.rice.service.FilterService;

public interface AerialUserlogService extends FilterService<UserlogModel, UserlogFilter, String, String> {
}
