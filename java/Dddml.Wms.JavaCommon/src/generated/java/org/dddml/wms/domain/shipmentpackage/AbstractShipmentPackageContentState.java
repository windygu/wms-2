package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentpackage.ShipmentPackageContentEvent.*;

public abstract class AbstractShipmentPackageContentState implements ShipmentPackageContentState.SqlShipmentPackageContentState
{

    private ShipmentPackageContentId shipmentPackageContentId = new ShipmentPackageContentId();

    public ShipmentPackageContentId getShipmentPackageContentId() {
        return this.shipmentPackageContentId;
    }

    public void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId) {
        this.shipmentPackageContentId = shipmentPackageContentId;
    }

    public ShipmentPackageId getShipmentPackageId() {
        return this.getShipmentPackageContentId().getShipmentPackageId();
    }
        
    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId) {
        this.getShipmentPackageContentId().setShipmentPackageId(shipmentPackageId);
    }

    public String getShipmentItemSeqId() {
        return this.getShipmentPackageContentId().getShipmentItemSeqId();
    }
        
    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        this.getShipmentPackageContentId().setShipmentItemSeqId(shipmentItemSeqId);
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

    private String subProductId;

    public String getSubProductId()
    {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId)
    {
        this.subProductId = subProductId;
    }

    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity()
    {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
    {
        this.subProductQuantity = subProductQuantity;
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


    public AbstractShipmentPackageContentState() {
        this(false);
    }

    public AbstractShipmentPackageContentState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentPackageContentStateCreated) {
            when((ShipmentPackageContentStateCreated) e);
        } else if (e instanceof ShipmentPackageContentStateMergePatched) {
            when((ShipmentPackageContentStateMergePatched) e);
        } else if (e instanceof ShipmentPackageContentStateRemoved) {
            when((ShipmentPackageContentStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentPackageContentStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());
        this.setSubProductId(e.getSubProductId());
        this.setSubProductQuantity(e.getSubProductQuantity());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(ShipmentPackageContentState s) {
        if (s == this) {
            return;
        }
        this.setQuantity(s.getQuantity());
        this.setSubProductId(s.getSubProductId());
        this.setSubProductQuantity(s.getSubProductQuantity());
        this.setActive(s.getActive());
    }

    public void when(ShipmentPackageContentStateMergePatched e)
    {
        throwOnWrongEvent(e);

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
        if (e.getSubProductId() == null)
        {
            if (e.getIsPropertySubProductIdRemoved() != null && e.getIsPropertySubProductIdRemoved())
            {
                this.setSubProductId(null);
            }
        }
        else
        {
            this.setSubProductId(e.getSubProductId());
        }
        if (e.getSubProductQuantity() == null)
        {
            if (e.getIsPropertySubProductQuantityRemoved() != null && e.getIsPropertySubProductQuantityRemoved())
            {
                this.setSubProductQuantity(null);
            }
        }
        else
        {
            this.setSubProductQuantity(e.getSubProductQuantity());
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

    public void when(ShipmentPackageContentStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentPackageContentEvent event)
    {
        ShipmentPackageId stateEntityIdShipmentPackageId = this.getShipmentPackageContentId().getShipmentPackageId();
        ShipmentPackageId eventEntityIdShipmentPackageId = ((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)event).getShipmentPackageContentEventId().getShipmentPackageId();
        if (!stateEntityIdShipmentPackageId.equals(eventEntityIdShipmentPackageId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentPackageId %1$s in state but entity id ShipmentPackageId %2$s in event", stateEntityIdShipmentPackageId, eventEntityIdShipmentPackageId);
        }

        String stateEntityIdShipmentItemSeqId = this.getShipmentPackageContentId().getShipmentItemSeqId();
        String eventEntityIdShipmentItemSeqId = ((ShipmentPackageContentEvent.SqlShipmentPackageContentEvent)event).getShipmentPackageContentEventId().getShipmentItemSeqId();
        if (!stateEntityIdShipmentItemSeqId.equals(eventEntityIdShipmentItemSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentItemSeqId %1$s in state but entity id ShipmentItemSeqId %2$s in event", stateEntityIdShipmentItemSeqId, eventEntityIdShipmentItemSeqId);
        }

        if (getForReapplying()) { return; }

        ShipmentPackageContentStateEvent stateEvent = event instanceof ShipmentPackageContentStateEvent ? (ShipmentPackageContentStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? ShipmentPackageContentState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(ShipmentPackageContentState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleShipmentPackageContentState extends AbstractShipmentPackageContentState
    {

        public SimpleShipmentPackageContentState() {
        }

        public SimpleShipmentPackageContentState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

