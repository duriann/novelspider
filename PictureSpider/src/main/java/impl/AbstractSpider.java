package impl;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import util.SSLClient;

public abstract class AbstractSpider {
	private static Log log = LogFactory.getLog(AbstractSpider.class
			);
	protected String crawl1(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
		httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				CloseableHttpResponse httpResponse = httpClient.execute( httpGet)) {
			String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	protected void crawl2yanzhengma(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
		httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				CloseableHttpResponse httpResponse = httpClient.execute( httpGet)) {
			HttpEntity entity = httpResponse.getEntity();
			entity.writeTo(new FileOutputStream(new File("d://1.jpg")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	//测试用的
	protected void crawl2yanzhengma(String url ,int i) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
		httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				CloseableHttpResponse httpResponse = httpClient.execute( httpGet)) {
			HttpEntity entity = httpResponse.getEntity();
			entity.writeTo(new FileOutputStream(new File("d://code//"+i+".jpg")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	protected String crawl_20170911(String url) throws Exception {
		
		
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
		httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
		SSLClient sslClient = null;
		try {
			sslClient = new SSLClient();
			CloseableHttpResponse httpResponse = sslClient.execute( httpGet);
			Header header = httpResponse.getFirstHeader("Set-Cookie");
			String[]values = header.getValue().split(";");
			for (String value : values) {
				//找到新连接
				if(value.contains("domain")){
					System.out.println("最原始的url:"+url);
					log.debug("原始url:"+url);
					String url1=url.substring(12, 22);
					System.out.println("需要替换的url:"+url1);
					String url2=value.substring(9, value.length());
					System.out.println("用来替换的url:"+url2);
					log.debug("用来替换的url:"+url2);
					if(!url.contains(url2)){
						//设置新的url
						url = url.replace(url1, url2);
						System.out.println("替换后的url:"+url);
						log.debug("替换后的url:"+url);
						httpGet = new HttpGet(url);
						httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
						httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
						sslClient = new SSLClient();
						httpResponse = sslClient.execute( httpGet);
					}
				}
			}
			
			String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			sslClient.close();
		}

	}
	
   protected String crawl(String url) throws Exception {
		
		
		HttpGet httpGet = new HttpGet(url);
		//xiamian san hang dai ma 20170911添加
		HttpParams params = new BasicHttpParams();
		params.setParameter("http.protocol.handle-redirects",false);
		httpGet.setParams(params);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
		httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
		//httpGet.getParams().setParameter("http.protocol.allow-circular-redirects", true);
		SSLClient sslClient = null;
		try {
			sslClient = new SSLClient();
			CloseableHttpResponse httpResponse = sslClient.execute( httpGet);
			System.out.println(url);
				//找到新连接
			String newurl = httpResponse.getFirstHeader("Location").getValue();
			System.out.println("新的重定向url:"+newurl);//
					log.info("原始url:"+url);
					String url1=url.substring(0, 22);
						//设置新的url
					System.out.println(url1);//ccc711.com
					url = url.replace(url1, newurl);
						log.info("替换后的url:"+url);
						httpGet = new HttpGet(url);
						System.out.println("真实的url:"+url);
						log.info("真实的url:"+url);
						httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
						httpGet.setHeader("Cookie", "uuid=a4e986d280f94e3c; cck_lasttime=1483847862651; cck_count=2; a9590_times=8; a2117_times=8; a2117_pages=1; a9590_pages=3");
						sslClient = new SSLClient();
						httpResponse = sslClient.execute( httpGet);
				
				
			
			
			String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			sslClient.close();
		}

	}

}
