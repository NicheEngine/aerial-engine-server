package io.github.nicheengine.aerial.stereotype;

import io.github.nicheengine.aerial.enums.RoleType;
import io.github.nichetoolkit.rest.RestException;
import io.github.nichetoolkit.rest.RestOptional;
import io.github.nichetoolkit.rest.stream.RestStream;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;
import java.util.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface RestRole {

    String key() default "";

    String[] keys() default {};

    long value() default 0L;

    long[] values() default {};

    RoleType role() default RoleType.UNKNOWN;

    RoleType[] roles() default {};

    final class Role {

        public static List<String> keys(@NonNull RestRole role) throws RestException {
            Set<String> keySet = new HashSet<>();
            RestOptional.ofEmptyable(role.key()).isNotEmpty(keySet::add);
            RestOptional.ofEmptyable(role.keys()).isNotEmpty(keys -> keySet.addAll(Arrays.asList(keys)));
            RestOptional.ofNullable(role.role()).flatMapOfNull(value -> RestOptional.ofEmptyable(value.getKey())).mapOfEmpty(keySet::add);
            RestOptional.ofNullable(role.roles()).isNotNull(values -> RestStream.stream(values).forEach(value -> RestOptional.ofNullable(value).flatMapOfNull(module -> RestOptional.ofEmptyable(module.getKey())).mapOfEmpty(keySet::add)));
            return new ArrayList<>(keySet);
        }

        public static List<Long> values(@NonNull RestRole role) throws RestException {
            Set<Long> valueSet = new HashSet<>();
            RestOptional.ofEmptyable(role.value()).isNotEmpty(valueSet::add);
            RestOptional.ofEmptyable(role.values()).isNotEmpty(values -> Arrays.stream(values).forEach(valueSet::add));
            RestOptional.ofNullable(role.role()).flatMapOfNull(value -> RestOptional.ofEmptyable(value.getValue())).mapOfEmpty(valueSet::add);
            RestOptional.ofNullable(role.roles()).isNotNull(values -> RestStream.stream(values).forEach(value -> RestOptional.ofNullable(value).flatMapOfNull(module -> RestOptional.ofEmptyable(module.getValue())).mapOfEmpty(valueSet::add)));
            return new ArrayList<>(valueSet);
        }

    }

}
