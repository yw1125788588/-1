package com.imooc.wx.mapper;

import com.imooc.wx.entity.SysDrug;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysDrugMapper {
    /*
    分页查询
     */
    static List<SysDrug> queryList(Integer startIndex, Integer pagesize) {
        return null;
    }

    static List<SysDrug> getDrugs() {
        return null;
    }

    static Integer queryCount() {
        return null;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysDrug queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysDrug> queryAllByIdLimit(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDrug 实例对象
     * @return 对象列表
     */
    @Select("select * from  sysDrug")
    List<SysDrug> queryAll(SysDrug sysDrug);
    /**
     * 新增数据
     *
     * @param sysDrug 实例对象
     * @return 影响行数
     */
    @Insert("insert into sysDrug(drugname,context),value(#{name},#{context})")
    int insert(SysDrug sysDrug);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("deleteById from sysDrug where sysDrugId = #{id}")
    static int deleteById(Integer id) {
        return 0;
    }

    /**
     * 根据药品名查询药品
     *
     * @param drugName
     * @return
     */
    SysDrug selectByName(String drugName);

    /**
     * 修改数据
     *
     * @param sysDrug 实例对象
     * @return 影响行数
     */
    @Update("update set drugname = #{sysDrug.durgname}，context = #{sysDrug.context}")
    static void update(SysDrug sysDrug) {

    }


}

