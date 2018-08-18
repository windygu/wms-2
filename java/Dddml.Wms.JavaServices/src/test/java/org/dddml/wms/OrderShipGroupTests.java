package org.dddml.wms;

import org.dddml.wms.domain.party.AbstractPartyCommand;
import org.dddml.wms.domain.party.PartyApplicationService;
import org.dddml.wms.domain.party.PartyCommand;
import org.dddml.wms.domain.product.AbstractProductCommand;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductCommand;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.domain.service.OrderShipGroupApplicationService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/8/18.
 */
public class OrderShipGroupTests {
    private OrderShipGroupApplicationService orderShipGroupApplicationService;

    private PartyApplicationService partyApplicationService;

    private ProductApplicationService productApplicationService;

    public final void setUp() {
        orderShipGroupApplicationService = (OrderShipGroupApplicationService) ApplicationContext.current.get("orderShipGroupApplicationService");
        partyApplicationService = (PartyApplicationService) ApplicationContext.current.get("partyApplicationService");
        productApplicationService = (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }

    public void testCreatePOShipGroup1() {
        String partyId = createTestPersonParty();

        OrderShipGroupServiceCommands.CreatePOShipGroup createPOShipGroup = new OrderShipGroupServiceCommands.CreatePOShipGroup();
        //订单 Id（合同号）
        createPOShipGroup.setOrderId("" + new Date().getTime());
        //装运组序号（通知单号），长整数
        createPOShipGroup.setShipGroupSeqId(Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "01"));
        //（预计）入库时间
        createPOShipGroup.setEstimatedDeliveryDate(new Timestamp(new Date().getTime()));
        //件数
        createPOShipGroup.setNumberOfPackages(400);
        //柜数
        createPOShipGroup.setNumberOfContainers(10);
        //每柜件数
        createPOShipGroup.setNumberOfPakagesPerContainer(40);
        //产品 Id
        createPOShipGroup.setProductId("f1");
        //数量（以产品的主计量单位计算）
        createPOShipGroup.setQuantity(BigDecimal.valueOf(100000));
        //跟踪单号
        createPOShipGroup.setTrackingNumber("" + new Date().getTime());
        //
        createPOShipGroup.setCommandId(createPOShipGroup.getOrderId());

        //联系人 Id
        createPOShipGroup.setContactPartyId(partyId);

        orderShipGroupApplicationService.when(createPOShipGroup);
    }


    public void testCreatePOShipGroupAndShipment2() {
        String partyId = createTestPersonParty();

        OrderShipGroupServiceCommands.CreatePOShipGroup createPOShipGroup = new OrderShipGroupServiceCommands.CreatePOShipGroup();
        //订单 Id（合同号）
        createPOShipGroup.setOrderId("" + new Date().getTime());
        //装运组序号（通知单号），长整数
        createPOShipGroup.setShipGroupSeqId(Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "01"));
        //（预计）入库时间
        createPOShipGroup.setEstimatedDeliveryDate(new Timestamp(new Date().getTime()));
        //件数
        createPOShipGroup.setNumberOfPackages(400);
        //柜数
        createPOShipGroup.setNumberOfContainers(10);
        //每柜件数
        createPOShipGroup.setNumberOfPakagesPerContainer(40);
        //产品 Id
        ProductCommand.CreateProduct createProduct = createProduct_1();
        createPOShipGroup.setProductId(createProduct.getProductId());
        //数量（以产品的主计量单位计算）
        createPOShipGroup.setQuantity(BigDecimal.valueOf(100000));
        //跟踪单号
        createPOShipGroup.setTrackingNumber("" + new Date().getTime());
        //
        createPOShipGroup.setCommandId(createPOShipGroup.getOrderId());

        //联系人 Id
        createPOShipGroup.setContactPartyId(partyId);

        orderShipGroupApplicationService.when(createPOShipGroup);

        OrderShipGroupServiceCommands.CreatePOShipment createPOShipment = new OrderShipGroupServiceCommands.CreatePOShipment();
        createPOShipment.setOrderId(createPOShipGroup.getOrderId());
        createPOShipment.setShipGroupSeqId(createPOShipGroup.getShipGroupSeqId());
        createPOShipment.setCommandId(createPOShipGroup.getShipGroupSeqId() + "");
        orderShipGroupApplicationService.when(createPOShipment);
    }


    public void testCreateSOShipGroup1() {
        String partyId = createTestPersonParty();

        OrderShipGroupServiceCommands.CreateSOShipGroup createSOShipGroup = new OrderShipGroupServiceCommands.CreateSOShipGroup();
        //订单 Id（合同号）
        createSOShipGroup.setOrderId("" + new Date().getTime());
        //装运组序号（通知单号），长整数
        createSOShipGroup.setShipGroupSeqId(Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "01"));
        //（预计）入库时间
        createSOShipGroup.setEstimatedShipDate(new Timestamp(new Date().getTime()));
        //件数
        createSOShipGroup.setNumberOfPackages(400);
        //柜数
        createSOShipGroup.setNumberOfContainers(10);
        //每柜件数
        createSOShipGroup.setNumberOfPakagesPerContainer(40);
        //产品 Id
        createSOShipGroup.setProductId("f1");
        //数量（以产品的主计量单位计算）
        createSOShipGroup.setQuantity(BigDecimal.valueOf(100000));
        //跟踪单号
        createSOShipGroup.setTrackingNumber("" + new Date().getTime());
        //
        createSOShipGroup.setCommandId(createSOShipGroup.getOrderId());

        //联系人 Id
        createSOShipGroup.setContactPartyId(partyId);
        //车牌号
        createSOShipGroup.setVehiclePlateNumber("LU" + new Date().getTime());
        //发货指示 / 备注等
        createSOShipGroup.setShippingInstructions("Customer Name:" + UUID.randomUUID().toString());

        orderShipGroupApplicationService.when(createSOShipGroup);
    }

    private String createTestPersonParty() {
        PartyCommand.CreateParty createPerson = new AbstractPartyCommand.SimpleCreatePerson();
        String partyId = "" + new Date().getTime();
        createPerson.setPartyId(partyId);
        createPerson.setFirstName("Yang");
        createPerson.setLastName("JF");
        createPerson.setActive(true);
        partyApplicationService.when(createPerson);
        return partyId;
    }

    private ProductCommand.CreateProduct createProduct_1() {
        ProductCommand.CreateProduct prd_1 = new AbstractProductCommand.SimpleCreateProduct();
        prd_1.setProductId("MineralWater" + new java.util.Date().getTime() + ""); //Guid.NewGuid().ToString();
        prd_1.setProductName("Test_" + prd_1.getProductId());
        //prd_1.setAttributeSetId(attributeSetId);
        prd_1.setIsSerialNumbered(false);
        prd_1.setIsManagedByLot(true);
        //prd_1.QuantityUomId;
        prd_1.setCommandId(UUID.randomUUID().toString());
        productApplicationService.when(prd_1);
        return prd_1;
    }
}
