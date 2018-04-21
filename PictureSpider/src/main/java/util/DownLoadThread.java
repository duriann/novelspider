package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadThread extends Thread{
	int start, end, threadId;
	File file = null;
	URL url = null;

	public DownLoadThread(int threadId, int block, File file, URL url) {
		this.threadId = threadId;
		start = block * threadId;
		end = block * (threadId + 1) - 1;
		this.file = file;
		this.url = url;
	}

	public void run() {
		final String[] UserAgent = {
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36",
				"Mozilla/5.0 (iPad; U; CPU OS 3_2_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B500 Safari/531.21.11",
				"Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18121",
				"Nokia5700AP23.01/SymbianOS/9.1 Series60/3.0", "UCWEB7.0.2.37/28/998", "NOKIA5700/UCWEB7.0.2.37/28/977",
				"Openwave/UCWEB7.0.2.37/28/978", "Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/989" };
		try {
			// 获取连接并设置相关属性。
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Pragma", "no-cache");
			conn.setRequestProperty("Cache-Control", "no-cache");
			// http://blog.csdn.net/yjflinchong
			int temp = Integer.parseInt(Math.round(Math.random() * 7) + "");
			conn.setRequestProperty("User-Agent", UserAgent[temp]);
			conn.setRequestMethod("GET");
			conn.setReadTimeout(60000);
			conn.setConnectTimeout(60000);
			// 此步骤是关键。
			
			conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
			if (conn.getResponseCode() == 206) {
				RandomAccessFile raf = new RandomAccessFile(file, "rw");
				// 移动指针至该线程负责写入数据的位置。
				raf.seek(start);
				// 读取数据并写入
				InputStream inStream = conn.getInputStream();
				byte[] b = new byte[1024];
				int len = 0;
				while ((len = inStream.read(b)) != -1) {
					raf.write(b, 0, len);
				}
				System.out.println("线程" + threadId + "下载完毕");
				conn.disconnect();
				raf.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
