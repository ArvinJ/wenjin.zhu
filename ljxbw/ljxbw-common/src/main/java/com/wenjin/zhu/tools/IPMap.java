package com.wenjin.zhu.tools;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import net.sf.json.JSONObject;

public class IPMap {
	public static Logger logger = (Logger) LoggerFactory.getLogger(IPMap.class);

	public static HashMap<String, Integer> serverWeightMap = new HashMap<String, Integer>();

	static {
		int temp22 = 0, temp28 = 0, temp33 = 0, temp34 = 0;

		int[] arr = { temp22, temp28, temp33, temp34 };
		int N = arr.length;
		int temp = 0;
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < N - i; ++j) {
				// 如果前面的数比后面的大，则不是按照顺序的，因此要交换
				if (arr[j] > arr[j + 1]) {
					temp = arr[j]; // 交换2个数
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < N; ++i) // 输出排序后的结果
		{
			System.out.print(arr[i] + "  ");

		}

		if (arr[0] == temp22) {
			temp22 = 1;
			temp28 = 0;
			temp33 = 0;
			temp34 = 0;
		} else if (arr[0] == temp28) {
			temp22 = 0;
			temp28 = 1;
			temp33 = 0;
			temp34 = 0;
		} else if (arr[0] == temp33) {
			temp22 = 0;
			temp28 = 0;
			temp33 = 1;
			temp34 = 0;
		} else if (arr[0] == temp34) {
			temp22 = 0;
			temp28 = 0;
			temp33 = 0;
			temp34 = 1;
		} else {
			temp22 = 1;
			temp28 = 0;
			temp33 = 0;
			temp34 = 0;
		}

		JSONObject proxyIp22 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8283"));
		JSONObject proxyIp28 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8284"));
		JSONObject proxyIp33 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8285"));
		JSONObject proxyIp34 = JSONObject.fromObject(new RproxyEntity("sock.nbscreen.com", "8286"));
		// 第一个参数是IP地址,第二个是权重.
		serverWeightMap.put(proxyIp22.toString(), temp22);
		serverWeightMap.put(proxyIp28.toString(), temp28);
		serverWeightMap.put(proxyIp33.toString(), temp33);
		serverWeightMap.put(proxyIp34.toString(), temp34);
	}
}
