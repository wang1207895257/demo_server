package com.example.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

    public static String doGet(String url) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet requestGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(requestGet);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());

                return strResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
