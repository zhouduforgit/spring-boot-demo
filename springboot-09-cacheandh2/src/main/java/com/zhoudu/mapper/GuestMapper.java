package com.zhoudu.mapper;

import com.zhoudu.domain.Guest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GuestMapper {
    @Select("select id, name, role from guest")
    public List<Guest> selectGuest();

    @Select("select id, name, role from guest where id=#{id}")
    Guest getGuestById(int id);

    @Update(" update guest set name=#{name},role=#{role} where id=#{id} ")
    int updateGuest(Guest guest);

    @Delete(" delete from guest where id=#{id}")
    void deleteGuest(int id);

    @Delete(" delete from guest")
    void deleteAllGuest();
}
