package com.wenjin.zhu.job;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class WenJob {
	public static  Logger logger = (Logger) LoggerFactory.getLogger(WenJob.class);
	
	public void doSomething() {
		logger.info("doSomething start. >>>");
		long start, end;
		start = System.currentTimeMillis();
		logger.info("doSomethingTODO>>>");
		end = System.currentTimeMillis();
		logger.info("start time:" + start + "; end time:" + end + "; Run Time:" + (end - start) + "(ms)");
		logger.info("doSomething end. >>>");

	}
}
