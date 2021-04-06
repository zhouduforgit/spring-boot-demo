package com.zhoudu.vo;

import lombok.Data;
import java.util.Date;
@Data
public class GoodsDetailVo {
    private String name;
    private String goodsId;
    private String imgPath;
    private Double price;
    private Double seckillPrice;
    private int stockNum;
    private Date startTime;
    private Date endTime;
}
