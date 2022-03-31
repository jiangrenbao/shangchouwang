package com.alibaba.raise.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.raise.constant.RaiseConstant;
import com.alibaba.raise.entity.Role;
import com.alibaba.raise.exception.SqlInsertFailException;
import com.alibaba.raise.mapper.RoleMapper;
import com.alibaba.raise.service.RoleService;
import com.alibaba.raise.util.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.panel.AbstractRadioPropertyGroup;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * parkerJ
 * 2021/10/25
 * description：
 * function：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * role分页查询
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public JsonResult getPageInfo(HttpServletRequest request, int pageNum, int pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = null;
        try {
            roleList = roleMapper.getPageInfo(keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return new JsonResult(true, "success", "1", pageInfo);
    }

    /**
     * 新增admin
     *
     * @param request
     * @return
     */
    @Override
    public JsonResult saveRole(HttpServletRequest request) {
        String roleName = request.getParameter("name");
        int result = roleMapper.queryNameByName(roleName);
        if (result > 0) {
            // throw new RuntimeException(roleName + "已经存在");
            return JsonResult.fail("账号已经存在");
        } else {
            result = roleMapper.saveRole(roleName);
            if (result < 1) {
                throw new SqlInsertFailException(RaiseConstant.SQL_INSERT_FAIL);
            } else {
                return JsonResult.success(roleName);
            }
        }
    }

    /**
     * 更新role
     *
     * @param request
     * @return
     */
    @Override
    public JsonResult updateRole(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(name)) {
            return JsonResult.fail("不能为空值");
        } else {
            if (roleMapper.updateRoleByid(id, name) < 1) {
                return JsonResult.fail("修改失败");
            } else {
                return JsonResult.success(name);
            }
        }
    }

    @Override
    public JsonResult deleteRoles(HttpServletRequest request, List<Integer> roleIdList) {
        if (roleMapper.deleteRoles(roleIdList) < 1) {
            return JsonResult.fail("删除失败");
        } else {
            return JsonResult.success("success");
        }
    }
}
