package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractMovementConfirmationStateEvent extends AbstractStateEvent implements MovementConfirmationStateEvent 
{
    private MovementConfirmationStateEventId stateEventId;

    public MovementConfirmationStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(MovementConfirmationStateEventId stateEventId) {
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

    protected AbstractMovementConfirmationStateEvent() {
    }

    protected AbstractMovementConfirmationStateEvent(MovementConfirmationStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected MovementConfirmationLineStateEventDao getMovementConfirmationLineStateEventDao() {
        return (MovementConfirmationLineStateEventDao)ApplicationContext.current.get("MovementConfirmationLineStateEventDao");
    }

    protected MovementConfirmationLineStateEventId newMovementConfirmationLineStateEventId(String lineNumber)
    {
        MovementConfirmationLineStateEventId stateEventId = new MovementConfirmationLineStateEventId(this.getStateEventId().getDocumentNumber(), 
            lineNumber, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(MovementConfirmationLineStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(MovementConfirmationStateEvent oe, MovementConfirmationLineStateEvent e)
    {
        if (!oe.getStateEventId().getDocumentNumber().equals(e.getStateEventId().getMovementConfirmationDocumentNumber()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id DocumentNumber %1$s but inner id MovementConfirmationDocumentNumber %2$s", 
                oe.getStateEventId().getDocumentNumber(), e.getStateEventId().getMovementConfirmationDocumentNumber());
        }
    }

    public MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(String lineNumber) {
        return new AbstractMovementConfirmationLineStateEvent.SimpleMovementConfirmationLineStateCreated(newMovementConfirmationLineStateEventId(lineNumber));
    }

    public MovementConfirmationLineStateEvent.MovementConfirmationLineStateMergePatched newMovementConfirmationLineStateMergePatched(String lineNumber) {
        return new AbstractMovementConfirmationLineStateEvent.SimpleMovementConfirmationLineStateMergePatched(newMovementConfirmationLineStateEventId(lineNumber));
    }

    public MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(String lineNumber) {
        return new AbstractMovementConfirmationLineStateEvent.SimpleMovementConfirmationLineStateRemoved(newMovementConfirmationLineStateEventId(lineNumber));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractMovementConfirmationStateCreated extends AbstractMovementConfirmationStateEvent implements MovementConfirmationStateEvent.MovementConfirmationStateCreated, Saveable
    {
        public AbstractMovementConfirmationStateCreated() {
            this(new MovementConfirmationStateEventId());
        }

        public AbstractMovementConfirmationStateCreated(MovementConfirmationStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<MovementConfirmationLineStateEventId, MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated> movementConfirmationLineEvents = new HashMap<MovementConfirmationLineStateEventId, MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated>();
        
        private Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated> readOnlyMovementConfirmationLineEvents;

        public Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated> getMovementConfirmationLineEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.movementConfirmationLineEvents.values();
            }
            else
            {
                if (readOnlyMovementConfirmationLineEvents != null) { return readOnlyMovementConfirmationLineEvents; }
                MovementConfirmationLineStateEventDao eventDao = getMovementConfirmationLineStateEventDao();
                List<MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated> eL = new ArrayList<MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated>();
                for (MovementConfirmationLineStateEvent e : eventDao.findByMovementConfirmationStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated)e);
                }
                return (readOnlyMovementConfirmationLineEvents = eL);
            }
        }

        public void setMovementConfirmationLineEvents(Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated> es)
        {
            if (es != null)
            {
                for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated e : es)
                {
                    addMovementConfirmationLineEvent(e);
                }
            }
            else { this.movementConfirmationLineEvents.clear(); }
        }
        
        public void addMovementConfirmationLineEvent(MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.movementConfirmationLineEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated e : this.getMovementConfirmationLineEvents()) {
                getMovementConfirmationLineStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementConfirmationStateMergePatched extends AbstractMovementConfirmationStateEvent implements MovementConfirmationStateEvent.MovementConfirmationStateMergePatched, Saveable
    {
        public AbstractMovementConfirmationStateMergePatched() {
            this(new MovementConfirmationStateEventId());
        }

        public AbstractMovementConfirmationStateMergePatched(MovementConfirmationStateEventId stateEventId) {
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

        private Map<MovementConfirmationLineStateEventId, MovementConfirmationLineStateEvent> movementConfirmationLineEvents = new HashMap<MovementConfirmationLineStateEventId, MovementConfirmationLineStateEvent>();
        
        private Iterable<MovementConfirmationLineStateEvent> readOnlyMovementConfirmationLineEvents;

        public Iterable<MovementConfirmationLineStateEvent> getMovementConfirmationLineEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.movementConfirmationLineEvents.values();
            }
            else
            {
                if (readOnlyMovementConfirmationLineEvents != null) { return readOnlyMovementConfirmationLineEvents; }
                MovementConfirmationLineStateEventDao eventDao = getMovementConfirmationLineStateEventDao();
                List<MovementConfirmationLineStateEvent> eL = new ArrayList<MovementConfirmationLineStateEvent>();
                for (MovementConfirmationLineStateEvent e : eventDao.findByMovementConfirmationStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((MovementConfirmationLineStateEvent)e);
                }
                return (readOnlyMovementConfirmationLineEvents = eL);
            }
        }

        public void setMovementConfirmationLineEvents(Iterable<MovementConfirmationLineStateEvent> es)
        {
            if (es != null)
            {
                for (MovementConfirmationLineStateEvent e : es)
                {
                    addMovementConfirmationLineEvent(e);
                }
            }
            else { this.movementConfirmationLineEvents.clear(); }
        }
        
        public void addMovementConfirmationLineEvent(MovementConfirmationLineStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.movementConfirmationLineEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (MovementConfirmationLineStateEvent e : this.getMovementConfirmationLineEvents()) {
                getMovementConfirmationLineStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractMovementConfirmationStateDeleted extends AbstractMovementConfirmationStateEvent implements MovementConfirmationStateEvent.MovementConfirmationStateDeleted, Saveable
    {
        public AbstractMovementConfirmationStateDeleted() {
            this(new MovementConfirmationStateEventId());
        }

        public AbstractMovementConfirmationStateDeleted(MovementConfirmationStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

		
        private Map<MovementConfirmationLineStateEventId, MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved> movementConfirmationLineEvents = new HashMap<MovementConfirmationLineStateEventId, MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved>();
        
        private Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved> readOnlyMovementConfirmationLineEvents;

        public Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved> getMovementConfirmationLineEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.movementConfirmationLineEvents.values();
            }
            else
            {
                if (readOnlyMovementConfirmationLineEvents != null) { return readOnlyMovementConfirmationLineEvents; }
                MovementConfirmationLineStateEventDao eventDao = getMovementConfirmationLineStateEventDao();
                List<MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved> eL = new ArrayList<MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved>();
                for (MovementConfirmationLineStateEvent e : eventDao.findByMovementConfirmationStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved)e);
                }
                return (readOnlyMovementConfirmationLineEvents = eL);
            }
        }

        public void setMovementConfirmationLineEvents(Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved> es)
        {
            if (es != null)
            {
                for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved e : es)
                {
                    addMovementConfirmationLineEvent(e);
                }
            }
            else { this.movementConfirmationLineEvents.clear(); }
        }
        
        public void addMovementConfirmationLineEvent(MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved e)
        {
            throwOnInconsistentEventIds(e);
            this.movementConfirmationLineEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved e : this.getMovementConfirmationLineEvents()) {
                getMovementConfirmationLineStateEventDao().save(e);
            }
        }
    }
    public static class SimpleMovementConfirmationStateCreated extends AbstractMovementConfirmationStateCreated
    {
        public SimpleMovementConfirmationStateCreated() {
        }

        public SimpleMovementConfirmationStateCreated(MovementConfirmationStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementConfirmationStateMergePatched extends AbstractMovementConfirmationStateMergePatched
    {
        public SimpleMovementConfirmationStateMergePatched() {
        }

        public SimpleMovementConfirmationStateMergePatched(MovementConfirmationStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleMovementConfirmationStateDeleted extends AbstractMovementConfirmationStateDeleted
    {
        public SimpleMovementConfirmationStateDeleted() {
        }

        public SimpleMovementConfirmationStateDeleted(MovementConfirmationStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

