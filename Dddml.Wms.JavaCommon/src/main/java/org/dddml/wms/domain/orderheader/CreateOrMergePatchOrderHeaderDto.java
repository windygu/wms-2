package org.dddml.wms.domain.orderheader;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderHeaderDto extends AbstractOrderHeaderCommandDto
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

    public void copyTo(AbstractOrderHeaderCommand.AbstractCreateOrMergePatchOrderHeader command)
    {
        ((AbstractOrderHeaderCommandDto) this).copyTo(command);
        command.setOrderTypeId(this.getOrderTypeId());
        command.setOrderName(this.getOrderName());
        command.setExternalId(this.getExternalId());
        command.setSalesChannelEnumId(this.getSalesChannelEnumId());
        command.setOrderDate(this.getOrderDate());
        command.setPriority(this.getPriority());
        command.setEntryDate(this.getEntryDate());
        command.setPickSheetPrintedDate(this.getPickSheetPrintedDate());
        command.setCurrencyUom(this.getCurrencyUom());
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
        command.setActive(this.getActive());
    }

    public OrderHeaderCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderHeaderCommand.SimpleCreateOrderHeader command = new AbstractOrderHeaderCommand.SimpleCreateOrderHeader();
            copyTo((AbstractOrderHeaderCommand.AbstractCreateOrderHeader) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderHeaderCommand.SimpleMergePatchOrderHeader command = new AbstractOrderHeaderCommand.SimpleMergePatchOrderHeader();
            copyTo((AbstractOrderHeaderCommand.SimpleMergePatchOrderHeader) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderHeaderCommand.AbstractCreateOrderHeader command)
    {
        copyTo((AbstractOrderHeaderCommand.AbstractCreateOrMergePatchOrderHeader) command);
    }

    public void copyTo(AbstractOrderHeaderCommand.AbstractMergePatchOrderHeader command)
    {
        copyTo((AbstractOrderHeaderCommand.AbstractCreateOrMergePatchOrderHeader) command);
        command.setIsPropertyOrderTypeIdRemoved(this.getIsPropertyOrderTypeIdRemoved());
        command.setIsPropertyOrderNameRemoved(this.getIsPropertyOrderNameRemoved());
        command.setIsPropertyExternalIdRemoved(this.getIsPropertyExternalIdRemoved());
        command.setIsPropertySalesChannelEnumIdRemoved(this.getIsPropertySalesChannelEnumIdRemoved());
        command.setIsPropertyOrderDateRemoved(this.getIsPropertyOrderDateRemoved());
        command.setIsPropertyPriorityRemoved(this.getIsPropertyPriorityRemoved());
        command.setIsPropertyEntryDateRemoved(this.getIsPropertyEntryDateRemoved());
        command.setIsPropertyPickSheetPrintedDateRemoved(this.getIsPropertyPickSheetPrintedDateRemoved());
        command.setIsPropertyCurrencyUomRemoved(this.getIsPropertyCurrencyUomRemoved());
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
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrderHeaderDto extends CreateOrMergePatchOrderHeaderDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderHeaderCommand.CreateOrderHeader toCreateOrderHeader()
        {
            return (OrderHeaderCommand.CreateOrderHeader) toCommand();
        }

    }

    public static class MergePatchOrderHeaderDto extends CreateOrMergePatchOrderHeaderDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderHeaderCommand.MergePatchOrderHeader toMergePatchOrderHeader()
        {
            return (OrderHeaderCommand.MergePatchOrderHeader) toCommand();
        }

    }

}

