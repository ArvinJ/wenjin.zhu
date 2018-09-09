package com.wenjin.zhu.webservice.publish;

import javax.xml.ws.Endpoint;

public class WebServicePublish {
	public static void main(String[] args) {
		String address = "http://localhost:8877/webservice/say";
		//在浏览器中输入我们在WebServicePublish类中定义的address?wsdl(注意一定要加wsdl)
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("WebService发布成功！");

	}
}
