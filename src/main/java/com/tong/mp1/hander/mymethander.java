package com.tong.mp1.hander;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandleInfo;
import java.util.Date;

/**
 * @author ：小童
 * @date 2023-05-10 20:01:22
 */
@Component
public class mymethander implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
      setFieldValByName("createtime",new Date(),metaObject);
        setFieldValByName("updatetime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updatetime",new Date(),metaObject);
    }
}
