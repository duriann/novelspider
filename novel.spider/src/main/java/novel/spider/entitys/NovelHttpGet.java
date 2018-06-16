package novel.spider.entitys;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

import java.net.URI;

public class NovelHttpGet extends HttpGet {

	public NovelHttpGet() {
	}

	public NovelHttpGet(URI uri) {
		super(uri);
	}

	public NovelHttpGet(String uri) {
		super(uri);
		setDefaultParams();
	}

	public void setDefaultParams(){
		this.setConfig(RequestConfig.custom()
				.setSocketTimeout(50000)
				.setConnectTimeout(50000)
				.setConnectionRequestTimeout(5000)
				.build());
		this.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
	}
}
