package com.test.client;

import java.net.URL;

import org.service.query.QueryServiceInter;
import org.service.query.QueryServiceService;

public class TestClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9080/server/queryservice?wsdl");

		QueryServiceService queryServiceService = new QueryServiceService(url);

		QueryServiceInter queryServiceInter = queryServiceService.getQueryServicePort();

		String carInfoStr = queryServiceInter.queryCarInfomation("宝马");

		String personStr = queryServiceInter.queryPersonnelInformation("马云");

		System.out.println(carInfoStr);
		System.out.println(personStr);

	}

}
