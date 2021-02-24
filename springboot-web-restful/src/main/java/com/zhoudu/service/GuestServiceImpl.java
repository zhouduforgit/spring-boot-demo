package com.zhoudu.service;

import com.zhoudu.dao.GuestDao;
import com.zhoudu.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestDao guestDao;

    @Override
    public List<Guest> selectGuest() {
        List<Guest>  guestList= guestDao.getGuestList();
        return guestList;
    }

    public void addGuest(Guest guest){
        guestDao.addGuest(guest);
    }

    public void update(Guest guest){
        guestDao.update(guest);
    }
    public Guest get(String name){
        return guestDao.getGuest(name);
    }

    public void delete(String name){
        guestDao.delete(name);
    }
}
