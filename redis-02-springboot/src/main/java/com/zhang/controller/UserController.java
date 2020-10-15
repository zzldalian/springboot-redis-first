package com.zhang.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;


@RestController
@RequestMapping("/test")
public class UserController {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Autowired
    private RedisUtil redisUtil;
    
    @Autowired
    private UserService userService;
    

    
    @RequestMapping("/insert")
    public String insertUser(User user) {

        boolean save = userService.save(user);
        if (save){
            return "success";
        }
        return "fail";
    }
    
    @RequestMapping("/select")
    public User queryUser(Integer id){
        User currentUser = (User) redisUtil.get("user"+id);
        
        if (currentUser == null){
            QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
            queryWrapper.eq("id",id);
            currentUser = userService.getOne(queryWrapper);
            redisUtil.set("user" + id,currentUser);
            System.out.println("未从redis缓存取");
            return currentUser;
        }else{
            System.out.println("从redis缓存取");
            return currentUser;
        }
    }
    
    @RequestMapping("/update")
    public String updateUser(User user){

        boolean update = userService.updateById(user);
        redisUtil.del("user"+user.getId());
        if (update){
            return "success";
        }
        return "fail";
    }
    
    @RequestMapping("/flushDb")
    public String flushRedisDB(){

        Jedis jedis = new Jedis("192.168.1.105",6379);

        
        jedis.auth("football");
        String s = jedis.flushAll();
        jedis.flushDB();
        System.out.println(s);
        return s;
    }
}
