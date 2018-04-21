package avgle.com;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entitys.Chapter;
import entitys.Picture;
import interfaces.IChapterSpider;
import util.AbstractDownload;

public class SchoolgirlMain extends AbstractDownload {
	private static Log log = LogFactory.getLog(SchoolgirlMain.class);

	public void run() {

		// 文件保存路径
		final String destination = "I://avgle//torrent//schoolgirl//";
		// String url = "https://avgle.com/videos/amateur?page=2";
		// 种子下载链接 https://avgle.com/download.php?id=88329
		final IChapterSpider chapterSpider = new AvChapterSpider();
		new Thread() {
			public void run() {
				String path = "";
				for (int i = 1; i <= 99; i++) {
					path = "https://avgle.com/videos/schoolgirl?page=" + i;
					List<Chapter> chapters = chapterSpider.getsChapter(path);
					for (Chapter chapter : chapters) {
						String chapterTitle = chapter.getTitle();
						File file = new File(destination + chapterTitle);
						boolean isSuccess = file.mkdirs();
						String filepath = file.getAbsolutePath();
						if (isSuccess) {
							System.out.println("创建文件夹:" + isSuccess);
							log.info(path + "----------------创建文件夹:" + file.getAbsolutePath());
							String url = chapter.getUrl();

							String downloadPath = "https://avgle.com/download.php?id=" + url.substring(24, 29);
							boolean success = download4Avgle(downloadPath, filepath);
							if (!success) {
								file.delete();
							}
							else{
								download(chapter.getTorrentImgUrl(), filepath, 5);
							}

						}else{
							if (file != null && file.exists() && file.isDirectory()) {
								File[] files = file.listFiles();
								if (files.length == 0) {
									file.delete();
	
								}
								if(files.length == 1){
									download(chapter.getTorrentImgUrl(), filepath, 5);
									log.info(path + "新增图片:" + file.getAbsolutePath() + "成功");
									System.out.println(path + "新增图片:" + file.getAbsolutePath() + "成功");
								}
							}
							log.error(path + "创建文件夹:" + file.getAbsolutePath() + "失败");
						}
					}
				}
			}

		}.start();

	}

}