package com.zhoudu.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Goods {
    private long id;
    private String goods_id;
    private String name;
    private String type;
    private Double price;
    private String img_path;
    private Integer stock_cnt;
}
