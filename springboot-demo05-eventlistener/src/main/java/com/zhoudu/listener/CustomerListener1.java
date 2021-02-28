package com.zhoudu.listener;

import com.zhoudu.event.CustomerEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class CustomerListener1 implements ApplicationListener<CustomerEvent> {

    @Override
    public void onApplicationEvent(CustomerEvent customerEvent) {
        customerEvent.printMes("CustomerListener1监听到信息");
    }
}
