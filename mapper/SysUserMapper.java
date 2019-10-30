package com.imooc.wx.mapper;


import com.imooc.wx.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.management.relation.Role;
import java.security.Permission;
import java.util.List;

@Mapper
public interface SysUserMapper {

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);

    SysUser insert(SysUser sysUser);

    SysUser update(SysUser sysUser);

    List<Role> queryAllsysRole();

    List<Integer> queryRoleByUserid(Integer id);

    List<SysUser> queryAllByLimit(int offset, int limit);

    List<Integer> querPermissionByUserid(Integer id);

    List<Permission> queryAllsysPermission();

    List<SysUser> selectUser();
}
