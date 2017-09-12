package com.example.demo.service;

import org.apache.http.impl.client.BasicCookieStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zph  Date：2017/8/29.
 */
@Component
public class BusRefresh extends AbstractHttpService {

//    @Value("${bus.refresh.url}")
    private static String url = "http://127.0.0.1:8762/bus/refresh";

    /**
    *@param:
    *@Description:刷新接口
    *
    */
    public void refresh() {
        LoginContext loginContext = createLoginContext(new BasicCookieStore(), null);
        loginContext.setEncoding("utf-8");
        loginContext.setUri(url);
        loginContext.setParams(null);
        doPost(loginContext);
    }
}
