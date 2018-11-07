package com.rpc.framework;

import com.rpc.protocol.http.HttpClient;
import com.rpc.protocol.http.HttpProtocol;
import com.rpc.register.support.Registry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂执行业务方法
 * @author dongsufeng
 * @create 2018/11/2 16:52
 */
public class ProxyFactory {
    public static <T> T getProxy(final Class interfaceClass,final String protocolname){
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Registry registry=new Registry();
                URL url = registry.random(interfaceClass.getName());
                Invocation invocation=new Invocation(interfaceClass.getName(),method.getName(),args,method.getParameterTypes());
                Protocol protocol=null;
                if(null == protocolname || "".equals(protocolname)){
                    protocol= ProtocolFactory.getProtocol(url.getProtocol());
                }else {
                    protocol=ProtocolFactory.getProtocol(protocolname);
                }
                String result = protocol.send(url, invocation);
                System.out.println("返回结果==="+result);
                return result;
            }
        });
    }
}
