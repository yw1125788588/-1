package com.imooc.wx.service.Imp;

import com.imooc.wx.entity.SysDrug;
import com.imooc.wx.mapper.SysDrugMapper;
import com.imooc.wx.service.SysDrugService;
import com.imooc.wx.util.Page;

import javax.annotation.Resource;
import java.util.List;

public class SysDrugServiceImp implements SysDrugService {
    @Resource
    private SysDrugMapper sysDrugMapper;


    public Page queryPage(Integer pageno, Integer pagesize) {
        Page page = new Page(pageno, pagesize);
        Integer startIndex = page.getStartIndex();
       List<SysDrug> Dates = SysDrugMapper.queryList(startIndex,pagesize);
       int totalsize = SysDrugMapper.queryCount();
       page.setTotalsize(totalsize);
       page.getDates(Dates);
        return page;
    }

    @Override
    public Integer queryCount() {
        return SysDrugMapper.queryCount();
    }

    @Override
    public List<SysDrug> getDrugs() {
        return SysDrugMapper.getDrugs();
    }

    @Override
    public SysDrug queryById(Integer id) {
        return this.sysDrugMapper.queryById(id);
    }

    @Override
    public List<SysDrug> queryAllByLimit(int offset, int limit) {
        return this.sysDrugMapper.queryAllByIdLimit(offset,limit);
    }

    @Override
    public SysDrug insert(SysDrug sysDrug) {
        this.sysDrugMapper.insert(sysDrug);
        return sysDrug;
    }

    @Override
    public SysDrug update(SysDrug sysDrug) {
        SysDrugMapper.update(sysDrug);
        return sysDrug;
    }

    @Override
    public boolean deleteById(Integer id) {
        return SysDrugMapper.deleteById(id)>0;
    }
}
