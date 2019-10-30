package com.imooc.wx.service;

import com.imooc.wx.entity.SysProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysProjectService {
    SysProject queryById(Integer id);
    List<SysProject> queryAllByLimit(@Param("offset")int offset,@Param("limit")int limit);
    List<SysProject> queryAll(SysProject sysProject);
    SysProject insert(SysProject sysProject);
    boolean deleteById(Integer id);
}
