package com.zhoudu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data@AllArgsConstructor@NoArgsConstructor
public class Guest {
    private Integer id;
    private String name;
    private String role;
}
