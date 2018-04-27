package novel.web.service.impl;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.entitys.Novel;
import novel.spider.util.NovelSpiderFactory;
import novel.web.dao.NovelDao;
import novel.web.entitys.Page;
import novel.web.service.NovelService;
import novel.web.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NovelServiceImpl implements NovelService {
	@Autowired
	private NovelDao novelDao;
	@Override
	public List<Novel> getsNovelByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return novelDao.getsNovelByKeyword(keyword);
	}
	@Override
	public List<Novel> getsNovelByKeyword(String keyword, int platformId) {
		Map<String, String> map = new HashMap<>();
		map.put("keyword", "%" + keyword + "%");
		map.put("platformId", platformId + "");
		return novelDao.getsNovelByKeyword2(map);
	}

    @Override
    public Page<Novel> getNovelByPage(String keyword, int currentPage, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("keyword", "%" + keyword + "%");
        map.put("currentPage",currentPage);
        map.put("pageSize",pageSize);
        return novelDao.getNovelByPage(map);
    }

    @Override
	public List<Chapter> getChapters(String base64Url) {
        String srcUrl = Base64Util.decode(base64Url);
        List<Chapter> chapters = NovelSpiderFactory.getChapterSpider(srcUrl).getsChapter(srcUrl);
        return chapters;
	}

	@Override
	public ChapterDetail getChapterDetail(String url) {
        ChapterDetail chapterDetail = NovelSpiderFactory.getChapterDetailSpider(url).getChapterDetail(url);
        //将AbstractChapterDetailSpider里替换的换行符换回来
        chapterDetail.setContent(chapterDetail.getContent().replace(" ", "&nbsp;").replace(System.getProperty("line.separator"), "<br>").replace("\n", "<br>"));
        return chapterDetail;
	}

}