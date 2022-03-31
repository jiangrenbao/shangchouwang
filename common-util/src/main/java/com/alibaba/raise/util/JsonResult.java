package com.alibaba.raise.util;

/**
 * parkerJ
 * 2021/10/22
 * description：
 * function：ajax请求返回返回结果类
 */
public class JsonResult {
    private static final String SUCCESS_CODE = "1";
    private static final String FAIL_CODE = "0";
    private boolean result;
    private String message;
    private String code;
    private Object data;

    public static JsonResult success(Object data){
       return new JsonResult(true, "success",SUCCESS_CODE,data);
    }

    public static JsonResult fail(String message){
        return new JsonResult(true, message,FAIL_CODE);
    }

    public JsonResult() {
    }

    public JsonResult(boolean result, String message, String code) {
        this.result = result;
        this.message = message;
        this.code = code;
    }

    public JsonResult(boolean result, String message, String code, Object data) {
        this.result = result;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public JsonResult setResult(boolean result) {
        this.result = result;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public JsonResult setCode(String code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResult setData(Object data) {
        this.data = data;
        return this;
    }
}
