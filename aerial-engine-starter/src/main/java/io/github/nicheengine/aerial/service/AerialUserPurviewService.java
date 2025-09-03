package io.github.nicheengine.aerial.service;

import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nicheengine.aerial.domain.model.PurviewModel;
import io.github.nicheengine.aerial.domain.model.UserPurviewModel;
import io.github.nicheengine.aerial.filter.PurviewFilter;
import io.github.nicheengine.aerial.filter.UserPurviewFilter;
import io.github.nichetoolkit.rice.service.FilterService;
import io.github.nichetoolkit.rice.service.NameService;
import io.github.nichetoolkit.rice.service.SingleService;

public interface AerialUserPurviewService extends FilterService<UserPurviewModel, UserPurviewFilter, UserPurviewIndex, String> {
}
