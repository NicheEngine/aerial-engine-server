package io.github.nicheengine.aerial.domain.index;

import io.github.nicheengine.aerial.domain.system.MenuEntity;
import io.github.nichetoolkit.mybatis.column.RestLoadKey;
import io.github.nichetoolkit.mybatis.column.RestLoadParam;
import io.github.nichetoolkit.mybatis.column.RestUnionKey;
import io.github.nichetoolkit.mybatis.table.RestIdentity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@SuperBuilder
@RestIdentity
@NoArgsConstructor
public class MenuIndex implements Serializable {
    @RestUnionKey
    @RestLoadParam(param = "parent", keys = "children", types = MenuEntity.class)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuIndex menuIndex = (MenuIndex) o;
        return Objects.equals(name, menuIndex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
