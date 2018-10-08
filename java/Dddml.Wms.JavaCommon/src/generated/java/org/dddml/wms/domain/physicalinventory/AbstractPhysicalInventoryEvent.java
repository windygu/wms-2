package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPhysicalInventoryEvent extends AbstractEvent implements PhysicalInventoryEvent.SqlPhysicalInventoryEvent 
{
    private PhysicalInventoryEventId physicalInventoryEventId;

    public PhysicalInventoryEventId getPhysicalInventoryEventId() {
        return this.physicalInventoryEventId;
    }

    public void setPhysicalInventoryEventId(PhysicalInventoryEventId eventId) {
        this.physicalInventoryEventId = eventId;
    }
    
    public String getDocumentNumber() {
        return getPhysicalInventoryEventId().getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber) {
        getPhysicalInventoryEventId().setDocumentNumber(documentNumber);
    }

    public Long getVersion() {
        return getPhysicalInventoryEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getPhysicalInventoryEventId().setVersion(version);
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

    protected AbstractPhysicalInventoryEvent() {
    }

    protected AbstractPhysicalInventoryEvent(PhysicalInventoryEventId eventId) {
        this.physicalInventoryEventId = eventId;
    }

    protected PhysicalInventoryLineEventDao getPhysicalInventoryLineEventDao() {
        return (PhysicalInventoryLineEventDao)ApplicationContext.current.get("PhysicalInventoryLineEventDao");
    }

    protected PhysicalInventoryLineEventId newPhysicalInventoryLineEventId(InventoryItemId inventoryItemId)
    {
        PhysicalInventoryLineEventId eventId = new PhysicalInventoryLineEventId(this.getPhysicalInventoryEventId().getDocumentNumber(), 
            inventoryItemId, 
            this.getPhysicalInventoryEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(PhysicalInventoryEvent.SqlPhysicalInventoryEvent oe, PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent e)
    {
        if (!oe.getPhysicalInventoryEventId().getDocumentNumber().equals(e.getPhysicalInventoryLineEventId().getPhysicalInventoryDocumentNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id DocumentNumber %1$s but inner id PhysicalInventoryDocumentNumber %2$s", 
                oe.getPhysicalInventoryEventId().getDocumentNumber(), e.getPhysicalInventoryLineEventId().getPhysicalInventoryDocumentNumber());
        }
    }

    public PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated newPhysicalInventoryLineStateCreated(InventoryItemId inventoryItemId) {
        return new AbstractPhysicalInventoryLineEvent.SimplePhysicalInventoryLineStateCreated(newPhysicalInventoryLineEventId(inventoryItemId));
    }

    public PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched newPhysicalInventoryLineStateMergePatched(InventoryItemId inventoryItemId) {
        return new AbstractPhysicalInventoryLineEvent.SimplePhysicalInventoryLineStateMergePatched(newPhysicalInventoryLineEventId(inventoryItemId));
    }

    public PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved newPhysicalInventoryLineStateRemoved(InventoryItemId inventoryItemId) {
        return new AbstractPhysicalInventoryLineEvent.SimplePhysicalInventoryLineStateRemoved(newPhysicalInventoryLineEventId(inventoryItemId));
    }


    public abstract String getEventType();


    public static abstract class AbstractPhysicalInventoryStateEvent extends AbstractPhysicalInventoryEvent implements PhysicalInventoryEvent.PhysicalInventoryStateEvent {
        private String documentStatusId;

        public String getDocumentStatusId()
        {
            return this.documentStatusId;
        }

        public void setDocumentStatusId(String documentStatusId)
        {
            this.documentStatusId = documentStatusId;
        }

        private String warehouseId;

        public String getWarehouseId()
        {
            return this.warehouseId;
        }

        public void setWarehouseId(String warehouseId)
        {
            this.warehouseId = warehouseId;
        }

        private String locatorIdPattern;

        public String getLocatorIdPattern()
        {
            return this.locatorIdPattern;
        }

        public void setLocatorIdPattern(String locatorIdPattern)
        {
            this.locatorIdPattern = locatorIdPattern;
        }

        private String productIdPattern;

        public String getProductIdPattern()
        {
            return this.productIdPattern;
        }

        public void setProductIdPattern(String productIdPattern)
        {
            this.productIdPattern = productIdPattern;
        }

        private Boolean posted;

        public Boolean getPosted()
        {
            return this.posted;
        }

        public void setPosted(Boolean posted)
        {
            this.posted = posted;
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

        private String processing;

        public String getProcessing()
        {
            return this.processing;
        }

        public void setProcessing(String processing)
        {
            this.processing = processing;
        }

        private String documentTypeId;

        public String getDocumentTypeId()
        {
            return this.documentTypeId;
        }

        public void setDocumentTypeId(String documentTypeId)
        {
            this.documentTypeId = documentTypeId;
        }

        private Date movementDate;

        public Date getMovementDate()
        {
            return this.movementDate;
        }

        public void setMovementDate(Date movementDate)
        {
            this.movementDate = movementDate;
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

        private Boolean isApproved;

        public Boolean getIsApproved()
        {
            return this.isApproved;
        }

        public void setIsApproved(Boolean isApproved)
        {
            this.isApproved = isApproved;
        }

        private BigDecimal approvalAmount;

        public BigDecimal getApprovalAmount()
        {
            return this.approvalAmount;
        }

        public void setApprovalAmount(BigDecimal approvalAmount)
        {
            this.approvalAmount = approvalAmount;
        }

        private Boolean isQuantityUpdated;

        public Boolean getIsQuantityUpdated()
        {
            return this.isQuantityUpdated;
        }

        public void setIsQuantityUpdated(Boolean isQuantityUpdated)
        {
            this.isQuantityUpdated = isQuantityUpdated;
        }

        private String reversalDocumentNumber;

        public String getReversalDocumentNumber()
        {
            return this.reversalDocumentNumber;
        }

        public void setReversalDocumentNumber(String reversalDocumentNumber)
        {
            this.reversalDocumentNumber = reversalDocumentNumber;
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

        protected AbstractPhysicalInventoryStateEvent(PhysicalInventoryEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPhysicalInventoryStateCreated extends AbstractPhysicalInventoryStateEvent implements PhysicalInventoryEvent.PhysicalInventoryStateCreated, Saveable
    {
        public AbstractPhysicalInventoryStateCreated() {
            this(new PhysicalInventoryEventId());
        }

        public AbstractPhysicalInventoryStateCreated(PhysicalInventoryEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<PhysicalInventoryLineEventId, PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated> physicalInventoryLineEvents = new HashMap<PhysicalInventoryLineEventId, PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated>();
        
        private Iterable<PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated> readOnlyPhysicalInventoryLineEvents;

        public Iterable<PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated> getPhysicalInventoryLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.physicalInventoryLineEvents.values();
            }
            else
            {
                if (readOnlyPhysicalInventoryLineEvents != null) { return readOnlyPhysicalInventoryLineEvents; }
                PhysicalInventoryLineEventDao eventDao = getPhysicalInventoryLineEventDao();
                List<PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated> eL = new ArrayList<PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated>();
                for (PhysicalInventoryLineEvent e : eventDao.findByPhysicalInventoryEventId(this.getPhysicalInventoryEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated)e);
                }
                return (readOnlyPhysicalInventoryLineEvents = eL);
            }
        }

        public void setPhysicalInventoryLineEvents(Iterable<PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated> es)
        {
            if (es != null)
            {
                for (PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e : es)
                {
                    addPhysicalInventoryLineEvent(e);
                }
            }
            else { this.physicalInventoryLineEvents.clear(); }
        }
        
        public void addPhysicalInventoryLineEvent(PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e)
        {
            throwOnInconsistentEventIds((PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent)e);
            this.physicalInventoryLineEvents.put(((PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent)e).getPhysicalInventoryLineEventId(), e);
        }

        public void save()
        {
            for (PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e : this.getPhysicalInventoryLineEvents()) {
                getPhysicalInventoryLineEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractPhysicalInventoryStateMergePatched extends AbstractPhysicalInventoryStateEvent implements PhysicalInventoryEvent.PhysicalInventoryStateMergePatched, Saveable
    {
        public AbstractPhysicalInventoryStateMergePatched() {
            this(new PhysicalInventoryEventId());
        }

        public AbstractPhysicalInventoryStateMergePatched(PhysicalInventoryEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyDocumentStatusIdRemoved;

        public Boolean getIsPropertyDocumentStatusIdRemoved() {
            return this.isPropertyDocumentStatusIdRemoved;
        }

        public void setIsPropertyDocumentStatusIdRemoved(Boolean removed) {
            this.isPropertyDocumentStatusIdRemoved = removed;
        }

        private Boolean isPropertyWarehouseIdRemoved;

        public Boolean getIsPropertyWarehouseIdRemoved() {
            return this.isPropertyWarehouseIdRemoved;
        }

        public void setIsPropertyWarehouseIdRemoved(Boolean removed) {
            this.isPropertyWarehouseIdRemoved = removed;
        }

        private Boolean isPropertyLocatorIdPatternRemoved;

        public Boolean getIsPropertyLocatorIdPatternRemoved() {
            return this.isPropertyLocatorIdPatternRemoved;
        }

        public void setIsPropertyLocatorIdPatternRemoved(Boolean removed) {
            this.isPropertyLocatorIdPatternRemoved = removed;
        }

        private Boolean isPropertyProductIdPatternRemoved;

        public Boolean getIsPropertyProductIdPatternRemoved() {
            return this.isPropertyProductIdPatternRemoved;
        }

        public void setIsPropertyProductIdPatternRemoved(Boolean removed) {
            this.isPropertyProductIdPatternRemoved = removed;
        }

        private Boolean isPropertyPostedRemoved;

        public Boolean getIsPropertyPostedRemoved() {
            return this.isPropertyPostedRemoved;
        }

        public void setIsPropertyPostedRemoved(Boolean removed) {
            this.isPropertyPostedRemoved = removed;
        }

        private Boolean isPropertyProcessedRemoved;

        public Boolean getIsPropertyProcessedRemoved() {
            return this.isPropertyProcessedRemoved;
        }

        public void setIsPropertyProcessedRemoved(Boolean removed) {
            this.isPropertyProcessedRemoved = removed;
        }

        private Boolean isPropertyProcessingRemoved;

        public Boolean getIsPropertyProcessingRemoved() {
            return this.isPropertyProcessingRemoved;
        }

        public void setIsPropertyProcessingRemoved(Boolean removed) {
            this.isPropertyProcessingRemoved = removed;
        }

        private Boolean isPropertyDocumentTypeIdRemoved;

        public Boolean getIsPropertyDocumentTypeIdRemoved() {
            return this.isPropertyDocumentTypeIdRemoved;
        }

        public void setIsPropertyDocumentTypeIdRemoved(Boolean removed) {
            this.isPropertyDocumentTypeIdRemoved = removed;
        }

        private Boolean isPropertyMovementDateRemoved;

        public Boolean getIsPropertyMovementDateRemoved() {
            return this.isPropertyMovementDateRemoved;
        }

        public void setIsPropertyMovementDateRemoved(Boolean removed) {
            this.isPropertyMovementDateRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyIsApprovedRemoved;

        public Boolean getIsPropertyIsApprovedRemoved() {
            return this.isPropertyIsApprovedRemoved;
        }

        public void setIsPropertyIsApprovedRemoved(Boolean removed) {
            this.isPropertyIsApprovedRemoved = removed;
        }

        private Boolean isPropertyApprovalAmountRemoved;

        public Boolean getIsPropertyApprovalAmountRemoved() {
            return this.isPropertyApprovalAmountRemoved;
        }

        public void setIsPropertyApprovalAmountRemoved(Boolean removed) {
            this.isPropertyApprovalAmountRemoved = removed;
        }

        private Boolean isPropertyIsQuantityUpdatedRemoved;

        public Boolean getIsPropertyIsQuantityUpdatedRemoved() {
            return this.isPropertyIsQuantityUpdatedRemoved;
        }

        public void setIsPropertyIsQuantityUpdatedRemoved(Boolean removed) {
            this.isPropertyIsQuantityUpdatedRemoved = removed;
        }

        private Boolean isPropertyReversalDocumentNumberRemoved;

        public Boolean getIsPropertyReversalDocumentNumberRemoved() {
            return this.isPropertyReversalDocumentNumberRemoved;
        }

        public void setIsPropertyReversalDocumentNumberRemoved(Boolean removed) {
            this.isPropertyReversalDocumentNumberRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<PhysicalInventoryLineEventId, PhysicalInventoryLineEvent> physicalInventoryLineEvents = new HashMap<PhysicalInventoryLineEventId, PhysicalInventoryLineEvent>();
        
        private Iterable<PhysicalInventoryLineEvent> readOnlyPhysicalInventoryLineEvents;

        public Iterable<PhysicalInventoryLineEvent> getPhysicalInventoryLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.physicalInventoryLineEvents.values();
            }
            else
            {
                if (readOnlyPhysicalInventoryLineEvents != null) { return readOnlyPhysicalInventoryLineEvents; }
                PhysicalInventoryLineEventDao eventDao = getPhysicalInventoryLineEventDao();
                List<PhysicalInventoryLineEvent> eL = new ArrayList<PhysicalInventoryLineEvent>();
                for (PhysicalInventoryLineEvent e : eventDao.findByPhysicalInventoryEventId(this.getPhysicalInventoryEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((PhysicalInventoryLineEvent)e);
                }
                return (readOnlyPhysicalInventoryLineEvents = eL);
            }
        }

        public void setPhysicalInventoryLineEvents(Iterable<PhysicalInventoryLineEvent> es)
        {
            if (es != null)
            {
                for (PhysicalInventoryLineEvent e : es)
                {
                    addPhysicalInventoryLineEvent(e);
                }
            }
            else { this.physicalInventoryLineEvents.clear(); }
        }
        
        public void addPhysicalInventoryLineEvent(PhysicalInventoryLineEvent e)
        {
            throwOnInconsistentEventIds((PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent)e);
            this.physicalInventoryLineEvents.put(((PhysicalInventoryLineEvent.SqlPhysicalInventoryLineEvent)e).getPhysicalInventoryLineEventId(), e);
        }

        public void save()
        {
            for (PhysicalInventoryLineEvent e : this.getPhysicalInventoryLineEvents()) {
                getPhysicalInventoryLineEventDao().save(e);
            }
        }
    }


    public static class SimplePhysicalInventoryStateCreated extends AbstractPhysicalInventoryStateCreated
    {
        public SimplePhysicalInventoryStateCreated() {
        }

        public SimplePhysicalInventoryStateCreated(PhysicalInventoryEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePhysicalInventoryStateMergePatched extends AbstractPhysicalInventoryStateMergePatched
    {
        public SimplePhysicalInventoryStateMergePatched() {
        }

        public SimplePhysicalInventoryStateMergePatched(PhysicalInventoryEventId eventId) {
            super(eventId);
        }
    }

}

