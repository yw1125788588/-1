package com.imooc.wx.service;

import com.imooc.wx.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService {

    List<SysUserRole> listByUserId(Integer userId);
}
