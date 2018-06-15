package novel.web.entitys;

public class User {
    private long id;
    private String name;
    private String password;
    private String lastReadChapterDetailUrl;


    public String getLastReadChapterDetailUrl() {
        return lastReadChapterDetailUrl;
    }

    public void setLastReadChapterDetailUrl(String lastReadChapterDetailUrl) {
        this.lastReadChapterDetailUrl = lastReadChapterDetailUrl;
    }

    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public User(){}

    public User(String cname, String cpwd) {
        this.name = cname;
        this.password = cpwd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", lastReadChapterDetailUrl='" + lastReadChapterDetailUrl + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String lastReadChapterTitle;

    public String getLastReadChapterTitle() {
        return lastReadChapterTitle;
    }

    public void setLastReadChapterTitle(String lastReadChapterTitle) {
        this.lastReadChapterTitle = lastReadChapterTitle;
    }
}
