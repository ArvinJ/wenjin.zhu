package com.wenjin.zhu.dubbo.provider;

public class DubboServiceImpl implements DubboService {

	public String sayHello(String name) {
		return "hello "+name;
	}

}
