package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.entity.UserlogEntity;
import io.github.nichetoolkit.mybatis.MybatisIdMapper;
import io.github.nichetoolkit.mybatis.natives.MybatisFilterLoadMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AerialUserlogMapper extends MybatisIdMapper<UserlogEntity,String>,
        MybatisFilterLoadMapper<UserlogEntity,String> {
}
