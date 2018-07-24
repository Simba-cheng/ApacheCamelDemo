package org.apache.hello_world_soap_http;

public interface Greeter {
	
	String greetMe(String param);
	
	void greetMeOneWay(String param);
	
	String sayHi();
	
	void pingMe(String param);
}
