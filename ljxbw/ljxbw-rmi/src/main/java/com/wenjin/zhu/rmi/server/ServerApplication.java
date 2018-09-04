package com.wenjin.zhu.rmi.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @Title:  ServerApplication.java   
 * @Package com.wenjin.zhu.rmi.server   
 * @Description: 服务端（被调用端，执行业务端）启动 
 * @author: wenjin.zhu    
 * @date:   2018年9月4日 上午10:58:36   
 * @version V1.0
 */
public class ServerApplication {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("rmiserver.xml");
		RmiServer server = context.getBean("rmiServerImpl", RmiServer.class);
		System.out.println("Server is Running !!!");
	}
}
