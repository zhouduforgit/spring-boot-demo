package com.zhoudu.listener;

import com.zhoudu.event.CustomerEvent;
import org.springframework.context.ApplicationListener;

public class Listener4 implements ApplicationListener<CustomerEvent> {
    public void onApplicationEvent(CustomerEvent event){
        event.printMes("di第4号监听器的接收的信息");
    }
}
