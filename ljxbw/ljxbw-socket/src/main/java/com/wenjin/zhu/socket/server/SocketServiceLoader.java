package com.wenjin.zhu.socket.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * 
 * @Title: SocketServiceLoader.java
 * @Package com.ahhf.ljxbw.socket.server
 * @Description: TODO(将socket service随tomcat启动)
 * @author: wenjin.zhu
 * @date: 2018年4月13日 下午2:34:43
 * @version V1.0
 */
public class SocketServiceLoader implements ServletContextListener {
	// socket server 线程
	private SocketThread socketThread;
	//public Logger logger = (Logger) LoggerFactory.getLogger(SocketServiceLoader.class);

	public void contextDestroyed(ServletContextEvent arg0) {
//		logger.info("SocketServiceLoader 》》》》contextDestroyed-------");
		if (null != socketThread && !socketThread.isInterrupted()) {
			socketThread.closeSocketServer();
			socketThread.interrupt();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
//		logger.info("SocketServiceLoader》》》contextInitialized------");
		// TODO Auto-generated method stub
		if (null == socketThread) {
			// 新建线程类
			socketThread = new SocketThread(null);
			// 启动线程
			socketThread.start();
		}
	}
}
