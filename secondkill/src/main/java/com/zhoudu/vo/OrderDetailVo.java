package com.zhoudu.vo;
import lombok.Data;

import java.util.Date;
@Data
public class OrderDetailVo {
    private String name; //订单的商品名字
    private String imgPath;
    private Double price;
    private Date startTime;
    private String tel;
    private String address;
}
