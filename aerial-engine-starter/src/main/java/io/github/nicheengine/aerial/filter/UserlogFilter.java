package io.github.nicheengine.aerial.filter;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.github.nichetoolkit.mybatis.load.RestLoad;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.userlog.LoggingType;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import io.github.nichetoolkit.rice.RestFilter;
import io.github.nichetoolkit.rice.builder.SqlBuilders;
import io.github.nichetoolkit.rice.jsonb.EqualOperation;
import io.github.nichetoolkit.rice.jsonb.EqualRule;
import io.github.nichetoolkit.rice.jsonb.ValueType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;

import java.util.*;

/**
 * <p>UserlogFilter</p>
 * @author Cyan (snow22314@outlook.com)
 * @version v.1.0
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserlogFilter extends RestFilter {
    /** 用户编号过滤模糊查询 */
    protected String userId;
    /** 用户编号集合过滤查询 */
    protected Set<String> userIds;
    /** 操作目标编号过滤模糊查询 */
    protected String targetId;
    /** 操作目标编号集合过滤查询 */
    protected Set<String> targetIds;
    /** 响应状态码模糊查询 */
    protected Integer status;
    /** 日志key过滤查询 */
    protected String loggingKey;
    /** 日志值过滤查询 */
    protected String loggingValue;
    /** 日志类型过滤查询 */
    protected LoggingType loggingType;
    /** 是否加载用户信息 默认false */
    protected boolean isLoadUser;

    public List<String> getUserIds() {
        if (GeneralUtils.isNotEmpty(userIds)) {
            return new ArrayList<>(userIds);
        }
        return null;
    }

    public void setUserIds(String... userIds) {
        this.userIds = Optional.ofNullable(userIds).map(propertyList -> new HashSet<>(Arrays.asList(propertyList))).orElse(null);
    }

    @JsonSetter
    public void setUserIds(Collection<String> userIds) {
        this.userIds = Optional.ofNullable(userIds).map(HashSet::new).orElse(null);
    }

    public void addUserIds(String... userIds) {
        if (GeneralUtils.isEmpty(this.userIds)) {
            this.userIds = Optional.ofNullable(userIds).map(propertyList -> new HashSet<>(Arrays.asList(propertyList))).orElse(null);
        } else {
            Optional.ofNullable(userIds).ifPresent(propertyList -> this.userIds.addAll(Arrays.asList(propertyList)));
        }
    }

    public void addUserIds(Collection<String> userIds) {
        if (GeneralUtils.isEmpty(this.userIds)) {
            this.userIds = Optional.ofNullable(userIds).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(userIds).ifPresent(this.userIds::addAll);
        }
    }

    public List<String> getTargetIds() {
        if (GeneralUtils.isNotEmpty(targetIds)) {
            return new ArrayList<>(targetIds);
        }
        return null;
    }

    public void setTargetIds(String... targetIds) {
        this.targetIds = Optional.ofNullable(targetIds).map(propertyList -> new HashSet<>(Arrays.asList(propertyList))).orElse(null);
    }

    @JsonSetter
    public void setTargetIds(Collection<String> targetIds) {
        this.targetIds = Optional.ofNullable(targetIds).map(HashSet::new).orElse(null);
    }

    public void addTargetIds(String... targetIds) {
        if (GeneralUtils.isEmpty(this.targetIds)) {
            this.targetIds = Optional.ofNullable(targetIds).map(propertyList -> new HashSet<>(Arrays.asList(propertyList))).orElse(null);
        } else {
            Optional.ofNullable(targetIds).ifPresent(propertyList -> this.targetIds.addAll(Arrays.asList(propertyList)));
        }
    }

    public void addTargetIds(Collection<String> targetIds) {
        if (GeneralUtils.isEmpty(this.targetIds)) {
            this.targetIds = Optional.ofNullable(targetIds).map(HashSet::new).orElse(null);
        } else {
            Optional.ofNullable(targetIds).ifPresent(this.targetIds::addAll);
        }
    }

    public UserlogFilter toUserIdSql() {
        this.toUserIdSql("user_id");
        return this;
    }

    public UserlogFilter toUserIdSql(@NonNull String alias) {
        if (GeneralUtils.isNotEmpty(this.userId)) {
            SqlBuilders.equal(SQL_BUILDER, alias, this.userId);
        } else if (GeneralUtils.isNotEmpty(this.userIds)) {
            SqlBuilders.in(SQL_BUILDER, alias, this.userIds);
        }
        return this;
    }

    public UserlogFilter toTargetJsonbSql() throws RestException {
        this.toTargetIdJsonbSql("target_ids");
        return this;
    }

    public UserlogFilter toTargetIdJsonbSql(@NonNull String alias) throws RestException {
        if (GeneralUtils.isNotEmpty(this.targetId)) {
            this.addEquals(new EqualRule(this.targetId, ValueType.STRING,null, EqualOperation.NOT_NULL_OPERATION));
            this.toJsonbSql(alias);
        } else if (GeneralUtils.isNotEmpty(this.targetIds)) {
            for (String targetId : this.targetIds) {
                addEquals(new EqualRule(targetId, ValueType.STRING,null, EqualOperation.NOT_NULL_OPERATION));
            }
            this.toJsonbSql(alias);
        }
        return this;
    }

    public UserlogFilter toUserlogSql() {
        if (GeneralUtils.isNotEmpty(this.status)) {
            SqlBuilders.equal(SQL_BUILDER, "response_status", this.status);
        }
        if (GeneralUtils.isNotEmpty(this.loggingKey)) {
            SqlBuilders.equal(SQL_BUILDER, "logging_key", this.loggingKey);
        }
        if (GeneralUtils.isNotEmpty(this.loggingValue)) {
            SqlBuilders.equal(SQL_BUILDER, "logging_value", this.loggingValue);
        }
        if (GeneralUtils.isNotEmpty(this.loggingType)) {
            SqlBuilders.equal(SQL_BUILDER, "logging_type", this.loggingType);
        }
        return this;
    }

    @Override
    public RestLoad[] toLoadArray() throws RestException {
        this.addLoadArray(RestLoad.of("userEntity",this.isLoadUser));
        return super.toLoadArray();
    }

}
