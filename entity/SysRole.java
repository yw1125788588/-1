package com.imooc.wx.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;
    private Integer id;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
