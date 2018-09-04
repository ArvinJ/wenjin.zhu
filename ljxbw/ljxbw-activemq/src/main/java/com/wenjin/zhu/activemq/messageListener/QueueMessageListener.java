package com.wenjin.zhu.activemq.messageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * 
 * 
 * @Title: QueueMessageListener.java
 * @Package com.wenjin.zhu.activemq.messageListener
 * @Description: 监听器 使用一个监听器来监听是否有消息到达，这样子可以很快的完成对消息的处理。
 * @author: wenjin.zhu
 * @date: 2018年8月31日 下午2:03:29
 * @version V1.0
 */
public class QueueMessageListener implements MessageListener {
	public static  Logger logger = (Logger) LoggerFactory.getLogger(QueueMessageListener.class);
	
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			logger.info("QueueMessageListener监听到了文本消息：\t" + tm.getText());
			// do something ...
		} catch (JMSException e) {
			logger.info("QueueMessageListener"+e.getMessage());
		}
	}
}