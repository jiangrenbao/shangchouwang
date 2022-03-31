package com.alibaba.raise.exception;

/**
 * parkerJ
 * 2021/10/24
 * description：访问被拒绝异常类
 * function：
 */
public class RequestRefusedException  extends RuntimeException{
    private static final long serialVersionUID = -4422392987529309890L;

    public RequestRefusedException(String message) {
        super(message);
    }
}
