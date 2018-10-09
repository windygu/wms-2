package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistbin.PicklistItemEvent.*;

public abstract class AbstractPicklistItemState implements PicklistItemState.SqlPicklistItemState
{

    private PicklistBinPicklistItemId picklistBinPicklistItemId = new PicklistBinPicklistItemId();

    public PicklistBinPicklistItemId getPicklistBinPicklistItemId() {
        return this.picklistBinPicklistItemId;
    }

    public void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId) {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
    }

    public String getPicklistBinId() {
        return this.getPicklistBinPicklistItemId().getPicklistBinId();
    }
        
    public void setPicklistBinId(String picklistBinId) {
        this.getPicklistBinPicklistItemId().setPicklistBinId(picklistBinId);
    }

    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId() {
        return this.getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId();
    }
        
    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        this.getPicklistBinPicklistItemId().setPicklistItemOrderShipGrpInvId(picklistItemOrderShipGrpInvId);
    }

    private String itemStatusId;

    public String getItemStatusId()
    {
        return this.itemStatusId;
    }

    public void setItemStatusId(String itemStatusId)
    {
        this.itemStatusId = itemStatusId;
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


    public AbstractPicklistItemState() {
        this(false);
    }

    public AbstractPicklistItemState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PicklistItemStateCreated) {
            when((PicklistItemStateCreated) e);
        } else if (e instanceof PicklistItemStateMergePatched) {
            when((PicklistItemStateMergePatched) e);
        } else if (e instanceof PicklistItemStateRemoved) {
            when((PicklistItemStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PicklistItemStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setItemStatusId(e.getItemStatusId());
        this.setQuantity(e.getQuantity());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PicklistItemStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getItemStatusId() == null)
        {
            if (e.getIsPropertyItemStatusIdRemoved() != null && e.getIsPropertyItemStatusIdRemoved())
            {
                this.setItemStatusId(null);
            }
        }
        else
        {
            this.setItemStatusId(e.getItemStatusId());
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

    public void when(PicklistItemStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PicklistItemEvent event)
    {
        String stateEntityIdPicklistBinId = this.getPicklistBinPicklistItemId().getPicklistBinId();
        String eventEntityIdPicklistBinId = ((PicklistItemEvent.SqlPicklistItemEvent)event).getPicklistItemEventId().getPicklistBinId();
        if (!stateEntityIdPicklistBinId.equals(eventEntityIdPicklistBinId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id PicklistBinId %1$s in state but entity id PicklistBinId %2$s in event", stateEntityIdPicklistBinId, eventEntityIdPicklistBinId);
        }

        PicklistItemOrderShipGrpInvId stateEntityIdPicklistItemOrderShipGrpInvId = this.getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId();
        PicklistItemOrderShipGrpInvId eventEntityIdPicklistItemOrderShipGrpInvId = ((PicklistItemEvent.SqlPicklistItemEvent)event).getPicklistItemEventId().getPicklistItemOrderShipGrpInvId();
        if (!stateEntityIdPicklistItemOrderShipGrpInvId.equals(eventEntityIdPicklistItemOrderShipGrpInvId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id PicklistItemOrderShipGrpInvId %1$s in state but entity id PicklistItemOrderShipGrpInvId %2$s in event", stateEntityIdPicklistItemOrderShipGrpInvId, eventEntityIdPicklistItemOrderShipGrpInvId);
        }

        if (getForReapplying()) { return; }

        PicklistItemStateEvent stateEvent = event instanceof PicklistItemStateEvent ? (PicklistItemStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? PicklistItemState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(PicklistItemState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimplePicklistItemState extends AbstractPicklistItemState
    {

        public SimplePicklistItemState() {
        }

        public SimplePicklistItemState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

