package com.camel.jdbc.server.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelJDBCRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("timer://queryAward?period=60s").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {

				Message message = exchange.getOut();
				message.setBody(
						"insert into award(nickname,account,password,message, remark) values ('ooo','vvv','bbb','234567','0000');");
			}
		}).to("jdbc:DataSource").to("log:JDBCRoutesTest?showExchangeId=true");

	}

}
