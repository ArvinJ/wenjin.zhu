package com.wenjin.zhu.activemq.pointtopoint;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听
 * @author Administrator
 *
 */
public class Listener implements MessageListener{

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Listener11收到的消息："+((TextMessage)message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
