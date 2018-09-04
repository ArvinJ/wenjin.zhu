package com.wenjin.zhu.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

	static Logger logger = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		logger.info("logger.infoMessage.");
		logger.info("logger.infoMessage111.");
		logger.info("logger.infoMessage222.");
	}

}
