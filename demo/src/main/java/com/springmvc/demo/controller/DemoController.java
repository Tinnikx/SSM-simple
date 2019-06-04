package com.springmvc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kaixiang Tao
 * @date 2019/6/4
 */
@RestController
public class DemoController {

    @RequestMapping("hello")
    public String index(){
        return "Hello";
    }
}
