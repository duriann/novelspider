package novel.spider.util;

import java.io.*;

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

    public static byte[] toByteArray(File f) throws IOException {

        if (!f.exists()) {
            throw new FileNotFoundException(f.getAbsolutePath());
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }
}
