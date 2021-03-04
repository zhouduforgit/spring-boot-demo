package com.zhoudu.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handler(Exception e){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/error");
        return mv;
    }
}
