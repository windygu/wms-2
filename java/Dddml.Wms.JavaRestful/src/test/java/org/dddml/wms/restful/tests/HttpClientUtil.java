package org.dddml.wms.restful.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiefeng on 2018/8/26.
 */
public class HttpClientUtil {

    public static void post(String token, String url, Object obj) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = doHttpPost(client, token, url, obj);
            int responseCode = response.getStatusLine().getStatusCode();
            //Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            System.out.println("==========================================");
            System.out.println(responseCode);
            System.out.println("==========================================");
            System.out.println(readString(response));
            client.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void put(String token, String url, Object obj) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = doHttpPut(client, token, url, obj);
            int responseCode = response.getStatusLine().getStatusCode();
            //Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            System.out.println("==========================================");
            System.out.println(responseCode);
            System.out.println("==========================================");
            System.out.println(readString(response));
            client.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /**
     * 从认证服务器上获取一个 Token（需要知道用户名和密码）。
     * @return
     */
    public static String getJwtTokenRemote(String authTokenUrl, String username, String password) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpPost httpPost = new HttpPost(authTokenUrl);
            httpPost.setHeader("ACCEPT", "application/json");
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("grant_type", "password"));
            pairs.add(new BasicNameValuePair("client_id", "malls"));
            pairs.add(new BasicNameValuePair("username", username));
            pairs.add(new BasicNameValuePair("password", password));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
            httpPost.setEntity(entity);
            HttpResponse response = client.execute(httpPost);
            //Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
            System.out.println(response.getStatusLine().getStatusCode());
            String jsonStr = readString(response);
            System.out.println(jsonStr);
            client.close();
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            String token = (String)jsonObject.get("access_token");
            if (token == null) {
                throw new NullPointerException("access_token is null.");
            }
            System.out.println(token);
            return token;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static String appendUrl(String url, String component) {
        return (url.endsWith("/") ? url : url + "/") + component;
    }

    /**
     * 执行 Http POST
     */
    private static HttpResponse doHttpPost(CloseableHttpClient client, String token, String url, Object dto) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + token);
        String json = JSON.toJSONString(dto);
        StringEntity entity = new StringEntity(json, "utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        //getContentFromResponse(response);
        return client.execute(httpPost);
    }

    /**
     * 执行 Http PUT
     */
    private static HttpResponse doHttpPut(CloseableHttpClient client, String token, String url, Object dto) throws IOException {
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-Type", "application/json");
        httpPut.setHeader("Authorization", "Bearer " + token);
        String json = JSON.toJSONString(dto);
        StringEntity entity = new StringEntity(json, "utf-8");
        entity.setContentType("application/json");
        httpPut.setEntity(entity);
        //getContentFromResponse(response);
        return client.execute(httpPut);
    }

    /**
     * 将 HTTP 的响应内容读为字符串。
     * @param response
     * @return
     * @throws IOException
     */
    static String readString(HttpResponse response) throws IOException {
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
