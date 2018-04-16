package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderrolemvo.OrderRoleMvoEvent.*;

public abstract class AbstractOrderRoleMvoState implements OrderRoleMvoState
{

    private OrderRoleId orderRoleId;

    public OrderRoleId getOrderRoleId()
    {
        return this.orderRoleId;
    }

    public void setOrderRoleId(OrderRoleId orderRoleId)
    {
        this.orderRoleId = orderRoleId;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    private String orderOrderTypeId;

    public String getOrderOrderTypeId()
    {
        return this.orderOrderTypeId;
    }

    public void setOrderOrderTypeId(String orderOrderTypeId)
    {
        this.orderOrderTypeId = orderOrderTypeId;
    }

    private String orderOrderName;

    public String getOrderOrderName()
    {
        return this.orderOrderName;
    }

    public void setOrderOrderName(String orderOrderName)
    {
        this.orderOrderName = orderOrderName;
    }

    private String orderExternalId;

    public String getOrderExternalId()
    {
        return this.orderExternalId;
    }

    public void setOrderExternalId(String orderExternalId)
    {
        this.orderExternalId = orderExternalId;
    }

    private String orderSalesChannelEnumId;

    public String getOrderSalesChannelEnumId()
    {
        return this.orderSalesChannelEnumId;
    }

    public void setOrderSalesChannelEnumId(String orderSalesChannelEnumId)
    {
        this.orderSalesChannelEnumId = orderSalesChannelEnumId;
    }

    private java.sql.Timestamp orderOrderDate;

    public java.sql.Timestamp getOrderOrderDate()
    {
        return this.orderOrderDate;
    }

    public void setOrderOrderDate(java.sql.Timestamp orderOrderDate)
    {
        this.orderOrderDate = orderOrderDate;
    }

    private String orderPriority;

    public String getOrderPriority()
    {
        return this.orderPriority;
    }

    public void setOrderPriority(String orderPriority)
    {
        this.orderPriority = orderPriority;
    }

    private java.sql.Timestamp orderEntryDate;

    public java.sql.Timestamp getOrderEntryDate()
    {
        return this.orderEntryDate;
    }

    public void setOrderEntryDate(java.sql.Timestamp orderEntryDate)
    {
        this.orderEntryDate = orderEntryDate;
    }

    private java.sql.Timestamp orderPickSheetPrintedDate;

    public java.sql.Timestamp getOrderPickSheetPrintedDate()
    {
        return this.orderPickSheetPrintedDate;
    }

    public void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate)
    {
        this.orderPickSheetPrintedDate = orderPickSheetPrintedDate;
    }

    private String orderStatusId;

    public String getOrderStatusId()
    {
        return this.orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId)
    {
        this.orderStatusId = orderStatusId;
    }

    private String orderCurrencyUom;

    public String getOrderCurrencyUom()
    {
        return this.orderCurrencyUom;
    }

    public void setOrderCurrencyUom(String orderCurrencyUom)
    {
        this.orderCurrencyUom = orderCurrencyUom;
    }

    private String orderSyncStatusId;

    public String getOrderSyncStatusId()
    {
        return this.orderSyncStatusId;
    }

    public void setOrderSyncStatusId(String orderSyncStatusId)
    {
        this.orderSyncStatusId = orderSyncStatusId;
    }

    private String orderBillingAccountId;

    public String getOrderBillingAccountId()
    {
        return this.orderBillingAccountId;
    }

    public void setOrderBillingAccountId(String orderBillingAccountId)
    {
        this.orderBillingAccountId = orderBillingAccountId;
    }

    private String orderOriginFacilityId;

    public String getOrderOriginFacilityId()
    {
        return this.orderOriginFacilityId;
    }

    public void setOrderOriginFacilityId(String orderOriginFacilityId)
    {
        this.orderOriginFacilityId = orderOriginFacilityId;
    }

    private String orderWebSiteId;

    public String getOrderWebSiteId()
    {
        return this.orderWebSiteId;
    }

    public void setOrderWebSiteId(String orderWebSiteId)
    {
        this.orderWebSiteId = orderWebSiteId;
    }

    private String orderProductStoreId;

