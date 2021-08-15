package com.sqlpay.project.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回值封装
 *
 * @author xiangy
 */
@Data
public class ResultData<T> implements Serializable {

    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 返回参数
     */
    private T data;

    /**
     * 返回时间
     */
    private long timestamp;


    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> ResultData<T> success(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultCode.SUCCESS.getCode());
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> success() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultCode.SUCCESS.getCode());
        resultData.setMessage(ResultCode.SUCCESS.getMessage());
        return resultData;
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultCode.SUCCESS.getCode());
        resultData.setMessage(ResultCode.SUCCESS.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultCode.FAIL.getCode());
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> fail() {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ResultCode.FAIL.getCode());
        resultData.setMessage(ResultCode.FAIL.getMessage());
        return resultData;
    }

}