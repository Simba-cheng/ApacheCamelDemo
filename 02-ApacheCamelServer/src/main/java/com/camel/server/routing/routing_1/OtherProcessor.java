package com.camel.server.routing.routing_1;

import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.commons.io.IOUtils;

public class OtherProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message message = exchange.getIn();

		System.out.println("OtherProcessor中的exchange" + exchange);

		InputStream body = (InputStream) message.getBody();
		String str = IOUtils.toString(body, "UTF-8");

//		System.out.println("OtherProcessor str : " + str);

		// 存入到exchange的out区域
		if (exchange.getPattern() == ExchangePattern.InOut) {
			Message outMessage = exchange.getOut();
			outMessage.setBody(str + " || 被OtherProcessor处理");
		}
	}

}
