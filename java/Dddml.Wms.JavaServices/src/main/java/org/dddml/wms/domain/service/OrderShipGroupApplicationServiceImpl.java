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
    public void when(OrderShipGroupServiceCommands.CreatePOShipGroup c) {
        OrderCommand.CreateOrder createOrder = new AbstractOrderCommand.SimpleCreateOrder();

        createOrder.setOrderId(c.getOrderId());
        createOrder.setOrderTypeId(OrderTypeIds.PURCHASE_ORDER);//入库，先写死订单类型
        createOrder.setActive(true);
        createOrder.setCommandId(c.getCommandId());
        createOrder.setRequesterId(c.getRequesterId());

        String orderItemSeqId = "1";//只有一行
        OrderItemCommand.CreateOrderItem orderItem = createOrder.newCreateOrderItem();
        orderItem.setOrderItemSeqId(orderItemSeqId);
        // 确认 Product 存在
        String productId = c.getProductId();
        ProductState productState = assertProductId(productId);
        orderItem.setProductId(productState.getProductId());
        orderItem.setQuantity(c.getQuantity());//数量
        orderItem.setActive(true);
        createOrder.getOrderItems().add(orderItem);

        OrderShipGroupCommand.CreateOrderShipGroup orderShipGroup = createOrder.newCreateOrderShipGroup();
        orderShipGroup.setShipGroupSeqId(c.getShipGroupSeqId());
        orderShipGroup.setContactPartyId(c.getContactPartyId());
        orderShipGroup.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
        orderShipGroup.setTrackingNumber(c.getTrackingNumber());
        orderShipGroup.setNumberOfPackages(c.getNumberOfPackages());//件数
        orderShipGroup.setNumberOfContainers(c.getNumberOfContainers());//柜数
        orderShipGroup.setNumberOfPakagesPerContainer(c.getNumberOfPakagesPerContainer());//每柜件数
        orderShipGroup.setActive(true);
        createOrder.getOrderShipGroups().add(orderShipGroup);

        OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation orderItemShipGroupAssociation
                = orderShipGroup.newCreateOrderItemShipGroupAssociation();
        orderItemShipGroupAssociation.setOrderItemSeqId(orderItem.getOrderItemSeqId());
        orderItemShipGroupAssociation.setQuantity(orderItem.getQuantity());
        orderItemShipGroupAssociation.setActive(true);
        orderShipGroup.getOrderItemShipGroupAssociations().add(orderItemShipGroupAssociation);

        getOrderApplicationService().when(createOrder);
    }

    private ProductState assertProductId(String productId) {
        ProductState productState = getProductApplicationService().get(productId);
        if (productState == null) {
            throw new IllegalArgumentException(String.format("Product Id '%1$s' error.", productId));
        }
        return productState;
    }

    @Transactional
    @Override
    public String when(OrderShipGroupServiceCommands.CreatePOShipment c) {
        String orderId = c.getOrderId();
        Long shipGroupSeqId = c.getShipGroupSeqId();
        OrderState orderState = getOrderApplicationService().get(orderId);
        if (orderState == null) {
            throw new IllegalArgumentException(String.format("Order Id '%1$s' error.", orderId));
        }
        OrderShipGroupState orderShipGroupState = orderState.getOrderShipGroups().get(shipGroupSeqId, false, true);
        if (orderShipGroupState == null) {
            throw new IllegalArgumentException(String.format("ShipGroupSeqId Id '%1$s' error.", shipGroupSeqId));
        }
        String shipmentId = c.getShipmentId();
        if (shipmentId == null || shipmentId.trim().isEmpty()) {
            shipmentId = "S" + seqIdGenerator.getNextId();
        }
        ShipmentCommand.CreateShipment createShipment = new AbstractShipmentCommand.SimpleCreateShipment();
        createShipment.setShipmentId(shipmentId);
        createShipment.setShipmentTypeId(ShipmentTypeIds.PURCHASE_SHIPMENT);
        createShipment.setStatusId(StatusItemIds.PURCH_SHIP_SHIPPED);
        createShipment.setPrimaryOrderId(orderId);
        createShipment.setPrimaryShipGroupSeqId(shipGroupSeqId);
        createShipment.setActive(true);
        createShipment.setCommandId(c.getCommandId());

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

        getShipmentApplicationService().when(createShipment);
        return shipmentId;
    }

}
