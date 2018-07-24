package com.camel.jms.server;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.PropertyConfigurator;

/**
 * 从mq中读取数据
 * 
 * @author CYX
 * @time 2017年12月20日下午2:16:40
 */
public class ActiveMQCamel {

	private static String user = ActiveMQConnection.DEFAULT_USER;

	private static String password = ActiveMQConnection.DEFAULT_PASSWORD;

	// private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String url = "failover://tcp://192.168.137.150:61616";

	public static void main(String[] args) throws Exception {

		PropertyConfigurator.configure("./conf/log4j.properties");
		PropertyConfigurator.configureAndWatch("./conf/log4j.properties", 1000);

		CamelContext context = new DefaultCamelContext();

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);

		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		System.out.println(url + " " + user + " " + password);

		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("jms:queue:hoo.mq.queue").to("file:./input").to("log:activemqcamel?showExchangeId=true");
			}
		});

		context.start();

		// 通用没有具体业务意义的代码，只是为了保证主线程不退出
		synchronized (ActiveMQCamel.class) {
			ActiveMQCamel.class.wait();
		}

	}

}
