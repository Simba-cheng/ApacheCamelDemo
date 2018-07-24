package com.camel.jdbc.server.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class CamelJDBCProcesser implements Processor {

	public static final Logger logger = Logger.getLogger(CamelJDBCProcesser.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		String str = exchange.getIn().getBody().toString();
		logger.info("str : " + str);

		Object obj = exchange.getIn().getBody();
		logger.info("obj : " + obj.getClass());
		logger.info("obj : " + obj);
	}

}