    public String getOrderProductStoreId()
    {
        return this.orderProductStoreId;
    }

    public void setOrderProductStoreId(String orderProductStoreId)
    {
        this.orderProductStoreId = orderProductStoreId;
    }

    private String orderTerminalId;

    public String getOrderTerminalId()
    {
        return this.orderTerminalId;
    }

    public void setOrderTerminalId(String orderTerminalId)
    {
        this.orderTerminalId = orderTerminalId;
    }

    private String orderTransactionId;

    public String getOrderTransactionId()
    {
        return this.orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId)
    {
        this.orderTransactionId = orderTransactionId;
    }

    private String orderAutoOrderShoppingListId;

    public String getOrderAutoOrderShoppingListId()
    {
        return this.orderAutoOrderShoppingListId;
    }

    public void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId)
    {
        this.orderAutoOrderShoppingListId = orderAutoOrderShoppingListId;
    }

    private String orderNeedsInventoryIssuance;

    public String getOrderNeedsInventoryIssuance()
    {
        return this.orderNeedsInventoryIssuance;
    }

    public void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance)
    {
        this.orderNeedsInventoryIssuance = orderNeedsInventoryIssuance;
    }

    private String orderIsRushOrder;

    public String getOrderIsRushOrder()
    {
        return this.orderIsRushOrder;
    }

    public void setOrderIsRushOrder(String orderIsRushOrder)
    {
        this.orderIsRushOrder = orderIsRushOrder;
    }

    private String orderInternalCode;

    public String getOrderInternalCode()
    {
        return this.orderInternalCode;
    }

    public void setOrderInternalCode(String orderInternalCode)
    {
        this.orderInternalCode = orderInternalCode;
    }

    private java.math.BigDecimal orderRemainingSubTotal;

    public java.math.BigDecimal getOrderRemainingSubTotal()
    {
        return this.orderRemainingSubTotal;
    }

    public void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal)
    {
        this.orderRemainingSubTotal = orderRemainingSubTotal;
    }

    private java.math.BigDecimal orderGrandTotal;

    public java.math.BigDecimal getOrderGrandTotal()
    {
        return this.orderGrandTotal;
    }

    public void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal)
    {
        this.orderGrandTotal = orderGrandTotal;
    }

    private String orderInvoicePerShipment;

    public String getOrderInvoicePerShipment()
    {
        return this.orderInvoicePerShipment;
    }

    public void setOrderInvoicePerShipment(String orderInvoicePerShipment)
    {
        this.orderInvoicePerShipment = orderInvoicePerShipment;
    }

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
    }

    private String orderCreatedBy;

    public String getOrderCreatedBy()
    {
        return this.orderCreatedBy;
    }

    public void setOrderCreatedBy(String orderCreatedBy)
    {
        this.orderCreatedBy = orderCreatedBy;
    }

    private Date orderCreatedAt;

    public Date getOrderCreatedAt()
    {
        return this.orderCreatedAt;
    }

    public void setOrderCreatedAt(Date orderCreatedAt)
    {
        this.orderCreatedAt = orderCreatedAt;
    }

    private String orderUpdatedBy;

    public String getOrderUpdatedBy()
    {
        return this.orderUpdatedBy;
    }

    public void setOrderUpdatedBy(String orderUpdatedBy)
    {
        this.orderUpdatedBy = orderUpdatedBy;
    }

    private Date orderUpdatedAt;

    public Date getOrderUpdatedAt()
    {
        return this.orderUpdatedAt;
    }

    public void setOrderUpdatedAt(Date orderUpdatedAt)
    {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    private Boolean orderActive;

    public Boolean getOrderActive()
    {
        return this.orderActive;
    }

    public void setOrderActive(Boolean orderActive)
    {
        this.orderActive = orderActive;
    }

    public boolean isStateUnsaved() 
    {
        return this.getOrderVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractOrderRoleMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderRoleId(((OrderRoleMvoEvent) events.get(0)).getOrderRoleMvoEventId().getOrderRoleId());
            for (Event e : events) {
                mutate(e);
                this.setOrderVersion(this.getOrderVersion() + 1);
            }
        }
    }


    public AbstractOrderRoleMvoState() {
        this(false);
    }

    public AbstractOrderRoleMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderRoleMvoStateCreated) {
            when((OrderRoleMvoStateCreated) e);
        } else if (e instanceof OrderRoleMvoStateMergePatched) {
            when((OrderRoleMvoStateMergePatched) e);
        } else if (e instanceof OrderRoleMvoStateDeleted) {
            when((OrderRoleMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderRoleMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setOrderOrderTypeId(e.getOrderOrderTypeId());
        this.setOrderOrderName(e.getOrderOrderName());
        this.setOrderExternalId(e.getOrderExternalId());
        this.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        this.setOrderOrderDate(e.getOrderOrderDate());
        this.setOrderPriority(e.getOrderPriority());
        this.setOrderEntryDate(e.getOrderEntryDate());
        this.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        this.setOrderStatusId(e.getOrderStatusId());
        this.setOrderCurrencyUom(e.getOrderCurrencyUom());
        this.setOrderSyncStatusId(e.getOrderSyncStatusId());
        this.setOrderBillingAccountId(e.getOrderBillingAccountId());
        this.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        this.setOrderWebSiteId(e.getOrderWebSiteId());
        this.setOrderProductStoreId(e.getOrderProductStoreId());
        this.setOrderTerminalId(e.getOrderTerminalId());
        this.setOrderTransactionId(e.getOrderTransactionId());
        this.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        this.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        this.setOrderIsRushOrder(e.getOrderIsRushOrder());
        this.setOrderInternalCode(e.getOrderInternalCode());
        this.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        this.setOrderGrandTotal(e.getOrderGrandTotal());
        this.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        this.setOrderCreatedBy(e.getOrderCreatedBy());
        this.setOrderCreatedAt(e.getOrderCreatedAt());
        this.setOrderUpdatedBy(e.getOrderUpdatedBy());
        this.setOrderUpdatedAt(e.getOrderUpdatedAt());
        this.setOrderActive(e.getOrderActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrderRoleMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getOrderOrderTypeId() == null)
        {
            if (e.getIsPropertyOrderOrderTypeIdRemoved() != null && e.getIsPropertyOrderOrderTypeIdRemoved())
            {
                this.setOrderOrderTypeId(null);
            }
        }
        else
        {
            this.setOrderOrderTypeId(e.getOrderOrderTypeId());
        }
        if (e.getOrderOrderName() == null)
        {
            if (e.getIsPropertyOrderOrderNameRemoved() != null && e.getIsPropertyOrderOrderNameRemoved())
            {
                this.setOrderOrderName(null);
            }
        }
        else
        {
            this.setOrderOrderName(e.getOrderOrderName());
        }
        if (e.getOrderExternalId() == null)
        {
            if (e.getIsPropertyOrderExternalIdRemoved() != null && e.getIsPropertyOrderExternalIdRemoved())
            {
                this.setOrderExternalId(null);
            }
        }
        else
        {
            this.setOrderExternalId(e.getOrderExternalId());
        }
        if (e.getOrderSalesChannelEnumId() == null)
        {
            if (e.getIsPropertyOrderSalesChannelEnumIdRemoved() != null && e.getIsPropertyOrderSalesChannelEnumIdRemoved())
            {
                this.setOrderSalesChannelEnumId(null);
            }
        }
        else
        {
            this.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        }
        if (e.getOrderOrderDate() == null)
        {
            if (e.getIsPropertyOrderOrderDateRemoved() != null && e.getIsPropertyOrderOrderDateRemoved())
            {
                this.setOrderOrderDate(null);
            }
        }
        else
        {
            this.setOrderOrderDate(e.getOrderOrderDate());
        }
        if (e.getOrderPriority() == null)
        {
            if (e.getIsPropertyOrderPriorityRemoved() != null && e.getIsPropertyOrderPriorityRemoved())
            {
                this.setOrderPriority(null);
            }
        }
        else
        {
            this.setOrderPriority(e.getOrderPriority());
        }
        if (e.getOrderEntryDate() == null)
        {
            if (e.getIsPropertyOrderEntryDateRemoved() != null && e.getIsPropertyOrderEntryDateRemoved())
            {
                this.setOrderEntryDate(null);
            }
        }
        else
        {
            this.setOrderEntryDate(e.getOrderEntryDate());
        }
        if (e.getOrderPickSheetPrintedDate() == null)
        {
            if (e.getIsPropertyOrderPickSheetPrintedDateRemoved() != null && e.getIsPropertyOrderPickSheetPrintedDateRemoved())
            {
                this.setOrderPickSheetPrintedDate(null);
            }
        }
        else
        {
            this.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        }
        if (e.getOrderStatusId() == null)
        {
            if (e.getIsPropertyOrderStatusIdRemoved() != null && e.getIsPropertyOrderStatusIdRemoved())
            {
                this.setOrderStatusId(null);
            }
        }
        else
        {
            this.setOrderStatusId(e.getOrderStatusId());
        }
        if (e.getOrderCurrencyUom() == null)
        {
            if (e.getIsPropertyOrderCurrencyUomRemoved() != null && e.getIsPropertyOrderCurrencyUomRemoved())
            {
                this.setOrderCurrencyUom(null);
            }
        }
        else
        {
            this.setOrderCurrencyUom(e.getOrderCurrencyUom());
        }
        if (e.getOrderSyncStatusId() == null)
        {
            if (e.getIsPropertyOrderSyncStatusIdRemoved() != null && e.getIsPropertyOrderSyncStatusIdRemoved())
            {
                this.setOrderSyncStatusId(null);
            }
        }
        else
        {
            this.setOrderSyncStatusId(e.getOrderSyncStatusId());
        }
        if (e.getOrderBillingAccountId() == null)
        {
            if (e.getIsPropertyOrderBillingAccountIdRemoved() != null && e.getIsPropertyOrderBillingAccountIdRemoved())
            {
                this.setOrderBillingAccountId(null);
            }
        }
        else
        {
            this.setOrderBillingAccountId(e.getOrderBillingAccountId());
        }
        if (e.getOrderOriginFacilityId() == null)
        {
            if (e.getIsPropertyOrderOriginFacilityIdRemoved() != null && e.getIsPropertyOrderOriginFacilityIdRemoved())
            {
                this.setOrderOriginFacilityId(null);
            }
        }
        else
        {
            this.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        }
        if (e.getOrderWebSiteId() == null)
        {
            if (e.getIsPropertyOrderWebSiteIdRemoved() != null && e.getIsPropertyOrderWebSiteIdRemoved())
            {
                this.setOrderWebSiteId(null);
            }
        }
        else
        {
            this.setOrderWebSiteId(e.getOrderWebSiteId());
        }
        if (e.getOrderProductStoreId() == null)
        {
            if (e.getIsPropertyOrderProductStoreIdRemoved() != null && e.getIsPropertyOrderProductStoreIdRemoved())
            {
                this.setOrderProductStoreId(null);
            }
        }
        else
        {
            this.setOrderProductStoreId(e.getOrderProductStoreId());
        }
        if (e.getOrderTerminalId() == null)
        {
            if (e.getIsPropertyOrderTerminalIdRemoved() != null && e.getIsPropertyOrderTerminalIdRemoved())
            {
                this.setOrderTerminalId(null);
            }
        }
        else
        {
            this.setOrderTerminalId(e.getOrderTerminalId());
        }
        if (e.getOrderTransactionId() == null)
        {
            if (e.getIsPropertyOrderTransactionIdRemoved() != null && e.getIsPropertyOrderTransactionIdRemoved())
            {
                this.setOrderTransactionId(null);
            }
        }
        else
        {
            this.setOrderTransactionId(e.getOrderTransactionId());
        }
        if (e.getOrderAutoOrderShoppingListId() == null)
        {
            if (e.getIsPropertyOrderAutoOrderShoppingListIdRemoved() != null && e.getIsPropertyOrderAutoOrderShoppingListIdRemoved())
            {
                this.setOrderAutoOrderShoppingListId(null);
            }
        }
        else
        {
            this.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        }
        if (e.getOrderNeedsInventoryIssuance() == null)
        {
            if (e.getIsPropertyOrderNeedsInventoryIssuanceRemoved() != null && e.getIsPropertyOrderNeedsInventoryIssuanceRemoved())
            {
                this.setOrderNeedsInventoryIssuance(null);
            }
        }
        else
        {
            this.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        }
        if (e.getOrderIsRushOrder() == null)
        {
            if (e.getIsPropertyOrderIsRushOrderRemoved() != null && e.getIsPropertyOrderIsRushOrderRemoved())
            {
                this.setOrderIsRushOrder(null);
            }
        }
        else
        {
            this.setOrderIsRushOrder(e.getOrderIsRushOrder());
        }
        if (e.getOrderInternalCode() == null)
        {
            if (e.getIsPropertyOrderInternalCodeRemoved() != null && e.getIsPropertyOrderInternalCodeRemoved())
            {
                this.setOrderInternalCode(null);
            }
        }
        else
        {
            this.setOrderInternalCode(e.getOrderInternalCode());
        }
        if (e.getOrderRemainingSubTotal() == null)
        {
            if (e.getIsPropertyOrderRemainingSubTotalRemoved() != null && e.getIsPropertyOrderRemainingSubTotalRemoved())
            {
                this.setOrderRemainingSubTotal(null);
            }
        }
        else
        {
            this.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        }
        if (e.getOrderGrandTotal() == null)
        {
            if (e.getIsPropertyOrderGrandTotalRemoved() != null && e.getIsPropertyOrderGrandTotalRemoved())
            {
                this.setOrderGrandTotal(null);
            }
        }
        else
        {
            this.setOrderGrandTotal(e.getOrderGrandTotal());
        }
        if (e.getOrderInvoicePerShipment() == null)
        {
            if (e.getIsPropertyOrderInvoicePerShipmentRemoved() != null && e.getIsPropertyOrderInvoicePerShipmentRemoved())
            {
                this.setOrderInvoicePerShipment(null);
            }
        }
        else
        {
            this.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        }
        if (e.getOrderCreatedBy() == null)
        {
            if (e.getIsPropertyOrderCreatedByRemoved() != null && e.getIsPropertyOrderCreatedByRemoved())
            {
                this.setOrderCreatedBy(null);
            }
        }
        else
        {
            this.setOrderCreatedBy(e.getOrderCreatedBy());
        }
        if (e.getOrderCreatedAt() == null)
        {
            if (e.getIsPropertyOrderCreatedAtRemoved() != null && e.getIsPropertyOrderCreatedAtRemoved())
            {
                this.setOrderCreatedAt(null);
            }
        }
        else
        {
            this.setOrderCreatedAt(e.getOrderCreatedAt());
        }
        if (e.getOrderUpdatedBy() == null)
        {
            if (e.getIsPropertyOrderUpdatedByRemoved() != null && e.getIsPropertyOrderUpdatedByRemoved())
            {
                this.setOrderUpdatedBy(null);
            }
        }
        else
        {
            this.setOrderUpdatedBy(e.getOrderUpdatedBy());
        }
        if (e.getOrderUpdatedAt() == null)
        {
            if (e.getIsPropertyOrderUpdatedAtRemoved() != null && e.getIsPropertyOrderUpdatedAtRemoved())
            {
                this.setOrderUpdatedAt(null);
            }
        }
        else
        {
            this.setOrderUpdatedAt(e.getOrderUpdatedAt());
        }
        if (e.getOrderActive() == null)
        {
            if (e.getIsPropertyOrderActiveRemoved() != null && e.getIsPropertyOrderActiveRemoved())
            {
                this.setOrderActive(null);
            }
        }
        else
        {
            this.setOrderActive(e.getOrderActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(OrderRoleMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderRoleMvoEvent event)
    {
        OrderRoleId stateEntityId = this.getOrderRoleId(); // Aggregate Id
        OrderRoleId eventEntityId = event.getOrderRoleMvoEventId().getOrderRoleId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getOrderVersion();
        Long eventVersion = event.getOrderRoleMvoEventId().getOrderVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getOrderRoleMvoEventId().getOrderVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderRoleMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderRoleMvoState extends AbstractOrderRoleMvoState
    {

        public SimpleOrderRoleMvoState() {
        }

        public SimpleOrderRoleMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderRoleMvoState(List<Event> events) {
            super(events);
        }

    }


}

