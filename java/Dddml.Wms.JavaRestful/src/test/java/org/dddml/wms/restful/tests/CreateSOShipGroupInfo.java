package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.security.JwtUser;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


/**
 * 创建出库通知单。
 * Created by yangjiefeng on 2018/8/25.
 */
public class CreateSOShipGroupInfo {

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

        OrderShipGroupServiceCommands.CreateSOShipGroup createSOShipGroup = new OrderShipGroupServiceCommands.CreateSOShipGroup();
        // 合同号:
        createSOShipGroup.setOrderId("CCCCCC-XX");
        // 通知单号:
        createSOShipGroup.setShipGroupSeqId("" + 2018081801L);
        // 发货指示：（发货指示 / 客户信息 / 备注等）
        createSOShipGroup.setShippingInstructions("Xxxxx, yyyy, zzzzz");
        // ////////////// 产品 Id： /////////////////
        createSOShipGroup.setProductId("20XXX");
        //产品名称：	 GI SEMI-TREATED FLUFF
        //Grade：	8866
        //Quantity Uom: kg
        // //////////////////////////////////////////
        //数量（kg）:
        createSOShipGroup.setQuantity(BigDecimal.valueOf(500000));
        //件数:
        createSOShipGroup.setNumberOfPackages(400);
        //柜数：
        createSOShipGroup.setNumberOfContainers(10);
        //每柜件数：
        createSOShipGroup.setNumberOfPakagesPerContainer(40);
        //联系人 / 司机:
        createSOShipGroup.setContactPartyId("YangXx");//个人的 Id，如果没有，需要到 {baseUri}/People 中新建个人信息
        //联系人 / 司机电话：
        createSOShipGroup.setTelecomContactMechId("18000001111");//先直接用电话作为联系方式 Id
        //车牌号：
        createSOShipGroup.setVehiclePlateNumber("鲁B123765");
        //出库时间:
        createSOShipGroup.setEstimatedShipDate(new Timestamp(new Date().getTime()));
        //跟踪（物流）单号:	（选填）
        //createSOShipGroup.setTrackingNumber("XXXXXXXX");

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "OrderShipGroupService/CreateSOShipGroup");
        createSOShipGroup.setCommandId(UUID.randomUUID().toString());
        HttpClientUtil.post(token, url, createSOShipGroup);

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
