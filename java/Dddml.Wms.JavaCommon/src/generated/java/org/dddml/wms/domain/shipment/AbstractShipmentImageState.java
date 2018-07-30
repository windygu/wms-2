package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ShipmentImageEvent.*;

public abstract class AbstractShipmentImageState implements ShipmentImageState
{

    private ShipmentImageId shipmentImageId = new ShipmentImageId();

    public ShipmentImageId getShipmentImageId() {
        return this.shipmentImageId;
    }

    public void setShipmentImageId(ShipmentImageId shipmentImageId) {
        this.shipmentImageId = shipmentImageId;
    }

    public String getShipmentId() {
        return this.getShipmentImageId().getShipmentId();
    }
        
    public void setShipmentId(String shipmentId) {
        this.getShipmentImageId().setShipmentId(shipmentId);
    }

    public String getSequenceId() {
        return this.getShipmentImageId().getSequenceId();
    }
        
    public void setSequenceId(String sequenceId) {
        this.getShipmentImageId().setSequenceId(sequenceId);
    }

    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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


    public AbstractShipmentImageState() {
        this(false);
    }

    public AbstractShipmentImageState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentImageStateCreated) {
            when((ShipmentImageStateCreated) e);
        } else if (e instanceof ShipmentImageStateMergePatched) {
            when((ShipmentImageStateMergePatched) e);
        } else if (e instanceof ShipmentImageStateRemoved) {
            when((ShipmentImageStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentImageStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setUrl(e.getUrl());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ShipmentImageStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getUrl() == null)
        {
            if (e.getIsPropertyUrlRemoved() != null && e.getIsPropertyUrlRemoved())
            {
                this.setUrl(null);
            }
        }
        else
        {
            this.setUrl(e.getUrl());
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

    public void when(ShipmentImageStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentImageEvent event)
    {
        String stateEntityIdShipmentId = this.getShipmentImageId().getShipmentId();
        String eventEntityIdShipmentId = event.getShipmentImageEventId().getShipmentId();
        if (!stateEntityIdShipmentId.equals(eventEntityIdShipmentId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentId %1$s in state but entity id ShipmentId %2$s in event", stateEntityIdShipmentId, eventEntityIdShipmentId);
        }

        String stateEntityIdSequenceId = this.getShipmentImageId().getSequenceId();
        String eventEntityIdSequenceId = event.getShipmentImageEventId().getSequenceId();
        if (!stateEntityIdSequenceId.equals(eventEntityIdSequenceId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id SequenceId %1$s in state but entity id SequenceId %2$s in event", stateEntityIdSequenceId, eventEntityIdSequenceId);
        }

        if (getForReapplying()) { return; }

        ShipmentImageStateEvent stateEvent = event instanceof ShipmentImageStateEvent ? (ShipmentImageStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? ShipmentImageState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(ShipmentImageState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleShipmentImageState extends AbstractShipmentImageState
    {

        public SimpleShipmentImageState() {
        }

        public SimpleShipmentImageState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

