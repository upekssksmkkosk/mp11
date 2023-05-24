package com.tong.mp1.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：小童
 * @date 2023-05-09 19:26:21
 */
@Configuration
public class mybatisplusconfig {
    @Bean
 public MybatisPlusInterceptor mybatisPlusInterceptor(){
     MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
     interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
     //防止全表更新的误操作
     interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
     interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
     return  interceptor;
 }

}
