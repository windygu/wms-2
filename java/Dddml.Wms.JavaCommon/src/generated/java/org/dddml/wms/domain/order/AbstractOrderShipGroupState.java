package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.order.OrderShipGroupEvent.*;

public abstract class AbstractOrderShipGroupState implements OrderShipGroupState, Saveable
{

    private OrderShipGroupId orderShipGroupId = new OrderShipGroupId();

    public OrderShipGroupId getOrderShipGroupId() {
        return this.orderShipGroupId;
    }

    public void setOrderShipGroupId(OrderShipGroupId orderShipGroupId) {
        this.orderShipGroupId = orderShipGroupId;
    }

    public String getOrderId() {
        return this.getOrderShipGroupId().getOrderId();
    }
        
    public void setOrderId(String orderId) {
        this.getOrderShipGroupId().setOrderId(orderId);
    }

    public String getShipGroupSeqId() {
        return this.getOrderShipGroupId().getShipGroupSeqId();
    }
        
    public void setShipGroupSeqId(String shipGroupSeqId) {
        this.getOrderShipGroupId().setShipGroupSeqId(shipGroupSeqId);
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

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    private String contactPartyId;

    public String getContactPartyId()
    {
        return this.contactPartyId;
    }

    public void setContactPartyId(String contactPartyId)
    {
        this.contactPartyId = contactPartyId;
    }

    private String vehiclePlateNumber;

    public String getVehiclePlateNumber()
    {
        return this.vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber)
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    private String shippingInstructions;

    public String getShippingInstructions()
    {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions)
    {
        this.shippingInstructions = shippingInstructions;
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

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private Long pickwaveId;

    public Long getPickwaveId()
    {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId)
    {
        this.pickwaveId = pickwaveId;
    }

    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    private Integer numberOfContainers;

    public Integer getNumberOfContainers()
    {
        return this.numberOfContainers;
    }

    public void setNumberOfContainers(Integer numberOfContainers)
    {
        this.numberOfContainers = numberOfContainers;
    }

    private Integer numberOfPakagesPerContainer;

    public Integer getNumberOfPakagesPerContainer()
    {
        return this.numberOfPakagesPerContainer;
    }

    public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
    {
        this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
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

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private OrderItemShipGroupAssociationStates orderItemShipGroupAssociations;

    public OrderItemShipGroupAssociationStates getOrderItemShipGroupAssociations()
    {
        return this.orderItemShipGroupAssociations;
    }

    public void setOrderItemShipGroupAssociations(OrderItemShipGroupAssociationStates orderItemShipGroupAssociations)
    {
        this.orderItemShipGroupAssociations = orderItemShipGroupAssociations;
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


    public AbstractOrderShipGroupState() {
        this(false);
    }

    public AbstractOrderShipGroupState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        orderItemShipGroupAssociations = new SimpleOrderItemShipGroupAssociationStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderShipGroupStateCreated) {
            when((OrderShipGroupStateCreated) e);
        } else if (e instanceof OrderShipGroupStateMergePatched) {
            when((OrderShipGroupStateMergePatched) e);
        } else if (e instanceof OrderShipGroupStateRemoved) {
            when((OrderShipGroupStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderShipGroupStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        this.setSupplierPartyId(e.getSupplierPartyId());
        this.setVendorPartyId(e.getVendorPartyId());
        this.setCarrierPartyId(e.getCarrierPartyId());
        this.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        this.setFacilityId(e.getFacilityId());
        this.setContactMechId(e.getContactMechId());
        this.setTelecomContactMechId(e.getTelecomContactMechId());
        this.setTrackingNumber(e.getTrackingNumber());
        this.setContactPartyId(e.getContactPartyId());
        this.setVehiclePlateNumber(e.getVehiclePlateNumber());
        this.setShippingInstructions(e.getShippingInstructions());
        this.setMaySplit(e.getMaySplit());
        this.setGiftMessage(e.getGiftMessage());
        this.setIsGift(e.getIsGift());
        this.setShipAfterDate(e.getShipAfterDate());
        this.setShipByDate(e.getShipByDate());
        this.setEstimatedShipDate(e.getEstimatedShipDate());
        this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        this.setPickwaveId(e.getPickwaveId());
        this.setNumberOfPackages(e.getNumberOfPackages());
        this.setNumberOfContainers(e.getNumberOfContainers());
        this.setNumberOfPakagesPerContainer(e.getNumberOfPakagesPerContainer());
        this.setOrderShipGroupStatusId(e.getOrderShipGroupStatusId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated innerEvent : e.getOrderItemShipGroupAssociationEvents()) {
            OrderItemShipGroupAssociationState innerState = this.getOrderItemShipGroupAssociations().get(innerEvent.getOrderItemShipGroupAssociationEventId().getOrderItemSeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(OrderShipGroupStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getShipmentMethodTypeId() == null)
        {
            if (e.getIsPropertyShipmentMethodTypeIdRemoved() != null && e.getIsPropertyShipmentMethodTypeIdRemoved())
            {
                this.setShipmentMethodTypeId(null);
            }
        }
        else
        {
            this.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        }
        if (e.getSupplierPartyId() == null)
        {
            if (e.getIsPropertySupplierPartyIdRemoved() != null && e.getIsPropertySupplierPartyIdRemoved())
            {
                this.setSupplierPartyId(null);
            }
        }
        else
        {
            this.setSupplierPartyId(e.getSupplierPartyId());
        }
        if (e.getVendorPartyId() == null)
        {
            if (e.getIsPropertyVendorPartyIdRemoved() != null && e.getIsPropertyVendorPartyIdRemoved())
            {
                this.setVendorPartyId(null);
            }
        }
        else
        {
            this.setVendorPartyId(e.getVendorPartyId());
        }
        if (e.getCarrierPartyId() == null)
        {
            if (e.getIsPropertyCarrierPartyIdRemoved() != null && e.getIsPropertyCarrierPartyIdRemoved())
            {
                this.setCarrierPartyId(null);
            }
        }
        else
        {
            this.setCarrierPartyId(e.getCarrierPartyId());
        }
        if (e.getCarrierRoleTypeId() == null)
        {
            if (e.getIsPropertyCarrierRoleTypeIdRemoved() != null && e.getIsPropertyCarrierRoleTypeIdRemoved())
            {
                this.setCarrierRoleTypeId(null);
            }
        }
        else
        {
            this.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        }
        if (e.getFacilityId() == null)
        {
            if (e.getIsPropertyFacilityIdRemoved() != null && e.getIsPropertyFacilityIdRemoved())
            {
                this.setFacilityId(null);
            }
        }
        else
        {
            this.setFacilityId(e.getFacilityId());
        }
        if (e.getContactMechId() == null)
        {
            if (e.getIsPropertyContactMechIdRemoved() != null && e.getIsPropertyContactMechIdRemoved())
            {
                this.setContactMechId(null);
            }
        }
        else
        {
            this.setContactMechId(e.getContactMechId());
        }
        if (e.getTelecomContactMechId() == null)
        {
            if (e.getIsPropertyTelecomContactMechIdRemoved() != null && e.getIsPropertyTelecomContactMechIdRemoved())
            {
                this.setTelecomContactMechId(null);
            }
        }
        else
        {
            this.setTelecomContactMechId(e.getTelecomContactMechId());
        }
        if (e.getTrackingNumber() == null)
        {
            if (e.getIsPropertyTrackingNumberRemoved() != null && e.getIsPropertyTrackingNumberRemoved())
            {
                this.setTrackingNumber(null);
            }
        }
        else
        {
            this.setTrackingNumber(e.getTrackingNumber());
        }
        if (e.getContactPartyId() == null)
        {
            if (e.getIsPropertyContactPartyIdRemoved() != null && e.getIsPropertyContactPartyIdRemoved())
            {
                this.setContactPartyId(null);
            }
        }
        else
        {
            this.setContactPartyId(e.getContactPartyId());
        }
        if (e.getVehiclePlateNumber() == null)
        {
            if (e.getIsPropertyVehiclePlateNumberRemoved() != null && e.getIsPropertyVehiclePlateNumberRemoved())
            {
                this.setVehiclePlateNumber(null);
            }
        }
        else
        {
            this.setVehiclePlateNumber(e.getVehiclePlateNumber());
        }
        if (e.getShippingInstructions() == null)
        {
            if (e.getIsPropertyShippingInstructionsRemoved() != null && e.getIsPropertyShippingInstructionsRemoved())
            {
                this.setShippingInstructions(null);
            }
        }
        else
        {
            this.setShippingInstructions(e.getShippingInstructions());
        }
        if (e.getMaySplit() == null)
        {
            if (e.getIsPropertyMaySplitRemoved() != null && e.getIsPropertyMaySplitRemoved())
            {
                this.setMaySplit(null);
            }
        }
        else
        {
            this.setMaySplit(e.getMaySplit());
        }
        if (e.getGiftMessage() == null)
        {
            if (e.getIsPropertyGiftMessageRemoved() != null && e.getIsPropertyGiftMessageRemoved())
            {
                this.setGiftMessage(null);
            }
        }
        else
        {
            this.setGiftMessage(e.getGiftMessage());
        }
        if (e.getIsGift() == null)
        {
            if (e.getIsPropertyIsGiftRemoved() != null && e.getIsPropertyIsGiftRemoved())
            {
                this.setIsGift(null);
            }
        }
        else
        {
            this.setIsGift(e.getIsGift());
        }
        if (e.getShipAfterDate() == null)
        {
            if (e.getIsPropertyShipAfterDateRemoved() != null && e.getIsPropertyShipAfterDateRemoved())
            {
                this.setShipAfterDate(null);
            }
        }
        else
        {
            this.setShipAfterDate(e.getShipAfterDate());
        }
        if (e.getShipByDate() == null)
        {
            if (e.getIsPropertyShipByDateRemoved() != null && e.getIsPropertyShipByDateRemoved())
            {
                this.setShipByDate(null);
            }
        }
        else
        {
            this.setShipByDate(e.getShipByDate());
        }
        if (e.getEstimatedShipDate() == null)
        {
            if (e.getIsPropertyEstimatedShipDateRemoved() != null && e.getIsPropertyEstimatedShipDateRemoved())
            {
                this.setEstimatedShipDate(null);
            }
        }
        else
        {
            this.setEstimatedShipDate(e.getEstimatedShipDate());
        }
        if (e.getEstimatedDeliveryDate() == null)
        {
            if (e.getIsPropertyEstimatedDeliveryDateRemoved() != null && e.getIsPropertyEstimatedDeliveryDateRemoved())
            {
                this.setEstimatedDeliveryDate(null);
            }
        }
        else
        {
            this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        }
        if (e.getPickwaveId() == null)
        {
            if (e.getIsPropertyPickwaveIdRemoved() != null && e.getIsPropertyPickwaveIdRemoved())
            {
                this.setPickwaveId(null);
            }
        }
        else
        {
            this.setPickwaveId(e.getPickwaveId());
        }
        if (e.getNumberOfPackages() == null)
        {
            if (e.getIsPropertyNumberOfPackagesRemoved() != null && e.getIsPropertyNumberOfPackagesRemoved())
            {
                this.setNumberOfPackages(null);
            }
        }
        else
        {
            this.setNumberOfPackages(e.getNumberOfPackages());
        }
        if (e.getNumberOfContainers() == null)
        {
            if (e.getIsPropertyNumberOfContainersRemoved() != null && e.getIsPropertyNumberOfContainersRemoved())
            {
                this.setNumberOfContainers(null);
            }
        }
        else
        {
            this.setNumberOfContainers(e.getNumberOfContainers());
        }
        if (e.getNumberOfPakagesPerContainer() == null)
        {
            if (e.getIsPropertyNumberOfPakagesPerContainerRemoved() != null && e.getIsPropertyNumberOfPakagesPerContainerRemoved())
            {
                this.setNumberOfPakagesPerContainer(null);
            }
        }
        else
        {
            this.setNumberOfPakagesPerContainer(e.getNumberOfPakagesPerContainer());
        }
        if (e.getOrderShipGroupStatusId() == null)
        {
            if (e.getIsPropertyOrderShipGroupStatusIdRemoved() != null && e.getIsPropertyOrderShipGroupStatusIdRemoved())
            {
                this.setOrderShipGroupStatusId(null);
            }
        }
        else
        {
            this.setOrderShipGroupStatusId(e.getOrderShipGroupStatusId());
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

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (OrderItemShipGroupAssociationEvent innerEvent : e.getOrderItemShipGroupAssociationEvents()) {
            OrderItemShipGroupAssociationState innerState = this.getOrderItemShipGroupAssociations().get(innerEvent.getOrderItemShipGroupAssociationEventId().getOrderItemSeqId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved)
            {
                //OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved removed = (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved)innerEvent;
                this.getOrderItemShipGroupAssociations().remove(innerState);
            }
        }
    }

    public void when(OrderShipGroupStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (OrderItemShipGroupAssociationState innerState : this.getOrderItemShipGroupAssociations())
        {
            this.getOrderItemShipGroupAssociations().remove(innerState);
        
            OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved innerE = e.newOrderItemShipGroupAssociationStateRemoved(innerState.getOrderItemSeqId());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addOrderItemShipGroupAssociationEvent(innerE);
        }
    }

    public void save()
    {
        orderItemShipGroupAssociations.save();

    }

    protected void throwOnWrongEvent(OrderShipGroupEvent event)
    {
        String stateEntityIdOrderId = this.getOrderShipGroupId().getOrderId();
        String eventEntityIdOrderId = event.getOrderShipGroupEventId().getOrderId();
        if (!stateEntityIdOrderId.equals(eventEntityIdOrderId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id OrderId %1$s in state but entity id OrderId %2$s in event", stateEntityIdOrderId, eventEntityIdOrderId);
        }

        String stateEntityIdShipGroupSeqId = this.getOrderShipGroupId().getShipGroupSeqId();
        String eventEntityIdShipGroupSeqId = event.getOrderShipGroupEventId().getShipGroupSeqId();
        if (!stateEntityIdShipGroupSeqId.equals(eventEntityIdShipGroupSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipGroupSeqId %1$s in state but entity id ShipGroupSeqId %2$s in event", stateEntityIdShipGroupSeqId, eventEntityIdShipGroupSeqId);
        }

        if (getForReapplying()) { return; }

        OrderShipGroupStateEvent stateEvent = event instanceof OrderShipGroupStateEvent ? (OrderShipGroupStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? OrderShipGroupState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(OrderShipGroupState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleOrderShipGroupState extends AbstractOrderShipGroupState
    {

        public SimpleOrderShipGroupState() {
        }

        public SimpleOrderShipGroupState(boolean forReapplying) {
            super(forReapplying);
        }

    }

    static class SimpleOrderItemShipGroupAssociationStates extends AbstractOrderItemShipGroupAssociationStates
    {
        public SimpleOrderItemShipGroupAssociationStates(AbstractOrderShipGroupState outerState)
        {
            super(outerState);
        }
    }


}

