package com.zhang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    
    @Autowired
    UserService userService;

    @org.junit.Test
    public void query(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        int id = 2;
        queryWrapper.eq("id", id);
        User one = userService.getOne(queryWrapper);
        System.out.println(one);
    }
}
