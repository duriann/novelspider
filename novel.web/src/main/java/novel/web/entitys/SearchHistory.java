package novel.web.entitys;

import java.util.Date;

public class SearchHistory {
    private int id;
    private String keyword;
    private String ip;
    //搜索次数
    private int count;

    @Override
    public String toString() {
        return "SearchHistory{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", ip='" + ip + '\'' +
                ", count=" + count +
                ", createDate=" + createDate +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    private Date createDate;
}
