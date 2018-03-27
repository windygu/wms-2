package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistitemmvo.PicklistItemMvoStateEvent.*;

public abstract class AbstractPicklistItemMvoState implements PicklistItemMvoState
{

    private PicklistBinPicklistItemId picklistBinPicklistItemId;

    public PicklistBinPicklistItemId getPicklistBinPicklistItemId()
    {
        return this.picklistBinPicklistItemId;
    }

    public void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId)
    {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
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

    private String picklistBinPicklistId;

    public String getPicklistBinPicklistId()
    {
        return this.picklistBinPicklistId;
    }

    public void setPicklistBinPicklistId(String picklistBinPicklistId)
    {
        this.picklistBinPicklistId = picklistBinPicklistId;
    }

    private Long picklistBinBinLocationNumber;

    public Long getPicklistBinBinLocationNumber()
    {
        return this.picklistBinBinLocationNumber;
    }

    public void setPicklistBinBinLocationNumber(Long picklistBinBinLocationNumber)
    {
        this.picklistBinBinLocationNumber = picklistBinBinLocationNumber;
    }

    private String picklistBinPrimaryOrderId;

    public String getPicklistBinPrimaryOrderId()
    {
        return this.picklistBinPrimaryOrderId;
    }

    public void setPicklistBinPrimaryOrderId(String picklistBinPrimaryOrderId)
    {
        this.picklistBinPrimaryOrderId = picklistBinPrimaryOrderId;
    }

    private Long picklistBinPrimaryShipGroupSeqId;

    public Long getPicklistBinPrimaryShipGroupSeqId()
    {
        return this.picklistBinPrimaryShipGroupSeqId;
    }

    public void setPicklistBinPrimaryShipGroupSeqId(Long picklistBinPrimaryShipGroupSeqId)
    {
        this.picklistBinPrimaryShipGroupSeqId = picklistBinPrimaryShipGroupSeqId;
    }

    private Long picklistBinVersion;

    public Long getPicklistBinVersion()
    {
        return this.picklistBinVersion;
    }

    public void setPicklistBinVersion(Long picklistBinVersion)
    {
        this.picklistBinVersion = picklistBinVersion;
    }

    private String picklistBinCreatedBy;

    public String getPicklistBinCreatedBy()
    {
        return this.picklistBinCreatedBy;
    }

    public void setPicklistBinCreatedBy(String picklistBinCreatedBy)
    {
        this.picklistBinCreatedBy = picklistBinCreatedBy;
    }

    private Date picklistBinCreatedAt;

    public Date getPicklistBinCreatedAt()
    {
        return this.picklistBinCreatedAt;
    }

    public void setPicklistBinCreatedAt(Date picklistBinCreatedAt)
    {
        this.picklistBinCreatedAt = picklistBinCreatedAt;
    }

    private String picklistBinUpdatedBy;

    public String getPicklistBinUpdatedBy()
    {
        return this.picklistBinUpdatedBy;
    }

    public void setPicklistBinUpdatedBy(String picklistBinUpdatedBy)
    {
        this.picklistBinUpdatedBy = picklistBinUpdatedBy;
    }

    private Date picklistBinUpdatedAt;

    public Date getPicklistBinUpdatedAt()
    {
        return this.picklistBinUpdatedAt;
    }

    public void setPicklistBinUpdatedAt(Date picklistBinUpdatedAt)
    {
        this.picklistBinUpdatedAt = picklistBinUpdatedAt;
    }

    private Boolean picklistBinActive;

    public Boolean getPicklistBinActive()
    {
        return this.picklistBinActive;
    }

    public void setPicklistBinActive(Boolean picklistBinActive)
    {
        this.picklistBinActive = picklistBinActive;
    }

    private Boolean picklistBinDeleted;

    public Boolean getPicklistBinDeleted()
    {
        return this.picklistBinDeleted;
    }

    public void setPicklistBinDeleted(Boolean picklistBinDeleted)
    {
        this.picklistBinDeleted = picklistBinDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getPicklistBinVersion() == null;
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

    public AbstractPicklistItemMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPicklistBinPicklistItemId(((PicklistItemMvoStateEvent) events.get(0)).getPicklistItemMvoEventId().getPicklistBinPicklistItemId());
            for (Event e : events) {
                mutate(e);
                this.setPicklistBinVersion(this.getPicklistBinVersion() + 1);
            }
        }
    }


    public AbstractPicklistItemMvoState() {
        this(false);
    }

    public AbstractPicklistItemMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PicklistItemMvoStateCreated) {
            when((PicklistItemMvoStateCreated) e);
        } else if (e instanceof PicklistItemMvoStateMergePatched) {
            when((PicklistItemMvoStateMergePatched) e);
        } else if (e instanceof PicklistItemMvoStateDeleted) {
            when((PicklistItemMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PicklistItemMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setItemStatusId(e.getItemStatusId());
        this.setQuantity(e.getQuantity());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setPicklistBinPicklistId(e.getPicklistBinPicklistId());
        this.setPicklistBinBinLocationNumber(e.getPicklistBinBinLocationNumber());
        this.setPicklistBinPrimaryOrderId(e.getPicklistBinPrimaryOrderId());
        this.setPicklistBinPrimaryShipGroupSeqId(e.getPicklistBinPrimaryShipGroupSeqId());
        this.setPicklistBinCreatedBy(e.getPicklistBinCreatedBy());
        this.setPicklistBinCreatedAt(e.getPicklistBinCreatedAt());
        this.setPicklistBinUpdatedBy(e.getPicklistBinUpdatedBy());
        this.setPicklistBinUpdatedAt(e.getPicklistBinUpdatedAt());
        this.setPicklistBinActive(e.getPicklistBinActive());
        this.setPicklistBinDeleted(e.getPicklistBinDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PicklistItemMvoStateMergePatched e)
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
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
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
        if (e.getPicklistBinPicklistId() == null)
        {
            if (e.getIsPropertyPicklistBinPicklistIdRemoved() != null && e.getIsPropertyPicklistBinPicklistIdRemoved())
            {
                this.setPicklistBinPicklistId(null);
            }
        }
        else
        {
            this.setPicklistBinPicklistId(e.getPicklistBinPicklistId());
        }
        if (e.getPicklistBinBinLocationNumber() == null)
        {
            if (e.getIsPropertyPicklistBinBinLocationNumberRemoved() != null && e.getIsPropertyPicklistBinBinLocationNumberRemoved())
            {
                this.setPicklistBinBinLocationNumber(null);
            }
        }
        else
        {
            this.setPicklistBinBinLocationNumber(e.getPicklistBinBinLocationNumber());
        }
        if (e.getPicklistBinPrimaryOrderId() == null)
        {
            if (e.getIsPropertyPicklistBinPrimaryOrderIdRemoved() != null && e.getIsPropertyPicklistBinPrimaryOrderIdRemoved())
            {
                this.setPicklistBinPrimaryOrderId(null);
            }
        }
        else
        {
            this.setPicklistBinPrimaryOrderId(e.getPicklistBinPrimaryOrderId());
        }
        if (e.getPicklistBinPrimaryShipGroupSeqId() == null)
        {
            if (e.getIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved() != null && e.getIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved())
            {
                this.setPicklistBinPrimaryShipGroupSeqId(null);
            }
        }
        else
        {
            this.setPicklistBinPrimaryShipGroupSeqId(e.getPicklistBinPrimaryShipGroupSeqId());
        }
        if (e.getPicklistBinCreatedBy() == null)
        {
            if (e.getIsPropertyPicklistBinCreatedByRemoved() != null && e.getIsPropertyPicklistBinCreatedByRemoved())
            {
                this.setPicklistBinCreatedBy(null);
            }
        }
        else
        {
            this.setPicklistBinCreatedBy(e.getPicklistBinCreatedBy());
        }
        if (e.getPicklistBinCreatedAt() == null)
        {
            if (e.getIsPropertyPicklistBinCreatedAtRemoved() != null && e.getIsPropertyPicklistBinCreatedAtRemoved())
            {
                this.setPicklistBinCreatedAt(null);
            }
        }
        else
        {
            this.setPicklistBinCreatedAt(e.getPicklistBinCreatedAt());
        }
        if (e.getPicklistBinUpdatedBy() == null)
        {
            if (e.getIsPropertyPicklistBinUpdatedByRemoved() != null && e.getIsPropertyPicklistBinUpdatedByRemoved())
            {
                this.setPicklistBinUpdatedBy(null);
            }
        }
        else
        {
            this.setPicklistBinUpdatedBy(e.getPicklistBinUpdatedBy());
        }
        if (e.getPicklistBinUpdatedAt() == null)
        {
            if (e.getIsPropertyPicklistBinUpdatedAtRemoved() != null && e.getIsPropertyPicklistBinUpdatedAtRemoved())
            {
                this.setPicklistBinUpdatedAt(null);
            }
        }
        else
        {
            this.setPicklistBinUpdatedAt(e.getPicklistBinUpdatedAt());
        }
        if (e.getPicklistBinActive() == null)
        {
            if (e.getIsPropertyPicklistBinActiveRemoved() != null && e.getIsPropertyPicklistBinActiveRemoved())
            {
                this.setPicklistBinActive(null);
            }
        }
        else
        {
            this.setPicklistBinActive(e.getPicklistBinActive());
        }
        if (e.getPicklistBinDeleted() == null)
        {
            if (e.getIsPropertyPicklistBinDeletedRemoved() != null && e.getIsPropertyPicklistBinDeletedRemoved())
            {
                this.setPicklistBinDeleted(null);
            }
        }
        else
        {
            this.setPicklistBinDeleted(e.getPicklistBinDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(PicklistItemMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PicklistItemMvoStateEvent stateEvent)
    {
        PicklistBinPicklistItemId stateEntityId = this.getPicklistBinPicklistItemId(); // Aggregate Id
        PicklistBinPicklistItemId eventEntityId = stateEvent.getPicklistItemMvoEventId().getPicklistBinPicklistItemId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getPicklistBinVersion();
        Long eventVersion = stateEvent.getPicklistItemMvoEventId().getPicklistBinVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getPicklistItemMvoEventId().getPicklistBinVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PicklistItemMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePicklistItemMvoState extends AbstractPicklistItemMvoState
    {

        public SimplePicklistItemMvoState() {
        }

        public SimplePicklistItemMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePicklistItemMvoState(List<Event> events) {
            super(events);
        }

    }


}

