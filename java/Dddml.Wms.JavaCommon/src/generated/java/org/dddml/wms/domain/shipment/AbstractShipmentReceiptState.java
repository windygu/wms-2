package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ShipmentReceiptStateEvent.*;

public abstract class AbstractShipmentReceiptState implements ShipmentReceiptState
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

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
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

    private String damageStatusId;

    public String getDamageStatusId()
    {
        return this.damageStatusId;
    }

    public void setDamageStatusId(String damageStatusId)
    {
        this.damageStatusId = damageStatusId;
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

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
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
        this.setShipmentItemSeqId(e.getShipmentItemSeqId());
        this.setRejectionReasonId(e.getRejectionReasonId());
        this.setDamageStatusId(e.getDamageStatusId());
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
        if (e.getDamageStatusId() == null)
        {
            if (e.getIsPropertyDamageStatusIdRemoved() != null && e.getIsPropertyDamageStatusIdRemoved())
            {
                this.setDamageStatusId(null);
            }
        }
        else
        {
            this.setDamageStatusId(e.getDamageStatusId());
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

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentReceiptStateEvent stateEvent)
    {
        String stateEntityIdShipmentId = this.getShipmentReceiptId().getShipmentId();
        String eventEntityIdShipmentId = stateEvent.getStateEventId().getShipmentId();
        if (!stateEntityIdShipmentId.equals(eventEntityIdShipmentId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentId %1$s in state but entity id ShipmentId %2$s in event", stateEntityIdShipmentId, eventEntityIdShipmentId);
        }

        String stateEntityIdReceiptSeqId = this.getShipmentReceiptId().getReceiptSeqId();
        String eventEntityIdReceiptSeqId = stateEvent.getStateEventId().getReceiptSeqId();
        if (!stateEntityIdReceiptSeqId.equals(eventEntityIdReceiptSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ReceiptSeqId %1$s in state but entity id ReceiptSeqId %2$s in event", stateEntityIdReceiptSeqId, eventEntityIdReceiptSeqId);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? ShipmentReceiptState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentReceiptState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentReceiptState extends AbstractShipmentReceiptState
    {

        public SimpleShipmentReceiptState() {
        }

        public SimpleShipmentReceiptState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

