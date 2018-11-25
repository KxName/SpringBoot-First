package com.fh;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    private   static JedisPool pool=null;


    private static JedisPool  initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMinIdle(100);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        pool = new JedisPool(jedisPoolConfig, SystemContext.IPLNUIX, 6379);
        return pool;
    }

    static {
        initPool();
    }
    private JedisUtil(){

    }
    public  static Jedis getRespuert(){
        return pool.getResource();
    }

}
