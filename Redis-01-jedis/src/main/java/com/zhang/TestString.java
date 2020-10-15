package com.zhang;

import redis.clients.jedis.Jedis;

public class TestString {

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("192.168.1.105", 6379);
        
        //set,get
        jedis.set("keyName","hello");
        System.out.println(jedis.get("keyName"));
        
        //append
        jedis.append("keyName","world");
        System.out.println(jedis.get("keyName"));
        jedis.flushDB();
        
        //incr,decr
        jedis.set("keyName","1");
        jedis.incr("keyName");
        System.out.println(jedis.get("keyName"));
        jedis.decr("keyName");
        System.out.println(jedis.get("keyName"));
        jedis.flushDB();
        
        //getrange
        jedis.set("keyName","hello,world");
        //全部字符
        System.out.println(jedis.getrange("keyName",0,-1));
        //从第5个字符截取字符到最后
        System.out.println(jedis.getrange("keyName",6,-1));
        //从第1个字符解读到第5个字符
        System.out.println(jedis.getrange("keyName",0,4));
        jedis.flushDB();
        
        //setrange选择字符进行替换
        jedis.set("keyName","hello,zhang");
        System.out.println(jedis.get("keyName"));
        jedis.setrange("keyName",6,"world");
        System.out.println(jedis.get("keyName"));
        jedis.flushDB();
        
        //setex设置过期时间
        jedis.setex("keyName",10,"hello");
        System.out.println(jedis.get("keyName"));
        Thread.sleep(2000);
        System.out.println(jedis.get("keyName"));
        jedis.flushDB();
        
        //setnx如果不存在，再设置，存在不设置
        jedis.set("keyName","hello");
        jedis.setnx("keyName","exist");
        System.out.println(jedis.get("keyName"));
        jedis.setnx("key1","noExist");
        System.out.println(jedis.get("key1"));
        jedis.flushDB();
        
        //mset,mget设置多个值,取多个值
        jedis.mset("key1","one","key2","two","key3","three");
        System.out.println(jedis.mget("key1","key2","key3"));
        jedis.flushDB();
        
        //msetnx
        
        //关闭链接
        jedis.close();
    }
}
