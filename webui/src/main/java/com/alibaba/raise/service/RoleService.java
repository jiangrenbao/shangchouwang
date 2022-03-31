package com.alibaba.raise.service;

import com.alibaba.raise.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * parkerJ
 * 2021/10/25
 * description：
 * function：
 */
public interface RoleService {

    /**
     * role分页查询
     * @param request
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    JsonResult getPageInfo(HttpServletRequest request, int pageNum, int pageSize, String keyword);

    /**
     * 新增admin
     * @param request
     * @return
     */
    JsonResult saveRole(HttpServletRequest request);


    /**
     * 更新role
     * @param request
     * @return
     */
    JsonResult updateRole(HttpServletRequest request);

    /**
     * 批量删除role
     * @param request
     * @return
     */
    JsonResult deleteRoles(HttpServletRequest request, List<Integer> roleIdList);
}
