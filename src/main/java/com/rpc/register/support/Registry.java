package com.rpc.register.support;

import com.rpc.framework.URL;
import com.rpc.register.RegisterService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongsufeng
 * @create 2018/11/2 15:40
 */
public class Registry implements RegisterService{

    public Registry() {

    }

    /**
     * 咱当服务注册角色,支持一个接口，多地址注册
     * Map<serviceName,Map<地址,serviceImplClass>>
     */
    private static Map<String,Map<URL,Class>> REGISTER=new HashMap<>();

    /**
     * 服务注册
     * @param serviceName
     * @param url
     * @param serviceImplClass
     */
    @Override
    public void register(String serviceName, URL url, Class serviceImplClass){
        Map<URL,Class> map=new HashMap<>();
        map.put(url,serviceImplClass);
        REGISTER.put(serviceName,map);

        saveRegisterToFile();
    }
    private void saveRegisterToFile(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("D:/wklc/temp.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务获取
     * @param serviceName
     * @param url
     * @return
     */
    @Override
    public Class get(String serviceName,URL url){
        REGISTER=getRegisterToFile();
        Class clazz = REGISTER.get(serviceName).get(url);
        return clazz;
    }

    private Map<String,Map<URL,Class>> getRegisterToFile(){
        try {
            FileInputStream fileInputStream=new FileInputStream("D:/wklc/temp.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Map<String, Map<URL, Class>> map = (Map<String, Map<URL, Class>>) objectInputStream.readObject();
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 访问规则
     * @param serviceName
     * @return
     */
    @Override
    public URL random(String serviceName){
        //目前只有一个获取第一条
        REGISTER=getRegisterToFile();
        return REGISTER.get(serviceName).keySet().iterator().next();
    }
}
