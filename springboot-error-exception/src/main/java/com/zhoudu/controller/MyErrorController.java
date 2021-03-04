package com.zhoudu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController {
    @RequestMapping("/error404")
    public String toErrorPage(){
        return "errorPage404";
    }

    @RequestMapping("/testerror")
    public String error() throws Exception{
        throw new Exception("测试异常");
    }
}
