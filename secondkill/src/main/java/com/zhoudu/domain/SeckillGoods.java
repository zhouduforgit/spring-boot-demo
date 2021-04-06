package com.zhoudu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class SeckillGoods {
    private long id;
    private String goods_id;
    private Double seckill_price;
    private Integer stock_cnt;
    private Date start_time;
    private Date  end_time;
}
