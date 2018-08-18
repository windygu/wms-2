package org.dddml.wms;

import org.dddml.wms.domain.party.AbstractPartyCommand;
import org.dddml.wms.domain.party.PartyApplicationService;
import org.dddml.wms.domain.party.PartyCommand;
import org.dddml.wms.domain.service.OrderShipGroupServiceCommands;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.domain.service.OrderShipGroupApplicationService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangjiefeng on 2018/8/18.
 */
public class OrderShipGroupTests {
    private OrderShipGroupApplicationService orderShipGroupApplicationService;

    private PartyApplicationService partyApplicationService;

    public final void setUp() {
        orderShipGroupApplicationService = (OrderShipGroupApplicationService) ApplicationContext.current.get("orderShipGroupApplicationService");
        partyApplicationService = (PartyApplicationService) ApplicationContext.current.get("partyApplicationService");
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

    public String createTestPersonParty() {
        PartyCommand.CreateParty createPerson = new AbstractPartyCommand.SimpleCreatePerson();
        String partyId = "" + new Date().getTime();
        createPerson.setPartyId(partyId);
        createPerson.setFirstName("Yang");
        createPerson.setLastName("JF");
        createPerson.setActive(true);
        partyApplicationService.when(createPerson);
        return partyId;
    }

}
