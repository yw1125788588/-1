package com.imooc.wx.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysDrug implements Serializable {
    private static final long serialVersionUID =23156488465L;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private Integer id;
    private String drugname;
    private String context;
}
