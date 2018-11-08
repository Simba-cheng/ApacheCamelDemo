package com.server.routes.slave;


import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Slave工作路由-Http
 *
 * @author CYX
 * @date 2018/11/7 14:03
 */
public class SlaveHttpRoute extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlaveHttpRoute.class);

    @Override
    public void configure() throws Exception {

        /**
         * 第一个路由（普通写法，不增加任何配置）
         */
        from("jetty:http://127.0.0.1:8282/test-route-control").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

                InputStream inputStream = exchange.getIn().getBody(InputStream.class);
                String bodyStr = IOUtils.toString(inputStream, "UTF-8");

                LOGGER.info("bodyStr : {}", new Object[]{bodyStr});
                inputStream.close();

                // 存入到exchange的out区域
                if (exchange.getPattern() == ExchangePattern.InOut) {
                    Message outMessage = exchange.getOut();
                    outMessage.setBody("消息收到" + "-已处理-slave-01");
                }
            }
        });

        /**
         * 第二个路由（设置route id）
         */
        from("jetty:http://127.0.0.1:8282/test-route-contro2").routeId("test-route-control-02").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

                InputStream inputStream = exchange.getIn().getBody(InputStream.class);
                String bodyStr = IOUtils.toString(inputStream, "UTF-8");

                LOGGER.info("bodyStr : {}", new Object[]{bodyStr});
                inputStream.close();

                // 存入到exchange的out区域
                if (exchange.getPattern() == ExchangePattern.InOut) {
                    Message outMessage = exchange.getOut();
                    outMessage.setBody("消息收到" + "-已处理-slave-02");
                }
            }
        });

        /**
         * 第三个路由（设置route id、设置禁止自动启动）
         */
        from("jetty:http://127.0.0.1:8282/test-route-contro3").routeId("test-route-control-03").autoStartup(false).process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

                InputStream inputStream = exchange.getIn().getBody(InputStream.class);
                String bodyStr = IOUtils.toString(inputStream, "UTF-8");

                LOGGER.info("bodyStr : {}", new Object[]{bodyStr});
                inputStream.close();

                // 存入到exchange的out区域
                if (exchange.getPattern() == ExchangePattern.InOut) {
                    Message outMessage = exchange.getOut();
                    outMessage.setBody("消息收到" + "-已处理-slave-03");
                }
            }
        });
    }

}