package com.rpc.protocol.http;

import com.rpc.framework.Invocation;
import com.rpc.framework.URL;
import com.rpc.register.support.Registry;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * servlet处理，可利用反射
 * @author dongsufeng
 * @create 2018/11/2 16:12
 */
public class HttpServletHandler {

    public void handle(HttpServletRequest request, HttpServletResponse response){
        try {
            InputStream inputStream=request.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            Registry registry=new Registry();
            Class clazz = registry.get(invocation.getInterfaceName(), new URL(request.getLocalName(), request.getLocalPort(),"http"));
            Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            Object result = method.invoke(clazz.newInstance(), invocation.getParams());
            if(result instanceof String){
                OutputStream outputStream=response.getOutputStream();
                IOUtils.write(result.toString(),outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
