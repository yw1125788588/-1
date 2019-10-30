package com.imooc.wx.service.Imp;


import com.imooc.wx.entity.SysPermission;
import com.imooc.wx.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl {
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 获取指定角色所有权限
     */
    public List<SysPermission> listByRoleId(Integer roleId) {
        return sysPermissionService.listByRoleId(roleId);
    }
}