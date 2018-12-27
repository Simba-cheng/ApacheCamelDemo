package com.server;

import com.server.service.BaseicQuery;
import com.server.service.BaseicQueryService;

/**
 * Hello world!
 */
public class ClientApp {

    public static void main(String[] args) {

        BaseicQueryService baseicQueryService = new BaseicQueryService();
        BaseicQuery baseicQuery = baseicQueryService.getBaseicQueryPort();
        String resultMessage = baseicQuery.queryPeopleInfo("server , do you copy");
        System.out.println(resultMessage);

    }

}
