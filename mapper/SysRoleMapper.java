package com.imooc.wx.mapper;


import com.imooc.wx.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface SysRoleMapper {

    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole queryById(Integer id);

    @Select("SELECT * FROM sys_role WHERE name = #{name}")
    Integer selectByName(String userName);

    SysRole selectById(Integer id);
}
