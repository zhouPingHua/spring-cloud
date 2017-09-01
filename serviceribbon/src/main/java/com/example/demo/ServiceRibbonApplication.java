package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/*
* @EnableDiscoveryClient向服务中心注册
* 并且向程序的ioc注入一个bean: restTemplate;
* 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
*
*
* RestTemplate+Ribbon去消费服务
*
* 监控页面
* http://10.0.10.96:8764/hystrix
* http://10.0.10.96:8764/hystrix.stream
* http://10.0.10.96:8764/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8764%2Fhystrix.stream&title=haha
*
*
* */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}