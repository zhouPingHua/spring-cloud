package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zph  Date：2017/8/18.
 *
 * @HystrixCommand  当服务出现问题，请求转到hiError
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://servicehi/hi?name="+name,String.class);
    }


    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
