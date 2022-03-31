package com.alibaba.raise.exception;

/**
 * parkerJ
 * 2021/10/24
 * description：账号已经存在异常类
 * function：
 */
public class LoginActExistException extends RuntimeException {
    public LoginActExistException(String message) {
        super(message);
    }
}
