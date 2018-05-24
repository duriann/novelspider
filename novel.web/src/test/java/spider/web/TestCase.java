package spider.web;

import novel.web.controller.SpiderController;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * 测试
 *
 * @author
 * @create 2018-05-22 23:12
 **/
public class TestCase {
    @Test
    public void testXml(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xml = db.parse(SpiderController.class.getClassLoader().getResourceAsStream("conf/Spider-Rule.xml"));
            Element root = xml.getDocumentElement();
            Element bxwx = (Element) selectSingleNode("/sites/site[@id='1']",
                    root);
            //获取到笔下文学 title值
            String text = bxwx.getElementsByTagName("title").item(0).getTextContent();
            System.out.println("text = " + text);

        }catch (Exception e){

        }
    }

    // 修改节点信息
    private static Node selectSingleNode(String express, Element source) {
        Node result = null;
        //创建XPath工厂
        XPathFactory xpathFactory = XPathFactory.newInstance();
        //创建XPath对象
        XPath xpath = xpathFactory.newXPath();
        try {
            result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
            System.out.println(result);
        } catch (XPathExpressionException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    @Test
    public void testMd5(){
        String md5Name = DigestUtils.md5Hex("admin");
        String md5Pwd = DigestUtils.md5Hex("123456"+"admin");
        System.out.println("md5Name = " + md5Name);
        System.out.println("md5Pwd = " + md5Pwd);
    }
}
