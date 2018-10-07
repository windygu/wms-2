package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklist.PicklistEvent.*;

public abstract class AbstractPicklistState implements PicklistState, Saveable
{

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    private java.sql.Timestamp picklistDate;

    public java.sql.Timestamp getPicklistDate()
    {
        return this.picklistDate;
    }

    public void setPicklistDate(java.sql.Timestamp picklistDate)
    {
        this.picklistDate = picklistDate;
    }

    private Long pickwaveId;

    public Long getPickwaveId()
    {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId)
    {
        this.pickwaveId = pickwaveId;
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

    private EntityStateCollection<PartyRoleId, PicklistRoleState> picklistRoles;

    public EntityStateCollection<PartyRoleId, PicklistRoleState> getPicklistRoles()
    {
        return this.picklistRoles;
    }

    public void setPicklistRoles(EntityStateCollection<PartyRoleId, PicklistRoleState> picklistRoles)
    {
        this.picklistRoles = picklistRoles;
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

    public AbstractPicklistState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPicklistId(((PicklistEvent) events.get(0)).getPicklistEventId().getPicklistId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractPicklistState() {
        this(false);
    }

    public AbstractPicklistState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        picklistRoles = new SimplePicklistRoleStateCollection(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PicklistStateCreated) {
            when((PicklistStateCreated) e);
        } else if (e instanceof PicklistStateMergePatched) {
            when((PicklistStateMergePatched) e);
        } else if (e instanceof PicklistStateDeleted) {
            when((PicklistStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PicklistStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDescription(e.getDescription());
        this.setFacilityId(e.getFacilityId());
        this.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        this.setStatusId(e.getStatusId());
        this.setPicklistDate(e.getPicklistDate());
        this.setPickwaveId(e.getPickwaveId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (PicklistRoleEvent.PicklistRoleStateCreated innerEvent : e.getPicklistRoleEvents()) {
            PicklistRoleState innerState = this.getPicklistRoles().get(innerEvent.getPicklistRoleEventId().getPartyRoleId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(PicklistStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getFacilityId() == null)
        {
            if (e.getIsPropertyFacilityIdRemoved() != null && e.getIsPropertyFacilityIdRemoved())
            {
                this.setFacilityId(null);
            }
        }
        else
        {
            this.setFacilityId(e.getFacilityId());
        }
        if (e.getShipmentMethodTypeId() == null)
        {
            if (e.getIsPropertyShipmentMethodTypeIdRemoved() != null && e.getIsPropertyShipmentMethodTypeIdRemoved())
            {
                this.setShipmentMethodTypeId(null);
            }
        }
        else
        {
            this.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        }
        if (e.getStatusId() == null)
        {
            if (e.getIsPropertyStatusIdRemoved() != null && e.getIsPropertyStatusIdRemoved())
            {
                this.setStatusId(null);
            }
        }
        else
        {
            this.setStatusId(e.getStatusId());
        }
        if (e.getPicklistDate() == null)
        {
            if (e.getIsPropertyPicklistDateRemoved() != null && e.getIsPropertyPicklistDateRemoved())
            {
                this.setPicklistDate(null);
            }
        }
        else
        {
            this.setPicklistDate(e.getPicklistDate());
        }
        if (e.getPickwaveId() == null)
        {
            if (e.getIsPropertyPickwaveIdRemoved() != null && e.getIsPropertyPickwaveIdRemoved())
            {
                this.setPickwaveId(null);
            }
        }
        else
        {
            this.setPickwaveId(e.getPickwaveId());
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

        for (PicklistRoleEvent innerEvent : e.getPicklistRoleEvents()) {
            PicklistRoleState innerState = this.getPicklistRoles().get(innerEvent.getPicklistRoleEventId().getPartyRoleId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof PicklistRoleEvent.PicklistRoleStateRemoved)
            {
                //PicklistRoleEvent.PicklistRoleStateRemoved removed = (PicklistRoleEvent.PicklistRoleStateRemoved)innerEvent;
                this.getPicklistRoles().remove(innerState);
            }
        }
    }

    public void when(PicklistStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (PicklistRoleState innerState : this.getPicklistRoles())
        {
            this.getPicklistRoles().remove(innerState);
        
            PicklistRoleEvent.PicklistRoleStateRemoved innerE = e.newPicklistRoleStateRemoved(innerState.getPartyRoleId());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedByUserLogin(e.getCreatedBy());
            innerState.when(innerE);
            //e.addPicklistRoleEvent(innerE);
        }
    }

    public void save()
    {
        ((Saveable)picklistRoles).save();

    }

    protected void throwOnWrongEvent(PicklistEvent event)
    {
        String stateEntityId = this.getPicklistId(); // Aggregate Id
        String eventEntityId = event.getPicklistEventId().getPicklistId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = event.getPicklistEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getPicklistEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PicklistState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePicklistState extends AbstractPicklistState
    {

        public SimplePicklistState() {
        }

        public SimplePicklistState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePicklistState(List<Event> events) {
            super(events);
        }

    }

    static class SimplePicklistRoleStateCollection extends AbstractPicklistRoleStateCollection
    {
        public SimplePicklistRoleStateCollection(AbstractPicklistState outerState)
        {
            super(outerState);
        }
    }


}

