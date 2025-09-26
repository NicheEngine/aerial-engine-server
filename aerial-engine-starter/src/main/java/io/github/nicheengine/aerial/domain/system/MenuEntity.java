package io.github.nicheengine.aerial.domain.system;

import io.github.nicheengine.aerial.domain.index.MenuIndex;
import io.github.nicheengine.aerial.enums.MenuType;
import io.github.nichetoolkit.mybatis.column.RestLoadEntity;
import io.github.nichetoolkit.mybatis.table.RestEntity;
import io.github.nichetoolkit.mybatis.table.RestExcludes;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultIdEntity;
import io.github.nichetoolkit.rice.helper.PropertyHelper;
import io.mybatis.provider.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter
@SuperBuilder
@Entity.Table(value = "arl_menu")
@RestEntity(value = "arl_menu")
@RestExcludes({"updateTime", "createTime", "logic"})
public class MenuEntity extends DefaultIdEntity<MenuEntity, MenuModel, MenuIndex> {
    private String workspaceId;
    private String path;
    private String role;
    private String parent;
    private String redirect;
    private String component;
    private String type;
    private String meta;

    @RestLoadEntity(recursive = true)
    private List<MenuEntity> children;

    public MenuEntity() {
    }

    public MenuEntity(MenuIndex id) {
        super(id);
    }

    @Override
    public MenuModel toModel() {
        MenuModel model = new MenuModel();
        BeanUtils.copyNonnullProperties(this, model);
        model.setType(MenuType.parseKey(this.type));
        model.setName(this.id.getName());
        if (GeneralUtils.isNotEmpty(this.meta)) {
            Map<String, Object> propertiesMap = PropertyHelper.toPropertiesMap(this.meta);
            model.setMeta(propertiesMap);
        }
        if (GeneralUtils.isNotEmpty(this.children)) {
            List<MenuModel> children = this.children.stream().map(MenuEntity::toModel).collect(Collectors.toList());
            model.setChildren(children);
        }
        return model;
    }
}
