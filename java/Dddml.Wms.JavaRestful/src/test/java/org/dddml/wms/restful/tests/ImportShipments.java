package org.dddml.wms.restful.tests;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dddml.wms.domain.service.OrderIdShipGroupSeqIdPair;
import org.dddml.wms.domain.service.OrderItemShipGroupAssociationInfo;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.restful.resource.ImportServiceResource;
import org.dddml.wms.security.JwtUser;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;


/**
 * 导入装运单（码单）信息。
 * Created by yangjiefeng on 2018/8/25.
 */
public class ImportShipments {

    // /////////////////////// 命令（写） API 服务地址 /////////////////////////
    //private static String baseUrl = "http://47.104.74.139:8080/api/";
    private static String baseUrl = "http://localhost:8080/api/";

    // //////////////  IAM（认证）服务获取 JWT Token 接口地址 ///////////////////
    //private static String authTokenUrl = "http://47.104.74.139:8080/api/iam/oauth2/token";
    private static String authTokenUrl = "http://localhost:8080/api/iam/oauth2/token";
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

        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "ImportService/ImportShipments");
        ImportServiceResource.ImportingShipmentHeader importSettings = getImportingShipmentHeader();
        HttpClientUtil.post(token, url, importSettings);

        if (true) return;

        // ///////////////////////////////////////////////////////////////////////////////
        // 创建一个测试“通知单”（有多行——即多个订单/装运组的行项） ///////////////////
        // ///////////////////////////////////////////////////////////////////////////////
        String orderId = "test-po-no.";
        String shipGroupSeqId = "" + UUID.randomUUID().hashCode();//测试装运组序号（通知单号）

        // ////////////////// “通知单”的第一行 /////////////////////////
        OrderItemShipGroupAssociationInfo orderItemShipGroupAssoc1 = new OrderItemShipGroupAssociationInfo();
        orderItemShipGroupAssoc1.setOrderId(orderId);
        orderItemShipGroupAssoc1.setShipGroupSeqId(shipGroupSeqId);
        orderItemShipGroupAssoc1.setProductId("21101");
        orderItemShipGroupAssoc1.setQuantity(BigDecimal.valueOf(100000));
        // ////////////////// “通知单”的第二行 /////////////////////////
        OrderItemShipGroupAssociationInfo orderItemShipGroupAssoc2 = new OrderItemShipGroupAssociationInfo();
        orderItemShipGroupAssoc2.setOrderId(orderId);
        orderItemShipGroupAssoc2.setShipGroupSeqId(shipGroupSeqId);
        orderItemShipGroupAssoc2.setProductId("21001");
        orderItemShipGroupAssoc2.setQuantity(BigDecimal.valueOf(100000));

        // ///////////////////
        OrderIdShipGroupSeqIdPair orderIdShipGroupSeqIdPair = new OrderIdShipGroupSeqIdPair();
        orderIdShipGroupSeqIdPair.setOrderId(orderId);
        orderIdShipGroupSeqIdPair.setShipGroupSeqId(shipGroupSeqId);
        OrderShipGroupServiceCommands.CreatePOShipGroups createPOShipGroups = new OrderShipGroupServiceCommands.CreatePOShipGroups();
        createPOShipGroups.setEstimatedDeliveryDate(new Timestamp(new Date().getTime()));
        createPOShipGroups.setContactPartyId("XXX-XXX");
        createPOShipGroups.setTelecomContactMechId("18000000000");
        createPOShipGroups.setDestinationFacilityId("W1");
        createPOShipGroups.setOrderItemShipGroupAssociations(Arrays.asList(orderItemShipGroupAssoc1));
        createPOShipGroups.setCommandId(UUID.randomUUID().toString());
        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "OrderShipGroupService/CreatePOShipGroups");
        HttpClientUtil.post(token, url, createPOShipGroups);

        if (true) return;

        // ////////////更新通知单的行项（其实是更新“订单/装运组”的相关行项） //////////////
        OrderShipGroupServiceCommands.UpdateOrderItemShipGroupAssociation updateOrderItemShipGroupAssociation = new OrderShipGroupServiceCommands.UpdateOrderItemShipGroupAssociation();
        OrderItemShipGroupAssociationInfo orderItemShipGroupAssoc = new OrderItemShipGroupAssociationInfo();
        orderItemShipGroupAssoc.setOrderId(orderId);//合同号
        orderItemShipGroupAssoc.setShipGroupSeqId("-602270240");//通知单号（装运组序号）
        orderItemShipGroupAssoc.setOrderItemSeqId(10161 + "");//生成的订单项目序号
        orderItemShipGroupAssoc.setProductId("21101");//不支持修改产品 Id，应该设置为与创建时一致的 Id
        orderItemShipGroupAssoc.setQuantity(BigDecimal.ZERO);
        updateOrderItemShipGroupAssociation.setOrderItemShipGroupAssociation(orderItemShipGroupAssoc);
        updateOrderItemShipGroupAssociation.setCommandId(UUID.randomUUID().toString());
        url = HttpClientUtil.appendUrl(baseUrl, "OrderShipGroupService/UpdateOrderItemShipGroupAssociation");
        HttpClientUtil.post(token, url, updateOrderItemShipGroupAssociation);

        if (true) return;

        // ///////////////////////////// /////////////////////////////
        // 将“通知单”与已经存在（导入）的码单（装运单）关联起来
        // ///////////////////////////////////////////////////////////
        OrderShipGroupServiceCommands.ShipPOShipment shipPOShipment = new OrderShipGroupServiceCommands.ShipPOShipment();
        shipPOShipment.setShipmentId("TCNU4367495");// 已导入装运单（码单）号
        shipPOShipment.setPrimaryOrderId(orderId);//合同号（必须与导入时相同）
        shipPOShipment.setPrimaryShipGroupSeqId(shipGroupSeqId);//通知单号（装运组序号）
        shipPOShipment.setDestinationFacilityId("W1");//目标仓库
        shipPOShipment.setHintShipmentItemsEnabled(true);//目前必须为 true
        shipPOShipment.setCommandId(UUID.randomUUID().toString());
        // ////////////////////////////////////////
        url = HttpClientUtil.appendUrl(baseUrl, "OrderShipGroupService/ShipPOShipment");
        HttpClientUtil.post(token, url, shipPOShipment);

    }

    private static ImportServiceResource.ImportingShipmentHeader getImportingShipmentHeader() {
        ImportServiceResource.ImportingShipmentHeader shipmentHeader = new ImportServiceResource.ImportingShipmentHeader();

        // ////////////////  导入库存文件的 URL ////////////////////////
        // 需要先将导入文件“上传”到本服务能访问到的 URL 地址
        //String fileUrl = "https://takumi.oss-cn-qingdao.aliyuncs.com/NO_EXIST_FILE.xls";
        String fileUrl = "file:///C:\\Users\\yangjiefeng\\Documents\\青岛\\ShipmentImportTest (2).xls";
        shipmentHeader.setFileUrl(fileUrl);

        //运单“头”信息
        // ///////////////// Ship To ///////////////////////////
        shipmentHeader.setShipToPartyId("XXX-XXX");//发送给谁（业务实体/单位/个人）
        // //////////////////  PO# ///////////////////////////
        shipmentHeader.setPurchaseOrderId("test-po-no.");//PO#
        // ////////////////// Order# ///////////////////////
        shipmentHeader.setExternalOrderNumber("test-order-no.");//Order#
        // ////////////////// Carrier ///////////////////////
        shipmentHeader.setCarrier("test_carrier_1");
        //  /////////////////  发运日期 /////////////////////
        shipmentHeader.setDateShipped(new Timestamp(new Date().getTime()));
        // /////////////////// 预计到达日期 ///////////////////
        shipmentHeader.setEstimatedArrivalDate(new Timestamp(new Date().getTime()));

        // ////////////////  产品名称到 产品 Id 的映射关系 //////////////////
        // 一般来说，Excel 中有多少种“没有使用产品 Id”作为 Product 列的值的产品，
        // 就需要添加多少个“品名映射”
        // shipmentHeader.setProductMap(new ImportServiceResource.ProductMapping[]{getProductMapping1(), getProductMapping2()});
        // 如果没有（Excel 中使用了 ProductId），那么就使用一个空数组
        shipmentHeader.setProductMap(new ImportServiceResource.ProductMapping[]{ getProductMapping2() });

        return shipmentHeader;
    }

    private static ImportServiceResource.ProductMapping getProductMapping1() {
        //ImportServiceResource.ProductMapping prdMapping1 = new ImportServiceResource.ProductMapping();
        //prdMapping1.setProductName("GOLDEN ISLES CO FLUFF PULP");//在 Excel 中出现的产品名称
        //prdMapping1.setProductId("21001");//在系统中的产品 Id（Product Id）
        //return prdMapping1;
        return null;
    }

    private static ImportServiceResource.ProductMapping getProductMapping2() {
        ImportServiceResource.ProductMapping productMapping = new ImportServiceResource.ProductMapping();
        productMapping.setProductName("GI SEMI-TREATED FLUFF");//在 Excel 中出现的产品名称
        productMapping.setProductId("21101");//在系统中的产品 Id（Product Id）
        return productMapping;
    }

    private static ImportServiceResource.ProductMapping getProductMapping3() {
        //ImportServiceResource.ProductMapping prdMapping1 = new ImportServiceResource.ProductMapping();
        //prdMapping1.setProductName("XXXX FLUFF PULP");//在 Excel 中出现的产品名称
        //prdMapping1.setProductId("2XXXX");//在系统中的产品 Id（Product Id）
        //return prdMapping1;
        return null;
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
