package com.alibaba.raise.exception;

/**
 * parkerJ
 * 2021/10/24
 * description：数据删除异常类
 * function：
 */
public class DataDeleteException extends RuntimeException {
    public DataDeleteException(String message) {
        super(message);
    }
}
