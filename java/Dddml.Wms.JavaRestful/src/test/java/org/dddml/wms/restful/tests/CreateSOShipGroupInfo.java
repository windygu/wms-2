package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.service.OrderItemShipGroupAssociationInfo;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.security.JwtUser;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;


/**
 * 创建出库通知单。
 * Created by yangjiefeng on 2018/8/25.
 */
public class CreateSOShipGroupInfo {

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

        OrderShipGroupServiceCommands.CreateSOShipGroups createSOShipGroups = new OrderShipGroupServiceCommands.CreateSOShipGroups();
        // 发货指示：（发货指示 / 客户信息 / 备注等）
        createSOShipGroups.setShippingInstructions("Xxxxx, yyyy, zzzzz");
        //联系人 / 司机:
        createSOShipGroups.setContactPartyId("YangXx");//个人的 Id，如果没有，需要到 {baseUri}/People 中新建个人信息
        //联系人 / 司机电话：
        createSOShipGroups.setTelecomContactMechId("18000001111");//先直接用电话作为联系方式 Id
        //车牌号：
        createSOShipGroups.setVehiclePlateNumber("鲁B123765");
        //出库时间:
        createSOShipGroups.setEstimatedShipDate(new Timestamp(new Date().getTime()));
        //跟踪（物流）单号:	（选填）
        //createSOShipGroup.setTrackingNumber("XXXXXXXX");

        String shipGroupSeqId = "" + 2018081801L;

        // //////////////// 通知单（装运组）的“行”信息 //////////////////////
        OrderItemShipGroupAssociationInfo line1 = new OrderItemShipGroupAssociationInfo();
        // 合同号:
        line1.setOrderId("CCCCCC-XX");
        // 通知单号:
        line1.setShipGroupSeqId(shipGroupSeqId);
        // ////////////// 产品 Id： /////////////////
        line1.setProductId("21001");
        //产品名称：	 GI SEMI-TREATED FLUFF
        //Grade：	8866
        //Quantity Uom: kg
        // //////////////////////////////////////////
        //数量（kg）:
        line1.setQuantity(BigDecimal.valueOf(500000));
        //件数:
        line1.setNumberOfPackages(400);
        //柜数：
        line1.setNumberOfContainers(10);
        //每柜件数：
        line1.setNumberOfPakagesPerContainer(40);

        // ///////////////////////// 第二行 ////////////////////////////
        OrderItemShipGroupAssociationInfo line2 = new OrderItemShipGroupAssociationInfo();
        // 合同号:
        line2.setOrderId("CCCCCC-YY");
        // 通知单号:
        line2.setShipGroupSeqId(shipGroupSeqId);
        // ////////////// 产品 Id： /////////////////
        line2.setProductId("21001");
        //产品名称：	 GI SEMI-TREATED FLUFF
        //Grade：	8866
        //Quantity Uom: kg
        // //////////////////////////////////////////
        //数量（kg）:
        line2.setQuantity(BigDecimal.valueOf(500000));
        //件数:
        line2.setNumberOfPackages(400);
        //柜数：
        line2.setNumberOfContainers(10);
        //每柜件数：
        line2.setNumberOfPakagesPerContainer(40);

        // //////////////////////////////////////////////////////////
        createSOShipGroups.setOrderItemShipGroupAssociations(Arrays.asList(line1, line2));

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "OrderShipGroupService/CreateSOShipGroups");
        createSOShipGroups.setCommandId(UUID.randomUUID().toString());
        HttpClientUtil.post(token, url, createSOShipGroups);

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
