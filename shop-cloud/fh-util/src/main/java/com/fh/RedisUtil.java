package com.fh;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static String get(String key) {
        Jedis jedis = null;
        String result = "";
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return  "";
        }finally {
            jedis.close();
            jedis = null;
        }
        return  result;
    }

    public static void set(String key , String value) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getJedis();
            jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            jedis = null;
        }
    }

    public static void expire(String key , int seconds) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getJedis();
            jedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            jedis.close();
            jedis = null;
        }
    }

    public static boolean setNxExpire(String key,String value, int seconds) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getJedis();
            Long flag = jedis.setnx(key, value);
            if (flag == 1) {
                jedis.expire(key, seconds);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if ( null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }

    public static void main(String[] args) {
//        set("try","catch");
        String s = get("aaa");
        System.out.println(s);
    }

    public static Long incrExpire(String key,int seconds) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getJedis();
            Long count = jedis.incr(key);
            if (count == 1) {
                jedis.expire(key, seconds);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if ( null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }
}
