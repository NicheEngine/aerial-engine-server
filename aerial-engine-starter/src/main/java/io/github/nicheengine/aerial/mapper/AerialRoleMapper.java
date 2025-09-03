package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.entity.RoleEntity;
import io.github.nicheengine.aerial.domain.entity.WorkspaceEntity;
import io.github.nichetoolkit.mybatis.MybatisInfoMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AerialRoleMapper extends MybatisInfoMapper<RoleEntity,String> {
}
