package com.zhoudu.mapper;

import com.zhoudu.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface GoodsMapper {
    public List<Goods> selectAllGoods();
    public Goods selectGoodsById(String goodsId);
    public void reduceStockCnt(String goodsId);
}
