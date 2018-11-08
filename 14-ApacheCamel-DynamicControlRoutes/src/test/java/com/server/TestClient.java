package com.server;

import com.alibaba.fastjson.JSONObject;
import com.server.dto.PersonDTO;
import com.server.util.CommonUtils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author
 */
public class TestClient {

    public static void main(String[] args) {
        URL url = null;
        HttpURLConnection http = null;
        try {
            url = new URL("http://127.0.0.1:8282/test-route-control");

            singleCall00(url);
            //singleCall(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单次调用
     */
    private static void singleCall00(URL url) throws Exception {

        HttpURLConnection http = null;
        System.out.println("http post start !!!");
        Long startTime = System.currentTimeMillis();
        http = (HttpURLConnection) url.openConnection();

        String param = null;
        // ************************************************************
        //JSONObject requestJson = new JSONObject();
        //requestJson.put("serviceFlag", "1");
        //requestJson.put("desc", "123456");
        //param = requestJson.toString();
        // ************************************************************

        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("CYX");
        param = CommonUtils.toJSONStr(personDTO);


        System.out.println("发送消息 : " + param);
        String result = HttpClient.doPost(param, 30000000, http);
        System.out.println("调用时间 : " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("返回数据 : " + result);
        Thread.sleep(500);


    }

    /**
     * 单次调用
     */
    private static void singleCall(URL url) throws Exception {

        HttpURLConnection http = null;
        System.out.println("http post start !!!");
        Long startTime = System.currentTimeMillis();
        http = (HttpURLConnection) url.openConnection();

        // ************************************************************
        JSONObject requestJson = new JSONObject();
        requestJson.put("serviceFlag", "1");
        requestJson.put("desc", "123456");
        // ************************************************************


        StringBuffer sb = new StringBuffer();
        sb.append(requestJson.toString());
        System.out.println("发送消息 : " + sb.toString());
        String result = HttpClient.doPost(sb.toString(), 30000000, http);
        System.out.println("调用时间 : " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("返回数据 : " + result);
        Thread.sleep(500);


    }

}
