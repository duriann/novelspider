package spider.web;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * 测试
 *
 * @author
 * @create 2018-05-22 23:12
 **/
public class TestCase {
    @Test
    public void testMd5(){
        String md5Name = DigestUtils.md5Hex("admin");
        String md5Pwd = DigestUtils.md5Hex("123456"+"admin");
        System.out.println("md5Name = " + md5Name);
        System.out.println("md5Pwd = " + md5Pwd);
    }
}
