package com.wenjin.zhu.entity;

import java.io.Serializable;
/**
 * 
 * 
 * @Title:  RproxyEntity.java   
 * @Package com.wenjin.zhu.entity   
 * @Description:    TODO(代理ip 和 port)   
 * @author: wenjin.zhu    
 * @date:   2018年8月20日 下午2:12:25   
 * @version V1.0
 */
public class RproxyEntity implements Serializable {

	private static final long serialVersionUID = 2675657365429757311L;
	private String ip;
	private String port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public RproxyEntity() {
	}

	public RproxyEntity(String ip, String port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public String toString() {
		return "RproxyEntity [ip=" + ip + ", port=" + port + "]";
	}

}
