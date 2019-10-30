package com.imooc.wx.service.Imp;

import com.imooc.wx.entity.SysProject;
import com.imooc.wx.mapper.SysProjectMapper;
import com.imooc.wx.service.SysProjectService;

import javax.annotation.Resource;
import java.util.List;

public class SysProjectServiceImpl implements SysProjectService {
    @Resource
    SysProjectMapper sysProjectMapper;

    @Override
    public SysProject queryById(Integer id) {
        return this.queryById(id);
    }

    @Override
    public List<SysProject> queryAllByLimit(int offset, int limit) {
        return this.queryAllByLimit(offset, limit);
    }

    @Override
    public List<SysProject> queryAll(SysProject sysProject) {
        return this.queryAll(sysProject);
    }

    @Override
    public SysProject insert(SysProject sysProject) {
        this.sysProjectMapper.insert(sysProject);
        return sysProject;
    }


    public boolean deleteById(Integer id) {
        return this.sysProjectMapper.deleteById(id) > 0;
    }


    public SysProject selectByName(String userName) {
        return this.sysProjectMapper.selectByName(userName);
    }
}
