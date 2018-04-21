package entitys;

import java.io.Serializable;
/**
 * 图片列表实体
 * @author pineapple
 * @time 2016年10月16日下午2:13:18
 */
public class Chapter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7574082095190014403L;
	private String title;
	private String url;
	private String torrentImgUrl;
	public String getTorrentImgUrl() {
		return torrentImgUrl;
	}
	public void setTorrentImgUrl(String torrentImgUrl) {
		this.torrentImgUrl = torrentImgUrl;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", url=" + url + ", torrentImgUrl=" + torrentImgUrl + "]";
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
