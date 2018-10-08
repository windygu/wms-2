package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInOutLineEvent extends AbstractEvent implements InOutLineEvent.SqlInOutLineEvent 
{
    private InOutLineEventId inOutLineEventId;

    public InOutLineEventId getInOutLineEventId() {
        return this.inOutLineEventId;
    }

    public void setInOutLineEventId(InOutLineEventId eventId) {
        this.inOutLineEventId = eventId;
    }
    
    public String getLineNumber() {
        return getInOutLineEventId().getLineNumber();
    }

    public void setLineNumber(String lineNumber) {
        getInOutLineEventId().setLineNumber(lineNumber);
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

    protected AbstractInOutLineEvent() {
    }

    protected AbstractInOutLineEvent(InOutLineEventId eventId) {
        this.inOutLineEventId = eventId;
    }

    protected InOutLineImageEventDao getInOutLineImageEventDao() {
        return (InOutLineImageEventDao)ApplicationContext.current.get("InOutLineImageEventDao");
    }

    protected InOutLineImageEventId newInOutLineImageEventId(String sequenceId)
    {
        InOutLineImageEventId eventId = new InOutLineImageEventId(this.getInOutLineEventId().getInOutDocumentNumber(), this.getInOutLineEventId().getLineNumber(), 
            sequenceId, 
            this.getInOutLineEventId().getInOutVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(InOutLineImageEvent.SqlInOutLineImageEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(InOutLineEvent.SqlInOutLineEvent oe, InOutLineImageEvent.SqlInOutLineImageEvent e)
    {
        if (!oe.getInOutLineEventId().getInOutDocumentNumber().equals(e.getInOutLineImageEventId().getInOutDocumentNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id InOutDocumentNumber %1$s but inner id InOutDocumentNumber %2$s", 
                oe.getInOutLineEventId().getInOutDocumentNumber(), e.getInOutLineImageEventId().getInOutDocumentNumber());
        }
        if (!oe.getInOutLineEventId().getLineNumber().equals(e.getInOutLineImageEventId().getInOutLineLineNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id LineNumber %1$s but inner id InOutLineLineNumber %2$s", 
                oe.getInOutLineEventId().getLineNumber(), e.getInOutLineImageEventId().getInOutLineLineNumber());
        }
    }

    public InOutLineImageEvent.InOutLineImageStateCreated newInOutLineImageStateCreated(String sequenceId) {
        return new AbstractInOutLineImageEvent.SimpleInOutLineImageStateCreated(newInOutLineImageEventId(sequenceId));
    }

    public InOutLineImageEvent.InOutLineImageStateMergePatched newInOutLineImageStateMergePatched(String sequenceId) {
        return new AbstractInOutLineImageEvent.SimpleInOutLineImageStateMergePatched(newInOutLineImageEventId(sequenceId));
    }

    public InOutLineImageEvent.InOutLineImageStateRemoved newInOutLineImageStateRemoved(String sequenceId) {
        return new AbstractInOutLineImageEvent.SimpleInOutLineImageStateRemoved(newInOutLineImageEventId(sequenceId));
    }


    public abstract String getEventType();


    public static abstract class AbstractInOutLineStateEvent extends AbstractInOutLineEvent implements InOutLineEvent.InOutLineStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String locatorId;

        public String getLocatorId()
        {
            return this.locatorId;
        }

        public void setLocatorId(String locatorId)
        {
            this.locatorId = locatorId;
        }

        private String productId;

        public String getProductId()
        {
            return this.productId;
        }

        public void setProductId(String productId)
        {
            this.productId = productId;
        }

        private String attributeSetInstanceId;

        public String getAttributeSetInstanceId()
        {
            return this.attributeSetInstanceId;
        }

        public void setAttributeSetInstanceId(String attributeSetInstanceId)
        {
            this.attributeSetInstanceId = attributeSetInstanceId;
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

        private String quantityUomId;

        public String getQuantityUomId()
        {
            return this.quantityUomId;
        }

        public void setQuantityUomId(String quantityUomId)
        {
            this.quantityUomId = quantityUomId;
        }

        private BigDecimal movementQuantity;

        public BigDecimal getMovementQuantity()
        {
            return this.movementQuantity;
        }

        public void setMovementQuantity(BigDecimal movementQuantity)
        {
            this.movementQuantity = movementQuantity;
        }

        private BigDecimal pickedQuantity;

        public BigDecimal getPickedQuantity()
        {
            return this.pickedQuantity;
        }

        public void setPickedQuantity(BigDecimal pickedQuantity)
        {
            this.pickedQuantity = pickedQuantity;
        }

        private Boolean isInvoiced;

        public Boolean getIsInvoiced()
        {
            return this.isInvoiced;
        }

        public void setIsInvoiced(Boolean isInvoiced)
        {
            this.isInvoiced = isInvoiced;
        }

        private Boolean processed;

        public Boolean getProcessed()
        {
            return this.processed;
        }

        public void setProcessed(Boolean processed)
        {
            this.processed = processed;
        }

        private String rmaLineNumber;

        public String getRmaLineNumber()
        {
            return this.rmaLineNumber;
        }

        public void setRmaLineNumber(String rmaLineNumber)
        {
            this.rmaLineNumber = rmaLineNumber;
        }

        private String reversalLineNumber;

        public String getReversalLineNumber()
        {
            return this.reversalLineNumber;
        }

        public void setReversalLineNumber(String reversalLineNumber)
        {
            this.reversalLineNumber = reversalLineNumber;
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

        private Set<String> damageStatusIds;

        public Set<String> getDamageStatusIds()
        {
            return this.damageStatusIds;
        }

        public void setDamageStatusIds(Set<String> damageStatusIds)
        {
            this.damageStatusIds = damageStatusIds;
        }

        protected AbstractInOutLineStateEvent(InOutLineEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractInOutLineStateCreated extends AbstractInOutLineStateEvent implements InOutLineEvent.InOutLineStateCreated, Saveable
    {
        public AbstractInOutLineStateCreated() {
            this(new InOutLineEventId());
        }

        public AbstractInOutLineStateCreated(InOutLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<InOutLineImageEventId, InOutLineImageEvent.InOutLineImageStateCreated> inOutLineImageEvents = new HashMap<InOutLineImageEventId, InOutLineImageEvent.InOutLineImageStateCreated>();
        
        private Iterable<InOutLineImageEvent.InOutLineImageStateCreated> readOnlyInOutLineImageEvents;

        public Iterable<InOutLineImageEvent.InOutLineImageStateCreated> getInOutLineImageEvents()
        {
            if (!getEventReadOnly())
            {
                return this.inOutLineImageEvents.values();
            }
            else
            {
                if (readOnlyInOutLineImageEvents != null) { return readOnlyInOutLineImageEvents; }
                InOutLineImageEventDao eventDao = getInOutLineImageEventDao();
                List<InOutLineImageEvent.InOutLineImageStateCreated> eL = new ArrayList<InOutLineImageEvent.InOutLineImageStateCreated>();
                for (InOutLineImageEvent e : eventDao.findByInOutLineEventId(this.getInOutLineEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((InOutLineImageEvent.InOutLineImageStateCreated)e);
                }
                return (readOnlyInOutLineImageEvents = eL);
            }
        }

        public void setInOutLineImageEvents(Iterable<InOutLineImageEvent.InOutLineImageStateCreated> es)
        {
            if (es != null)
            {
                for (InOutLineImageEvent.InOutLineImageStateCreated e : es)
                {
                    addInOutLineImageEvent(e);
                }
            }
            else { this.inOutLineImageEvents.clear(); }
        }
        
        public void addInOutLineImageEvent(InOutLineImageEvent.InOutLineImageStateCreated e)
        {
            throwOnInconsistentEventIds((InOutLineImageEvent.SqlInOutLineImageEvent)e);
            this.inOutLineImageEvents.put(((InOutLineImageEvent.SqlInOutLineImageEvent)e).getInOutLineImageEventId(), e);
        }

        public void save()
        {
            for (InOutLineImageEvent.InOutLineImageStateCreated e : this.getInOutLineImageEvents()) {
                getInOutLineImageEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractInOutLineStateMergePatched extends AbstractInOutLineStateEvent implements InOutLineEvent.InOutLineStateMergePatched, Saveable
    {
        public AbstractInOutLineStateMergePatched() {
            this(new InOutLineEventId());
        }

        public AbstractInOutLineStateMergePatched(InOutLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyLocatorIdRemoved;

        public Boolean getIsPropertyLocatorIdRemoved() {
            return this.isPropertyLocatorIdRemoved;
        }

        public void setIsPropertyLocatorIdRemoved(Boolean removed) {
            this.isPropertyLocatorIdRemoved = removed;
        }

        private Boolean isPropertyProductIdRemoved;

        public Boolean getIsPropertyProductIdRemoved() {
            return this.isPropertyProductIdRemoved;
        }

        public void setIsPropertyProductIdRemoved(Boolean removed) {
            this.isPropertyProductIdRemoved = removed;
        }

        private Boolean isPropertyAttributeSetInstanceIdRemoved;

        public Boolean getIsPropertyAttributeSetInstanceIdRemoved() {
            return this.isPropertyAttributeSetInstanceIdRemoved;
        }

        public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed) {
            this.isPropertyAttributeSetInstanceIdRemoved = removed;
        }

        private Boolean isPropertyDamageStatusIdsRemoved;

        public Boolean getIsPropertyDamageStatusIdsRemoved() {
            return this.isPropertyDamageStatusIdsRemoved;
        }

        public void setIsPropertyDamageStatusIdsRemoved(Boolean removed) {
            this.isPropertyDamageStatusIdsRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyQuantityUomIdRemoved;

        public Boolean getIsPropertyQuantityUomIdRemoved() {
            return this.isPropertyQuantityUomIdRemoved;
        }

        public void setIsPropertyQuantityUomIdRemoved(Boolean removed) {
            this.isPropertyQuantityUomIdRemoved = removed;
        }

        private Boolean isPropertyMovementQuantityRemoved;

        public Boolean getIsPropertyMovementQuantityRemoved() {
            return this.isPropertyMovementQuantityRemoved;
        }

        public void setIsPropertyMovementQuantityRemoved(Boolean removed) {
            this.isPropertyMovementQuantityRemoved = removed;
        }

        private Boolean isPropertyPickedQuantityRemoved;

        public Boolean getIsPropertyPickedQuantityRemoved() {
            return this.isPropertyPickedQuantityRemoved;
        }

        public void setIsPropertyPickedQuantityRemoved(Boolean removed) {
            this.isPropertyPickedQuantityRemoved = removed;
        }

        private Boolean isPropertyIsInvoicedRemoved;

        public Boolean getIsPropertyIsInvoicedRemoved() {
            return this.isPropertyIsInvoicedRemoved;
        }

        public void setIsPropertyIsInvoicedRemoved(Boolean removed) {
            this.isPropertyIsInvoicedRemoved = removed;
        }

        private Boolean isPropertyProcessedRemoved;

        public Boolean getIsPropertyProcessedRemoved() {
            return this.isPropertyProcessedRemoved;
        }

        public void setIsPropertyProcessedRemoved(Boolean removed) {
            this.isPropertyProcessedRemoved = removed;
        }

        private Boolean isPropertyRmaLineNumberRemoved;

        public Boolean getIsPropertyRmaLineNumberRemoved() {
            return this.isPropertyRmaLineNumberRemoved;
        }

        public void setIsPropertyRmaLineNumberRemoved(Boolean removed) {
            this.isPropertyRmaLineNumberRemoved = removed;
        }

        private Boolean isPropertyReversalLineNumberRemoved;

        public Boolean getIsPropertyReversalLineNumberRemoved() {
            return this.isPropertyReversalLineNumberRemoved;
        }

        public void setIsPropertyReversalLineNumberRemoved(Boolean removed) {
            this.isPropertyReversalLineNumberRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<InOutLineImageEventId, InOutLineImageEvent> inOutLineImageEvents = new HashMap<InOutLineImageEventId, InOutLineImageEvent>();
        
        private Iterable<InOutLineImageEvent> readOnlyInOutLineImageEvents;

        public Iterable<InOutLineImageEvent> getInOutLineImageEvents()
        {
            if (!getEventReadOnly())
            {
                return this.inOutLineImageEvents.values();
            }
            else
            {
                if (readOnlyInOutLineImageEvents != null) { return readOnlyInOutLineImageEvents; }
                InOutLineImageEventDao eventDao = getInOutLineImageEventDao();
                List<InOutLineImageEvent> eL = new ArrayList<InOutLineImageEvent>();
                for (InOutLineImageEvent e : eventDao.findByInOutLineEventId(this.getInOutLineEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((InOutLineImageEvent)e);
                }
                return (readOnlyInOutLineImageEvents = eL);
            }
        }

        public void setInOutLineImageEvents(Iterable<InOutLineImageEvent> es)
        {
            if (es != null)
            {
                for (InOutLineImageEvent e : es)
                {
                    addInOutLineImageEvent(e);
                }
            }
            else { this.inOutLineImageEvents.clear(); }
        }
        
        public void addInOutLineImageEvent(InOutLineImageEvent e)
        {
            throwOnInconsistentEventIds((InOutLineImageEvent.SqlInOutLineImageEvent)e);
            this.inOutLineImageEvents.put(((InOutLineImageEvent.SqlInOutLineImageEvent)e).getInOutLineImageEventId(), e);
        }

        public void save()
        {
            for (InOutLineImageEvent e : this.getInOutLineImageEvents()) {
                getInOutLineImageEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractInOutLineStateRemoved extends AbstractInOutLineStateEvent implements InOutLineEvent.InOutLineStateRemoved, Saveable
    {
        public AbstractInOutLineStateRemoved() {
            this(new InOutLineEventId());
        }

        public AbstractInOutLineStateRemoved(InOutLineEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

		
        private Map<InOutLineImageEventId, InOutLineImageEvent.InOutLineImageStateRemoved> inOutLineImageEvents = new HashMap<InOutLineImageEventId, InOutLineImageEvent.InOutLineImageStateRemoved>();
        
        private Iterable<InOutLineImageEvent.InOutLineImageStateRemoved> readOnlyInOutLineImageEvents;

        public Iterable<InOutLineImageEvent.InOutLineImageStateRemoved> getInOutLineImageEvents()
        {
            if (!getEventReadOnly())
            {
                return this.inOutLineImageEvents.values();
            }
            else
            {
                if (readOnlyInOutLineImageEvents != null) { return readOnlyInOutLineImageEvents; }
                InOutLineImageEventDao eventDao = getInOutLineImageEventDao();
                List<InOutLineImageEvent.InOutLineImageStateRemoved> eL = new ArrayList<InOutLineImageEvent.InOutLineImageStateRemoved>();
                for (InOutLineImageEvent e : eventDao.findByInOutLineEventId(this.getInOutLineEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((InOutLineImageEvent.InOutLineImageStateRemoved)e);
                }
                return (readOnlyInOutLineImageEvents = eL);
            }
        }

        public void setInOutLineImageEvents(Iterable<InOutLineImageEvent.InOutLineImageStateRemoved> es)
        {
            if (es != null)
            {
                for (InOutLineImageEvent.InOutLineImageStateRemoved e : es)
                {
                    addInOutLineImageEvent(e);
                }
            }
            else { this.inOutLineImageEvents.clear(); }
        }
        
        public void addInOutLineImageEvent(InOutLineImageEvent.InOutLineImageStateRemoved e)
        {
            throwOnInconsistentEventIds((InOutLineImageEvent.SqlInOutLineImageEvent)e);
            this.inOutLineImageEvents.put(((InOutLineImageEvent.SqlInOutLineImageEvent)e).getInOutLineImageEventId(), e);
        }

        public void save()
        {
            for (InOutLineImageEvent.InOutLineImageStateRemoved e : this.getInOutLineImageEvents()) {
                getInOutLineImageEventDao().save(e);
            }
        }
    }
    public static class SimpleInOutLineStateCreated extends AbstractInOutLineStateCreated
    {
        public SimpleInOutLineStateCreated() {
        }

        public SimpleInOutLineStateCreated(InOutLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInOutLineStateMergePatched extends AbstractInOutLineStateMergePatched
    {
        public SimpleInOutLineStateMergePatched() {
        }

        public SimpleInOutLineStateMergePatched(InOutLineEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInOutLineStateRemoved extends AbstractInOutLineStateRemoved
    {
        public SimpleInOutLineStateRemoved() {
        }

        public SimpleInOutLineStateRemoved(InOutLineEventId eventId) {
            super(eventId);
        }
    }

}

