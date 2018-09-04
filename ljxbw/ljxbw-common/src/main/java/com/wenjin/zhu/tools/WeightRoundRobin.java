package com.wenjin.zhu.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @Title: WeightRoundRobin.java
 * @Package org.eastbar.info.cafeinfo.tools
 * @Description: TODO(加权轮训法)
 * @author: wenjin.zhu
 * @date: 2018年8月8日 上午10:20:36
 * @version V1.0
 */
public class WeightRoundRobin {
	private static Integer pos = 0;

	public static String getServerIP() {

		// 重新在线程本地copy一份IPMap, 避免服务器上线下线导致的并发问题
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(IPMap.serverWeightMap);
	//	System.out.println(serverMap.toString());
		// 取的IP地址的Set
		Set<String> ips = serverMap.keySet();
		Iterator<String> iterator = ips.iterator();

		List<String> iplist = new ArrayList<String>();
		while (iterator.hasNext()) {
			String server = iterator.next();
			int weight = serverMap.get(server);
			// 按照权重来添加比例.
			for (int i = 0; i < weight; i++) {
				iplist.add(server);
			}
		}

		
	//	System.err.println("iplist.size--"+iplist.size());
		String server = null;
		synchronized (pos) {
			if (pos > iplist.size())
				pos = 0;

			server = iplist.get(pos);

			pos++;
		}
		return server;
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String result = null;

		/* for (int i = 0; i < 5; i++) {
			result = getServerIP();
			System.out.println("load balance 的地址是:" + result);

		} */
		
		result = getServerIP();
		System.out.println("load balance 的地址是:" + result);
	}

}
