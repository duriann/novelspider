package novel.web.constants;

/**
 * 全局静态类
 */
public final class Constants {
    /**
     * user
     */
    public static final String CURRENT_USER = "user";
    /**
     *token默认过期时间
     */
    public static final long TOKEN_EXPIRES_HOUR = 3600*24*7;

    /**
     * 热搜过期时间
     */
    public static final long HOTNOVEL_EXPIRES_HOUR = 3600*24;
    /**
     * redis默认过期时间
     */
    public static final int DEFAULT_EXPIRES_HOUR = 3600*24*30;

    /**
     * 最后阅读章节url
     */
    public static final String LRCDU = "lastReadChapterDetailUrl";
    /**
     * 最后阅读章节标题
     */
    public static final String LRCT = "lastReadChapterTitle";
}
