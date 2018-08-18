package org.dddml.wms.domain.service;

import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.specialization.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

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
        ProductState productState = getProductApplicationService().get(c.getProductId());
        if (productState == null) {
            throw new IllegalArgumentException(String.format("Product Id '%1$s' error.", c.getProductId()));
        }
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

}
