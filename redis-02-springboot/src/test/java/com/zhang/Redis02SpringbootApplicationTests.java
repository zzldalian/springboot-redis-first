package com.zhang;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {
    
    @Autowired
    RedisTemplate redisTemplate;
    
    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws JsonProcessingException {
        //User user = new User("张志璘", 35);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
       // redisTemplate.opsForValue().set("user",user);
       // System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
