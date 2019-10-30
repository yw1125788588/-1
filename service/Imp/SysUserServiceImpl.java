package com.imooc.wx.service.Imp;


import com.imooc.wx.entity.SysUser;
import com.imooc.wx.mapper.SysUserMapper;
import com.imooc.wx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import java.security.Permission;
import java.util.List;

@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return sysUserMapper.selectByName(name);
    }

    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return sysUserMapper.queryAllByLimit(offset, limit);
    }

    @Override
    public SysUser insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser update(SysUser sysUser) {
        return sysUserMapper.update(sysUser);
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public List<Role> queryAllsysRole() {
        return sysUserMapper.queryAllsysRole();
    }

    @Override
    public List<Integer> queryRoleByUserid(Integer id) {
        return sysUserMapper.queryRoleByUserid(id);
    }

    @Override
    public List<Permission> queryAllsysPermission() {
        return sysUserMapper.queryAllsysPermission();
    }

    @Override
    public List<Integer> querPermissionByUserid(Integer id) {
        return sysUserMapper.querPermissionByUserid(id);
    }

    @Override
    public List<SysUser> selectUser() {return sysUserMapper.selectUser(); }

    @Override
    public boolean batchImport(String fileName, MultipartFile file) { return false; }

}
