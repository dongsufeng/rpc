package com.rpc.provider.impl;

import com.rpc.provider.api.HelloService;

/**
 * @author dongsufeng
 * @create 2018/11/2 14:54
 */

public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String name) {

        return "hello "+name;
    }
}
