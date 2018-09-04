package com.wenjin.zhu.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @Title: SocketThread.java
 * @Package com.ahhf.ljxbw.socket.server
 * @Description: TODO(socket 线程类 )
 * @author: wenjin.zhu
 * @date: 2018年4月13日 下午2:35:44
 * @version V1.0
 */
public class SocketThread extends Thread {
	private ServerSocket serverSocket = null;
	public  Logger logger = (Logger) LoggerFactory.getLogger(SocketThread.class);
	public SocketThread(ServerSocket serverScoket) {
		try {
			if (null == serverSocket) {
				this.serverSocket = new ServerSocket(9898);
				logger.info("socket start>>>>>");
				logger.info("socket start>>>>>*****************");
			}
		} catch (Exception e) {
			logger.info("SocketThread创建socket服务出错"+e.getMessage());
		}

	}
	public SocketThread() {
		
	}

	public void run() {
		while (!this.isInterrupted()) {
			try {
				ExecutorService threadPool = Executors.newFixedThreadPool(100);
					Socket socket = serverSocket.accept();
					logger.info("当前最新建立好连接的 socket-----"+socket);
					/*if (null != socket && !socket.isClosed()) {
						// 处理接受的数据
						new SocketOperate(socket).start();
					}*/
					new SocketOperate(socket).start();
					//socket.setSoTimeout(30000);
					threadPool.submit(new SocketOperate(socket));
			} catch (Exception e) {
				logger.info("run():"+e.getMessage());
			}
		}
	}

	public void closeSocketServer() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			logger.info("closeSocketServer:"+e.getMessage());
		}
	}
	
}
