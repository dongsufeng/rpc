package com.rpc.register;

import com.rpc.framework.URL;

public interface RegisterService {

    /**
     * 服务注册
     * @param serviceName
     * @param url
     * @param serviceImplClass
     */
    void register(String serviceName, URL url,Class serviceImplClass);

    /**
     * 服务获取
     * @param serviceName
     * @param url
     * @return
     */
    Class get(String serviceName,URL url);

    /**
     * 访问规则
     * @param serviceName
     * @return
     */
    URL random(String serviceName);
}
