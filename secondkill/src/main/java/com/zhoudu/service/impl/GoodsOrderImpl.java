package com.zhoudu.service.impl;
import com.zhoudu.domain.GoodsOrder;
import com.zhoudu.mapper.GoodsOrderMapper;
import com.zhoudu.service.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoodsOrderImpl implements GoodsOrderService {
    @Autowired
    private GoodsOrderMapper goodsOrderMapper;
    @Override
    public int addOrder(GoodsOrder goodsOrder) {
        return goodsOrderMapper.addOrder(goodsOrder);
    }
}
