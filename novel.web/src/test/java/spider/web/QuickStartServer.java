/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spider.web;

import org.eclipse.jetty.server.Server;

/**
 * 使用Jetty运行调试Web应用, 在Console输入回车快速重新加载应用.
 *
 * @author zengzhipeng
 */
public class QuickStartServer {

    public static final int PORT = 9999;
    public static final String CONTEXT = "/";

    public static void main(String[] args) throws Exception {
        // 启动Jetty
        Server server = JettyFactory.createServerInSource(PORT, CONTEXT);

        // 设定Spring的profile
        //System.setProperty("spring.profiles.active", "test");
        try {server.start();
            System.out.println("[INFO] Server running at http://localhost:" + PORT + CONTEXT);

            // 等待用户输入回车重载应用.
            while (true) {
                System.out.println("[HINT] Hit Enter to reload the application quickly");
                int n = System.in.read();
                char c = (char) n;
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                } else if (c == 'Q') {
                   System.out.println("[INFO] exiting the application");
                    System.exit(0);
                } else if (n == -1) {
                    System.out.println("[WARNING] stdin has closed");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}