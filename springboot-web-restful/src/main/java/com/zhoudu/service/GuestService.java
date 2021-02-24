package com.zhoudu.service;

import com.zhoudu.domain.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> selectGuest();
    void addGuest(Guest guest);
    void update(Guest guest);
    Guest get(String name);
    void delete(String name);
}
