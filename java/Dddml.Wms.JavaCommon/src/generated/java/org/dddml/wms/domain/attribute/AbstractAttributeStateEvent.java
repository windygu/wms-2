package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractAttributeStateEvent extends AbstractStateEvent implements AttributeStateEvent 
{
    private AttributeEventId stateEventId;

    public AttributeEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(AttributeEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public String getAttributeId() {
        return getStateEventId().getAttributeId();
    }

    public void setAttributeId(String attributeId) {
        getStateEventId().setAttributeId(attributeId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractAttributeStateEvent() {
    }

    protected AbstractAttributeStateEvent(AttributeEventId eventId) {
        this.stateEventId = eventId;
    }

    protected AttributeValueStateEventDao getAttributeValueStateEventDao() {
        return (AttributeValueStateEventDao)ApplicationContext.current.get("AttributeValueStateEventDao");
    }

    protected AttributeValueEventId newAttributeValueEventId(String value)
    {
        AttributeValueEventId eventId = new AttributeValueEventId(this.getStateEventId().getAttributeId(), 
            value, 
            this.getStateEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(AttributeValueStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(AttributeStateEvent oe, AttributeValueStateEvent e)
    {
        if (!oe.getStateEventId().getAttributeId().equals(e.getStateEventId().getAttributeId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id AttributeId %1$s but inner id AttributeId %2$s", 
                oe.getStateEventId().getAttributeId(), e.getStateEventId().getAttributeId());
        }
    }

    protected AttributeAliasStateEventDao getAttributeAliasStateEventDao() {
        return (AttributeAliasStateEventDao)ApplicationContext.current.get("AttributeAliasStateEventDao");
    }

    protected AttributeAliasEventId newAttributeAliasEventId(String code)
    {
        AttributeAliasEventId eventId = new AttributeAliasEventId(this.getStateEventId().getAttributeId(), 
            code, 
            this.getStateEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(AttributeAliasStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(AttributeStateEvent oe, AttributeAliasStateEvent e)
    {
        if (!oe.getStateEventId().getAttributeId().equals(e.getStateEventId().getAttributeId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id AttributeId %1$s but inner id AttributeId %2$s", 
                oe.getStateEventId().getAttributeId(), e.getStateEventId().getAttributeId());
        }
    }

    public AttributeValueStateEvent.AttributeValueStateCreated newAttributeValueStateCreated(String value) {
        return new AbstractAttributeValueStateEvent.SimpleAttributeValueStateCreated(newAttributeValueEventId(value));
    }

    public AttributeValueStateEvent.AttributeValueStateMergePatched newAttributeValueStateMergePatched(String value) {
        return new AbstractAttributeValueStateEvent.SimpleAttributeValueStateMergePatched(newAttributeValueEventId(value));
    }

    public AttributeValueStateEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(String value) {
        return new AbstractAttributeValueStateEvent.SimpleAttributeValueStateRemoved(newAttributeValueEventId(value));
    }

    public AttributeAliasStateEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(String code) {
        return new AbstractAttributeAliasStateEvent.SimpleAttributeAliasStateCreated(newAttributeAliasEventId(code));
    }

    public AttributeAliasStateEvent.AttributeAliasStateMergePatched newAttributeAliasStateMergePatched(String code) {
        return new AbstractAttributeAliasStateEvent.SimpleAttributeAliasStateMergePatched(newAttributeAliasEventId(code));
    }

    public AttributeAliasStateEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(String code) {
        return new AbstractAttributeAliasStateEvent.SimpleAttributeAliasStateRemoved(newAttributeAliasEventId(code));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeStateCreated extends AbstractAttributeStateEvent implements AttributeStateEvent.AttributeStateCreated, Saveable
    {
        public AbstractAttributeStateCreated() {
            this(new AttributeEventId());
        }

        public AbstractAttributeStateCreated(AttributeEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<AttributeValueEventId, AttributeValueStateEvent.AttributeValueStateCreated> attributeValueEvents = new HashMap<AttributeValueEventId, AttributeValueStateEvent.AttributeValueStateCreated>();
        
        private Iterable<AttributeValueStateEvent.AttributeValueStateCreated> readOnlyAttributeValueEvents;

        public Iterable<AttributeValueStateEvent.AttributeValueStateCreated> getAttributeValueEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeValueEvents.values();
            }
            else
            {
                if (readOnlyAttributeValueEvents != null) { return readOnlyAttributeValueEvents; }
                AttributeValueStateEventDao eventDao = getAttributeValueStateEventDao();
                List<AttributeValueStateEvent.AttributeValueStateCreated> eL = new ArrayList<AttributeValueStateEvent.AttributeValueStateCreated>();
                for (AttributeValueStateEvent e : eventDao.findByAttributeEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeValueStateEvent.AttributeValueStateCreated)e);
                }
                return (readOnlyAttributeValueEvents = eL);
            }
        }

        public void setAttributeValueEvents(Iterable<AttributeValueStateEvent.AttributeValueStateCreated> es)
        {
            if (es != null)
            {
                for (AttributeValueStateEvent.AttributeValueStateCreated e : es)
                {
                    addAttributeValueEvent(e);
                }
            }
            else { this.attributeValueEvents.clear(); }
        }
        
        public void addAttributeValueEvent(AttributeValueStateEvent.AttributeValueStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeValueEvents.put(e.getStateEventId(), e);
        }

        private Map<AttributeAliasEventId, AttributeAliasStateEvent.AttributeAliasStateCreated> attributeAliasEvents = new HashMap<AttributeAliasEventId, AttributeAliasStateEvent.AttributeAliasStateCreated>();
        
        private Iterable<AttributeAliasStateEvent.AttributeAliasStateCreated> readOnlyAttributeAliasEvents;

        public Iterable<AttributeAliasStateEvent.AttributeAliasStateCreated> getAttributeAliasEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeAliasEvents.values();
            }
            else
            {
                if (readOnlyAttributeAliasEvents != null) { return readOnlyAttributeAliasEvents; }
                AttributeAliasStateEventDao eventDao = getAttributeAliasStateEventDao();
                List<AttributeAliasStateEvent.AttributeAliasStateCreated> eL = new ArrayList<AttributeAliasStateEvent.AttributeAliasStateCreated>();
                for (AttributeAliasStateEvent e : eventDao.findByAttributeEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeAliasStateEvent.AttributeAliasStateCreated)e);
                }
                return (readOnlyAttributeAliasEvents = eL);
            }
        }

        public void setAttributeAliasEvents(Iterable<AttributeAliasStateEvent.AttributeAliasStateCreated> es)
        {
            if (es != null)
            {
                for (AttributeAliasStateEvent.AttributeAliasStateCreated e : es)
                {
                    addAttributeAliasEvent(e);
                }
            }
            else { this.attributeAliasEvents.clear(); }
        }
        
        public void addAttributeAliasEvent(AttributeAliasStateEvent.AttributeAliasStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeAliasEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (AttributeValueStateEvent.AttributeValueStateCreated e : this.getAttributeValueEvents()) {
                getAttributeValueStateEventDao().save(e);
            }
            for (AttributeAliasStateEvent.AttributeAliasStateCreated e : this.getAttributeAliasEvents()) {
                getAttributeAliasStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeStateMergePatched extends AbstractAttributeStateEvent implements AttributeStateEvent.AttributeStateMergePatched, Saveable
    {
        public AbstractAttributeStateMergePatched() {
            this(new AttributeEventId());
        }

        public AbstractAttributeStateMergePatched(AttributeEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

        private Map<AttributeValueEventId, AttributeValueStateEvent> attributeValueEvents = new HashMap<AttributeValueEventId, AttributeValueStateEvent>();
        
        private Iterable<AttributeValueStateEvent> readOnlyAttributeValueEvents;

        public Iterable<AttributeValueStateEvent> getAttributeValueEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeValueEvents.values();
            }
            else
            {
                if (readOnlyAttributeValueEvents != null) { return readOnlyAttributeValueEvents; }
                AttributeValueStateEventDao eventDao = getAttributeValueStateEventDao();
                List<AttributeValueStateEvent> eL = new ArrayList<AttributeValueStateEvent>();
                for (AttributeValueStateEvent e : eventDao.findByAttributeEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeValueStateEvent)e);
                }
                return (readOnlyAttributeValueEvents = eL);
            }
        }

        public void setAttributeValueEvents(Iterable<AttributeValueStateEvent> es)
        {
            if (es != null)
            {
                for (AttributeValueStateEvent e : es)
                {
                    addAttributeValueEvent(e);
                }
            }
            else { this.attributeValueEvents.clear(); }
        }
        
        public void addAttributeValueEvent(AttributeValueStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeValueEvents.put(e.getStateEventId(), e);
        }

        private Map<AttributeAliasEventId, AttributeAliasStateEvent> attributeAliasEvents = new HashMap<AttributeAliasEventId, AttributeAliasStateEvent>();
        
        private Iterable<AttributeAliasStateEvent> readOnlyAttributeAliasEvents;

        public Iterable<AttributeAliasStateEvent> getAttributeAliasEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeAliasEvents.values();
            }
            else
            {
                if (readOnlyAttributeAliasEvents != null) { return readOnlyAttributeAliasEvents; }
                AttributeAliasStateEventDao eventDao = getAttributeAliasStateEventDao();
                List<AttributeAliasStateEvent> eL = new ArrayList<AttributeAliasStateEvent>();
                for (AttributeAliasStateEvent e : eventDao.findByAttributeEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeAliasStateEvent)e);
                }
                return (readOnlyAttributeAliasEvents = eL);
            }
        }

        public void setAttributeAliasEvents(Iterable<AttributeAliasStateEvent> es)
        {
            if (es != null)
            {
                for (AttributeAliasStateEvent e : es)
                {
                    addAttributeAliasEvent(e);
                }
            }
            else { this.attributeAliasEvents.clear(); }
        }
        
        public void addAttributeAliasEvent(AttributeAliasStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeAliasEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (AttributeValueStateEvent e : this.getAttributeValueEvents()) {
                getAttributeValueStateEventDao().save(e);
            }
            for (AttributeAliasStateEvent e : this.getAttributeAliasEvents()) {
                getAttributeAliasStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractAttributeStateDeleted extends AbstractAttributeStateEvent implements AttributeStateEvent.AttributeStateDeleted, Saveable
    {
        public AbstractAttributeStateDeleted() {
            this(new AttributeEventId());
        }

        public AbstractAttributeStateDeleted(AttributeEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<AttributeValueEventId, AttributeValueStateEvent.AttributeValueStateRemoved> attributeValueEvents = new HashMap<AttributeValueEventId, AttributeValueStateEvent.AttributeValueStateRemoved>();
        
        private Iterable<AttributeValueStateEvent.AttributeValueStateRemoved> readOnlyAttributeValueEvents;

        public Iterable<AttributeValueStateEvent.AttributeValueStateRemoved> getAttributeValueEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeValueEvents.values();
            }
            else
            {
                if (readOnlyAttributeValueEvents != null) { return readOnlyAttributeValueEvents; }
                AttributeValueStateEventDao eventDao = getAttributeValueStateEventDao();
                List<AttributeValueStateEvent.AttributeValueStateRemoved> eL = new ArrayList<AttributeValueStateEvent.AttributeValueStateRemoved>();
                for (AttributeValueStateEvent e : eventDao.findByAttributeEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeValueStateEvent.AttributeValueStateRemoved)e);
                }
                return (readOnlyAttributeValueEvents = eL);
            }
        }

        public void setAttributeValueEvents(Iterable<AttributeValueStateEvent.AttributeValueStateRemoved> es)
        {
            if (es != null)
            {
                for (AttributeValueStateEvent.AttributeValueStateRemoved e : es)
                {
                    addAttributeValueEvent(e);
                }
            }
            else { this.attributeValueEvents.clear(); }
        }
        
        public void addAttributeValueEvent(AttributeValueStateEvent.AttributeValueStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeValueEvents.put(e.getStateEventId(), e);
        }

		
        private Map<AttributeAliasEventId, AttributeAliasStateEvent.AttributeAliasStateRemoved> attributeAliasEvents = new HashMap<AttributeAliasEventId, AttributeAliasStateEvent.AttributeAliasStateRemoved>();
        
        private Iterable<AttributeAliasStateEvent.AttributeAliasStateRemoved> readOnlyAttributeAliasEvents;

        public Iterable<AttributeAliasStateEvent.AttributeAliasStateRemoved> getAttributeAliasEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.attributeAliasEvents.values();
            }
            else
            {
                if (readOnlyAttributeAliasEvents != null) { return readOnlyAttributeAliasEvents; }
                AttributeAliasStateEventDao eventDao = getAttributeAliasStateEventDao();
                List<AttributeAliasStateEvent.AttributeAliasStateRemoved> eL = new ArrayList<AttributeAliasStateEvent.AttributeAliasStateRemoved>();
                for (AttributeAliasStateEvent e : eventDao.findByAttributeEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((AttributeAliasStateEvent.AttributeAliasStateRemoved)e);
                }
                return (readOnlyAttributeAliasEvents = eL);
            }
        }

        public void setAttributeAliasEvents(Iterable<AttributeAliasStateEvent.AttributeAliasStateRemoved> es)
        {
            if (es != null)
            {
                for (AttributeAliasStateEvent.AttributeAliasStateRemoved e : es)
                {
                    addAttributeAliasEvent(e);
                }
            }
            else { this.attributeAliasEvents.clear(); }
        }
        
        public void addAttributeAliasEvent(AttributeAliasStateEvent.AttributeAliasStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.attributeAliasEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (AttributeValueStateEvent.AttributeValueStateRemoved e : this.getAttributeValueEvents()) {
                getAttributeValueStateEventDao().save(e);
            }
            for (AttributeAliasStateEvent.AttributeAliasStateRemoved e : this.getAttributeAliasEvents()) {
                getAttributeAliasStateEventDao().save(e);
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

