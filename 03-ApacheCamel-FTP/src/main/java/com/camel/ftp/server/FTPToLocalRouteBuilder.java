package com.camel.ftp.server;

import org.apache.camel.builder.RouteBuilder;

/**
 * 从FTP服务器上下载文件至本地.
 * 
 * @author CYX
 * @time 2017年12月19日下午8:12:35
 */
public class FTPToLocalRouteBuilder extends RouteBuilder {

	// 从FTP上下载文件
	@Override
	public void configure() throws Exception {
		from("ftp://10.0.227.66/?username=cloudsftp&password=cloudsftp&binary=true&passiveMode=true&delete=true&delay=5000").to("file:/temp");
	}

}
