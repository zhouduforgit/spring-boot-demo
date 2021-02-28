package com.zhoudu;

import com.zhoudu.listener.CustomerListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventlistenerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(EventlistenerApplication.class, args);
        context.addApplicationListener(new CustomerListener1());
    }

}
