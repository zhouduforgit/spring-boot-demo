package com.zhoudu.service.impl;

import com.zhoudu.domain.Goods;
import com.zhoudu.domain.SeckillGoods;
import com.zhoudu.mapper.GoodsMapper;
import com.zhoudu.mapper.SeckillGoodsMapper;
import com.zhoudu.service.GoodsService;
import com.zhoudu.vo.GoodsDetailVo;
import com.zhoudu.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    /**
     * 查询所有商品和秒杀商品信息组成goodsVo
     * @return
     */
    public List<GoodsVo> getGoods() {
        List<GoodsVo> goodsVos=new ArrayList<>();
        List<Goods> goodsList= goodsMapper.selectAllGoods();
        for(Goods goods:goodsList){
            GoodsVo vo=new GoodsVo();
            SeckillGoods seckillGoods=seckillGoodsMapper.selectSeckillGoods(goods.getGoods_id());
            vo.setId(goods.getId());
            vo.setGoodsId(seckillGoods.getGoods_id());
            vo.setName(goods.getName());
            vo.setImgPath(goods.getImg_path());
            vo.setPrice(goods.getPrice());
            vo.setSeckillPrice(seckillGoods.getSeckill_price());
            vo.setStockNum(seckillGoods.getStock_cnt());
            goodsVos.add(vo);
        }
        return goodsVos;
    }

    public GoodsDetailVo getGoodsDetail(String goodsId) {
        GoodsDetailVo goodsDetailVo=new GoodsDetailVo();
        SeckillGoods seckillGoods=seckillGoodsMapper.selectSeckillGoods(goodsId);
        Goods goods=goodsMapper.selectGoodsById(goodsId);

        goodsDetailVo.setName(goods.getName());
        goodsDetailVo.setGoodsId(goods.getGoods_id());
        goodsDetailVo.setImgPath(goods.getImg_path());
        goodsDetailVo.setPrice(goods.getPrice());
        goodsDetailVo.setSeckillPrice(seckillGoods.getSeckill_price());
        goodsDetailVo.setStockNum(seckillGoods.getStock_cnt());
        goodsDetailVo.setStartTime(seckillGoods.getStart_time());
        goodsDetailVo.setEndTime(seckillGoods.getEnd_time());
        return goodsDetailVo;
    }

}
