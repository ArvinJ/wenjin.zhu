package com.wenjin.zhu.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 
 * 
 * @Title: WeightRandom.java
 * @Package org.eastbar.info.cafeinfo.tools
 * @Description: TODO(加权随机法)
 * @author: wenjin.zhu
 * @date: 2018年8月8日 上午10:15:52
 * @version V1.0
 */
public class WeightRandom {
	public static String getServerIP() {

		// 重新在线程本地copy一份IPMap, 避免服务器上线下线导致的并发问题
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(IPMap.serverWeightMap);
	//	System.err.println(IPMap.serverWeightMap.toString());
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

		// 获取IP的策略
		Random random = new Random();
		int pos = random.nextInt(iplist.size());
		return iplist.get(pos);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = null;
		/*for (int i = 0; i < 3; i++) {
			result = getServerIP();
			System.out.println("load balance 的地址是:" + result);

		}*/
		result = getServerIP();
		System.out.println("load balance 的地址是:" + result);
		
	}
}