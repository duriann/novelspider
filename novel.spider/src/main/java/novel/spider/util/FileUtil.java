package novel.spider.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 文件帮助类
 *
 * @author pineapple
 * @create 2018-05-22 23:04
 **/
public class FileUtil {
    /**
     * 读取文件内容到字符串
     * @param src
     * @return
     * @throws Exception
     */
    public static String file2String(String src) throws Exception {
        InputStream inputStream = FileUtil.class.getClassLoader().getResource(src).openStream();
        //此处需要设置一下编码 不然前台显示会乱码
        BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();
        return  sb.toString();
    }
    
}
