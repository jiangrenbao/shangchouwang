package com.alibaba.raise.mvc.interceptor;

import com.alibaba.raise.constant.RaiseConstant;
import com.alibaba.raise.entity.Admin;
import com.alibaba.raise.exception.RequestRefusedException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * parkerJ
 * 2021/10/24
 * description：
 * function：is a interceptor class of login verify
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute(RaiseConstant.LOGIN_USER);
        if (admin == null) {
            throw new RequestRefusedException(RaiseConstant.MESSAGE_NEED_LOGIN);
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
