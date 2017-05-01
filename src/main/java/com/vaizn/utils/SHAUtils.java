package com.vaizn.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {

	public static String shaEndcode(String str) throws Exception {
		MessageDigest md = null;
		try {
			//对字符串进行sha1加密
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(str.getBytes());
			return byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 将字节数组转换为十六进制字符串
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		StringBuilder strDigest = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			strDigest.append(byteToHexStr(byteArray[i]));
		}
		return strDigest.toString();
	}
	
	/**
	 * 将字节转换为十六进制字符串
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		
		return new String(tempArr);
	}
}
