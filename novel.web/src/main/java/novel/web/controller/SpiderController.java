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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.UUID;

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
    /**
     * 新增网站爬取规则
     * @return
     */
    @RequestMapping(value = "/addSpiderRule")
    @ResponseBody
    public JSONResponse addSpiderRule(@RequestParam("param")String param){
        JSONObject object = JSONObject.fromObject(param);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xml = db.parse(SpiderController.class.getClassLoader().getResourceAsStream("conf/Spider-Rule.xml"));
            //获取根节点 sites
            Element root = xml.getDocumentElement();
            //创建site节点
            Element site = xml.createElement("site");
            //设置site节点属性
            site.setAttribute("id", UUID.randomUUID().toString().replace("-",""));

            Element title = xml.createElement("title");
            title.setTextContent(object.getString("title"));
            site.appendChild(title);
            Element charset = xml.createElement("charset");
            charset.setTextContent(object.getString("charset"));
            site.appendChild(charset);
            Element url = xml.createElement("url");
            url.setTextContent(object.getString("url"));
            site.appendChild(url);
            Element chapterListSelector = xml.createElement("chapter-list-selector");
            chapterListSelector.setTextContent(object.getString("chapter-list-selector"));

            site.appendChild(chapterListSelector);
            Element chapterDetailTitleSelector = xml.createElement("chapter-detail-title-selector");
            chapterDetailTitleSelector.setTextContent(object.getString("chapter-detail-title-selector"));

            site.appendChild(chapterDetailTitleSelector);
            Element chapterDetailContentSelector = xml.createElement("chapter-detail-content-selector");
            chapterDetailContentSelector.setTextContent(object.getString("chapter-detail-content-selector"));

            site.appendChild(chapterDetailContentSelector);
            Element chapterDetailPrevSelector = xml.createElement("chapter-detail-prev-selector");
            chapterDetailPrevSelector.setTextContent(object.getString("chapter-detail-prev-selector"));

            site.appendChild(chapterDetailPrevSelector);
            Element chapterDetailNextSelector = xml.createElement("chapter-detail-next-selector");
            chapterDetailNextSelector.setTextContent(object.getString("chapter-detail-next-selector"));

            site.appendChild(chapterDetailNextSelector);
            Element novelSelector = xml.createElement("novel-selector");
            novelSelector.setTextContent(object.getString("novel-selector"));

            site.appendChild(novelSelector);
            Element novelNextpageSelector = xml.createElement("novel-nextpage-selector");
            novelNextpageSelector.setTextContent(object.getString("novel-nextpage-selector"));

            site.appendChild(novelNextpageSelector);

            //将site节点保存到sites节点中
            root.appendChild(site);
            // 保存
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer former = factory.newTransformer();
            //设置换行回车
            former.setOutputProperty(OutputKeys.INDENT, "yes");
            former.transform(new DOMSource(xml), new StreamResult(
                    new File(getClass().getClassLoader().getResource("conf/Spider-Rule.xml").getFile())));
        }catch (Exception e){
            e.printStackTrace();
            return JSONResponse.error("新增规则失败!");
        }
        return JSONResponse.success("");
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
