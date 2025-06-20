package io.github.nicheengine.aerial.mqtt;

import io.github.nichetoolkit.rest.util.GeneralUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class MqttChannelFactory {

    private static final ConcurrentHashMap<String, MqttChannelFactory> CHANNEL_CACHES = new ConcurrentHashMap<>();

    private static final int UNIT = 1000_000;

    private volatile MqttMessage<?> message;

    private volatile Thread thread;

    private MqttChannelFactory() {
    }

    public static MqttChannelFactory instance(String tid, boolean create) {
        if (!create) {
            return CHANNEL_CACHES.get(tid);
        }
        MqttChannelFactory channelFactory = new MqttChannelFactory();
        CHANNEL_CACHES.put(tid, channelFactory);
        return channelFactory;
    }

    public MqttMessage<?> get(String tid, long timeout) {
        MqttChannelFactory channelFactory = CHANNEL_CACHES.get(tid);
        if (Objects.isNull(channelFactory)) {
            return null;
        }
        channelFactory.thread = Thread.currentThread();
        LockSupport.parkNanos(channelFactory.thread, timeout * UNIT);
        channelFactory.thread = null;
        CHANNEL_CACHES.remove(tid);
        return channelFactory.message;
    }

    public void put(MqttMessage<?> message) {
        MqttChannelFactory channelFactory = CHANNEL_CACHES.get(message.getTid());
        if (GeneralUtils.isNotEmpty(channelFactory)) {
            channelFactory.message = message;
            if (GeneralUtils.isNotEmpty(channelFactory.thread)) {
                LockSupport.unpark(channelFactory.thread);
            }
        }
    }
}
