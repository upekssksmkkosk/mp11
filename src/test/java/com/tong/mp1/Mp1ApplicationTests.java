package com.tong.mp1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.SimpleQuery;
import com.tong.mp1.domain.user;
import com.tong.mp1.enums.Genderenum;
import com.tong.mp1.mapper.usermapper;
import com.tong.mp1.service.userservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Mp1ApplicationTests {
    @Autowired
    private  userservice userservice;
    @Autowired
    private usermapper usermapper;

    /**
     * 使用mybatis-plus进行增加操作

    @Test
    void contextLoads() {
      user user=new user("12","王建",12,"男",1,1, Genderenum.MAN,null,new Date(),new Date());
        int insert = usermapper.insert(user);
        System.out.println(insert);
    }
    /**
     * 根据id进行查询对应这一条记录
     */
    @Test
    void select(){
        user user = usermapper.selectById("1");
        System.out.println(user);
    }
    /**
     * 进行删除的操作
     */
    @Test
    void deleteUserById() {
        // 定义要删除的用户的id
        String userId = "12";
        // 调用mapper方法删除用户
        int deleteResult = usermapper.deleteById(userId);
        // 使用断言判断删除是否成功
        assertTrue(deleteResult == 1, "删除用户失败");
    }
/**
    @Test
    void insertuser(){
        user user=new user("13","张二飞",13,"女",1,1,Genderenum.WOMAN,null,new Date(),new Date());
        boolean save = userservice.save(user);
        //我们程序我们都使用断言进行检查测试用例
        assertTrue(save);

    }
    */
    /**
    @Test
    void  update(){
        user user=new user("13","张博兴",15,"男",1,1,Genderenum.MAN,null,new Date(),new Date());
        boolean updateById = userservice.updateById(user);
        assertTrue(updateById);
    }
    */
    @Test
    void selectlist(){
        List<user> userList = userservice.selectuser();
        System.out.println(userList);
    }
    @Test
    void   test01(){
        user user = usermapper.selectuserbyname("张博兴");
        System.out.println(user);

    }
    @Test
    void test02(){
        //创建条件查询对象
        QueryWrapper<user> queryWrapper=new QueryWrapper<>();
        //设置查询条件
        queryWrapper.eq("name","张博兴");
        user user = usermapper.selectOne(queryWrapper);
        System.out.println(user);
    }
    @Test
    void test002(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(user::getName,"张博兴");
        user user = usermapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }
    @Test
    void test001(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        String name=null;
        lambdaQueryWrapper.eq(name!=null,user::getName,name);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void teat003(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(user::getName,"张博兴");
        lambdaQueryWrapper.eq(user::getAge,"15");
        user user = usermapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }
    @Test
    void isnull(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNull(user::getName);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void isnotnull(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNotNull(user::getName);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void teat0(){
        /**
         * in多条件匹配
         */
        ArrayList<Integer> arrayList=new ArrayList<>();
        Collections.addAll(arrayList,12,13,14);
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(user::getAge,arrayList);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void  noting(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        Collections.addAll(arrayList,12,13,14);
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notIn(user::getAge,arrayList);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void insql(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(user::getAge,"12,13,14");
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void insql1(){
        LambdaQueryWrapper<user> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(user::getAge,"select age from t_user where age<13");
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void notinsql(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(user::getAge,"12,13,14");
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void notinsql2(){
        LambdaQueryWrapper<user> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(user::getAge,"select age from t_user where age<13");
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    /**
     * 分组查询
     */
    @Test
    void fenzutest(){
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("age");
        queryWrapper.select("age,count(*) as field_count");
        List<Map<String, Object>> mapList = usermapper.selectMaps(queryWrapper);
        System.out.println(mapList);

    }
    /**
     *聚合查询
     */
    @Test
    void testw(){
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("age");
        queryWrapper.select("age,count(*) as field_count");
        queryWrapper.having("field_count=1");
        List<Map<String, Object>> mapList = usermapper.selectMaps(queryWrapper);
        System.out.println(mapList);
    }
    @Test
    void testw1(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
         lambdaQueryWrapper.orderByAsc(user::getAge,user::getId   );
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    @Test
    void   tser(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderBy(true,true,user::getAge);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    /**
     * 逻辑查询and嵌套的用法
     *
     */
    @Test
  void and(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(user::getName,"张博兴").and(i->i.gt(user::getAge,12).or().lt(user::getAge,15));
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
  }
    /**
     * 逻辑查询and的用法
     */
    @Test
    void and1(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.gt(user::getAge,12).lt(user::getAge,14);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    /**
     * or的用法
     */
    @Test
    void or(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(user::getAge,13).or().gt(user::getAge,17);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
    /**
     * or嵌套的用法
     */
    @Test
     void  or1(){
         LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
         lambdaQueryWrapper.eq(user::getName,"王建").or(i->i.gt(user::getAge,12).lt(user::getAge,15));
         List<user> users = usermapper.selectList(lambdaQueryWrapper);
         System.out.println(users);
     }
     @Test
       void nested(){
         LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
         lambdaQueryWrapper.nested(i->i.eq(user::getName,"张博兴").ne(user::getAge,"14"));
         List<user> users = usermapper.selectList(lambdaQueryWrapper);
         System.out.println(users);
     }
    /**
     * 自定义查询
     */
    @Test
     void apply(){
         LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
         lambdaQueryWrapper.apply("age=12");
         List<user> users = usermapper.selectList(lambdaQueryWrapper);
         System.out.println(users);
     }
    /**
     * 分页查询-last查询
     */
    @Test
     void last(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.last("limit 0,2");
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
     }
    /**
     * exists查询
     */
    @Test
     void exists(){
         LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
         lambdaQueryWrapper.exists("select id from t_user where age=13");
         List<user> users = usermapper.selectList(lambdaQueryWrapper);
         System.out.println(users);
     }
    /**
     * notexists查询
     */
    @Test
    void notexists(){

            LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
            lambdaQueryWrapper.notExists("select id from t_user where age=50");
            List<user> users = usermapper.selectList(lambdaQueryWrapper);
            System.out.println(users);
        }
    /**
     * select查询
     */
    @Test
     void select1(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(user::getId,user::getAge);
        List<user> users = usermapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
     }
     @Test
      void   testid(){
        user user=new user();
        user.setAge(13);
        user.setName("张三");
        user.setSex("男");
         int insert = usermapper.insert(user);
         System.out.println(insert);
     }
    /**
     * 分页查询的第一种方式
     */
    @Test
     void  fenye(){
        LambdaQueryWrapper<user> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        IPage<user> userPage=new Page<>(1,3);
        usermapper.selectPage(userPage,lambdaQueryWrapper);
        System.out.println("当前页"+userPage.getCurrent());
        System.out.println("每页显示条数"+userPage.getSize());
        System.out.println("总页数"+userPage.getPages());
        System.out.println("总条数"+userPage.getTotal());
    }

    /**
     * 分页查询第二种
     */
    @Test
    void  febye(){
        IPage<user> userPage=new Page<>(1,2);
        usermapper.selectbyname(userPage,"张三");
        System.out.println("当前页"+userPage.getCurrent());
        System.out.println("每页显示条数"+userPage.getSize());
        System.out.println("总页数"+userPage.getPages());
        System.out.println("总条数"+userPage.getTotal());
    }

    /**
     * 插入操作
     */
    @Test
    void  activverecad(){
        user user=new user();
        user.setName("zhang");
        user.setAge(12);
        user.setSex("男");
        user.insert();

    }

    /**
     * 删除操作
     */
    @Test
    void  activverecadd(){
        user user=new user();
        user.setId("62c91f184cd5174e9cd7e9e4eb4bf215");
        user.deleteById();
    }
    /**
     * 修改操作
     */
    @Test
  void  activverecad1(){
      user user=new user();
      user.setId("4ba1c4294c781a2fed1baed4ee90e5e8");
      user.setAge(19);
      user.updateById();
  }
    /**
     * 查询操作
     */
    @Test
     void select12(){
         user user=new user();
         user.setId("4ba1c4294c781a2fed1baed4ee90e5e8");
         user user1 = user.selectById();
        System.out.println(user1);
    }
    @Test
     void  map1(){

    }

}


