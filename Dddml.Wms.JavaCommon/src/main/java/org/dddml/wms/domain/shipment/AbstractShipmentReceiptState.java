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

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String rejectionId;

    public String getRejectionId()
    {
        return this.rejectionId;
    }

    public void setRejectionId(String rejectionId)
    {
        this.rejectionId = rejectionId;
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
        this.setShipmentItemSeqId(e.getShipmentItemSeqId());
        this.setRejectionId(e.getRejectionId());
        this.setItemDescription(e.getItemDescription());
        this.setAcceptedQuantity(e.getAcceptedQuantity());
        this.setRejectedQuantity(e.getRejectedQuantity());
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
        if (e.getRejectionId() == null)
        {
            if (e.getIsPropertyRejectionIdRemoved() != null && e.getIsPropertyRejectionIdRemoved())
            {
                this.setRejectionId(null);
            }
        }
        else
        {
            this.setRejectionId(e.getRejectionId());
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
        if (!(stateVersion == null && eventVersion.equals(ShipmentReceiptState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
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
