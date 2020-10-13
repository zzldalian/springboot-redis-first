package com.zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;



@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable { //使用Redis是，我们的实体类必须系列化，否则容易报错
    
    private String name;
    
    private Integer age;
}
