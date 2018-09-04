/*package com.wenjin.zhu.activemq.integrateSpring;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenjin.zhu.service.activemq.ProducerUrlService;

public class Main {

	@Autowired
	private static ProducerUrlService producerUrlService;
	@Autowired
	private static Destination urlQueueDestination;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		try {
			producerUrlService.sendMessage(urlQueueDestination, "urlTest");
			System.out.println("jms-url-success");
		} catch (Exception e) {
			System.out.println("jms-url-failure" + e.getMessage());
		}
	}
}
*/