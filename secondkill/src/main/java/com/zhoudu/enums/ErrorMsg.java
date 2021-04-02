package com.zhoudu.enums;

import jdk.internal.org.objectweb.asm.ClassReader;
import lombok.Data;
import lombok.Getter;

@Getter
public enum ErrorMsg {
    UNSTART("100001","秒杀未开始或已结束"),
    CLEARED("100002","库存没了");
    ErrorMsg(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
    private String code;
    private String msg;
}
