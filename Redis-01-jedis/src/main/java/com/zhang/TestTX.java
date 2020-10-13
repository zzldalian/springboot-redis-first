package com.zhang;


import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {

    public static void main(String[] args) {
        //创建连接
        Jedis jedis = new Jedis("192.168.2.118", 6379);
        System.out.println(jedis.ping());
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","zhang");
        jedis.flushDB(); 
        //开启事务
        Transaction multi = jedis.multi();
        String s = jsonObject.toJSONString();
        
        try {
            multi.set("user1",s);
            multi.set("user2",s);
            int i = 1/0; //代码抛出异常，执行失败。
            //执行事务
            multi.exec();
        } catch (Exception e) {
            //放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
        
    }
}
