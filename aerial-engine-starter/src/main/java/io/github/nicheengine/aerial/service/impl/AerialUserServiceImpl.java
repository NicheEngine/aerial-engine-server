package io.github.nicheengine.aerial.service.impl;

import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nicheengine.aerial.domain.model.*;
import io.github.nicheengine.aerial.filter.UserFilter;
import io.github.nicheengine.aerial.service.AerialUserPurviewService;
import io.github.nicheengine.aerial.service.AerialUserRoleService;
import io.github.nicheengine.aerial.service.AerialUserService;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.IdModel;
import io.github.nichetoolkit.rice.RestId;
import io.github.nichetoolkit.rice.RestInfoService;
import io.github.nichetoolkit.rice.helper.MEBuilderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <code>AerialUserServiceImpl</code>
 * <p>The aerial user service class.</p>
 * @author Cyan (snow22314@outlook.com)
 * @see io.github.nichetoolkit.rice.RestInfoService
 * @see io.github.nicheengine.aerial.service.AerialUserService
 * @see org.springframework.stereotype.Service
 * @since Jdk1.8
 */
@Service
public class AerialUserServiceImpl extends RestInfoService<UserModel, UserEntity, UserFilter> implements AerialUserService {
    private final AerialUserRoleService userRoleService;
    private final AerialUserPurviewService userPurviewService;

    public AerialUserServiceImpl(AerialUserRoleService userRoleService, AerialUserPurviewService userPurviewService) {
        this.userRoleService = userRoleService;
        this.userPurviewService = userPurviewService;
    }

    @Override
    public String queryWhereSql(UserFilter filter) throws RestException {
        return filter.toWorkspaceIdSql().toTimeSql("create_time").toNameSql("name").toQuerySql(this, "logic").toIdSql().addSorts("id").toSql();
    }

    @Override
    public void buildModelList(Collection<UserEntity> entityList, List<UserModel> modelList, RestLoad... isLoadArray) throws RestException {
        if (GeneralUtils.isEmpty(modelList) || (isLoadArray.length > 0 && isLoadArray[0].getValue())) {
            return;
        }
        MEBuilderHelper.buildMultiIndexId(entityList, modelList,
                (indies) -> userRoleService.queryAll(indies, RestLoad.of("roleEntity")),
                UserEntity::toUserRoleIndex, UserRoleModel::getUserId, RestId::getId,
                (userModel, userRoles) -> {
                    if (isLoadArray.length > 1 && isLoadArray[1].getValue()) {
                        List<RoleModel> roleModels = userRoles.stream().map(UserRoleModel::getRole).collect(Collectors.toList());
                        userModel.setRoles(roleModels);
                    } else {
                        List<String> roleKeys = new ArrayList<>();
                        long roleValue = 0L;
                        for (UserRoleModel userRoleModel : userRoles) {
                            RoleModel role = userRoleModel.getRole();
                            if (GeneralUtils.isNotEmpty(role)) {
                                roleValue = roleValue | role.getComplex();
                                roleKeys.add(role.getKey());
                            }
                        }
                        userModel.setRoleKeys(roleKeys);
                        userModel.setRoleValue(roleValue);
                    }
                });
        MEBuilderHelper.buildMultiIndexId(entityList, modelList,
                (indies) -> userPurviewService.queryAll(indies, RestLoad.of("purviewEntity")),
                UserEntity::toUserPurviewIndex, UserPurviewModel::getUserId, RestId::getId,
                (userModel, userPurviews) -> {
                    if (isLoadArray.length > 1 && isLoadArray[1].getValue()) {
                        List<PurviewModel> purviewModels = userPurviews.stream().map(UserPurviewModel::getPurview).collect(Collectors.toList());
                        userModel.setPurviews(purviewModels);
                    } else {
                        List<String> purviewKeys = new ArrayList<>();
                        long purviewValue = 0L;
                        for (UserPurviewModel userPurviewModel : userPurviews) {
                            PurviewModel purview = userPurviewModel.getPurview();
                            if (GeneralUtils.isNotEmpty(purview)) {
                                purviewValue = purviewValue | purview.getValue();
                                purviewKeys.add(purview.getKey());
                            }
                        }
                        userModel.setPurviewKeys(purviewKeys);
                        userModel.setPurviewValue(purviewValue);
                    }
                });
    }
}
