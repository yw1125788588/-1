package com.imooc.wx.service;

import com.imooc.wx.entity.SysDrug;
import com.imooc.wx.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDrugService {

    Page queryPage(Integer pageno, Integer pagesize) ;

    Integer queryCount();

    List<SysDrug> getDrugs();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysDrug queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysDrug> queryAllByLimit(int offset,int limit);

    /**
     * 新增数据
     *
     * @param sysDrug 实例对象
     * @return 实例对象
     */

    SysDrug insert(SysDrug sysDrug);
    /**
     * 修改数据
     *
     * @param sysDrug 实例对象
     * @return 实例对象
     */

    SysDrug update(@Param("sysDrug") SysDrug sysDrug);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    boolean deleteById(@Param("id") Integer id);

}
