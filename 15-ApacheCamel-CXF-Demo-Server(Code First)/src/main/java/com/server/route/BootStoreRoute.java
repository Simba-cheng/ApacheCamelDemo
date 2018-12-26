package com.server.route;

import com.server.process.MappingProcessor;
import com.server.resources.BookStoreImpl;
import org.apache.camel.builder.RouteBuilder;

/**
 * @author CYX
 * @create 2018-12-26-22:45
 */
public class BootStoreRoute extends RouteBuilder {

    private static final String SOAP_ENDPOINT_URI = "cxf://http://localhost:9006/soap?serviceClass=com.server.resources.BookStore";
    private static final String REST_ENDPOINT_URI = "cxfrs://http://localhost:9002/rest?resourceClasses=com.server.resources.BookStoreImpl";

    @Override
    public void configure() throws Exception {

        // populate the message queue with some messages
        from(SOAP_ENDPOINT_URI).process(new MappingProcessor(new BookStoreImpl(false)));

        from(REST_ENDPOINT_URI).process(new MappingProcessor(new BookStoreImpl(true)));
    }
}
