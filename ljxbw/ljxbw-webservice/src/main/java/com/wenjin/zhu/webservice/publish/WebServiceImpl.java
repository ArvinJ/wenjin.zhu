package com.wenjin.zhu.webservice.publish;

@javax.jws.WebService
public class WebServiceImpl implements WebService {

	public void sayHello(String msg) {
		System.out.println(msg + " 欢迎您！");
	}

}
