package com.tong.mp1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tong.mp1.domain.user;

import java.util.List;

/**
 * @author ：小童
 * @date ：2023-05-08 17:36:15
 */
public interface userservice  extends IService<user> {
    List<user> selectuser();
}
