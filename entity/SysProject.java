package com.imooc.wx.entity;

public class SysProject {

    private Integer id;
    private Integer roleid;
    private int creattinme;
    private String plan;
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getCreattinme() {
        return creattinme;
    }

    public void setCreattinme(int creattinme) {
        this.creattinme = creattinme;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
