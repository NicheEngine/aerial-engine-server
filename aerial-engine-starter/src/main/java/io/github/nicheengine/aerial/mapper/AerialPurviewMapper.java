package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.entity.PurviewEntity;
import io.github.nichetoolkit.mybatis.MybatisInfoMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AerialPurviewMapper extends MybatisInfoMapper<PurviewEntity,String> {
}
