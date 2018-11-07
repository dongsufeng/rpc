package com.rpc.framework;

import java.io.Serializable;

/**
 * @author dongsufeng
 * @create 2018/11/2 15:32
 */
public class URL implements Serializable{

    private String hostname;
    private Integer port;
    private String protocol;



    public URL() {
    }

    public URL(String hostname, Integer port, String protocol) {
        this.hostname = hostname;
        this.port = port;
        this.protocol = protocol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URL url = (URL) o;

        if (hostname != null ? !hostname.equals(url.hostname) : url.hostname != null) return false;
        if (port != null ? !port.equals(url.port) : url.port != null) return false;
        return protocol != null ? protocol.equals(url.protocol) : url.protocol == null;
    }

    @Override
    public int hashCode() {
        int result = hostname != null ? hostname.hashCode() : 0;
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        return result;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
