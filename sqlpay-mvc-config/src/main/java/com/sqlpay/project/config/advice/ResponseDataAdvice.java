package com.sqlpay.project.config.advice;

import com.sqlpay.project.config.annotation.IgnoreResponseAdvice;
import com.sqlpay.project.result.ResultData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 实现统一响应
 *
 * @author xiangy
 */
@SuppressWarnings("all")
@RestControllerAdvice(value = "com.sqlpay")
public class ResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要对响应进行处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {

        // controller无需处理
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 方法无需处理
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (null == o) {
            // 如果返回值为null,直接返回0
            return ResultData.fail(0, "");
        } else if (o instanceof ResultData) {
            // ResultData直接返回
            return o;
        } else {
            // 封装自定义返回结果
            return ResultData.success(o);
        }
    }
}
