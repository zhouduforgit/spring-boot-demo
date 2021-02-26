package com.zhoudu.service;


import com.zhoudu.mapper.GuestMapper;
import com.zhoudu.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper guestMapper;

    @Override
    public List<Guest> selectGuest() {
       return guestMapper.selectGuest();
    }
}
