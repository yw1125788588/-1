package com.imooc.wx.Controller;

import com.imooc.wx.entity.SysUser;
import com.imooc.wx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.Role;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    SysUserService sysUserService;
    //用户模块
    @GetMapping("/userManage")
    public String sysUser() {
        SysUser sysUser = sysUserService.selectByName("name");
        return "/userManage.html";
    }

    //角色模块
    @RequestMapping("")
    public String sysRole(Integer id, Map map){
        List<Role> allListRole = sysUserService.queryAllsysRole();
        List<Integer> roleIds =sysUserService.queryRoleByUserid(id);


        List<Role> leftRoleList = new ArrayList<Role>();//未分配角色
        List<Role> rightRoleList = new ArrayList<Role>();//以分配角色

        for (Role role : allListRole) {
            if (roleIds.contains(role.getClass())){//有问题获取不到id
                rightRoleList.add(role);
            }else {
                leftRoleList.add(role);
            }

        }
        map.put("rightRoleList",rightRoleList);
        map.put("leftRoleList",leftRoleList);
        return "";
    }
    //权限模块
    @RequestMapping("")
    public String sysPermission(Integer id,Map map){
        List<Permission> allListPermission = sysUserService.queryAllsysPermission();
        List<Integer> permissionIds = sysUserService.querPermissionByUserid(id);

        List<Permission> leftPermissionList = new ArrayList<>();//未分配权限
        List<Permission> rightPermisssionList = new ArrayList<>();//已经分配权限

        for (Permission permission: allListPermission) {
            if (permissionIds.contains(permission.getClass())){
                rightPermisssionList.add(permission);
            }else{
                leftPermissionList.add(permission);
            }

        }
        map.put("rightPermisssionList",rightPermisssionList);
        map.put("leftPermissionList",leftPermissionList);
        return "";
    }


}