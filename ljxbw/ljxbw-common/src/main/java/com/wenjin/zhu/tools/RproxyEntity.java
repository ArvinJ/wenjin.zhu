package com.wenjin.zhu.tools;

import java.io.Serializable;

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
