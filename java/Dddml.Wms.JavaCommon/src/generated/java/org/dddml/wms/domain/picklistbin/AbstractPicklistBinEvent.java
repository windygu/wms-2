package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPicklistBinEvent extends AbstractEvent implements PicklistBinEvent.SqlPicklistBinEvent 
{
    private PicklistBinEventId picklistBinEventId;

    public PicklistBinEventId getPicklistBinEventId() {
        return this.picklistBinEventId;
    }

    public void setPicklistBinEventId(PicklistBinEventId eventId) {
        this.picklistBinEventId = eventId;
    }
    
    public String getPicklistBinId() {
        return getPicklistBinEventId().getPicklistBinId();
    }

    public void setPicklistBinId(String picklistBinId) {
        getPicklistBinEventId().setPicklistBinId(picklistBinId);
    }

    public Long getVersion() {
        return getPicklistBinEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getPicklistBinEventId().setVersion(version);
    //}

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractPicklistBinEvent() {
    }

    protected AbstractPicklistBinEvent(PicklistBinEventId eventId) {
        this.picklistBinEventId = eventId;
    }

    protected PicklistItemEventDao getPicklistItemEventDao() {
        return (PicklistItemEventDao)ApplicationContext.current.get("PicklistItemEventDao");
    }

    protected PicklistItemEventId newPicklistItemEventId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
    {
        PicklistItemEventId eventId = new PicklistItemEventId(this.getPicklistBinEventId().getPicklistBinId(), 
            picklistItemOrderShipGrpInvId, 
            this.getPicklistBinEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(PicklistItemEvent.SqlPicklistItemEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(PicklistBinEvent.SqlPicklistBinEvent oe, PicklistItemEvent.SqlPicklistItemEvent e)
    {
        if (!oe.getPicklistBinEventId().getPicklistBinId().equals(e.getPicklistItemEventId().getPicklistBinId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id PicklistBinId %1$s but inner id PicklistBinId %2$s", 
                oe.getPicklistBinEventId().getPicklistBinId(), e.getPicklistItemEventId().getPicklistBinId());
        }
    }

    public PicklistItemEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return new AbstractPicklistItemEvent.SimplePicklistItemStateCreated(newPicklistItemEventId(picklistItemOrderShipGrpInvId));
    }

    public PicklistItemEvent.PicklistItemStateMergePatched newPicklistItemStateMergePatched(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return new AbstractPicklistItemEvent.SimplePicklistItemStateMergePatched(newPicklistItemEventId(picklistItemOrderShipGrpInvId));
    }

    public PicklistItemEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return new AbstractPicklistItemEvent.SimplePicklistItemStateRemoved(newPicklistItemEventId(picklistItemOrderShipGrpInvId));
    }


    public abstract String getEventType();


    public static abstract class AbstractPicklistBinStateEvent extends AbstractPicklistBinEvent implements PicklistBinEvent.PicklistBinStateEvent {
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractPicklistBinStateEvent(PicklistBinEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPicklistBinStateCreated extends AbstractPicklistBinStateEvent implements PicklistBinEvent.PicklistBinStateCreated, Saveable
    {
        public AbstractPicklistBinStateCreated() {
            this(new PicklistBinEventId());
        }

        public AbstractPicklistBinStateCreated(PicklistBinEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<PicklistItemEventId, PicklistItemEvent.PicklistItemStateCreated> picklistItemEvents = new HashMap<PicklistItemEventId, PicklistItemEvent.PicklistItemStateCreated>();
        
        private Iterable<PicklistItemEvent.PicklistItemStateCreated> readOnlyPicklistItemEvents;

        public Iterable<PicklistItemEvent.PicklistItemStateCreated> getPicklistItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.picklistItemEvents.values();
            }
            else
            {
                if (readOnlyPicklistItemEvents != null) { return readOnlyPicklistItemEvents; }
                PicklistItemEventDao eventDao = getPicklistItemEventDao();
                List<PicklistItemEvent.PicklistItemStateCreated> eL = new ArrayList<PicklistItemEvent.PicklistItemStateCreated>();
                for (PicklistItemEvent e : eventDao.findByPicklistBinEventId(this.getPicklistBinEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PicklistItemEvent.PicklistItemStateCreated)e);
                }
                return (readOnlyPicklistItemEvents = eL);
            }
        }

        public void setPicklistItemEvents(Iterable<PicklistItemEvent.PicklistItemStateCreated> es)
        {
            if (es != null)
            {
                for (PicklistItemEvent.PicklistItemStateCreated e : es)
                {
                    addPicklistItemEvent(e);
                }
            }
            else { this.picklistItemEvents.clear(); }
        }
        
        public void addPicklistItemEvent(PicklistItemEvent.PicklistItemStateCreated e)
        {
            throwOnInconsistentEventIds((PicklistItemEvent.SqlPicklistItemEvent)e);
            this.picklistItemEvents.put(((PicklistItemEvent.SqlPicklistItemEvent)e).getPicklistItemEventId(), e);
        }

        public void save()
        {
            for (PicklistItemEvent.PicklistItemStateCreated e : this.getPicklistItemEvents()) {
                getPicklistItemEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistBinStateMergePatched extends AbstractPicklistBinStateEvent implements PicklistBinEvent.PicklistBinStateMergePatched, Saveable
    {
        public AbstractPicklistBinStateMergePatched() {
            this(new PicklistBinEventId());
        }

        public AbstractPicklistBinStateMergePatched(PicklistBinEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyPicklistIdRemoved;

        public Boolean getIsPropertyPicklistIdRemoved() {
            return this.isPropertyPicklistIdRemoved;
        }

        public void setIsPropertyPicklistIdRemoved(Boolean removed) {
            this.isPropertyPicklistIdRemoved = removed;
        }

        private Boolean isPropertyBinLocationNumberRemoved;

        public Boolean getIsPropertyBinLocationNumberRemoved() {
            return this.isPropertyBinLocationNumberRemoved;
        }

        public void setIsPropertyBinLocationNumberRemoved(Boolean removed) {
            this.isPropertyBinLocationNumberRemoved = removed;
        }

        private Boolean isPropertyPrimaryOrderIdRemoved;

        public Boolean getIsPropertyPrimaryOrderIdRemoved() {
            return this.isPropertyPrimaryOrderIdRemoved;
        }

        public void setIsPropertyPrimaryOrderIdRemoved(Boolean removed) {
            this.isPropertyPrimaryOrderIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryShipGroupSeqIdRemoved;

        public Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved() {
            return this.isPropertyPrimaryShipGroupSeqIdRemoved;
        }

        public void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed) {
            this.isPropertyPrimaryShipGroupSeqIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<PicklistItemEventId, PicklistItemEvent> picklistItemEvents = new HashMap<PicklistItemEventId, PicklistItemEvent>();
        
        private Iterable<PicklistItemEvent> readOnlyPicklistItemEvents;

        public Iterable<PicklistItemEvent> getPicklistItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.picklistItemEvents.values();
            }
            else
            {
                if (readOnlyPicklistItemEvents != null) { return readOnlyPicklistItemEvents; }
                PicklistItemEventDao eventDao = getPicklistItemEventDao();
                List<PicklistItemEvent> eL = new ArrayList<PicklistItemEvent>();
                for (PicklistItemEvent e : eventDao.findByPicklistBinEventId(this.getPicklistBinEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PicklistItemEvent)e);
                }
                return (readOnlyPicklistItemEvents = eL);
            }
        }

        public void setPicklistItemEvents(Iterable<PicklistItemEvent> es)
        {
            if (es != null)
            {
                for (PicklistItemEvent e : es)
                {
                    addPicklistItemEvent(e);
                }
            }
            else { this.picklistItemEvents.clear(); }
        }
        
        public void addPicklistItemEvent(PicklistItemEvent e)
        {
            throwOnInconsistentEventIds((PicklistItemEvent.SqlPicklistItemEvent)e);
            this.picklistItemEvents.put(((PicklistItemEvent.SqlPicklistItemEvent)e).getPicklistItemEventId(), e);
        }

        public void save()
        {
            for (PicklistItemEvent e : this.getPicklistItemEvents()) {
                getPicklistItemEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistBinStateDeleted extends AbstractPicklistBinStateEvent implements PicklistBinEvent.PicklistBinStateDeleted, Saveable
    {
        public AbstractPicklistBinStateDeleted() {
            this(new PicklistBinEventId());
        }

        public AbstractPicklistBinStateDeleted(PicklistBinEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<PicklistItemEventId, PicklistItemEvent.PicklistItemStateRemoved> picklistItemEvents = new HashMap<PicklistItemEventId, PicklistItemEvent.PicklistItemStateRemoved>();
        
        private Iterable<PicklistItemEvent.PicklistItemStateRemoved> readOnlyPicklistItemEvents;

        public Iterable<PicklistItemEvent.PicklistItemStateRemoved> getPicklistItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.picklistItemEvents.values();
            }
            else
            {
                if (readOnlyPicklistItemEvents != null) { return readOnlyPicklistItemEvents; }
                PicklistItemEventDao eventDao = getPicklistItemEventDao();
                List<PicklistItemEvent.PicklistItemStateRemoved> eL = new ArrayList<PicklistItemEvent.PicklistItemStateRemoved>();
                for (PicklistItemEvent e : eventDao.findByPicklistBinEventId(this.getPicklistBinEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PicklistItemEvent.PicklistItemStateRemoved)e);
                }
                return (readOnlyPicklistItemEvents = eL);
            }
        }

        public void setPicklistItemEvents(Iterable<PicklistItemEvent.PicklistItemStateRemoved> es)
        {
            if (es != null)
            {
                for (PicklistItemEvent.PicklistItemStateRemoved e : es)
                {
                    addPicklistItemEvent(e);
                }
            }
            else { this.picklistItemEvents.clear(); }
        }
        
        public void addPicklistItemEvent(PicklistItemEvent.PicklistItemStateRemoved e)
        {
            throwOnInconsistentEventIds((PicklistItemEvent.SqlPicklistItemEvent)e);
            this.picklistItemEvents.put(((PicklistItemEvent.SqlPicklistItemEvent)e).getPicklistItemEventId(), e);
        }

        public void save()
        {
            for (PicklistItemEvent.PicklistItemStateRemoved e : this.getPicklistItemEvents()) {
                getPicklistItemEventDao().save(e);
            }
        }
    }
    public static class SimplePicklistBinStateCreated extends AbstractPicklistBinStateCreated
    {
        public SimplePicklistBinStateCreated() {
        }

        public SimplePicklistBinStateCreated(PicklistBinEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistBinStateMergePatched extends AbstractPicklistBinStateMergePatched
    {
        public SimplePicklistBinStateMergePatched() {
        }

        public SimplePicklistBinStateMergePatched(PicklistBinEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistBinStateDeleted extends AbstractPicklistBinStateDeleted
    {
        public SimplePicklistBinStateDeleted() {
        }

        public SimplePicklistBinStateDeleted(PicklistBinEventId eventId) {
            super(eventId);
        }
    }

}

