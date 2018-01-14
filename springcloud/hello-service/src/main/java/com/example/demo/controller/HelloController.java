/**
 * sinafenqi.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lisong
 * @version $Id: HelloController.java, v 0.1 2017-12-12 14:06 lisong Exp $$
 */
@RestController
public class HelloController {

    /**
     * 从配置中心获取配置注入
     */
    @Value("${config.param}")
    private String CONFIG_PARAM;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        /*ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        System.out.println(instance.toString());
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        System.out.println("sleepTime:" + sleepTime);*/
        return CONFIG_PARAM;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name) {
        return "Hello," + name;
    }
}
