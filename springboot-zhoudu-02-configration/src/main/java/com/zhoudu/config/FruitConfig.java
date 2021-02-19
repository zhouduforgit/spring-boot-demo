package com.zhoudu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "fruit")
@PropertySource("classpath:fruit.properties")
public class FruitConfig {
    private String apple;
    private String plum;
    private String grape;

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getPlum() {
        return plum;
    }

    public void setPlum(String plum) {
        this.plum = plum;
    }

    public String getGrape() {
        return grape;
    }

    public void setGrape(String grape) {
        this.grape = grape;
    }
}
