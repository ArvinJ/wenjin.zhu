package com.wenjin.zhu.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = "classpath:redis/spring-redis.xml")
public class RedisTest21 {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@SuppressWarnings("unchecked")
	@Test
	public void selectActivitySite () {
		HashMap<String,Object> tempMaps = (HashMap<String, Object>) redisTemplate.opsForHash().get("proxySiteCodeToIp", "data");
		System.err.println(tempMaps.toString());
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void rr1() 
	{
		HashMap<String, Object> computerIps =(HashMap<String, Object>) redisTemplate.opsForHash().get("computListInstall", "pcinstall"+"3101041507");
		System.out.println(computerIps.toString());
		
		//HashMap<String, Object> hashMap2 = (HashMap<String, Object>) redisTemplate.opsForHash().get("computerStatisicMaps","3101048889");
		//System.out.println(hashMap2.toString());
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void proxy() {
		
		try {
			HashMap<String, Object> proxyMaps = (HashMap<String, Object>) redisTemplate.opsForHash().get("proxySiteCodeToIp", "data");
			System.err.println("proxyMaps:"+proxyMaps.toString());
			
		} catch (Exception e) {
			System.err.println("proxyIpError---" + e.getMessage());
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void ttR() {
		
		String requestBody = (String) redisTemplate.boundValueOps("computerbody3101041507").get();
		System.err.println(requestBody);
		HashMap<String, Object> hashMap2 = (HashMap<String, Object>) redisTemplate.opsForHash().get("computerStatisicMaps","3101041533");
		System.out.println(hashMap2.get("list"));
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRedis() {
		//redisTemplate.boundValueOps("zhangsan").set("����");

		String str = (String) redisTemplate.boundValueOps("computerbody3101041533").get();
//		String str1 = (String) redisTemplate.boundValueOps("lisi").get();
		// HashMap<String, Socket> socketLists =(HashMap<String, Socket>) redisTemplate.boundValueOps("socketLists").get();
		 
		System.out.println(str);
		//System.out.println("socketLists--"+socketLists.toString());
		HashMap<String, Object> computerIps = (HashMap<String, Object>) redisTemplate.opsForHash().get("computListInstall", "pcinstall3101041533");
		System.out.println("installcomputerIps3101041533--"+computerIps);
		HashMap<String, Object> computerIps2 = (HashMap<String, Object>) redisTemplate.opsForHash().get("computListInstall", "pcinstall3101000000");
		System.out.println("installcomputerIps222--"+computerIps2);
		HashMap<String, Object> computerIps3 = (HashMap<String, Object>) redisTemplate.opsForHash().get("computListInstall", "pcinstall3101000044");
		System.out.println("installcomputerIps333--"+computerIps3);
		
	}

	@Test
	public void test01() {
		// �������
		Map<String, String> map = new HashMap<String, String>();

		map.put("name", "jack");
		map.put("age", "27");
		map.put("class", "1");
		redisTemplate.opsForHash().putAll("hashOps", map);
		// �ӹ�ϣ�л�ȡ����hashKey��ֵ
		List<Object> kes = new ArrayList<Object>();
		kes.add("name");
		kes.add("age");
		kes.add("class");
		System.out.println(redisTemplate.opsForHash().multiGet("hashOps", kes));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void tt() {
		// �������
		Map<Object, Object> map = new HashMap<Object, Object>();
//		List<User> alist =  new ArrayList<User>();
//		User u1 = new User("aaa", "123");
//		User u2 = new User("bbb", "345");
//		User u3 = new User("ccc", "567");
//		alist.add(u1);
//		alist.add(u2);
//		alist.add(u3);
//		map.put("list", alist);
		map.put("age", "27");
		map.put("class", "1");
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("8888", map);
		
		redisTemplate.opsForHash().putAll("hashOps", hashMap);
		// �ӹ�ϣ�л�ȡ����hashKey��ֵ
		List<Object> kes = new ArrayList<Object>();
		kes.add("list");
		kes.add("age");
		kes.add("class");
		System.out.println(redisTemplate.opsForHash().multiGet("hashOps", kes));
		HashMap<String, Object> hashMap2 = (HashMap<String, Object>) redisTemplate.opsForHash().get("hashOps", "8888");
		System.out.println(hashMap2.get("list"));
		
		
		
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void  zzproxy() {
		
		HashMap<String,Object> proxyIpHostMaps = new HashMap<String,Object>();
//		HashMap<String,Object> tempProxyIpHostMaps = new HashMap<String,Object>();
		proxyIpHostMaps = (HashMap<String, Object>) redisTemplate.opsForHash().get("proxySiteCodeToIp", "data");
		
		//proxyIpHostMaps = (HashMap<String, Object>) redisTemplate.opsForHash().get("computListInstall", "pcinstall"+"aaaa");
		
		
		System.err.println("---"+proxyIpHostMaps);
		
		
		
	}
	
	
	
	
	

	@Test
	public void test02() {

		// ��ʼ���� ��
		redisTemplate.opsForHash().put("redisHash", "name", "tom");
		redisTemplate.opsForHash().put("redisHash", "age", 26);
		redisTemplate.opsForHash().put("redisHash", "class", "6");

		System.out.println(redisTemplate.opsForHash().entries("redisHash"));

		// ȷ����ϣhashKey�Ƿ����
		System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "ttt"));
		System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "name"));

		// ɾ�������Ĺ�ϣhashKeys
		redisTemplate.opsForHash().delete("redisHash", "name");
		System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "name"));
		System.out.println(redisTemplate.opsForHash().entries("redisHash"));

		// �Ӽ��еĹ�ϣ��ȡ����hashKey��ֵ
		System.out.println(redisTemplate.opsForHash().get("redisHash", "age"));

		// ��ȡkey����Ӧ��ɢ�б��key
		System.out.println(redisTemplate.opsForHash().keys("redisHash"));
		// ��ȡkey����Ӧ��ɢ�б�Ĵ�С����
		System.out.println(redisTemplate.opsForHash().size("redisHash1"));

	}

}