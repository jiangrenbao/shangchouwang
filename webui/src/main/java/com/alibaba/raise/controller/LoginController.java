package com.alibaba.raise.controller;

import com.alibaba.raise.constant.RaiseConstant;
import com.alibaba.raise.entity.Admin;
import com.alibaba.raise.exception.LoginFailedException;
import com.alibaba.raise.service.AdminService;
import com.alibaba.raise.util.RaiseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * parkerJ
 * 2021/10/23
 * description：
 * function：登陆controller
 */
@Controller
public class LoginController {

    @Resource
    private AdminService adminService;

    /**
     * 跳转到后台管理系统的登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/admin/do/login.html")
    public String login(HttpServletRequest request) {
        return "admin-login";
    }

    /**
     * 后台管理系统登陆功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/background/login.html",method = RequestMethod.POST)
    public String backgroundLogin(HttpServletRequest request) {
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        Admin admin = adminService.queryAdminByLoginActAndPwd(loginAct, loginPwd);
        // 如果能执行到这一步,说明没有抛LoginFailedException异常,说明有该admin用户
        request.getSession().setAttribute(RaiseConstant.LOGIN_USER, admin);
        // 登陆功能的页面跳转,一般用重定向
        return "redirect:/admin/mainpage.html";
    }


    /**
     * 退出账号功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/do/logout.html")
    public String logout(HttpServletRequest request) {
        // 强制session失效
      request.getSession().invalidate();
      return "redirect:/admin/do/login.html";
    }

    @RequestMapping(value = "/admin/test.html")
    public String test(HttpServletRequest request) {
        // 强制session失效
        request.getSession().invalidate();
        return "redirect:/admin/do/login.html";
    }

}
