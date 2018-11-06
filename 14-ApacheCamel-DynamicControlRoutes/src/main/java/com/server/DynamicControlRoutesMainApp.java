package com.server;

import com.server.conf.LogBackConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态控制路由
 *
 * @author CYX
 */
public class DynamicControlRoutesMainApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicControlRoutesMainApp.class);

    private static final String LOGBACK_CONF_FILE_PATH = "./conf/logback.xml";

    public static void main(String[] args) {

        //加载相关配置，失败直接kill
        try {
            LogBackConfigLoader.loadLogBack(LOGBACK_CONF_FILE_PATH);
        } catch (Exception e) {
            System.exit(1);
        }

        LOGGER.info("123");

    }
}
