package com.rpc.protocol.http;

import com.rpc.framework.Invocation;
import com.rpc.framework.Protocol;
import com.rpc.framework.URL;

/**
 * @author dongsufeng
 * @create 2018/11/7 11:08
 */
public class HttpProtocol implements Protocol {
    /**
     * 启动服务
     *
     * @param url
     */
    @Override
    public void start(URL url) {
        HttpServer httpServer=new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());
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
        HttpClient httpClient=new HttpClient();
        String post = httpClient.post(url.getHostname(), url.getPort(), invocation);
        return post;
    }
}
