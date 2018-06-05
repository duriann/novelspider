package novel.spider.impl.chapter;

import novel.spider.entitys.Chapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 笔下文学专用，因为笔下文学章节标题没有按照自然顺序排序，需要过滤一下
 * @author pineapple
 * @time 2018年4月9日下午8:23:20
 */
public class BxwxChapterSpider extends AbstractChapterSpider {
	public List<Chapter> getsChapter(String url) {
		List<Chapter> chapters = super.getsChapter(url);
		Collections.sort(chapters, new Comparator<Chapter>() {
			@Override
			public int compare(Chapter o1, Chapter o2) {
				String o1Url = o1.getUrl();
				String o2Url = o2.getUrl();
				String o1Index = o1Url.substring(o1Url.lastIndexOf('/') + 1, o1Url.lastIndexOf('.'));
				String o2Index = o2Url.substring(o2Url.lastIndexOf('/') + 1, o2Url.lastIndexOf('.'));
				return o1Index.compareTo(o2Index);
			}
		});
		return chapters;
	}
}
