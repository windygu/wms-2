package org.dddml.wms.restful.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.dddml.wms.domain.product.CreateOrMergePatchProductDto;
import org.dddml.wms.restful.resource.ImportServiceResource;
import org.dddml.wms.security.JwtUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by yangjiefeng on 2018/8/25.
 */
public class InitInventoryItems {

    private static String baseUrl = "http://47.104.74.139:8080/api/";
    // /////////////////////////////////////////////////////////////
    private static String authUrl = "http://47.104.74.139:8080/api/iam/oauth2/token";
    private static String username = "006";
    private static String password = "xxxxxxxx";
    /**
     * 在知道 Secret 的情况下，可以自己创建一个 JWT Token。
     */
    private static String jwtSecret = "xxxxxxxx";
    // /////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        String token = null;
        String url = null;
        // //////////////////////////////
        token = getJwtToken();
        //token = getJwtTokenRemote();

        // ////////////////////////////////////////
        url = appendUrl(baseUrl, "ImportService/InitializeInventoryItems");
        ImportServiceResource.InitializingInventoryItemSettings importSettings = getInitializingInventoryItemSettings();
        doInitInventoryItems(token, url, importSettings);
        //（现在只是生成若干入库单，执行掉这些入库单，库存就初始化好了）
        // ///////////////////////////////////////
    }

    // ///////////////////////////////////////

    private static void doInitInventoryItems(String token, String url,
                                             ImportServiceResource.InitializingInventoryItemSettings importSettings) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = doHttpPost(client, token, url, importSettings);
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

    private static ImportServiceResource.InitializingInventoryItemSettings getInitializingInventoryItemSettings() {
        ImportServiceResource.InitializingInventoryItemSettings settings = new ImportServiceResource.InitializingInventoryItemSettings();

        // ////////////////// 导入文件的列名设置 ////////////////////////
        settings.setEntryDateColumnName("入库时间");// 入库时间
        settings.setLocatorIdColumnName("Locator Id");// 货位 Id
        settings.setSerialNumberColumnName("Package");// 序列号即包装 Id
        settings.setAirDryMetricTonColumnName("ADMT");
        // 如果 Excel 中的列名没有使用默认值，就需要设置！！！
        //settings.setQuantityColumnName("重量（公斤）"); // （以主计量单位计算的）数量的列名

        // ////////////////  产品名称到 产品 Id 的映射关系 //////////////////
        // 一般来说，Excel 中有多少种产品，就需要添加多少个“品名映射”
        ImportServiceResource.ProductMapping prdMapping1 = new ImportServiceResource.ProductMapping();
        prdMapping1.setProductName("GOLDEN ISLES CO FLUFF PULP");//在 Excel 中出现的产品名称
        prdMapping1.setProductId("21001");//在系统中的产品 Id（Product Id）
        settings.setProductMap(new ImportServiceResource.ProductMapping[]{prdMapping1});

        // ////////////////  导入库存文件的 URL ////////////////////////
        // 需要先将导入文件“上传”到本服务能访问到的 URL 地址
        String fileUrl = "file:///C:\\Users\\yangjiefeng\\Documents\\青岛\\初始化库存示例.xls";
        settings.setFileUrl(fileUrl);

        return settings;
    }

    // /////////////////////////////////////////////////////////
    // 以下是（相对）通用的代码
    // /////////////////////////////////////////////////////////

    /**
     * 在知道 Secret 的情况下，可以自己创建一个 JWT Token。
     * @return
     */
    private static String getJwtToken() {
        JwtUser u = new JwtUser();
        u.setUsername("001");
        u.setRole("admin");

        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("role", u.getRole());
        //claims.put("userId", u.getId());

        String secret = jwtSecret;
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        System.out.println(token);
        return token;
    }

    /**
     * 从认证服务器上获取一个 Token（需要知道用户名和密码）。
     * @return
     */
    private static String getJwtTokenRemote() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpPost httpPost = new HttpPost(authUrl);
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

    private static String appendUrl(String url, String component) {
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
}
