package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractAttributeEvent extends AbstractEvent implements AttributeEvent 
{
    private AttributeEventId attributeEventId;

    public AttributeEventId getAttributeEventId() {
        return this.attributeEventId;
    }

    public void setAttributeEventId(AttributeEventId eventId) {
        this.attributeEventId = eventId;
    }
    
    public String getAttributeId() {
        return getAttributeEventId().getAttributeId();
    }

    public void setAttributeId(String attributeId) {
        getAttributeEventId().setAttributeId(attributeId);
    }

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

    protected AbstractAttributeEvent() {
    }

    protected AbstractAttributeEvent(AttributeEventId eventId) {
        this.attributeEventId = eventId;
    }

    protected AttributeValueEventDao getAttributeValueEventDao() {
        return (AttributeValueEventDao)ApplicationContext.current.get("AttributeValueEventDao");
    }

    protected AttributeValueEventId newAttributeValueEventId(String value)
    {
        AttributeValueEventId eventId = new AttributeValueEventId(this.getAttributeEventId().getAttributeId(), 
            value, 
            this.getAttributeEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(AttributeValueEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(AttributeEvent oe, AttributeValueEvent e)
    {
        if (!oe.getAttributeEventId().getAttributeId().equals(e.getAttributeValueEventId().getAttributeId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id AttributeId %1$s but inner id AttributeId %2$s", 
                oe.getAttributeEventId().getAttributeId(), e.getAttributeValueEventId().getAttributeId());
        }
    }

    protected AttributeAliasEventDao getAttributeAliasEventDao() {
        return (AttributeAliasEventDao)ApplicationContext.current.get("AttributeAliasEventDao");
    }

    protected AttributeAliasEventId newAttributeAliasEventId(String code)
    {
        AttributeAliasEventId eventId = new AttributeAliasEventId(this.getAttributeEventId().getAttributeId(), 
            code, 
            this.getAttributeEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(AttributeAliasEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(AttributeEvent oe, AttributeAliasEvent e)
    {
        if (!oe.getAttributeEventId().getAttributeId().equals(e.getAttributeAliasEventId().getAttributeId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id AttributeId %1$s but inner id AttributeId %2$s", 
                oe.getAttributeEventId().getAttributeId(), e.getAttributeAliasEventId().getAttributeId());
        }
    }

    public AttributeValueEvent.AttributeValueStateCreated newAttributeValueStateCreated(String value) {
        return new AbstractAttributeValueEvent.SimpleAttributeValueStateCreated(newAttributeValueEventId(value));
    }

    public AttributeValueEvent.AttributeValueStateMergePatched newAttributeValueStateMergePatched(String value) {
        return new AbstractAttributeValueEvent.SimpleAttributeValueStateMergePatched(newAttributeValueEventId(value));
    }

    public AttributeValueEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(String value) {
        return new AbstractAttributeValueEvent.SimpleAttributeValueStateRemoved(newAttributeValueEventId(value));
    }

    public AttributeAliasEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(String code) {
        return new AbstractAttributeAliasEvent.SimpleAttributeAliasStateCreated(newAttributeAliasEventId(code));
    }

    public AttributeAliasEvent.AttributeAliasStateMergePatched newAttributeAliasStateMergePatched(String code) {
        return new AbstractAttributeAliasEvent.SimpleAttributeAliasStateMergePatched(newAttributeAliasEventId(code));
    }

    public AttributeAliasEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(String code) {
        return new AbstractAttributeAliasEvent.SimpleAttributeAliasStateRemoved(newAttributeAliasEventId(code));
    }


    public abstract String getEventType();


    public static abstract class AbstractAttributeStateEvent extends AbstractAttributeEvent implements AttributeEvent.AttributeStateEvent {
        private String attributeName;

        public String getAttributeName()
        {
            return this.attributeName;
        }

        public void setAttributeName(String attributeName)
        {
            this.attributeName = attributeName;
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

        private Boolean isMandatory;

        public Boolean getIsMandatory()
        {
            return this.isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory)
        {
            this.isMandatory = isMandatory;
        }

        private String attributeValueType;

        public String getAttributeValueType()
        {
            return this.attributeValueType;
        }

        public void setAttributeValueType(String attributeValueType)
        {
            this.attributeValueType = attributeValueType;
        }

        private Integer attributeValueLength;

        public Integer getAttributeValueLength()
        {
            return this.attributeValueLength;
        }

        public void setAttributeValueLength(Integer attributeValueLength)
        {
            this.attributeValueLength = attributeValueLength;
        }

        private Boolean isList;

        public Boolean getIsList()
        {
            return this.isList;
        }

        public void setIsList(Boolean isList)
        {
            this.isList = isList;
        }

        private String fieldName;

        public String getFieldName()
        {
            return this.fieldName;
        }

        public void setFieldName(String fieldName)
        {
            this.fieldName = fieldName;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractAttributeStateEvent(AttributeEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractAttributeStateCreated extends AbstractAttributeStateEvent implements AttributeEvent.AttributeStateCreated, Saveable
    {
        public AbstractAttributeStateCreated() {
            this(new AttributeEventId());
        }

        public AbstractAttributeStateCreated(AttributeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<AttributeValueEventId, AttributeValueEvent.AttributeValueStateCreated> attributeValueEvents = new HashMap<AttributeValueEventId, AttributeValueEvent.AttributeValueStateCreated>();
        
        private Iterable<AttributeValueEvent.AttributeValueStateCreated> readOnlyAttributeValueEvents;

        public Iterable<AttributeValueEvent.AttributeValueStateCreated> getAttributeValueEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeValueEvents.values();
            }
            else
            {
                if (readOnlyAttributeValueEvents != null) { return readOnlyAttributeValueEvents; }
                AttributeValueEventDao eventDao = getAttributeValueEventDao();
                List<AttributeValueEvent.AttributeValueStateCreated> eL = new ArrayList<AttributeValueEvent.AttributeValueStateCreated>();
                for (AttributeValueEvent e : eventDao.findByAttributeEventId(this.getAttributeEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((AttributeValueEvent.AttributeValueStateCreated)e);
                }
                return (readOnlyAttributeValueEvents = eL);
            }
        }

        public void setAttributeValueEvents(Iterable<AttributeValueEvent.AttributeValueStateCreated> es)
        {
            if (es != null)
            {
                for (AttributeValueEvent.AttributeValueStateCreated e : es)
                {
                    addAttributeValueEvent(e);
                }
            }
            else { this.attributeValueEvents.clear(); }
        }
        
        public void addAttributeValueEvent(AttributeValueEvent.AttributeValueStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeValueEvents.put(e.getAttributeValueEventId(), e);
        }

        private Map<AttributeAliasEventId, AttributeAliasEvent.AttributeAliasStateCreated> attributeAliasEvents = new HashMap<AttributeAliasEventId, AttributeAliasEvent.AttributeAliasStateCreated>();
        
        private Iterable<AttributeAliasEvent.AttributeAliasStateCreated> readOnlyAttributeAliasEvents;

        public Iterable<AttributeAliasEvent.AttributeAliasStateCreated> getAttributeAliasEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeAliasEvents.values();
            }
            else
            {
                if (readOnlyAttributeAliasEvents != null) { return readOnlyAttributeAliasEvents; }
                AttributeAliasEventDao eventDao = getAttributeAliasEventDao();
                List<AttributeAliasEvent.AttributeAliasStateCreated> eL = new ArrayList<AttributeAliasEvent.AttributeAliasStateCreated>();
                for (AttributeAliasEvent e : eventDao.findByAttributeEventId(this.getAttributeEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((AttributeAliasEvent.AttributeAliasStateCreated)e);
                }
                return (readOnlyAttributeAliasEvents = eL);
            }
        }

        public void setAttributeAliasEvents(Iterable<AttributeAliasEvent.AttributeAliasStateCreated> es)
        {
            if (es != null)
            {
                for (AttributeAliasEvent.AttributeAliasStateCreated e : es)
                {
                    addAttributeAliasEvent(e);
                }
            }
            else { this.attributeAliasEvents.clear(); }
        }
        
        public void addAttributeAliasEvent(AttributeAliasEvent.AttributeAliasStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeAliasEvents.put(e.getAttributeAliasEventId(), e);
        }

        public void save()
        {
            for (AttributeValueEvent.AttributeValueStateCreated e : this.getAttributeValueEvents()) {
                getAttributeValueEventDao().save(e);
            }
            for (AttributeAliasEvent.AttributeAliasStateCreated e : this.getAttributeAliasEvents()) {
                getAttributeAliasEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeStateMergePatched extends AbstractAttributeStateEvent implements AttributeEvent.AttributeStateMergePatched, Saveable
    {
        public AbstractAttributeStateMergePatched() {
            this(new AttributeEventId());
        }

        public AbstractAttributeStateMergePatched(AttributeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyAttributeNameRemoved;

        public Boolean getIsPropertyAttributeNameRemoved() {
            return this.isPropertyAttributeNameRemoved;
        }

        public void setIsPropertyAttributeNameRemoved(Boolean removed) {
            this.isPropertyAttributeNameRemoved = removed;
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

        private Boolean isPropertyIsMandatoryRemoved;

        public Boolean getIsPropertyIsMandatoryRemoved() {
            return this.isPropertyIsMandatoryRemoved;
        }

        public void setIsPropertyIsMandatoryRemoved(Boolean removed) {
            this.isPropertyIsMandatoryRemoved = removed;
        }

        private Boolean isPropertyAttributeValueTypeRemoved;

        public Boolean getIsPropertyAttributeValueTypeRemoved() {
            return this.isPropertyAttributeValueTypeRemoved;
        }

        public void setIsPropertyAttributeValueTypeRemoved(Boolean removed) {
            this.isPropertyAttributeValueTypeRemoved = removed;
        }

        private Boolean isPropertyAttributeValueLengthRemoved;

        public Boolean getIsPropertyAttributeValueLengthRemoved() {
            return this.isPropertyAttributeValueLengthRemoved;
        }

        public void setIsPropertyAttributeValueLengthRemoved(Boolean removed) {
            this.isPropertyAttributeValueLengthRemoved = removed;
        }

        private Boolean isPropertyIsListRemoved;

        public Boolean getIsPropertyIsListRemoved() {
            return this.isPropertyIsListRemoved;
        }

        public void setIsPropertyIsListRemoved(Boolean removed) {
            this.isPropertyIsListRemoved = removed;
        }

        private Boolean isPropertyFieldNameRemoved;

        public Boolean getIsPropertyFieldNameRemoved() {
            return this.isPropertyFieldNameRemoved;
        }

        public void setIsPropertyFieldNameRemoved(Boolean removed) {
            this.isPropertyFieldNameRemoved = removed;
        }

        private Boolean isPropertyReferenceIdRemoved;

        public Boolean getIsPropertyReferenceIdRemoved() {
            return this.isPropertyReferenceIdRemoved;
        }

        public void setIsPropertyReferenceIdRemoved(Boolean removed) {
            this.isPropertyReferenceIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<AttributeValueEventId, AttributeValueEvent> attributeValueEvents = new HashMap<AttributeValueEventId, AttributeValueEvent>();
        
        private Iterable<AttributeValueEvent> readOnlyAttributeValueEvents;

        public Iterable<AttributeValueEvent> getAttributeValueEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeValueEvents.values();
            }
            else
            {
                if (readOnlyAttributeValueEvents != null) { return readOnlyAttributeValueEvents; }
                AttributeValueEventDao eventDao = getAttributeValueEventDao();
                List<AttributeValueEvent> eL = new ArrayList<AttributeValueEvent>();
                for (AttributeValueEvent e : eventDao.findByAttributeEventId(this.getAttributeEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((AttributeValueEvent)e);
                }
                return (readOnlyAttributeValueEvents = eL);
            }
        }

        public void setAttributeValueEvents(Iterable<AttributeValueEvent> es)
        {
            if (es != null)
            {
                for (AttributeValueEvent e : es)
                {
                    addAttributeValueEvent(e);
                }
            }
            else { this.attributeValueEvents.clear(); }
        }
        
        public void addAttributeValueEvent(AttributeValueEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeValueEvents.put(e.getAttributeValueEventId(), e);
        }

        private Map<AttributeAliasEventId, AttributeAliasEvent> attributeAliasEvents = new HashMap<AttributeAliasEventId, AttributeAliasEvent>();
        
        private Iterable<AttributeAliasEvent> readOnlyAttributeAliasEvents;

        public Iterable<AttributeAliasEvent> getAttributeAliasEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeAliasEvents.values();
            }
            else
            {
                if (readOnlyAttributeAliasEvents != null) { return readOnlyAttributeAliasEvents; }
                AttributeAliasEventDao eventDao = getAttributeAliasEventDao();
                List<AttributeAliasEvent> eL = new ArrayList<AttributeAliasEvent>();
                for (AttributeAliasEvent e : eventDao.findByAttributeEventId(this.getAttributeEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((AttributeAliasEvent)e);
                }
                return (readOnlyAttributeAliasEvents = eL);
            }
        }

        public void setAttributeAliasEvents(Iterable<AttributeAliasEvent> es)
        {
            if (es != null)
            {
                for (AttributeAliasEvent e : es)
                {
                    addAttributeAliasEvent(e);
                }
            }
            else { this.attributeAliasEvents.clear(); }
        }
        
        public void addAttributeAliasEvent(AttributeAliasEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeAliasEvents.put(e.getAttributeAliasEventId(), e);
        }

        public void save()
        {
            for (AttributeValueEvent e : this.getAttributeValueEvents()) {
                getAttributeValueEventDao().save(e);
            }
            for (AttributeAliasEvent e : this.getAttributeAliasEvents()) {
                getAttributeAliasEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeStateDeleted extends AbstractAttributeStateEvent implements AttributeEvent.AttributeStateDeleted, Saveable
    {
        public AbstractAttributeStateDeleted() {
            this(new AttributeEventId());
        }

        public AbstractAttributeStateDeleted(AttributeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<AttributeValueEventId, AttributeValueEvent.AttributeValueStateRemoved> attributeValueEvents = new HashMap<AttributeValueEventId, AttributeValueEvent.AttributeValueStateRemoved>();
        
        private Iterable<AttributeValueEvent.AttributeValueStateRemoved> readOnlyAttributeValueEvents;

        public Iterable<AttributeValueEvent.AttributeValueStateRemoved> getAttributeValueEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeValueEvents.values();
            }
            else
            {
                if (readOnlyAttributeValueEvents != null) { return readOnlyAttributeValueEvents; }
                AttributeValueEventDao eventDao = getAttributeValueEventDao();
                List<AttributeValueEvent.AttributeValueStateRemoved> eL = new ArrayList<AttributeValueEvent.AttributeValueStateRemoved>();
                for (AttributeValueEvent e : eventDao.findByAttributeEventId(this.getAttributeEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((AttributeValueEvent.AttributeValueStateRemoved)e);
                }
                return (readOnlyAttributeValueEvents = eL);
            }
        }

        public void setAttributeValueEvents(Iterable<AttributeValueEvent.AttributeValueStateRemoved> es)
        {
            if (es != null)
            {
                for (AttributeValueEvent.AttributeValueStateRemoved e : es)
                {
                    addAttributeValueEvent(e);
                }
            }
            else { this.attributeValueEvents.clear(); }
        }
        
        public void addAttributeValueEvent(AttributeValueEvent.AttributeValueStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeValueEvents.put(e.getAttributeValueEventId(), e);
        }

		
        private Map<AttributeAliasEventId, AttributeAliasEvent.AttributeAliasStateRemoved> attributeAliasEvents = new HashMap<AttributeAliasEventId, AttributeAliasEvent.AttributeAliasStateRemoved>();
        
        private Iterable<AttributeAliasEvent.AttributeAliasStateRemoved> readOnlyAttributeAliasEvents;

        public Iterable<AttributeAliasEvent.AttributeAliasStateRemoved> getAttributeAliasEvents()
        {
            if (!getEventReadOnly())
            {
                return this.attributeAliasEvents.values();
            }
            else
            {
                if (readOnlyAttributeAliasEvents != null) { return readOnlyAttributeAliasEvents; }
                AttributeAliasEventDao eventDao = getAttributeAliasEventDao();
                List<AttributeAliasEvent.AttributeAliasStateRemoved> eL = new ArrayList<AttributeAliasEvent.AttributeAliasStateRemoved>();
                for (AttributeAliasEvent e : eventDao.findByAttributeEventId(this.getAttributeEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((AttributeAliasEvent.AttributeAliasStateRemoved)e);
                }
                return (readOnlyAttributeAliasEvents = eL);
            }
        }

        public void setAttributeAliasEvents(Iterable<AttributeAliasEvent.AttributeAliasStateRemoved> es)
        {
            if (es != null)
            {
                for (AttributeAliasEvent.AttributeAliasStateRemoved e : es)
                {
                    addAttributeAliasEvent(e);
                }
            }
            else { this.attributeAliasEvents.clear(); }
        }
        
        public void addAttributeAliasEvent(AttributeAliasEvent.AttributeAliasStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeAliasEvents.put(e.getAttributeAliasEventId(), e);
        }

        public void save()
        {
            for (AttributeValueEvent.AttributeValueStateRemoved e : this.getAttributeValueEvents()) {
                getAttributeValueEventDao().save(e);
            }
            for (AttributeAliasEvent.AttributeAliasStateRemoved e : this.getAttributeAliasEvents()) {
                getAttributeAliasEventDao().save(e);
            }
        }
    }
    public static class SimpleAttributeStateCreated extends AbstractAttributeStateCreated
    {
        public SimpleAttributeStateCreated() {
        }

        public SimpleAttributeStateCreated(AttributeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeStateMergePatched extends AbstractAttributeStateMergePatched
    {
        public SimpleAttributeStateMergePatched() {
        }

        public SimpleAttributeStateMergePatched(AttributeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleAttributeStateDeleted extends AbstractAttributeStateDeleted
    {
        public SimpleAttributeStateDeleted() {
        }

        public SimpleAttributeStateDeleted(AttributeEventId eventId) {
            super(eventId);
        }
    }

}

