package com.server;

import com.server.conf.LogBackConfigLoader;
import com.server.route.BootStoreRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Apache Camel With CXF-JAXRS(Code First)
 * <p>
 * https://github.com/apache/camel/tree/master/examples/camel-example-cxf
 *
 * @author CYX
 */
public class CamelWithCxfServerMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(CamelWithCxfServerMain.class);

    private static final String LOGBACK_FILENAME = "./conf/logback.xml";

    public static void main(String[] args) {

        try {

            LogBackConfigLoader.loadLogBack(LOGBACK_FILENAME);

            CamelContext context = new DefaultCamelContext();

            context.start();

            context.addRoutes(new BootStoreRoute());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
