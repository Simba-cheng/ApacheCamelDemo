package com.server;


import com.server.dto.PersonDTO;
import com.server.util.CommonUtils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author CYX
 */
public class TestClient {

    public static void main(String[] args) {

        try {

            //启动路由
            //startRoute();

            //停止路由
            stopRoute();

            //暂停路由
            //suspendRoute();

            //测试其他路由
            //testOtherRoutes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动路由
     */
    private static void startRoute() throws Exception {

        System.out.println("http post start !!!");
        Long startTime = System.currentTimeMillis();

        URL url = new URL("http://127.0.0.1:8282/masterRoute");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("CYX");
        personDTO.setId("320265551212584512");
        personDTO.setAge("32");
        personDTO.setSlaveFlag("1");
        String param = CommonUtils.toJSONStr(personDTO);

        System.out.println("发送消息 : " + param);

        String result = HttpClient.doPost(param, 30000000, http);

        System.out.println("调用时间 : " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("返回数据 : " + result);
    }

    /**
     * 停止路由
     */
    private static void stopRoute() throws Exception {

        System.out.println("http post start !!!");
        Long startTime = System.currentTimeMillis();

        URL url = new URL("http://127.0.0.1:8282/masterRoute");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("CYX");
        personDTO.setId("320265551212584512");
        personDTO.setAge("32");
        personDTO.setSlaveFlag("0");
        String param = CommonUtils.toJSONStr(personDTO);

        System.out.println("发送消息 : " + param);

        String result = HttpClient.doPost(param, 30000000, http);

        System.out.println("调用时间 : " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("返回数据 : " + result);

    }

    /**
     * 暂停路由
     */
    private static void suspendRoute() throws Exception {

        System.out.println("http post start !!!");
        Long startTime = System.currentTimeMillis();

        URL url = new URL("http://127.0.0.1:8282/masterRoute");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("CYX");
        personDTO.setId("320265551212584512");
        personDTO.setAge("32");
        personDTO.setSlaveFlag("2");
        String param = CommonUtils.toJSONStr(personDTO);

        System.out.println("发送消息 : " + param);

        String result = HttpClient.doPost(param, 30000000, http);

        System.out.println("调用时间 : " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("返回数据 : " + result);

    }

    /**
     * 测试其他路由
     */
    private static void testOtherRoutes() throws Exception {

        System.out.println("http post start !!!");
        Long startTime = System.currentTimeMillis();

        //URL url = new URL("http://127.0.0.1:8282/test-route-control");
        //URL url = new URL("http://127.0.0.1:8282/test-route-contro2");

        //如果该路由并未启动，是无法调用的。
        URL url = new URL("http://127.0.0.1:8282/test-route-contro3");

        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("CYX");
        personDTO.setId("320265551212584512");
        personDTO.setAge("32");
        personDTO.setSlaveFlag("1");
        String param = CommonUtils.toJSONStr(personDTO);

        System.out.println("发送消息 : " + param);
        String result = HttpClient.doPost(param, 30000000, http);
        System.out.println("调用时间 : " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("返回数据 : " + result);
    }

}
