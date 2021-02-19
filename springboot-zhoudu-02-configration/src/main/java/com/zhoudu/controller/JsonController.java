package com.zhoudu.controller;

import com.zhoudu.bean.Food;
import com.zhoudu.config.FoodConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 是@Controller和@ResponseBody的组合  返回json形式
 * 而不是返回视图  jsp html
 */
@RestController
public class JsonController {
  /*  @Value("${food.rice}")
    private String  rice;

    @Value("${food.meat}")
    private String meat;*/
    @Autowired
    FoodConfig foodConfig;

    @RequestMapping("/json")
    public Food json(){
        Food food=new Food();
        food.setMeat(foodConfig.getMeat());
        food.setRice(foodConfig.getRice());
        return food;
    }
}