package novel.spider.entitys;

import java.net.URI;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

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
				.setSocketTimeout(30000)
				.setConnectTimeout(10000)
				.setConnectionRequestTimeout(5000)
				.build());
	}
}
