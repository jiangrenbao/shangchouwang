package com.alibaba.raise.mvc.config;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.raise.constant.RaiseConstant;
import com.alibaba.raise.exception.*;
import com.alibaba.raise.util.JsonResult;
import com.alibaba.raise.util.RaiseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/**
 * class: 异常处理器类
 * @ControllerAdvice: 表示当前类是一个基于注解的异常处理器类 attention：component-scan need to scan this class
 */
@ControllerAdvice
public class RaiseExceptionResolver {

    /**
     * 发生SqlUpdataException异常时执行的方法
     *
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = SqlUpdataException.class)
    public ModelAndView resolveSqlUpdataException(
            SqlUpdataException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String viewName = "system-error";
        // String viewName = "system-edit";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 发生SqlInsertFailException异常时执行的方法
     *
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = SqlInsertFailException.class)
    public ModelAndView resolveSqlInsertFailException(
            SqlInsertFailException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String viewName = "system-error";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 发生LoginActExistException异常时执行的方法
     *
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = LoginActExistException.class)
    public ModelAndView resolveLoginActExistException(
            LoginActExistException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String viewName = "admin-add";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 发生LoginFailedException异常时执行的方法
     *
     * @param exception LoginFailedException
     * @param request
     * @param response
     * @return errorPage
     * @throws IOException
     * @ExceptionHandler将一个具体的异常类型和一个方法关联起来
     */
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolveLoginFailedException(
            LoginFailedException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String viewName = "admin-login";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 发生RequestRefusedException异常时执行的方法
     *
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = RequestRefusedException.class)
    public ModelAndView resolveRequestRefusedException(
            RequestRefusedException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String viewName = "admin-login";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 发生DataDeleteException异常时执行的方法
     *
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = DataDeleteException.class)
    public ModelAndView resolveDataDeleteException(
            DataDeleteException exception,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String viewName = "system-error";
        return commonResolve(viewName, exception, request, response);
    }


    /**
     * 核心异常处理方法
     *
     * @param viewName  异常处理完成后要去的页面
     * @param exception 实际捕获到的异常类型
     * @param request   当前请求对象
     * @param response  当前响应对象
     * @return
     * @throws IOException
     */
    private ModelAndView commonResolve(String viewName,
                                       Exception exception,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws IOException {

        // 判断当前请求类型
        boolean judgeResult = RaiseUtil.judgeRequestType(request);
        // 如果是Ajax请求
        if (judgeResult) {
            JsonResult jsonResult = JsonResult.fail(exception.getMessage());
            String json = new Gson().toJson(jsonResult);
            response.getWriter().write(json);
            return null;
        }
        // 如果是普通请求
        ModelAndView modelAndView = new ModelAndView();
        // 将Exception对象存入模型
        modelAndView.addObject(RaiseConstant.EXCEPTION, exception);
        // 设置对应的视图名称
        modelAndView.setViewName(viewName);
        // 返回modelAndView对象
        return modelAndView;
    }
}
