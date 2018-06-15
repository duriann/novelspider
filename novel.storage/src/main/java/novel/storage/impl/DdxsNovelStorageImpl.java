package novel.storage.impl;

import java.io.FileNotFoundException;

public class DdxsNovelStorageImpl extends AbstractNovelStorage {
	public DdxsNovelStorageImpl() throws FileNotFoundException {
	    //全本的无需更新
		//tasks.put("0","http://www.23wx.cc/quanben/410");
		tasks.put("1","http://www.23wx.cc/top/monthvisit_1.html");

	}

}
