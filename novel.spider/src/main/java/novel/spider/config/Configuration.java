package novel.spider.config;

public class Configuration {
	private static final int DEFAULT_SIZE = 100;
	public Configuration() {
		this.size = DEFAULT_SIZE;
		this.tryTimes = DEFAULT_TRY_TIMES;
		System.out.println();
	}
	//下载的基址目录
	private String path;
	//每个线程下载多少章
	private int size;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Configuration(String path, int size) {
		this();
		this.path = path;
		this.size = size;
		
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	private static final int DEFAULT_TRY_TIMES = 10;
	
	private int tryTimes;
	public int getTryTimes() {
		return tryTimes;
	}
	public void setTryTimes(int tryTimes) {
		this.tryTimes = tryTimes;
	}
	
}
