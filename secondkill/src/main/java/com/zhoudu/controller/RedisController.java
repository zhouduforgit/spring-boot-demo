package com.zhoudu.controller;

import com.zhoudu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/initData")
    public String initData(String goodsId, int stockCnt) {
        // 将 秒杀商品的 秒杀开始时间  库存等数据  先存入库中
        redisService.initData(goodsId, stockCnt);
        return "success";
    }


    @GetMapping("/seckillAPI")
    public String seckillAPI(String userId, String goodsId) {
        if (userId == null || goodsId == null) {
            return "传入参数异常";
        }
        System.out.println("接收请求：" + userId + "--" + goodsId);
        String result = redisService.seckill(userId, goodsId);
        System.out.println(result);
        return result;
    }
}
