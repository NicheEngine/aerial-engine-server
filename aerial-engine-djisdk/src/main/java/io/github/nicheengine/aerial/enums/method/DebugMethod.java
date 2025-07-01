package io.github.nicheengine.aerial.enums.method;

import io.github.nicheengine.aerial.AerialDjisdkModel;
import io.github.nicheengine.aerial.model.debug.*;
import io.github.nichetoolkit.rest.RestValue;
import lombok.Getter;

@Getter
public enum DebugMethod implements RestValue<String,Class<? extends AerialDjisdkModel>> {

    DEBUG_MODE_OPEN("debug_mode_open", null),

    DEBUG_MODE_CLOSE("debug_mode_close", null),

    SUPPLEMENT_LIGHT_OPEN("supplement_light_open", null),

    SUPPLEMENT_LIGHT_CLOSE("supplement_light_close", null),

    DEVICE_REBOOT("device_reboot", null),

    DRONE_OPEN("drone_open", null),

    DRONE_CLOSE("drone_close", null),

    DRONE_FORMAT("drone_format", null),

    DEVICE_FORMAT("device_format", null),

    COVER_OPEN("cover_open", null),

    COVER_CLOSE("cover_close", null),

    PUTTER_OPEN("putter_open", null),

    PUTTER_CLOSE("putter_close", null),

    CHARGE_OPEN("charge_open", null),

    CHARGE_CLOSE("charge_close", null),

    BATTERY_MAINTENANCE_SWITCH("battery_maintenance_switch", BatteryMaintenanceSwitchRequest.class),

    ALARM_STATE_SWITCH("alarm_state_switch", AlarmStateSwitchRequest.class),

    BATTERY_STORE_MODE_SWITCH("battery_store_mode_switch", BatteryStoreModeSwitchRequest.class),

    SDR_WORKMODE_SWITCH("sdr_workmode_switch", SdrWorkmodeSwitchRequest.class),

    AIR_CONDITIONER_MODE_SWITCH("air_conditioner_mode_switch", AirConditionerModeSwitchRequest.class),

    ESIM_ACTIVATE("esim_activate", EsimActivateRequest.class),

    SIM_SLOT_SWITCH("sim_slot_switch", SimSlotSwitchRequest.class),

    ESIM_OPERATOR_SWITCH("esim_operator_switch", EsimOperatorSwitchRequest.class),

    UNKNOWN("",AerialDjisdkModel.class),

    ;

    private final String method;

    private final Class<? extends AerialDjisdkModel> type;

    DebugMethod(String method, Class<? extends AerialDjisdkModel> type) {
        this.method = method;
        this.type = type;
    }
    
    @Override
    public Class<? extends AerialDjisdkModel> getValue() {
        return this.type;
    }

    @Override
    public String getKey() {
        return this.method;
    }
}
