package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.entity.UserRoleEntity;
import io.github.nicheengine.aerial.domain.index.UserRoleIndex;
import io.github.nichetoolkit.mybatis.MybatisIdMapper;
import io.github.nichetoolkit.mybatis.natives.MybatisFilterLoadMapper;
import io.github.nichetoolkit.mybatis.natives.MybatisFindLoadMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AerialUserRoleMapper extends MybatisIdMapper<UserRoleEntity, UserRoleIndex>,
        MybatisFindLoadMapper<UserRoleEntity,UserRoleIndex>,
        MybatisFilterLoadMapper<UserRoleEntity,UserRoleIndex> {
}
