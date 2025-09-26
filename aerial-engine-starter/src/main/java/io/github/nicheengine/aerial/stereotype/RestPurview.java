package io.github.nicheengine.aerial.stereotype;

import io.github.nicheengine.aerial.enums.PurviewType;
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
public @interface RestPurview {

    String key() default "";

    String[] keys() default {};

    long value() default 0L;

    long[] values() default {};

    PurviewType purview() default PurviewType.UNKNOWN;

    PurviewType[] purviews() default {};

    final class Purview {

        public static List<String> keys(@NonNull RestPurview purview) throws RestException {
            Set<String> keySet = new HashSet<>();
            RestOptional.ofEmptyable(purview.key()).isNotEmpty(keySet::add);
            RestOptional.ofEmptyable(purview.keys()).isNotEmpty(keys -> keySet.addAll(Arrays.asList(keys)));
            RestOptional.ofNullable(purview.purview()).flatMapOfNull(value -> RestOptional.ofEmptyable(value.getKey())).mapOfEmpty(keySet::add);
            RestOptional.ofNullable(purview.purviews()).isNotNull(values -> RestStream.stream(values).forEach(value -> RestOptional.ofNullable(value).flatMapOfNull(module -> RestOptional.ofEmptyable(module.getKey())).mapOfEmpty(keySet::add)));
            return new ArrayList<>(keySet);
        }

        public static List<Long> values(@NonNull RestPurview purview) throws RestException {
            Set<Long> valueSet = new HashSet<>();
            RestOptional.ofEmptyable(purview.value()).isNotEmpty(valueSet::add);
            RestOptional.ofEmptyable(purview.values()).isNotEmpty(values -> Arrays.stream(values).forEach(valueSet::add));
            RestOptional.ofNullable(purview.purview()).flatMapOfNull(value -> RestOptional.ofEmptyable(value.getValue())).mapOfEmpty(valueSet::add);
            RestOptional.ofNullable(purview.purviews()).isNotNull(values -> RestStream.stream(values).forEach(value -> RestOptional.ofNullable(value).flatMapOfNull(module -> RestOptional.ofEmptyable(module.getValue())).mapOfEmpty(valueSet::add)));
            return new ArrayList<>(valueSet);
        }

    }

}
