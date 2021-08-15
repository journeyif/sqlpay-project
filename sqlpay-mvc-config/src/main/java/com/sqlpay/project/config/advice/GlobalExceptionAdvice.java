package com.sqlpay.project.config.advice;

import com.sqlpay.project.result.ResultCode;
import com.sqlpay.project.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获处理
 *
 * @author xiangy
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 默认全局异常处理
     *
     * @param exception the exception
     * @return the result data
     */
    @ExceptionHandler(value = Exception.class)
    public ResultData<String> handlerCommerceException(Exception exception) {
        log.error("Exception error: [{}]", exception.getMessage(), exception);
        return ResultData.fail(ResultCode.UNKNOWN.getCode(), exception.getMessage());
    }
}
