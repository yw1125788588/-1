package com.imooc.wx.util;

import com.imooc.wx.entity.SysDrug;
import lombok.Data;

import java.util.List;
@Data
public class Page {
    private int pageno;
    private int pagesize;
    private List dates;
    private int totalno;
    private int totalsize;

    public Page(Integer pageno,Integer pagesize){
        if(pageno<=0){
            this.pageno=1;
        }else {
            this.pageno=pageno;
        }
        if(pagesize<=0){
            this.pagesize = 10;
        }else {
            this.pagesize = pagesize;
        }
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List getDates(List<SysDrug> dates) {
        return this.dates;
    }

    public void setDates(List dates) {
        this.dates = dates;
    }

    public int getTotalno() {
        return totalno;
    }

    private void setTotalno(int totalno) {
        this.totalno = totalno;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
        this.totalno = (totalsize%pagesize)==0?(totalsize/pagesize):(totalsize/pagesize+1);
    }
    public Integer startIndex(){
        return (this.pageno-1)*pagesize;
    }

    public Integer getStartIndex() {
        return (this.pageno-1)*pagesize;
    }
}
