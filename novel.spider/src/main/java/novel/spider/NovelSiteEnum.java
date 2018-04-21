package novel.spider;

/**
 * 
 */
public enum NovelSiteEnum {
	BXWX(3,"bxwx9.org"),
	DingDianXiaoShuo(1, "23wx.cc"),
	BiQuGe(2, "xs.la"),
	KanShuZhong(4,"kanshuzhong.com");
	private int id;
	private String url;
	private NovelSiteEnum(int id, String url) {
		this.id = id;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static NovelSiteEnum getEnumById(int id) {
		switch (id) {
		case 1 : return DingDianXiaoShuo;
		case 2 : return BiQuGe;
		case 3 : return BXWX;
		case 4 : return KanShuZhong;
		default : throw new RuntimeException("id=" + id + "不被支持的id");
		}
	}
	public static NovelSiteEnum getEnumByUrl(String url) {
		for (NovelSiteEnum novelSiteEnum : values()) {
			if (url.contains(novelSiteEnum.url)) {
				return novelSiteEnum;
			}
		}
		throw new RuntimeException("url=" + url + "不被支持的url");
	}
}
