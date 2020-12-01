package com.hongxing.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Title: EduApplication.java
 * Description: 说明
 * Copyright: Copyright (c) 2020
 *
 * @author jsj
 * @date 2020.11.25
 */
//设置包的扫描范围com.hongxing.*
@SpringBootApplication
@ComponentScan(basePackages = {"com.hongxing"})
public class EduApplication {

    public static void main(String[] args){
        SpringApplication.run(EduApplication.class,args);
    }
}
