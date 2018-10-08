package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderShipGroupEvent extends AbstractEvent implements OrderShipGroupEvent.SqlOrderShipGroupEvent 
{
    private OrderShipGroupEventId orderShipGroupEventId;

    public OrderShipGroupEventId getOrderShipGroupEventId() {
        return this.orderShipGroupEventId;
    }

    public void setOrderShipGroupEventId(OrderShipGroupEventId eventId) {
        this.orderShipGroupEventId = eventId;
    }
    
    public String getShipGroupSeqId() {
        return getOrderShipGroupEventId().getShipGroupSeqId();
    }

    public void setShipGroupSeqId(String shipGroupSeqId) {
        getOrderShipGroupEventId().setShipGroupSeqId(shipGroupSeqId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderShipGroupEvent() {
    }

    protected AbstractOrderShipGroupEvent(OrderShipGroupEventId eventId) {
        this.orderShipGroupEventId = eventId;
    }

    protected OrderItemShipGroupAssociationEventDao getOrderItemShipGroupAssociationEventDao() {
        return (OrderItemShipGroupAssociationEventDao)ApplicationContext.current.get("OrderItemShipGroupAssociationEventDao");
    }

    protected OrderItemShipGroupAssociationEventId newOrderItemShipGroupAssociationEventId(String orderItemSeqId)
    {
        OrderItemShipGroupAssociationEventId eventId = new OrderItemShipGroupAssociationEventId(this.getOrderShipGroupEventId().getOrderId(), this.getOrderShipGroupEventId().getShipGroupSeqId(), 
            orderItemSeqId, 
            this.getOrderShipGroupEventId().getOrderVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(OrderShipGroupEvent.SqlOrderShipGroupEvent oe, OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent e)
    {
        if (!oe.getOrderShipGroupEventId().getOrderId().equals(e.getOrderItemShipGroupAssociationEventId().getOrderId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id OrderId %1$s but inner id OrderId %2$s", 
                oe.getOrderShipGroupEventId().getOrderId(), e.getOrderItemShipGroupAssociationEventId().getOrderId());
        }
        if (!oe.getOrderShipGroupEventId().getShipGroupSeqId().equals(e.getOrderItemShipGroupAssociationEventId().getOrderShipGroupShipGroupSeqId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id ShipGroupSeqId %1$s but inner id OrderShipGroupShipGroupSeqId %2$s", 
                oe.getOrderShipGroupEventId().getShipGroupSeqId(), e.getOrderItemShipGroupAssociationEventId().getOrderShipGroupShipGroupSeqId());
        }
    }

    public OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(String orderItemSeqId) {
        return new AbstractOrderItemShipGroupAssociationEvent.SimpleOrderItemShipGroupAssociationStateCreated(newOrderItemShipGroupAssociationEventId(orderItemSeqId));
    }

    public OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched newOrderItemShipGroupAssociationStateMergePatched(String orderItemSeqId) {
        return new AbstractOrderItemShipGroupAssociationEvent.SimpleOrderItemShipGroupAssociationStateMergePatched(newOrderItemShipGroupAssociationEventId(orderItemSeqId));
    }

    public OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(String orderItemSeqId) {
        return new AbstractOrderItemShipGroupAssociationEvent.SimpleOrderItemShipGroupAssociationStateRemoved(newOrderItemShipGroupAssociationEventId(orderItemSeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderShipGroupStateEvent extends AbstractOrderShipGroupEvent implements OrderShipGroupEvent.OrderShipGroupStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String shipmentMethodTypeId;

        public String getShipmentMethodTypeId()
        {
            return this.shipmentMethodTypeId;
        }

        public void setShipmentMethodTypeId(String shipmentMethodTypeId)
        {
            this.shipmentMethodTypeId = shipmentMethodTypeId;
        }

        private String supplierPartyId;

        public String getSupplierPartyId()
        {
            return this.supplierPartyId;
        }

        public void setSupplierPartyId(String supplierPartyId)
        {
            this.supplierPartyId = supplierPartyId;
        }

        private String vendorPartyId;

        public String getVendorPartyId()
        {
            return this.vendorPartyId;
        }

        public void setVendorPartyId(String vendorPartyId)
        {
            this.vendorPartyId = vendorPartyId;
        }

        private String carrierPartyId;

        public String getCarrierPartyId()
        {
            return this.carrierPartyId;
        }

        public void setCarrierPartyId(String carrierPartyId)
        {
            this.carrierPartyId = carrierPartyId;
        }

        private String carrierRoleTypeId;

        public String getCarrierRoleTypeId()
        {
            return this.carrierRoleTypeId;
        }

        public void setCarrierRoleTypeId(String carrierRoleTypeId)
        {
            this.carrierRoleTypeId = carrierRoleTypeId;
        }

        private String facilityId;

        public String getFacilityId()
        {
            return this.facilityId;
        }

        public void setFacilityId(String facilityId)
        {
            this.facilityId = facilityId;
        }

        private String contactMechId;

        public String getContactMechId()
        {
            return this.contactMechId;
        }

        public void setContactMechId(String contactMechId)
        {
            this.contactMechId = contactMechId;
        }

        private String telecomContactMechId;

        public String getTelecomContactMechId()
        {
            return this.telecomContactMechId;
        }

        public void setTelecomContactMechId(String telecomContactMechId)
        {
            this.telecomContactMechId = telecomContactMechId;
        }

        private String maySplit;

        public String getMaySplit()
        {
            return this.maySplit;
        }

        public void setMaySplit(String maySplit)
        {
            this.maySplit = maySplit;
        }

        private String giftMessage;

        public String getGiftMessage()
        {
            return this.giftMessage;
        }

        public void setGiftMessage(String giftMessage)
        {
            this.giftMessage = giftMessage;
        }

        private String isGift;

        public String getIsGift()
        {
            return this.isGift;
        }

        public void setIsGift(String isGift)
        {
            this.isGift = isGift;
        }

        private java.sql.Timestamp shipAfterDate;

        public java.sql.Timestamp getShipAfterDate()
        {
            return this.shipAfterDate;
        }

        public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
        {
            this.shipAfterDate = shipAfterDate;
        }

        private java.sql.Timestamp shipByDate;

        public java.sql.Timestamp getShipByDate()
        {
            return this.shipByDate;
        }

        public void setShipByDate(java.sql.Timestamp shipByDate)
        {
            this.shipByDate = shipByDate;
        }

        private String orderShipGroupStatusId;

        public String getOrderShipGroupStatusId()
        {
            return this.orderShipGroupStatusId;
        }

        public void setOrderShipGroupStatusId(String orderShipGroupStatusId)
        {
            this.orderShipGroupStatusId = orderShipGroupStatusId;
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

        protected AbstractOrderShipGroupStateEvent(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderShipGroupStateCreated extends AbstractOrderShipGroupStateEvent implements OrderShipGroupEvent.OrderShipGroupStateCreated, Saveable
    {
        public AbstractOrderShipGroupStateCreated() {
            this(new OrderShipGroupEventId());
        }

        public AbstractOrderShipGroupStateCreated(OrderShipGroupEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<OrderItemShipGroupAssociationEventId, OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated> orderItemShipGroupAssociationEvents = new HashMap<OrderItemShipGroupAssociationEventId, OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated>();
        
        private Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated> readOnlyOrderItemShipGroupAssociationEvents;

        public Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated> getOrderItemShipGroupAssociationEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderItemShipGroupAssociationEvents.values();
            }
            else
            {
                if (readOnlyOrderItemShipGroupAssociationEvents != null) { return readOnlyOrderItemShipGroupAssociationEvents; }
                OrderItemShipGroupAssociationEventDao eventDao = getOrderItemShipGroupAssociationEventDao();
                List<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated> eL = new ArrayList<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated>();
                for (OrderItemShipGroupAssociationEvent e : eventDao.findByOrderShipGroupEventId(this.getOrderShipGroupEventId()))
                {
                    ((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e).setEventReadOnly(true);
                    eL.add((OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated)e);
                }
                return (readOnlyOrderItemShipGroupAssociationEvents = eL);
            }
        }

        public void setOrderItemShipGroupAssociationEvents(Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated> es)
        {
            if (es != null)
            {
                for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e : es)
                {
                    addOrderItemShipGroupAssociationEvent(e);
                }
            }
            else { this.orderItemShipGroupAssociationEvents.clear(); }
        }
        
        public void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e)
        {
            throwOnInconsistentEventIds((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e);
            this.orderItemShipGroupAssociationEvents.put(((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e).getOrderItemShipGroupAssociationEventId(), e);
        }

        public void save()
        {
            for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e : this.getOrderItemShipGroupAssociationEvents()) {
                getOrderItemShipGroupAssociationEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractOrderShipGroupStateMergePatched extends AbstractOrderShipGroupStateEvent implements OrderShipGroupEvent.OrderShipGroupStateMergePatched, Saveable
    {
        public AbstractOrderShipGroupStateMergePatched() {
            this(new OrderShipGroupEventId());
        }

        public AbstractOrderShipGroupStateMergePatched(OrderShipGroupEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyShipmentMethodTypeIdRemoved() {
            return this.isPropertyShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed) {
            this.isPropertyShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertySupplierPartyIdRemoved;

        public Boolean getIsPropertySupplierPartyIdRemoved() {
            return this.isPropertySupplierPartyIdRemoved;
        }

        public void setIsPropertySupplierPartyIdRemoved(Boolean removed) {
            this.isPropertySupplierPartyIdRemoved = removed;
        }

        private Boolean isPropertyVendorPartyIdRemoved;

        public Boolean getIsPropertyVendorPartyIdRemoved() {
            return this.isPropertyVendorPartyIdRemoved;
        }

        public void setIsPropertyVendorPartyIdRemoved(Boolean removed) {
            this.isPropertyVendorPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierPartyIdRemoved;

        public Boolean getIsPropertyCarrierPartyIdRemoved() {
            return this.isPropertyCarrierPartyIdRemoved;
        }

        public void setIsPropertyCarrierPartyIdRemoved(Boolean removed) {
            this.isPropertyCarrierPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierRoleTypeIdRemoved;

        public Boolean getIsPropertyCarrierRoleTypeIdRemoved() {
            return this.isPropertyCarrierRoleTypeIdRemoved;
        }

        public void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed) {
            this.isPropertyCarrierRoleTypeIdRemoved = removed;
        }

        private Boolean isPropertyFacilityIdRemoved;

        public Boolean getIsPropertyFacilityIdRemoved() {
            return this.isPropertyFacilityIdRemoved;
        }

        public void setIsPropertyFacilityIdRemoved(Boolean removed) {
            this.isPropertyFacilityIdRemoved = removed;
        }

        private Boolean isPropertyContactMechIdRemoved;

        public Boolean getIsPropertyContactMechIdRemoved() {
            return this.isPropertyContactMechIdRemoved;
        }

        public void setIsPropertyContactMechIdRemoved(Boolean removed) {
            this.isPropertyContactMechIdRemoved = removed;
        }

        private Boolean isPropertyTelecomContactMechIdRemoved;

        public Boolean getIsPropertyTelecomContactMechIdRemoved() {
            return this.isPropertyTelecomContactMechIdRemoved;
        }

        public void setIsPropertyTelecomContactMechIdRemoved(Boolean removed) {
            this.isPropertyTelecomContactMechIdRemoved = removed;
        }

        private Boolean isPropertyMaySplitRemoved;

        public Boolean getIsPropertyMaySplitRemoved() {
            return this.isPropertyMaySplitRemoved;
        }

        public void setIsPropertyMaySplitRemoved(Boolean removed) {
            this.isPropertyMaySplitRemoved = removed;
        }

        private Boolean isPropertyGiftMessageRemoved;

        public Boolean getIsPropertyGiftMessageRemoved() {
            return this.isPropertyGiftMessageRemoved;
        }

        public void setIsPropertyGiftMessageRemoved(Boolean removed) {
            this.isPropertyGiftMessageRemoved = removed;
        }

        private Boolean isPropertyIsGiftRemoved;

        public Boolean getIsPropertyIsGiftRemoved() {
            return this.isPropertyIsGiftRemoved;
        }

        public void setIsPropertyIsGiftRemoved(Boolean removed) {
            this.isPropertyIsGiftRemoved = removed;
        }

        private Boolean isPropertyShipAfterDateRemoved;

        public Boolean getIsPropertyShipAfterDateRemoved() {
            return this.isPropertyShipAfterDateRemoved;
        }

        public void setIsPropertyShipAfterDateRemoved(Boolean removed) {
            this.isPropertyShipAfterDateRemoved = removed;
        }

        private Boolean isPropertyShipByDateRemoved;

        public Boolean getIsPropertyShipByDateRemoved() {
            return this.isPropertyShipByDateRemoved;
        }

        public void setIsPropertyShipByDateRemoved(Boolean removed) {
            this.isPropertyShipByDateRemoved = removed;
        }

        private Boolean isPropertyOrderShipGroupStatusIdRemoved;

        public Boolean getIsPropertyOrderShipGroupStatusIdRemoved() {
            return this.isPropertyOrderShipGroupStatusIdRemoved;
        }

        public void setIsPropertyOrderShipGroupStatusIdRemoved(Boolean removed) {
            this.isPropertyOrderShipGroupStatusIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<OrderItemShipGroupAssociationEventId, OrderItemShipGroupAssociationEvent> orderItemShipGroupAssociationEvents = new HashMap<OrderItemShipGroupAssociationEventId, OrderItemShipGroupAssociationEvent>();
        
        private Iterable<OrderItemShipGroupAssociationEvent> readOnlyOrderItemShipGroupAssociationEvents;

        public Iterable<OrderItemShipGroupAssociationEvent> getOrderItemShipGroupAssociationEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderItemShipGroupAssociationEvents.values();
            }
            else
            {
                if (readOnlyOrderItemShipGroupAssociationEvents != null) { return readOnlyOrderItemShipGroupAssociationEvents; }
                OrderItemShipGroupAssociationEventDao eventDao = getOrderItemShipGroupAssociationEventDao();
                List<OrderItemShipGroupAssociationEvent> eL = new ArrayList<OrderItemShipGroupAssociationEvent>();
                for (OrderItemShipGroupAssociationEvent e : eventDao.findByOrderShipGroupEventId(this.getOrderShipGroupEventId()))
                {
                    ((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e).setEventReadOnly(true);
                    eL.add((OrderItemShipGroupAssociationEvent)e);
                }
                return (readOnlyOrderItemShipGroupAssociationEvents = eL);
            }
        }

        public void setOrderItemShipGroupAssociationEvents(Iterable<OrderItemShipGroupAssociationEvent> es)
        {
            if (es != null)
            {
                for (OrderItemShipGroupAssociationEvent e : es)
                {
                    addOrderItemShipGroupAssociationEvent(e);
                }
            }
            else { this.orderItemShipGroupAssociationEvents.clear(); }
        }
        
        public void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEvent e)
        {
            throwOnInconsistentEventIds((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e);
            this.orderItemShipGroupAssociationEvents.put(((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e).getOrderItemShipGroupAssociationEventId(), e);
        }

        public void save()
        {
            for (OrderItemShipGroupAssociationEvent e : this.getOrderItemShipGroupAssociationEvents()) {
                getOrderItemShipGroupAssociationEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractOrderShipGroupStateRemoved extends AbstractOrderShipGroupStateEvent implements OrderShipGroupEvent.OrderShipGroupStateRemoved, Saveable
    {
        public AbstractOrderShipGroupStateRemoved() {
            this(new OrderShipGroupEventId());
        }

        public AbstractOrderShipGroupStateRemoved(OrderShipGroupEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

		
        private Map<OrderItemShipGroupAssociationEventId, OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved> orderItemShipGroupAssociationEvents = new HashMap<OrderItemShipGroupAssociationEventId, OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved>();
        
        private Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved> readOnlyOrderItemShipGroupAssociationEvents;

        public Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved> getOrderItemShipGroupAssociationEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderItemShipGroupAssociationEvents.values();
            }
            else
            {
                if (readOnlyOrderItemShipGroupAssociationEvents != null) { return readOnlyOrderItemShipGroupAssociationEvents; }
                OrderItemShipGroupAssociationEventDao eventDao = getOrderItemShipGroupAssociationEventDao();
                List<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved> eL = new ArrayList<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved>();
                for (OrderItemShipGroupAssociationEvent e : eventDao.findByOrderShipGroupEventId(this.getOrderShipGroupEventId()))
                {
                    ((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e).setEventReadOnly(true);
                    eL.add((OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved)e);
                }
                return (readOnlyOrderItemShipGroupAssociationEvents = eL);
            }
        }

        public void setOrderItemShipGroupAssociationEvents(Iterable<OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved> es)
        {
            if (es != null)
            {
                for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e : es)
                {
                    addOrderItemShipGroupAssociationEvent(e);
                }
            }
            else { this.orderItemShipGroupAssociationEvents.clear(); }
        }
        
        public void addOrderItemShipGroupAssociationEvent(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e)
        {
            throwOnInconsistentEventIds((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e);
            this.orderItemShipGroupAssociationEvents.put(((OrderItemShipGroupAssociationEvent.SqlOrderItemShipGroupAssociationEvent)e).getOrderItemShipGroupAssociationEventId(), e);
        }

        public void save()
        {
            for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e : this.getOrderItemShipGroupAssociationEvents()) {
                getOrderItemShipGroupAssociationEventDao().save(e);
            }
        }
    }
    public static class SimpleOrderShipGroupStateCreated extends AbstractOrderShipGroupStateCreated
    {
        public SimpleOrderShipGroupStateCreated() {
        }

        public SimpleOrderShipGroupStateCreated(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipGroupStateMergePatched extends AbstractOrderShipGroupStateMergePatched
    {
        public SimpleOrderShipGroupStateMergePatched() {
        }

        public SimpleOrderShipGroupStateMergePatched(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipGroupStateRemoved extends AbstractOrderShipGroupStateRemoved
    {
        public SimpleOrderShipGroupStateRemoved() {
        }

        public SimpleOrderShipGroupStateRemoved(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

}

