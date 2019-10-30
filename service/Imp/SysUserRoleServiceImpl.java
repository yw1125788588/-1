package com.imooc.wx.service.Imp;

import com.imooc.wx.entity.SysUserRole;
import com.imooc.wx.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    public List<SysUserRole> listByUserId(Integer userId) {
        return sysUserRoleService.listByUserId(userId);
    }
}
