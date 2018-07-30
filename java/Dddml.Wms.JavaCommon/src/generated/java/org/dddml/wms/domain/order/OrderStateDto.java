package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrderStateDto
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    private OrderRoleStateDto[] orderRoles;

    public OrderRoleStateDto[] getOrderRoles()
    {
        return this.orderRoles;
    }	

    public void setOrderRoles(OrderRoleStateDto[] orderRoles)
    {
        this.orderRoles = orderRoles;
    }

    private OrderItemStateDto[] orderItems;

    public OrderItemStateDto[] getOrderItems()
    {
        return this.orderItems;
    }	

    public void setOrderItems(OrderItemStateDto[] orderItems)
    {
        this.orderItems = orderItems;
    }

    private OrderShipGroupStateDto[] orderShipGroups;

    public OrderShipGroupStateDto[] getOrderShipGroups()
    {
        return this.orderShipGroups;
    }	

    public void setOrderShipGroups(OrderShipGroupStateDto[] orderShipGroups)
    {
        this.orderShipGroups = orderShipGroups;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"OrderRoles", "OrderItems", "OrderShipGroups"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public OrderStateDto[] toOrderStateDtoArray(Iterable<OrderState> states) {
            return toOrderStateDtoList(states).toArray(new OrderStateDto[0]);
        }

        public List<OrderStateDto> toOrderStateDtoList(Iterable<OrderState> states) {
            ArrayList<OrderStateDto> stateDtos = new ArrayList();
            for (OrderState s : states) {
                OrderStateDto dto = toOrderStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public OrderStateDto toOrderStateDto(OrderState state)
        {
            if(state == null) {
                return null;
            }
            OrderStateDto dto = new OrderStateDto();
            if (returnedFieldsContains("OrderId")) {
                dto.setOrderId(state.getOrderId());
            }
            if (returnedFieldsContains("OrderTypeId")) {
                dto.setOrderTypeId(state.getOrderTypeId());
            }
            if (returnedFieldsContains("OrderName")) {
                dto.setOrderName(state.getOrderName());
            }
            if (returnedFieldsContains("ExternalId")) {
                dto.setExternalId(state.getExternalId());
            }
            if (returnedFieldsContains("SalesChannelEnumId")) {
                dto.setSalesChannelEnumId(state.getSalesChannelEnumId());
            }
            if (returnedFieldsContains("OrderDate")) {
                dto.setOrderDate(state.getOrderDate());
            }
            if (returnedFieldsContains("Priority")) {
                dto.setPriority(state.getPriority());
            }
            if (returnedFieldsContains("EntryDate")) {
                dto.setEntryDate(state.getEntryDate());
            }
            if (returnedFieldsContains("PickSheetPrintedDate")) {
                dto.setPickSheetPrintedDate(state.getPickSheetPrintedDate());
            }
            if (returnedFieldsContains("StatusId")) {
                dto.setStatusId(state.getStatusId());
            }
            if (returnedFieldsContains("CurrencyUom")) {
                dto.setCurrencyUom(state.getCurrencyUom());
            }
            if (returnedFieldsContains("SyncStatusId")) {
                dto.setSyncStatusId(state.getSyncStatusId());
            }
            if (returnedFieldsContains("BillingAccountId")) {
                dto.setBillingAccountId(state.getBillingAccountId());
            }
            if (returnedFieldsContains("OriginFacilityId")) {
                dto.setOriginFacilityId(state.getOriginFacilityId());
            }
            if (returnedFieldsContains("WebSiteId")) {
                dto.setWebSiteId(state.getWebSiteId());
            }
            if (returnedFieldsContains("ProductStoreId")) {
                dto.setProductStoreId(state.getProductStoreId());
            }
            if (returnedFieldsContains("TerminalId")) {
                dto.setTerminalId(state.getTerminalId());
            }
            if (returnedFieldsContains("TransactionId")) {
                dto.setTransactionId(state.getTransactionId());
            }
            if (returnedFieldsContains("AutoOrderShoppingListId")) {
                dto.setAutoOrderShoppingListId(state.getAutoOrderShoppingListId());
            }
            if (returnedFieldsContains("NeedsInventoryIssuance")) {
                dto.setNeedsInventoryIssuance(state.getNeedsInventoryIssuance());
            }
            if (returnedFieldsContains("IsRushOrder")) {
                dto.setIsRushOrder(state.getIsRushOrder());
            }
            if (returnedFieldsContains("InternalCode")) {
                dto.setInternalCode(state.getInternalCode());
            }
            if (returnedFieldsContains("RemainingSubTotal")) {
                dto.setRemainingSubTotal(state.getRemainingSubTotal());
            }
            if (returnedFieldsContains("GrandTotal")) {
                dto.setGrandTotal(state.getGrandTotal());
            }
            if (returnedFieldsContains("InvoicePerShipment")) {
                dto.setInvoicePerShipment(state.getInvoicePerShipment());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            if (returnedFieldsContains("OrderRoles")) {
                ArrayList<OrderRoleStateDto> arrayList = new ArrayList();
                if (state.getOrderRoles() != null) {
                    OrderRoleStateDto.DtoConverter conv = new OrderRoleStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "OrderRoles");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (OrderRoleState s : state.getOrderRoles()) {
                        arrayList.add(conv.toOrderRoleStateDto(s));
                    }
                }
                dto.setOrderRoles(arrayList.toArray(new OrderRoleStateDto[0]));
            }
            if (returnedFieldsContains("OrderItems")) {
                ArrayList<OrderItemStateDto> arrayList = new ArrayList();
                if (state.getOrderItems() != null) {
                    OrderItemStateDto.DtoConverter conv = new OrderItemStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "OrderItems");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (OrderItemState s : state.getOrderItems()) {
                        arrayList.add(conv.toOrderItemStateDto(s));
                    }
                }
                dto.setOrderItems(arrayList.toArray(new OrderItemStateDto[0]));
            }
            if (returnedFieldsContains("OrderShipGroups")) {
                ArrayList<OrderShipGroupStateDto> arrayList = new ArrayList();
                if (state.getOrderShipGroups() != null) {
                    OrderShipGroupStateDto.DtoConverter conv = new OrderShipGroupStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "OrderShipGroups");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (OrderShipGroupState s : state.getOrderShipGroups()) {
                        arrayList.add(conv.toOrderShipGroupStateDto(s));
                    }
                }
                dto.setOrderShipGroups(arrayList.toArray(new OrderShipGroupStateDto[0]));
            }
            return dto;
        }

    }
}

