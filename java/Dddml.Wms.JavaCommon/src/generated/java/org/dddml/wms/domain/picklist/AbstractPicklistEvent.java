package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPicklistEvent extends AbstractEvent implements PicklistEvent 
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

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractPicklistEvent() {
    }

    protected AbstractPicklistEvent(PicklistEventId eventId) {
        this.picklistEventId = eventId;
    }

    protected PicklistRoleEventDao getPicklistRoleEventDao() {
        return (PicklistRoleEventDao)ApplicationContext.current.get("PicklistRoleEventDao");
    }

    protected PicklistRoleEventId newPicklistRoleEventId(PartyRoleId partyRoleId)
    {
        PicklistRoleEventId eventId = new PicklistRoleEventId(this.getPicklistEventId().getPicklistId(), 
            partyRoleId, 
            this.getPicklistEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(PicklistRoleEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(PicklistEvent oe, PicklistRoleEvent e)
    {
        if (!oe.getPicklistEventId().getPicklistId().equals(e.getPicklistRoleEventId().getPicklistId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id PicklistId %1$s but inner id PicklistId %2$s", 
                oe.getPicklistEventId().getPicklistId(), e.getPicklistRoleEventId().getPicklistId());
        }
    }

    public PicklistRoleEvent.PicklistRoleStateCreated newPicklistRoleStateCreated(PartyRoleId partyRoleId) {
        return new AbstractPicklistRoleEvent.SimplePicklistRoleStateCreated(newPicklistRoleEventId(partyRoleId));
    }

    public PicklistRoleEvent.PicklistRoleStateMergePatched newPicklistRoleStateMergePatched(PartyRoleId partyRoleId) {
        return new AbstractPicklistRoleEvent.SimplePicklistRoleStateMergePatched(newPicklistRoleEventId(partyRoleId));
    }

    public PicklistRoleEvent.PicklistRoleStateRemoved newPicklistRoleStateRemoved(PartyRoleId partyRoleId) {
        return new AbstractPicklistRoleEvent.SimplePicklistRoleStateRemoved(newPicklistRoleEventId(partyRoleId));
    }


    public abstract String getEventType();


    public static abstract class AbstractPicklistStateCreated extends AbstractPicklistEvent implements PicklistEvent.PicklistStateCreated, Saveable
    {
        public AbstractPicklistStateCreated() {
            this(new PicklistEventId());
        }

        public AbstractPicklistStateCreated(PicklistEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<PicklistRoleEventId, PicklistRoleEvent.PicklistRoleStateCreated> picklistRoleEvents = new HashMap<PicklistRoleEventId, PicklistRoleEvent.PicklistRoleStateCreated>();
        
        private Iterable<PicklistRoleEvent.PicklistRoleStateCreated> readOnlyPicklistRoleEvents;

        public Iterable<PicklistRoleEvent.PicklistRoleStateCreated> getPicklistRoleEvents()
        {
            if (!getEventReadOnly())
            {
                return this.picklistRoleEvents.values();
            }
            else
            {
                if (readOnlyPicklistRoleEvents != null) { return readOnlyPicklistRoleEvents; }
                PicklistRoleEventDao eventDao = getPicklistRoleEventDao();
                List<PicklistRoleEvent.PicklistRoleStateCreated> eL = new ArrayList<PicklistRoleEvent.PicklistRoleStateCreated>();
                for (PicklistRoleEvent e : eventDao.findByPicklistEventId(this.getPicklistEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PicklistRoleEvent.PicklistRoleStateCreated)e);
                }
                return (readOnlyPicklistRoleEvents = eL);
            }
        }

        public void setPicklistRoleEvents(Iterable<PicklistRoleEvent.PicklistRoleStateCreated> es)
        {
            if (es != null)
            {
                for (PicklistRoleEvent.PicklistRoleStateCreated e : es)
                {
                    addPicklistRoleEvent(e);
                }
            }
            else { this.picklistRoleEvents.clear(); }
        }
        
        public void addPicklistRoleEvent(PicklistRoleEvent.PicklistRoleStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistRoleEvents.put(e.getPicklistRoleEventId(), e);
        }

        public void save()
        {
            for (PicklistRoleEvent.PicklistRoleStateCreated e : this.getPicklistRoleEvents()) {
                getPicklistRoleEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistStateMergePatched extends AbstractPicklistEvent implements PicklistEvent.PicklistStateMergePatched, Saveable
    {
        public AbstractPicklistStateMergePatched() {
            this(new PicklistEventId());
        }

        public AbstractPicklistStateMergePatched(PicklistEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

        private Map<PicklistRoleEventId, PicklistRoleEvent> picklistRoleEvents = new HashMap<PicklistRoleEventId, PicklistRoleEvent>();
        
        private Iterable<PicklistRoleEvent> readOnlyPicklistRoleEvents;

        public Iterable<PicklistRoleEvent> getPicklistRoleEvents()
        {
            if (!getEventReadOnly())
            {
                return this.picklistRoleEvents.values();
            }
            else
            {
                if (readOnlyPicklistRoleEvents != null) { return readOnlyPicklistRoleEvents; }
                PicklistRoleEventDao eventDao = getPicklistRoleEventDao();
                List<PicklistRoleEvent> eL = new ArrayList<PicklistRoleEvent>();
                for (PicklistRoleEvent e : eventDao.findByPicklistEventId(this.getPicklistEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PicklistRoleEvent)e);
                }
                return (readOnlyPicklistRoleEvents = eL);
            }
        }

        public void setPicklistRoleEvents(Iterable<PicklistRoleEvent> es)
        {
            if (es != null)
            {
                for (PicklistRoleEvent e : es)
                {
                    addPicklistRoleEvent(e);
                }
            }
            else { this.picklistRoleEvents.clear(); }
        }
        
        public void addPicklistRoleEvent(PicklistRoleEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistRoleEvents.put(e.getPicklistRoleEventId(), e);
        }

        public void save()
        {
            for (PicklistRoleEvent e : this.getPicklistRoleEvents()) {
                getPicklistRoleEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistStateDeleted extends AbstractPicklistEvent implements PicklistEvent.PicklistStateDeleted, Saveable
    {
        public AbstractPicklistStateDeleted() {
            this(new PicklistEventId());
        }

        public AbstractPicklistStateDeleted(PicklistEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<PicklistRoleEventId, PicklistRoleEvent.PicklistRoleStateRemoved> picklistRoleEvents = new HashMap<PicklistRoleEventId, PicklistRoleEvent.PicklistRoleStateRemoved>();
        
        private Iterable<PicklistRoleEvent.PicklistRoleStateRemoved> readOnlyPicklistRoleEvents;

        public Iterable<PicklistRoleEvent.PicklistRoleStateRemoved> getPicklistRoleEvents()
        {
            if (!getEventReadOnly())
            {
                return this.picklistRoleEvents.values();
            }
            else
            {
                if (readOnlyPicklistRoleEvents != null) { return readOnlyPicklistRoleEvents; }
                PicklistRoleEventDao eventDao = getPicklistRoleEventDao();
                List<PicklistRoleEvent.PicklistRoleStateRemoved> eL = new ArrayList<PicklistRoleEvent.PicklistRoleStateRemoved>();
                for (PicklistRoleEvent e : eventDao.findByPicklistEventId(this.getPicklistEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PicklistRoleEvent.PicklistRoleStateRemoved)e);
                }
                return (readOnlyPicklistRoleEvents = eL);
            }
        }

        public void setPicklistRoleEvents(Iterable<PicklistRoleEvent.PicklistRoleStateRemoved> es)
        {
            if (es != null)
            {
                for (PicklistRoleEvent.PicklistRoleStateRemoved e : es)
                {
                    addPicklistRoleEvent(e);
                }
            }
            else { this.picklistRoleEvents.clear(); }
        }
        
        public void addPicklistRoleEvent(PicklistRoleEvent.PicklistRoleStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistRoleEvents.put(e.getPicklistRoleEventId(), e);
        }

        public void save()
        {
            for (PicklistRoleEvent.PicklistRoleStateRemoved e : this.getPicklistRoleEvents()) {
                getPicklistRoleEventDao().save(e);
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

