package novel.spider.impl.novel;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Novel;
import novel.spider.util.NovelSpiderUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XiaoShuo58NovelSpider extends AbstractNovelSpider {
    @Override
    public List<Novel> getsNovel(String url, Integer maxTryTimes) throws Exception {

        List<Novel> novels = new ArrayList<>();
        try {
            Elements trs = super.getsTr(url, maxTryTimes);
            for (int index = 1, size = trs.size(); index < size; index++) {
                Element tr = trs.get(index);
                Elements tds = tr.getElementsByTag("td");
                Novel novel = new Novel();
                novel.setType(tds.first().text());
                novel.setName(tds.get(1).getElementsByTag("a").html());
                String novelUrl = NovelSiteEnum.getEnumByUrl(url).getUrl()+getRealChapterUrl(tds.get(1).getElementsByTag("a").first().attr("href"));
                novel.setUrl(novelUrl);
                novel.setLastUpdateChapter(tds.get(2).text());

                String lastUpdateChapterUrl = tds.get(2).getElementsByTag("a").first().absUrl("href");
                novel.setLastUpdateChapterUrl(lastUpdateChapterUrl);
                novel.setAuthor(tds.get(3).text());

                novel.setLastUpdateTime(NovelSpiderUtil.getDate(tds.get(7).text().substring(0,5), "MM-dd"));
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
