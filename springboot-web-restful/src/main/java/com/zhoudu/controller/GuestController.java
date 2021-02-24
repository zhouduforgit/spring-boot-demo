package com.zhoudu.controller;

import com.zhoudu.domain.Guest;
import com.zhoudu.service.GuestService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @RequestMapping("/guest")
 * 放在类上面代表类中的所有方法的请求是以"/guest"开头
 */

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String listGuest(Model model){
        List<Guest>  guestList=guestService.selectGuest();
        model.addAttribute("guestList",guestList);
        return "list";
    }

    @GetMapping("/toAdd")
    public String toAddPage(){
        return "add";
    }

    @PostMapping
    public String add(Guest guest){
        guestService.addGuest(guest);
        return  "redirect:/guest";
    }


    /**
     * 将 /guest/update/{name}/格式url映射到此方法
     * String name参数，是通过@PathVariable("name")复制
     * @param model
     * @param name
     * @return
     */
    @GetMapping("/toUpdate/{name}")
    public String toUpdatePage(Model model,@PathVariable("name") String name){
        Guest guest=guestService.get(name);
        model.addAttribute("guest",guest);
        return "update";
    }

    @PutMapping
    public String update(Guest guest){
        guestService.update(guest);
        return  "redirect:/guest";
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name){
        guestService.delete(name);
        return  "redirect:/guest";
    }


}
