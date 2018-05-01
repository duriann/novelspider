package novel.web.utils;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * @author
 * @create 2018-04-30 23:35
 **/
public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists();// 判断该页面是否存在
    }

}
