package com.springmvc.demo.exception.resolver;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kaixiang Tao
 * @date 2019/8/22
 */
public class MyExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String name = ex.getClass().getName();
        return null;
    }
}
