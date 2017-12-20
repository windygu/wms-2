package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movement.MovementStateEvent.*;

public abstract class AbstractMovementState implements MovementState, Saveable
{

    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
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

    private String documentStatusId;

    public String getDocumentStatusId()
    {
        return this.documentStatusId;
    }

    public void setDocumentStatusId(String documentStatusId)
    {
        this.documentStatusId = documentStatusId;
    }

    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private MovementLineStates movementLines;

    public MovementLineStates getMovementLines()
    {
        return this.movementLines;
    }

    public void setMovementLines(MovementLineStates movementLines)
    {
        this.movementLines = movementLines;
    }

    private MovementConfirmationLineStates movementConfirmationLines;

    public MovementConfirmationLineStates getMovementConfirmationLines()
    {
        return this.movementConfirmationLines;
    }

    public void setMovementConfirmationLines(MovementConfirmationLineStates movementConfirmationLines)
    {
        this.movementConfirmationLines = movementConfirmationLines;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractMovementState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setDocumentNumber(((MovementStateEvent) events.get(0)).getStateEventId().getDocumentNumber());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractMovementState() {
        this(false);
    }

    public AbstractMovementState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        movementLines = new SimpleMovementLineStates(this);
        movementConfirmationLines = new SimpleMovementConfirmationLineStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementStateCreated) {
            when((MovementStateCreated) e);
        } else if (e instanceof MovementStateMergePatched) {
            when((MovementStateMergePatched) e);
        } else if (e instanceof MovementStateDeleted) {
            when((MovementStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setDocumentTypeId(e.getDocumentTypeId());
        this.setDocumentStatusId(e.getDocumentStatusId());
        this.setMovementTypeId(e.getMovementTypeId());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (MovementLineStateEvent.MovementLineStateCreated innerEvent : e.getMovementLineEvents()) {
            MovementLineState innerState = this.getMovementLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
        }
        for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated innerEvent : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineState innerState = this.getMovementConfirmationLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
        }
    }

    public void when(MovementStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getDocumentTypeId() == null)
        {
            if (e.getIsPropertyDocumentTypeIdRemoved() != null && e.getIsPropertyDocumentTypeIdRemoved())
            {
                this.setDocumentTypeId(null);
            }
        }
        else
        {
            this.setDocumentTypeId(e.getDocumentTypeId());
        }
        if (e.getDocumentStatusId() == null)
        {
            if (e.getIsPropertyDocumentStatusIdRemoved() != null && e.getIsPropertyDocumentStatusIdRemoved())
            {
                this.setDocumentStatusId(null);
            }
        }
        else
        {
            this.setDocumentStatusId(e.getDocumentStatusId());
        }
        if (e.getMovementTypeId() == null)
        {
            if (e.getIsPropertyMovementTypeIdRemoved() != null && e.getIsPropertyMovementTypeIdRemoved())
            {
                this.setMovementTypeId(null);
            }
        }
        else
        {
            this.setMovementTypeId(e.getMovementTypeId());
        }
        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (MovementLineStateEvent innerEvent : e.getMovementLineEvents()) {
            MovementLineState innerState = this.getMovementLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof MovementLineStateEvent.MovementLineStateRemoved)
            {
                //MovementLineStateEvent.MovementLineStateRemoved removed = (MovementLineStateEvent.MovementLineStateRemoved)innerEvent;
                this.getMovementLines().remove(innerState);
            }
        }
        for (MovementConfirmationLineStateEvent innerEvent : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineState innerState = this.getMovementConfirmationLines().get(innerEvent.getStateEventId().getLineNumber());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved)
            {
                //MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved removed = (MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved)innerEvent;
                this.getMovementConfirmationLines().remove(innerState);
            }
        }
    }

    public void when(MovementStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (MovementLineState innerState : this.getMovementLines())
        {
            this.getMovementLines().remove(innerState);
        
            MovementLineStateEvent.MovementLineStateRemoved innerE = e.newMovementLineStateRemoved(innerState.getLineNumber());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addMovementLineEvent(innerE);
        }
        for (MovementConfirmationLineState innerState : this.getMovementConfirmationLines())
        {
            this.getMovementConfirmationLines().remove(innerState);
        
            MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved innerE = e.newMovementConfirmationLineStateRemoved(innerState.getLineNumber());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addMovementConfirmationLineEvent(innerE);
        }
    }

    public void save()
    {
        movementLines.save();

        movementConfirmationLines.save();

    }

    protected void throwOnWrongEvent(MovementStateEvent stateEvent)
    {
        String stateEntityId = this.getDocumentNumber(); // Aggregate Id
        String eventEntityId = stateEvent.getStateEventId().getDocumentNumber(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementState extends AbstractMovementState
    {

        public SimpleMovementState() {
        }

        public SimpleMovementState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleMovementLineStates extends AbstractMovementLineStates
    {
        public SimpleMovementLineStates(AbstractMovementState outerState)
        {
            super(outerState);
        }
    }

    static class SimpleMovementConfirmationLineStates extends AbstractMovementConfirmationLineStates
    {
        public SimpleMovementConfirmationLineStates(AbstractMovementState outerState)
        {
            super(outerState);
        }
    }


}

