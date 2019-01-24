package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.inoutnotice.CreateOrMergePatchInOutNoticeDto;
import org.dddml.wms.domain.inoutnotice.InOutNoticeType;
import org.dddml.wms.domain.lot.CreateOrMergePatchLotDto;
import org.dddml.wms.security.JwtUser;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


/**
 * 创建个人信息。
 * Created by yangjiefeng on 2018/8/25.
 */
public class CreateLotInfo {

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
        //token = HttpClientUtil.getJwtTokenRemote(authTokenUrl, username, password);
        token = getJwtToken();

        String lotId = UUID.randomUUID().toString();
        CreateOrMergePatchLotDto.CreateLotDto createLotDto = new CreateOrMergePatchLotDto.CreateLotDto();
        createLotDto.setLotId(lotId);
        createLotDto.setExpirationDate(new Timestamp(new Date().getTime()));
        createLotDto.setActive(true);
        createLotDto.setCommandId(lotId);

        // ////////////////////////////////////////
        // 使用 PUT 方法
        //url = HttpClientUtil.appendUrl(baseUrl, "Lots/" + lotId);
        //HttpClientUtil.put(token, url, createLotDto);
        // ////////////////////////////////////////
        // 使用 POST 方法试试？
        url = HttpClientUtil.appendUrl(baseUrl, "Lots");
        HttpClientUtil.post(token, url, createLotDto);

    }

    // //////////////////////////////////////////////////////////////

    /**
     * 在知道 Secret 的情况下，也可以自己创建一个 JWT Token。
     */
    private static String jwtSecret = "bWFsbHM=";

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
