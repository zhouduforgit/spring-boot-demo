package com.zhoudu.controller;

import com.google.gson.Gson;
import com.zhoudu.domain.GoodsOrder;
import com.zhoudu.enums.ErrorMsg;
import com.zhoudu.service.GoodsOrderService;
import com.zhoudu.service.GoodsService;
import com.zhoudu.service.SeckillGoodsService;
import com.zhoudu.vo.GoodsDetailVo;
import com.zhoudu.vo.GoodsVo;
import com.zhoudu.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsOrderService goodsOrderService;

    @Autowired
    private SeckillGoodsService seckillGoodsService;
    /**
     * 把查询到GoodVo的信息展示到showGoods.html
     * @param model
     * @return
     */
    @GetMapping("/")
    public String showGoods(Model model){
        List<GoodsVo> goodsList=goodsService.getGoods();
        model.addAttribute("goodsList",goodsList);
        String result = new Gson().toJson(goodsList);
        System.out.println(result);
        return "showGoods";
    }

    /**
     * 此方法是传递商品id，显示小商品详情html
     * @return
     */
    @GetMapping("/goodsDetail/{goodsId}")
    public String showGoodsDetail(@PathVariable String goodsId,Model model){
        GoodsDetailVo detailVo= goodsService.getGoodsDetail(goodsId);
        model.addAttribute("detailVo",detailVo);

        Date startTime=detailVo.getStartTime();
        Date endTime=detailVo.getEndTime();
        Date now=new Date();
        //表示秒杀活动的状态  0未开始 1进行中 2已结束，这状态还可以用枚举
        int status;
        int remainSeconds=-1;
        if(now.before(startTime)){
            status=0;
            remainSeconds = (int)((startTime.getTime() - now.getTime())/1000);
        }else if(now.after(endTime)){ //活动已结束
            status=2;
            remainSeconds=-1;
        }else{ //秒杀活动开始
            status=1;
            remainSeconds=0;
        }
        model.addAttribute("status",status);
        model.addAttribute("remainSeconds",remainSeconds);
        return "GoodsDetail";
    }

    /**
     * 跳转到订单页面
     * 若失败跳转失败页面
     * 生成订单是要判断合理性
     * 1）是否登录  暂无
     * 2）是否有库存  cnt>0
     * 3) 是否正在秒杀   start<now<end
     * 4）是否满足限购条件
     * @param goodsId
     * @param model
     * @return
     */
    @PostMapping("/toSeckill/goodsId")
    public String toSeckill(String goodsId,Model model){
        //根据goodsId获得goodsDetailVo对象，得到期商品的库存和开始，结束时间
        GoodsDetailVo goodsDetailVo=goodsService.getGoodsDetail(goodsId);
        int cnt= goodsDetailVo.getStockNum();
        if(cnt<=0){
            model.addAttribute("msg", ErrorMsg.CLEARED.getMsg());
            return "fail";
        }
        Date startTime=goodsDetailVo.getStartTime();
        Date endTime=goodsDetailVo.getEndTime();
        Date now=new Date();
        if(now.before(startTime) || now.after(endTime)){
            model.addAttribute("msg",ErrorMsg.UNSTART.getMsg());
            return "fail";
        }
        //减库存
        seckillGoodsService.reduceStockCnt(goodsId);
        //生成订单
        GoodsOrder goodsOrder=new GoodsOrder();
        goodsOrder.setUser_id("zhoudu");
        goodsOrder.setOrder_id("112233");
        goodsOrder.setGoods_id(goodsId);
        goodsOrder.setTel("18164250089");
        goodsOrder.setAddress("汉正街");
        goodsOrderService.addOrder(goodsOrder);
        //        //展示订单页面
        OrderDetailVo orderDetailVo=new OrderDetailVo();
        orderDetailVo.setName(goodsDetailVo.getName());
        orderDetailVo.setImgPath(goodsDetailVo.getImgPath());
        orderDetailVo.setPrice(goodsDetailVo.getPrice());
        orderDetailVo.setStartTime(new Date());
        orderDetailVo.setTel(goodsOrder.getTel());
        orderDetailVo.setAddress(goodsOrder.getAddress());
        model.addAttribute("orderDetailVo",orderDetailVo);
        return "goodsOrder";
    }

}
