package org.dddml.wms.restful.tests;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.dddml.wms.security.JwtUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiefeng on 2018/8/21.
 */
public class JwtTests {

    public static void main(String[] args) {
        String token = getJwtTokenRemote();

        String url = "http://localhost:8080/api/InOuts";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("ACCEPT", "application/json");
            httpGet.setHeader("Authorization", "Bearer " + token);
            HttpResponse response = client.execute(httpGet);
            //Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
            System.out.println(response.getStatusLine().getStatusCode());
            String jsonStr = readString(response);
            System.out.println("==========================================");
            System.out.println(jsonStr);
            System.out.println("==========================================");
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getJwtTokenRemote() {
        String authUrl = "http://localhost:8089/iam/oauth2/token";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpPost httpPost = new HttpPost(authUrl);
            httpPost.setHeader("ACCEPT", "application/json");
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("grant_type", "password"));
            pairs.add(new BasicNameValuePair("client_id", "malls"));
            pairs.add(new BasicNameValuePair("username", "admin0"));
            pairs.add(new BasicNameValuePair("password", "admin0"));
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

    private static String readString(HttpResponse response) throws IOException {
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private static String getJwtToken() {
        JwtUser u = new JwtUser();
        u.setUsername("yang");
        u.setRole("admin,inoutop");
        //u.setId("yangjf");

        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("role", u.getRole());
        //claims.put("userId", u.getId());

        String secret = "mySecret";
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        System.out.println(token);
        return token;
    }
}
