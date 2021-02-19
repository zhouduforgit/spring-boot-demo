package com.zhoudu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ConfigurationProperties 声名这是一个配置文件对应的类
 * prefix前缀指向配置文件的一级目录
 */
@ConfigurationProperties(prefix = "food")
public class FoodConfig {
    private String meat;
    private String rice;

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getRice() {
        return rice;
    }

    public void setRice(String rice) {
        this.rice = rice;
    }
}
