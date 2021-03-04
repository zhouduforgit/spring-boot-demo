package com.zhoudu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data @AllArgsConstructor
public class Guest {
    @NotBlank(message = "{guest.name.notblank}")
    private String name;
    @NotBlank(message = "guest嘉宾角色不能是空")
    private String role;
}
