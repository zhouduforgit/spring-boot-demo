package com.zhoudu.controller;

import com.zhoudu.domain.Guest;
import com.zhoudu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public  List<Guest>  listGuest(Model model) {
        List<Guest> guestList = guestService.selectGuest();
        return guestList;
    }

    @GetMapping("/{id}")
    public  Guest  listGuest(@PathVariable("id") int id ) {
        Guest guest=guestService.getGuestById(id);
        return guest;
    }

    @GetMapping("/update")
    public Guest updateGuest(Integer id,String name,String role){
        Guest newGuest=new Guest(id,name,role);
        guestService.update(newGuest);
        return newGuest;
    }
    @GetMapping("/delete/{id}")
    public String deleteGuest(@PathVariable("id") int id){
        if(id!=0) {
            guestService.deleteGuest(id);
        }else {
            guestService.deleteAllGuest();
        }
        return "Success";
    }
}
