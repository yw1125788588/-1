package com.imooc.wx.service.Imp;

import com.imooc.wx.entity.SysEmploy;
import com.imooc.wx.mapper.SysEmployMapper;
import com.imooc.wx.service.SysEmployService;

import javax.annotation.Resource;
import java.util.List;

public  class SysEmployServiceImp implements SysEmployService {
   @Resource
    private SysEmployMapper sysEmployMapper;

    @Override
    public SysEmploy queryById(Integer id) {
        return (this.queryById(id));
    }

    @Override
    public List<SysEmploy> queryAllByLimit(int offset, int limit) {
        return (this.queryAllByLimit(offset, limit));
    }

    @Override
    public SysEmploy queryAll(SysEmploy sysEmploy) {
        return (this.queryAll(sysEmploy));
    }

    @Override
    public int deleteById() {
        return 0;
    }


}
