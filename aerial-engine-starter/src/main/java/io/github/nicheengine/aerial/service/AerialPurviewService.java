package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.model.PurviewModel;
import io.github.nicheengine.aerial.filter.PurviewFilter;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.service.FilterService;
import io.github.nichetoolkit.rice.service.NameService;
import io.github.nichetoolkit.rice.service.SingleService;

public interface AerialPurviewService extends FilterService<PurviewModel, PurviewFilter, String, String>, NameService<PurviewModel, String, String>, SingleService<PurviewModel, String, String> {
}
