package com.zhoudu.dao;

import com.zhoudu.domain.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDao {
    static List<Guest> guestList=new ArrayList<>();
    static {
        guestList.add(new Guest("保罗","控球后卫"));
        guestList.add(new Guest("科比","得分后卫"));
        guestList.add(new Guest("詹姆斯","小前锋"));
        guestList.add(new Guest("阿尔德里奇","大前锋"));
        guestList.add(new Guest("姚明","中锋"));
    }
    public List<Guest> getGuestList(){
        return guestList;
    }
    public void addGuest(Guest guest){
        guestList.add(guest);
    }

    public void update(Guest newGuest){
        Guest oldGuest=getGuest(newGuest.getName());
        oldGuest.setRole(newGuest.getRole());
    }

    //修改需要先找到guest对象再修改信息
    public Guest getGuest(String name){
        for(Guest guest:guestList){
            if(guest.getName().equals(name)){
                return guest;
            }
        }
        return null;
    }

    public void delete(String name){
        guestList.remove(getGuest(name));
    }
}
