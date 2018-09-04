package com.wenjin.zhu.rmi.server;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @Title: RmiServerImpl.java
 * @Package com.wenjin.zhu.rmi.server
 * @Description: rmi服务器端（执行端）业务实现类
 * @author: wenjin.zhu
 * @date: 2018年9月4日 上午10:51:48
 * @version V1.0
 */

@Component
public class RmiServerImpl implements RmiServer {

	public void sayHello(String msg) {

		System.err.println(msg + "----->一起说Hi购！");

	}

}
