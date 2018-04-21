package daily_20170910;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("I://toupaizipai");
		if(file!=null&&file.exists()&&file.isDirectory()){
			File[] files = file.listFiles();
			for(File file2 : files){
				if(file2!=null&&file.exists()&&file.isDirectory()){
						if(file2.listFiles().length==0){
							System.out.println(file2.getName());
						}
					}
				}
			}
		}
		
	

}
