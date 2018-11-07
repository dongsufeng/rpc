package com.rpc.protocol.http;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 启动要暴漏的servlet
 * servlet适配器，重写service方法接受request
 * 调用服务
 * 返回结果
 * @author dongsufeng
 * @create 2018/11/2 15:18
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("调用接口=======================");
        HttpServletHandler httpServletHandler=new HttpServletHandler();
        httpServletHandler.handle(req,resp);
    }
}
