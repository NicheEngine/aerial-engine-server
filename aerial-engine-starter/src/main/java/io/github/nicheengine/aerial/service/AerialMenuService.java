package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.index.MenuIndex;
import io.github.nicheengine.aerial.domain.system.MenuModel;
import io.github.nicheengine.aerial.filter.MenuFilter;
import io.github.nichetoolkit.rice.service.FilterService;

public interface AerialMenuService extends FilterService<MenuModel, MenuFilter, MenuIndex, String> {
}
