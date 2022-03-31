package com.alibaba.raise.mapper;


import com.alibaba.raise.entity.Admin;
import com.alibaba.raise.entity.AdminExample;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminMapper {

    /**
     * 根据用户名与密码查询admin
     * @param loginAct
     * @param loginPwd
     * @return
     */
    Admin queryAdminByLoginActAndPwd(@Param("loginAct") String loginAct, @Param("loginPwd") String loginPwd);

    /**
     * 分页查询admin数据
     * @param keyWord
     * @return
     */
    List<Admin> getPageInfo(@Param("keyWord") String keyWord);


    /**
     * admin数据删除功能
     * @param adminId

     */
    int deleteById(@Param("adminId") String adminId);


    /**
     * 根据用户名查询用户
     * @param loginAct
     * @return
     */
    int  queryAdminByLoginAct(@Param("loginAct") String loginAct);

    /**
     * 新增一条admin
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 根据id获取admin
     * @param adminId
     * @return
     */
    Admin getAdminById(@Param("adminId") String adminId);

    /**
     * 更新admin
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);
}