package com.zhoudu.mapper;

import com.zhoudu.domain.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsOrderMapper {
    int addOrder(GoodsOrder goodsOrder);
}
