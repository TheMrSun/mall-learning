package com.macro.mall.tiny.service;

/**
 * redis操作Service
 * 对象和数组以json形式进行存储
 *
 * @author Slience
 * @version 1.0
 */
public interface RedisService {
    /**
     * 存储数据
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 获取值
     *
     * @param key key
     * @return value
     */
    String get(String key);

    /**
     * 设置过期时间
     *
     * @param key   key
     * @param expire 时间
     * @return 是否过期
     */
    boolean expire(String key, Long expire);

    /**
     * 删除数据
     *
     * @param key key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key, Long delta);
}
