package com.app.base.exception;

import com.app.base.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ninaklaus
 */
@RestControllerAdvice(basePackages = "com.app")
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public Response<Object> serviceExceptionHandler(HttpServletRequest req, BusinessException e) {
        log.info("业务异常:", e);
        return Response.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public Response<Object> exceptionHandler(HttpServletRequest req, Exception e) {
        log.info("未知异常:", e);
        System.out.println("分支管理测试...lkslsk");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        return Response.error(500, "系统异常");
    }
}
