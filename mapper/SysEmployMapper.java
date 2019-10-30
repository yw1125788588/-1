package com.imooc.wx.mapper;

import com.imooc.wx.entity.SysEmploy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysEmployMapper {
    /**
     * @return
     */
    SysEmployMapper queryById();

    /**
     * @param offset
     * @param limit
     * @return
     */
    List<SysEmployMapper> queryAllByLimit(@Param("offset")int offset,@Param("limit") int limit);

    /**
     * @param
     * @return
     */
    List<SysEmployMapper> queryAll(SysEmploy sysEmploy);

    /**
     * @return
     */
    int deleteById();

    /**
     * @param startIndex
     * @param pagesize
     * @return
     */
    List<SysEmploy> queryList(Integer startIndex, Integer pagesize);

    /**
     * @return
     */


}
