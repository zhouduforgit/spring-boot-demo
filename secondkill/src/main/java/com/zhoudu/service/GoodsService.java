package com.zhoudu.service;

import com.zhoudu.domain.Goods;
import com.zhoudu.vo.GoodsDetailVo;
import com.zhoudu.vo.GoodsVo;

import java.util.List;
public interface GoodsService {
    List<GoodsVo> getGoods();
    GoodsDetailVo getGoodsDetail(String goodsId);

}
