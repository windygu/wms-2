package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ShipmentReceiptImageEvent.*;

public abstract class AbstractShipmentReceiptImageState implements ShipmentReceiptImageState.SqlShipmentReceiptImageState
{

    private ShipmentReceiptImageId shipmentReceiptImageId = new ShipmentReceiptImageId();

    public ShipmentReceiptImageId getShipmentReceiptImageId() {
        return this.shipmentReceiptImageId;
    }

    public void setShipmentReceiptImageId(ShipmentReceiptImageId shipmentReceiptImageId) {
        this.shipmentReceiptImageId = shipmentReceiptImageId;
    }

    public String getShipmentId() {
        return this.getShipmentReceiptImageId().getShipmentId();
    }
        
    public void setShipmentId(String shipmentId) {
        this.getShipmentReceiptImageId().setShipmentId(shipmentId);
    }

    public String getShipmentReceiptReceiptSeqId() {
        return this.getShipmentReceiptImageId().getShipmentReceiptReceiptSeqId();
    }
        
    public void setShipmentReceiptReceiptSeqId(String shipmentReceiptReceiptSeqId) {
        this.getShipmentReceiptImageId().setShipmentReceiptReceiptSeqId(shipmentReceiptReceiptSeqId);
    }

    public String getSequenceId() {
        return this.getShipmentReceiptImageId().getSequenceId();
    }
        
    public void setSequenceId(String sequenceId) {
        this.getShipmentReceiptImageId().setSequenceId(sequenceId);
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


    public AbstractShipmentReceiptImageState() {
        this(false);
    }

    public AbstractShipmentReceiptImageState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentReceiptImageStateCreated) {
            when((ShipmentReceiptImageStateCreated) e);
        } else if (e instanceof ShipmentReceiptImageStateMergePatched) {
            when((ShipmentReceiptImageStateMergePatched) e);
        } else if (e instanceof ShipmentReceiptImageStateRemoved) {
            when((ShipmentReceiptImageStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentReceiptImageStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setUrl(e.getUrl());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(ShipmentReceiptImageState s) {
        if (s == this) {
            return;
        }
        this.setUrl(s.getUrl());
        this.setActive(s.getActive());
    }

    public void when(ShipmentReceiptImageStateMergePatched e)
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

    public void when(ShipmentReceiptImageStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentReceiptImageEvent event)
    {
        String stateEntityIdShipmentId = this.getShipmentReceiptImageId().getShipmentId();
        String eventEntityIdShipmentId = ((ShipmentReceiptImageEvent.SqlShipmentReceiptImageEvent)event).getShipmentReceiptImageEventId().getShipmentId();
        if (!stateEntityIdShipmentId.equals(eventEntityIdShipmentId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentId %1$s in state but entity id ShipmentId %2$s in event", stateEntityIdShipmentId, eventEntityIdShipmentId);
        }

        String stateEntityIdShipmentReceiptReceiptSeqId = this.getShipmentReceiptImageId().getShipmentReceiptReceiptSeqId();
        String eventEntityIdShipmentReceiptReceiptSeqId = ((ShipmentReceiptImageEvent.SqlShipmentReceiptImageEvent)event).getShipmentReceiptImageEventId().getShipmentReceiptReceiptSeqId();
        if (!stateEntityIdShipmentReceiptReceiptSeqId.equals(eventEntityIdShipmentReceiptReceiptSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentReceiptReceiptSeqId %1$s in state but entity id ShipmentReceiptReceiptSeqId %2$s in event", stateEntityIdShipmentReceiptReceiptSeqId, eventEntityIdShipmentReceiptReceiptSeqId);
        }

        String stateEntityIdSequenceId = this.getShipmentReceiptImageId().getSequenceId();
        String eventEntityIdSequenceId = ((ShipmentReceiptImageEvent.SqlShipmentReceiptImageEvent)event).getShipmentReceiptImageEventId().getSequenceId();
        if (!stateEntityIdSequenceId.equals(eventEntityIdSequenceId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id SequenceId %1$s in state but entity id SequenceId %2$s in event", stateEntityIdSequenceId, eventEntityIdSequenceId);
        }

        if (getForReapplying()) { return; }

        ShipmentReceiptImageStateEvent stateEvent = event instanceof ShipmentReceiptImageStateEvent ? (ShipmentReceiptImageStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? ShipmentReceiptImageState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(ShipmentReceiptImageState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleShipmentReceiptImageState extends AbstractShipmentReceiptImageState
    {

        public SimpleShipmentReceiptImageState() {
        }

        public SimpleShipmentReceiptImageState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

