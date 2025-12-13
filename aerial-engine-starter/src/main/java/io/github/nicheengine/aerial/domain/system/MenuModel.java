package io.github.nicheengine.aerial.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.nicheengine.aerial.domain.index.MenuIndex;
import io.github.nicheengine.aerial.enums.MenuType;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.DefaultIdModel;
import io.github.nichetoolkit.rice.jsonb.Property;
import io.github.nichetoolkit.rice.jsonb.PropertyUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"id", "operate"}, ignoreUnknown = true)
public class MenuModel extends DefaultIdModel<MenuModel, MenuEntity, MenuIndex> {
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String workspaceId;
    private String path;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String parent;
    private String redirect;
    private String component;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MenuType type;
    private Map<String, Object> meta;

    private List<MenuModel> children;

    public MenuModel() {
    }

    public MenuModel(MenuIndex id) {
        super(id);
    }

    @Override
    public void initialize() {
        MenuIndex.MenuIndexBuilder<?, ?> builder = MenuIndex.builder();
        builder.name(this.name);
        this.id = builder.build();
    }

    @Override
    public MenuEntity toEntity() {
        MenuEntity entity = new MenuEntity();
        BeanUtils.copyNonnullProperties(this, entity);
        entity.setType(Optional.ofNullable(this.type).map(MenuType::getKey).orElse(null));
        if (GeneralUtils.isNotEmpty(this.meta)) {
            List<Property> properties = PropertyUtils.toPropertiesList(this.meta);
            entity.setMeta(PropertyUtils.toPropertiesJson(properties));
        }
        return entity;
    }
}
