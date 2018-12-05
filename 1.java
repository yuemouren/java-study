package com.offcn.util;

import org.springframework.web.client.RestTemplate;

public class TestMobile {
	//这是我新加入的注解
	public static void main(String[] args) {
		
		RestTemplate template = new RestTemplate();
		Message forObject = template.getForObject("http://localhost:8080/WebServiceCallerloc/service/seach/get/15843118494",Message.class);
		System.out.println(forObject);
	}

}
