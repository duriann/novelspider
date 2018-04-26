/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spider.web;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

//import org.eclipse.jetty.server.nio.SelectChannelConnector;

/**
 * 创建Jetty Server的工厂类.
 *
 * @author zengzhipeng
 */
public class JettyFactory {


    private static final String DEFAULT_WEBAPP_PATH = "C:/Users/Administrator/Desktop/pineapple/eclipse-workspace/novel.web/src/main/webapp";//src/main/webapp
    //private static final String WINDOWS_WEBDEFAULT_PATH = "jetty/webdefault-windows.xml";
    private static final String WINDOWS_WEBDEFAULT_PATH = "C:/Users/Administrator/Desktop/pineapple/eclipse-workspace/novel.web/src/main/webapp/WEB-INF/web.xml";//src/main/webapp/WEB-INF/web-test.xml


    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port, String contextPath) {
        Server server = new Server();
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);


//		SelectChannelConnector connector = new SelectChannelConnector();
        HttpConfiguration config = new HttpConfiguration();
        ServerConnector connector = new ServerConnector(server, new HttpConnectionFactory(config));
        connector.setReuseAddress(true);
        connector.setIdleTimeout(30000);

        connector.setPort(port);
        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[]{connector});

        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
        // 修改webdefault.xml，解决Windows下Jetty Lock住静态文件的问题.
//		webContext.setDefaultsDescriptor(WINDOWS_WEBDEFAULT_PATH);
        webContext.setDescriptor(WINDOWS_WEBDEFAULT_PATH);
        server.setHandler(webContext);

        return server;
    }

    /**
     * 快速重新启动application，重载target/classes与target/test-classes.
     */
    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("[INFO] Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        classLoader.addClassPath("build/classes/main");
        classLoader.addClassPath("build/classes/test");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("[INFO] Application reloaded");
    }
}
