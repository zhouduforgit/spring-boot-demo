package com.zhoudu.service;

import com.zhoudu.domain.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> selectGuest();
    Guest getGuestById(int id);

    //返回值guest要存入缓存 所以不是 int or void
    Guest update(Guest guest);

    void deleteGuest(int id);
    void deleteAllGuest();
 /*   void addGuest(Guest guest);
    void update(Guest guest);
    Guest get(String name);
    void delete(String name);*/
}
