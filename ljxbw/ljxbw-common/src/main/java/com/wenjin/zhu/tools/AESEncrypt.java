package com.wenjin.zhu.tools;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
/**
 * 
 * 
 * @Title:  AESEncrypt.java   
 * @Package com.wenjin.zhu.tools   
 * @Description:    TODO(AES加密解密)   
 * @author: wenjin.zhu    
 * @date:   2018年8月20日 下午2:06:05   
 * @version V1.0
 */
public class AESEncrypt {

	/**
	 * 密钥算法 java6支持56位密钥，bouncycastle支持64位
	 */
	public static final String KEY_ALGORITHM = "AES";

	/**
	 * 加密/解密算法/工作模式/填充方式
	 * 
	 * JAVA6 支持PKCS5PADDING填充方式 Bouncy castle支持PKCS7Padding填充方式
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(Base64.encodeBase64(password.getBytes(Charsets.UTF_8)));
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
			byte[] byteContent = content.getBytes(Charsets.UTF_8);
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return new String(Hex.encodeHex(result, false)); // 加密
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static String decrypt(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(Base64.encodeBase64(password.getBytes(Charsets.UTF_8)));
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(Hex.decodeHex(content.toCharArray()));
			return new String(result, Charsets.UTF_8); // 加密
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String content = "啊啊test";
		String password = "E7A545A471374E51810ABCD8101B0538";
		// 加密
		System.out.println("加密前：" + content);
		System.out.println(content.getBytes(Charsets.UTF_8));
		String encryptResultStr = encrypt(content, password);
		System.out.println("加密后：" + encryptResultStr);
		// 解密
		String decryptResult = decrypt(encryptResultStr, password);
		System.out.println("解密后：" + new String(decryptResult));
	}

}
