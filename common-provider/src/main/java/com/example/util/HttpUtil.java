package com.example.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtil {

    public static String doGet(String url) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet requestGet = new HttpGet(url);
            HttpResponse execute = httpClient.execute(requestGet);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
