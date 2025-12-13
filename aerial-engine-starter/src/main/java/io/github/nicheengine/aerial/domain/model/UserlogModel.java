package io.github.nicheengine.aerial.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.nicheengine.aerial.domain.entity.UserlogEntity;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.RestUsernoteModel;
import io.github.nichetoolkit.rice.jsonb.Property;
import io.github.nichetoolkit.rice.jsonb.PropertyUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@SuperBuilder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class UserlogModel  extends RestUsernoteModel<UserlogModel,UserlogEntity> {

    private UserModel user;

    public UserlogModel() {
    }

    public UserlogModel(String id) {
        super(id);
    }

    @Override
    public UserlogEntity toEntity() {
        UserlogEntity entity = new UserlogEntity();
        BeanUtils.copyNonnullProperties(this, entity);
        entity.setLoggingType(Optional.ofNullable(this.loggingType).map(LoggingType::getKey).orElse(null));
        if (GeneralUtils.isNotEmpty(this.targetIds)) {
            List<String> targetIds = getTargetIds();
            List<Property> properties = new ArrayList<>();
            for (int i = 0; i < targetIds.size(); i++) {
                properties.add(new Property(targetIds.get(i), String.valueOf(i)));
            }
            entity.setTargetIds(PropertyUtils.toPropertiesJson(properties));
        }

        return entity;
    }
}
