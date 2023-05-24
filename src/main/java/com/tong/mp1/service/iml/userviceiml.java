package com.tong.mp1.service.iml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tong.mp1.domain.user;
import com.tong.mp1.mapper.usermapper;
import com.tong.mp1.service.userservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：小童
 * @date 2023-05-08 19:11:09
 */
@Service
public  class userviceiml extends ServiceImpl<usermapper,user> implements userservice {
    @Resource
    private  usermapper usermapper;


    @Override
    public List<user> selectuser() {
        return  usermapper.selectList(null);
    }
}
