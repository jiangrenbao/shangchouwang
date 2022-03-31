package com.alibaba.raise.controller;

import com.alibaba.raise.entity.Admin;
import com.alibaba.raise.service.AdminService;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * parkerJ
 * 2021/10/24
 * description：用户维护controller
 * function：
 */
@Controller
public class UserMaintenanceController {

    @Resource
    private AdminService adminService;

    /**
     * 点击用户维护按钮的功能
     * @param request
     * @return admin-page.jsp
     */
    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(HttpServletRequest request,
                              @RequestParam(value = "keyWord",defaultValue = "") String keyWord,
                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "3") int pageSize){
        PageInfo<Admin> adminInfo = adminService.getPageInfo(keyWord, pageNum, pageSize);
        request.setAttribute("adminInfo", adminInfo);
        return "admin-page";
    }

    /**
     * 点击删除的功能
     * @param request
     * @param adminId
     * @param pageNum
     * @param keyWord
     * @return
     */
    @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyWord}.html")
    public String deleteById(HttpServletRequest request,@PathVariable("adminId") String adminId,
                                                        @PathVariable("pageNum") int pageNum,
                                                        @PathVariable("keyWord") String keyWord){
       return adminService.deleteById(adminId, pageNum, keyWord);
    }


    /**
     * 跳转到admin新增页面
     * @param request
     * @return
     */
    @RequestMapping("/admin/to/add/page.html")
    public String addPage(HttpServletRequest request){
        return "admin-add";
    }

    /**
     * 跳转到admin编辑页面的功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/save.html")
    public String saveAdmin(HttpServletRequest request,Admin admin) {
        return adminService.saveAdmin(request, admin);
    }

    /**
     * 跳到编辑页面的功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/to/edit/page.html")
    public String toEditAdmin(HttpServletRequest request){
       return adminService.toEditAdmin(request);
    }

    /**
     * 更新admin的功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/update.html")
    public String updateAdmin(HttpServletRequest request,Admin admin){
        return adminService.updateAdmin(request,admin);
    }
}
