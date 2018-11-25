package com.fh;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private RedisPool() {};

    private  static JedisPool pool;

    private  static void initPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(1000);
        poolConfig.setMinIdle(100);
        poolConfig.setMaxIdle(100);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        /*192.168.58.128*/      /*192.168.61.129*/
        pool = new JedisPool(poolConfig,"192.168.1.50",6380);
    }

    static {
        initPool();
    }


    public static Jedis getJedis() {
        return pool.getResource();
    }

}
