package ccc711.com;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entitys.Chapter;
import entitys.Picture;
import interfaces.IChapterSpider;
import interfaces.IPictureSpider;
import util.AbstractDownload;

public class AVMainTouPaiZiPai extends AbstractDownload{
	private static Log log = LogFactory.getLog(AVMainTouPaiZiPai.class);
	
	public  void run() {

		// 文件保存路径
		final String destination = "I://ccc711//toupaizipai//";
		// 打算开启的线程数
		final int threadNum = 10;
		
		final IChapterSpider chapterSpider = new AvChapterSpider();
		final IPictureSpider pictureSpider = new AvPictureSpider();
		//一天更新了22页 20170107
		new Thread() {
			public void run() {
				String path = "";
				for (int i = 1; i <= 99; i++) {
					path = "https://www.122cf.com/htm/piclist1/"+i+".htm";
					List<Chapter> chapters = chapterSpider.getsChapter(path);
					for (Chapter chapter : chapters) {
						try {
							String chapterTitle = chapter.getTitle();
							
							File file = new File(destination+chapterTitle);
							boolean isSuccess = file.mkdirs();
							if (isSuccess) {
								System.out.println("创建文件夹:"+isSuccess);
								log.info(path+"----------------创建文件夹:"+file.getAbsolutePath());
								String chapterPath = chapter.getUrl();
								//System.out.println(chapterPath);
								List<Picture> pictures = pictureSpider.getsChapter(chapterPath);
								for (Picture picture : pictures) {
									String picturePath = picture.getUrl();
									System.out.println("picturePath:"+picturePath);
									download(picturePath, file.getAbsolutePath(), threadNum);
								}
							}else{
								if(file!=null&&file.exists()&&file.isDirectory()){
									File[] files = file.listFiles();
									if(files.length==0){
										file.delete();
										//重新曾经是空的文件夹System.out.println("创建文件夹:"+isSuccess);
										file = new File(destination+chapterTitle);
										file.mkdir();
										log.info(path+"----------------重新创建文件夹:"+file.getAbsolutePath());
										String chapterPath = chapter.getUrl();
										//System.out.println(chapterPath);
										List<Picture> pictures = pictureSpider.getsChapter(chapterPath);
										for (Picture picture : pictures) {
											String picturePath = picture.getUrl();
											System.out.println("picturePath:"+picturePath);
											download(picturePath, file.getAbsolutePath(), threadNum);
										}
									}
								}
								log.error(path+"创建文件夹:"+file.getAbsolutePath()+"失败");
								//return;
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}

			}

		}.start();
		

	}

}