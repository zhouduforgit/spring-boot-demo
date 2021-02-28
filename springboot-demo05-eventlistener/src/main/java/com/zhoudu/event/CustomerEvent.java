package com.zhoudu.event;

import org.springframework.context.ApplicationEvent;

public class CustomerEvent extends ApplicationEvent {
    public CustomerEvent(Object source) {
        super(source);
    }
    public void printMes(String msg){
        System.out.println("事件监听的开始:::"+msg);
    }
}
