package com.alibaba.raise.exception;

/**
 * parkerJ
 * 2021/10/24
 * description：数据库insert方法失败异常类
 * function：
 */
public class SqlInsertFailException  extends RuntimeException{

    public SqlInsertFailException(String message) {
        super(message);
    }
}
