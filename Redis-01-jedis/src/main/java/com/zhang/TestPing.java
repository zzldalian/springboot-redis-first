package com.zhang;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestPing {

    public static void main(String[] args) {
//        //获得连接池配置对象
//        JedisPoolConfig config = new JedisPoolConfig();
//        //获得最大链接数
//        config.setMaxTotal(30);
//        //获得最小连接数
//        config.setMinIdle(10);
//        //获得链接池
//        JedisPool jp = new JedisPool(config,"192.168.2.118",6379);
//        //获得核心对象
//        Jedis jedis = null;
//        try {
//            //jedis = jp.getResource();
//            jedis.set("qqq","成功了");
//            String value = jedis.get("qqq");
//            System.out.println(value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//            if (jp != null) {
//                jp.close();
//            }
//        }
        Jedis jedis = new Jedis("192.168.2.118", 6379);
        System.out.println(jedis.ping());
        //关闭链接
        jedis.close();
        
    }
}
