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
				.setSocketTimeout(50000)
				.setConnectTimeout(50000)
				.setConnectionRequestTimeout(5000)
				.build());
	}
}
