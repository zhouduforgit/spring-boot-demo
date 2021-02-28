package com.zhoudu.listener;

import com.zhoudu.event.CustomerEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Listener2 implements ApplicationListener<CustomerEvent> {

    @Override
    public void onApplicationEvent(CustomerEvent customerEvent) {
        customerEvent.printMes("2号监听器的信息++：");
    }
}
