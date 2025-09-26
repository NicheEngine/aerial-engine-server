package io.github.nicheengine.aerial.mapper;

import io.github.nicheengine.aerial.domain.index.MenuIndex;
import io.github.nicheengine.aerial.domain.system.MenuEntity;
import io.github.nichetoolkit.mybatis.MybatisIdMapper;
import io.github.nichetoolkit.mybatis.natives.MybatisFilterLoadMapper;
import io.github.nichetoolkit.mybatis.natives.MybatisFindLoadMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AerialMenuMapper extends MybatisIdMapper<MenuEntity, MenuIndex>,
        MybatisFindLoadMapper<MenuEntity, MenuIndex>,
        MybatisFilterLoadMapper<MenuEntity, MenuIndex> {
}
