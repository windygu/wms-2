package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractAttributeSetStateEvent extends AbstractStateEvent implements AttributeSetStateEvent 
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

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractAttributeSetStateEvent() {
    }

    protected AbstractAttributeSetStateEvent(AttributeSetEventId eventId) {
        this.attributeSetEventId = eventId;
    }

    protected AttributeUseStateEventDao getAttributeUseStateEventDao() {
        return (AttributeUseStateEventDao)ApplicationContext.current.get("AttributeUseStateEventDao");
    }

    protected AttributeUseEventId newAttributeUseEventId(String attributeId)
    {
        AttributeUseEventId eventId = new AttributeUseEventId(this.getAttributeSetEventId().getAttributeSetId(), 
            attributeId, 
            this.getAttributeSetEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(AttributeUseStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(AttributeSetStateEvent oe, AttributeUseStateEvent e)
    {
        if (!oe.getAttributeSetEventId().getAttributeSetId().equals(e.getAttributeUseEventId().getAttributeSetId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id AttributeSetId %1$s but inner id AttributeSetId %2$s", 
                oe.getAttributeSetEventId().getAttributeSetId(), e.getAttributeUseEventId().getAttributeSetId());
        }
    }

    public AttributeUseStateEvent.AttributeUseStateCreated newAttributeUseStateCreated(String attributeId) {
        return new AbstractAttributeUseStateEvent.SimpleAttributeUseStateCreated(newAttributeUseEventId(attributeId));
    }

    public AttributeUseStateEvent.AttributeUseStateMergePatched newAttributeUseStateMergePatched(String attributeId) {
        return new AbstractAttributeUseStateEvent.SimpleAttributeUseStateMergePatched(newAttributeUseEventId(attributeId));
    }

    public AttributeUseStateEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(String attributeId) {
        return new AbstractAttributeUseStateEvent.SimpleAttributeUseStateRemoved(newAttributeUseEventId(attributeId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeSetStateCreated extends AbstractAttributeSetStateEvent implements AttributeSetStateEvent.AttributeSetStateCreated, Saveable
    {
        public AbstractAttributeSetStateCreated() {
            this(new AttributeSetEventId());
        }

        public AbstractAttributeSetStateCreated(AttributeSetEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<AttributeUseEventId, AttributeUseStateEvent.AttributeUseStateCreated> attributeUseEvents = new HashMap<AttributeUseEventId, AttributeUseStateEvent.AttributeUseStateCreated>();
        
        private Iterable<AttributeUseStateEvent.AttributeUseStateCreated> readOnlyAttributeUseEvents;

        public Iterable<AttributeUseStateEvent.AttributeUseStateCreated> getAttributeUseEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeUseEvents.values();
            }
            else
            {
                if (readOnlyAttributeUseEvents != null) { return readOnlyAttributeUseEvents; }
                AttributeUseStateEventDao eventDao = getAttributeUseStateEventDao();
                List<AttributeUseStateEvent.AttributeUseStateCreated> eL = new ArrayList<AttributeUseStateEvent.AttributeUseStateCreated>();
                for (AttributeUseStateEvent e : eventDao.findByAttributeSetEventId(this.getAttributeSetEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeUseStateEvent.AttributeUseStateCreated)e);
                }
                return (readOnlyAttributeUseEvents = eL);
            }
        }

        public void setAttributeUseEvents(Iterable<AttributeUseStateEvent.AttributeUseStateCreated> es)
        {
            if (es != null)
            {
                for (AttributeUseStateEvent.AttributeUseStateCreated e : es)
                {
                    addAttributeUseEvent(e);
                }
            }
            else { this.attributeUseEvents.clear(); }
        }
        
        public void addAttributeUseEvent(AttributeUseStateEvent.AttributeUseStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeUseEvents.put(e.getAttributeUseEventId(), e);
        }

        public void save()
        {
            for (AttributeUseStateEvent.AttributeUseStateCreated e : this.getAttributeUseEvents()) {
                getAttributeUseStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeSetStateMergePatched extends AbstractAttributeSetStateEvent implements AttributeSetStateEvent.AttributeSetStateMergePatched, Saveable
    {
        public AbstractAttributeSetStateMergePatched() {
            this(new AttributeSetEventId());
        }

        public AbstractAttributeSetStateMergePatched(AttributeSetEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

        private Map<AttributeUseEventId, AttributeUseStateEvent> attributeUseEvents = new HashMap<AttributeUseEventId, AttributeUseStateEvent>();
        
        private Iterable<AttributeUseStateEvent> readOnlyAttributeUseEvents;

        public Iterable<AttributeUseStateEvent> getAttributeUseEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeUseEvents.values();
            }
            else
            {
                if (readOnlyAttributeUseEvents != null) { return readOnlyAttributeUseEvents; }
                AttributeUseStateEventDao eventDao = getAttributeUseStateEventDao();
                List<AttributeUseStateEvent> eL = new ArrayList<AttributeUseStateEvent>();
                for (AttributeUseStateEvent e : eventDao.findByAttributeSetEventId(this.getAttributeSetEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeUseStateEvent)e);
                }
                return (readOnlyAttributeUseEvents = eL);
            }
        }

        public void setAttributeUseEvents(Iterable<AttributeUseStateEvent> es)
        {
            if (es != null)
            {
                for (AttributeUseStateEvent e : es)
                {
                    addAttributeUseEvent(e);
                }
            }
            else { this.attributeUseEvents.clear(); }
        }
        
        public void addAttributeUseEvent(AttributeUseStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeUseEvents.put(e.getAttributeUseEventId(), e);
        }

        public void save()
        {
            for (AttributeUseStateEvent e : this.getAttributeUseEvents()) {
                getAttributeUseStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeSetStateDeleted extends AbstractAttributeSetStateEvent implements AttributeSetStateEvent.AttributeSetStateDeleted, Saveable
    {
        public AbstractAttributeSetStateDeleted() {
            this(new AttributeSetEventId());
        }

        public AbstractAttributeSetStateDeleted(AttributeSetEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<AttributeUseEventId, AttributeUseStateEvent.AttributeUseStateRemoved> attributeUseEvents = new HashMap<AttributeUseEventId, AttributeUseStateEvent.AttributeUseStateRemoved>();
        
        private Iterable<AttributeUseStateEvent.AttributeUseStateRemoved> readOnlyAttributeUseEvents;

        public Iterable<AttributeUseStateEvent.AttributeUseStateRemoved> getAttributeUseEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeUseEvents.values();
            }
            else
            {
                if (readOnlyAttributeUseEvents != null) { return readOnlyAttributeUseEvents; }
                AttributeUseStateEventDao eventDao = getAttributeUseStateEventDao();
                List<AttributeUseStateEvent.AttributeUseStateRemoved> eL = new ArrayList<AttributeUseStateEvent.AttributeUseStateRemoved>();
                for (AttributeUseStateEvent e : eventDao.findByAttributeSetEventId(this.getAttributeSetEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeUseStateEvent.AttributeUseStateRemoved)e);
                }
                return (readOnlyAttributeUseEvents = eL);
            }
        }

        public void setAttributeUseEvents(Iterable<AttributeUseStateEvent.AttributeUseStateRemoved> es)
        {
            if (es != null)
            {
                for (AttributeUseStateEvent.AttributeUseStateRemoved e : es)
                {
                    addAttributeUseEvent(e);
                }
            }
            else { this.attributeUseEvents.clear(); }
        }
        
        public void addAttributeUseEvent(AttributeUseStateEvent.AttributeUseStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeUseEvents.put(e.getAttributeUseEventId(), e);
        }

        public void save()
        {
            for (AttributeUseStateEvent.AttributeUseStateRemoved e : this.getAttributeUseEvents()) {
                getAttributeUseStateEventDao().save(e);
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

