package com.zhoudu.service.impl;

import com.zhoudu.util.RedisUtil;
import com.zhoudu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;

    //  http://localhost:8080/seckillAPI?userId=1&goodsId=123456
    @Override
    public String seckill(String userId, String goodsId) {
        // 编写lua脚本
        // 返回值的含义
        //  2 - 用户已经秒杀成功过  0 - 库存空了  1- 秒杀成功

        // 脚本加载进来  调用redis执行脚本  并获得结果
        DefaultRedisScript<Long> script=new DefaultRedisScript<>();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(
                new ClassPathResource("lua/seckill.lua")
        ));
        List<String> keyList=new ArrayList<>();
        keyList.add(userId);
        keyList.add(goodsId);
        Object result=redisUtil.execute(script,keyList);
        String str=String.valueOf(result);
        switch (str){
            case "1":
                return userId+"秒杀成功";
            case "2":
                return userId+"已购买过该商品";
            case  "0":
                return "商品秒杀一空";
            default:
                return "秒杀异常";
        }
    }

    public String seckill2(String userId, String goodsId) {
        // 对应 redis事务的会话
        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations)
                    throws DataAccessException {
                redisOperations.watch(goodsId + "_count");

                Object stockCnt = redisUtil.get(goodsId + "_count");
                if (stockCnt == null || (int) stockCnt <= 0) {
                    return false;
                }
                redisOperations.multi();
                // 减库存   建立用户和商品的关联关系
                redisUtil.decr(goodsId + "_count");
                //  key代表 用户买了某个商品  拼装规则 goodsId + "_" + userId
                redisUtil.set(goodsId + "_" + userId, 1);
                return redisOperations.exec();
            }
        };
        redisUtil.execute(sessionCallback);
        if (redisUtil.hasKey(goodsId + "_" + userId)) {
            return userId + "秒杀成功";
        }
        return userId + "秒杀失败";
    }


    public String seckill1(String userId, String goodsId) {

        // 存进redis的数据格式问题
//        redisUtil.set("k_" + userId, userId + "_" + goodsId);

        // 有没有到开始时间   有没有剩余库存  有没有剩余限购额度
        Date startTime = (Date) redisUtil.get(goodsId + "_startTime");
        if (startTime == null || new Date().before(startTime)) {
            // 一般放在枚举类中   更严谨的判断是  是否介于秒杀时段内 （增加对结束时间的判断）
            return "秒杀还未开始";
        }

        int stockCnt = (int) redisUtil.get(goodsId + "_count");
        if (stockCnt <= 0) {
            return "商品秒杀一空";
        }
        if (redisUtil.get(goodsId + "_" + userId) != null) {
            return userId + "用户已秒杀成功过";
        }
        // 减库存   建立用户和商品的关联关系
        redisUtil.decr(goodsId + "_count");
        //  key代表 用户买了某个商品  拼装规则 goodsId + "_" + userId
        redisUtil.set(goodsId + "_" + userId, 1);

        return userId + "用户秒杀成功";

    }

    @Override
    public boolean initData(String goodsId, int stockCnt) {
        // redis  String
        //  区分出商品的库存   设置好key的规则   goodsId + "_count"  |  goodsId + "_stockCnt"
        //  商品的秒杀时间   设置好key的规则   goodsId + "_startTime"

        //  数据库的字段名   select stock_cnt where goodsId = #{goodsId}
        //  redis <key,value> -> <String,Object>     key: goodsId + "_count"
        //  数据可以来自于数据库的同步  也可以来自于专门的数据初始化程序
        redisUtil.set(goodsId + "_count", stockCnt);

        try {
            String str = "2021-03-31 00:00:00";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(str);

            redisUtil.set(goodsId + "_startTime", date);
        } catch (Exception e) {
        }

        return false;
    }
}
