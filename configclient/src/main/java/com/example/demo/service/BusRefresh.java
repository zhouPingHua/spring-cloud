package com.example.demo.service;

import org.apache.http.impl.client.BasicCookieStore;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zph  Date：2017/8/29.
 */
@Component
public class BusRefresh extends AbstractHttpService {

    /**
    *@param:
    *@Description:刷新接口
    *
    */
    public void refresh() {
        LoginContext loginContext = createLoginContext(new BasicCookieStore(), null);
//        String url = "http://127.0.0.1:8881/bus/refresh";
//        loginContext.setEncoding("utf-8");
        loginContext.setUri("http://127.0.0.1:8881/bus/refresh?destination=config-client:**");
        loginContext.setParams(null);
        doPost(loginContext);
    }
}
