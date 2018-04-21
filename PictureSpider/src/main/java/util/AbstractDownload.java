package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AbstractDownload {
	Log log = LogFactory.getLog(AbstractDownload.class);
	public static String[] UserAgent = {
			"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36",
			"Mozilla/5.0 (iPad; U; CPU OS 3_2_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B500 Safari/531.21.11",
			"Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18121",

			"Nokia5700AP23.01/SymbianOS/9.1 Series60/3.0", "UCWEB7.0.2.37/28/998", "NOKIA5700/UCWEB7.0.2.37/28/977",
			"Openwave/UCWEB7.0.2.37/28/978", "Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/989" };
	
	//下载种子文件 avgle.com
	protected boolean download4Avgle(String url, String filepath){
		HttpGet httpGet = new HttpGet(url);
		int temp = Integer.parseInt(Math.round(Math.random() * 7) + "");
		httpGet.setHeader("User-Agent", UserAgent[temp]);
		httpGet.setHeader("Cookie",
				"__cfduid=d07ad704b324284b50e1afd7c8a4becfb1506131411; AVS=d84fa04b8679884768786f80ab1a20ce; HstCfa3858761=1506131397098; HstCmu3858761=1506131397098; __atuvc=43%7C38; __atuvs=59c5e525d384cc93000; HstCla3858761=1506141477850; HstPn3858761=13; HstPt3858761=107; HstCnv3858761=2; HstCns3858761=5; _ga=GA1.2.868487672.1506131396; _gid=GA1.2.1810546951.1506131396; __dtsu=1FE70445D8BDC559655FD15302A438C7");
		httpGet.setHeader("upgrade-insecure-requests", "1");
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			Header header = entity.getContentType();
			if (header.getValue().equalsIgnoreCase("application/force-download")) {
				entity.writeTo(new FileOutputStream(filepath+"//"+UUID.randomUUID().toString() + ".torrent"));
				return true;
			}else{
				String result = EntityUtils.toString(entity);
				Document doc = Jsoup.parse(result);
				String torrer =  doc.select("a").attr("href");
				if (torrer.contains("magnet")) {
					FileWriter fw = new FileWriter(new File(filepath+"//"+UUID.randomUUID().toString() + ".txt"));
					fw.write(torrer);
					fw.close();
					log.info("下载成功");
					System.out.println("下载成功");
					return true;
				}else{
					System.out.println("不是种子文件");
					log.error("不是种子文件");
					return false;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
	}
	
	
	/**
	 * 下载文件
	 * 
	 * @throws Exception
	 */
	protected void download(String filePath, String destination, int threadNum) {
		try {
			System.out.println("filepath:"+filePath);
			// 通过下载路径获取连接
			URL url = new URL(filePath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			int temp = Integer.parseInt(Math.round(Math.random() * 7) + "");
			conn.setRequestProperty("User-Agent", UserAgent[temp]);
			// 设置连接的相关属性
			conn.setRequestMethod("GET");
			conn.setReadTimeout(60000);
			conn.setConnectTimeout(60000);
			// 判断连接是否正确。
			System.out.println("conn.getResponseCode():" + conn.getResponseCode());
			if (conn.getResponseCode() == 404) {
				System.out.println(filePath + "网页没图片"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new  Date()));
				conn.disconnect();
			}
			if (conn.getConnectTimeout() == 0) {
				System.out.println("readtimeout restart");
				// download(filePath, destination, threadNum);
			}
			if (conn.getResponseCode() == 200) {
				System.out.println("开始下载");
				// 获取文件大小。
				int fileSize = conn.getContentLength();
				// 得到文件名
				String fileName = getFileName(filePath);
				// 根据文件大小及文件名，创建一个同样大小，同样文件名的文件
				File file = new File(destination + File.separator + fileName);
				if (file.exists()) {
					return;
				} else {
					RandomAccessFile raf = new RandomAccessFile(file, "rw");
					raf.setLength(fileSize);
					raf.close();
					// 将文件分成threadNum = 5份。
					int block = fileSize % threadNum == 0 ? fileSize / threadNum : fileSize / threadNum + 1;
					for (int threadId = 0; threadId < threadNum; threadId++) {
						// 传入线程编号，并开始下载。
						new DownLoadThread(threadId, block, file, url).start();
					}
				}

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 由路径获取文件名
		private String getFileName(String filePath) {
			return filePath.substring(filePath.lastIndexOf('/')+1);
		}

}
