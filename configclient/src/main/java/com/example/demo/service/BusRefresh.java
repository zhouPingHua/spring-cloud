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
        BusRefresh main = new BusRefresh();
        LoginContext loginContext = createLoginContext(new BasicCookieStore(), null);
        Map<String, String> headers = loginContext.getRequestHeaders();
        headers.put("Accept", "text/html, application/xhtml+xml, */*");
        headers.put("Accept-Language", "zh-CN");
        headers.put("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/7.0)");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Host", "127.0.0.1");
        headers.put("Connection", "Keep-Alive");
//        String url = "http://127.0.0.1:8881/bus/refresh?destination=config-client:**";
        String url = "http://127.0.0.1:8881/bus/refresh";
        loginContext.setEncoding("utf-8");
        loginContext.setUri(url);
        loginContext.setParams(null);
        String errHtml = doPost(loginContext);
        System.out.println(  errHtml);
    }
}
