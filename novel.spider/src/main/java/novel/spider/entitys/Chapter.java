package novel.spider.entitys;

public class Chapter {
	private String title;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", url=" + url + "]";
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
