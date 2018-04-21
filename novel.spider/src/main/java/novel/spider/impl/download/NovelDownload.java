package novel.spider.impl.download;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import novel.spider.NovelSiteEnum;
import novel.spider.config.Configuration;
import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.interfaces.INovelDownload;
import novel.spider.util.NovelSpiderFactory;

/**
 * 如何实现多线程下载任意网站的小说
 *	1.拿到该网站的某本小说的所有章节：章节列表
 *	2.通过计算，将这些章节分配给指定数量的线程，让他们去解析，然后保存到文本文件中
 *	3.通知主线程，将这些零散的小文件合并成一个大文件。最后将那些分片的小文件删除掉。
 * 
 */
public class NovelDownload implements INovelDownload {

	@Override
	public String download(String url,Configuration config) {
		IChapterSpider chapterSpider = NovelSpiderFactory.getChapterSpider(url);
		List<Chapter> chapters = chapterSpider.getsChapter(url);
		//分配线程数量,先获取每个线程打算下载的章节数量,这边默认是100章
		int size = config.getSize();
		//假设该小说有1108章 1108/100 = 11 再加1个线程
		int threadSize = (chapters.size()/size)+1;
		//待下载的小说分组
		Map<String,List<Chapter>> downloadTask = new HashMap<>();
		for(int i = 0;i<threadSize;i++){
			//0,99
			//100,199
			//200,299
			//1000,1099
			//1100,1199
			int start = i*size;
			//如果是最后一个线程的时候，让end等于章节数-1即可
			int end = i==threadSize-1?chapters.size():i*size+size;
			downloadTask.put(start+"-"+end, chapters.subList(start, end));
		}
		ExecutorService service = Executors.newFixedThreadPool(threadSize);
		Set<String> keySet = downloadTask.keySet();
		List<Future<String>> tasks = new ArrayList<>();
		String savePath = config.getPath()+"/"+NovelSiteEnum.getEnumByUrl(url).getUrl();
		new File(savePath).mkdirs();
		for (String key : keySet) {
			tasks.add(service.submit(new Callable<String>() {
				
				@Override
				public String call() throws Exception {
					int tryTimes = config.getTryTimes();
					try(PrintWriter pw = new PrintWriter(new File(savePath+"/"+key+".txt"))){
						for(Chapter chapter:downloadTask.get(key)){
							//拿到章节详情爬虫
							IChapterDetailSpider chapterDetailSpider = NovelSpiderFactory.getChapterDetailSpider(chapter.getUrl());
							//获取章节详情
							for(int i = 0;i<tryTimes;i++){
								try {
									ChapterDetail chapterDetail = chapterDetailSpider.getChapterDetail(chapter.getUrl());
									pw.println(chapterDetail.getTitle());
									pw.println(chapterDetail.getContent());
									break;
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out.println("尝试下载第:"+i+1+"/"+tryTimes+"次失败了!");
								}
							}
							
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					return key;
				}
			}));
		}
		service.shutdown();
		for (Future<String> future : tasks) {
			try {
				System.out.println(future.get()+"下载完了");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

}
