package com.zhoudu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * vegetable.potato=土豆
 * vegetable.eggplant=茄子
 * vegetable.greenpeper=青椒
 *
 * @Configuration 声名这是个配置类
 * @ConfigurationProperties(prefix = "vegetable")
 * @PropertySource("classpath:vegetable.properties")  声名配置类的前缀
 */
@Configuration
@ConfigurationProperties(prefix = "vegetable")
@PropertySource("classpath:vegetable.properties")
@Data
public class VegetableConfig {

        private String potato;
        private String eggplant;
        private String greenpeper;
}


