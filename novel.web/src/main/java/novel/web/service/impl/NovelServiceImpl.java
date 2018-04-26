package novel.web.service.impl;

import novel.spider.entitys.Chapter;
import novel.spider.entitys.Novel;
import novel.spider.util.NovelSpiderFactory;
import novel.web.dao.NovelDao;
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
	public List<Chapter> getChapters(String base64Url) {
        String srcUrl = Base64Util.decode(base64Url);
        List<Chapter> chapters = NovelSpiderFactory.getChapterSpider(srcUrl).getsChapter(srcUrl);
        return chapters;
	}

}
