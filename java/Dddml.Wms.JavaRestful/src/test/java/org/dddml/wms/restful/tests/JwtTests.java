package org.dddml.wms.restful.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.dddml.wms.domain.product.CreateOrMergePatchProductDto;
import org.dddml.wms.security.JwtUser;
import org.dddml.wms.security.JwtUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/8/21.
 */
public class JwtTests {

    private static String baseUrl = "http://localhost:8080/api/";

    public static void main(String[] args) {
        // ///////////////////////////////////////////////
        //        CRM JWT Token:
        //        String token_0 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJOaWNrTmFtZSI6IuWOpumXqOa5lua7qOWNl-i3r-W6lyIsIlBob25lIjoiMTE4MTE2MTQzODI1IiwiVXNlcklkIjoiMzE1NDY2IiwiVXNlclR5cGUiOiJBIiwiUm9sZXMiOiIxIiwiU3RvcmVJZCI6IjMxNTQ2NiIsImV4cCI6MTUzOTI3MzAyMSwiaXNzIjoiY3JtIiwiYXVkIjoiY3JtIn0.s3uhIME7ylozXBk7FDwGLOFsKSZ8NIViENpqgQaycF0";
        //        token_0 = token_0.substring(0, token_0.lastIndexOf(".") + 1);
        //        Claims claims = Jwts.parser()
        //                .setSigningKey("xxxx")
        //                .parseClaimsJwt(token_0)
        //                .getBody();
        //        System.out.println(claims);
        //        //{NickName=厦门湖滨南路店, Phone=118116143825, UserId=315466, UserType=A, Roles=1, StoreId=315466, exp=1539273021, iss=crm, aud=crm}
        //        //System.out.print(claims.get("NickName"));
        //        if(true) return;

        // ///////////////////////////////////////////////
        //        String token_1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bXMtaWFtIiwic3ViIjoiYWRtaW4iLCJhdWQiOiJ3bXMiLCJleHAiOjE1NDAzODIxOTMsImlhdCI6MTU0MDM3ODU5Mywicm9sZSI6ImFkbWluLGd1ZXN0LGNlc2hpMyIsInVzZXJfZ3JvdXAiOiJjazAwMSxjazAwMixjazAwMyJ9.sm_4EYtE6VNNj1fZaNDFTVWmiBOb316NeYS9l0VW8Sw";
        //        token_1 = token_1.substring(0, token_1.lastIndexOf(".") + 1);
        //        Claims claims = Jwts.parser()
        //                .setSigningKey("xxxx")
        //                .parseClaimsJwt(token_1)
        //                .getBody();
        //        System.out.println(claims);
        //        //{iss=wms-iam, sub=admin, aud=wms, exp=1540382193, iat=1540378593, role=admin,guest,ceshi3, user_group=ck001,ck002,ck003}
        //        if(true) return;

        //        String token_1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bXMtaWFtIiwic3ViIjoiYWRtaW4iLCJhdWQiOiJ3bXMiLCJleHAiOjE1NDAzODIxOTMsImlhdCI6MTU0MDM3ODU5Mywicm9sZSI6ImFkbWluLGd1ZXN0LGNlc2hpMyIsInVzZXJfZ3JvdXAiOiJjazAwMSxjazAwMixjazAwMyJ9.sm_4EYtE6VNNj1fZaNDFTVWmiBOb316NeYS9l0VW8Sw";
        //        JwtUtil jwtUtil = new JwtUtil();
        //        JwtUser jwtUser = jwtUtil.parseToken(token_1);
        //        System.out.println(jwtUser.getAuthorities());
        //        //[admin, guest, ceshi3]
        //        System.out.println(jwtUser.getUserGroups());
        //        //[ck001, ck002, ck003]
        //        if (true) return;

        String token = null;
        String url = null;

        // //////////////////////////////
        //        token = getJwtToken();
        //        url = appendUrl(baseUrl, "ImportService/TestInitializeInventoryItems");
        //        testGet(token, url);
        //        if (true) { return; }
        // /////////////////////////////
        //        token = getJwtToken();
        //        url = appendUrl(baseUrl, "ImportService/TestImportShipments");
        //        testGet(token, url);
        //        if (true) { return; }

        token = getJwtTokenRemote();

        url = appendUrl(baseUrl, "InOuts");
        testGetInouts(token, url);

        url = appendUrl(baseUrl, "Products");
        testPutProduct(token, url);

    }

    private static String appendUrl(String url, String component) {
        return (url.endsWith("/") ? url : url + "/") + component;
    }

    private static void testPutProduct(String token, String url) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();

            String productId = UUID.randomUUID().toString();
            String productUrl = appendUrl(url, productId);
            CreateOrMergePatchProductDto.CreateProductDto dto = new CreateOrMergePatchProductDto.CreateProductDto();
            dto.setCommandId(UUID.randomUUID().toString());
            dto.setProductName("test-prd-" + productId);
            dto.setAmountUomTypeId("kg");

            HttpResponse response = doHttpPut(client, token, productUrl, dto);
            int responseCode = response.getStatusLine().getStatusCode();
            //Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            System.out.println("==========================================");
            System.out.println(responseCode);
            System.out.println("==========================================");
            client.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }

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

    private static void testGetInouts(String token, String url) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = doHttpGet(client, token, url);
            String jsonStr = readString(response);
            System.out.println("==========================================");
            System.out.println(jsonStr);
            System.out.println("==========================================");
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void testGet(String token, String url) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = doHttpGet(client, token, url);
            String str = readString(response);
            System.out.println("==========================================");
            System.out.println(str);
            System.out.println("==========================================");
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static HttpResponse doHttpGet(CloseableHttpClient client, String token, String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("ACCEPT", "application/json");
        httpGet.setHeader("Authorization", "Bearer " + token);
        HttpResponse response = client.execute(httpGet);
        //Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
        System.out.println(response.getStatusLine().getStatusCode());
        return response;
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
        u.setRole("admin,inOutOp");
        //u.setId("yangjf");

        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("role", u.getRole());
        //claims.put("userId", u.getId());

        String secret = "xxxxxxxx";
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        System.out.println(token);
        return token;
    }
}
