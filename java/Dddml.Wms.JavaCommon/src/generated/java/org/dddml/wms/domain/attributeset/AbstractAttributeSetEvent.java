package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractAttributeSetEvent extends AbstractEvent implements AttributeSetEvent.SqlAttributeSetEvent 
{
    private AttributeSetEventId attributeSetEventId;

    public AttributeSetEventId getAttributeSetEventId() {
        return this.attributeSetEventId;
    }

    public void setAttributeSetEventId(AttributeSetEventId eventId) {
        this.attributeSetEventId = eventId;
    }
    
    public String getAttributeSetId() {
        return getAttributeSetEventId().getAttributeSetId();
    }

    public void setAttributeSetId(String attributeSetId) {
        getAttributeSetEventId().setAttributeSetId(attributeSetId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getAttributeSetEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getAttributeSetEventId().setVersion(version);
    //}

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

    protected AbstractAttributeSetEvent() {
    }

    protected AbstractAttributeSetEvent(AttributeSetEventId eventId) {
        this.attributeSetEventId = eventId;
    }

    protected AttributeUseEventDao getAttributeUseEventDao() {
        return (AttributeUseEventDao)ApplicationContext.current.get("AttributeUseEventDao");
    }

    protected AttributeUseEventId newAttributeUseEventId(String attributeId)
    {
        AttributeUseEventId eventId = new AttributeUseEventId(this.getAttributeSetEventId().getAttributeSetId(), 
            attributeId, 
            this.getAttributeSetEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(AttributeUseEvent.SqlAttributeUseEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(AttributeSetEvent.SqlAttributeSetEvent oe, AttributeUseEvent.SqlAttributeUseEvent e)
    {
        if (!oe.getAttributeSetEventId().getAttributeSetId().equals(e.getAttributeUseEventId().getAttributeSetId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id AttributeSetId %1$s but inner id AttributeSetId %2$s", 
                oe.getAttributeSetEventId().getAttributeSetId(), e.getAttributeUseEventId().getAttributeSetId());
        }
    }

    public AttributeUseEvent.AttributeUseStateCreated newAttributeUseStateCreated(String attributeId) {
        return new AbstractAttributeUseEvent.SimpleAttributeUseStateCreated(newAttributeUseEventId(attributeId));
    }

    public AttributeUseEvent.AttributeUseStateMergePatched newAttributeUseStateMergePatched(String attributeId) {
        return new AbstractAttributeUseEvent.SimpleAttributeUseStateMergePatched(newAttributeUseEventId(attributeId));
    }

    public AttributeUseEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(String attributeId) {
        return new AbstractAttributeUseEvent.SimpleAttributeUseStateRemoved(newAttributeUseEventId(attributeId));
    }


    public abstract String getEventType();


    public static abstract class AbstractAttributeSetStateEvent extends AbstractAttributeSetEvent implements AttributeSetEvent.AttributeSetStateEvent {
        private String attributeSetName;

        public String getAttributeSetName()
        {
            return this.attributeSetName;
        }

        public void setAttributeSetName(String attributeSetName)
        {
            this.attributeSetName = attributeSetName;
        }

        private String organizationId;

        public String getOrganizationId()
        {
            return this.organizationId;
        }

        public void setOrganizationId(String organizationId)
        {
            this.organizationId = organizationId;
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

        private String referenceId;

        public String getReferenceId()
        {
            return this.referenceId;
        }

        public void setReferenceId(String referenceId)
        {
            this.referenceId = referenceId;
        }

        private Boolean isInstanceAttributeSet;

        public Boolean getIsInstanceAttributeSet()
        {
            return this.isInstanceAttributeSet;
        }

        public void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet)
        {
            this.isInstanceAttributeSet = isInstanceAttributeSet;
        }

        private Boolean isMandatory;

        public Boolean getIsMandatory()
        {
            return this.isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory)
        {
            this.isMandatory = isMandatory;
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

        protected AbstractAttributeSetStateEvent(AttributeSetEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractAttributeSetStateCreated extends AbstractAttributeSetStateEvent implements AttributeSetEvent.AttributeSetStateCreated, Saveable
    {
        public AbstractAttributeSetStateCreated() {
            this(new AttributeSetEventId());
        }

        public AbstractAttributeSetStateCreated(AttributeSetEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<AttributeUseEventId, AttributeUseEvent.AttributeUseStateCreated> attributeUseEvents = new HashMap<AttributeUseEventId, AttributeUseEvent.AttributeUseStateCreated>();
        
        private Iterable<AttributeUseEvent.AttributeUseStateCreated> readOnlyAttributeUseEvents;

        public Iterable<AttributeUseEvent.AttributeUseStateCreated> getAttributeUseEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeUseEvents.values();
            }
            else
            {
                if (readOnlyAttributeUseEvents != null) { return readOnlyAttributeUseEvents; }
                AttributeUseEventDao eventDao = getAttributeUseEventDao();
                List<AttributeUseEvent.AttributeUseStateCreated> eL = new ArrayList<AttributeUseEvent.AttributeUseStateCreated>();
                for (AttributeUseEvent e : eventDao.findByAttributeSetEventId(this.getAttributeSetEventId()))
                {
                    ((AttributeUseEvent.SqlAttributeUseEvent)e).setEventReadOnly(true);
                    eL.add((AttributeUseEvent.AttributeUseStateCreated)e);
                }
                return (readOnlyAttributeUseEvents = eL);
            }
        }

        public void setAttributeUseEvents(Iterable<AttributeUseEvent.AttributeUseStateCreated> es)
        {
            if (es != null)
            {
                for (AttributeUseEvent.AttributeUseStateCreated e : es)
                {
                    addAttributeUseEvent(e);
                }
            }
            else { this.attributeUseEvents.clear(); }
        }
        
        public void addAttributeUseEvent(AttributeUseEvent.AttributeUseStateCreated e)
        {
            throwOnInconsistentEventIds((AttributeUseEvent.SqlAttributeUseEvent)e);
            this.attributeUseEvents.put(((AttributeUseEvent.SqlAttributeUseEvent)e).getAttributeUseEventId(), e);
        }

        public void save()
        {
            for (AttributeUseEvent.AttributeUseStateCreated e : this.getAttributeUseEvents()) {
                getAttributeUseEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeSetStateMergePatched extends AbstractAttributeSetStateEvent implements AttributeSetEvent.AttributeSetStateMergePatched, Saveable
    {
        public AbstractAttributeSetStateMergePatched() {
            this(new AttributeSetEventId());
        }

        public AbstractAttributeSetStateMergePatched(AttributeSetEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyAttributeSetNameRemoved;

        public Boolean getIsPropertyAttributeSetNameRemoved() {
            return this.isPropertyAttributeSetNameRemoved;
        }

        public void setIsPropertyAttributeSetNameRemoved(Boolean removed) {
            this.isPropertyAttributeSetNameRemoved = removed;
        }

        private Boolean isPropertyOrganizationIdRemoved;

        public Boolean getIsPropertyOrganizationIdRemoved() {
            return this.isPropertyOrganizationIdRemoved;
        }

        public void setIsPropertyOrganizationIdRemoved(Boolean removed) {
            this.isPropertyOrganizationIdRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyReferenceIdRemoved;

        public Boolean getIsPropertyReferenceIdRemoved() {
            return this.isPropertyReferenceIdRemoved;
        }

        public void setIsPropertyReferenceIdRemoved(Boolean removed) {
            this.isPropertyReferenceIdRemoved = removed;
        }

        private Boolean isPropertyIsInstanceAttributeSetRemoved;

        public Boolean getIsPropertyIsInstanceAttributeSetRemoved() {
            return this.isPropertyIsInstanceAttributeSetRemoved;
        }

        public void setIsPropertyIsInstanceAttributeSetRemoved(Boolean removed) {
            this.isPropertyIsInstanceAttributeSetRemoved = removed;
        }

        private Boolean isPropertyIsMandatoryRemoved;

        public Boolean getIsPropertyIsMandatoryRemoved() {
            return this.isPropertyIsMandatoryRemoved;
        }

        public void setIsPropertyIsMandatoryRemoved(Boolean removed) {
            this.isPropertyIsMandatoryRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<AttributeUseEventId, AttributeUseEvent> attributeUseEvents = new HashMap<AttributeUseEventId, AttributeUseEvent>();
        
        private Iterable<AttributeUseEvent> readOnlyAttributeUseEvents;

        public Iterable<AttributeUseEvent> getAttributeUseEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeUseEvents.values();
            }
            else
            {
                if (readOnlyAttributeUseEvents != null) { return readOnlyAttributeUseEvents; }
                AttributeUseEventDao eventDao = getAttributeUseEventDao();
                List<AttributeUseEvent> eL = new ArrayList<AttributeUseEvent>();
                for (AttributeUseEvent e : eventDao.findByAttributeSetEventId(this.getAttributeSetEventId()))
                {
                    ((AttributeUseEvent.SqlAttributeUseEvent)e).setEventReadOnly(true);
                    eL.add((AttributeUseEvent)e);
                }
                return (readOnlyAttributeUseEvents = eL);
            }
        }

        public void setAttributeUseEvents(Iterable<AttributeUseEvent> es)
        {
            if (es != null)
            {
                for (AttributeUseEvent e : es)
                {
                    addAttributeUseEvent(e);
                }
            }
            else { this.attributeUseEvents.clear(); }
        }
        
        public void addAttributeUseEvent(AttributeUseEvent e)
        {
            throwOnInconsistentEventIds((AttributeUseEvent.SqlAttributeUseEvent)e);
            this.attributeUseEvents.put(((AttributeUseEvent.SqlAttributeUseEvent)e).getAttributeUseEventId(), e);
        }

        public void save()
        {
            for (AttributeUseEvent e : this.getAttributeUseEvents()) {
                getAttributeUseEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeSetStateDeleted extends AbstractAttributeSetStateEvent implements AttributeSetEvent.AttributeSetStateDeleted, Saveable
    {
        public AbstractAttributeSetStateDeleted() {
            this(new AttributeSetEventId());
        }

        public AbstractAttributeSetStateDeleted(AttributeSetEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<AttributeUseEventId, AttributeUseEvent.AttributeUseStateRemoved> attributeUseEvents = new HashMap<AttributeUseEventId, AttributeUseEvent.AttributeUseStateRemoved>();
        
        private Iterable<AttributeUseEvent.AttributeUseStateRemoved> readOnlyAttributeUseEvents;

        public Iterable<AttributeUseEvent.AttributeUseStateRemoved> getAttributeUseEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeUseEvents.values();
            }
            else
            {
                if (readOnlyAttributeUseEvents != null) { return readOnlyAttributeUseEvents; }
                AttributeUseEventDao eventDao = getAttributeUseEventDao();
                List<AttributeUseEvent.AttributeUseStateRemoved> eL = new ArrayList<AttributeUseEvent.AttributeUseStateRemoved>();
                for (AttributeUseEvent e : eventDao.findByAttributeSetEventId(this.getAttributeSetEventId()))
                {
                    ((AttributeUseEvent.SqlAttributeUseEvent)e).setEventReadOnly(true);
                    eL.add((AttributeUseEvent.AttributeUseStateRemoved)e);
                }
                return (readOnlyAttributeUseEvents = eL);
            }
        }

        public void setAttributeUseEvents(Iterable<AttributeUseEvent.AttributeUseStateRemoved> es)
        {
            if (es != null)
            {
                for (AttributeUseEvent.AttributeUseStateRemoved e : es)
                {
                    addAttributeUseEvent(e);
                }
            }
            else { this.attributeUseEvents.clear(); }
        }
        
        public void addAttributeUseEvent(AttributeUseEvent.AttributeUseStateRemoved e)
        {
            throwOnInconsistentEventIds((AttributeUseEvent.SqlAttributeUseEvent)e);
            this.attributeUseEvents.put(((AttributeUseEvent.SqlAttributeUseEvent)e).getAttributeUseEventId(), e);
        }

        public void save()
        {
            for (AttributeUseEvent.AttributeUseStateRemoved e : this.getAttributeUseEvents()) {
                getAttributeUseEventDao().save(e);
            }
        }
    }
    public static class SimpleAttributeSetStateCreated extends AbstractAttributeSetStateCreated
    {
        public SimpleAttributeSetStateCreated() {
        }

        public SimpleAttributeSetStateCreated(AttributeSetEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeSetStateMergePatched extends AbstractAttributeSetStateMergePatched
    {
        public SimpleAttributeSetStateMergePatched() {
        }

        public SimpleAttributeSetStateMergePatched(AttributeSetEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeSetStateDeleted extends AbstractAttributeSetStateDeleted
    {
        public SimpleAttributeSetStateDeleted() {
        }

        public SimpleAttributeSetStateDeleted(AttributeSetEventId eventId) {
            super(eventId);
        }
    }

}

