package com.tong.mp1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tong.mp1.domain.user;
import com.tong.mp1.enums.Genderenum;
import com.tong.mp1.mapper.usermapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：小童
 * @date 2023-05-10 17:00:56
 */
@SpringBootTest
public class logic {
    @Autowired
    private usermapper usermapper;
    @Test
 void logic(){
        /**
         * 逻辑删除
         */
        usermapper.deleteById("13");

 }
 @Test
  void   select(){
     LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
     List<user> users = usermapper.selectList(lambdaQueryWrapper);
     System.out.println(users);
 }
 @Test
     void meiju(){
     /**
      * 通用枚举,需要进行配置
      */
     user user=new user();
     user.setName("琉璃");
     user.setSex("女");
     user.setAge(12);
     user.setGender(Genderenum.MAN);
     int insert = usermapper.insert(user);
     System.out.println(insert);
 }
    /**
     * 字段处理器
     */
    @Test
  void   test(){
        user user=new user();
        user.setName("zjas");
        user.setAge(12);
        user.setSex("男");
        user.setStaus(1);
        HashMap<String,String> hashMap= new HashMap<>();
        hashMap.put("tel","12123131");
        hashMap.put("phone","123213");
        user.setContact(hashMap);
        usermapper.insert(user);
  }
  @Test
   void  qtest(){
      List<user> users = usermapper.selectList(null);
      System.out.println(users);
  }
  @Test
   void  test1(){
      user user = usermapper.selectById("12");
      System.out.println("查询结果"+user);
       user.setName("张三");
        user.updateById();
    }
    @Test
     void updfate(){
        user user = usermapper.selectById("13");
        com.tong.mp1.domain.user user1 = usermapper.selectById("12");
        System.out.println("查询1的结果"+user);
        System.out.println(user1);
    }



}
