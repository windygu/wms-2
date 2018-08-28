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

    // /////////////////////// 命令（写） API 服务地址 /////////////////////////
    //private static String baseUrl = "http://47.104.74.139:8080/api/";
    private static String baseUrl = "http://localhost:8080/api/";

    // //////////////  IAM（认证）服务获取 JWT Token 接口地址 ///////////////////
    private static String authTokenUrl = "http://47.104.74.139:8080/api/iam/oauth2/token";
    //private static String authTokenUrl = "http://localhost:8080/api/iam/oauth2/token";
    private static String username = "006";
    private static String password = "XXXXXX";//需要密码！！！

    // /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        String token = null;
        String url = null;
        // /////////////////////////////////////////
        // 获取一个有效的 Token
        token = getJwtToken();
        //token = HttpClientUtil.getJwtTokenRemote(authTokenUrl, username, password);

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "ImportService/InitializeInventoryItems");
        ImportServiceResource.InitializingInventoryItemSettings importSettings = getInitializingInventoryItemSettings();
        doInitInventoryItems(token, url, importSettings);
        //（现在只是生成若干入库单，执行掉这些入库单，库存就初始化好了）
        // ///////////////////////////////////////
    }

    private static ImportServiceResource.InitializingInventoryItemSettings getInitializingInventoryItemSettings() {
        ImportServiceResource.InitializingInventoryItemSettings settings = new ImportServiceResource.InitializingInventoryItemSettings();

        // ////////////////  导入库存文件的 URL ////////////////////////
        // 需要先将导入文件“上传”到本服务能访问到的 URL 地址
        //String fileUrl = "file:///C:\\Users\\yangjiefeng\\Documents\\青岛\\初始化库存示例.xls";
        String fileUrl = "https://takumi.oss-cn-qingdao.aliyuncs.com/%E7%BB%92%E6%AF%9B%E6%B5%86%E5%BA%93%E5%AD%98%E6%B1%87%E6%80%BB20180825.xls";
        settings.setFileUrl(fileUrl);

        // /////////////////////////////////////////////////////////
        //每次导入可以使用不同的前缀，防止生成的单据（入库单） Id 冲突导致导入失败
        // /////////////////////////////////////////////////////////
        settings.setDocumentPrefix("II");

        // ////////////////// 导入文件的列名设置 ////////////////////////
        settings.setEntryDateColumnName("入库时间");// 入库时间
        settings.setLocatorIdColumnName("Locator Id");// 货位 Id
        settings.setSerialNumberColumnName("Package");// 序列号即包装 Id
        settings.setAirDryMetricTonColumnName("ADMT");
        // 如果 Excel 中的列名没有使用默认值，就需要设置！！！
        //settings.setQuantityColumnName("重量（公斤）"); // （以主计量单位计算的）数量的列名

        // ////////////////  产品名称到 产品 Id 的映射关系 //////////////////
        // 一般来说，Excel 中有多少种“没有使用产品 Id”作为 Product 列的值的产品，
        // 就需要添加多少个“品名映射”
        //ImportServiceResource.ProductMapping prdMapping1 = new ImportServiceResource.ProductMapping();
        //prdMapping1.setProductName("GOLDEN ISLES CO FLUFF PULP");//在 Excel 中出现的产品名称
        //prdMapping1.setProductId("21001");//在系统中的产品 Id（Product Id）

        settings.setProductMap(new ImportServiceResource.ProductMapping[]{});//prdMapping1

        return settings;
    }


    private static void doInitInventoryItems(String token, String url,
                                             ImportServiceResource.InitializingInventoryItemSettings importSettings) {
        HttpClientUtil.post(token, url, importSettings);
    }
    // //////////////////////////////////////////////////////////////

    /**
     * 在知道 Secret 的情况下，也可以自己创建一个 JWT Token。
     */
    private static String jwtSecret = "xxxxxxxx";

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

}
