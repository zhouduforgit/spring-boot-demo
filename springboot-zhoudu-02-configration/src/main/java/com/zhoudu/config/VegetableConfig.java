package com.zhoudu.config;

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

public class VegetableConfig {

        private String potato;
        private String eggplant;
        private String greenpeper;

        public String getPotato() {
            return potato;
        }

        public void setPotato(String potato) {
            this.potato = potato;
        }

        public String getEggplant() {
            return eggplant;
        }

        public void setEggplant(String eggplant) {
            this.eggplant = eggplant;
        }

        public String getGreenpeper() {
            return greenpeper;
        }

        public void setGreenpeper(String greenpeper) {
            this.greenpeper = greenpeper;
        }
}


