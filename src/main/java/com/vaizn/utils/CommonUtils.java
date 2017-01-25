package com.vaizn.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaizn.common.vo.ResourcePermissionVo;
import com.vaizn.common.vo.TreeVo;

public class CommonUtils {

	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	
	/**
	 * 获取32位随机数
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 获取地图两点间距离<br>
	 * @param lng1 经度1<br>
	 * @param lat1 纬度1<br>
	 * @param lng2 经度2<br>
	 * @param lat2 纬度2<br>
	 * @return 两点间距离，单位：米
	 */
	public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
		double radius = 6371004.00;//地球半径,单位(米)
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		
		double sin1, sin2;
		sin1 = Math.sin((lat1 - lat2) / 2.0);
		sin2 = Math.sin(((lng1 - lng2) * Math.PI / 180.0) / 2.0);
		
		double distance = 2 * radius 
							* Math.asin(Math.sqrt(sin1 * sin1 + Math.cos(lat1)  
			                * Math.cos(lat2) * sin2 * sin2));
		
		return distance;
	}
	
	/**
	 * 获取批定IP地址所属的城市信息
	 * @param ip
	 * @return
	 * @throws IOException 
	 */
	public static String getCityByIP(String ip) throws IOException {
		if (StringUtils.isBlank(ip))
			return null;
		//IP地址库
		String ipHouse = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=";
		//String ipHouse = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
		String cityInfo = HttpConnectUtils.doGetRequest(ipHouse);
		
		return cityInfo;
	}
	
	/**
	 * unicode转换成中文
	 * @param str
	 * @return
	 */
	public static String decodeUnicode(String str) {
		char aChar;
		int len = str.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = str.charAt(x++);
			if (aChar == '\\') {
				aChar = str.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = str.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}
	
	/**
	 * 处理树形菜单
	 * @param permissions
	 * @param id
	 * @return
	 */
	public static List<TreeVo> treeProcess(List<ResourcePermissionVo> permissions, String id) {
		List<TreeVo> trees = new ArrayList<TreeVo>();
		for (ResourcePermissionVo permission : permissions) {
			if (id.equals(permission.getParentId())) {
				TreeVo tree = new TreeVo();
				String parentId = permission.getParentId();
				tree.setId(permission.getResourceId());
				tree.setParentId(parentId);
				tree.setParentName(permission.getParentName());
				tree.setCode(permission.getResourceCode());
				tree.setName(permission.getResourceName());
				tree.setText(permission.getResourceName());
				tree.setPermissionCode(permission.getResourceCode());
				tree.setUrl(permission.getResourceUrl());
				tree.setStatus(permission.getResourceStatus());
				tree.setOrder(permission.getResourceOrder());
				tree.setChildren(treeProcess(permissions, permission.getResourceId()));
				trees.add(tree);
			}
		}
		return trees;
	}
	
	/**
	 * 对字符进行MD5加密
	 * @param str 要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encodeMD5(String str) {
		StringBuilder sb = new StringBuilder(32);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(str.getBytes("utf-8"));
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
		} catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("MD5加密处理时出错！", e);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		logger.info("加密后的值：{}", CommonUtils.encodeMD5("1"));
		logger.info("UUID:{}", CommonUtils.getUUID());
	}
}
