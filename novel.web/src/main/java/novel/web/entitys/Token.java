package novel.web.entitys;

public class Token {
    //用户id
    private long user_id;
    //随机生成的uuid
    private String token;

    public Token() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token(long user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }
}
