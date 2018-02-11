/**
 * <p>Title: HttpsRequestHelper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月8日 下午4:14:26
 */
package cn.com.ylpw.core.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * <p>Title: HttpsRequestHelper.java</p>
 * <p>Description: </p>
 * @author 张嘉杰
 * @date 2017年2月8日 下午4:14:26
 */
public class HttpTool {
	
	public static String  doHttpsRequest(String requestUrl, String requestMethod, String outputStr) {
		try{
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);
			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				try(OutputStream outputStream = conn.getOutputStream())
				{
					outputStream.write(outputStr.getBytes("UTF-8"));
				}catch (Exception e) {}
			}
			
			// 从输入流读取返回内容
			try(InputStream inputStream = conn.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader))
			{
				String str = null;
				StringBuffer buffer = new StringBuffer();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				conn.disconnect();
				return buffer.toString();
			}catch (Exception e) {}
		} catch (ConnectException ce) {
			//MyLogger.info("连接超时：{}"+ce);
		} catch (Exception e) {
			//MyLogger.info("https请求异常：{}"+e);
		}
		return null;
	}
	
}

class MyX509TrustManager implements X509TrustManager {
	
	// 检查客户端证书
	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}
	
	// 检查服务器端证书
	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}
	
	// 返回受信任的X509证书数组
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}
