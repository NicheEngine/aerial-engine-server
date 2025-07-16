package io.github.nicheengine.aerial.manager;

import io.github.nicheengine.aerial.enums.method.DrcUpMethod;
import io.github.nicheengine.aerial.mqtt.drc.DrcTopicRequest;
import io.github.nichetoolkit.rest.util.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisManager {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisManager.redisTemplate = redisTemplate;
    }

    public static void setOfHash(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public static Object getOfHash(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    public static Set<String> keysOfHash(String key) {
        return redisTemplate.<String, Object>opsForHash().keys(key);
    }

    public static boolean existOfHash(String key, String field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    public static boolean deleteOfHash(String key, Object[] fields) {
        return redisTemplate.opsForHash().delete(key, fields) > 0;
    }

    public static long sizeOfHash(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public static boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public static void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    public static long expire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public static boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    public static boolean delete(String key) {
        return RedisManager.exist(key) && redisTemplate.delete(key);
    }

    public static Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public static void set(String key, Object... values) {
        if (GeneralUtils.isNotEmpty(values)) {
            Arrays.stream(values).forEach(value -> redisTemplate.opsForList().rightPush(key, value));
        }
    }

    public static void set(String key, Collection<Object> values) {
        if (GeneralUtils.isNotEmpty(values)) {
            values.forEach(value -> redisTemplate.opsForList().rightPush(key, value));
        }
    }

    public static List<Object> all(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    public static List<Object> all(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public static Long size(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public static Boolean add(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public static Boolean remove(String key, Object... value) {
        Long remove = redisTemplate.opsForZSet().remove(key, value);
        return GeneralUtils.isNotEmpty(remove) && remove > 0;
    }

    public static Set<Object> range(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    public static Object min(String key) {
        Set<Object> objects = range(key, 0, 0);
        if (CollectionUtils.isEmpty(objects)) {
            return null;
        }
        return objects.iterator().next();
    }

    public static Double score(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    public static Double increment(String key, Object value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }
}
