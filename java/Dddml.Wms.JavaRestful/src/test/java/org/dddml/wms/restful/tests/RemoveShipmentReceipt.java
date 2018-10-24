package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.service.OrderIdShipGroupSeqIdPair;
import org.dddml.wms.domain.service.OrderItemShipGroupAssociationInfo;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.security.JwtUser;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;


/**
 * 创建入库通知单。
 * Created by yangjiefeng on 2018/8/25.
 */
public class RemoveShipmentReceipt {

    // /////////////////////// 命令（写） API 服务地址 /////////////////////////
    //private static String baseUrl = "http://47.104.74.139:8080/api/";
    private static String baseUrl = "http://localhost:8080/api/";

    // //////////////  IAM（认证）服务获取 JWT Token 接口地址 ///////////////////
    private static String authTokenUrl = "http://47.104.74.139:8080/api/iam/oauth2/token";
    //private static String authTokenUrl = "http://localhost:8080/api/iam/oauth2/token";
    private static String username = "006";
    private static String password = "xxxxxx";//需要密码！！！


    // /////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        String token = null;
        String url = null;
        // /////////////////////////////////////////
        // 获取一个有效的 Token
        token = getJwtToken();
        //token = HttpClientUtil.getJwtTokenRemote(authTokenUrl, username, password);

        String shipmentId = "1540375370930";//装运单号
        String receiptSeqId = "10002";//接收行项序号
        String shipmentVersion = "5";//装运单当前版本
        String commandId = UUID.randomUUID().toString();//Command Id

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl,
                "Shipments/" + shipmentId + "/ShipmentReceipts/" + receiptSeqId);
        url = url + "?version=" + shipmentVersion + "&commandId=" + commandId;
        System.out.println(url);
        HttpClientUtil.delete(token, url);
    }

    // //////////////////////////////////////////////////////////////

    /**
     * 在知道 Secret 的情况下，也可以自己创建一个 JWT Token。
     */
    private static String jwtSecret = "bWFsbHM=";

    private static String getJwtToken() {
        JwtUser u = new JwtUser();
        u.setUsername("001");
        u.setRole("ADMIN");

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
