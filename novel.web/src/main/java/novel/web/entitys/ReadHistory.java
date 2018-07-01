package novel.web.entitys;

import java.util.Date;

/**
 * @author
 * @create 2018-07-01 15:22
 **/
public class ReadHistory {
    private String title;
    private String url;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
