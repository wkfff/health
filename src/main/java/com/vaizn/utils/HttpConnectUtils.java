package com.vaizn.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaizn.common.vo.HttpResponseVo;

public class HttpConnectUtils {

	private static final Logger log = LoggerFactory.getLogger(HttpConnectUtils.class);
	//socket超时，单位毫秒
	private static final int SOCKET_TIMEOUT = 35000;
	//连接超时，单位毫秒
	private static final int CONNECT_TIMEOUT = 20000;
	//连接不够用的等待时间，不宜过长，必须设置
	private static final int CONNECT_REQUEST_TIMEOUT = 500;
	
	public static final String JSON_CONTENT_TYPE = "application/json";
	
	public static final String XML_CONTENT_TYPE = "application/xml";
	
	public static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";
	
	private static CloseableHttpClient httpClient;
	
	private static CookieStore cookieStore;
	
	static {
		try {
			init();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}
	
	private static void init() throws GeneralSecurityException {
		SSLContext sslcontext = SSLContexts.custom()
				.loadTrustMaterial(null, new TrustStrategy(){
					public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		                return true;
		            }
				}).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext, NoopHostnameVerifier.INSTANCE);
		//自定义的socket工厂类可以和指定的协议（Http、Https）联系起来，用来创建自定义的连接管理器
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", sslsf).build();
		//使用自定义配置创建连接池管理器
		PoolingHttpClientConnectionManager connManager =
				new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		SocketConfig socketConfig = SocketConfig.custom()
				.setTcpNoDelay(true)
				.build();
		//设置默认socket配置
		connManager.setDefaultSocketConfig(socketConfig);
		//设置最大连接数
		connManager.setMaxTotal(200);
		//设置默认路由基础连接数(到每个目标主机最大并发数)
		connManager.setDefaultMaxPerRoute(20);
		//设置目标主机
		HttpHost stHost = new HttpHost("");
		connManager.setMaxPerRoute(new HttpRoute(stHost), 100);//最大并发边接数为100
		//使用cookie保存数据
		cookieStore = new BasicCookieStore();
		//定义默认的请求配置
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(SOCKET_TIMEOUT)
				.setConnectTimeout(CONNECT_TIMEOUT)
				.setConnectionRequestTimeout(CONNECT_REQUEST_TIMEOUT)
				.setCookieSpec(CookieSpecs.IGNORE_COOKIES)//手动管理Cookie
				.build();
		//创建连接管理器
		httpClient = HttpClients.custom()
				.setDefaultCookieStore(cookieStore)
				.setDefaultRequestConfig(requestConfig)
				.setConnectionManager(connManager)
				.setRetryHandler(new DefaultHttpRequestRetryHandler(1, false))
				.build();
	}
	
	/**
	 * 执行post请求
	 * @param host
	 * @param jsonParam
	 * @return
	 * @throws MtripException
	 */
	public static String postRequest(String host, String jsonParam) throws IOException {
		DecimalFormat df = new DecimalFormat("######0.000");
		long start = System.currentTimeMillis();
		String result = "";
		HttpPost httpPost = new HttpPost(host);
		httpPost.addHeader(HTTP.CONTENT_TYPE, JSON_CONTENT_TYPE);
		if (StringUtils.isNotBlank(jsonParam)) {
			StringEntity se = new StringEntity(jsonParam, "utf-8");
			httpPost.setEntity(se);
		}
		for (int i = 0; i < 3; i++) {
			try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
				long end = System.currentTimeMillis();
				HttpEntity entity = response.getEntity();
				StatusLine status = response.getStatusLine();
				log.info("[info message] 响应状态：{}，运行耗时：{}S，请求地址：{}", status.getStatusCode(), df.format((end - start)/1000.00), host);
				if (HttpStatus.SC_OK == status.getStatusCode()) {
					if (null != entity) {
						result = EntityUtils.toString(entity);
						//释放资源
						EntityUtils.consume(entity);
					}
				}
				if (response != null)
					break;
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("通过post调用外部接口出错");
			} finally {
				//释放连接返回到连接池中
				httpPost.releaseConnection();
			}
		}
		return result;
	}
	
	/**
	 * 执行post请求
	 * @param host
	 * @param jsonParam
	 * @return
	 * @throws MtripException
	 */
	public static String postRequest(String host, Map<String, String> param, boolean isForm) throws IOException{
		DecimalFormat df = new DecimalFormat("######0.000");
		long start = System.currentTimeMillis();
		String result = "";
		HttpPost httpPost = new HttpPost(host);
		if (isForm)
			httpPost.addHeader(HTTP.CONTENT_TYPE,  FORM_CONTENT_TYPE);
		else
			httpPost.addHeader(HTTP.CONTENT_TYPE,  JSON_CONTENT_TYPE);
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : param.entrySet()) {
			nvp.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		try {
			UrlEncodedFormEntity encoded = new UrlEncodedFormEntity(nvp, "UTF-8");
			httpPost.setEntity(encoded);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new UnsupportedEncodingException("通过post调用外部接口出错");
		}
		for (int i = 0; i < 3; i++) {
			try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
				long end = System.currentTimeMillis();
				HttpEntity entity = response.getEntity();
				StatusLine status = response.getStatusLine();
				log.info("[info message] 响应状态：{}，运行耗时：{}S，请求地址：{}", status.getStatusCode(), df.format((end - start)/1000.00), host);
				if (HttpStatus.SC_OK == status.getStatusCode()) {
					if (null != entity) {
						result = EntityUtils.toString(entity);
						//释放资源
						EntityUtils.consume(entity);
					}
				}
				if (response != null)
					break;
			} catch (IOException e) {
				e.printStackTrace();
				throw new UnsupportedEncodingException("通过post调用外部接口出错");
			} finally {
				//释放连接返回到连接池中
				httpPost.releaseConnection();
			}
		}
		return result;
	}
	
	/**
	 * 执行post请求
	 * @param host
	 * @param jsonParam
	 * @return
	 * @throws MtripException
	 */
	public static HttpResponseVo postRequest(String host, String param, String contentType) throws IOException{
		DecimalFormat df = new DecimalFormat("######0.000");
		HttpResponseVo obj = new HttpResponseVo();
		HttpPost httpPost = new HttpPost(host);
		httpPost.addHeader(HTTP.CONTENT_TYPE, contentType);
		if (StringUtils.isNotBlank(param)) {
			StringEntity se = new StringEntity(param, "utf-8");
			httpPost.setEntity(se);
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < 3; i++) {
			try(CloseableHttpResponse response = httpClient.execute(httpPost)) {
				long end = System.currentTimeMillis();
				HttpEntity entity = response.getEntity();
				StatusLine status = response.getStatusLine();
				log.info("[info message] 响应状态：{}，运行耗时：{}S，请求地址：{}", status.getStatusCode(), df.format((end - start)/1000.00), host);
				if (HttpStatus.SC_OK == status.getStatusCode()) {
					if (null != entity) {
						obj.setType(1);
						obj.setResponse(EntityUtils.toString(entity));
						//释放资源
						EntityUtils.consume(entity);
					}
				} else {
					obj.setType(0);
					obj.setResponse(String.valueOf(status.getStatusCode()));
				}
				if (response != null)
					break;
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("通过post调用外部接口出错");
			} finally {
				//释放连接返回到连接池中
				httpPost.releaseConnection();
			}
		}
		return obj;
	}
	
	/**
	 * 执行Get请求
	 * @param host
	 * @return
	 * @throws IOException 
	 * @throws MtripException
	 */
	public static String doGetRequest(String host) throws IOException {
		DecimalFormat df = new DecimalFormat("######0.000");
		long start = System.currentTimeMillis();
		String result = "";
		HttpGet httpGet = new HttpGet(host);
		httpGet.addHeader(HTTP.CONTENT_TYPE, JSON_CONTENT_TYPE);
		for (int i = 0; i < 3; i++) {
			try(CloseableHttpResponse response = httpClient.execute(httpGet)) {
				long end = System.currentTimeMillis();
				HttpEntity entity = response.getEntity();
				StatusLine status = response.getStatusLine();
				log.info("[info message] 响应状态：{}，运行耗时：{}S，请求地址：{}", status.getStatusCode(), df.format((end - start)/1000.00), host);
				if (HttpStatus.SC_OK == status.getStatusCode()) {
					if (null != entity) {
						result = EntityUtils.toString(entity);
						//释放资源
						EntityUtils.consume(entity);
					}
				}
				if (response != null)
					break;
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("通过GET调用外部接口时出错！");
			} finally {
				//释放连接返回到连接池中
				httpGet.releaseConnection();
			}
		}
		return result;
	}
	
	/**
	 * 添加参数到cookie
	 * @param name
	 * @param value
	 */
	public static void putCookieToStore(String name, String value) {
		BasicClientCookie cookie = new BasicClientCookie(name, value);
		cookieStore.addCookie(cookie);
	}
	
	/**
	 * 获取指定cookie值
	 * @param name
	 * @return
	 */
	public static String getCookie(String name) {
		List<Cookie> cookies = cookieStore.getCookies();
		if (null != cookies && !cookies.isEmpty()) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name))
					return cookie.getValue();
			}
		}
		return null;
	}
}
