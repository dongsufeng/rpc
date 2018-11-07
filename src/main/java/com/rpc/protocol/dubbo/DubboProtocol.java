package com.rpc.protocol.dubbo;

import com.rpc.framework.Invocation;
import com.rpc.framework.Protocol;
import com.rpc.framework.URL;

/**
 * @author dongsufeng
 * @create 2018/11/7 11:37
 */
public class DubboProtocol implements Protocol {
    /**
     * 启动服务
     *
     * @param url
     */
    @Override
    public void start(URL url) {
        NettyServer nettyServer=new NettyServer();
        nettyServer.start(url.getHostname(),url.getPort());
    }

    /**
     * 发送请求
     *
     * @param url
     * @param invocation
     * @return
     */
    @Override
    public String send(URL url, Invocation invocation) {
        NettyClient nettyClient=new NettyClient();
        return nettyClient.send(url.getHostname(),url.getPort(),invocation);
    }
}
