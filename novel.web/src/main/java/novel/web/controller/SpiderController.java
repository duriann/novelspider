package novel.web.controller;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import novel.spider.util.FileUtil;
import novel.web.entitys.JSONResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

/**
 * @author pineapple
 * @create 2018-05-22 23:00
 **/
@Controller
@RequestMapping("/admin")
public class SpiderController {

    /**
     * 获取所有网站爬取规则
     * @return
     */
    @RequestMapping(value = "/getAllSpiderRule")
    @ResponseBody
    public JSONResponse getAllSpiderRule(){
        try {
            String xml = FileUtil.file2String("conf/Spider-Rule.xml");
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSON result = xmlSerializer.read(xml);
            return JSONResponse.success(JSONArray.fromObject(result.toString().replace("@","")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONResponse.error("获取爬虫规则失败!");

    }

    /**
     * 修改网站爬取规则
     * @return
     */
    @RequestMapping(value = "/updateSpiderRule")
    @ResponseBody
    public JSONResponse updateSpiderRule(@RequestParam("param")String param){
        JSONObject object = JSONObject.fromObject(param);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xml = db.parse(SpiderController.class.getClassLoader().getResourceAsStream("conf/Spider-Rule.xml"));
            Element root = xml.getDocumentElement();
            Element site = (Element)selectSingleNode("/sites/site[@id=" + object.getString("id") + "]", root);
            site.getElementsByTagName("charset").item(0).setTextContent(object.getString("charset"));
            site.getElementsByTagName("url").item(0).setTextContent(object.getString("url"));
            site.getElementsByTagName("chapter-list-selector").item(0).setTextContent(object.getString("chapter-list-selector"));
            site.getElementsByTagName("chapter-detail-title-selector").item(0).setTextContent(object.getString("chapter-detail-title-selector"));
            site.getElementsByTagName("chapter-detail-content-selector").item(0).setTextContent(object.getString("chapter-detail-content-selector"));
            site.getElementsByTagName("chapter-detail-prev-selector").item(0).setTextContent(object.getString("chapter-detail-prev-selector"));
            site.getElementsByTagName("chapter-detail-next-selector").item(0).setTextContent(object.getString("chapter-detail-next-selector"));
            site.getElementsByTagName("novel-selector").item(0).setTextContent(object.getString("novel-selector"));
            site.getElementsByTagName("novel-nextpage-selector").item(0).setTextContent(object.getString("novel-nextpage-selector"));
            // 保存
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer former = factory.newTransformer();
            former.transform(new DOMSource(xml), new StreamResult(
                  new File(getClass().getClassLoader().getResource("conf/Spider-Rule.xml").getFile())));
        }catch (Exception e){
            e.printStackTrace();
            return JSONResponse.error("更新规则失败!");
        }
       return JSONResponse.success("更新成功");

    }
    //inputStream转outputStream
    private ByteArrayOutputStream parse(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream;
    }
    // 根据xpath定位节点信息
    private static Node selectSingleNode(String express, Element source) {
        Node result = null;
        //创建XPath工厂
        XPathFactory xpathFactory = XPathFactory.newInstance();
        //创建XPath对象
        XPath xpath = xpathFactory.newXPath();
        try {
            result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
