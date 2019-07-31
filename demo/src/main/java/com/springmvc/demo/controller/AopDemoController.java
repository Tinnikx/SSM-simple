package com.springmvc.demo.controller;

import com.springmvc.demo.service.AopDemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kaixiang Tao
 * @date 2019/7/31
 */
@Controller
public class AopDemoController {

    private Integer count = 1;

    @Autowired
    private AopDemoService aopDemoService;

    @GetMapping("/aop/based_on_annotation")
    @ResponseBody
    public String annotationAop() {
        if (count == 1) {
            count++;
            throw new ArrayIndexOutOfBoundsException("OutOfBounds");
        }
        return aopDemoService.add(5, 6);
    }
}
