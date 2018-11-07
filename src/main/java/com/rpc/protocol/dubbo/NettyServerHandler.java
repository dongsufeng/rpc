package com.rpc.protocol.dubbo;

import com.rpc.framework.Invocation;
import com.rpc.framework.URL;
import com.rpc.register.support.Registry;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;

        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().localAddress();
        Registry  registry=new Registry();
        Class serviceImpl = registry.get(invocation.getInterfaceName(), new URL(insocket.getHostName(), insocket.getPort(),"dubbo"));

        Method method = serviceImpl.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        Object result = method.invoke(serviceImpl.newInstance(), invocation.getParams());

        System.out.println("Netty-------------" + result.toString());
        ctx.writeAndFlush("Netty:" + result);
    }
}
