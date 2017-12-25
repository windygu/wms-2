package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractMovementStateEvent extends AbstractStateEvent implements MovementStateEvent 
{
    private MovementStateEventId stateEventId;

    public MovementStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MovementStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getDocumentNumber() {
        return getStateEventId().getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber) {
        getStateEventId().setDocumentNumber(documentNumber);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractMovementStateEvent() {
    }

    protected AbstractMovementStateEvent(MovementStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected MovementLineStateEventDao getMovementLineStateEventDao() {
        return (MovementLineStateEventDao)ApplicationContext.current.get("MovementLineStateEventDao");
    }

    protected MovementLineStateEventId newMovementLineStateEventId(String lineNumber)
    {
        MovementLineStateEventId stateEventId = new MovementLineStateEventId(this.getStateEventId().getDocumentNumber(), 
            lineNumber, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(MovementLineStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(MovementStateEvent oe, MovementLineStateEvent e)
    {
        if (!oe.getStateEventId().getDocumentNumber().equals(e.getStateEventId().getMovementDocumentNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id DocumentNumber %1$s but inner id MovementDocumentNumber %2$s", 
                oe.getStateEventId().getDocumentNumber(), e.getStateEventId().getMovementDocumentNumber());
        }
    }

    public MovementLineStateEvent.MovementLineStateCreated newMovementLineStateCreated(String lineNumber) {
        return new AbstractMovementLineStateEvent.SimpleMovementLineStateCreated(newMovementLineStateEventId(lineNumber));
    }

    public MovementLineStateEvent.MovementLineStateMergePatched newMovementLineStateMergePatched(String lineNumber) {
        return new AbstractMovementLineStateEvent.SimpleMovementLineStateMergePatched(newMovementLineStateEventId(lineNumber));
    }

    public MovementLineStateEvent.MovementLineStateRemoved newMovementLineStateRemoved(String lineNumber) {
        return new AbstractMovementLineStateEvent.SimpleMovementLineStateRemoved(newMovementLineStateEventId(lineNumber));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMovementStateCreated extends AbstractMovementStateEvent implements MovementStateEvent.MovementStateCreated, Saveable
    {
        public AbstractMovementStateCreated() {
            this(new MovementStateEventId());
        }

        public AbstractMovementStateCreated(MovementStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<MovementLineStateEventId, MovementLineStateEvent.MovementLineStateCreated> movementLineEvents = new HashMap<MovementLineStateEventId, MovementLineStateEvent.MovementLineStateCreated>();
        
        private Iterable<MovementLineStateEvent.MovementLineStateCreated> readOnlyMovementLineEvents;

        public Iterable<MovementLineStateEvent.MovementLineStateCreated> getMovementLineEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.movementLineEvents.values();
            }
            else
            {
                if (readOnlyMovementLineEvents != null) { return readOnlyMovementLineEvents; }
                MovementLineStateEventDao eventDao = getMovementLineStateEventDao();
                List<MovementLineStateEvent.MovementLineStateCreated> eL = new ArrayList<MovementLineStateEvent.MovementLineStateCreated>();
                for (MovementLineStateEvent e : eventDao.findByMovementStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((MovementLineStateEvent.MovementLineStateCreated)e);
                }
                return (readOnlyMovementLineEvents = eL);
            }
        }

        public void setMovementLineEvents(Iterable<MovementLineStateEvent.MovementLineStateCreated> es)
        {
            if (es != null)
            {
                for (MovementLineStateEvent.MovementLineStateCreated e : es)
                {
                    addMovementLineEvent(e);
                }
            }
            else { this.movementLineEvents.clear(); }
        }
        
        public void addMovementLineEvent(MovementLineStateEvent.MovementLineStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.movementLineEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (MovementLineStateEvent.MovementLineStateCreated e : this.getMovementLineEvents()) {
                getMovementLineStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementStateMergePatched extends AbstractMovementStateEvent implements MovementStateEvent.MovementStateMergePatched, Saveable
    {
        public AbstractMovementStateMergePatched() {
            this(new MovementStateEventId());
        }

        public AbstractMovementStateMergePatched(MovementStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
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

        private Map<MovementLineStateEventId, MovementLineStateEvent> movementLineEvents = new HashMap<MovementLineStateEventId, MovementLineStateEvent>();
        
        private Iterable<MovementLineStateEvent> readOnlyMovementLineEvents;

        public Iterable<MovementLineStateEvent> getMovementLineEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.movementLineEvents.values();
            }
            else
            {
                if (readOnlyMovementLineEvents != null) { return readOnlyMovementLineEvents; }
                MovementLineStateEventDao eventDao = getMovementLineStateEventDao();
                List<MovementLineStateEvent> eL = new ArrayList<MovementLineStateEvent>();
                for (MovementLineStateEvent e : eventDao.findByMovementStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((MovementLineStateEvent)e);
                }
                return (readOnlyMovementLineEvents = eL);
            }
        }

        public void setMovementLineEvents(Iterable<MovementLineStateEvent> es)
        {
            if (es != null)
            {
                for (MovementLineStateEvent e : es)
                {
                    addMovementLineEvent(e);
                }
            }
            else { this.movementLineEvents.clear(); }
        }
        
        public void addMovementLineEvent(MovementLineStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.movementLineEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (MovementLineStateEvent e : this.getMovementLineEvents()) {
                getMovementLineStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementStateDeleted extends AbstractMovementStateEvent implements MovementStateEvent.MovementStateDeleted, Saveable
    {
        public AbstractMovementStateDeleted() {
            this(new MovementStateEventId());
        }

        public AbstractMovementStateDeleted(MovementStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<MovementLineStateEventId, MovementLineStateEvent.MovementLineStateRemoved> movementLineEvents = new HashMap<MovementLineStateEventId, MovementLineStateEvent.MovementLineStateRemoved>();
        
        private Iterable<MovementLineStateEvent.MovementLineStateRemoved> readOnlyMovementLineEvents;

        public Iterable<MovementLineStateEvent.MovementLineStateRemoved> getMovementLineEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.movementLineEvents.values();
            }
            else
            {
                if (readOnlyMovementLineEvents != null) { return readOnlyMovementLineEvents; }
                MovementLineStateEventDao eventDao = getMovementLineStateEventDao();
                List<MovementLineStateEvent.MovementLineStateRemoved> eL = new ArrayList<MovementLineStateEvent.MovementLineStateRemoved>();
                for (MovementLineStateEvent e : eventDao.findByMovementStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((MovementLineStateEvent.MovementLineStateRemoved)e);
                }
                return (readOnlyMovementLineEvents = eL);
            }
        }

        public void setMovementLineEvents(Iterable<MovementLineStateEvent.MovementLineStateRemoved> es)
        {
            if (es != null)
            {
                for (MovementLineStateEvent.MovementLineStateRemoved e : es)
                {
                    addMovementLineEvent(e);
                }
            }
            else { this.movementLineEvents.clear(); }
        }
        
        public void addMovementLineEvent(MovementLineStateEvent.MovementLineStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.movementLineEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (MovementLineStateEvent.MovementLineStateRemoved e : this.getMovementLineEvents()) {
                getMovementLineStateEventDao().save(e);
            }
        }
    }
    public static class SimpleMovementStateCreated extends AbstractMovementStateCreated
    {
        public SimpleMovementStateCreated() {
        }

        public SimpleMovementStateCreated(MovementStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementStateMergePatched extends AbstractMovementStateMergePatched
    {
        public SimpleMovementStateMergePatched() {
        }

        public SimpleMovementStateMergePatched(MovementStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementStateDeleted extends AbstractMovementStateDeleted
    {
        public SimpleMovementStateDeleted() {
        }

        public SimpleMovementStateDeleted(MovementStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

