package com.vaizn.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

public class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	public static String object2json(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("JsonUtils_转换json字符串出错！");
			return null;
		}
	}
	
	public static <T> T json2object(String json, String nodeName, Class<T> cls) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (StringUtils.isNotBlank(nodeName)) {
				JsonNode root = objectMapper.readTree(json);
				JsonParser jsonParser = objectMapper.treeAsTokens(root.findPath(nodeName));
				return objectMapper.readValue(jsonParser, cls);
			} else
				return objectMapper.readValue(json, cls);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("JsonUtils_json转换对象出错！");
			return null;
		}
	}
	
	public static <T> Collection<T> json2collection(String json, String nodeName,
					Class<? extends Collection<T>> collectionType,
					Class<T> elementType) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CollectionType type = objectMapper.getTypeFactory()
							.constructCollectionType(collectionType, elementType);
		try {
			if (StringUtils.isNotBlank(nodeName)) {
				JsonNode root = objectMapper.readTree(json);
				JsonParser jsonParser = objectMapper.treeAsTokens(root.findPath(nodeName));
				return objectMapper.readValue(jsonParser, type);
			} else
				return objectMapper.readValue(json, type);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("JsonUtils_json转换集合出错！");
			return null;
		}
	}
	
	public static <K, V> Map<K, V> json2map(String json, String nodeName, Class<K> keyType, Class<V> valueType) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MapType type = objectMapper.getTypeFactory().constructMapType(Map.class, keyType, valueType);
		try {
			if (StringUtils.isNotBlank(nodeName)) {
				JsonNode root = objectMapper.readTree(json);
				JsonParser jsonParser = objectMapper.treeAsTokens(root.findPath(nodeName));
				return objectMapper.readValue(jsonParser, type);
			} else
				return objectMapper.readValue(json, type);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("JsonUtils_json转换map出错！");
			return null;
		}
	}
}