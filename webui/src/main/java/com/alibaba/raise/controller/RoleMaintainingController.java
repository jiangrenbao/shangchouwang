package com.alibaba.raise.controller;

import com.alibaba.raise.service.RoleService;
import com.alibaba.raise.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * parkerJ
 * 2021/10/25
 * description：
 * function：
 * @author jiangrenbao
 */
@Controller
public class RoleMaintainingController {

    @Resource
    private RoleService roleService;

    /**
     * 点击角色维护的功能
     * @param request
     * @return
     * 由于使用ajax传递后端数据,所以不用携带参数返回页面
     */
    @RequestMapping("/role/to/page.html")
    public String toRoleMaintainingPage(HttpServletRequest request) {
        return "role-page";
    }

    @RequestMapping("/role/get/page/info.json")
    @ResponseBody
    public JsonResult getPageInfo(HttpServletRequest request,
                                  @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "3") int pageSize,
                                  @RequestParam(value = "keyword",defaultValue = "") String keyword){
        return roleService.getPageInfo(request,pageNum,pageSize,keyword);
    }

    /**
     * 保存role
     * @param request
     * @return
     */
    @RequestMapping("/role/save.json")
    @ResponseBody
    public JsonResult saveRole(HttpServletRequest request){
        return roleService.saveRole(request);
    }

    /**
     * 根据id更新role
     * @param request
     * @return
     */
    @RequestMapping("/role/update.json")
    @ResponseBody
    public JsonResult updateRole(HttpServletRequest request){
        return roleService.updateRole(request);
    }

    @RequestMapping("/role/remove/by/role/id/array.json")
    @ResponseBody
    public JsonResult deleteRoles(HttpServletRequest request, @RequestBody List<Integer> roleIdList){
        return roleService.deleteRoles(request,roleIdList);
    }

}
