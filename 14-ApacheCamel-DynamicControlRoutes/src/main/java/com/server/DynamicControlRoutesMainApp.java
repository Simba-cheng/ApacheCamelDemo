package com.server;

import com.server.conf.LogBackConfigLoader;
import com.server.routes.master.MasterHttpRoute;
import com.server.routes.slave.SlaveHttpRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态控制路由
 *
 * @author CYX
 */
public class DynamicControlRoutesMainApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicControlRoutesMainApp.class);

    private static final String LOGBACK_FILENAME = "./conf/logback.xml";

    public static CamelContext camelContext;

    public static void main(String[] args) {

        // 初始化参数、异常直接kill程序
        try {
            LogBackConfigLoader.loadLogBack(LOGBACK_FILENAME);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        LOGGER.info("===== 准备启动 CamelContext =====");

        try {
            // 创建CamelContext上下文
            camelContext = new DefaultCamelContext();
            camelContext.start();

            // 将MasterHttpRoute路由加入CamelContext中
            camelContext.addRoutes(new MasterHttpRoute());

            // 将SlaveHttpRoute路由加入CamelContext中
            // 其中'test-route-control-03'禁止自动启动，由Master路由进行控制
            camelContext.addRoutes(new SlaveHttpRoute());

            // 保证主线程不退出
            synchronized (DynamicControlRoutesMainApp.class) {
                DynamicControlRoutesMainApp.class.wait();
            }

        } catch (Exception e) {
            LOGGER.error("error : {} , errorMessage : {}", new Object[]{e, e.getMessage()});
        }
    }
}
