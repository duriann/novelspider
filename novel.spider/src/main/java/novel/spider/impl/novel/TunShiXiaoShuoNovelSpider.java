package novel.spider.impl.novel;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Novel;
import novel.spider.util.NovelSpiderUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TunShiXiaoShuoNovelSpider extends AbstractNovelSpider {
    @Override
    public List<Novel> getsNovel(String url, Integer maxTryTimes) throws Exception {
        List<Novel> novels = new ArrayList<>();
        try {
            Elements trs = super.getsTr(url, maxTryTimes);
            for (int index = 1, size = trs.size(); index < size; index++) {
                Element tr = trs.get(index);
                Elements ps = tr.getElementsByTag("p");
                Novel novel = new Novel();
                novel.setType(ps.first().select("span").first().text());
                novel.setName(ps.first().getElementsByTag("a").html());
                String novelUrl = ps.first().getElementsByTag("a").first().absUrl("href");
                novel.setUrl(novelUrl);
                novel.setLastUpdateChapter(ps.first().select("span").get(1).getElementsByTag("a").first().text());

                String lastUpdateChapterUrl = ps.first().select("span").get(1).getElementsByTag("a").first().absUrl("href");
                novel.setLastUpdateChapterUrl(lastUpdateChapterUrl);
                novel.setAuthor(ps.get(1).select("span").first().text());
                novel.setLastUpdateTime(NovelSpiderUtil.getDate(ps.get(1).select("span").get(1).text().substring(5,15), "yyyy-MM-dd"));
                novel.setAddTime(new Date());
                //没有状态
                novel.setStatus(-1);
                novel.setPlatformId(NovelSiteEnum.getEnumByUrl(url).getId());
                novels.add(novel);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return novels;
    }
    private String getRealChapterUrl(String url){
        return "/html"+url.substring(0, url.lastIndexOf(".html")-3)+url.replace(".html","")
                ;
    }
}
