package test_avgle.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import avgle.com.AvChapterSpider;
import entitys.Chapter;
import impl.AbstractSpider;

public class MainTest extends AbstractSpider{
	
	
	
	@Test
	public void test_findlastDir(){
		findlastDir(new File("D://a"));
		
	}
	private static void findlastDir(File file){
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if(files.length!=0){
				System.out.println("files.length:"+files.length);
				for (File ls : files) {
					findlastDir(ls);
				}
			}else{
				System.out.println(file.getPath());
			}
			
		}else{
			//System.out.println(file.getParentFile().getPath());
		}
		
	}
	
	@Test
	public  void test_a() throws Exception{
		String url = "https://avgle.com/videos/jp";
		String result = crawl1(url);
		System.out.println(result);
		
	}	
	
	@Test
	public void test_AvChapterSpider(){
		AvChapterSpider spider = new AvChapterSpider();
		List<Chapter> chapter = spider.getsChapter("https://avgle.com/videos/amateur");
		for (Chapter chapter2 : chapter) {
			System.out.println(chapter2.getTitle()+":"+chapter2.getUrl()+":"+chapter2.getTorrentImgUrl());
		}
	}
	/**
	 * 测试下载的url
	 * 
	 * 2017年9月24日下午12:51:19
	 */
	@Test
	public void test_downloadurl(){
		//https://avgle.com/video/88330/素人動画-第4弾
		String url = "https://avgle.com/video/88330/素人動画-第4弾";
		String url2 = url.substring(24, 29);
		System.out.println(url2);
	}
	@Test
	public void test_download_torrent(){
		String url1 = "https://avgle.com/download.php?id=88237";//不是种子文件 Content-Type:text/html; charset=UTF-8
		String url2 = "https://avgle.com/download.php?id=88807";//是种子文件 Content-Type:text/html; charset=UTF-8
		String url3 = "https://avgle.com/download.php?id=88139";//是种子文件Content-Type:application/force-download
		HttpGet httpGet = new HttpGet(url2);
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
				entity.writeTo(new FileOutputStream(UUID.randomUUID().toString() + ".torrent"));
				return;
			}else{
				String result = EntityUtils.toString(entity);
				Document doc = Jsoup.parse(result);
				String torrer =  doc.select("a").attr("href");
				if (torrer.contains("magnet")) {
					FileWriter fw = new FileWriter(new File(UUID.randomUUID().toString() + ".txt"));
					fw.write(torrer);
					fw.close();
				}else{
					System.out.println("不是种子文件");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String[] UserAgent = {
			"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36",
			"Mozilla/5.0 (iPad; U; CPU OS 3_2_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B500 Safari/531.21.11",
			"Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18121",

			"Nokia5700AP23.01/SymbianOS/9.1 Series60/3.0", "UCWEB7.0.2.37/28/998", "NOKIA5700/UCWEB7.0.2.37/28/977",
			"Openwave/UCWEB7.0.2.37/28/978", "Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/989" };
}
