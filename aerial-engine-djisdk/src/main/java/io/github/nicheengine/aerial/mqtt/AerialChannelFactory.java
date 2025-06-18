package io.github.nicheengine.aerial.mqtt;

import io.github.nichetoolkit.rest.util.GeneralUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class AerialChannelFactory {

    private static final ConcurrentHashMap<String, AerialChannelFactory> CHANNEL_CACHES = new ConcurrentHashMap<>();

    private static final int UNIT = 1000_000;

    private volatile AerialTopicResponse<?> message;

    private volatile Thread thread;

    private AerialChannelFactory () {
    }

    public static AerialChannelFactory instance(String tid, boolean create) {
        if (!create) {
            return CHANNEL_CACHES.get(tid);
        }
        AerialChannelFactory channelFactory = new AerialChannelFactory();
        CHANNEL_CACHES.put(tid, channelFactory);
        return channelFactory;
    }

    public AerialTopicResponse<?> get(String tid, long timeout) {
        AerialChannelFactory channelFactory = CHANNEL_CACHES.get(tid);
        if (Objects.isNull(channelFactory)) {
            return null;
        }
        channelFactory.thread = Thread.currentThread();
        LockSupport.parkNanos(channelFactory.thread, timeout * UNIT);
        channelFactory.thread = null;
        CHANNEL_CACHES.remove(tid);
        return channelFactory.message;
    }

    public void put(AerialTopicResponse<?> message) {
        AerialChannelFactory channelFactory = CHANNEL_CACHES.get(message.getTid());
        if (GeneralUtils.isNotEmpty(channelFactory)) {
            channelFactory.message = message;
            if (GeneralUtils.isNotEmpty(channelFactory.thread)) {
                LockSupport.unpark(channelFactory.thread);
            }
        }
    }
}
