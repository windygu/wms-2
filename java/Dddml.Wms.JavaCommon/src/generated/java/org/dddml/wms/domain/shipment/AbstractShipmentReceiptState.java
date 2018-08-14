package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ShipmentReceiptEvent.*;

public abstract class AbstractShipmentReceiptState implements ShipmentReceiptState, Saveable
{

    private ShipmentReceiptId shipmentReceiptId = new ShipmentReceiptId();

    public ShipmentReceiptId getShipmentReceiptId() {
        return this.shipmentReceiptId;
    }

    public void setShipmentReceiptId(ShipmentReceiptId shipmentReceiptId) {
        this.shipmentReceiptId = shipmentReceiptId;
    }

    public String getShipmentId() {
        return this.getShipmentReceiptId().getShipmentId();
    }
        
    public void setShipmentId(String shipmentId) {
        this.getShipmentReceiptId().setShipmentId(shipmentId);
    }

    public String getReceiptSeqId() {
        return this.getShipmentReceiptId().getReceiptSeqId();
    }
        
    public void setReceiptSeqId(String receiptSeqId) {
        this.getShipmentReceiptId().setReceiptSeqId(receiptSeqId);
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String shipmentPackageSeqId;

    public String getShipmentPackageSeqId()
    {
        return this.shipmentPackageSeqId;
    }

    public void setShipmentPackageSeqId(String shipmentPackageSeqId)
    {
        this.shipmentPackageSeqId = shipmentPackageSeqId;
    }

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderItemSeqId;

    public String getOrderItemSeqId()
    {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.orderItemSeqId = orderItemSeqId;
    }

    private String returnId;

    public String getReturnId()
    {
        return this.returnId;
    }

    public void setReturnId(String returnId)
    {
        this.returnId = returnId;
    }

    private String returnItemSeqId;

    public String getReturnItemSeqId()
    {
        return this.returnItemSeqId;
    }

    public void setReturnItemSeqId(String returnItemSeqId)
    {
        this.returnItemSeqId = returnItemSeqId;
    }

    private String rejectionReasonId;

    public String getRejectionReasonId()
    {
        return this.rejectionReasonId;
    }

    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.rejectionReasonId = rejectionReasonId;
    }

    private String damageReasonId;

    public String getDamageReasonId()
    {
        return this.damageReasonId;
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.damageReasonId = damageReasonId;
    }

    private String receivedBy;

    public String getReceivedBy()
    {
        return this.receivedBy;
    }

    public void setReceivedBy(String receivedBy)
    {
        this.receivedBy = receivedBy;
    }

    private java.sql.Timestamp datetimeReceived;

    public java.sql.Timestamp getDatetimeReceived()
    {
        return this.datetimeReceived;
    }

    public void setDatetimeReceived(java.sql.Timestamp datetimeReceived)
    {
        this.datetimeReceived = datetimeReceived;
    }

    private String itemDescription;

    public String getItemDescription()
    {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    private java.math.BigDecimal acceptedQuantity;

    public java.math.BigDecimal getAcceptedQuantity()
    {
        return this.acceptedQuantity;
    }

    public void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity)
    {
        this.acceptedQuantity = acceptedQuantity;
    }

    private java.math.BigDecimal rejectedQuantity;

    public java.math.BigDecimal getRejectedQuantity()
    {
        return this.rejectedQuantity;
    }

    public void setRejectedQuantity(java.math.BigDecimal rejectedQuantity)
    {
        this.rejectedQuantity = rejectedQuantity;
    }

    private java.math.BigDecimal damagedQuantity;

    public java.math.BigDecimal getDamagedQuantity()
    {
        return this.damagedQuantity;
    }

