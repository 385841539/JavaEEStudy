package com.jerdis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedieTest {

    @Test
    public void test1(){

        Jedis localhost = new Jedis("localhost", 6379);
        localhost.set("username","43212345678");

        localhost.sadd("wohuo","234");

        localhost.setex("woca",10,"duitou");
        localhost.close();
    }


    /**
     * string 操作
     */
    @Test
    public void test2(){

        Jedis localhost = new Jedis();
//        localhost.set("username","43212345678");

//        localhost.sadd("wohuo","234");




        String username = localhost.get("username");
        System.out.println("username----"+username);
        String woca = localhost.get("woca");

        System.out.println("woca----"+woca);
        localhost.close();
    }


    /**
     * hash的操作
     */
    @Test
    public void test3(){

        Jedis localhost = new Jedis();

//        localhost.hset("user","name","lisi");
//        localhost.hset("user","age","23");
//        localhost.hset("user","gender","male");

        String hget = localhost.hget("user", "name");
        System.out.println("hget---"+hget);

        Map<String, String> user = localhost.hgetAll("user");

        Set<String> strings = user.keySet();
        for (String content:strings) {
            String s = user.get(content);
            System.out.println("key----"+content+"----value---"+s);
        }

        localhost.close();
    }



    /**
     * list的操作
     */
    @Test
    public void test4(){

        Jedis localhost = new Jedis();

        localhost.lpush("mylist2","a","b","c");//从左存
        localhost.rpush("mylist2","aa","bb","cc");//从左存
//        localhost.llpop("mylist2").;
        List<String> mylist2 = localhost.lrange("mylist2", 0, -1);

        localhost.close();
    }

    /**
     * 连接池使用
     */
    @Test
    public void test5(){


        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);



        Jedis resource = jedisPool.getResource();

        resource.set("hh","hhahgfds");

        String hh = resource.get("hh");
        System.out.println("--hh--"+hh);

        resource.close();

    }

}
