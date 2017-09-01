package com.example.demo.config;

import com.example.demo.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by zph  Date：2017/8/18.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
