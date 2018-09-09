package com.wenjin.zhu.utils;

public class Tools {
public static void main(String[] args) {
	
	
	String tempCertId= "320106198004013218";
	if(tempCertId!=null && tempCertId.length()==18) {
		StringBuffer str = new StringBuffer();
		String  CertIdHead =tempCertId.substring(0, 10);
		String  CertIdEnd =tempCertId.substring(14,18);
		str.append(CertIdHead).append("****").append(CertIdEnd);
		System.out.println(str.toString());
	}
	
}
}
