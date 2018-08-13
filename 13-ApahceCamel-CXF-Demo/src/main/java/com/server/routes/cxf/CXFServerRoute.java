//package com.server.routes.cxf;
//
//import org.apache.camel.Exchange;
//import org.apache.camel.Processor;
//import org.apache.camel.builder.RouteBuilder;
//
//
//
///**
// * @author CYX
// * @create 2018-08-07-23:32
// */
//public class CXFServerRoute extends RouteBuilder {
//
//    // CXF webservice using code first approach
//    private String uri = "cxf:/incident?serviceClass=" + IncidentService.class.getName();
//
//    @Override
//    public void configure() throws Exception {
//        from(uri)
//                .to("log:input")
//                // send the request to the route to handle the operation
//                // the name of the operation is in that header
//                .recipientList(simple("direct:${header.operationName}"));
//
//        // report incident
//        from("direct:reportIncident")
//                .process(new Processor() {
//                    public void process(Exchange exchange) throws Exception {
//                        // get the id of the input
//                        String id = exchange.getIn().getBody(InputReportIncident.class).getIncidentId();
//
//                        // set reply including the id
//                        OutputReportIncident output = new OutputReportIncident();
//                        output.setCode("OK;" + id);
//                        exchange.getOut().setBody(output);
//                    }
//                })
//                .to("log:output");
//
//        // status incident
//        from("direct:statusIncident")
//                .process(new Processor() {
//                    public void process(Exchange exchange) throws Exception {
//                        // set reply
//                        OutputStatusIncident output = new OutputStatusIncident();
//                        output.setStatus("IN PROGRESS");
//                        exchange.getOut().setBody(output);
//                    }
//                })
//                .to("log:output");
//    }
//
//}
