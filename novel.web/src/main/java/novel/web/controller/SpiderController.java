package novel.web.controller;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import novel.spider.util.FileUtil;
import novel.web.entitys.JSONResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pineapple
 * @create 2018-05-22 23:00
 **/
@Controller
@RequestMapping("/admin")
public class SpiderController {
    @RequestMapping(value = "/getAllSpider")
    @ResponseBody
    public JSONResponse getAllSpider(){
        try {
            String xml = FileUtil.file2String("conf/Spider-Rule.xml");
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSON result = xmlSerializer.read(xml);
            System.out.println("result = " + result);
            return JSONResponse.success(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONResponse.error("获取爬虫规则失败!");

    }
}
