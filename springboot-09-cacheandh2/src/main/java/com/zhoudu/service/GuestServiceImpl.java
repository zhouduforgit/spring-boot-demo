package com.zhoudu.service;

import com.zhoudu.mapper.GuestMapper;
import com.zhoudu.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper guestMapper;

    public List<Guest> selectGuest() {
       return guestMapper.selectGuest();
    }
    @Cacheable(cacheNames = "guests",key = "#id", condition = "#id>1")
    public Guest getGuestById(int id){
        System.out.println("查询第"+id+"位嘉宾");
        return guestMapper.getGuestById(id);
    }

    /**
     * @CachePut 返回值guest存入缓存里
     * @param guest
     * @return
     */
    @CachePut(cacheNames ="guests",key = "#guest.id")
    public Guest update(Guest guest) {
        System.out.println("跟新到第："+guest.getId()+"的嘉宾");
        guestMapper.updateGuest(guest);
        return guest;
    }

    @CacheEvict(cacheNames = "guests" ,key = "#id")
    public void deleteGuest(int id) {
        System.out.println("删除第："+id+"位嘉宾");
        guestMapper.deleteGuest(id);
    }
    @CacheEvict(cacheNames = "guest",allEntries = true)
    public void deleteAllGuest(){
        System.out.println("删除所有的嘉宾");
        guestMapper.deleteAllGuest();
        int re=1/0;
    }
}
