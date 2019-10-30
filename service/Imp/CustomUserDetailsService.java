package com.imooc.wx.service.Imp;


import com.imooc.wx.entity.SysRole;
import com.imooc.wx.entity.SysUser;
import com.imooc.wx.entity.SysUserRole;
import com.imooc.wx.service.SysUserRoleService;
import com.imooc.wx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        //从数据库中取出用户信息
        SysUser user = sysUserService.selectByName(username);
        //判断用户是否存在
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //添加权限
        List<SysUserRole> userRoles = sysUserRoleService.listByUserId(user.getId());
        for (SysUserRole userRole:userRoles) {
            SysRole role = sysRoleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(user.getName(),user.getPassword(),authorities);
    }
}
