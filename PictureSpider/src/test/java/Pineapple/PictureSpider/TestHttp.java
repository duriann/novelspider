package Pineapple.PictureSpider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class TestHttp {
	public static void main(String[] args) throws Exception, IOException {
		String url = "https://avgle.com/download.php?id=88329";

		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
		httpGet.setHeader("Cookie",
				"__cfduid=d07ad704b324284b50e1afd7c8a4becfb1506131411; AVS=d84fa04b8679884768786f80ab1a20ce; HstCfa3858761=1506131397098; HstCmu3858761=1506131397098; __atuvc=43%7C38; __atuvs=59c5e525d384cc93000; HstCla3858761=1506141477850; HstPn3858761=13; HstPt3858761=107; HstCnv3858761=2; HstCns3858761=5; _ga=GA1.2.868487672.1506131396; _gid=GA1.2.1810546951.1506131396; __dtsu=1FE70445D8BDC559655FD15302A438C7");
		httpGet.setHeader("upgrade-insecure-requests", "1");
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		HttpEntity entity = httpResponse.getEntity();
		entity.writeTo(new FileOutputStream(UUID.randomUUID().toString() + ".torrent"));

	}
}
