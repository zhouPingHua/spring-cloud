package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@RestController
@RefreshScope
public class Servicehi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Servicehi2Application.class, args);
	}

	@Value("${server.port}")
	String port;

	//server.ww
	@Value("${server.ww}")
	String ww;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port+"  "+ww;
	}
}
