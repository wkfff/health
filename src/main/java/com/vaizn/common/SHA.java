package com.vaizn.common;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

public class SHA {

	//加密方式
	private final static String KEY_SHA = "SHA";
	private final static String KEY_SHA1 = "SHA-1";
	
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6",
										"7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public SHA() {
		
	}
	
	/**
	 * 对字节数组进行SHA1加密
	 * @param data 要加密的字节数组
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data) throws Exception {
		//创建具有指定算法名称的信息摘要
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);
		//使用指定的字节数组对摘要进行最后更新
		sha.update(data);
		return sha.digest();
	}
	
	/**
	 * 对字符串进行SHA加密
	 * @param data 要加密的字符串
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data) throws Exception {
		if (StringUtils.isBlank(data))
			return "";
		//创建具有指定算法名称的信息摘要
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		//使用指定的字节数组对摘要进行最后更新
		sha.update(data.getBytes());
		byte[] bytes = sha.digest();
		
		return byteArrayToHexString(bytes);
	}
	
	/**
	 * 将一个字节转化成十六进制形式的字符串
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int ret = b;
		if (ret < 0)
			ret += 256;
		int m = ret / 16;
		int n = ret % 16;
		
		return hexDigits[m] + hexDigits[n];
	}
	
	/**
	 * 转换字节数组为十六进制字符串
	 * @param bytes
	 * @return
	 */
	private static String byteArrayToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(byteToHexString(bytes[i]));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String key = "123";
		System.out.println(encrypt(key));
	}
	
}
