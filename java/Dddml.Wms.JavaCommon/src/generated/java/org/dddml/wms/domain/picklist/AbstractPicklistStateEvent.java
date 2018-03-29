package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPicklistStateEvent extends AbstractStateEvent implements PicklistStateEvent 
{
    private PicklistEventId picklistEventId;

    public PicklistEventId getPicklistEventId() {
        return this.picklistEventId;
    }

    public void setPicklistEventId(PicklistEventId eventId) {
        this.picklistEventId = eventId;
    }
    
    public String getPicklistId() {
        return getPicklistEventId().getPicklistId();
    }

    public void setPicklistId(String picklistId) {
        getPicklistEventId().setPicklistId(picklistId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractPicklistStateEvent() {
    }

    protected AbstractPicklistStateEvent(PicklistEventId eventId) {
        this.picklistEventId = eventId;
    }

    protected PicklistRoleStateEventDao getPicklistRoleStateEventDao() {
        return (PicklistRoleStateEventDao)ApplicationContext.current.get("PicklistRoleStateEventDao");
    }

    protected PicklistRoleEventId newPicklistRoleEventId(PartyRoleId partyRoleId)
    {
        PicklistRoleEventId eventId = new PicklistRoleEventId(this.getPicklistEventId().getPicklistId(), 
            partyRoleId, 
            this.getPicklistEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(PicklistRoleStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(PicklistStateEvent oe, PicklistRoleStateEvent e)
    {
        if (!oe.getPicklistEventId().getPicklistId().equals(e.getPicklistRoleEventId().getPicklistId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id PicklistId %1$s but inner id PicklistId %2$s", 
                oe.getPicklistEventId().getPicklistId(), e.getPicklistRoleEventId().getPicklistId());
        }
    }

    public PicklistRoleStateEvent.PicklistRoleStateCreated newPicklistRoleStateCreated(PartyRoleId partyRoleId) {
        return new AbstractPicklistRoleStateEvent.SimplePicklistRoleStateCreated(newPicklistRoleEventId(partyRoleId));
    }

    public PicklistRoleStateEvent.PicklistRoleStateMergePatched newPicklistRoleStateMergePatched(PartyRoleId partyRoleId) {
        return new AbstractPicklistRoleStateEvent.SimplePicklistRoleStateMergePatched(newPicklistRoleEventId(partyRoleId));
    }

    public PicklistRoleStateEvent.PicklistRoleStateRemoved newPicklistRoleStateRemoved(PartyRoleId partyRoleId) {
        return new AbstractPicklistRoleStateEvent.SimplePicklistRoleStateRemoved(newPicklistRoleEventId(partyRoleId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPicklistStateCreated extends AbstractPicklistStateEvent implements PicklistStateEvent.PicklistStateCreated, Saveable
    {
        public AbstractPicklistStateCreated() {
            this(new PicklistEventId());
        }

        public AbstractPicklistStateCreated(PicklistEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<PicklistRoleEventId, PicklistRoleStateEvent.PicklistRoleStateCreated> picklistRoleEvents = new HashMap<PicklistRoleEventId, PicklistRoleStateEvent.PicklistRoleStateCreated>();
        
        private Iterable<PicklistRoleStateEvent.PicklistRoleStateCreated> readOnlyPicklistRoleEvents;

        public Iterable<PicklistRoleStateEvent.PicklistRoleStateCreated> getPicklistRoleEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.picklistRoleEvents.values();
            }
            else
            {
                if (readOnlyPicklistRoleEvents != null) { return readOnlyPicklistRoleEvents; }
                PicklistRoleStateEventDao eventDao = getPicklistRoleStateEventDao();
                List<PicklistRoleStateEvent.PicklistRoleStateCreated> eL = new ArrayList<PicklistRoleStateEvent.PicklistRoleStateCreated>();
                for (PicklistRoleStateEvent e : eventDao.findByPicklistEventId(this.getPicklistEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((PicklistRoleStateEvent.PicklistRoleStateCreated)e);
                }
                return (readOnlyPicklistRoleEvents = eL);
            }
        }

        public void setPicklistRoleEvents(Iterable<PicklistRoleStateEvent.PicklistRoleStateCreated> es)
        {
            if (es != null)
            {
                for (PicklistRoleStateEvent.PicklistRoleStateCreated e : es)
                {
                    addPicklistRoleEvent(e);
                }
            }
            else { this.picklistRoleEvents.clear(); }
        }
        
        public void addPicklistRoleEvent(PicklistRoleStateEvent.PicklistRoleStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistRoleEvents.put(e.getPicklistRoleEventId(), e);
        }

        public void save()
        {
            for (PicklistRoleStateEvent.PicklistRoleStateCreated e : this.getPicklistRoleEvents()) {
                getPicklistRoleStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistStateMergePatched extends AbstractPicklistStateEvent implements PicklistStateEvent.PicklistStateMergePatched, Saveable
    {
        public AbstractPicklistStateMergePatched() {
            this(new PicklistEventId());
        }

        public AbstractPicklistStateMergePatched(PicklistEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyFacilityIdRemoved;

        public Boolean getIsPropertyFacilityIdRemoved() {
            return this.isPropertyFacilityIdRemoved;
        }

        public void setIsPropertyFacilityIdRemoved(Boolean removed) {
            this.isPropertyFacilityIdRemoved = removed;
        }

        private Boolean isPropertyShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyShipmentMethodTypeIdRemoved() {
            return this.isPropertyShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed) {
            this.isPropertyShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved() {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed) {
            this.isPropertyStatusIdRemoved = removed;
        }

        private Boolean isPropertyPicklistDateRemoved;

        public Boolean getIsPropertyPicklistDateRemoved() {
            return this.isPropertyPicklistDateRemoved;
        }

        public void setIsPropertyPicklistDateRemoved(Boolean removed) {
            this.isPropertyPicklistDateRemoved = removed;
        }

        private Boolean isPropertyPickwaveIdRemoved;

        public Boolean getIsPropertyPickwaveIdRemoved() {
            return this.isPropertyPickwaveIdRemoved;
        }

        public void setIsPropertyPickwaveIdRemoved(Boolean removed) {
            this.isPropertyPickwaveIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<PicklistRoleEventId, PicklistRoleStateEvent> picklistRoleEvents = new HashMap<PicklistRoleEventId, PicklistRoleStateEvent>();
        
        private Iterable<PicklistRoleStateEvent> readOnlyPicklistRoleEvents;

        public Iterable<PicklistRoleStateEvent> getPicklistRoleEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.picklistRoleEvents.values();
            }
            else
            {
                if (readOnlyPicklistRoleEvents != null) { return readOnlyPicklistRoleEvents; }
                PicklistRoleStateEventDao eventDao = getPicklistRoleStateEventDao();
                List<PicklistRoleStateEvent> eL = new ArrayList<PicklistRoleStateEvent>();
                for (PicklistRoleStateEvent e : eventDao.findByPicklistEventId(this.getPicklistEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((PicklistRoleStateEvent)e);
                }
                return (readOnlyPicklistRoleEvents = eL);
            }
        }

        public void setPicklistRoleEvents(Iterable<PicklistRoleStateEvent> es)
        {
            if (es != null)
            {
                for (PicklistRoleStateEvent e : es)
                {
                    addPicklistRoleEvent(e);
                }
            }
            else { this.picklistRoleEvents.clear(); }
        }
        
        public void addPicklistRoleEvent(PicklistRoleStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistRoleEvents.put(e.getPicklistRoleEventId(), e);
        }

        public void save()
        {
            for (PicklistRoleStateEvent e : this.getPicklistRoleEvents()) {
                getPicklistRoleStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistStateDeleted extends AbstractPicklistStateEvent implements PicklistStateEvent.PicklistStateDeleted, Saveable
    {
        public AbstractPicklistStateDeleted() {
            this(new PicklistEventId());
        }

        public AbstractPicklistStateDeleted(PicklistEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<PicklistRoleEventId, PicklistRoleStateEvent.PicklistRoleStateRemoved> picklistRoleEvents = new HashMap<PicklistRoleEventId, PicklistRoleStateEvent.PicklistRoleStateRemoved>();
        
        private Iterable<PicklistRoleStateEvent.PicklistRoleStateRemoved> readOnlyPicklistRoleEvents;

        public Iterable<PicklistRoleStateEvent.PicklistRoleStateRemoved> getPicklistRoleEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.picklistRoleEvents.values();
            }
            else
            {
                if (readOnlyPicklistRoleEvents != null) { return readOnlyPicklistRoleEvents; }
                PicklistRoleStateEventDao eventDao = getPicklistRoleStateEventDao();
                List<PicklistRoleStateEvent.PicklistRoleStateRemoved> eL = new ArrayList<PicklistRoleStateEvent.PicklistRoleStateRemoved>();
                for (PicklistRoleStateEvent e : eventDao.findByPicklistEventId(this.getPicklistEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((PicklistRoleStateEvent.PicklistRoleStateRemoved)e);
                }
                return (readOnlyPicklistRoleEvents = eL);
            }
        }

        public void setPicklistRoleEvents(Iterable<PicklistRoleStateEvent.PicklistRoleStateRemoved> es)
        {
            if (es != null)
            {
                for (PicklistRoleStateEvent.PicklistRoleStateRemoved e : es)
                {
                    addPicklistRoleEvent(e);
                }
            }
            else { this.picklistRoleEvents.clear(); }
        }
        
        public void addPicklistRoleEvent(PicklistRoleStateEvent.PicklistRoleStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistRoleEvents.put(e.getPicklistRoleEventId(), e);
        }

        public void save()
        {
            for (PicklistRoleStateEvent.PicklistRoleStateRemoved e : this.getPicklistRoleEvents()) {
                getPicklistRoleStateEventDao().save(e);
            }
        }
    }
    public static class SimplePicklistStateCreated extends AbstractPicklistStateCreated
    {
        public SimplePicklistStateCreated() {
        }

        public SimplePicklistStateCreated(PicklistEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistStateMergePatched extends AbstractPicklistStateMergePatched
    {
        public SimplePicklistStateMergePatched() {
        }

        public SimplePicklistStateMergePatched(PicklistEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistStateDeleted extends AbstractPicklistStateDeleted
    {
        public SimplePicklistStateDeleted() {
        }

        public SimplePicklistStateDeleted(PicklistEventId eventId) {
            super(eventId);
        }
    }

}

