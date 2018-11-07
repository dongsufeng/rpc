package com.rpc.framework;

import com.rpc.protocol.dubbo.DubboProtocol;
import com.rpc.protocol.http.HttpProtocol;

/**
 * 协议工厂
 * @author dongsufeng
 * @create 2018/11/7 11:12
 */
public class ProtocolFactory {
    /**
     * 根据协议名称获取
     * @param protocolname
     * @return
     */
    public static Protocol getProtocol(String protocolname){
        System.out.println("协议名===="+protocolname);
        switch (protocolname){
            case "dubbo":{
                return new DubboProtocol();
            }
            case "http":{
                return new HttpProtocol();
            }
            default:{
                break;
            }
        }
        return new HttpProtocol();
    }
}
