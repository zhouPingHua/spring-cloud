package com.example.demo;

import com.example.demo.service.BusRefresh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${server.ww}")
	String foo;
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}

	//democonfigclient.message
//	@Value("${democonfigclient.message}")
	String message;
	@RequestMapping(value = "/hi2")
	public String hi2(){
		return message;
	}

	@Autowired
	private BusRefresh busRefresh;
	@RequestMapping(value = "/refresh.go")
	public void refresh(){
		busRefresh.refresh();
	}
}
