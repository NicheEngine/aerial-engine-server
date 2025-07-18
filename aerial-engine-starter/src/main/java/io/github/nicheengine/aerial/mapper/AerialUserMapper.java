package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.entity.UserEntity;
import io.github.nichetoolkit.mybatis.MybatisInfoMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AerialUserMapper extends MybatisInfoMapper<UserEntity,String> {
}
