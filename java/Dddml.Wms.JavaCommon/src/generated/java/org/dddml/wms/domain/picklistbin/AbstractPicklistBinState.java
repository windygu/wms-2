package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistbin.PicklistBinEvent.*;

public abstract class AbstractPicklistBinState implements PicklistBinState.SqlPicklistBinState, Saveable
{

    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
    }

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }

    private Long binLocationNumber;

    public Long getBinLocationNumber()
    {
        return this.binLocationNumber;
    }

    public void setBinLocationNumber(Long binLocationNumber)
    {
        this.binLocationNumber = binLocationNumber;
    }

    private String primaryOrderId;

    public String getPrimaryOrderId()
    {
        return this.primaryOrderId;
    }

    public void setPrimaryOrderId(String primaryOrderId)
    {
        this.primaryOrderId = primaryOrderId;
    }

    private String primaryShipGroupSeqId;

    public String getPrimaryShipGroupSeqId()
    {
        return this.primaryShipGroupSeqId;
    }

    public void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId)
    {
        this.primaryShipGroupSeqId = primaryShipGroupSeqId;
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

    private EntityStateCollection<PicklistItemOrderShipGrpInvId, PicklistItemState> picklistItems;

    public EntityStateCollection<PicklistItemOrderShipGrpInvId, PicklistItemState> getPicklistItems()
    {
        return this.picklistItems;
    }

    public void setPicklistItems(EntityStateCollection<PicklistItemOrderShipGrpInvId, PicklistItemState> picklistItems)
    {
        this.picklistItems = picklistItems;
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

    public AbstractPicklistBinState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPicklistBinId(((PicklistBinEvent.SqlPicklistBinEvent) events.get(0)).getPicklistBinEventId().getPicklistBinId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractPicklistBinState() {
        this(false);
    }

    public AbstractPicklistBinState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        picklistItems = new SimplePicklistItemStateCollection(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PicklistBinStateCreated) {
            when((PicklistBinStateCreated) e);
        } else if (e instanceof PicklistBinStateMergePatched) {
            when((PicklistBinStateMergePatched) e);
        } else if (e instanceof PicklistBinStateDeleted) {
            when((PicklistBinStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PicklistBinStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setPicklistId(e.getPicklistId());
        this.setBinLocationNumber(e.getBinLocationNumber());
        this.setPrimaryOrderId(e.getPrimaryOrderId());
        this.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (PicklistItemEvent.PicklistItemStateCreated innerEvent : e.getPicklistItemEvents()) {
            PicklistItemState innerState = this.getPicklistItems().get(((PicklistItemEvent.SqlPicklistItemEvent)innerEvent).getPicklistItemEventId().getPicklistItemOrderShipGrpInvId());
            ((PicklistItemState.SqlPicklistItemState)innerState).mutate(innerEvent);
        }
    }

    public void when(PicklistBinStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getPicklistId() == null)
        {
            if (e.getIsPropertyPicklistIdRemoved() != null && e.getIsPropertyPicklistIdRemoved())
            {
                this.setPicklistId(null);
            }
        }
        else
        {
            this.setPicklistId(e.getPicklistId());
        }
        if (e.getBinLocationNumber() == null)
        {
            if (e.getIsPropertyBinLocationNumberRemoved() != null && e.getIsPropertyBinLocationNumberRemoved())
            {
                this.setBinLocationNumber(null);
            }
        }
        else
        {
            this.setBinLocationNumber(e.getBinLocationNumber());
        }
        if (e.getPrimaryOrderId() == null)
        {
            if (e.getIsPropertyPrimaryOrderIdRemoved() != null && e.getIsPropertyPrimaryOrderIdRemoved())
            {
                this.setPrimaryOrderId(null);
            }
        }
        else
        {
            this.setPrimaryOrderId(e.getPrimaryOrderId());
        }
        if (e.getPrimaryShipGroupSeqId() == null)
        {
            if (e.getIsPropertyPrimaryShipGroupSeqIdRemoved() != null && e.getIsPropertyPrimaryShipGroupSeqIdRemoved())
            {
                this.setPrimaryShipGroupSeqId(null);
            }
        }
        else
        {
            this.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
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

        for (PicklistItemEvent innerEvent : e.getPicklistItemEvents()) {
            PicklistItemState innerState = this.getPicklistItems().get(((PicklistItemEvent.SqlPicklistItemEvent)innerEvent).getPicklistItemEventId().getPicklistItemOrderShipGrpInvId());
            ((PicklistItemState.SqlPicklistItemState)innerState).mutate(innerEvent);
            if (innerEvent instanceof PicklistItemEvent.PicklistItemStateRemoved)
            {
                //PicklistItemEvent.PicklistItemStateRemoved removed = (PicklistItemEvent.PicklistItemStateRemoved)innerEvent;
                this.getPicklistItems().remove(innerState);
            }
        }
    }

    public void when(PicklistBinStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (PicklistItemState innerState : this.getPicklistItems())
        {
            this.getPicklistItems().remove(innerState);
        
            PicklistItemEvent.PicklistItemStateRemoved innerE = e.newPicklistItemStateRemoved(innerState.getPicklistItemOrderShipGrpInvId());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            ((PicklistItemState.MutablePicklistItemState)innerState).when(innerE);
            //e.addPicklistItemEvent(innerE);
        }
    }

    public void save()
    {
        ((Saveable)picklistItems).save();

    }

    protected void throwOnWrongEvent(PicklistBinEvent event)
    {
        String stateEntityId = this.getPicklistBinId(); // Aggregate Id
        String eventEntityId = ((PicklistBinEvent.SqlPicklistBinEvent)event).getPicklistBinEventId().getPicklistBinId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((PicklistBinEvent.SqlPicklistBinEvent)event).getPicklistBinEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getPicklistBinEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PicklistBinState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePicklistBinState extends AbstractPicklistBinState
    {

        public SimplePicklistBinState() {
        }

        public SimplePicklistBinState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePicklistBinState(List<Event> events) {
            super(events);
        }

    }

    static class SimplePicklistItemStateCollection extends AbstractPicklistItemStateCollection
    {
        public SimplePicklistItemStateCollection(AbstractPicklistBinState outerState)
        {
            super(outerState);
        }
    }


}

