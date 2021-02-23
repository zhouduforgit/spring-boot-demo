package com.zhoudu.controller;

import com.zhoudu.domain.Guest;
import com.zhoudu.service.GuestService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class GuestController {
    @Autowired
    private GuestService guestService;

    @RequestMapping("/guest/list")
    public String listGuest(Model model){
        List<Guest>  guestList=guestService.selectGuest();
        model.addAttribute("guestList",guestList);
        return "list";
    }

    @RequestMapping("/guest/toAdd")
    public String toAddPage(){
        return "add";
    }

    @RequestMapping("/guest/add")
    public String add(Guest guest){
        guestService.addGuest(guest);
        return  "redirect:/guest/list";
    }


    @RequestMapping("/guest/toUpdate")
    public String toUpdatePage(Model model,String name){
        Guest guest=guestService.get(name);
        model.addAttribute("guest",guest);
        return "update";
    }

    @RequestMapping("/guest/update")
    public String update(Guest guest){
        guestService.update(guest);
        return  "redirect:/guest/list";
    }

    @RequestMapping("/guest/delete")
    public String delete(String name){
        guestService.delete(name);
        return  "redirect:/guest/list";
    }


}
