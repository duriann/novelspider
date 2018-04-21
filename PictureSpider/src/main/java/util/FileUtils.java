package util;

import java.io.File;

public class FileUtils {
	
	/**
	 * 删除文件夹下只有一个文件的无效文件夹
	 * 
	 * 2017年9月26日下午9:53:47
	 */
	public static void clearUselessFile(){
		String path = "I:\\avgle\\torrent\\amateur";
		File root = new File(path);
		File[] ls = root.listFiles();
		for(File f:ls){
			if (f.isDirectory()) {
				File[] files = f.listFiles();
				if(files.length==1){
					for (File file : files) {
						file.delete();
						System.out.println("删除了文件："+file.getPath());
						f.delete();
						System.out.println("删除了文件夹："+f.getPath());
					}
				}
			}
		}
		
	}
}
