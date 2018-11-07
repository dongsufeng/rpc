package com.rpc.framework;

/**
 * 协议接口
 * @author dongsufeng
 * @create 2018/11/7 11:05
 */
public interface Protocol {
    /**
     * 启动服务
     * @param url
     */
    void start(URL url);

    /**
     * 发送请求
     * @param url
     * @param invocation
     * @return
     */
    String send(URL url,Invocation invocation);
}
