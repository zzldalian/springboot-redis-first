package com.zhang.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("test01")
public class User extends Model<User> implements Serializable { //使用Redis是，我们的实体类必须系列化，否则容易报错

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    
    @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private String name;
    
    @TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private Integer age;
}
