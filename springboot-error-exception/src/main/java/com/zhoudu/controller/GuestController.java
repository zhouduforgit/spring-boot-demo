package com.zhoudu.controller;

import com.zhoudu.domain.Guest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GuestController {
    /**
     * @Valid  校验规则  校验不通过返回400和原因
     * 默认普通校验，遍历所有属性全部返回
     *
     * ,BindingResult是自定义的处理类
     * @param guest
     * @return
     */
    @PostMapping("/guest")
    public String add(@Valid Guest guest, BindingResult bindingResult){
        if(bindingResult.getErrorCount()>0){
            List<FieldError> fieldErrorList= bindingResult.getFieldErrors();
            StringBuilder builder=new StringBuilder();
            for(FieldError fieldError:fieldErrorList){
                builder.append(fieldError.getField());
                builder.append("\t");
                builder.append(fieldError.getDefaultMessage());
                builder.append("\n");
            }
            return builder.toString();
        }
        return "Success";
    }
}
