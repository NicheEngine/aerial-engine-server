package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.entity.UserPurviewEntity;
import io.github.nicheengine.aerial.domain.index.UserPurviewIndex;
import io.github.nichetoolkit.mybatis.*;
import io.github.nichetoolkit.mybatis.natives.MybatisFilterLoadMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AerialUserPurviewMapper extends MybatisIdMapper<UserPurviewEntity, UserPurviewIndex>,
        MybatisFilterLoadMapper<UserPurviewEntity,UserPurviewIndex> {
}
