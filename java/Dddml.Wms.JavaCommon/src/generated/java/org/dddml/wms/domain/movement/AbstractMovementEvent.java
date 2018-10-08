package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractMovementEvent extends AbstractEvent implements MovementEvent.SqlMovementEvent 
{
    private MovementEventId movementEventId;

    public MovementEventId getMovementEventId() {
        return this.movementEventId;
    }

    public void setMovementEventId(MovementEventId eventId) {
        this.movementEventId = eventId;
    }
    
    public String getDocumentNumber() {
        return getMovementEventId().getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber) {
        getMovementEventId().setDocumentNumber(documentNumber);
    }

    public Long getVersion() {
        return getMovementEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getMovementEventId().setVersion(version);
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

    protected AbstractMovementEvent() {
    }

    protected AbstractMovementEvent(MovementEventId eventId) {
        this.movementEventId = eventId;
    }

    protected MovementLineEventDao getMovementLineEventDao() {
        return (MovementLineEventDao)ApplicationContext.current.get("MovementLineEventDao");
    }

    protected MovementLineEventId newMovementLineEventId(String lineNumber)
    {
        MovementLineEventId eventId = new MovementLineEventId(this.getMovementEventId().getDocumentNumber(), 
            lineNumber, 
            this.getMovementEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(MovementLineEvent.SqlMovementLineEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(MovementEvent.SqlMovementEvent oe, MovementLineEvent.SqlMovementLineEvent e)
    {
        if (!oe.getMovementEventId().getDocumentNumber().equals(e.getMovementLineEventId().getMovementDocumentNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id DocumentNumber %1$s but inner id MovementDocumentNumber %2$s", 
                oe.getMovementEventId().getDocumentNumber(), e.getMovementLineEventId().getMovementDocumentNumber());
        }
    }

    public MovementLineEvent.MovementLineStateCreated newMovementLineStateCreated(String lineNumber) {
        return new AbstractMovementLineEvent.SimpleMovementLineStateCreated(newMovementLineEventId(lineNumber));
    }

    public MovementLineEvent.MovementLineStateMergePatched newMovementLineStateMergePatched(String lineNumber) {
        return new AbstractMovementLineEvent.SimpleMovementLineStateMergePatched(newMovementLineEventId(lineNumber));
    }

    public MovementLineEvent.MovementLineStateRemoved newMovementLineStateRemoved(String lineNumber) {
        return new AbstractMovementLineEvent.SimpleMovementLineStateRemoved(newMovementLineEventId(lineNumber));
    }


    public abstract String getEventType();


    public static abstract class AbstractMovementStateEvent extends AbstractMovementEvent implements MovementEvent.MovementStateEvent {
        private String documentStatusId;

        public String getDocumentStatusId()
        {
            return this.documentStatusId;
        }

        public void setDocumentStatusId(String documentStatusId)
        {
            this.documentStatusId = documentStatusId;
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

        private Date dateReceived;

        public Date getDateReceived()
        {
            return this.dateReceived;
        }

        public void setDateReceived(Date dateReceived)
        {
            this.dateReceived = dateReceived;
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

        private Boolean isInTransit;

        public Boolean getIsInTransit()
        {
            return this.isInTransit;
        }

        public void setIsInTransit(Boolean isInTransit)
        {
            this.isInTransit = isInTransit;
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

        private String shipperId;

        public String getShipperId()
        {
            return this.shipperId;
        }

        public void setShipperId(String shipperId)
        {
            this.shipperId = shipperId;
        }

        private String salesRepresentativeId;

        public String getSalesRepresentativeId()
        {
            return this.salesRepresentativeId;
        }

        public void setSalesRepresentativeId(String salesRepresentativeId)
        {
            this.salesRepresentativeId = salesRepresentativeId;
        }

        private String businessPartnerId;

        public String getBusinessPartnerId()
        {
            return this.businessPartnerId;
        }

        public void setBusinessPartnerId(String businessPartnerId)
        {
            this.businessPartnerId = businessPartnerId;
        }

        private BigDecimal chargeAmount;

        public BigDecimal getChargeAmount()
        {
            return this.chargeAmount;
        }

        public void setChargeAmount(BigDecimal chargeAmount)
        {
            this.chargeAmount = chargeAmount;
        }

        private String createFrom;

        public String getCreateFrom()
        {
            return this.createFrom;
        }

        public void setCreateFrom(String createFrom)
        {
            this.createFrom = createFrom;
        }

        private BigDecimal freightAmount;

        public BigDecimal getFreightAmount()
        {
            return this.freightAmount;
        }

        public void setFreightAmount(BigDecimal freightAmount)
        {
            this.freightAmount = freightAmount;
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

        private String warehouseIdFrom;

        public String getWarehouseIdFrom()
        {
            return this.warehouseIdFrom;
        }

        public void setWarehouseIdFrom(String warehouseIdFrom)
        {
            this.warehouseIdFrom = warehouseIdFrom;
        }

        private String warehouseIdTo;

        public String getWarehouseIdTo()
        {
            return this.warehouseIdTo;
        }

        public void setWarehouseIdTo(String warehouseIdTo)
        {
            this.warehouseIdTo = warehouseIdTo;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractMovementStateEvent(MovementEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractMovementStateCreated extends AbstractMovementStateEvent implements MovementEvent.MovementStateCreated, Saveable
    {
        public AbstractMovementStateCreated() {
            this(new MovementEventId());
        }

        public AbstractMovementStateCreated(MovementEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<MovementLineEventId, MovementLineEvent.MovementLineStateCreated> movementLineEvents = new HashMap<MovementLineEventId, MovementLineEvent.MovementLineStateCreated>();
        
        private Iterable<MovementLineEvent.MovementLineStateCreated> readOnlyMovementLineEvents;

        public Iterable<MovementLineEvent.MovementLineStateCreated> getMovementLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.movementLineEvents.values();
            }
            else
            {
                if (readOnlyMovementLineEvents != null) { return readOnlyMovementLineEvents; }
                MovementLineEventDao eventDao = getMovementLineEventDao();
                List<MovementLineEvent.MovementLineStateCreated> eL = new ArrayList<MovementLineEvent.MovementLineStateCreated>();
                for (MovementLineEvent e : eventDao.findByMovementEventId(this.getMovementEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((MovementLineEvent.MovementLineStateCreated)e);
                }
                return (readOnlyMovementLineEvents = eL);
            }
        }

        public void setMovementLineEvents(Iterable<MovementLineEvent.MovementLineStateCreated> es)
        {
            if (es != null)
            {
                for (MovementLineEvent.MovementLineStateCreated e : es)
                {
                    addMovementLineEvent(e);
                }
            }
            else { this.movementLineEvents.clear(); }
        }
        
        public void addMovementLineEvent(MovementLineEvent.MovementLineStateCreated e)
        {
            throwOnInconsistentEventIds((MovementLineEvent.SqlMovementLineEvent)e);
            this.movementLineEvents.put(((MovementLineEvent.SqlMovementLineEvent)e).getMovementLineEventId(), e);
        }

        public void save()
        {
            for (MovementLineEvent.MovementLineStateCreated e : this.getMovementLineEvents()) {
                getMovementLineEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementStateMergePatched extends AbstractMovementStateEvent implements MovementEvent.MovementStateMergePatched, Saveable
    {
        public AbstractMovementStateMergePatched() {
            this(new MovementEventId());
        }

        public AbstractMovementStateMergePatched(MovementEventId eventId) {
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

        private Boolean isPropertyMovementDateRemoved;

        public Boolean getIsPropertyMovementDateRemoved() {
            return this.isPropertyMovementDateRemoved;
        }

        public void setIsPropertyMovementDateRemoved(Boolean removed) {
            this.isPropertyMovementDateRemoved = removed;
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

        private Boolean isPropertyDateReceivedRemoved;

        public Boolean getIsPropertyDateReceivedRemoved() {
            return this.isPropertyDateReceivedRemoved;
        }

        public void setIsPropertyDateReceivedRemoved(Boolean removed) {
            this.isPropertyDateReceivedRemoved = removed;
        }

        private Boolean isPropertyDocumentTypeIdRemoved;

        public Boolean getIsPropertyDocumentTypeIdRemoved() {
            return this.isPropertyDocumentTypeIdRemoved;
        }

        public void setIsPropertyDocumentTypeIdRemoved(Boolean removed) {
            this.isPropertyDocumentTypeIdRemoved = removed;
        }

        private Boolean isPropertyIsInTransitRemoved;

        public Boolean getIsPropertyIsInTransitRemoved() {
            return this.isPropertyIsInTransitRemoved;
        }

        public void setIsPropertyIsInTransitRemoved(Boolean removed) {
            this.isPropertyIsInTransitRemoved = removed;
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

        private Boolean isPropertyShipperIdRemoved;

        public Boolean getIsPropertyShipperIdRemoved() {
            return this.isPropertyShipperIdRemoved;
        }

        public void setIsPropertyShipperIdRemoved(Boolean removed) {
            this.isPropertyShipperIdRemoved = removed;
        }

        private Boolean isPropertySalesRepresentativeIdRemoved;

        public Boolean getIsPropertySalesRepresentativeIdRemoved() {
            return this.isPropertySalesRepresentativeIdRemoved;
        }

        public void setIsPropertySalesRepresentativeIdRemoved(Boolean removed) {
            this.isPropertySalesRepresentativeIdRemoved = removed;
        }

        private Boolean isPropertyBusinessPartnerIdRemoved;

        public Boolean getIsPropertyBusinessPartnerIdRemoved() {
            return this.isPropertyBusinessPartnerIdRemoved;
        }

        public void setIsPropertyBusinessPartnerIdRemoved(Boolean removed) {
            this.isPropertyBusinessPartnerIdRemoved = removed;
        }

        private Boolean isPropertyChargeAmountRemoved;

        public Boolean getIsPropertyChargeAmountRemoved() {
            return this.isPropertyChargeAmountRemoved;
        }

        public void setIsPropertyChargeAmountRemoved(Boolean removed) {
            this.isPropertyChargeAmountRemoved = removed;
        }

        private Boolean isPropertyCreateFromRemoved;

        public Boolean getIsPropertyCreateFromRemoved() {
            return this.isPropertyCreateFromRemoved;
        }

        public void setIsPropertyCreateFromRemoved(Boolean removed) {
            this.isPropertyCreateFromRemoved = removed;
        }

        private Boolean isPropertyFreightAmountRemoved;

        public Boolean getIsPropertyFreightAmountRemoved() {
            return this.isPropertyFreightAmountRemoved;
        }

        public void setIsPropertyFreightAmountRemoved(Boolean removed) {
            this.isPropertyFreightAmountRemoved = removed;
        }

        private Boolean isPropertyReversalDocumentNumberRemoved;

        public Boolean getIsPropertyReversalDocumentNumberRemoved() {
            return this.isPropertyReversalDocumentNumberRemoved;
        }

        public void setIsPropertyReversalDocumentNumberRemoved(Boolean removed) {
            this.isPropertyReversalDocumentNumberRemoved = removed;
        }

        private Boolean isPropertyWarehouseIdFromRemoved;

        public Boolean getIsPropertyWarehouseIdFromRemoved() {
            return this.isPropertyWarehouseIdFromRemoved;
        }

        public void setIsPropertyWarehouseIdFromRemoved(Boolean removed) {
            this.isPropertyWarehouseIdFromRemoved = removed;
        }

        private Boolean isPropertyWarehouseIdToRemoved;

        public Boolean getIsPropertyWarehouseIdToRemoved() {
            return this.isPropertyWarehouseIdToRemoved;
        }

        public void setIsPropertyWarehouseIdToRemoved(Boolean removed) {
            this.isPropertyWarehouseIdToRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<MovementLineEventId, MovementLineEvent> movementLineEvents = new HashMap<MovementLineEventId, MovementLineEvent>();
        
        private Iterable<MovementLineEvent> readOnlyMovementLineEvents;

        public Iterable<MovementLineEvent> getMovementLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.movementLineEvents.values();
            }
            else
            {
                if (readOnlyMovementLineEvents != null) { return readOnlyMovementLineEvents; }
                MovementLineEventDao eventDao = getMovementLineEventDao();
                List<MovementLineEvent> eL = new ArrayList<MovementLineEvent>();
                for (MovementLineEvent e : eventDao.findByMovementEventId(this.getMovementEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((MovementLineEvent)e);
                }
                return (readOnlyMovementLineEvents = eL);
            }
        }

        public void setMovementLineEvents(Iterable<MovementLineEvent> es)
        {
            if (es != null)
            {
                for (MovementLineEvent e : es)
                {
                    addMovementLineEvent(e);
                }
            }
            else { this.movementLineEvents.clear(); }
        }
        
        public void addMovementLineEvent(MovementLineEvent e)
        {
            throwOnInconsistentEventIds((MovementLineEvent.SqlMovementLineEvent)e);
            this.movementLineEvents.put(((MovementLineEvent.SqlMovementLineEvent)e).getMovementLineEventId(), e);
        }

        public void save()
        {
            for (MovementLineEvent e : this.getMovementLineEvents()) {
                getMovementLineEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementStateDeleted extends AbstractMovementStateEvent implements MovementEvent.MovementStateDeleted, Saveable
    {
        public AbstractMovementStateDeleted() {
            this(new MovementEventId());
        }

        public AbstractMovementStateDeleted(MovementEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<MovementLineEventId, MovementLineEvent.MovementLineStateRemoved> movementLineEvents = new HashMap<MovementLineEventId, MovementLineEvent.MovementLineStateRemoved>();
        
        private Iterable<MovementLineEvent.MovementLineStateRemoved> readOnlyMovementLineEvents;

        public Iterable<MovementLineEvent.MovementLineStateRemoved> getMovementLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.movementLineEvents.values();
            }
            else
            {
                if (readOnlyMovementLineEvents != null) { return readOnlyMovementLineEvents; }
                MovementLineEventDao eventDao = getMovementLineEventDao();
                List<MovementLineEvent.MovementLineStateRemoved> eL = new ArrayList<MovementLineEvent.MovementLineStateRemoved>();
                for (MovementLineEvent e : eventDao.findByMovementEventId(this.getMovementEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((MovementLineEvent.MovementLineStateRemoved)e);
                }
                return (readOnlyMovementLineEvents = eL);
            }
        }

        public void setMovementLineEvents(Iterable<MovementLineEvent.MovementLineStateRemoved> es)
        {
            if (es != null)
            {
                for (MovementLineEvent.MovementLineStateRemoved e : es)
                {
                    addMovementLineEvent(e);
                }
            }
            else { this.movementLineEvents.clear(); }
        }
        
        public void addMovementLineEvent(MovementLineEvent.MovementLineStateRemoved e)
        {
            throwOnInconsistentEventIds((MovementLineEvent.SqlMovementLineEvent)e);
            this.movementLineEvents.put(((MovementLineEvent.SqlMovementLineEvent)e).getMovementLineEventId(), e);
        }

        public void save()
        {
            for (MovementLineEvent.MovementLineStateRemoved e : this.getMovementLineEvents()) {
                getMovementLineEventDao().save(e);
            }
        }
    }
    public static class SimpleMovementStateCreated extends AbstractMovementStateCreated
    {
        public SimpleMovementStateCreated() {
        }

        public SimpleMovementStateCreated(MovementEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementStateMergePatched extends AbstractMovementStateMergePatched
    {
        public SimpleMovementStateMergePatched() {
        }

        public SimpleMovementStateMergePatched(MovementEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementStateDeleted extends AbstractMovementStateDeleted
    {
        public SimpleMovementStateDeleted() {
        }

        public SimpleMovementStateDeleted(MovementEventId eventId) {
            super(eventId);
        }
    }

}

