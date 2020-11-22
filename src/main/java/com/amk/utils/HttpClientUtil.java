package com.amk.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
    private static final String PRIFIX_URL = "http://127.0.0.1:8082";

    public static String getData(String url){
        CloseableHttpClient httpClient = null;
        HttpPut httpPut = null;
        CloseableHttpResponse response = null;
        String content = null;

        try {
            //1：获取httpClient实例
            httpClient = HttpClients.createDefault();

            //2：获取请求实例 get(select)  post(insert)   put(update)   delete(delete)
            httpPut = new HttpPut(PRIFIX_URL+url);

            //3：发送请求
            response = httpClient.execute(httpPut);

            //4：获取返回的实体(entity)
            HttpEntity entity = response.getEntity();

            //5：获取网页内容
            content = EntityUtils.toString(entity, "utf-8");

            //5：释放资源
            if(response!=null){
                response.close();
            }
            if(httpClient!=null){
                httpClient.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return content;
    }

}
