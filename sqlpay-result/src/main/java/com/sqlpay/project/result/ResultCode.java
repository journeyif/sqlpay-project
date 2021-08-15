package com.sqlpay.project.result;

import java.util.stream.Stream;

/**
 * 返回值枚举
 *
 * @author xiangy
 */

public enum ResultCode {

    /**
     * 操作成功
     **/
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    FAIL(-200, "操作失败"),

    /**
     * 服务异常
     **/
    UNKNOWN(-1, "正体不明");


    /**
     * 自定义状态码
     **/
    private final int code;
    /**
     * 自定义描述
     **/
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据 code 获取枚举
     */
    public static ResultCode of(int code) {
        return Stream.of(values())
                .filter(bean -> bean.code == code)
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }
}