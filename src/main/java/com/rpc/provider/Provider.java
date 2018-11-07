package com.rpc.provider;

import com.rpc.framework.Protocol;
import com.rpc.framework.ProtocolFactory;
import com.rpc.framework.URL;
import com.rpc.protocol.http.HttpServer;
import com.rpc.provider.api.HelloService;
import com.rpc.provider.impl.HelloServiceImpl;
import com.rpc.register.support.Registry;

/**
 * @author dongsufeng
 * @create 2018/11/2 15:57
 */
public class Provider {

    public static void main(String[] args) {
        //注册服务
        String name="dubbo";
        URL url=new URL("127.0.0.1",8080,name);
        Registry registry=new Registry() ;
        registry.register(HelloService.class.getName(),url, HelloServiceImpl.class);

        //启动容器tomcat,netty
        Protocol protocol = ProtocolFactory.getProtocol(name);
        protocol.start(url);
    }
}
