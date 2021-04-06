package com.zhoudu.service.impl;

import com.zhoudu.domain.SeckillGoods;
import com.zhoudu.mapper.SeckillGoodsMapper;
import com.zhoudu.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    public SeckillGoods getSeckillGoods(String goodsId) {
        SeckillGoods seckillGoods= seckillGoodsMapper.selectSeckillGoods(goodsId);
        return seckillGoods;
    }
    public void reduceStockCnt(String goodsId){
        SeckillGoods seckillGoods= seckillGoodsMapper.selectSeckillGoods(goodsId);
        seckillGoods.setStock_cnt(seckillGoods.getStock_cnt()-1);
        seckillGoodsMapper.reduceStockCnt(seckillGoods);
    }
}
