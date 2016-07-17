package com.vaizn.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AES加密解密
 * @author 关志伟
 */
public class AES {
	
	private static final Logger logger = LoggerFactory.getLogger(AES.class);
	//16位密钥
	private static final String KEY = "www.fs.vaizn.com";
	
	/**
	 * 加密操作
	 * @param str 要加密的字符串
	 * @return
	 */
	public static String encode(String str) {
		if (StringUtils.isBlank(str))
			return null;
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
			//使用加密模式初始化密钥
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			//进行加密操作
			byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
			
			return new Base64().encodeToString(encrypted);
		} catch (UnsupportedEncodingException |
				NoSuchAlgorithmException |
				NoSuchPaddingException |
				InvalidKeyException |
				IllegalBlockSizeException |
				BadPaddingException e) {
			e.printStackTrace();
			logger.error("AES加密操作出错！", e);
		}
		
		return null;
	}
	
	/**
	 * 解密操作
	 * @param str 要解密的字符串
	 * @return
	 */
	public static String decode(String str) {
		if (StringUtils.isBlank(str))
			return null;
		//先使用Base64解密
		byte[] base64 = new Base64().decode(str);
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
			//使用加密模式初始化密钥
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			
			return new String(cipher.doFinal(base64), "UTF-8");
		} catch (UnsupportedEncodingException |
				NoSuchAlgorithmException |
				NoSuchPaddingException |
				InvalidKeyException |
				IllegalBlockSizeException |
				BadPaddingException e) {
			e.printStackTrace();
			logger.error("AES解密操作出错！", e);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		String str = "{\"userAccount\":\"13602291009\",\"password\":\"1\"}";
		String encodeStr = AES.encode(str);
		String decodeStr = AES.decode(encodeStr);
		//NYVChgjp0Qm8vHeB0rm2q9KzEn1Y7Cy352eAVWO4bgI3QGjQ5nRaftK9VuUlYZEM
		logger.info("加密后：{}", encodeStr);
		logger.info("解密后：{}", decodeStr);
	}

}
