package io.github.nicheengine.aerial.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.nicheengine.aerial.enums.device.DeviceDomain;
import io.github.nicheengine.aerial.enums.device.DeviceThing;
import io.github.nichetoolkit.rest.RestKey;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum PayloadPosition implements RestKey<Integer> {
    FRONT_LEFT(0),

    FRONT_RIGHT(1),

    TOP(2),

    FPV(7),

    UNKNOWN(-1);

    public static final String PAYLOAD_KEY = "payload";
    
    private final Integer position;

    PayloadPosition(Integer position) {
        this.position = position;
    }

    @JsonValue
    @Override
    public Integer getKey() {
        return this.position;
    }

    @JsonCreator
    public static PayloadPosition parseKey(Integer key) {
        PayloadPosition parsedKey = RestKey.parseKey(PayloadPosition.class, key);
        return Optional.ofNullable(parsedKey).orElse(PayloadPosition.UNKNOWN);
    }

    public static Set<String> positionOfModel() {
        Set<String> position = Arrays.stream(PayloadPosition.values()).map(PayloadPosition::getPosition)
                .map(String::valueOf).collect(Collectors.toSet());
        return Arrays.stream(DeviceThing.values()).filter(device -> DeviceDomain.PAYLOAD == device.getDeviceDomain())
                .map(Enum::name).map(name -> name.replace("_CAMERA", ""))
                .flatMap(model -> position.stream().map(p -> model.concat("-").concat(p))).collect(Collectors.toSet());
    }

    public static Set<String> positionOfIndex() {
        Set<String> position = Arrays.stream(PayloadPosition.values()).map(PayloadPosition::getPosition)
                .map(String::valueOf).collect(Collectors.toSet());
        return Arrays.stream(DeviceThing.values()).filter(device -> DeviceDomain.PAYLOAD == device.getDeviceDomain())
                .map(device -> String.format("%d-%d", device.getDeviceType().getType(), device.getDeviceSubtype().getSubtype()))
                .flatMap(index -> position.stream().map(p -> index.concat("-").concat(p))).collect(Collectors.toSet());
    }
}
