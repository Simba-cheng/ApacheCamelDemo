package com.server.route;

import com.server.App;
import com.server.process.BaseicQueryProcess;
import com.server.service.impl.BaseicQueryImpl;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CYX
 * @create 2018-12-27-20:05
 */
public class BaseQueryRoute extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseQueryRoute.class);

    @Override
    public void configure() throws Exception {

        from(App.BASEQUERY_SERVICE_URL_ADDRESS).process(new BaseicQueryProcess(new BaseicQueryImpl()));

    }
}
