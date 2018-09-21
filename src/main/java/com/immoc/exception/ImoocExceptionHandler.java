package com.immoc.exception;

import com.immoc.pojo.JsonResult;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 捕获异常 有异常都会经过这个处理类
 */
@ControllerAdvice
public class ImoocExceptionHandler {

    public static final String ERROR_VIEW = "thymeleaf/error";

    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;
//
////    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
//        e.printStackTrace();
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", request.getRequestURL());
//        mav.setViewName(ERROR_VIEW);
//        System.out.println(ERROR_VIEW);
//        return mav;
//    }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws Exception {
        e.printStackTrace();

        if (isAjax(request)) {
            JsonResult result = JsonResult.errorException(e.getMessage());
            jsonConverter.write(result, MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));
            return null;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 该方法用来判断请求是否是ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null);
    }
}
