package com.imooc.wx.service;

import com.imooc.wx.entity.SysUser;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import java.security.Permission;
import java.util.List;

public interface SysUserService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser    selectById(Integer id);

    SysUser selectByName(String name);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    List<Role> queryAllsysRole();

    List<Integer> queryRoleByUserid(Integer id);

    List<Permission> queryAllsysPermission();

    List<Integer> querPermissionByUserid(Integer id);

    List<SysUser> selectUser();

    boolean batchImport(String fileName, MultipartFile file);
}
