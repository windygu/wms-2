package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPicklistBinStateEvent extends AbstractStateEvent implements PicklistBinStateEvent 
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

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private Long primaryShipGroupSeqId;

    public Long getPrimaryShipGroupSeqId()
    {
        return this.primaryShipGroupSeqId;
    }

    public void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId)
    {
        this.primaryShipGroupSeqId = primaryShipGroupSeqId;
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

    protected AbstractPicklistBinStateEvent() {
    }

    protected AbstractPicklistBinStateEvent(PicklistBinEventId eventId) {
        this.picklistBinEventId = eventId;
    }

    protected PicklistItemStateEventDao getPicklistItemStateEventDao() {
        return (PicklistItemStateEventDao)ApplicationContext.current.get("PicklistItemStateEventDao");
    }

    protected PicklistItemEventId newPicklistItemEventId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
    {
        PicklistItemEventId eventId = new PicklistItemEventId(this.getPicklistBinEventId().getPicklistBinId(), 
            picklistItemOrderShipGrpInvId, 
            this.getPicklistBinEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(PicklistItemStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(PicklistBinStateEvent oe, PicklistItemStateEvent e)
    {
        if (!oe.getPicklistBinEventId().getPicklistBinId().equals(e.getPicklistItemEventId().getPicklistBinId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id PicklistBinId %1$s but inner id PicklistBinId %2$s", 
                oe.getPicklistBinEventId().getPicklistBinId(), e.getPicklistItemEventId().getPicklistBinId());
        }
    }

    public PicklistItemStateEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return new AbstractPicklistItemStateEvent.SimplePicklistItemStateCreated(newPicklistItemEventId(picklistItemOrderShipGrpInvId));
    }

    public PicklistItemStateEvent.PicklistItemStateMergePatched newPicklistItemStateMergePatched(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return new AbstractPicklistItemStateEvent.SimplePicklistItemStateMergePatched(newPicklistItemEventId(picklistItemOrderShipGrpInvId));
    }

    public PicklistItemStateEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return new AbstractPicklistItemStateEvent.SimplePicklistItemStateRemoved(newPicklistItemEventId(picklistItemOrderShipGrpInvId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPicklistBinStateCreated extends AbstractPicklistBinStateEvent implements PicklistBinStateEvent.PicklistBinStateCreated, Saveable
    {
        public AbstractPicklistBinStateCreated() {
            this(new PicklistBinEventId());
        }

        public AbstractPicklistBinStateCreated(PicklistBinEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<PicklistItemEventId, PicklistItemStateEvent.PicklistItemStateCreated> picklistItemEvents = new HashMap<PicklistItemEventId, PicklistItemStateEvent.PicklistItemStateCreated>();
        
        private Iterable<PicklistItemStateEvent.PicklistItemStateCreated> readOnlyPicklistItemEvents;

        public Iterable<PicklistItemStateEvent.PicklistItemStateCreated> getPicklistItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.picklistItemEvents.values();
            }
            else
            {
                if (readOnlyPicklistItemEvents != null) { return readOnlyPicklistItemEvents; }
                PicklistItemStateEventDao eventDao = getPicklistItemStateEventDao();
                List<PicklistItemStateEvent.PicklistItemStateCreated> eL = new ArrayList<PicklistItemStateEvent.PicklistItemStateCreated>();
                for (PicklistItemStateEvent e : eventDao.findByPicklistBinEventId(this.getPicklistBinEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((PicklistItemStateEvent.PicklistItemStateCreated)e);
                }
                return (readOnlyPicklistItemEvents = eL);
            }
        }

        public void setPicklistItemEvents(Iterable<PicklistItemStateEvent.PicklistItemStateCreated> es)
        {
            if (es != null)
            {
                for (PicklistItemStateEvent.PicklistItemStateCreated e : es)
                {
                    addPicklistItemEvent(e);
                }
            }
            else { this.picklistItemEvents.clear(); }
        }
        
        public void addPicklistItemEvent(PicklistItemStateEvent.PicklistItemStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistItemEvents.put(e.getPicklistItemEventId(), e);
        }

        public void save()
        {
            for (PicklistItemStateEvent.PicklistItemStateCreated e : this.getPicklistItemEvents()) {
                getPicklistItemStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistBinStateMergePatched extends AbstractPicklistBinStateEvent implements PicklistBinStateEvent.PicklistBinStateMergePatched, Saveable
    {
        public AbstractPicklistBinStateMergePatched() {
            this(new PicklistBinEventId());
        }

        public AbstractPicklistBinStateMergePatched(PicklistBinEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

        private Map<PicklistItemEventId, PicklistItemStateEvent> picklistItemEvents = new HashMap<PicklistItemEventId, PicklistItemStateEvent>();
        
        private Iterable<PicklistItemStateEvent> readOnlyPicklistItemEvents;

        public Iterable<PicklistItemStateEvent> getPicklistItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.picklistItemEvents.values();
            }
            else
            {
                if (readOnlyPicklistItemEvents != null) { return readOnlyPicklistItemEvents; }
                PicklistItemStateEventDao eventDao = getPicklistItemStateEventDao();
                List<PicklistItemStateEvent> eL = new ArrayList<PicklistItemStateEvent>();
                for (PicklistItemStateEvent e : eventDao.findByPicklistBinEventId(this.getPicklistBinEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((PicklistItemStateEvent)e);
                }
                return (readOnlyPicklistItemEvents = eL);
            }
        }

        public void setPicklistItemEvents(Iterable<PicklistItemStateEvent> es)
        {
            if (es != null)
            {
                for (PicklistItemStateEvent e : es)
                {
                    addPicklistItemEvent(e);
                }
            }
            else { this.picklistItemEvents.clear(); }
        }
        
        public void addPicklistItemEvent(PicklistItemStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistItemEvents.put(e.getPicklistItemEventId(), e);
        }

        public void save()
        {
            for (PicklistItemStateEvent e : this.getPicklistItemEvents()) {
                getPicklistItemStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPicklistBinStateDeleted extends AbstractPicklistBinStateEvent implements PicklistBinStateEvent.PicklistBinStateDeleted, Saveable
    {
        public AbstractPicklistBinStateDeleted() {
            this(new PicklistBinEventId());
        }

        public AbstractPicklistBinStateDeleted(PicklistBinEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<PicklistItemEventId, PicklistItemStateEvent.PicklistItemStateRemoved> picklistItemEvents = new HashMap<PicklistItemEventId, PicklistItemStateEvent.PicklistItemStateRemoved>();
        
        private Iterable<PicklistItemStateEvent.PicklistItemStateRemoved> readOnlyPicklistItemEvents;

        public Iterable<PicklistItemStateEvent.PicklistItemStateRemoved> getPicklistItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.picklistItemEvents.values();
            }
            else
            {
                if (readOnlyPicklistItemEvents != null) { return readOnlyPicklistItemEvents; }
                PicklistItemStateEventDao eventDao = getPicklistItemStateEventDao();
                List<PicklistItemStateEvent.PicklistItemStateRemoved> eL = new ArrayList<PicklistItemStateEvent.PicklistItemStateRemoved>();
                for (PicklistItemStateEvent e : eventDao.findByPicklistBinEventId(this.getPicklistBinEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((PicklistItemStateEvent.PicklistItemStateRemoved)e);
                }
                return (readOnlyPicklistItemEvents = eL);
            }
        }

        public void setPicklistItemEvents(Iterable<PicklistItemStateEvent.PicklistItemStateRemoved> es)
        {
            if (es != null)
            {
                for (PicklistItemStateEvent.PicklistItemStateRemoved e : es)
                {
                    addPicklistItemEvent(e);
                }
            }
            else { this.picklistItemEvents.clear(); }
        }
        
        public void addPicklistItemEvent(PicklistItemStateEvent.PicklistItemStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.picklistItemEvents.put(e.getPicklistItemEventId(), e);
        }

        public void save()
        {
            for (PicklistItemStateEvent.PicklistItemStateRemoved e : this.getPicklistItemEvents()) {
                getPicklistItemStateEventDao().save(e);
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

