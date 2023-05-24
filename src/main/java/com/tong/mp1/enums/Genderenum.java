package com.tong.mp1.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Genderenum {
    MAN(0,"男") ,WOMAN(1,"女");
   @EnumValue
    private  Integer gender;
    private  String  genderName;

    Genderenum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }
}
