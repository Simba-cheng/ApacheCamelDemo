package com.server.routes.masterroute;

import org.apache.camel.builder.RouteBuilder;


/**
 * master路由
 *
 * @author CYX
 * @date 2018/11/7 15:26
 */
public class MasterHttpRoute extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterHttpRoute.class);

    private CamelContext camelContext = DynamicControlRoutesMainApp.camelContext;

    @Override
    public void configure() throws Exception {

        /**
         * master路由
         * 该路由控制slave中的其他路由
         */
        from("jetty:http://127.0.0.1:8282/masterRoute").routeId("masterRoute").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {

                InputStream bodyStream = exchange.getIn().getBody(InputStream.class);
                String bodyStr = IOUtils.toString(bodyStream, "UTF-8");

                LOGGER.info("bodyStr : {}", new Object[]{bodyStr});

                PersonDTO personDTO = CommonUtils.toJavaObject(bodyStr, PersonDTO.class);

                if ("0".equals(personDTO.getSlaveFlag())) {

                    camelContext.stopRoute("test-route-control-03");

                    LOGGER.info("===== stop routeID:test-route-control-03 =====");

                } else if ("1".equals(personDTO.getSlaveFlag())) {

                    camelContext.startRoute("test-route-control-03");

                    LOGGER.info("===== start routeID:test-route-control-03 =====");
                }

                if (exchange.getPattern() == ExchangePattern.InOut) {
                    Message outMessage = exchange.getOut();
                    outMessage.setBody("消息收到" + "-已处理-00");
                }
            }
        });

    }
}
