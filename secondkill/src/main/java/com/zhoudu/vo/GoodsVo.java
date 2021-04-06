package com.zhoudu.vo;

import lombok.Data;

@Data
public class GoodsVo {
    private long id;
    private String name;
    private String goodsId;
    private String imgPath;
    private Double price;
    private Double seckillPrice;
    private int stockNum;

}
