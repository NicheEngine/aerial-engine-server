package io.github.nicheengine.aerial.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.nicheengine.aerial.domain.model.UserlogModel;
import io.github.nichetoolkit.mybatis.column.RestLoadEntity;
import io.github.nichetoolkit.mybatis.column.RestLoadKey;
import io.github.nichetoolkit.mybatis.table.RestEntity;
import io.github.nichetoolkit.mybatis.table.RestExcludes;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.util.BeanUtils;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.RestIdEntity;
import io.github.nichetoolkit.rice.jsonb.PropertyUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Map;

/**
 * <p>UserlogEntity</p>
 * @author Cyan (snow22314@outlook.com)
 * @version v1.0.0
 */
@Setter
@Getter
@SuperBuilder
@RestEntity(value = "arl_userlog")
@EqualsAndHashCode(callSuper = true)
@RestExcludes({"updateTime","createTime","logic"})
public class UserlogEntity extends RestIdEntity<UserlogEntity, UserlogModel> {
    @RestLoadKey(key = "userEntity", type = UserEntity.class)
    private String userId;
    private String targetIds;
    private String username;
    private String userAgent;
    private String ipAddress;
    private String requestMethod;
    private String requestParams;
    private String requestUrl;
    private String methodName;
    private String mediaType;
    private Long responseTime;
    private Integer responseStatus;
    private String responseMessage;
    private String notelog;
    private String userlog;
    private Integer loggingKey;
    private String loggingValue;
    private String loggingType;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loggingTime;

    @RestLoadEntity
    private UserEntity userEntity;

    public UserlogEntity() {
    }

    public UserlogEntity(String id) {
        super(id);
    }

    @Override
    public UserlogModel toModel() {
        UserlogModel model = new UserlogModel();
        BeanUtils.copyNonnullProperties(this, model);
        model.setLoggingType(LoggingType.parseKey(this.loggingType));
        if (GeneralUtils.isNotEmpty(this.targetIds)) {
            Map<String, Object> propertiesMap = PropertyUtils.toPropertiesMap(this.targetIds);
            model.setTargetIds(propertiesMap.keySet());
        }
        if (GeneralUtils.isNotEmpty(this.userEntity)) {
            model.setUser(this.userEntity.toModel());
        }
        return model;
    }
}
