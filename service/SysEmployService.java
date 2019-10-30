package com.imooc.wx.service;

import com.imooc.wx.entity.SysEmploy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysEmployService {

    SysEmploy queryById(Integer id);

    List<SysEmploy> queryAllByLimit(@Param("offset")int offset,@Param("limit")int limit);

    SysEmploy queryAll(SysEmploy sysEmploy);

    int deleteById();


}
