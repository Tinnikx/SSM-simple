package com.springmvc.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * @author Kaixiang Tao
 * @date 2019/7/10
 */
@Configuration
@EnableAspectJAutoProxy
public class MyConfiguration {

    @Bean
    public ConversionService conversionService() {
        return new GenericConversionService();
    }
}
