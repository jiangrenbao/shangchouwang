package com.alibaba.raise.service.impl;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.raise.constant.RaiseConstant;
import com.alibaba.raise.entity.Admin;
import com.alibaba.raise.exception.*;
import com.alibaba.raise.mapper.AdminMapper;
import com.alibaba.raise.service.AdminService;
import com.alibaba.raise.util.RaiseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.executor.ErrorContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;


    /**
     * 根据用户名与密码查询admin
     *
     * @param loginAct
     * @param loginPwd
     * @return
     */
    @Override
    public Admin queryAdminByLoginActAndPwd(String loginAct, String loginPwd) {
        // md5解密
        loginPwd = RaiseUtil.md5(loginPwd);
        Admin admin = adminMapper.queryAdminByLoginActAndPwd(loginAct, loginPwd);
        if (admin != null) {
            return admin;
        } else {
            // 抛出登陆失败异常
            throw new LoginFailedException(RaiseConstant.LOGIN_FAIL);
        }
    }

    /**
     * 分页查询admin数据
     *
     * @param keyWord
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Admin> getPageInfo(String keyWord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> adminList = adminMapper.getPageInfo(keyWord);
        return new PageInfo<>(adminList);
    }

    /**
     * admin数据删除功能
     *
     * @param adminId
     * @param pageNum
     * @param keyWord
     */
    @Override
    public String deleteById(String adminId, int pageNum, String keyWord) {
        int result = adminMapper.deleteById(adminId);
        if (result > 0) {
            // 如果请求转发,会再一次执行删除的SQL
            return "redirect:/admin/get/page.html?keyWord=" + keyWord + "&pageNum=" + pageNum;
        } else {
            throw new DataDeleteException(RaiseConstant.SQL_DELETE_FAIL);
        }
    }

    /**
     * 新增admin功能
     *
     * @param admin
     * @return
     */
    @Override
    public String saveAdmin(HttpServletRequest request, Admin admin) {
        // 判断用户是否是否填入数据
        if (StringUtils.isEmpty(admin.getLoginAct()) ||
                StringUtils.isEmpty(admin.getUserPwd()) ||
                StringUtils.isEmpty(admin.getUserName()) ||
                StringUtils.isEmpty(admin.getEmail())) {
            throw new RuntimeException(RaiseConstant.MESSAGE_STRING_INVALIDATE);
        } else {
            // 判断用户注册时输入的账号是否已经存在
            int result = adminMapper.queryAdminByLoginAct(admin.getLoginAct());
            if (result > 0) {
                throw new LoginActExistException(RaiseConstant.LOGIN_ACT_EXIST);
            } else {
                // admin新增一条数据
                admin.setUserPwd(RaiseUtil.md5(admin.getUserPwd()));
                admin.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                result = adminMapper.insertAdmin(admin);
                if (result < 1) {
                    // 如果新增失败,抛出异常
                    throw new SqlInsertFailException(RaiseConstant.SQL_INSERT_FAIL);
                } else {
                    // 返回到数据展示页面
                    return "redirect:/admin/get/page.html";
                }
            }
        }
    }

    /**
     * 跳到编辑页面的功能
     *
     * @param request
     * @return
     */
    @Override
    public String toEditAdmin(HttpServletRequest request) {
        String adminId = request.getParameter("adminId");
        // 判断前端传递的admin的id是否为空,如果是,抛出异常
        if (StringUtils.isEmpty(adminId)) {
            throw new RuntimeException(RaiseConstant.MESSAGE_STRING_INVALIDATE);
        } else {
            Admin admin = adminMapper.getAdminById(adminId);
            request.setAttribute("admin", admin);
            request.setAttribute("pageNum", request.getParameter("pageNum"));
            request.setAttribute("keyWord", request.getParameter("keyWord"));
            return "admin-edit";
        }
    }

    /**
     * 更新admin的功能
     *
     * @param request
     * @return
     */
    @Override
    public String updateAdmin(HttpServletRequest request, Admin admin) {
        String originUserName = request.getParameter("originUserName");
        String originEmail = request.getParameter("originEmail");
        String pageNum = request.getParameter("pageNum");
        String keyword = request.getParameter("keyWord");
        String originAct = request.getParameter("originAct");
        String loginAct = admin.getLoginAct();
        String userName = admin.getUserName();
        String email = admin.getEmail();
        // 判断用户输入的参数是否有空值
        if (StringUtils.isEmpty(loginAct) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(email)) {
            throw new RuntimeException(RaiseConstant.MESSAGE_STRING_INVALIDATE);
            // 判断是否有更新
        } else if (loginAct.equals(originAct) && userName.equals(originUserName) && email.equals(originEmail)) {
            throw new RuntimeException("请至少修改一条数据");
            // 判断用户名是否更新,如果更新了,判断更新的新用户名数据库中是否有,如果有,报异常,跳到system-error.jsp页面
        } else if (!loginAct.equals(originAct) && adminMapper.queryAdminByLoginAct(loginAct) > 0) {
            throw new RuntimeException(RaiseConstant.LOGIN_ACT_EXIST);
            // 判断是否更新成功
        } else if (adminMapper.updateAdmin(admin) < 1) {
            throw new SqlUpdataException(RaiseConstant.SQL_UPDATE_FAIL);
        } else {
            return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyWord=" + keyword;
        }
    }
}
