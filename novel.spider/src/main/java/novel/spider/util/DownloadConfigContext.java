package novel.spider.util;

import novel.spider.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class DownloadConfigContext {

    public static Configuration configuration;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
