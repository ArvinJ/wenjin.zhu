package com.wenjin.zhu.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenjin.zhu.dubbo.provider.DubboService;

public class Consumer {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubboclient.xml" });
		context.start();

		DubboService dubboService = (DubboService) context.getBean("dubboService");
		String hello = dubboService.sayHello("dubbo");
		System.out.println(hello);

		System.in.read();
	}
}
