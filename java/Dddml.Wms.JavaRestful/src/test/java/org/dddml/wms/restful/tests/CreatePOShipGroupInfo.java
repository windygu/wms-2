package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.order.OrderCommands;
import org.dddml.wms.domain.party.CreateOrMergePatchPartyDto;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.security.JwtUser;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


/**
 * 创建入库通知单。
 * Created by yangjiefeng on 2018/8/25.
 */
public class CreatePOShipGroupInfo {

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

        OrderShipGroupServiceCommands.CreatePOShipGroup createPOShipGroup = new OrderShipGroupServiceCommands.CreatePOShipGroup();
        // 合同号:
        createPOShipGroup.setOrderId("XXXXXX-XX");
        // 通知单号:
        createPOShipGroup.setShipGroupSeqId("" + 2018082702L);
        //todo
        /*
        // ////////////// 产品 Id： /////////////////
        createPOShipGroup.setProductId("21001");
        //产品名称：	 GI SEMI-TREATED FLUFF
        //Grade：	8866
        //Quantity Uom: kg
        // //////////////////////////////////////////
        //数量（kg）:
        createPOShipGroup.setQuantity(BigDecimal.valueOf(500000));
        //件数:
        createPOShipGroup.setNumberOfPackages(400);
        //柜数：
        createPOShipGroup.setNumberOfContainers(10);
        //每柜件数：
        createPOShipGroup.setNumberOfPakagesPerContainer(40);
        */
        //联系人:
        createPOShipGroup.setContactPartyId("YangXx");//个人的 Id，如果没有，需要到 {baseUri}/People 中新建个人信息
        //入库时间:
        createPOShipGroup.setEstimatedDeliveryDate(new Timestamp(new Date().getTime()));
        //跟踪（物流）单号:	（选填）
        //createPOShipGroup.setTrackingNumber("XXXXXXXX");

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "OrderShipGroupService/CreatePOShipGroup");
        createPOShipGroup.setCommandId(UUID.randomUUID().toString());
        HttpClientUtil.post(token, url, createPOShipGroup);

        // ////////////// 测试： 创建另一个“通知单” ///////////////////////////////////////////////
        //createPOShipGroup.setCommandId(UUID.randomUUID().toString());
        //createPOShipGroup.setShipGroupSeqId(UUID.randomUUID().hashCode() + "");//随机产生通知单号
        //HttpClientUtil.post(token, url, createPOShipGroup);
        // //////////////////////////////////////////////////////////////////////////////////////////


        // /////////////// “批准”这个通知单 /////////////////////////
        String orderShipGroupUrl = HttpClientUtil.appendUrl(baseUrl,
                "Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}/_commands/OrderShipGroupAction");
        orderShipGroupUrl = orderShipGroupUrl.replace("{orderId}", createPOShipGroup.getOrderId())
                .replace("{shipGroupSeqId}", createPOShipGroup.getShipGroupSeqId().toString());
        OrderCommands.OrderShipGroupAction orderShipGroupAction = new OrderCommands.OrderShipGroupAction();
        orderShipGroupAction.setValue("Approve");
        orderShipGroupAction.setCommandId(UUID.randomUUID().toString());
        orderShipGroupAction.setVersion(0L);//当前订单的版本号
        HttpClientUtil.put(token, orderShipGroupUrl, orderShipGroupAction);

    }

    // //////////////////////////////////////////////////////////////

    /**
     * 在知道 Secret 的情况下，也可以自己创建一个 JWT Token。
     */
    private static String jwtSecret = "xxxxxx";

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
