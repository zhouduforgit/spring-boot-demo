package com.zhoudu.domain;

import lombok.Data;

@Data
public class GoodsOrder {
    private String id;
    private String user_id;
    private String goods_id;
    private String order_id;
    private String tel;
    private String address;
}
