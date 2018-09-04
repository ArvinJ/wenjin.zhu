package com.wenjin.zhu.tools;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import net.sf.json.JSONObject;

/**
 * 
 * 
 * @Title: ProxyIpAndPort.java
 * @Package org.cybercafe.api.utils
 * @Description: TODO(反向代理ip和port)
 * @author: wenjin.zhu
 * @date: 2018年8月15日 上午10:32:33
 * @version V1.0
 */
public class ProxyIpAndPort {
	public static Logger logger = (Logger) LoggerFactory.getLogger(ProxyIpAndPort.class);
	public static HashMap<String, Integer> serverWeightMap = new HashMap<String, Integer>();

	public static HashMap<String, Integer> initIpAndPort() {

		int temp22 = 0, temp28 = 0, temp33 = 0, temp34 = 0;

		JSONObject proxyIp22 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8283"));
		JSONObject proxyIp28 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8284"));
		JSONObject proxyIp33 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8285"));
		JSONObject proxyIp34 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8286"));
		// 第一个参数是IP地址,第二个是权重.
		serverWeightMap.put(proxyIp22.toString(), temp22);
		serverWeightMap.put(proxyIp28.toString(), temp28);
		serverWeightMap.put(proxyIp33.toString(), temp33);
		serverWeightMap.put(proxyIp34.toString(), temp34);

		return serverWeightMap;

	}

}
