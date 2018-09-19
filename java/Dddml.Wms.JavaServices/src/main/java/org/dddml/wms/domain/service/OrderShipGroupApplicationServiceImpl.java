package org.dddml.wms.domain.service;

import org.dddml.wms.domain.Command;
import org.dddml.wms.domain.PurchaseShipmentAction;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.ordershipment.AbstractOrderShipmentCommand;
import org.dddml.wms.domain.ordershipment.OrderShipmentApplicationService;
import org.dddml.wms.domain.ordershipment.OrderShipmentCommand;
import org.dddml.wms.domain.ordershipment.OrderShipmentId;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.shipmenttype.ShipmentTypeIds;
import org.dddml.wms.domain.statusitem.StatusItemIds;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.DomainError;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.*;

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

    private OrderShipmentApplicationService getOrderShipmentApplicationService() {
        return (OrderShipmentApplicationService) ApplicationContext.current.get("orderShipmentApplicationService");
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    @Transactional
    @Override
    public void when(OrderShipGroupServiceCommands.CreatePOShipGroups c) {
        List<OrderItemShipGroupAssociationInfo> orderItemShipGroupAssociations = c.getOrderItemShipGroupAssociations();
        if (orderItemShipGroupAssociations == null) {
            return;
        }
        for (OrderItemShipGroupAssociationInfo line : orderItemShipGroupAssociations) {
            OrderState orderState = createOrMergePatchPOShipGroup(line.getOrderId(), line.getShipGroupSeqId(), c);
            if (line.getOrderItemSeqId() != null && !line.getOrderItemSeqId().trim().isEmpty()) {
                throw new IllegalArgumentException("OrderItemSeqId MUST be null.");
            }
            createOrMergePatchOrderItemAndShipGroupAssociation(orderState, line);
        }
    }

    @Transactional
    @Override
    public void when(OrderShipGroupServiceCommands.CreateSOShipGroups c) {
        List<OrderItemShipGroupAssociationInfo> orderItemShipGroupAssociations = c.getOrderItemShipGroupAssociations();
        if (orderItemShipGroupAssociations == null) {
            return;
        }
        for (OrderItemShipGroupAssociationInfo line : orderItemShipGroupAssociations) {
            OrderState orderState = createOrMergePatchSOShipGroup(line.getOrderId(), line.getShipGroupSeqId(), c);
            if (line.getOrderItemSeqId() != null && !line.getOrderItemSeqId().trim().isEmpty()) {
                throw new IllegalArgumentException("OrderItemSeqId MUST be null.");
            }
            createOrMergePatchOrderItemAndShipGroupAssociation(orderState, line);
        }
    }

    @Override
    public void when(OrderShipGroupServiceCommands.UpdateOrderItemShipGroupAssociation c) {
        String orderId = c.getOrderItemShipGroupAssociation().getOrderId();
        OrderState orderState = getOrderApplicationService().get(orderId);
        if (orderState == null) {
            throw new IllegalArgumentException(String.format("OrderId '%1$s' error.", orderId));
        }
        String orderItemSeqId = c.getOrderItemShipGroupAssociation().getOrderItemSeqId();
        if (orderItemSeqId == null || orderItemSeqId.trim().isEmpty()) {
            throw new IllegalArgumentException("OrderItemSeqId is null.");
        }
        createOrMergePatchOrderItemAndShipGroupAssociation(orderState, c.getOrderItemShipGroupAssociation());
    }

    @Transactional
    @Override
    public String when(OrderShipGroupServiceCommands.CreatePOShipment c) {
        if (c.getOrderIdShipGroupSeqIdPairs() == null || c.getOrderIdShipGroupSeqIdPairs().size() == 0) {
            throw new IllegalArgumentException("OrderIdShipGroupSeqIdPair is empty.");
        }
        //        if (!OrderTypeIds.PURCHASE_ORDER.equalsIgnoreCase(orderState.getOrderTypeId())) {
        //            throw new IllegalArgumentException("Order type error.");
        //        }
        //OrderShipGroupState orderShipGroupState = assertShipGroupSeqId(orderState, shipGroupSeqId);
        String shipmentId = c.getShipmentId();
        if (shipmentId == null || shipmentId.trim().isEmpty()) {
            shipmentId = "S" + seqIdGenerator.getNextId();
        }
        String shipmentTypeId = ShipmentTypeIds.PURCHASE_SHIPMENT;
        // //////////////////////////////////////////////
        ShipmentCommand.CreateShipment createShipment =
                createShipment(c.getOrderIdShipGroupSeqIdPairs().get(0).getOrderId(),
                        c.getOrderIdShipGroupSeqIdPairs().get(0).getShipGroupSeqId(),
                        shipmentId, shipmentTypeId);
        setShipmentProperties(createShipment, c.getOriginFacilityId(), c.getDestinationFacilityId(),
                c.getOriginContactMechId(), c.getDestinationContactMechId(),
                c.getHandlingInstructions(), c.getEstimatedShipDate());
        createShipment.setRequesterId(c.getRequesterId());
        createShipment.setCommandId(c.getCommandId());
        // //////////////////////////////////////////////
        Map<OrderShipmentId, BigDecimal> orderShipmentMap =
                createShipmentItems(c.getOrderIdShipGroupSeqIdPairs(), createShipment, false);

        getShipmentApplicationService().when(createShipment);

        createOrderShipmentMap(orderShipmentMap, c.getRequesterId());

        ShipmentState shipmentState = assertShipmentStatus(shipmentId, StatusItemIds.PURCH_SHIP_CREATED);
        if (c.getIsShipped() != null && c.getIsShipped()) {
            setPOShipmentShipped(shipmentId, shipmentState.getVersion(), c.getRequesterId());
        }
        return shipmentId;
    }

    private void setPOShipmentShipped(String shipmentId, Long version, String requesterId) {
        ShipmentCommands.PurchaseShipmentAction purchaseShipmentAction = new ShipmentCommands.PurchaseShipmentAction();
        purchaseShipmentAction.setShipmentId(shipmentId);
        purchaseShipmentAction.setVersion(version);
        purchaseShipmentAction.setValue(PurchaseShipmentAction.SHIP);
        purchaseShipmentAction.setCommandId(UUID.randomUUID().toString());
        purchaseShipmentAction.setRequesterId(requesterId);
        getShipmentApplicationService().when(purchaseShipmentAction);
    }


    @Transactional
    @Override
    public String when(OrderShipGroupServiceCommands.CreateSOShipment c) {
        if (c.getOrderIdShipGroupSeqIdPairs() == null || c.getOrderIdShipGroupSeqIdPairs().size() == 0) {
            throw new IllegalArgumentException("OrderIdShipGroupSeqIdPair is empty.");
        }
        //        OrderState orderState = assertOrderId(orderId);
        //        if (!OrderTypeIds.SALES_ORDER.equalsIgnoreCase(orderState.getOrderTypeId())) {
        //            throw new IllegalArgumentException("Order type error.");
        //        }
        //OrderShipGroupState orderShipGroupState = assertShipGroupSeqId(orderState, shipGroupSeqId);
        String shipmentId = c.getShipmentId();
        if (shipmentId == null || shipmentId.trim().isEmpty()) {
            shipmentId = "S" + seqIdGenerator.getNextId();
        }
        String shipmentTypeId = ShipmentTypeIds.SALES_SHIPMENT;
        // //////////////////////////////////////////////
        ShipmentCommand.CreateShipment createShipment =
                createShipment(c.getOrderIdShipGroupSeqIdPairs().get(0).getOrderId(),
                        c.getOrderIdShipGroupSeqIdPairs().get(0).getShipGroupSeqId(),
                        shipmentId, shipmentTypeId); //shipmentStatusId,
        setShipmentProperties(createShipment, c.getOriginFacilityId(), c.getDestinationFacilityId(),
                c.getOriginContactMechId(), c.getDestinationContactMechId(),
                c.getHandlingInstructions(), c.getEstimatedShipDate());
        createShipment.setRequesterId(c.getRequesterId());
        createShipment.setCommandId(c.getCommandId());
        // ///////////////////////////////////////////////
        createShipment.setIsScheduleNeeded(c.getIsScheduleNeeded());
        // //////////////////////////////////////////////
        Map<OrderShipmentId, BigDecimal> orderShipmentMap =
                createShipmentItems(c.getOrderIdShipGroupSeqIdPairs(), createShipment, false);

        getShipmentApplicationService().when(createShipment);
        createOrderShipmentMap(orderShipmentMap, c.getRequesterId());
        return shipmentId;
    }

    @Override
    @Transactional
    public void when(OrderShipGroupServiceCommands.ShipPOShipment c) {
        // ////////////////////////////////////////////////////
        // 增加一些用于“提示”的应收数量为 0 的备用行项
        if (!c.getHintShipmentItemsEnabled()) {
            throw new UnsupportedOperationException("HintShipmentItemsEnabled MUST be true.");
        }
        // ////////////////////////////////////////////////////

        if (c.getPrimaryOrderId() == null || c.getPrimaryOrderId().trim().isEmpty()) {
            throw new NullPointerException("primaryOrderId is null.");
        }
        if (c.getPrimaryShipGroupSeqId() == null || c.getPrimaryShipGroupSeqId().trim().isEmpty()) {
            throw new NullPointerException("primaryShipGroupSeqId is null.");
        }
        String shipmentId = c.getShipmentId();
        ShipmentState shipmentState = assertShipmentStatus(shipmentId, StatusItemIds.PURCH_SHIP_CREATED);
        if (shipmentState.getPrimaryOrderId() != null && !shipmentState.getPrimaryOrderId().equals(c.getPrimaryOrderId())) {
            throw new IllegalArgumentException("Shipment primaryOrderId CANNOT be modified.");
        }
        if (shipmentState.getPrimaryShipGroupSeqId() != null && !shipmentState.getPrimaryShipGroupSeqId().equals(c.getPrimaryShipGroupSeqId())) {
            throw new IllegalArgumentException("Shipment primaryShipGroupSeqId CANNOT be modified.");
        }
        // /////////////////////////////////////////////////////////
        // 添加之前已有装运单行项，与订单装运组之间的关联
        String orderId = c.getPrimaryOrderId();
        String shipGroupSeqId = c.getPrimaryShipGroupSeqId();
        Map<String, OrderItemId> productOrderItemMap = getProductOrderItemMap(orderId, shipGroupSeqId);
        createOrderShipmentMap(shipmentState, orderId, shipGroupSeqId, productOrderItemMap, c);
        // /////////////////////////////////////////////////////////

        List<OrderIdShipGroupSeqIdPair> orderIdShipGroupSeqIdPairs = new ArrayList<>();
        orderIdShipGroupSeqIdPairs.add(new OrderIdShipGroupSeqIdPair(c.getPrimaryOrderId(), c.getPrimaryShipGroupSeqId()));
        if (c.getOtherOrderIdShipGroupSeqIdPairs() != null) {
            orderIdShipGroupSeqIdPairs.addAll(c.getOtherOrderIdShipGroupSeqIdPairs());
        }
        // /////////////////////////////////////////////
        //if (c.getHintShipmentItemsEnabled()) {
        ShipmentCommand.MergePatchShipment mergePatchShipment = new AbstractShipmentCommand.SimpleMergePatchShipment();
        mergePatchShipment.setShipmentId(shipmentId);
        mergePatchShipment.setPrimaryOrderId(c.getPrimaryOrderId());
        mergePatchShipment.setPrimaryShipGroupSeqId(c.getPrimaryShipGroupSeqId());
        // ///////////////
        setShipmentProperties(mergePatchShipment, c.getOriginFacilityId(), c.getDestinationFacilityId(),
                c.getOriginContactMechId(), c.getDestinationContactMechId(),
                c.getHandlingInstructions(), null);
        // ///////////////
        mergePatchShipment.setVersion(shipmentState.getVersion());
        mergePatchShipment.setCommandId(c.getCommandId());
        mergePatchShipment.setRequesterId(c.getRequesterId());
        // 增加一些数量为 0 的装运行项目（“提示”）
        Map<OrderShipmentId, BigDecimal> orderShipmentMap =
                createShipmentItems(orderIdShipGroupSeqIdPairs, mergePatchShipment, true);
        getShipmentApplicationService().when(mergePatchShipment);
        createOrderShipmentMap(orderShipmentMap, c.getRequesterId());
        //}
        // ///////////////// 更新状态到“已发运” ///////////////////////////
        setPOShipmentShipped(shipmentId,shipmentState.getVersion(), c.getRequesterId());
    }

    private ShipmentState assertShipmentStatus(String shipmentId, String status) {
        ShipmentState shipmentState = assertShipmentId(shipmentId);
        if (!shipmentState.getStatusId().equals(status)) {
            throw new IllegalArgumentException("Shipment status MUST be PURCH_SHIP_CREATED.");
        }
        return shipmentState;
    }

    private void createOrderShipmentMap(ShipmentState shipmentState,
                                        String orderId, String shipGroupSeqId,
                                        Map<String, OrderItemId> productOrderItemMap,
                                        OrderShipGroupServiceCommands.ShipPOShipment c) {
        for (ShipmentItemState shipmentItemState : shipmentState.getShipmentItems()) {
            String shipmentItemSeqId = shipmentItemState.getShipmentItemSeqId();
            String productId = shipmentItemState.getProductId();
            if (!productOrderItemMap.containsKey(productId)) {
                throw DomainError.named("wrongProductId",
                        "Shipment productId '%1$s' not in orderShipGroup.", productId);
            }
            String orderItemSeqId = productOrderItemMap.get(productId).getOrderItemSeqId();
            // ///////////////////////////////////////////////
            OrderShipmentId orderShipmentId = new OrderShipmentId();
            orderShipmentId.setOrderId(orderId);
            orderShipmentId.setOrderItemSeqId(orderItemSeqId);
            orderShipmentId.setShipGroupSeqId(shipGroupSeqId);
            orderShipmentId.setShipmentId(shipmentState.getShipmentId());
            orderShipmentId.setShipmentItemSeqId(shipmentItemSeqId);
            // ////////////////////////////////////////////////
            BigDecimal qty = shipmentItemState.getQuantity();
            createOrderShipmentMapping(orderShipmentId, qty, c.getRequesterId());
        }
    }

    private ShipmentState assertShipmentId(String shipmentId) {
        ShipmentState shipmentState = getShipmentApplicationService().get(shipmentId);
        if (shipmentState == null) {
            throw new IllegalArgumentException(String.format("ShipmentId '%1$s' error.", shipmentId));
        }
        return shipmentState;
    }

    private Map<String, OrderItemId> getProductOrderItemMap(String orderId, String shipGroupSeqId) {
        //产品与订单项目的映射关系（只保留一个订单项）
        Map<String, OrderItemId> productOrderItemMap = new HashMap<>();
        OrderState orderState = assertOrderId(orderId);
        OrderShipGroupState orderShipGroupState = assertShipGroupSeqId(orderState, shipGroupSeqId);
        for (OrderItemShipGroupAssociationState orderItemShipGroupAssoc : orderShipGroupState.getOrderItemShipGroupAssociations()) {
            String orderItemSeqId = orderItemShipGroupAssoc.getOrderItemSeqId();
            OrderItemState orderItemState = assertOrderItemSeqSeqId(orderState, orderItemSeqId);
            if (!productOrderItemMap.containsKey(orderItemState.getProductId())) {
                productOrderItemMap.put(orderItemState.getProductId(), new OrderItemId(orderId, orderItemSeqId));
            }
        }
        return productOrderItemMap;
    }

    private void createOrMergePatchOrderItemAndShipGroupAssociation(OrderState orderState, OrderItemShipGroupAssociationInfo line) {
        OrderCommand.MergePatchOrder orderCommand = new AbstractOrderCommand.SimpleMergePatchOrder();
        orderCommand.setOrderId(line.getOrderId());
        orderCommand.setVersion(orderState.getVersion());
        boolean needOrderItemCreation = (line.getOrderItemSeqId() == null || line.getOrderItemSeqId().trim().isEmpty());
        String orderItemSeqId = null;
        if (needOrderItemCreation) {
            orderItemSeqId = seqIdGenerator.getNextId().toString();
        } else {
            orderItemSeqId = line.getOrderItemSeqId();
        }
        OrderItemCommand.CreateOrMergePatchOrderItem orderItemCommand = null;
        if (needOrderItemCreation) {
            orderItemCommand = orderCommand.newCreateOrderItem();
            orderItemCommand.setOrderItemSeqId(orderItemSeqId);
            String productId = line.getProductId();
            ProductState productState = assertProductId(productId); // 确认 Product 存在
            orderItemCommand.setProductId(productState.getProductId());
            orderItemCommand.setQuantity(line.getQuantity());//数量
            orderItemCommand.setActive(true);
            orderCommand.getOrderItemCommands().add(orderItemCommand);
        } else {
            orderItemCommand = orderCommand.newMergePatchOrderItem();
            OrderItemState orderItemState = orderState.getOrderItems().get(orderItemSeqId, false, true);
            if (orderItemState == null) {
                throw new IllegalArgumentException(String.format("OrderItemSeqId '%1$s' error.", orderItemSeqId));
            }
            orderItemCommand.setOrderItemSeqId(orderItemSeqId);
            String productId = line.getProductId();
            if (productId != null) {
                if (!orderItemState.getProductId().equals(productId)) {
                    throw new IllegalArgumentException(String.format("ProductId '%1$s' CANNOT be modified.", productId));
                }
            }
            orderItemCommand.setQuantity(line.getQuantity());//数量
            orderCommand.getOrderItemCommands().add(orderItemCommand);
        }

        OrderShipGroupCommand.MergePatchOrderShipGroup mergePatchOrderShipGroup = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
        mergePatchOrderShipGroup.setShipGroupSeqId(line.getShipGroupSeqId());
        orderCommand.getOrderShipGroupCommands().add(mergePatchOrderShipGroup);

        OrderItemShipGroupAssociationCommand.CreateOrMergePatchOrderItemShipGroupAssociation orderItemShipGroupAssocCommand = null;
        if (needOrderItemCreation) {
            orderItemShipGroupAssocCommand = mergePatchOrderShipGroup.newCreateOrderItemShipGroupAssociation();
            orderItemShipGroupAssocCommand.setOrderItemSeqId(orderItemCommand.getOrderItemSeqId());
            orderItemShipGroupAssocCommand.setQuantity(orderItemCommand.getQuantity());
            orderItemShipGroupAssocCommand.setActive(true);
            orderItemShipGroupAssocCommand.setNumberOfPackages(line.getNumberOfPackages());//件数
            orderItemShipGroupAssocCommand.setNumberOfContainers(line.getNumberOfContainers());//柜数
            orderItemShipGroupAssocCommand.setNumberOfPakagesPerContainer(line.getNumberOfPakagesPerContainer());//每柜件数
            String orderItemShipGroupAssociationKey = getOrderItemShipGroupAssociationKey(line);
            orderItemShipGroupAssocCommand.setOrderItemShipGroupAssociationKey(orderItemShipGroupAssociationKey);
        } else {
            orderItemShipGroupAssocCommand = mergePatchOrderShipGroup.newMergePatchOrderItemShipGroupAssociation();
            orderItemShipGroupAssocCommand.setOrderItemSeqId(orderItemCommand.getOrderItemSeqId());
            orderItemShipGroupAssocCommand.setQuantity(orderItemCommand.getQuantity());
            orderItemShipGroupAssocCommand.setActive(true);
            if (line.getNumberOfPackages() != null) {
                orderItemShipGroupAssocCommand.setNumberOfPackages(line.getNumberOfPackages());//件数
            }
            if (line.getNumberOfContainers() != null) {
                orderItemShipGroupAssocCommand.setNumberOfContainers(line.getNumberOfContainers());//柜数
            }
            if (line.getNumberOfPakagesPerContainer() != null) {
                orderItemShipGroupAssocCommand.setNumberOfPakagesPerContainer(line.getNumberOfPakagesPerContainer());//每柜件数
            }
            //String orderItemShipGroupAssociationKey = getOrderItemShipGroupAssociationKey(line);
            //orderItemShipGroupAssocCommand.setOrderItemShipGroupAssociationKey(orderItemShipGroupAssociationKey);
        }
        mergePatchOrderShipGroup.getOrderItemShipGroupAssociationCommands().add(orderItemShipGroupAssocCommand);
        getOrderApplicationService().when(orderCommand);
    }

    private String getOrderItemShipGroupAssociationKey(OrderItemShipGroupAssociationInfo line) {
        return line.getShipGroupSeqId() + "|" + line.getOrderId() + "|" + line.getProductId();
    }

    private OrderState createOrMergePatchPOShipGroup(String orderId, String shipGroupSeqId, OrderShipGroupServiceCommands.CreatePOShipGroups c) {
        OrderState orderState = getOrderApplicationService().get(orderId);
        AbstractOrderCommand.AbstractCreateOrMergePatchOrder orderCommand = null;
        OrderShipGroupCommand.CreateOrMergePatchOrderShipGroup orderShipGroupCommand = null;
        if (orderState == null) {
            orderCommand = new AbstractOrderCommand.SimpleCreateOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setOrderTypeId(OrderTypeIds.PURCHASE_ORDER);//入库，先写死订单类型
            orderCommand.setActive(true);
            orderCommand.setCommandId(UUID.randomUUID().toString());//(c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
            orderShipGroupCommand = orderCommand.newCreateOrderShipGroup();
        } else {
            orderCommand = new AbstractOrderCommand.SimpleMergePatchOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setCommandId(UUID.randomUUID().toString());//c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
            orderCommand.setVersion(orderState.getVersion());
            OrderShipGroupState orderShipGroupState = orderState.getOrderShipGroups().get(shipGroupSeqId, false, true);
            if (orderShipGroupState == null) {
                orderShipGroupCommand = orderCommand.newCreateOrderShipGroup();
            } else {
                orderShipGroupCommand = orderCommand.newMergePatchOrderShipGroup();
            }
        }

        orderShipGroupCommand.setShipGroupSeqId(shipGroupSeqId);
        if (c.getTelecomContactMechId()!=null && !c.getTelecomContactMechId().isEmpty()) {
            orderShipGroupCommand.setTelecomContactMechId(c.getTelecomContactMechId());//电话号码
        }
        //orderShipGroup.setContactPartyId(c.getContactPartyId());
        //        if (c.getTrackingNumber()!=null && !c.getTrackingNumber().isEmpty()) {
        //            orderShipGroupCommand.setTrackingNumber(c.getTrackingNumber());
        //        }
        orderShipGroupCommand.setActive(true);
        //---------------------
        //        if (c.getEstimatedDeliveryDate()!=null) {
        //            orderShipGroupCommand.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());//预计收货日期
        //        }
        //        if (c.getDestinationFacilityId()!=null && !c.getDestinationFacilityId().isEmpty()) {
        //            orderShipGroupCommand.setDestinationFacilityId(c.getDestinationFacilityId());//目标仓库 / 设施 Id
        //        }

        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            ((OrderCommand.CreateOrder)orderCommand).getOrderShipGroups().add((OrderShipGroupCommand.CreateOrderShipGroup)orderShipGroupCommand);
            getOrderApplicationService().when((AbstractOrderCommand.SimpleCreateOrder) orderCommand);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            ((OrderCommand.MergePatchOrder)orderCommand).getOrderShipGroupCommands().add(orderShipGroupCommand);
            getOrderApplicationService().when((AbstractOrderCommand.SimpleMergePatchOrder) orderCommand);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }

        orderState = getOrderApplicationService().get(orderId);
        return orderState;
    }

    private OrderState createOrMergePatchSOShipGroup(String orderId, String shipGroupSeqId, OrderShipGroupServiceCommands.CreateSOShipGroups c) {
        OrderState orderState = getOrderApplicationService().get(orderId);
        AbstractOrderCommand.AbstractCreateOrMergePatchOrder orderCommand = null;
        OrderShipGroupCommand.CreateOrMergePatchOrderShipGroup orderShipGroupCommand = null;
        if (orderState == null) {
            orderCommand = new AbstractOrderCommand.SimpleCreateOrder();
            orderShipGroupCommand = orderCommand.newCreateOrderShipGroup();
            orderCommand = new AbstractOrderCommand.SimpleCreateOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setOrderTypeId(OrderTypeIds.SALES_ORDER);//出库，先写死订单类型
            orderCommand.setActive(true);
            orderCommand.setCommandId(UUID.randomUUID().toString());//c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
        } else {
            orderCommand = new AbstractOrderCommand.SimpleMergePatchOrder();
            orderCommand.setOrderId(orderId);
            orderCommand.setCommandId(UUID.randomUUID().toString());//c.getCommandId());
            orderCommand.setRequesterId(c.getRequesterId());
            orderCommand.setVersion(orderState.getVersion());
            OrderShipGroupState orderShipGroupState = orderState.getOrderShipGroups().get(shipGroupSeqId, false, true);
            if (orderShipGroupState == null) {
                orderShipGroupCommand = orderCommand.newCreateOrderShipGroup();
            } else {
                orderShipGroupCommand = orderCommand.newMergePatchOrderShipGroup();
            }
        }

        orderShipGroupCommand.setShipGroupSeqId(shipGroupSeqId);
        if (c.getTelecomContactMechId()!=null && !c.getTelecomContactMechId().isEmpty()) {
            orderShipGroupCommand.setTelecomContactMechId(c.getTelecomContactMechId());//电话号码
        }
        //orderShipGroup.setContactPartyId(c.getContactPartyId());
        //        if (c.getTrackingNumber()!=null && !c.getTrackingNumber().isEmpty()) {
        //            orderShipGroupCommand.setTrackingNumber(c.getTrackingNumber());
        //        }
        orderShipGroupCommand.setActive(true);
        //---------------------
        //        if (c.getEstimatedShipDate()!=null) {
        //            orderShipGroupCommand.setEstimatedShipDate(c.getEstimatedShipDate());//预计发货日期
        //        }
        //        orderShipGroupCommand.setVehiclePlateNumber(c.getVehiclePlateNumber());//车牌号
        //        orderShipGroupCommand.setShippingInstructions(c.getShippingInstructions());//发货指示
        if (c.getFacilityId()!=null && !c.getFacilityId().isEmpty()) {
            orderShipGroupCommand.setFacilityId(c.getFacilityId());//源仓库 / 设施 Id
        }

        if(orderCommand instanceof AbstractOrderCommand.SimpleCreateOrder) {
            ((OrderCommand.CreateOrder)orderCommand).getOrderShipGroups().add((OrderShipGroupCommand.CreateOrderShipGroup)orderShipGroupCommand);
            getOrderApplicationService().when((AbstractOrderCommand.SimpleCreateOrder) orderCommand);
        } else if(orderCommand instanceof AbstractOrderCommand.SimpleMergePatchOrder) {
            ((OrderCommand.MergePatchOrder)orderCommand).getOrderShipGroupCommands().add(orderShipGroupCommand);
            getOrderApplicationService().when((AbstractOrderCommand.SimpleMergePatchOrder) orderCommand);
        } else {
            throw new RuntimeException("Unknown order command type.");
        }

        orderState = getOrderApplicationService().get(orderId);
        return orderState;
    }


    private void createOrderShipmentMap(Map<OrderShipmentId, BigDecimal> orderShipmentMap, String requesterId) {
        for (Map.Entry<OrderShipmentId, BigDecimal> entry : orderShipmentMap.entrySet()) {
            OrderShipmentId orderShipmentId = entry.getKey();
            BigDecimal qty = entry.getValue();
            createOrderShipmentMapping(orderShipmentId, qty, requesterId);
        }
    }

    private void createOrderShipmentMapping(OrderShipmentId orderShipmentId, BigDecimal qty, String requesterId) {
        OrderShipmentCommand.CreateOrderShipment createOrderShipment = new AbstractOrderShipmentCommand.SimpleCreateOrderShipment();
        createOrderShipment.setOrderShipmentId(orderShipmentId);
        createOrderShipment.setQuantity(qty);
        createOrderShipment.setCommandId(UUID.randomUUID().toString());
        createOrderShipment.setRequesterId(requesterId);
        getOrderShipmentApplicationService().when(createOrderShipment);
    }

    private Map<OrderShipmentId, BigDecimal> createShipmentItems(List<OrderIdShipGroupSeqIdPair> orderIdShipGroupSeqIdPairs,
                                                                 ShipmentCommand.CreateOrMergePatchShipment shipmentCommand,
                                                                 boolean forceZeroQuantity) {
        Map<OrderShipmentId, BigDecimal> orderShipmentMap = new HashMap<>();

        //注意，这里统计每个产品需要发运多少数量
        Map<OrderShipmentId, BigDecimal> orderShipmentQtyPrdMap = new HashMap<>();
        for (OrderIdShipGroupSeqIdPair pair : orderIdShipGroupSeqIdPairs) {
            String orderId = pair.getOrderId();
            String orderShipGroupSeqId = pair.getShipGroupSeqId();
            OrderState orderState = getOrderApplicationService().get(orderId);
            if (orderState == null) {
                throw new IllegalArgumentException(String.format("OrderId '%1$s' error.", orderId));
            }
            OrderShipGroupState orderShipGroupState = orderState.getOrderShipGroups().get(orderShipGroupSeqId, false, true);
            if (orderShipGroupState == null) {
                throw new IllegalArgumentException(String.format("OrderShipGroupSeqId '%1$s' error.", orderShipGroupSeqId));
            }
            for (OrderItemShipGroupAssociationState assoc : orderShipGroupState.getOrderItemShipGroupAssociations()) {
                String orderItemSeqId = assoc.getOrderItemSeqId();
                OrderItemState orderItemState = orderState.getOrderItems().get(orderItemSeqId, false, true);
                if (orderItemState == null) {
                    throw new IllegalArgumentException(String.format("OrderItemSeqId '%1$s' error.", orderItemSeqId));
                }
                String productId = orderItemState.getProductId();
                //ProductState productState = assertProductId(productId);
                //if (productState.getIsSerialNumbered() == null || !productState.getIsSerialNumbered()) {
                OrderShipmentId orderShipmentId = new OrderShipmentId();
                orderShipmentId.setOrderId(orderId);
                orderShipmentId.setShipGroupSeqId(orderShipGroupSeqId);
                orderShipmentId.setOrderItemSeqId(orderItemSeqId);
                orderShipmentId.setShipmentId(shipmentCommand.getShipmentId());
                orderShipmentId.setShipmentItemSeqId(productId);//这里使用产品 Id
                if (!orderShipmentQtyPrdMap.containsKey(orderShipmentId)) {
                    orderShipmentQtyPrdMap.put(orderShipmentId, BigDecimal.ZERO);
                }
                BigDecimal qty = forceZeroQuantity ? BigDecimal.ZERO
                        : orderShipmentQtyPrdMap.get(orderShipmentId).add(assoc.getQuantity());
                orderShipmentQtyPrdMap.put(orderShipmentId, qty);
                //} //end if
            }
        }
        for (Map.Entry<OrderShipmentId, BigDecimal> entry : orderShipmentQtyPrdMap.entrySet()) {
            String productId = entry.getKey().getShipmentItemSeqId();//在上面把产品 Id 保存到了这里
            String shipmentItemSeqId = seqIdGenerator.getNextId().toString();//Is this OK?
            BigDecimal quantity = entry.getValue();
            ShipmentItemCommand.CreateShipmentItem shipmentItem = null;
            if (shipmentCommand instanceof ShipmentCommand.CreateShipment) {
                shipmentItem = ((ShipmentCommand.CreateShipment) shipmentCommand).newCreateShipmentItem();
            } else if (shipmentCommand instanceof ShipmentCommand.MergePatchShipment) {
                shipmentItem = ((ShipmentCommand.MergePatchShipment) shipmentCommand).newCreateShipmentItem();
            } else {
                throw new RuntimeException("Unknown command type.");
            }
            shipmentItem.setShipmentItemSeqId(shipmentItemSeqId);
            shipmentItem.setProductId(productId);
            shipmentItem.setQuantity(quantity);
            shipmentItem.setActive(true);
            if (shipmentCommand instanceof ShipmentCommand.CreateShipment) {
                ((ShipmentCommand.CreateShipment) shipmentCommand).getShipmentItems().add(shipmentItem);
            } else if (shipmentCommand instanceof ShipmentCommand.MergePatchShipment) {
                ((ShipmentCommand.MergePatchShipment) shipmentCommand).getShipmentItemCommands().add(shipmentItem);
            } else {
                throw new RuntimeException("Unknown command type.");
            }

            // ///////////////////////////////////////////////
            OrderShipmentId orderShipmentId = new OrderShipmentId();
            orderShipmentId.setOrderId(entry.getKey().getOrderId());
            orderShipmentId.setOrderItemSeqId(entry.getKey().getOrderItemSeqId());
            orderShipmentId.setShipGroupSeqId(entry.getKey().getShipGroupSeqId());
            orderShipmentId.setShipmentId(entry.getKey().getShipmentId());
            orderShipmentId.setShipmentItemSeqId(shipmentItemSeqId);
            orderShipmentMap.put(orderShipmentId, quantity);
        }
        return orderShipmentMap;
    }

    private ShipmentCommand.CreateShipment createShipment(String primaryOrderId, String primaryShipGroupSeqId, String shipmentId,
                                                          String shipmentTypeId) {
        ShipmentCommand.CreateShipment createShipment = new AbstractShipmentCommand.SimpleCreateShipment();
        createShipment.setShipmentId(shipmentId);
        createShipment.setShipmentTypeId(shipmentTypeId);
        //createShipment.setStatusId(shipmentStatusId);
        createShipment.setPrimaryOrderId(primaryOrderId);
        createShipment.setPrimaryShipGroupSeqId(primaryShipGroupSeqId);
        createShipment.setActive(true);
        //createShipment.setOriginFacilityId(originFacilityId);
        //createShipment.setDestinationFacilityId(destinationFacilityId);
        return createShipment;
    }

    private void setShipmentProperties(ShipmentCommand.CreateOrMergePatchShipment shipmentCommand,
                                       String originFacilityId, String destinationFacilityId,
                                       String originContactMechId, String destinationContactMechId,
                                       String handlingInstructions, java.sql.Timestamp estimatedShipDate) {
        if (originFacilityId != null) {
            shipmentCommand.setOriginFacilityId(originFacilityId);
        }
        if (destinationFacilityId != null) {
            shipmentCommand.setDestinationFacilityId(destinationFacilityId);
        }
        if (originContactMechId != null) {
            shipmentCommand.setOriginContactMechId(originContactMechId);
        }
        if (destinationContactMechId != null) {
            shipmentCommand.setDestinationContactMechId(destinationContactMechId);
        }
        //shipmentCommand.setTrackingNumber();
        // 联系人 / 司机 Id
        //shipmentCommand.setContactPartyId();
        // 车牌号
        //shipmentCommand.setVehiclePlateNumber();
        // 预计交付（入库）日期
        //shipmentCommand.setEstimatedDeliveryDate();
        // 发货指示 / 客户名称 / 备注等
        if (handlingInstructions != null) {
            shipmentCommand.setHandlingInstructions(handlingInstructions);
        }
        // 预计（发货）日期
        if (estimatedShipDate != null) {
            shipmentCommand.setEstimatedShipDate(estimatedShipDate);
        }
    }

    private OrderShipGroupState assertShipGroupSeqId(OrderState orderState, String shipGroupSeqId) {
        OrderShipGroupState orderShipGroupState = orderState.getOrderShipGroups().get(shipGroupSeqId, false, true);
        if (orderShipGroupState == null) {
            throw new IllegalArgumentException(String.format("ShipGroupSeqId Id '%1$s' error.", shipGroupSeqId));
        }
        return orderShipGroupState;
    }

    private OrderItemState assertOrderItemSeqSeqId(OrderState orderState, String orderItemSeqId) {
        OrderItemState orderItemState = orderState.getOrderItems().get(orderItemSeqId, false, true);
        if (orderItemState == null) {
            throw new IllegalArgumentException(String.format("OrderItemSeqId Id '%1$s' error.", orderItemSeqId));
        }
        return orderItemState;
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
