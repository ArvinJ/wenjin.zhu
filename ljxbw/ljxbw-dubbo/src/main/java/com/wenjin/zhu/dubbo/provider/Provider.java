package com.wenjin.zhu.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubboserver.xml" });
		context.start();

		System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
	}

}
