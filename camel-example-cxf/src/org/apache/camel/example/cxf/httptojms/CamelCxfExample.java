/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.cxf.httptojms;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.PropertyConfigurator;

/**
 * An example for demonstrating how Camel works as a Router. This example shows
 * how Camel can route a SOAP client's HTTP request to a SOAP over JMS Service.
 */
public final class CamelCxfExample {
	private static final String ROUTER_ADDRESS = "http://localhost:{{routerPort}}/SoapContext/SoapPort";
	private static final String SERVICE_CLASS = "serviceClass=org.apache.hello_world_soap_http.Greeter";
	private static final String WSDL_LOCATION = "wsdlURL=wsdl/hello_world.wsdl";
	private static final String SERVICE_NAME = "serviceName={http://apache.org/hello_world_soap_http}SOAPService";
	private static final String SOAP_OVER_HTTP_ROUTER = "portName={http://apache.org/hello_world_soap_http}SoapOverHttpRouter";

	private static final String ROUTER_ENDPOINT_URI = "cxf://" + ROUTER_ADDRESS + "?" + SERVICE_CLASS + "&" + WSDL_LOCATION + "&" + SERVICE_NAME + "&" + SOAP_OVER_HTTP_ROUTER + "&dataFormat=POJO";

	
	private CamelCxfExample() {
	}

	public static void main(String args[]) throws Exception {

		PropertyConfigurator.configure("./conf/log4j.properties");
		PropertyConfigurator.configureAndWatch("./conf/log4j.properties", 1000);

		System.setProperty("routerPort", "9001");
		System.setProperty("servicePort", "9003");

		CamelContext context = new DefaultCamelContext();

		PropertiesComponent pc = new PropertiesComponent();
		context.addComponent("properties", pc);

		try {

			context.addRoutes(new RouteBuilder() {
				public void configure() {

					from(ROUTER_ENDPOINT_URI).to("log:CamelCxfExample?showExchangeId=true");
				}
			});

			String address = ROUTER_ADDRESS.replace("{{routerPort}}", System.getProperty("routerPort"));

			System.out.println("Address : " + address);

			context.start();

			synchronized (CamelCxfExample.class) {
				CamelCxfExample.class.wait();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// server.stop();
			// broker.stop();
			System.exit(0);
		}

	}
}
