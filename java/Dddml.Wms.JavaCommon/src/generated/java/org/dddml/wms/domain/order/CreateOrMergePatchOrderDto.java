package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderDto extends AbstractOrderCommandDto
{
    /**
     * Order Type Id
     */
    private String orderTypeId;

    public String getOrderTypeId()
    {
        return this.orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId)
    {
        this.orderTypeId = orderTypeId;
    }

    /**
     * Order Name
     */
    private String orderName;

    public String getOrderName()
    {
        return this.orderName;
    }

    public void setOrderName(String orderName)
    {
        this.orderName = orderName;
    }

    /**
     * External Id
     */
    private String externalId;

    public String getExternalId()
    {
        return this.externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    /**
     * Sales Channel Enum Id
     */
    private String salesChannelEnumId;

    public String getSalesChannelEnumId()
    {
        return this.salesChannelEnumId;
    }

    public void setSalesChannelEnumId(String salesChannelEnumId)
    {
        this.salesChannelEnumId = salesChannelEnumId;
    }

    /**
     * Order Date
     */
    private java.sql.Timestamp orderDate;

    public java.sql.Timestamp getOrderDate()
    {
        return this.orderDate;
    }

    public void setOrderDate(java.sql.Timestamp orderDate)
    {
        this.orderDate = orderDate;
    }

    /**
     * Priority
     */
    private String priority;

    public String getPriority()
    {
        return this.priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    /**
     * Entry Date
     */
    private java.sql.Timestamp entryDate;

    public java.sql.Timestamp getEntryDate()
    {
        return this.entryDate;
    }

    public void setEntryDate(java.sql.Timestamp entryDate)
    {
        this.entryDate = entryDate;
    }

    /**
     * This will be set to a date when pick sheet of the order is printed
     */
    private java.sql.Timestamp pickSheetPrintedDate;

    public java.sql.Timestamp getPickSheetPrintedDate()
    {
        return this.pickSheetPrintedDate;
    }

    public void setPickSheetPrintedDate(java.sql.Timestamp pickSheetPrintedDate)
    {
        this.pickSheetPrintedDate = pickSheetPrintedDate;
    }

    /**
     * Status Id
     */
    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    /**
     * Currency Uom Id
     */
    private String currencyUomId;

    public String getCurrencyUomId()
    {
        return this.currencyUomId;
    }

    public void setCurrencyUomId(String currencyUomId)
    {
        this.currencyUomId = currencyUomId;
    }

    /**
     * Sync Status Id
     */
    private String syncStatusId;

    public String getSyncStatusId()
    {
        return this.syncStatusId;
    }

    public void setSyncStatusId(String syncStatusId)
    {
        this.syncStatusId = syncStatusId;
    }

    /**
     * Billing Account Id
     */
    private String billingAccountId;

    public String getBillingAccountId()
    {
        return this.billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId)
    {
        this.billingAccountId = billingAccountId;
    }

    /**
     * Origin Facility Id
     */
    private String originFacilityId;

    public String getOriginFacilityId()
    {
        return this.originFacilityId;
    }

    public void setOriginFacilityId(String originFacilityId)
    {
        this.originFacilityId = originFacilityId;
    }

    /**
     * Web Site Id
     */
    private String webSiteId;

    public String getWebSiteId()
    {
        return this.webSiteId;
    }

    public void setWebSiteId(String webSiteId)
    {
        this.webSiteId = webSiteId;
    }

    /**
     * Product Store Id
     */
    private String productStoreId;

    public String getProductStoreId()
    {
        return this.productStoreId;
    }

    public void setProductStoreId(String productStoreId)
    {
        this.productStoreId = productStoreId;
    }

    /**
     * Terminal Id
     */
    private String terminalId;

    public String getTerminalId()
    {
        return this.terminalId;
    }

    public void setTerminalId(String terminalId)
    {
        this.terminalId = terminalId;
    }

    /**
     * Transaction Id
     */
    private String transactionId;

    public String getTransactionId()
    {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    /**
     * Auto Order Shopping List Id
     */
    private String autoOrderShoppingListId;

    public String getAutoOrderShoppingListId()
    {
        return this.autoOrderShoppingListId;
    }

    public void setAutoOrderShoppingListId(String autoOrderShoppingListId)
    {
        this.autoOrderShoppingListId = autoOrderShoppingListId;
    }

    /**
     * Needs Inventory Issuance
     */
    private String needsInventoryIssuance;

    public String getNeedsInventoryIssuance()
    {
        return this.needsInventoryIssuance;
    }

    public void setNeedsInventoryIssuance(String needsInventoryIssuance)
    {
        this.needsInventoryIssuance = needsInventoryIssuance;
    }

    /**
     * Is Rush Order
     */
    private String isRushOrder;

    public String getIsRushOrder()
    {
        return this.isRushOrder;
    }

    public void setIsRushOrder(String isRushOrder)
    {
        this.isRushOrder = isRushOrder;
    }

    /**
     * Internal Code
     */
    private String internalCode;

    public String getInternalCode()
    {
        return this.internalCode;
    }

    public void setInternalCode(String internalCode)
    {
        this.internalCode = internalCode;
    }

    /**
     * Remaining Sub Total
     */
    private java.math.BigDecimal remainingSubTotal;

    public java.math.BigDecimal getRemainingSubTotal()
    {
        return this.remainingSubTotal;
    }

    public void setRemainingSubTotal(java.math.BigDecimal remainingSubTotal)
    {
        this.remainingSubTotal = remainingSubTotal;
    }

    /**
     * Grand Total
     */
    private java.math.BigDecimal grandTotal;

    public java.math.BigDecimal getGrandTotal()
    {
        return this.grandTotal;
    }

    public void setGrandTotal(java.math.BigDecimal grandTotal)
    {
        this.grandTotal = grandTotal;
    }

    /**
     * Invoice Per Shipment
     */
    private String invoicePerShipment;

    public String getInvoicePerShipment()
    {
        return this.invoicePerShipment;
    }

    public void setInvoicePerShipment(String invoicePerShipment)
    {
        this.invoicePerShipment = invoicePerShipment;
    }

    /**
     * F_ B_1_
     */
    private Boolean f_B_1_;

    public Boolean getF_B_1_()
    {
        return this.f_B_1_;
    }

    public void setF_B_1_(Boolean f_B_1_)
    {
        this.f_B_1_ = f_B_1_;
    }

    /**
     * F_ B_2_
     */
    private Boolean f_B_2_;

    public Boolean getF_B_2_()
    {
        return this.f_B_2_;
    }

    public void setF_B_2_(Boolean f_B_2_)
    {
        this.f_B_2_ = f_B_2_;
    }

    /**
     * F_ B_3_
     */
    private Boolean f_B_3_;

    public Boolean getF_B_3_()
    {
        return this.f_B_3_;
    }

    public void setF_B_3_(Boolean f_B_3_)
    {
        this.f_B_3_ = f_B_3_;
    }

    /**
     * F_ C10_1_
     */
    private String f_C10_1_;

    public String getF_C10_1_()
    {
        return this.f_C10_1_;
    }

    public void setF_C10_1_(String f_C10_1_)
    {
        this.f_C10_1_ = f_C10_1_;
    }

    /**
     * F_ C10_2_
     */
    private String f_C10_2_;

    public String getF_C10_2_()
    {
        return this.f_C10_2_;
    }

    public void setF_C10_2_(String f_C10_2_)
    {
        this.f_C10_2_ = f_C10_2_;
    }

    /**
     * F_ C10_3_
     */
    private String f_C10_3_;

    public String getF_C10_3_()
    {
        return this.f_C10_3_;
    }

    public void setF_C10_3_(String f_C10_3_)
    {
        this.f_C10_3_ = f_C10_3_;
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

    private CreateOrMergePatchOrderRoleDto[] orderRoles;

    public CreateOrMergePatchOrderRoleDto[] getOrderRoles()
    {
        return this.orderRoles;
    }

    public void setOrderRoles(CreateOrMergePatchOrderRoleDto[] orderRoles)
    {
        this.orderRoles = orderRoles;
    }

    private CreateOrMergePatchOrderItemDto[] orderItems;

    public CreateOrMergePatchOrderItemDto[] getOrderItems()
    {
        return this.orderItems;
    }

    public void setOrderItems(CreateOrMergePatchOrderItemDto[] orderItems)
    {
        this.orderItems = orderItems;
    }

    private CreateOrMergePatchOrderShipGroupDto[] orderShipGroups;

    public CreateOrMergePatchOrderShipGroupDto[] getOrderShipGroups()
    {
        return this.orderShipGroups;
    }

    public void setOrderShipGroups(CreateOrMergePatchOrderShipGroupDto[] orderShipGroups)
    {
        this.orderShipGroups = orderShipGroups;
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

    private Boolean isPropertyCurrencyUomIdRemoved;

    public Boolean getIsPropertyCurrencyUomIdRemoved()
    {
        return this.isPropertyCurrencyUomIdRemoved;
    }

    public void setIsPropertyCurrencyUomIdRemoved(Boolean removed)
    {
        this.isPropertyCurrencyUomIdRemoved = removed;
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

    private Boolean isPropertyF_B_1_Removed;

    public Boolean getIsPropertyF_B_1_Removed()
    {
        return this.isPropertyF_B_1_Removed;
    }

    public void setIsPropertyF_B_1_Removed(Boolean removed)
    {
        this.isPropertyF_B_1_Removed = removed;
    }

    private Boolean isPropertyF_B_2_Removed;

    public Boolean getIsPropertyF_B_2_Removed()
    {
        return this.isPropertyF_B_2_Removed;
    }

    public void setIsPropertyF_B_2_Removed(Boolean removed)
    {
        this.isPropertyF_B_2_Removed = removed;
    }

    private Boolean isPropertyF_B_3_Removed;

    public Boolean getIsPropertyF_B_3_Removed()
    {
        return this.isPropertyF_B_3_Removed;
    }

    public void setIsPropertyF_B_3_Removed(Boolean removed)
    {
        this.isPropertyF_B_3_Removed = removed;
    }

    private Boolean isPropertyF_C10_1_Removed;

    public Boolean getIsPropertyF_C10_1_Removed()
    {
        return this.isPropertyF_C10_1_Removed;
    }

    public void setIsPropertyF_C10_1_Removed(Boolean removed)
    {
        this.isPropertyF_C10_1_Removed = removed;
    }

    private Boolean isPropertyF_C10_2_Removed;

    public Boolean getIsPropertyF_C10_2_Removed()
    {
        return this.isPropertyF_C10_2_Removed;
    }

    public void setIsPropertyF_C10_2_Removed(Boolean removed)
    {
        this.isPropertyF_C10_2_Removed = removed;
    }

    private Boolean isPropertyF_C10_3_Removed;

    public Boolean getIsPropertyF_C10_3_Removed()
    {
        return this.isPropertyF_C10_3_Removed;
    }

    public void setIsPropertyF_C10_3_Removed(Boolean removed)
    {
        this.isPropertyF_C10_3_Removed = removed;
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

    public void copyTo(AbstractOrderCommand.AbstractCreateOrMergePatchOrder command)
    {
        ((AbstractOrderCommandDto) this).copyTo(command);
        command.setOrderTypeId(this.getOrderTypeId());
        command.setOrderName(this.getOrderName());
        command.setExternalId(this.getExternalId());
        command.setSalesChannelEnumId(this.getSalesChannelEnumId());
        command.setOrderDate(this.getOrderDate());
        command.setPriority(this.getPriority());
        command.setEntryDate(this.getEntryDate());
        command.setPickSheetPrintedDate(this.getPickSheetPrintedDate());
        command.setStatusId(this.getStatusId());
        command.setCurrencyUomId(this.getCurrencyUomId());
        command.setSyncStatusId(this.getSyncStatusId());
        command.setBillingAccountId(this.getBillingAccountId());
        command.setOriginFacilityId(this.getOriginFacilityId());
        command.setWebSiteId(this.getWebSiteId());
        command.setProductStoreId(this.getProductStoreId());
        command.setTerminalId(this.getTerminalId());
        command.setTransactionId(this.getTransactionId());
        command.setAutoOrderShoppingListId(this.getAutoOrderShoppingListId());
        command.setNeedsInventoryIssuance(this.getNeedsInventoryIssuance());
        command.setIsRushOrder(this.getIsRushOrder());
        command.setInternalCode(this.getInternalCode());
        command.setRemainingSubTotal(this.getRemainingSubTotal());
        command.setGrandTotal(this.getGrandTotal());
        command.setInvoicePerShipment(this.getInvoicePerShipment());
        command.setF_B_1_(this.getF_B_1_());
        command.setF_B_2_(this.getF_B_2_());
        command.setF_B_3_(this.getF_B_3_());
        command.setF_C10_1_(this.getF_C10_1_());
        command.setF_C10_2_(this.getF_C10_2_());
        command.setF_C10_3_(this.getF_C10_3_());
        command.setActive(this.getActive());
    }

    public OrderCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderCommand.SimpleCreateOrder command = new AbstractOrderCommand.SimpleCreateOrder();
            copyTo((AbstractOrderCommand.AbstractCreateOrder) command);
            if (this.getOrderRoles() != null) {
                for (CreateOrMergePatchOrderRoleDto cmd : this.getOrderRoles()) {
                    command.getOrderRoles().add((OrderRoleCommand.CreateOrderRole) cmd.toCommand());
                }
            }
            if (this.getOrderItems() != null) {
                for (CreateOrMergePatchOrderItemDto cmd : this.getOrderItems()) {
                    command.getOrderItems().add((OrderItemCommand.CreateOrderItem) cmd.toCommand());
                }
            }
            if (this.getOrderShipGroups() != null) {
                for (CreateOrMergePatchOrderShipGroupDto cmd : this.getOrderShipGroups()) {
                    command.getOrderShipGroups().add((OrderShipGroupCommand.CreateOrderShipGroup) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderCommand.SimpleMergePatchOrder command = new AbstractOrderCommand.SimpleMergePatchOrder();
            copyTo((AbstractOrderCommand.SimpleMergePatchOrder) command);
            if (this.getOrderRoles() != null) {
                for (CreateOrMergePatchOrderRoleDto cmd : this.getOrderRoles()) {
                    command.getOrderRoleCommands().add(cmd.toCommand());
                }
            }
            if (this.getOrderItems() != null) {
                for (CreateOrMergePatchOrderItemDto cmd : this.getOrderItems()) {
                    command.getOrderItemCommands().add(cmd.toCommand());
                }
            }
            if (this.getOrderShipGroups() != null) {
                for (CreateOrMergePatchOrderShipGroupDto cmd : this.getOrderShipGroups()) {
                    command.getOrderShipGroupCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderCommand.AbstractCreateOrder command)
    {
        copyTo((AbstractOrderCommand.AbstractCreateOrMergePatchOrder) command);
    }

    public void copyTo(AbstractOrderCommand.AbstractMergePatchOrder command)
    {
        copyTo((AbstractOrderCommand.AbstractCreateOrMergePatchOrder) command);
        command.setIsPropertyOrderTypeIdRemoved(this.getIsPropertyOrderTypeIdRemoved());
        command.setIsPropertyOrderNameRemoved(this.getIsPropertyOrderNameRemoved());
        command.setIsPropertyExternalIdRemoved(this.getIsPropertyExternalIdRemoved());
        command.setIsPropertySalesChannelEnumIdRemoved(this.getIsPropertySalesChannelEnumIdRemoved());
        command.setIsPropertyOrderDateRemoved(this.getIsPropertyOrderDateRemoved());
        command.setIsPropertyPriorityRemoved(this.getIsPropertyPriorityRemoved());
        command.setIsPropertyEntryDateRemoved(this.getIsPropertyEntryDateRemoved());
        command.setIsPropertyPickSheetPrintedDateRemoved(this.getIsPropertyPickSheetPrintedDateRemoved());
        command.setIsPropertyStatusIdRemoved(this.getIsPropertyStatusIdRemoved());
        command.setIsPropertyCurrencyUomIdRemoved(this.getIsPropertyCurrencyUomIdRemoved());
        command.setIsPropertySyncStatusIdRemoved(this.getIsPropertySyncStatusIdRemoved());
        command.setIsPropertyBillingAccountIdRemoved(this.getIsPropertyBillingAccountIdRemoved());
        command.setIsPropertyOriginFacilityIdRemoved(this.getIsPropertyOriginFacilityIdRemoved());
        command.setIsPropertyWebSiteIdRemoved(this.getIsPropertyWebSiteIdRemoved());
        command.setIsPropertyProductStoreIdRemoved(this.getIsPropertyProductStoreIdRemoved());
        command.setIsPropertyTerminalIdRemoved(this.getIsPropertyTerminalIdRemoved());
        command.setIsPropertyTransactionIdRemoved(this.getIsPropertyTransactionIdRemoved());
        command.setIsPropertyAutoOrderShoppingListIdRemoved(this.getIsPropertyAutoOrderShoppingListIdRemoved());
        command.setIsPropertyNeedsInventoryIssuanceRemoved(this.getIsPropertyNeedsInventoryIssuanceRemoved());
        command.setIsPropertyIsRushOrderRemoved(this.getIsPropertyIsRushOrderRemoved());
        command.setIsPropertyInternalCodeRemoved(this.getIsPropertyInternalCodeRemoved());
        command.setIsPropertyRemainingSubTotalRemoved(this.getIsPropertyRemainingSubTotalRemoved());
        command.setIsPropertyGrandTotalRemoved(this.getIsPropertyGrandTotalRemoved());
        command.setIsPropertyInvoicePerShipmentRemoved(this.getIsPropertyInvoicePerShipmentRemoved());
        command.setIsPropertyF_B_1_Removed(this.getIsPropertyF_B_1_Removed());
        command.setIsPropertyF_B_2_Removed(this.getIsPropertyF_B_2_Removed());
        command.setIsPropertyF_B_3_Removed(this.getIsPropertyF_B_3_Removed());
        command.setIsPropertyF_C10_1_Removed(this.getIsPropertyF_C10_1_Removed());
        command.setIsPropertyF_C10_2_Removed(this.getIsPropertyF_C10_2_Removed());
        command.setIsPropertyF_C10_3_Removed(this.getIsPropertyF_C10_3_Removed());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrderDto extends CreateOrMergePatchOrderDto
    {
        public CreateOrderDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderCommand.CreateOrder toCreateOrder()
        {
            return (OrderCommand.CreateOrder) toCommand();
        }

    }

    public static class MergePatchOrderDto extends CreateOrMergePatchOrderDto
    {
        public MergePatchOrderDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderCommand.MergePatchOrder toMergePatchOrder()
        {
            return (OrderCommand.MergePatchOrder) toCommand();
        }

    }

}

