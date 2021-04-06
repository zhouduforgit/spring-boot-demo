package com.zhoudu.service;

import com.zhoudu.domain.SeckillGoods;

import java.util.List;
public interface SeckillGoodsService {
    public SeckillGoods getSeckillGoods(String goodsId);
    void reduceStockCnt(String goodsId);
}
