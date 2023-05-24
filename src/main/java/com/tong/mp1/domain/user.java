package com.tong.mp1.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.tong.mp1.enums.Genderenum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @author ：小童
 * @date 2023-05-07 21:08:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)
public class user extends Model<user> {
    @TableId(type = IdType.ASSIGN_UUID)
    private  String id;
    private  String name;
    private   int age;
    private  String sex;
    @TableField(exist = false)
    private  Integer online;
    private  Integer staus;
    private Genderenum gender;
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String,String> contact;//联系方式
    @TableField(fill = FieldFill.INSERT)
    private Date  createtime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private  Date updatetime;
    @Version
    private  Integer version ;

}
