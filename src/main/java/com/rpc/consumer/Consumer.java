package com.rpc.consumer;

import com.rpc.framework.Invocation;
import com.rpc.framework.ProxyFactory;
import com.rpc.framework.URL;
import com.rpc.protocol.http.HttpClient;
import com.rpc.provider.api.HelloService;
import com.rpc.register.support.Registry;

/**
 * @author dongsufeng
 * @create 2018/11/2 16:41
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class,"");
        System.out.println(helloService.sayHello("ddssaafsdfsdf"));

    }
}
