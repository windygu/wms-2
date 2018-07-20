package org.dddml.wms.domain.orderrolemvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderRoleMvoDto extends AbstractOrderRoleMvoCommandDto
{
    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    /**
     * Order Order Type Id
     */
    private String orderOrderTypeId;

    public String getOrderOrderTypeId()
    {
        return this.orderOrderTypeId;
    }

    public void setOrderOrderTypeId(String orderOrderTypeId)
    {
        this.orderOrderTypeId = orderOrderTypeId;
    }

    /**
     * Order Order Name
     */
    private String orderOrderName;

    public String getOrderOrderName()
    {
        return this.orderOrderName;
    }

    public void setOrderOrderName(String orderOrderName)
    {
        this.orderOrderName = orderOrderName;
    }

    /**
     * Order External Id
     */
    private String orderExternalId;

    public String getOrderExternalId()
    {
        return this.orderExternalId;
    }

    public void setOrderExternalId(String orderExternalId)
    {
        this.orderExternalId = orderExternalId;
    }

    /**
     * Order Sales Channel Enum Id
     */
    private String orderSalesChannelEnumId;

    public String getOrderSalesChannelEnumId()
    {
        return this.orderSalesChannelEnumId;
    }

    public void setOrderSalesChannelEnumId(String orderSalesChannelEnumId)
    {
        this.orderSalesChannelEnumId = orderSalesChannelEnumId;
    }

    /**
     * Order Order Date
     */
    private java.sql.Timestamp orderOrderDate;

    public java.sql.Timestamp getOrderOrderDate()
    {
        return this.orderOrderDate;
    }

    public void setOrderOrderDate(java.sql.Timestamp orderOrderDate)
    {
        this.orderOrderDate = orderOrderDate;
    }

    /**
     * Order Priority
     */
    private String orderPriority;

    public String getOrderPriority()
    {
        return this.orderPriority;
    }

    public void setOrderPriority(String orderPriority)
    {
        this.orderPriority = orderPriority;
    }

    /**
     * Order Entry Date
     */
    private java.sql.Timestamp orderEntryDate;

    public java.sql.Timestamp getOrderEntryDate()
    {
        return this.orderEntryDate;
    }

    public void setOrderEntryDate(java.sql.Timestamp orderEntryDate)
    {
        this.orderEntryDate = orderEntryDate;
    }

    /**
     * This will be set to a date when pick sheet of the order is printed
     */
    private java.sql.Timestamp orderPickSheetPrintedDate;

    public java.sql.Timestamp getOrderPickSheetPrintedDate()
    {
        return this.orderPickSheetPrintedDate;
    }

    public void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate)
    {
        this.orderPickSheetPrintedDate = orderPickSheetPrintedDate;
    }

    /**
     * Order Status Id
     */
    private String orderStatusId;

    public String getOrderStatusId()
    {
        return this.orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId)
    {
        this.orderStatusId = orderStatusId;
    }

    /**
     * Order Currency Uom
     */
    private String orderCurrencyUom;

    public String getOrderCurrencyUom()
    {
        return this.orderCurrencyUom;
    }

    public void setOrderCurrencyUom(String orderCurrencyUom)
    {
        this.orderCurrencyUom = orderCurrencyUom;
    }

    /**
     * Order Sync Status Id
     */
    private String orderSyncStatusId;

    public String getOrderSyncStatusId()
    {
        return this.orderSyncStatusId;
    }

    public void setOrderSyncStatusId(String orderSyncStatusId)
    {
        this.orderSyncStatusId = orderSyncStatusId;
    }

    /**
     * Order Billing Account Id
     */
    private String orderBillingAccountId;

    public String getOrderBillingAccountId()
    {
        return this.orderBillingAccountId;
    }

    public void setOrderBillingAccountId(String orderBillingAccountId)
    {
        this.orderBillingAccountId = orderBillingAccountId;
    }

    /**
     * Order Origin Facility Id
     */
    private String orderOriginFacilityId;

    public String getOrderOriginFacilityId()
    {
        return this.orderOriginFacilityId;
    }

    public void setOrderOriginFacilityId(String orderOriginFacilityId)
    {
        this.orderOriginFacilityId = orderOriginFacilityId;
    }

    /**
     * Order Web Site Id
     */
    private String orderWebSiteId;

    public String getOrderWebSiteId()
    {
        return this.orderWebSiteId;
    }

    public void setOrderWebSiteId(String orderWebSiteId)
    {
        this.orderWebSiteId = orderWebSiteId;
    }

    /**
     * Order Product Store Id
     */
    private String orderProductStoreId;

    public String getOrderProductStoreId()
    {
        return this.orderProductStoreId;
    }

    public void setOrderProductStoreId(String orderProductStoreId)
    {
        this.orderProductStoreId = orderProductStoreId;
    }

    /**
     * Order Terminal Id
     */
    private String orderTerminalId;

    public String getOrderTerminalId()
    {
        return this.orderTerminalId;
    }

    public void setOrderTerminalId(String orderTerminalId)
    {
        this.orderTerminalId = orderTerminalId;
    }

    /**
     * Order Transaction Id
     */
    private String orderTransactionId;

    public String getOrderTransactionId()
    {
        return this.orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId)
    {
        this.orderTransactionId = orderTransactionId;
    }

    /**
     * Order Auto Order Shopping List Id
     */
    private String orderAutoOrderShoppingListId;

    public String getOrderAutoOrderShoppingListId()
    {
        return this.orderAutoOrderShoppingListId;
    }

    public void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId)
    {
        this.orderAutoOrderShoppingListId = orderAutoOrderShoppingListId;
    }

    /**
     * Order Needs Inventory Issuance
     */
    private String orderNeedsInventoryIssuance;

    public String getOrderNeedsInventoryIssuance()
    {
        return this.orderNeedsInventoryIssuance;
    }

    public void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance)
    {
        this.orderNeedsInventoryIssuance = orderNeedsInventoryIssuance;
    }

    /**
     * Order Is Rush Order
     */
    private String orderIsRushOrder;

    public String getOrderIsRushOrder()
    {
        return this.orderIsRushOrder;
    }

    public void setOrderIsRushOrder(String orderIsRushOrder)
    {
        this.orderIsRushOrder = orderIsRushOrder;
    }

    /**
     * Order Internal Code
     */
    private String orderInternalCode;

    public String getOrderInternalCode()
    {
        return this.orderInternalCode;
    }

    public void setOrderInternalCode(String orderInternalCode)
    {
        this.orderInternalCode = orderInternalCode;
    }

    /**
     * Order Remaining Sub Total
     */
    private java.math.BigDecimal orderRemainingSubTotal;

    public java.math.BigDecimal getOrderRemainingSubTotal()
    {
        return this.orderRemainingSubTotal;
    }

    public void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal)
    {
        this.orderRemainingSubTotal = orderRemainingSubTotal;
    }

    /**
     * Order Grand Total
     */
    private java.math.BigDecimal orderGrandTotal;

    public java.math.BigDecimal getOrderGrandTotal()
    {
        return this.orderGrandTotal;
    }

    public void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal)
    {
        this.orderGrandTotal = orderGrandTotal;
    }

    /**
     * Order Invoice Per Shipment
     */
    private String orderInvoicePerShipment;

    public String getOrderInvoicePerShipment()
    {
        return this.orderInvoicePerShipment;
    }

    public void setOrderInvoicePerShipment(String orderInvoicePerShipment)
    {
        this.orderInvoicePerShipment = orderInvoicePerShipment;
    }

    /**
     * Order Created By
     */
    private String orderCreatedBy;

    public String getOrderCreatedBy()
    {
        return this.orderCreatedBy;
    }

    public void setOrderCreatedBy(String orderCreatedBy)
    {
        this.orderCreatedBy = orderCreatedBy;
    }

    /**
     * Order Created At
     */
    private Date orderCreatedAt;

    public Date getOrderCreatedAt()
    {
        return this.orderCreatedAt;
    }

    public void setOrderCreatedAt(Date orderCreatedAt)
    {
        this.orderCreatedAt = orderCreatedAt;
    }

    /**
     * Order Updated By
     */
    private String orderUpdatedBy;

    public String getOrderUpdatedBy()
    {
        return this.orderUpdatedBy;
    }

    public void setOrderUpdatedBy(String orderUpdatedBy)
    {
        this.orderUpdatedBy = orderUpdatedBy;
    }

    /**
     * Order Updated At
     */
    private Date orderUpdatedAt;

    public Date getOrderUpdatedAt()
    {
        return this.orderUpdatedAt;
    }

    public void setOrderUpdatedAt(Date orderUpdatedAt)
    {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    /**
     * Order Active
     */
    private Boolean orderActive;

    public Boolean getOrderActive()
    {
        return this.orderActive;
    }

    public void setOrderActive(Boolean orderActive)
    {
        this.orderActive = orderActive;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved()
    {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed)
    {
        this.isPropertyVersionRemoved = removed;
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

    private Boolean isPropertyOrderOrderTypeIdRemoved;

    public Boolean getIsPropertyOrderOrderTypeIdRemoved()
    {
        return this.isPropertyOrderOrderTypeIdRemoved;
    }

    public void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed)
    {
        this.isPropertyOrderOrderTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderOrderNameRemoved;

    public Boolean getIsPropertyOrderOrderNameRemoved()
    {
        return this.isPropertyOrderOrderNameRemoved;
    }

    public void setIsPropertyOrderOrderNameRemoved(Boolean removed)
    {
        this.isPropertyOrderOrderNameRemoved = removed;
    }

    private Boolean isPropertyOrderExternalIdRemoved;

    public Boolean getIsPropertyOrderExternalIdRemoved()
    {
        return this.isPropertyOrderExternalIdRemoved;
    }

    public void setIsPropertyOrderExternalIdRemoved(Boolean removed)
    {
        this.isPropertyOrderExternalIdRemoved = removed;
    }

    private Boolean isPropertyOrderSalesChannelEnumIdRemoved;

    public Boolean getIsPropertyOrderSalesChannelEnumIdRemoved()
    {
        return this.isPropertyOrderSalesChannelEnumIdRemoved;
    }

    public void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed)
    {
        this.isPropertyOrderSalesChannelEnumIdRemoved = removed;
    }

    private Boolean isPropertyOrderOrderDateRemoved;

    public Boolean getIsPropertyOrderOrderDateRemoved()
    {
        return this.isPropertyOrderOrderDateRemoved;
    }

    public void setIsPropertyOrderOrderDateRemoved(Boolean removed)
    {
        this.isPropertyOrderOrderDateRemoved = removed;
    }

    private Boolean isPropertyOrderPriorityRemoved;

    public Boolean getIsPropertyOrderPriorityRemoved()
    {
        return this.isPropertyOrderPriorityRemoved;
    }

    public void setIsPropertyOrderPriorityRemoved(Boolean removed)
    {
        this.isPropertyOrderPriorityRemoved = removed;
    }

    private Boolean isPropertyOrderEntryDateRemoved;

    public Boolean getIsPropertyOrderEntryDateRemoved()
    {
        return this.isPropertyOrderEntryDateRemoved;
    }

    public void setIsPropertyOrderEntryDateRemoved(Boolean removed)
    {
        this.isPropertyOrderEntryDateRemoved = removed;
    }

    private Boolean isPropertyOrderPickSheetPrintedDateRemoved;

    public Boolean getIsPropertyOrderPickSheetPrintedDateRemoved()
    {
        return this.isPropertyOrderPickSheetPrintedDateRemoved;
    }

    public void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed)
    {
        this.isPropertyOrderPickSheetPrintedDateRemoved = removed;
    }

    private Boolean isPropertyOrderStatusIdRemoved;

    public Boolean getIsPropertyOrderStatusIdRemoved()
    {
        return this.isPropertyOrderStatusIdRemoved;
    }

    public void setIsPropertyOrderStatusIdRemoved(Boolean removed)
    {
        this.isPropertyOrderStatusIdRemoved = removed;
    }

    private Boolean isPropertyOrderCurrencyUomRemoved;

    public Boolean getIsPropertyOrderCurrencyUomRemoved()
    {
        return this.isPropertyOrderCurrencyUomRemoved;
    }

    public void setIsPropertyOrderCurrencyUomRemoved(Boolean removed)
    {
        this.isPropertyOrderCurrencyUomRemoved = removed;
    }

    private Boolean isPropertyOrderSyncStatusIdRemoved;

    public Boolean getIsPropertyOrderSyncStatusIdRemoved()
    {
        return this.isPropertyOrderSyncStatusIdRemoved;
    }

    public void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed)
    {
        this.isPropertyOrderSyncStatusIdRemoved = removed;
    }

    private Boolean isPropertyOrderBillingAccountIdRemoved;

    public Boolean getIsPropertyOrderBillingAccountIdRemoved()
    {
        return this.isPropertyOrderBillingAccountIdRemoved;
    }

    public void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed)
    {
        this.isPropertyOrderBillingAccountIdRemoved = removed;
    }

    private Boolean isPropertyOrderOriginFacilityIdRemoved;

    public Boolean getIsPropertyOrderOriginFacilityIdRemoved()
    {
        return this.isPropertyOrderOriginFacilityIdRemoved;
    }

    public void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyOrderOriginFacilityIdRemoved = removed;
    }

    private Boolean isPropertyOrderWebSiteIdRemoved;

    public Boolean getIsPropertyOrderWebSiteIdRemoved()
    {
        return this.isPropertyOrderWebSiteIdRemoved;
    }

    public void setIsPropertyOrderWebSiteIdRemoved(Boolean removed)
    {
        this.isPropertyOrderWebSiteIdRemoved = removed;
    }

    private Boolean isPropertyOrderProductStoreIdRemoved;

    public Boolean getIsPropertyOrderProductStoreIdRemoved()
    {
        return this.isPropertyOrderProductStoreIdRemoved;
    }

    public void setIsPropertyOrderProductStoreIdRemoved(Boolean removed)
    {
        this.isPropertyOrderProductStoreIdRemoved = removed;
    }

    private Boolean isPropertyOrderTerminalIdRemoved;

    public Boolean getIsPropertyOrderTerminalIdRemoved()
    {
        return this.isPropertyOrderTerminalIdRemoved;
    }

    public void setIsPropertyOrderTerminalIdRemoved(Boolean removed)
    {
        this.isPropertyOrderTerminalIdRemoved = removed;
    }

    private Boolean isPropertyOrderTransactionIdRemoved;

    public Boolean getIsPropertyOrderTransactionIdRemoved()
    {
        return this.isPropertyOrderTransactionIdRemoved;
    }

    public void setIsPropertyOrderTransactionIdRemoved(Boolean removed)
    {
        this.isPropertyOrderTransactionIdRemoved = removed;
    }

    private Boolean isPropertyOrderAutoOrderShoppingListIdRemoved;

    public Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved()
    {
        return this.isPropertyOrderAutoOrderShoppingListIdRemoved;
    }

    public void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed)
    {
        this.isPropertyOrderAutoOrderShoppingListIdRemoved = removed;
    }

    private Boolean isPropertyOrderNeedsInventoryIssuanceRemoved;

    public Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved()
    {
        return this.isPropertyOrderNeedsInventoryIssuanceRemoved;
    }

    public void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed)
    {
        this.isPropertyOrderNeedsInventoryIssuanceRemoved = removed;
    }

    private Boolean isPropertyOrderIsRushOrderRemoved;

    public Boolean getIsPropertyOrderIsRushOrderRemoved()
    {
        return this.isPropertyOrderIsRushOrderRemoved;
    }

    public void setIsPropertyOrderIsRushOrderRemoved(Boolean removed)
    {
        this.isPropertyOrderIsRushOrderRemoved = removed;
    }

    private Boolean isPropertyOrderInternalCodeRemoved;

    public Boolean getIsPropertyOrderInternalCodeRemoved()
    {
        return this.isPropertyOrderInternalCodeRemoved;
    }

    public void setIsPropertyOrderInternalCodeRemoved(Boolean removed)
    {
        this.isPropertyOrderInternalCodeRemoved = removed;
    }

    private Boolean isPropertyOrderRemainingSubTotalRemoved;

    public Boolean getIsPropertyOrderRemainingSubTotalRemoved()
    {
        return this.isPropertyOrderRemainingSubTotalRemoved;
    }

    public void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed)
    {
        this.isPropertyOrderRemainingSubTotalRemoved = removed;
    }

    private Boolean isPropertyOrderGrandTotalRemoved;

    public Boolean getIsPropertyOrderGrandTotalRemoved()
    {
        return this.isPropertyOrderGrandTotalRemoved;
    }

    public void setIsPropertyOrderGrandTotalRemoved(Boolean removed)
    {
        this.isPropertyOrderGrandTotalRemoved = removed;
    }

    private Boolean isPropertyOrderInvoicePerShipmentRemoved;

    public Boolean getIsPropertyOrderInvoicePerShipmentRemoved()
    {
        return this.isPropertyOrderInvoicePerShipmentRemoved;
    }

    public void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed)
    {
        this.isPropertyOrderInvoicePerShipmentRemoved = removed;
    }

    private Boolean isPropertyOrderCreatedByRemoved;

    public Boolean getIsPropertyOrderCreatedByRemoved()
    {
        return this.isPropertyOrderCreatedByRemoved;
    }

    public void setIsPropertyOrderCreatedByRemoved(Boolean removed)
    {
        this.isPropertyOrderCreatedByRemoved = removed;
    }

    private Boolean isPropertyOrderCreatedAtRemoved;

    public Boolean getIsPropertyOrderCreatedAtRemoved()
    {
        return this.isPropertyOrderCreatedAtRemoved;
    }

    public void setIsPropertyOrderCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyOrderCreatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderUpdatedByRemoved;

    public Boolean getIsPropertyOrderUpdatedByRemoved()
    {
        return this.isPropertyOrderUpdatedByRemoved;
    }

    public void setIsPropertyOrderUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyOrderUpdatedByRemoved = removed;
    }

    private Boolean isPropertyOrderUpdatedAtRemoved;

    public Boolean getIsPropertyOrderUpdatedAtRemoved()
    {
        return this.isPropertyOrderUpdatedAtRemoved;
    }

    public void setIsPropertyOrderUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyOrderUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderActiveRemoved;

    public Boolean getIsPropertyOrderActiveRemoved()
    {
        return this.isPropertyOrderActiveRemoved;
    }

    public void setIsPropertyOrderActiveRemoved(Boolean removed)
    {
        this.isPropertyOrderActiveRemoved = removed;
    }

    public void copyTo(AbstractOrderRoleMvoCommand.AbstractCreateOrMergePatchOrderRoleMvo command)
    {
        ((AbstractOrderRoleMvoCommandDto) this).copyTo(command);
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setOrderOrderTypeId(this.getOrderOrderTypeId());
        command.setOrderOrderName(this.getOrderOrderName());
        command.setOrderExternalId(this.getOrderExternalId());
        command.setOrderSalesChannelEnumId(this.getOrderSalesChannelEnumId());
        command.setOrderOrderDate(this.getOrderOrderDate());
        command.setOrderPriority(this.getOrderPriority());
        command.setOrderEntryDate(this.getOrderEntryDate());
        command.setOrderPickSheetPrintedDate(this.getOrderPickSheetPrintedDate());
        command.setOrderStatusId(this.getOrderStatusId());
        command.setOrderCurrencyUom(this.getOrderCurrencyUom());
        command.setOrderSyncStatusId(this.getOrderSyncStatusId());
        command.setOrderBillingAccountId(this.getOrderBillingAccountId());
        command.setOrderOriginFacilityId(this.getOrderOriginFacilityId());
        command.setOrderWebSiteId(this.getOrderWebSiteId());
        command.setOrderProductStoreId(this.getOrderProductStoreId());
        command.setOrderTerminalId(this.getOrderTerminalId());
        command.setOrderTransactionId(this.getOrderTransactionId());
        command.setOrderAutoOrderShoppingListId(this.getOrderAutoOrderShoppingListId());
        command.setOrderNeedsInventoryIssuance(this.getOrderNeedsInventoryIssuance());
        command.setOrderIsRushOrder(this.getOrderIsRushOrder());
        command.setOrderInternalCode(this.getOrderInternalCode());
        command.setOrderRemainingSubTotal(this.getOrderRemainingSubTotal());
        command.setOrderGrandTotal(this.getOrderGrandTotal());
        command.setOrderInvoicePerShipment(this.getOrderInvoicePerShipment());
        command.setOrderCreatedBy(this.getOrderCreatedBy());
        command.setOrderCreatedAt(this.getOrderCreatedAt());
        command.setOrderUpdatedBy(this.getOrderUpdatedBy());
        command.setOrderUpdatedAt(this.getOrderUpdatedAt());
        command.setOrderActive(this.getOrderActive());
    }

    public OrderRoleMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderRoleMvoCommand.SimpleCreateOrderRoleMvo command = new AbstractOrderRoleMvoCommand.SimpleCreateOrderRoleMvo();
            copyTo((AbstractOrderRoleMvoCommand.AbstractCreateOrderRoleMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderRoleMvoCommand.SimpleMergePatchOrderRoleMvo command = new AbstractOrderRoleMvoCommand.SimpleMergePatchOrderRoleMvo();
            copyTo((AbstractOrderRoleMvoCommand.SimpleMergePatchOrderRoleMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderRoleMvoCommand.AbstractCreateOrderRoleMvo command)
    {
        copyTo((AbstractOrderRoleMvoCommand.AbstractCreateOrMergePatchOrderRoleMvo) command);
    }

    public void copyTo(AbstractOrderRoleMvoCommand.AbstractMergePatchOrderRoleMvo command)
    {
        copyTo((AbstractOrderRoleMvoCommand.AbstractCreateOrMergePatchOrderRoleMvo) command);
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyOrderOrderTypeIdRemoved(this.getIsPropertyOrderOrderTypeIdRemoved());
        command.setIsPropertyOrderOrderNameRemoved(this.getIsPropertyOrderOrderNameRemoved());
        command.setIsPropertyOrderExternalIdRemoved(this.getIsPropertyOrderExternalIdRemoved());
        command.setIsPropertyOrderSalesChannelEnumIdRemoved(this.getIsPropertyOrderSalesChannelEnumIdRemoved());
        command.setIsPropertyOrderOrderDateRemoved(this.getIsPropertyOrderOrderDateRemoved());
        command.setIsPropertyOrderPriorityRemoved(this.getIsPropertyOrderPriorityRemoved());
        command.setIsPropertyOrderEntryDateRemoved(this.getIsPropertyOrderEntryDateRemoved());
        command.setIsPropertyOrderPickSheetPrintedDateRemoved(this.getIsPropertyOrderPickSheetPrintedDateRemoved());
        command.setIsPropertyOrderStatusIdRemoved(this.getIsPropertyOrderStatusIdRemoved());
        command.setIsPropertyOrderCurrencyUomRemoved(this.getIsPropertyOrderCurrencyUomRemoved());
        command.setIsPropertyOrderSyncStatusIdRemoved(this.getIsPropertyOrderSyncStatusIdRemoved());
        command.setIsPropertyOrderBillingAccountIdRemoved(this.getIsPropertyOrderBillingAccountIdRemoved());
        command.setIsPropertyOrderOriginFacilityIdRemoved(this.getIsPropertyOrderOriginFacilityIdRemoved());
        command.setIsPropertyOrderWebSiteIdRemoved(this.getIsPropertyOrderWebSiteIdRemoved());
        command.setIsPropertyOrderProductStoreIdRemoved(this.getIsPropertyOrderProductStoreIdRemoved());
        command.setIsPropertyOrderTerminalIdRemoved(this.getIsPropertyOrderTerminalIdRemoved());
        command.setIsPropertyOrderTransactionIdRemoved(this.getIsPropertyOrderTransactionIdRemoved());
        command.setIsPropertyOrderAutoOrderShoppingListIdRemoved(this.getIsPropertyOrderAutoOrderShoppingListIdRemoved());
        command.setIsPropertyOrderNeedsInventoryIssuanceRemoved(this.getIsPropertyOrderNeedsInventoryIssuanceRemoved());
        command.setIsPropertyOrderIsRushOrderRemoved(this.getIsPropertyOrderIsRushOrderRemoved());
        command.setIsPropertyOrderInternalCodeRemoved(this.getIsPropertyOrderInternalCodeRemoved());
        command.setIsPropertyOrderRemainingSubTotalRemoved(this.getIsPropertyOrderRemainingSubTotalRemoved());
        command.setIsPropertyOrderGrandTotalRemoved(this.getIsPropertyOrderGrandTotalRemoved());
        command.setIsPropertyOrderInvoicePerShipmentRemoved(this.getIsPropertyOrderInvoicePerShipmentRemoved());
        command.setIsPropertyOrderCreatedByRemoved(this.getIsPropertyOrderCreatedByRemoved());
        command.setIsPropertyOrderCreatedAtRemoved(this.getIsPropertyOrderCreatedAtRemoved());
        command.setIsPropertyOrderUpdatedByRemoved(this.getIsPropertyOrderUpdatedByRemoved());
        command.setIsPropertyOrderUpdatedAtRemoved(this.getIsPropertyOrderUpdatedAtRemoved());
        command.setIsPropertyOrderActiveRemoved(this.getIsPropertyOrderActiveRemoved());
    }

    public static class CreateOrderRoleMvoDto extends CreateOrMergePatchOrderRoleMvoDto
    {
        public CreateOrderRoleMvoDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderRoleMvoCommand.CreateOrderRoleMvo toCreateOrderRoleMvo()
        {
            return (OrderRoleMvoCommand.CreateOrderRoleMvo) toCommand();
        }

    }

    public static class MergePatchOrderRoleMvoDto extends CreateOrMergePatchOrderRoleMvoDto
    {
        public MergePatchOrderRoleMvoDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderRoleMvoCommand.MergePatchOrderRoleMvo toMergePatchOrderRoleMvo()
        {
            return (OrderRoleMvoCommand.MergePatchOrderRoleMvo) toCommand();
        }

    }

}

