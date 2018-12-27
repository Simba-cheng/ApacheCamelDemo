package com.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author CYX
 * @create 2018-12-27-19:59
 */
@WebService
public interface BaseicQuery {

    /**
     * 查询人员信息
     *
     * @param queryCondition 基础查询
     * @return
     */
    @WebMethod
    String queryPeopleInfo(@WebParam(name = "queryCondition") String queryCondition);

}
