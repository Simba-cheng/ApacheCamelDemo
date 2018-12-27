package com.server;

import com.server.conf.LogBackConfigLoader;
import com.server.route.BaseQueryRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Apache Camel With CXF-JAXRS(Code First)
 * <p>
 * Apache Camel集成Apache CXF-JAXRS,发布WebService(代码优先)
 *
 * @author CYX
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static final String LOGBACK_FILENAME = "./conf/logback.xml";

    public static final String BASEICQUERY_SERVICE_URL = "http://localhost:9999/baseQueryService";

    public static final String BASEQUERY_SERVICE_URL_ADDRESS = "cxf://" + BASEICQUERY_SERVICE_URL + "?serviceClass=com.server.service.BaseicQuery";

    public static void main(String[] args) {

        try {

            LogBackConfigLoader.loadLogBack(LOGBACK_FILENAME);

            CamelContext camelContext = new DefaultCamelContext();
            camelContext.start();
            camelContext.addRoutes(new BaseQueryRoute());

            LOGGER.info("baseic query service address : " + BASEICQUERY_SERVICE_URL + "?wsdl");

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
