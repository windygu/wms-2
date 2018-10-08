package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractMovementConfirmationEvent extends AbstractEvent implements MovementConfirmationEvent.SqlMovementConfirmationEvent 
{
    private MovementConfirmationEventId movementConfirmationEventId;

    public MovementConfirmationEventId getMovementConfirmationEventId() {
        return this.movementConfirmationEventId;
    }

    public void setMovementConfirmationEventId(MovementConfirmationEventId eventId) {
        this.movementConfirmationEventId = eventId;
    }
    
    public String getDocumentNumber() {
        return getMovementConfirmationEventId().getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber) {
        getMovementConfirmationEventId().setDocumentNumber(documentNumber);
    }

    public Long getVersion() {
        return getMovementConfirmationEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getMovementConfirmationEventId().setVersion(version);
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

    protected AbstractMovementConfirmationEvent() {
    }

    protected AbstractMovementConfirmationEvent(MovementConfirmationEventId eventId) {
        this.movementConfirmationEventId = eventId;
    }

    protected MovementConfirmationLineEventDao getMovementConfirmationLineEventDao() {
        return (MovementConfirmationLineEventDao)ApplicationContext.current.get("MovementConfirmationLineEventDao");
    }

    protected MovementConfirmationLineEventId newMovementConfirmationLineEventId(String lineNumber)
    {
        MovementConfirmationLineEventId eventId = new MovementConfirmationLineEventId(this.getMovementConfirmationEventId().getDocumentNumber(), 
            lineNumber, 
            this.getMovementConfirmationEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(MovementConfirmationEvent.SqlMovementConfirmationEvent oe, MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent e)
    {
        if (!oe.getMovementConfirmationEventId().getDocumentNumber().equals(e.getMovementConfirmationLineEventId().getMovementConfirmationDocumentNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id DocumentNumber %1$s but inner id MovementConfirmationDocumentNumber %2$s", 
                oe.getMovementConfirmationEventId().getDocumentNumber(), e.getMovementConfirmationLineEventId().getMovementConfirmationDocumentNumber());
        }
    }

    public MovementConfirmationLineEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(String lineNumber) {
        return new AbstractMovementConfirmationLineEvent.SimpleMovementConfirmationLineStateCreated(newMovementConfirmationLineEventId(lineNumber));
    }

    public MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched newMovementConfirmationLineStateMergePatched(String lineNumber) {
        return new AbstractMovementConfirmationLineEvent.SimpleMovementConfirmationLineStateMergePatched(newMovementConfirmationLineEventId(lineNumber));
    }

    public MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(String lineNumber) {
        return new AbstractMovementConfirmationLineEvent.SimpleMovementConfirmationLineStateRemoved(newMovementConfirmationLineEventId(lineNumber));
    }


    public abstract String getEventType();


    public static abstract class AbstractMovementConfirmationStateEvent extends AbstractMovementConfirmationEvent implements MovementConfirmationEvent.MovementConfirmationStateEvent {
        private String documentStatusId;

        public String getDocumentStatusId()
        {
            return this.documentStatusId;
        }

        public void setDocumentStatusId(String documentStatusId)
        {
            this.documentStatusId = documentStatusId;
        }

        private String movementDocumentNumber;

        public String getMovementDocumentNumber()
        {
            return this.movementDocumentNumber;
        }

        public void setMovementDocumentNumber(String movementDocumentNumber)
        {
            this.movementDocumentNumber = movementDocumentNumber;
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

        protected AbstractMovementConfirmationStateEvent(MovementConfirmationEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractMovementConfirmationStateCreated extends AbstractMovementConfirmationStateEvent implements MovementConfirmationEvent.MovementConfirmationStateCreated, Saveable
    {
        public AbstractMovementConfirmationStateCreated() {
            this(new MovementConfirmationEventId());
        }

        public AbstractMovementConfirmationStateCreated(MovementConfirmationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<MovementConfirmationLineEventId, MovementConfirmationLineEvent.MovementConfirmationLineStateCreated> movementConfirmationLineEvents = new HashMap<MovementConfirmationLineEventId, MovementConfirmationLineEvent.MovementConfirmationLineStateCreated>();
        
        private Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateCreated> readOnlyMovementConfirmationLineEvents;

        public Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateCreated> getMovementConfirmationLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.movementConfirmationLineEvents.values();
            }
            else
            {
                if (readOnlyMovementConfirmationLineEvents != null) { return readOnlyMovementConfirmationLineEvents; }
                MovementConfirmationLineEventDao eventDao = getMovementConfirmationLineEventDao();
                List<MovementConfirmationLineEvent.MovementConfirmationLineStateCreated> eL = new ArrayList<MovementConfirmationLineEvent.MovementConfirmationLineStateCreated>();
                for (MovementConfirmationLineEvent e : eventDao.findByMovementConfirmationEventId(this.getMovementConfirmationEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((MovementConfirmationLineEvent.MovementConfirmationLineStateCreated)e);
                }
                return (readOnlyMovementConfirmationLineEvents = eL);
            }
        }

        public void setMovementConfirmationLineEvents(Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateCreated> es)
        {
            if (es != null)
            {
                for (MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e : es)
                {
                    addMovementConfirmationLineEvent(e);
                }
            }
            else { this.movementConfirmationLineEvents.clear(); }
        }
        
        public void addMovementConfirmationLineEvent(MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e)
        {
            throwOnInconsistentEventIds((MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent)e);
            this.movementConfirmationLineEvents.put(((MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent)e).getMovementConfirmationLineEventId(), e);
        }

        public void save()
        {
            for (MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e : this.getMovementConfirmationLineEvents()) {
                getMovementConfirmationLineEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementConfirmationStateMergePatched extends AbstractMovementConfirmationStateEvent implements MovementConfirmationEvent.MovementConfirmationStateMergePatched, Saveable
    {
        public AbstractMovementConfirmationStateMergePatched() {
            this(new MovementConfirmationEventId());
        }

        public AbstractMovementConfirmationStateMergePatched(MovementConfirmationEventId eventId) {
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

        private Boolean isPropertyMovementDocumentNumberRemoved;

        public Boolean getIsPropertyMovementDocumentNumberRemoved() {
            return this.isPropertyMovementDocumentNumberRemoved;
        }

        public void setIsPropertyMovementDocumentNumberRemoved(Boolean removed) {
            this.isPropertyMovementDocumentNumberRemoved = removed;
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

        private Map<MovementConfirmationLineEventId, MovementConfirmationLineEvent> movementConfirmationLineEvents = new HashMap<MovementConfirmationLineEventId, MovementConfirmationLineEvent>();
        
        private Iterable<MovementConfirmationLineEvent> readOnlyMovementConfirmationLineEvents;

        public Iterable<MovementConfirmationLineEvent> getMovementConfirmationLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.movementConfirmationLineEvents.values();
            }
            else
            {
                if (readOnlyMovementConfirmationLineEvents != null) { return readOnlyMovementConfirmationLineEvents; }
                MovementConfirmationLineEventDao eventDao = getMovementConfirmationLineEventDao();
                List<MovementConfirmationLineEvent> eL = new ArrayList<MovementConfirmationLineEvent>();
                for (MovementConfirmationLineEvent e : eventDao.findByMovementConfirmationEventId(this.getMovementConfirmationEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((MovementConfirmationLineEvent)e);
                }
                return (readOnlyMovementConfirmationLineEvents = eL);
            }
        }

        public void setMovementConfirmationLineEvents(Iterable<MovementConfirmationLineEvent> es)
        {
            if (es != null)
            {
                for (MovementConfirmationLineEvent e : es)
                {
                    addMovementConfirmationLineEvent(e);
                }
            }
            else { this.movementConfirmationLineEvents.clear(); }
        }
        
        public void addMovementConfirmationLineEvent(MovementConfirmationLineEvent e)
        {
            throwOnInconsistentEventIds((MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent)e);
            this.movementConfirmationLineEvents.put(((MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent)e).getMovementConfirmationLineEventId(), e);
        }

        public void save()
        {
            for (MovementConfirmationLineEvent e : this.getMovementConfirmationLineEvents()) {
                getMovementConfirmationLineEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementConfirmationStateDeleted extends AbstractMovementConfirmationStateEvent implements MovementConfirmationEvent.MovementConfirmationStateDeleted, Saveable
    {
        public AbstractMovementConfirmationStateDeleted() {
            this(new MovementConfirmationEventId());
        }

        public AbstractMovementConfirmationStateDeleted(MovementConfirmationEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<MovementConfirmationLineEventId, MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved> movementConfirmationLineEvents = new HashMap<MovementConfirmationLineEventId, MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved>();
        
        private Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved> readOnlyMovementConfirmationLineEvents;

        public Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved> getMovementConfirmationLineEvents()
        {
            if (!getEventReadOnly())
            {
                return this.movementConfirmationLineEvents.values();
            }
            else
            {
                if (readOnlyMovementConfirmationLineEvents != null) { return readOnlyMovementConfirmationLineEvents; }
                MovementConfirmationLineEventDao eventDao = getMovementConfirmationLineEventDao();
                List<MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved> eL = new ArrayList<MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved>();
                for (MovementConfirmationLineEvent e : eventDao.findByMovementConfirmationEventId(this.getMovementConfirmationEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved)e);
                }
                return (readOnlyMovementConfirmationLineEvents = eL);
            }
        }

        public void setMovementConfirmationLineEvents(Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved> es)
        {
            if (es != null)
            {
                for (MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e : es)
                {
                    addMovementConfirmationLineEvent(e);
                }
            }
            else { this.movementConfirmationLineEvents.clear(); }
        }
        
        public void addMovementConfirmationLineEvent(MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e)
        {
            throwOnInconsistentEventIds((MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent)e);
            this.movementConfirmationLineEvents.put(((MovementConfirmationLineEvent.SqlMovementConfirmationLineEvent)e).getMovementConfirmationLineEventId(), e);
        }

        public void save()
        {
            for (MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e : this.getMovementConfirmationLineEvents()) {
                getMovementConfirmationLineEventDao().save(e);
            }
        }
    }
    public static class SimpleMovementConfirmationStateCreated extends AbstractMovementConfirmationStateCreated
    {
        public SimpleMovementConfirmationStateCreated() {
        }

        public SimpleMovementConfirmationStateCreated(MovementConfirmationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementConfirmationStateMergePatched extends AbstractMovementConfirmationStateMergePatched
    {
        public SimpleMovementConfirmationStateMergePatched() {
        }

        public SimpleMovementConfirmationStateMergePatched(MovementConfirmationEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleMovementConfirmationStateDeleted extends AbstractMovementConfirmationStateDeleted
    {
        public SimpleMovementConfirmationStateDeleted() {
        }

        public SimpleMovementConfirmationStateDeleted(MovementConfirmationEventId eventId) {
            super(eventId);
        }
    }

}

