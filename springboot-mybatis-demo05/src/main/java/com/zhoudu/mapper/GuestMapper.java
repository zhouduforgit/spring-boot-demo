package com.zhoudu.mapper;

import com.zhoudu.domain.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// @Mapper
public interface GuestMapper {
    @Select("select  name, role from guest")
    public List<Guest> selectGuest();
}
