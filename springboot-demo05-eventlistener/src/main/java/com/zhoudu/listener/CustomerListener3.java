package com.zhoudu.listener;

import com.zhoudu.event.CustomerEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerListener3  {
    @EventListener
    public void eventListener(CustomerEvent event){
        event.printMes("第3号监听器接收到信息");
    }

}
