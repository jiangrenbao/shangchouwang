package com.alibaba.raise.service;

import com.alibaba.raise.entity.Admin;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminService {

    /**
     * 根据用户名与密码查询admin
     * @param loginAct
     * @param loginPwd
     * @return
     */
    Admin queryAdminByLoginActAndPwd(String loginAct, String loginPwd);

    /**
     * 分页查询admin数据
     * @param keyWord
     * @return
     */
    PageInfo<Admin> getPageInfo(String keyWord, int pageNum, int pageSize);

    /**
     * admin数据删除功能
     * @param adminId
     * @param pageNum
     * @param keyWord
     */
    String deleteById(String adminId,int pageNum, String keyWord);

    /**
     * 新增admin功能
     * @param admin
     * @return
     */
    String saveAdmin(HttpServletRequest request,Admin admin);


    /**
     * 跳到编辑页面的功能
     * @param request
     * @return
     */
    String toEditAdmin(HttpServletRequest request);

    /**
     * 更新admin的功能
     * @param request
     * @return
     */
    String updateAdmin(HttpServletRequest request,Admin admin);

}
