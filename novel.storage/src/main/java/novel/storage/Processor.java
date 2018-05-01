package novel.storage;

/**
 * 一个处理器接口
 */
public interface Processor {
	/**
	 * 一个插入处理方法
	 */

    public void process(String action,int maxTry);

	public void process(String action);


}
