package com.zhoudu;

import com.zhoudu.domain.Guest;
import com.zhoudu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;
    private String path="";

    @GetMapping
    public String listGuest(Model model) {
        List<Guest> guestList = guestService.selectGuest();
        model.addAttribute("guestList", guestList);
        return path+"list";
    }
}