    public void setDamagedQuantity(java.math.BigDecimal damagedQuantity)
    {
        this.damagedQuantity = damagedQuantity;
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

    private Set<String> damageStatusIds;

    public Set<String> getDamageStatusIds()
    {
        return this.damageStatusIds;
    }

    public void setDamageStatusIds(Set<String> damageStatusIds)
    {
        this.damageStatusIds = damageStatusIds;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private ShipmentReceiptImageStates shipmentReceiptImages;

    public ShipmentReceiptImageStates getShipmentReceiptImages()
    {
        return this.shipmentReceiptImages;
    }

    public void setShipmentReceiptImages(ShipmentReceiptImageStates shipmentReceiptImages)
    {
        this.shipmentReceiptImages = shipmentReceiptImages;
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


    public AbstractShipmentReceiptState() {
        this(false);
    }

    public AbstractShipmentReceiptState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        shipmentReceiptImages = new SimpleShipmentReceiptImageStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentReceiptStateCreated) {
            when((ShipmentReceiptStateCreated) e);
        } else if (e instanceof ShipmentReceiptStateMergePatched) {
            when((ShipmentReceiptStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentReceiptStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setLocatorId(e.getLocatorId());
        this.setShipmentItemSeqId(e.getShipmentItemSeqId());
        this.setShipmentPackageSeqId(e.getShipmentPackageSeqId());
        this.setOrderId(e.getOrderId());
        this.setOrderItemSeqId(e.getOrderItemSeqId());
        this.setReturnId(e.getReturnId());
        this.setReturnItemSeqId(e.getReturnItemSeqId());
        this.setRejectionReasonId(e.getRejectionReasonId());
        this.setDamageStatusIds(e.getDamageStatusIds());
        this.setDamageReasonId(e.getDamageReasonId());
        this.setReceivedBy(e.getReceivedBy());
        this.setDatetimeReceived(e.getDatetimeReceived());
        this.setItemDescription(e.getItemDescription());
        this.setAcceptedQuantity(e.getAcceptedQuantity());
        this.setRejectedQuantity(e.getRejectedQuantity());
        this.setDamagedQuantity(e.getDamagedQuantity());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated innerEvent : e.getShipmentReceiptImageEvents()) {
            ShipmentReceiptImageState innerState = this.getShipmentReceiptImages().get(innerEvent.getShipmentReceiptImageEventId().getSequenceId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(ShipmentReceiptStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getProductId() == null)
        {
            if (e.getIsPropertyProductIdRemoved() != null && e.getIsPropertyProductIdRemoved())
            {
                this.setProductId(null);
            }
        }
        else
        {
            this.setProductId(e.getProductId());
        }
        if (e.getAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdRemoved() != null && e.getIsPropertyAttributeSetInstanceIdRemoved())
            {
                this.setAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        }
        if (e.getLocatorId() == null)
        {
            if (e.getIsPropertyLocatorIdRemoved() != null && e.getIsPropertyLocatorIdRemoved())
            {
                this.setLocatorId(null);
            }
        }
        else
        {
            this.setLocatorId(e.getLocatorId());
        }
        if (e.getShipmentItemSeqId() == null)
        {
            if (e.getIsPropertyShipmentItemSeqIdRemoved() != null && e.getIsPropertyShipmentItemSeqIdRemoved())
            {
                this.setShipmentItemSeqId(null);
            }
        }
        else
        {
            this.setShipmentItemSeqId(e.getShipmentItemSeqId());
        }
        if (e.getShipmentPackageSeqId() == null)
        {
            if (e.getIsPropertyShipmentPackageSeqIdRemoved() != null && e.getIsPropertyShipmentPackageSeqIdRemoved())
            {
                this.setShipmentPackageSeqId(null);
            }
        }
        else
        {
            this.setShipmentPackageSeqId(e.getShipmentPackageSeqId());
        }
        if (e.getOrderId() == null)
        {
            if (e.getIsPropertyOrderIdRemoved() != null && e.getIsPropertyOrderIdRemoved())
            {
                this.setOrderId(null);
            }
        }
        else
        {
            this.setOrderId(e.getOrderId());
        }
        if (e.getOrderItemSeqId() == null)
        {
            if (e.getIsPropertyOrderItemSeqIdRemoved() != null && e.getIsPropertyOrderItemSeqIdRemoved())
            {
                this.setOrderItemSeqId(null);
            }
        }
        else
        {
            this.setOrderItemSeqId(e.getOrderItemSeqId());
        }
        if (e.getReturnId() == null)
        {
            if (e.getIsPropertyReturnIdRemoved() != null && e.getIsPropertyReturnIdRemoved())
            {
                this.setReturnId(null);
            }
        }
        else
        {
            this.setReturnId(e.getReturnId());
        }
        if (e.getReturnItemSeqId() == null)
        {
            if (e.getIsPropertyReturnItemSeqIdRemoved() != null && e.getIsPropertyReturnItemSeqIdRemoved())
            {
                this.setReturnItemSeqId(null);
            }
        }
        else
        {
            this.setReturnItemSeqId(e.getReturnItemSeqId());
        }
        if (e.getRejectionReasonId() == null)
        {
            if (e.getIsPropertyRejectionReasonIdRemoved() != null && e.getIsPropertyRejectionReasonIdRemoved())
            {
                this.setRejectionReasonId(null);
            }
        }
        else
        {
            this.setRejectionReasonId(e.getRejectionReasonId());
        }
        if (e.getDamageStatusIds() == null)
        {
            if (e.getIsPropertyDamageStatusIdsRemoved() != null && e.getIsPropertyDamageStatusIdsRemoved())
            {
                this.setDamageStatusIds(null);
            }
        }
        else
        {
            this.setDamageStatusIds(e.getDamageStatusIds());
        }
        if (e.getDamageReasonId() == null)
        {
            if (e.getIsPropertyDamageReasonIdRemoved() != null && e.getIsPropertyDamageReasonIdRemoved())
            {
                this.setDamageReasonId(null);
            }
        }
        else
        {
            this.setDamageReasonId(e.getDamageReasonId());
        }
        if (e.getReceivedBy() == null)
        {
            if (e.getIsPropertyReceivedByRemoved() != null && e.getIsPropertyReceivedByRemoved())
            {
                this.setReceivedBy(null);
            }
        }
        else
        {
            this.setReceivedBy(e.getReceivedBy());
        }
        if (e.getDatetimeReceived() == null)
        {
            if (e.getIsPropertyDatetimeReceivedRemoved() != null && e.getIsPropertyDatetimeReceivedRemoved())
            {
                this.setDatetimeReceived(null);
            }
        }
        else
        {
            this.setDatetimeReceived(e.getDatetimeReceived());
        }
        if (e.getItemDescription() == null)
        {
            if (e.getIsPropertyItemDescriptionRemoved() != null && e.getIsPropertyItemDescriptionRemoved())
            {
                this.setItemDescription(null);
            }
        }
        else
        {
            this.setItemDescription(e.getItemDescription());
        }
        if (e.getAcceptedQuantity() == null)
        {
            if (e.getIsPropertyAcceptedQuantityRemoved() != null && e.getIsPropertyAcceptedQuantityRemoved())
            {
                this.setAcceptedQuantity(null);
            }
        }
        else
        {
            this.setAcceptedQuantity(e.getAcceptedQuantity());
        }
        if (e.getRejectedQuantity() == null)
        {
            if (e.getIsPropertyRejectedQuantityRemoved() != null && e.getIsPropertyRejectedQuantityRemoved())
            {
                this.setRejectedQuantity(null);
            }
        }
        else
        {
            this.setRejectedQuantity(e.getRejectedQuantity());
        }
        if (e.getDamagedQuantity() == null)
        {
            if (e.getIsPropertyDamagedQuantityRemoved() != null && e.getIsPropertyDamagedQuantityRemoved())
            {
                this.setDamagedQuantity(null);
            }
        }
        else
        {
            this.setDamagedQuantity(e.getDamagedQuantity());
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

        for (ShipmentReceiptImageEvent innerEvent : e.getShipmentReceiptImageEvents()) {
            ShipmentReceiptImageState innerState = this.getShipmentReceiptImages().get(innerEvent.getShipmentReceiptImageEventId().getSequenceId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved)
            {
                //ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved removed = (ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved)innerEvent;
                this.getShipmentReceiptImages().remove(innerState);
            }
        }
    }

    public void save()
    {
        shipmentReceiptImages.save();

    }

    protected void throwOnWrongEvent(ShipmentReceiptEvent event)
    {
        String stateEntityIdShipmentId = this.getShipmentReceiptId().getShipmentId();
        String eventEntityIdShipmentId = event.getShipmentReceiptEventId().getShipmentId();
        if (!stateEntityIdShipmentId.equals(eventEntityIdShipmentId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentId %1$s in state but entity id ShipmentId %2$s in event", stateEntityIdShipmentId, eventEntityIdShipmentId);
        }

        String stateEntityIdReceiptSeqId = this.getShipmentReceiptId().getReceiptSeqId();
        String eventEntityIdReceiptSeqId = event.getShipmentReceiptEventId().getReceiptSeqId();
        if (!stateEntityIdReceiptSeqId.equals(eventEntityIdReceiptSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ReceiptSeqId %1$s in state but entity id ReceiptSeqId %2$s in event", stateEntityIdReceiptSeqId, eventEntityIdReceiptSeqId);
        }

        if (getForReapplying()) { return; }

        ShipmentReceiptStateEvent stateEvent = event instanceof ShipmentReceiptStateEvent ? (ShipmentReceiptStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? ShipmentReceiptState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(ShipmentReceiptState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleShipmentReceiptState extends AbstractShipmentReceiptState
    {

        public SimpleShipmentReceiptState() {
        }

        public SimpleShipmentReceiptState(boolean forReapplying) {
            super(forReapplying);
        }

    }

    static class SimpleShipmentReceiptImageStates extends AbstractShipmentReceiptImageStates
    {
        public SimpleShipmentReceiptImageStates(AbstractShipmentReceiptState outerState)
        {
            super(outerState);
        }
    }


}

