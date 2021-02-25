package com.zhoudu.service;


import com.zhoudu.domain.Guest;
import com.zhoudu.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository repository;
    @Override
    public List<Guest> selectGuest() {
        return  repository.findAll();
    }

 }
