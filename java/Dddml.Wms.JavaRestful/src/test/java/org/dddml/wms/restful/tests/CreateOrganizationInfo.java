package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.party.CreateOrMergePatchPartyDto;
import org.dddml.wms.security.JwtUser;


/**
 * 创建组织信息。
 * Created by yangjiefeng on 2018/8/25.
 */
public class CreateOrganizationInfo {

    // /////////////////////// 命令（写） API 服务地址 /////////////////////////
    private static String baseUrl = "http://47.104.74.139:8080/api/";
    //private static String baseUrl = "http://localhost:8080/api/";

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
        //token = getJwtToken();
        token = HttpClientUtil.getJwtTokenRemote(authTokenUrl, username, password);

        // /////////////////// 组织 Id  ////////////////////////////
        String orgPartyId = "mallsVipCo";
        CreateOrMergePatchPartyDto.CreatePartyDto createPerson = new CreateOrMergePatchPartyDto.CreatePartyDto();
        createPerson.setPartyId(orgPartyId);
        // //////////////////  组织名称 ///////////////////////////
        createPerson.setOrganizationName("Shanghai MallsVIP E-Commerce Co.,Ltd.");
        createPerson.setActive(true);
        createPerson.setCommandId(orgPartyId);

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "Organizations/" + orgPartyId);
        HttpClientUtil.put(token, url, createPerson);

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
