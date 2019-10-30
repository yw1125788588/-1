package com.imooc.wx.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    private Integer userId;
    private Integer roleId;


}
