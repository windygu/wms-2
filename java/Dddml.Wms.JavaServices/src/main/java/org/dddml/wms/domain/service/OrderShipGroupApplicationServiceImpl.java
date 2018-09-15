package org.dddml.wms.domain.service;

import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.shipment.AbstractShipmentCommand;
import org.dddml.wms.domain.shipment.ShipmentApplicationService;
import org.dddml.wms.domain.shipment.ShipmentCommand;
import org.dddml.wms.domain.shipment.ShipmentItemCommand;
import org.dddml.wms.domain.shipmenttype.ShipmentTypeIds;
import org.dddml.wms.domain.statusitem.StatusItemIds;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by yangjiefeng on 2018/8/18.
 */
public class OrderShipGroupApplicationServiceImpl implements OrderShipGroupApplicationService {

    private OrderApplicationService getOrderApplicationService() {
            return (OrderApplicationService) ApplicationContext.current.get("orderApplicationService");
    }

    private ProductApplicationService getProductApplicationService() {
        return (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }

    private ShipmentApplicationService getShipmentApplicationService() {
        return (ShipmentApplicationService) ApplicationContext.current.get("shipmentApplicationService");
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    @Transactional
    @Override
    public void when(OrderShipGroupServiceCommands.CreatePOShipGroups c) {
        AbstractOrderCommand.AbstractCreateOrMergePatchOrder orderCommand = getCreateOrMergePatchPOCommand(c);

        //todo
        // /////////// 不只有一行 /////////////
        String orderItemSeqId = seqIdGenerator.getNextId().toString();

        OrderItemCommand.CreateOrderItem orderItem = orderCommand.newCreateOrderItem();
        orderItem.setOrderItemSeqId(orderItemSeqId);
        //todo
        String productId = null;//c.getProductId();
        ProductState productState = assertProductId(productId); // 确认 Product 存在
        orderItem.setProductId(productState.getProductId());
        //todo
        //orderItem.setQuantity(c.getQuantity());//数量
        orderItem.setActive(true);

        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            ((OrderCommand.CreateOrder)orderCommand).getOrderItems().add(orderItem);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            ((OrderCommand.MergePatchOrder)orderCommand).getOrderItemCommands().add(orderItem);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }

        OrderShipGroupCommand.CreateOrderShipGroup orderShipGroup = orderCommand.newCreateOrderShipGroup();
        //todo
        //orderShipGroup.setShipGroupSeqId(c.getShipGroupSeqId());
        orderShipGroup.setTelecomContactMechId(c.getTelecomContactMechId());//电话号码
        //orderShipGroup.setContactPartyId(c.getContactPartyId());
        orderShipGroup.setTrackingNumber(c.getTrackingNumber());
        //todo
        //        orderShipGroup.setNumberOfPackages(c.getNumberOfPackages());//件数
        //        orderShipGroup.setNumberOfContainers(c.getNumberOfContainers());//柜数
        //        orderShipGroup.setNumberOfPakagesPerContainer(c.getNumberOfPakagesPerContainer());//每柜件数
        orderShipGroup.setActive(true);
        //---------------------
        orderShipGroup.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());//预计收货日期
        orderShipGroup.setDestinationFacilityId(c.getDestinationFacilityId());//目标仓库 / 设施 Id
        //---------------------
        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            ((OrderCommand.CreateOrder)orderCommand).getOrderShipGroups().add(orderShipGroup);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            ((OrderCommand.MergePatchOrder)orderCommand).getOrderShipGroupCommands().add(orderShipGroup);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }

        OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation orderItemShipGroupAssociation
                = orderShipGroup.newCreateOrderItemShipGroupAssociation();
        orderItemShipGroupAssociation.setOrderItemSeqId(orderItem.getOrderItemSeqId());
        orderItemShipGroupAssociation.setQuantity(orderItem.getQuantity());
        orderItemShipGroupAssociation.setActive(true);
        orderShipGroup.getOrderItemShipGroupAssociations().add(orderItemShipGroupAssociation);

        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            getOrderApplicationService().when((AbstractOrderCommand.SimpleCreateOrder) orderCommand);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            getOrderApplicationService().when((AbstractOrderCommand.SimpleMergePatchOrder) orderCommand);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }
    }

    AbstractOrderCommand.AbstractCreateOrMergePatchOrder getCreateOrMergePatchPOCommand(OrderShipGroupServiceCommands.CreatePOShipGroups c) {
        AbstractOrderCommand.AbstractCreateOrMergePatchOrder orderCommand = null;
        //todo
        String orderId = null;
        OrderState orderState = null;//getOrderApplicationService().get(c.getOrderId());
        if (orderState == null) {
            orderCommand = new AbstractOrderCommand.SimpleCreateOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setOrderTypeId(OrderTypeIds.PURCHASE_ORDER);//入库，先写死订单类型
            orderCommand.setActive(true);
            orderCommand.setCommandId(c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
        } else {
            orderCommand = new AbstractOrderCommand.SimpleMergePatchOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setCommandId(c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
            orderCommand.setVersion(orderState.getVersion());
        }
        return orderCommand;
    }

    @Transactional
    @Override
    public void when(OrderShipGroupServiceCommands.CreateSOShipGroups c) {
        AbstractOrderCommand.AbstractCreateOrMergePatchOrder orderCommand = getCreateOrMergePatchSOCommand(c);

        //todo
        // /////////// 不只有一行 /////////////
        String orderItemSeqId = seqIdGenerator.getNextId().toString();

        OrderItemCommand.CreateOrderItem orderItem = orderCommand.newCreateOrderItem();
        orderItem.setOrderItemSeqId(orderItemSeqId);
        //todo
        String productId = null;//c.getProductId();// 确认 Product 存在
        ProductState productState = assertProductId(productId);
        orderItem.setProductId(productState.getProductId());
        //todo
        //orderItem.setQuantity(c.getQuantity());//数量
        orderItem.setActive(true);
        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            ((OrderCommand.CreateOrder)orderCommand).getOrderItems().add(orderItem);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            ((OrderCommand.MergePatchOrder)orderCommand).getOrderItemCommands().add(orderItem);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }

        OrderShipGroupCommand.CreateOrderShipGroup orderShipGroup = orderCommand.newCreateOrderShipGroup();
        //todo
        orderShipGroup.setShipGroupSeqId(null);//c.getShipGroupSeqId());
        orderShipGroup.setTelecomContactMechId(c.getTelecomContactMechId());//司机 / 联系人电话
        //orderShipGroup.setContactPartyId(c.getContactPartyId());//司机 / 联系人
        orderShipGroup.setTrackingNumber(c.getTrackingNumber());
        //todo
        //        orderShipGroup.setNumberOfPackages(c.getNumberOfPackages());//件数
        //        orderShipGroup.setNumberOfContainers(c.getNumberOfContainers());//柜数
        //        orderShipGroup.setNumberOfPakagesPerContainer(c.getNumberOfPakagesPerContainer());//每柜件数
        orderShipGroup.setActive(true);
        //---------------------
        orderShipGroup.setEstimatedShipDate(c.getEstimatedShipDate());//预计发货日期
        //        orderShipGroup.setVehiclePlateNumber(c.getVehiclePlateNumber());//车牌号
        //        orderShipGroup.setShippingInstructions(c.getShippingInstructions());//发货指示
        orderShipGroup.setFacilityId(c.getFacilityId());//源仓库 / 设施 Id
        //---------------------
        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            ((OrderCommand.CreateOrder)orderCommand).getOrderShipGroups().add(orderShipGroup);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            ((OrderCommand.MergePatchOrder)orderCommand).getOrderShipGroupCommands().add(orderShipGroup);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }

        OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation orderItemShipGroupAssociation
                = orderShipGroup.newCreateOrderItemShipGroupAssociation();
        orderItemShipGroupAssociation.setOrderItemSeqId(orderItem.getOrderItemSeqId());
        orderItemShipGroupAssociation.setQuantity(orderItem.getQuantity());
        orderItemShipGroupAssociation.setActive(true);
        orderShipGroup.getOrderItemShipGroupAssociations().add(orderItemShipGroupAssociation);

        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            getOrderApplicationService().when((AbstractOrderCommand.SimpleCreateOrder) orderCommand);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            getOrderApplicationService().when((AbstractOrderCommand.SimpleMergePatchOrder) orderCommand);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }
    }

    @Override
    public void when(OrderShipGroupServiceCommands.UpdateOrderItemShipGroupAssociation c) {
        //todo
    }


    AbstractOrderCommand.AbstractCreateOrMergePatchOrder getCreateOrMergePatchSOCommand(OrderShipGroupServiceCommands.CreateSOShipGroups c) {
        AbstractOrderCommand.AbstractCreateOrMergePatchOrder orderCommand = null;
        //todo
        String orderId = null;
        OrderState orderState = null;//getOrderApplicationService().get(c.getOrderId());
        if (orderState == null) {
            orderCommand = new AbstractOrderCommand.SimpleCreateOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setOrderTypeId(OrderTypeIds.SALES_ORDER);//出库，先写死订单类型
            orderCommand.setActive(true);
            orderCommand.setCommandId(c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
        } else {
            orderCommand = new AbstractOrderCommand.SimpleMergePatchOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setCommandId(c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
            orderCommand.setVersion(orderState.getVersion());
        }
        return orderCommand;
    }

    @Transactional
    @Override
    public String when(OrderShipGroupServiceCommands.CreatePOShipment c) {
        //todo
        String orderId = null;//c.getOrderId();
        String shipGroupSeqId = null;//c.getShipGroupSeqId();
        OrderState orderState = assertOrderId(orderId);
        if (!OrderTypeIds.PURCHASE_ORDER.equalsIgnoreCase(orderState.getOrderTypeId())) {
            throw new IllegalArgumentException("Order type error.");
        }
        OrderShipGroupState orderShipGroupState = assertShipGroupSeqId(orderState, shipGroupSeqId);
        String shipmentId = c.getShipmentId();
        if (shipmentId == null || shipmentId.trim().isEmpty()) {
            shipmentId = "S" + seqIdGenerator.getNextId();
        }
        String shipmentTypeId = ShipmentTypeIds.PURCHASE_SHIPMENT;
        //String shipmentStatusId = StatusItemIds.PURCH_SHIP_SHIPPED;
        // //////////////////////////////////////////////
        ShipmentCommand.CreateShipment createShipment =
                createShipment(orderId, shipGroupSeqId, shipmentId, shipmentTypeId, //shipmentStatusId,
                        orderShipGroupState.getFacilityId(), orderShipGroupState.getDestinationFacilityId());
        createShipment.setCommandId(c.getCommandId());
        // //////////////////////////////////////////////
        createShipmentItems(orderState, orderShipGroupState, createShipment);

        getShipmentApplicationService().when(createShipment);
        return shipmentId;
    }

    @Transactional
    @Override
    public String when(OrderShipGroupServiceCommands.CreateSOShipment c) {
        //todo
        String orderId = null;//c.getOrderId();
        String shipGroupSeqId = null;//c.getShipGroupSeqId();
        OrderState orderState = assertOrderId(orderId);
        if (!OrderTypeIds.SALES_ORDER.equalsIgnoreCase(orderState.getOrderTypeId())) {
            throw new IllegalArgumentException("Order type error.");
        }
        OrderShipGroupState orderShipGroupState = assertShipGroupSeqId(orderState, shipGroupSeqId);
        String shipmentId = c.getShipmentId();
        if (shipmentId == null || shipmentId.trim().isEmpty()) {
            shipmentId = "S" + seqIdGenerator.getNextId();
        }
        String shipmentTypeId = ShipmentTypeIds.SALES_SHIPMENT;
        //String shipmentStatusId = StatusItemIds.SHIPMENT_INPUT;
        // //////////////////////////////////////////////
        ShipmentCommand.CreateShipment createShipment =
                createShipment(orderId, shipGroupSeqId, shipmentId, shipmentTypeId, //shipmentStatusId,
                        orderShipGroupState.getFacilityId(), orderShipGroupState.getDestinationFacilityId());
        createShipment.setCommandId(c.getCommandId());
        // //////////////////////////////////////////////
        createShipmentItems(orderState, orderShipGroupState, createShipment);

        getShipmentApplicationService().when(createShipment);
        return shipmentId;
    }

    @Override
    public void when(OrderShipGroupServiceCommands.ShipPOShipment c) {

    }

    private void createShipmentItems(OrderState orderState, OrderShipGroupState orderShipGroupState, ShipmentCommand.CreateShipment createShipment) {
        for (OrderItemShipGroupAssociationState assc :  orderShipGroupState.getOrderItemShipGroupAssociations()) {
            String orderItemSeqId = assc.getOrderItemSeqId();
            OrderItemState orderItemState = orderState.getOrderItems().get(orderItemSeqId, false, true);
            if (orderItemState != null) {
                String productId = orderItemState.getProductId();
                ProductState productState = assertProductId(productId);
                if (productState.getIsSerialNumbered() == null || !productState.getIsSerialNumbered()) {
                    BigDecimal quantity = assc.getQuantity();
                    ShipmentItemCommand.CreateShipmentItem shipmentItem = createShipment.newCreateShipmentItem();
                    shipmentItem.setShipmentItemSeqId(assc.getOrderItemSeqId());//Is this OK?
                    shipmentItem.setProductId(productId);
                    shipmentItem.setQuantity(quantity);
                    shipmentItem.setActive(true);
                    createShipment.getShipmentItems().add(shipmentItem);
                }
            }
        }
    }

    private ShipmentCommand.CreateShipment createShipment(String orderId, String shipGroupSeqId, String shipmentId,
                                                          String shipmentTypeId, //String shipmentStatusId,
                                                          String originFacilityId, String destinationFacilityId) {
        ShipmentCommand.CreateShipment createShipment = new AbstractShipmentCommand.SimpleCreateShipment();
        createShipment.setShipmentId(shipmentId);
        createShipment.setShipmentTypeId(shipmentTypeId);
        //createShipment.setStatusId(shipmentStatusId);
        createShipment.setPrimaryOrderId(orderId);
        createShipment.setPrimaryShipGroupSeqId(shipGroupSeqId);
        createShipment.setActive(true);
        createShipment.setOriginFacilityId(originFacilityId);
        createShipment.setDestinationFacilityId(destinationFacilityId);
        return createShipment;
    }

    private OrderShipGroupState assertShipGroupSeqId(OrderState orderState, String shipGroupSeqId) {
        OrderShipGroupState orderShipGroupState = orderState.getOrderShipGroups().get(shipGroupSeqId, false, true);
        if (orderShipGroupState == null) {
            throw new IllegalArgumentException(String.format("ShipGroupSeqId Id '%1$s' error.", shipGroupSeqId));
        }
        return orderShipGroupState;
    }

    private OrderState assertOrderId(String orderId) {
        OrderState orderState = getOrderApplicationService().get(orderId);
        if (orderState == null) {
            throw new IllegalArgumentException(String.format("Order Id '%1$s' error.", orderId));
        }
        return orderState;
    }

    private ProductState assertProductId(String productId) {
        ProductState productState = getProductApplicationService().get(productId);
        if (productState == null) {
            throw new IllegalArgumentException(String.format("Product Id '%1$s' error.", productId));
        }
        return productState;
    }
}
