package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ShipmentItemStateEvent.*;

public abstract class AbstractShipmentItemState implements ShipmentItemState
{

    private ShipmentItemId shipmentItemId = new ShipmentItemId();

    public ShipmentItemId getShipmentItemId() {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemId shipmentItemId) {
        this.shipmentItemId = shipmentItemId;
    }

    public String getShipmentId() {
        return this.getShipmentItemId().getShipmentId();
    }
        
    public void setShipmentId(String shipmentId) {
        this.getShipmentItemId().setShipmentId(shipmentId);
    }

    public String getShipmentItemSeqId() {
        return this.getShipmentItemId().getShipmentItemSeqId();
    }
        
    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        this.getShipmentItemId().setShipmentItemSeqId(shipmentItemSeqId);
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

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private String shipmentContentDescription;

    public String getShipmentContentDescription()
    {
        return this.shipmentContentDescription;
    }

    public void setShipmentContentDescription(String shipmentContentDescription)
    {
        this.shipmentContentDescription = shipmentContentDescription;
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


    public AbstractShipmentItemState() {
        this(false);
    }

    public AbstractShipmentItemState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentItemStateCreated) {
            when((ShipmentItemStateCreated) e);
        } else if (e instanceof ShipmentItemStateMergePatched) {
            when((ShipmentItemStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentItemStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setQuantity(e.getQuantity());
        this.setShipmentContentDescription(e.getShipmentContentDescription());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ShipmentItemStateMergePatched e)
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
        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
        }
        if (e.getShipmentContentDescription() == null)
        {
            if (e.getIsPropertyShipmentContentDescriptionRemoved() != null && e.getIsPropertyShipmentContentDescriptionRemoved())
            {
                this.setShipmentContentDescription(null);
            }
        }
        else
        {
            this.setShipmentContentDescription(e.getShipmentContentDescription());
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

    protected void throwOnWrongEvent(ShipmentItemStateEvent stateEvent)
    {
        String stateEntityIdShipmentId = this.getShipmentItemId().getShipmentId();
        String eventEntityIdShipmentId = stateEvent.getShipmentItemEventId().getShipmentId();
        if (!stateEntityIdShipmentId.equals(eventEntityIdShipmentId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentId %1$s in state but entity id ShipmentId %2$s in event", stateEntityIdShipmentId, eventEntityIdShipmentId);
        }

        String stateEntityIdShipmentItemSeqId = this.getShipmentItemId().getShipmentItemSeqId();
        String eventEntityIdShipmentItemSeqId = stateEvent.getShipmentItemEventId().getShipmentItemSeqId();
        if (!stateEntityIdShipmentItemSeqId.equals(eventEntityIdShipmentItemSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentItemSeqId %1$s in state but entity id ShipmentItemSeqId %2$s in event", stateEntityIdShipmentItemSeqId, eventEntityIdShipmentItemSeqId);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? ShipmentItemState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentItemState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentItemState extends AbstractShipmentItemState
    {

        public SimpleShipmentItemState() {
        }

        public SimpleShipmentItemState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

