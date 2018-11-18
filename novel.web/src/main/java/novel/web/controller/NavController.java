package novel.web.controller;

import novel.web.entitys.JSONResponse;
import novel.web.entitys.index.Nav;
import novel.web.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class NavController {

    @Autowired
    private NavService navService;

    @RequestMapping(value = "/navManager",method = RequestMethod.GET)
    @ResponseBody
    public JSONResponse navManager(){
        System.out.println("test");
        List<Nav> navs = navService.getAllNav();
        System.out.println(navs);
        return JSONResponse.success(navs);
    }
}
