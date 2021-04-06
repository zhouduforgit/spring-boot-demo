package com.zhoudu.mapper;

import com.zhoudu.domain.Goods;
import com.zhoudu.domain.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SeckillGoodsMapper {
    public SeckillGoods selectSeckillGoods(String goodsId);
    public void   reduceStockCnt(SeckillGoods seckillGoods);


}
