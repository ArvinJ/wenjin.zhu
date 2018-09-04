package com.wenjin.zhu.rmi.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenjin.zhu.rmi.server.RmiServer;

/**
 * 
 * 
 * @Title: ClientApplication.java
 * @Package com.wenjin.zhu.rmi.client
 * @Description:客户端远程调用启动
 * @author: wenjin.zhu
 * @date: 2018年9月4日 上午10:47:04
 * @version V1.0
 */
public class ClientApplication {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("rmiclient.xml");
		RmiServer server = context.getBean("rmiProxyFactoryBean", RmiServer.class);
		server.sayHello("静静");
	}
}
