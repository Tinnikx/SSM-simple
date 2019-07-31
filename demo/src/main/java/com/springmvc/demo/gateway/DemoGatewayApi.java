package com.springmvc.demo.gateway;

import com.springmvc.demo.annotation.Gateway;

import org.springframework.stereotype.Component;

/**
 * @author Kaixiang Tao
 * @date 2019/7/31
 */
@Component
@Gateway
public class DemoGatewayApi {

    public String get1() {
        return "123";
    }
}
