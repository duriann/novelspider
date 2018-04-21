package daily_20161207;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest {

	public static void main(String[] args) throws Exception {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		bis = new BufferedInputStream(new FileInputStream("L:\\深刻学习形式与政策\\bol\\短片系列\\test.txt"));
		bos = new BufferedOutputStream(new FileOutputStream("test_bak.txt"));
		byte[] buf = new byte[1024];
		int read = 0;
		while ((read = bis.read(buf)) != -1) {
			bos.write(buf, 0, read);
		}
		bos.write(00);
		bis.close();
		bos.close();

	}

}
