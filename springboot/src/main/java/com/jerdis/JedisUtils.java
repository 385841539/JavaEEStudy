package com.jerdis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 连接池的链接参数
 */
public class JedisUtils {


    private static JedisPool jedisPool;

    public static Jedis getJedis(){


        return  jedisPool.getResource();

    }

}
