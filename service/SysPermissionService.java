package com.imooc.wx.service;

import com.imooc.wx.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {
    List<SysPermission> listByRoleId(Integer roleId);
}
