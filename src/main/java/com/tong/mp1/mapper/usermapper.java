package com.tong.mp1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tong.mp1.domain.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：小童
 * @date ：2023-05-07 21:07:50
 */
@Mapper
public interface usermapper  extends BaseMapper<user> {
   user selectuserbyname(String name);
   IPage<user> selectbyname(IPage<user> userIPage,String name);
   /**
    * 我写的一个文件
    */
}
