package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderCommand extends AbstractCommand implements OrderCommand
{
    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchOrder extends AbstractOrderCommand implements CreateOrMergePatchOrder
    {
        private String orderTypeId;

        public String getOrderTypeId()
        {
            return this.orderTypeId;
        }

        public void setOrderTypeId(String orderTypeId)
        {
            this.orderTypeId = orderTypeId;
        }

        private String orderName;

        public String getOrderName()
        {
            return this.orderName;
        }

        public void setOrderName(String orderName)
        {
            this.orderName = orderName;
        }

        private String externalId;

        public String getExternalId()
        {
            return this.externalId;
        }

        public void setExternalId(String externalId)
        {
            this.externalId = externalId;
        }

        private String salesChannelEnumId;

        public String getSalesChannelEnumId()
        {
            return this.salesChannelEnumId;
        }

        public void setSalesChannelEnumId(String salesChannelEnumId)
        {
            this.salesChannelEnumId = salesChannelEnumId;
        }

        private java.sql.Timestamp orderDate;

        public java.sql.Timestamp getOrderDate()
        {
            return this.orderDate;
        }

        public void setOrderDate(java.sql.Timestamp orderDate)
        {
            this.orderDate = orderDate;
        }

        private String priority;

        public String getPriority()
        {
            return this.priority;
        }

        public void setPriority(String priority)
        {
            this.priority = priority;
        }

        private java.sql.Timestamp entryDate;

        public java.sql.Timestamp getEntryDate()
        {
            return this.entryDate;
        }

        public void setEntryDate(java.sql.Timestamp entryDate)
        {
            this.entryDate = entryDate;
        }

        private java.sql.Timestamp pickSheetPrintedDate;

        public java.sql.Timestamp getPickSheetPrintedDate()
        {
            return this.pickSheetPrintedDate;
        }

        public void setPickSheetPrintedDate(java.sql.Timestamp pickSheetPrintedDate)
        {
            this.pickSheetPrintedDate = pickSheetPrintedDate;
        }

        private String statusId;

        public String getStatusId()
        {
            return this.statusId;
        }

        public void setStatusId(String statusId)
        {
            this.statusId = statusId;
        }

        private String currencyUom;

        public String getCurrencyUom()
        {
            return this.currencyUom;
        }

        public void setCurrencyUom(String currencyUom)
        {
            this.currencyUom = currencyUom;
        }

        private String syncStatusId;

        public String getSyncStatusId()
        {
            return this.syncStatusId;
        }

        public void setSyncStatusId(String syncStatusId)
        {
            this.syncStatusId = syncStatusId;
        }

        private String billingAccountId;

        public String getBillingAccountId()
        {
            return this.billingAccountId;
        }

        public void setBillingAccountId(String billingAccountId)
        {
            this.billingAccountId = billingAccountId;
        }

        private String originFacilityId;

        public String getOriginFacilityId()
        {
            return this.originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId)
        {
            this.originFacilityId = originFacilityId;
        }

        private String webSiteId;

        public String getWebSiteId()
        {
            return this.webSiteId;
        }

        public void setWebSiteId(String webSiteId)
        {
            this.webSiteId = webSiteId;
        }

        private String productStoreId;

        public String getProductStoreId()
        {
            return this.productStoreId;
        }

        public void setProductStoreId(String productStoreId)
        {
            this.productStoreId = productStoreId;
        }

        private String terminalId;

        public String getTerminalId()
        {
            return this.terminalId;
        }

        public void setTerminalId(String terminalId)
        {
            this.terminalId = terminalId;
        }

        private String transactionId;

        public String getTransactionId()
        {
            return this.transactionId;
        }

        public void setTransactionId(String transactionId)
        {
            this.transactionId = transactionId;
        }

        private String autoOrderShoppingListId;

        public String getAutoOrderShoppingListId()
        {
            return this.autoOrderShoppingListId;
        }

        public void setAutoOrderShoppingListId(String autoOrderShoppingListId)
        {
            this.autoOrderShoppingListId = autoOrderShoppingListId;
        }

        private String needsInventoryIssuance;

        public String getNeedsInventoryIssuance()
        {
            return this.needsInventoryIssuance;
        }

        public void setNeedsInventoryIssuance(String needsInventoryIssuance)
        {
            this.needsInventoryIssuance = needsInventoryIssuance;
        }

        private String isRushOrder;

        public String getIsRushOrder()
        {
            return this.isRushOrder;
        }

        public void setIsRushOrder(String isRushOrder)
        {
            this.isRushOrder = isRushOrder;
        }

        private String internalCode;

        public String getInternalCode()
        {
            return this.internalCode;
        }

        public void setInternalCode(String internalCode)
        {
            this.internalCode = internalCode;
        }

        private java.math.BigDecimal remainingSubTotal;

        public java.math.BigDecimal getRemainingSubTotal()
        {
            return this.remainingSubTotal;
        }

        public void setRemainingSubTotal(java.math.BigDecimal remainingSubTotal)
        {
            this.remainingSubTotal = remainingSubTotal;
        }

        private java.math.BigDecimal grandTotal;

        public java.math.BigDecimal getGrandTotal()
        {
            return this.grandTotal;
        }

        public void setGrandTotal(java.math.BigDecimal grandTotal)
        {
            this.grandTotal = grandTotal;
        }

        private String invoicePerShipment;

        public String getInvoicePerShipment()
        {
            return this.invoicePerShipment;
        }

        public void setInvoicePerShipment(String invoicePerShipment)
        {
            this.invoicePerShipment = invoicePerShipment;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        public OrderRoleCommand.CreateOrderRole newCreateOrderRole()
        {
            AbstractOrderRoleCommand.SimpleCreateOrderRole c = new AbstractOrderRoleCommand.SimpleCreateOrderRole();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderRoleCommand.MergePatchOrderRole newMergePatchOrderRole()
        {
            AbstractOrderRoleCommand.SimpleMergePatchOrderRole c = new AbstractOrderRoleCommand.SimpleMergePatchOrderRole();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderRoleCommand.RemoveOrderRole newRemoveOrderRole()
        {
            AbstractOrderRoleCommand.SimpleRemoveOrderRole c = new AbstractOrderRoleCommand.SimpleRemoveOrderRole();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderItemCommand.CreateOrderItem newCreateOrderItem()
        {
            AbstractOrderItemCommand.SimpleCreateOrderItem c = new AbstractOrderItemCommand.SimpleCreateOrderItem();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderItemCommand.MergePatchOrderItem newMergePatchOrderItem()
        {
            AbstractOrderItemCommand.SimpleMergePatchOrderItem c = new AbstractOrderItemCommand.SimpleMergePatchOrderItem();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderItemCommand.RemoveOrderItem newRemoveOrderItem()
        {
            AbstractOrderItemCommand.SimpleRemoveOrderItem c = new AbstractOrderItemCommand.SimpleRemoveOrderItem();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderShipGroupCommand.CreateOrderShipGroup newCreateOrderShipGroup()
        {
            AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup c = new AbstractOrderShipGroupCommand.SimpleCreateOrderShipGroup();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderShipGroupCommand.MergePatchOrderShipGroup newMergePatchOrderShipGroup()
        {
            AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup c = new AbstractOrderShipGroupCommand.SimpleMergePatchOrderShipGroup();
            c.setOrderId(this.getOrderId());

            return c;
        }

        public OrderShipGroupCommand.RemoveOrderShipGroup newRemoveOrderShipGroup()
        {
            AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup c = new AbstractOrderShipGroupCommand.SimpleRemoveOrderShipGroup();
            c.setOrderId(this.getOrderId());

            return c;
        }

    }

    public static abstract class AbstractCreateOrder extends AbstractCreateOrMergePatchOrder implements CreateOrder
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateOrderRoleCommands orderRoles = new SimpleCreateOrderRoleCommands();

        public CreateOrderRoleCommands getOrderRoles()
        {
            return this.orderRoles;
        }

        private CreateOrderItemCommands orderItems = new SimpleCreateOrderItemCommands();

        public CreateOrderItemCommands getOrderItems()
        {
            return this.orderItems;
        }

        private CreateOrderShipGroupCommands orderShipGroups = new SimpleCreateOrderShipGroupCommands();

        public CreateOrderShipGroupCommands getOrderShipGroups()
        {
            return this.orderShipGroups;
        }

    }

    public static abstract class AbstractMergePatchOrder extends AbstractCreateOrMergePatchOrder implements MergePatchOrder
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyOrderTypeIdRemoved;

        public Boolean getIsPropertyOrderTypeIdRemoved()
        {
            return this.isPropertyOrderTypeIdRemoved;
        }

        public void setIsPropertyOrderTypeIdRemoved(Boolean removed)
        {
            this.isPropertyOrderTypeIdRemoved = removed;
        }

        private Boolean isPropertyOrderNameRemoved;

        public Boolean getIsPropertyOrderNameRemoved()
        {
            return this.isPropertyOrderNameRemoved;
        }

        public void setIsPropertyOrderNameRemoved(Boolean removed)
        {
            this.isPropertyOrderNameRemoved = removed;
        }

        private Boolean isPropertyExternalIdRemoved;

        public Boolean getIsPropertyExternalIdRemoved()
        {
            return this.isPropertyExternalIdRemoved;
        }

        public void setIsPropertyExternalIdRemoved(Boolean removed)
        {
            this.isPropertyExternalIdRemoved = removed;
        }

        private Boolean isPropertySalesChannelEnumIdRemoved;

        public Boolean getIsPropertySalesChannelEnumIdRemoved()
        {
            return this.isPropertySalesChannelEnumIdRemoved;
        }

        public void setIsPropertySalesChannelEnumIdRemoved(Boolean removed)
        {
            this.isPropertySalesChannelEnumIdRemoved = removed;
        }

        private Boolean isPropertyOrderDateRemoved;

        public Boolean getIsPropertyOrderDateRemoved()
        {
            return this.isPropertyOrderDateRemoved;
        }

        public void setIsPropertyOrderDateRemoved(Boolean removed)
        {
            this.isPropertyOrderDateRemoved = removed;
        }

        private Boolean isPropertyPriorityRemoved;

        public Boolean getIsPropertyPriorityRemoved()
        {
            return this.isPropertyPriorityRemoved;
        }

        public void setIsPropertyPriorityRemoved(Boolean removed)
        {
            this.isPropertyPriorityRemoved = removed;
        }

        private Boolean isPropertyEntryDateRemoved;

        public Boolean getIsPropertyEntryDateRemoved()
        {
            return this.isPropertyEntryDateRemoved;
        }

        public void setIsPropertyEntryDateRemoved(Boolean removed)
        {
            this.isPropertyEntryDateRemoved = removed;
        }

        private Boolean isPropertyPickSheetPrintedDateRemoved;

        public Boolean getIsPropertyPickSheetPrintedDateRemoved()
        {
            return this.isPropertyPickSheetPrintedDateRemoved;
        }

        public void setIsPropertyPickSheetPrintedDateRemoved(Boolean removed)
        {
            this.isPropertyPickSheetPrintedDateRemoved = removed;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved()
        {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed)
        {
            this.isPropertyStatusIdRemoved = removed;
        }

        private Boolean isPropertyCurrencyUomRemoved;

        public Boolean getIsPropertyCurrencyUomRemoved()
        {
            return this.isPropertyCurrencyUomRemoved;
        }

        public void setIsPropertyCurrencyUomRemoved(Boolean removed)
        {
            this.isPropertyCurrencyUomRemoved = removed;
        }

        private Boolean isPropertySyncStatusIdRemoved;

        public Boolean getIsPropertySyncStatusIdRemoved()
        {
            return this.isPropertySyncStatusIdRemoved;
        }

        public void setIsPropertySyncStatusIdRemoved(Boolean removed)
        {
            this.isPropertySyncStatusIdRemoved = removed;
        }

        private Boolean isPropertyBillingAccountIdRemoved;

        public Boolean getIsPropertyBillingAccountIdRemoved()
        {
            return this.isPropertyBillingAccountIdRemoved;
        }

        public void setIsPropertyBillingAccountIdRemoved(Boolean removed)
        {
            this.isPropertyBillingAccountIdRemoved = removed;
        }

        private Boolean isPropertyOriginFacilityIdRemoved;

        public Boolean getIsPropertyOriginFacilityIdRemoved()
        {
            return this.isPropertyOriginFacilityIdRemoved;
        }

        public void setIsPropertyOriginFacilityIdRemoved(Boolean removed)
        {
            this.isPropertyOriginFacilityIdRemoved = removed;
        }

        private Boolean isPropertyWebSiteIdRemoved;

        public Boolean getIsPropertyWebSiteIdRemoved()
        {
            return this.isPropertyWebSiteIdRemoved;
        }

        public void setIsPropertyWebSiteIdRemoved(Boolean removed)
        {
            this.isPropertyWebSiteIdRemoved = removed;
        }

        private Boolean isPropertyProductStoreIdRemoved;

        public Boolean getIsPropertyProductStoreIdRemoved()
        {
            return this.isPropertyProductStoreIdRemoved;
        }

        public void setIsPropertyProductStoreIdRemoved(Boolean removed)
        {
            this.isPropertyProductStoreIdRemoved = removed;
        }

        private Boolean isPropertyTerminalIdRemoved;

        public Boolean getIsPropertyTerminalIdRemoved()
        {
            return this.isPropertyTerminalIdRemoved;
        }

        public void setIsPropertyTerminalIdRemoved(Boolean removed)
        {
            this.isPropertyTerminalIdRemoved = removed;
        }

        private Boolean isPropertyTransactionIdRemoved;

        public Boolean getIsPropertyTransactionIdRemoved()
        {
            return this.isPropertyTransactionIdRemoved;
        }

        public void setIsPropertyTransactionIdRemoved(Boolean removed)
        {
            this.isPropertyTransactionIdRemoved = removed;
        }

        private Boolean isPropertyAutoOrderShoppingListIdRemoved;

        public Boolean getIsPropertyAutoOrderShoppingListIdRemoved()
        {
            return this.isPropertyAutoOrderShoppingListIdRemoved;
        }

        public void setIsPropertyAutoOrderShoppingListIdRemoved(Boolean removed)
        {
            this.isPropertyAutoOrderShoppingListIdRemoved = removed;
        }

        private Boolean isPropertyNeedsInventoryIssuanceRemoved;

        public Boolean getIsPropertyNeedsInventoryIssuanceRemoved()
        {
            return this.isPropertyNeedsInventoryIssuanceRemoved;
        }

        public void setIsPropertyNeedsInventoryIssuanceRemoved(Boolean removed)
        {
            this.isPropertyNeedsInventoryIssuanceRemoved = removed;
        }

        private Boolean isPropertyIsRushOrderRemoved;

        public Boolean getIsPropertyIsRushOrderRemoved()
        {
            return this.isPropertyIsRushOrderRemoved;
        }

        public void setIsPropertyIsRushOrderRemoved(Boolean removed)
        {
            this.isPropertyIsRushOrderRemoved = removed;
        }

        private Boolean isPropertyInternalCodeRemoved;

        public Boolean getIsPropertyInternalCodeRemoved()
        {
            return this.isPropertyInternalCodeRemoved;
        }

        public void setIsPropertyInternalCodeRemoved(Boolean removed)
        {
            this.isPropertyInternalCodeRemoved = removed;
        }

        private Boolean isPropertyRemainingSubTotalRemoved;

        public Boolean getIsPropertyRemainingSubTotalRemoved()
        {
            return this.isPropertyRemainingSubTotalRemoved;
        }

        public void setIsPropertyRemainingSubTotalRemoved(Boolean removed)
        {
            this.isPropertyRemainingSubTotalRemoved = removed;
        }

        private Boolean isPropertyGrandTotalRemoved;

        public Boolean getIsPropertyGrandTotalRemoved()
        {
            return this.isPropertyGrandTotalRemoved;
        }

        public void setIsPropertyGrandTotalRemoved(Boolean removed)
        {
            this.isPropertyGrandTotalRemoved = removed;
        }

        private Boolean isPropertyInvoicePerShipmentRemoved;

        public Boolean getIsPropertyInvoicePerShipmentRemoved()
        {
            return this.isPropertyInvoicePerShipmentRemoved;
        }

        public void setIsPropertyInvoicePerShipmentRemoved(Boolean removed)
        {
            this.isPropertyInvoicePerShipmentRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private OrderRoleCommands orderRoleCommands = new SimpleOrderRoleCommands();

        public OrderRoleCommands getOrderRoleCommands()
        {
            return this.orderRoleCommands;
        }

        private OrderItemCommands orderItemCommands = new SimpleOrderItemCommands();

        public OrderItemCommands getOrderItemCommands()
        {
            return this.orderItemCommands;
        }

        private OrderShipGroupCommands orderShipGroupCommands = new SimpleOrderShipGroupCommands();

        public OrderShipGroupCommands getOrderShipGroupCommands()
        {
            return this.orderShipGroupCommands;
        }

    }

    public static class SimpleCreateOrder extends AbstractCreateOrder
    {
    }

    
    public static class SimpleMergePatchOrder extends AbstractMergePatchOrder
    {
    }

    
	public static class SimpleDeleteOrder extends AbstractOrderCommand implements DeleteOrder
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateOrderRoleCommands implements CreateOrderRoleCommands
    {
        private List<OrderRoleCommand.CreateOrderRole> innerCommands = new ArrayList<OrderRoleCommand.CreateOrderRole>();

        public void add(OrderRoleCommand.CreateOrderRole c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderRoleCommand.CreateOrderRole c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderRoleCommand.CreateOrderRole> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleOrderRoleCommands implements OrderRoleCommands
    {
        private List<OrderRoleCommand> innerCommands = new ArrayList<OrderRoleCommand>();

        public void add(OrderRoleCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderRoleCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderRoleCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateOrderItemCommands implements CreateOrderItemCommands
    {
        private List<OrderItemCommand.CreateOrderItem> innerCommands = new ArrayList<OrderItemCommand.CreateOrderItem>();

        public void add(OrderItemCommand.CreateOrderItem c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderItemCommand.CreateOrderItem c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderItemCommand.CreateOrderItem> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleOrderItemCommands implements OrderItemCommands
    {
        private List<OrderItemCommand> innerCommands = new ArrayList<OrderItemCommand>();

        public void add(OrderItemCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderItemCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderItemCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateOrderShipGroupCommands implements CreateOrderShipGroupCommands
    {
        private List<OrderShipGroupCommand.CreateOrderShipGroup> innerCommands = new ArrayList<OrderShipGroupCommand.CreateOrderShipGroup>();

        public void add(OrderShipGroupCommand.CreateOrderShipGroup c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderShipGroupCommand.CreateOrderShipGroup c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderShipGroupCommand.CreateOrderShipGroup> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleOrderShipGroupCommands implements OrderShipGroupCommands
    {
        private List<OrderShipGroupCommand> innerCommands = new ArrayList<OrderShipGroupCommand>();

        public void add(OrderShipGroupCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(OrderShipGroupCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<OrderShipGroupCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

