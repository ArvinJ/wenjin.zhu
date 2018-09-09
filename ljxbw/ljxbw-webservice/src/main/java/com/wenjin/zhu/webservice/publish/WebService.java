package com.wenjin.zhu.webservice.publish;

import javax.jws.WebMethod;

@javax.jws.WebService
public interface WebService {
	@WebMethod
	public void sayHello(String msg);
}
