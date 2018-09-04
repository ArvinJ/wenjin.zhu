package com.wenjin.zhu.socket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 
 * 
 * @Title:  TeLuoYiSocketClient.java   
 * @Package com.wenjin.zhu.socket.client   
 * @Description:    TODO(socket client)   
 * @author: wenjin.zhu    
 * @date:   2018年8月23日 下午4:34:35   
 * @version V1.0
 */
public class TeLuoYiSocketClient {
//	 public static Logger logger = (Logger) LoggerFactory.getLogger(TeLuoYiSocketClient.class);

	private static final String HOST = "127.0.0.1";

	private static final int PORT = 9898;

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket(HOST, PORT);
		OutputStream out = client.getOutputStream();
		try {
			while (true) {
				Thread.sleep(8000);
//				logger.info("client2:发心跳数据包");
				out.write("{\"code\":\"0123456789\"}eof".getBytes());
			}
			
			/*Map<String, Object> map = new HashMap<String, Object>();
			map.put("opt", 5);
			map.put("ip", HOST);
			String json = new Gson().toJson(map);
			out.write(json.getBytes());*/
			
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
			client.close();
		}
	}

}
