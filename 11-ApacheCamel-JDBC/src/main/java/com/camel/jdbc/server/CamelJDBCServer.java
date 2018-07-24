package com.camel.jdbc.server;

import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.model.ModelCamelContext;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.camel.jdbc.server.routes.CamelJDBCRoute;

public class CamelJDBCServer {

	public static final Logger logger = Logger.getLogger(CamelJDBCServer.class);

	public static void main(String[] args) {

		final String url = "jdbc:mysql://192.168.137.150:3306/test1";

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUsername("");
		basicDataSource.setPassword("");
		basicDataSource.setUrl(url);
		SimpleRegistry simpleregistry = new SimpleRegistry();
		simpleregistry.put("DataSource", basicDataSource);

		// 日志
		PropertyConfigurator.configure("./conf/log4j.properties");
		PropertyConfigurator.configureAndWatch("./conf/log4j.properties", 1000);

		try {

			ModelCamelContext camelContext = new DefaultCamelContext(simpleregistry);
			camelContext.start();

			camelContext.addRoutes(new CamelJDBCRoute());

			// 没有具体业务意义的代码，只是为了保证主线程不退出
			synchronized (CamelJDBCServer.class) {
				CamelJDBCServer.class.wait();
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}
