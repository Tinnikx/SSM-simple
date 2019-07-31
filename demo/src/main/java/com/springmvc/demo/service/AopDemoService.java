package com.springmvc.demo.service;

import com.springmvc.demo.gateway.DemoGatewayApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kaixiang Tao
 * @date 2019/7/31
 */
@Service
public class AopDemoService {

    private Integer count = 0;

    @Autowired
    private DemoGatewayApi demoGatewayApi;

    public String add(Integer i, Integer j) {
        if (count % 2 == 0) {
            count++;
            return String.valueOf(i + j);
        } else {
            count++;
            return demoGatewayApi.get1();
        }
    }
}
