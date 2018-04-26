package novel.web.utils;

import java.util.Base64;

public class Base64Util {

    /**
     *
     * @param src 待解码的字符串
     * @return 源字符串
     */
    public static String decode(String src){
        return new String(Base64.getDecoder().decode(src.getBytes()));
    }

    /**
     *
     * @param src 待编码的字符串
     * @return 编码后的字符串
     */
    public static String encode(String src){
        return new String(Base64.getEncoder().encode(src.getBytes()));
    }
}
