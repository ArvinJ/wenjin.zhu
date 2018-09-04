package com.wenjin.zhu.socket.server;

import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * 
 * 
 * @Title: SocketOperate.java
 * @Package com.ahhf.ljxbw.socket.server
 * @Description: TODO(多线程处理socket接收的数据 )
 * @author: wenjin.zhu
 * @date: 2018年4月13日 下午2:37:14
 * @version V1.0
 */
public class SocketOperate extends Thread {

//	public Logger logger = (Logger) LoggerFactory.getLogger(SocketOperate.class);
	private Socket socket;
	private String siteCode;
	public static HashMap<String, Socket> socketLists = new HashMap<String, Socket>();

	public SocketOperate(Socket socket) {
		this.socket = socket;
	}

	@SuppressWarnings("unused")
	public void run() {

		try {
			handleSocket();
		} catch (Exception e) {
//			logger.info("SocketOperate run() failure!!!" + e.getMessage());
		}

	}

	/**
	 * 跟客户端Socket进行通信
	 * 
	 * @throws Exception
	 */
	private void handleSocket() throws Exception {
//		logger.info("SocketOperate handleSocket() ***********start*********");
		byte[] recData = null;
		InputStream in = socket.getInputStream();
		// OutputStream out = socket.getOutputStream();

		while (true) {
			recData = new byte[1024];
			int r = in.read(recData);
			if (r > -1) {
				String data = new String(recData);
				System.err.println("SocketOperate server： client send Data--" + data);
//				logger.info("SocketOperate server： client send Data --" + data);
				if (data.trim().equals("over")) {
					socket.close();
					socketLists.remove(siteCode);
				}
				String firstData = "";
				int index = data.indexOf("eof");
				if (data.indexOf("code") != -1) {
					if (index != -1) {
						firstData = data.substring(0, index);
						JSONObject json = JSONObject.fromObject(firstData);
						siteCode = json.getString("code");
						socketLists.put(siteCode, socket);
						// ActiveSocket activeSocket = new ActiveSocket(socket, 1);
						// activeSocketList.put(json.getString("code"), activeSocket);
					}
				}

//				logger.info("SocketOperate socketLists.toString()---" + socketLists.toString());
			} else {
//				logger.info("数据读取完毕！");
				socket.close();
				socketLists.remove(siteCode);
				System.exit(0);
				// ss.close();
			}

		}

	}
}