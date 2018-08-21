package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.dddml.wms.security.JwtUser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by yangjiefeng on 2018/8/21.
 */
public class JwtTests {

    public static void main(String[] args) {
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

        String url = "http://localhost:8080/api/InOuts";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("ACCEPT", "application/json");
            httpGet.setHeader("Authorization", "Bearer " + token);
            HttpResponse response = client.execute(httpGet);
            //Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
            System.out.println(response.getStatusLine().getStatusCode());
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                //sb.append(line + "/n");
                System.out.println(line);
            }
            System.out.println(reader.readLine());
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
