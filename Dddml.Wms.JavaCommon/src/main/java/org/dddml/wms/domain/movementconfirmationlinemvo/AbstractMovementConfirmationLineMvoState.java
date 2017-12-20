package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementconfirmationlinemvo.MovementConfirmationLineMvoStateEvent.*;

public abstract class AbstractMovementConfirmationLineMvoState implements MovementConfirmationLineMvoState
{

    private MovementConfirmationLineId movementConfirmationLineId;

    public MovementConfirmationLineId getMovementConfirmationLineId()
    {
        return this.movementConfirmationLineId;
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
    }

    private BigDecimal targetQuantity;

    public BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
    }

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    private BigDecimal differenceQuantity;

    public BigDecimal getDifferenceQuantity()
    {
        return this.differenceQuantity;
    }

    public void setDifferenceQuantity(BigDecimal differenceQuantity)
    {
        this.differenceQuantity = differenceQuantity;
    }

    private BigDecimal scrappedQuantity;

    public BigDecimal getScrappedQuantity()
    {
        return this.scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity)
    {
        this.scrappedQuantity = scrappedQuantity;
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

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private String movementMovementTypeId;

    public String getMovementMovementTypeId()
    {
        return this.movementMovementTypeId;
    }

    public void setMovementMovementTypeId(String movementMovementTypeId)
    {
        this.movementMovementTypeId = movementMovementTypeId;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getMovementVersion() == null;
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

    public AbstractMovementConfirmationLineMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setMovementConfirmationLineId(((MovementConfirmationLineMvoStateEvent) events.get(0)).getStateEventId().getMovementConfirmationLineId());
            for (Event e : events) {
                mutate(e);
                this.setMovementVersion(this.getMovementVersion() + 1);
            }
        }
    }


    public AbstractMovementConfirmationLineMvoState() {
        this(false);
    }

    public AbstractMovementConfirmationLineMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementConfirmationLineMvoStateCreated) {
            when((MovementConfirmationLineMvoStateCreated) e);
        } else if (e instanceof MovementConfirmationLineMvoStateMergePatched) {
            when((MovementConfirmationLineMvoStateMergePatched) e);
        } else if (e instanceof MovementConfirmationLineMvoStateDeleted) {
            when((MovementConfirmationLineMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementConfirmationLineMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setTargetQuantity(e.getTargetQuantity());
        this.setConfirmedQuantity(e.getConfirmedQuantity());
        this.setDifferenceQuantity(e.getDifferenceQuantity());
        this.setScrappedQuantity(e.getScrappedQuantity());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        this.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        this.setMovementMovementTypeId(e.getMovementMovementTypeId());
        this.setMovementDescription(e.getMovementDescription());
        this.setMovementCreatedBy(e.getMovementCreatedBy());
        this.setMovementCreatedAt(e.getMovementCreatedAt());
        this.setMovementUpdatedBy(e.getMovementUpdatedBy());
        this.setMovementUpdatedAt(e.getMovementUpdatedAt());
        this.setMovementActive(e.getMovementActive());
        this.setMovementDeleted(e.getMovementDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(MovementConfirmationLineMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getTargetQuantity() == null)
        {
            if (e.getIsPropertyTargetQuantityRemoved() != null && e.getIsPropertyTargetQuantityRemoved())
            {
                this.setTargetQuantity(null);
            }
        }
        else
        {
            this.setTargetQuantity(e.getTargetQuantity());
        }
        if (e.getConfirmedQuantity() == null)
        {
            if (e.getIsPropertyConfirmedQuantityRemoved() != null && e.getIsPropertyConfirmedQuantityRemoved())
            {
                this.setConfirmedQuantity(null);
            }
        }
        else
        {
            this.setConfirmedQuantity(e.getConfirmedQuantity());
        }
        if (e.getDifferenceQuantity() == null)
        {
            if (e.getIsPropertyDifferenceQuantityRemoved() != null && e.getIsPropertyDifferenceQuantityRemoved())
            {
                this.setDifferenceQuantity(null);
            }
        }
        else
        {
            this.setDifferenceQuantity(e.getDifferenceQuantity());
        }
        if (e.getScrappedQuantity() == null)
        {
            if (e.getIsPropertyScrappedQuantityRemoved() != null && e.getIsPropertyScrappedQuantityRemoved())
            {
                this.setScrappedQuantity(null);
            }
        }
        else
        {
            this.setScrappedQuantity(e.getScrappedQuantity());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
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
        if (e.getMovementDocumentTypeId() == null)
        {
            if (e.getIsPropertyMovementDocumentTypeIdRemoved() != null && e.getIsPropertyMovementDocumentTypeIdRemoved())
            {
                this.setMovementDocumentTypeId(null);
            }
        }
        else
        {
            this.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        }
        if (e.getMovementDocumentStatusId() == null)
        {
            if (e.getIsPropertyMovementDocumentStatusIdRemoved() != null && e.getIsPropertyMovementDocumentStatusIdRemoved())
            {
                this.setMovementDocumentStatusId(null);
            }
        }
        else
        {
            this.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        }
        if (e.getMovementMovementTypeId() == null)
        {
            if (e.getIsPropertyMovementMovementTypeIdRemoved() != null && e.getIsPropertyMovementMovementTypeIdRemoved())
            {
                this.setMovementMovementTypeId(null);
            }
        }
        else
        {
            this.setMovementMovementTypeId(e.getMovementMovementTypeId());
        }
        if (e.getMovementDescription() == null)
        {
            if (e.getIsPropertyMovementDescriptionRemoved() != null && e.getIsPropertyMovementDescriptionRemoved())
            {
                this.setMovementDescription(null);
            }
        }
        else
        {
            this.setMovementDescription(e.getMovementDescription());
        }
        if (e.getMovementCreatedBy() == null)
        {
            if (e.getIsPropertyMovementCreatedByRemoved() != null && e.getIsPropertyMovementCreatedByRemoved())
            {
                this.setMovementCreatedBy(null);
            }
        }
        else
        {
            this.setMovementCreatedBy(e.getMovementCreatedBy());
        }
        if (e.getMovementCreatedAt() == null)
        {
            if (e.getIsPropertyMovementCreatedAtRemoved() != null && e.getIsPropertyMovementCreatedAtRemoved())
            {
                this.setMovementCreatedAt(null);
            }
        }
        else
        {
            this.setMovementCreatedAt(e.getMovementCreatedAt());
        }
        if (e.getMovementUpdatedBy() == null)
        {
            if (e.getIsPropertyMovementUpdatedByRemoved() != null && e.getIsPropertyMovementUpdatedByRemoved())
            {
                this.setMovementUpdatedBy(null);
            }
        }
        else
        {
            this.setMovementUpdatedBy(e.getMovementUpdatedBy());
        }
        if (e.getMovementUpdatedAt() == null)
        {
            if (e.getIsPropertyMovementUpdatedAtRemoved() != null && e.getIsPropertyMovementUpdatedAtRemoved())
            {
                this.setMovementUpdatedAt(null);
            }
        }
        else
        {
            this.setMovementUpdatedAt(e.getMovementUpdatedAt());
        }
        if (e.getMovementActive() == null)
        {
            if (e.getIsPropertyMovementActiveRemoved() != null && e.getIsPropertyMovementActiveRemoved())
            {
                this.setMovementActive(null);
            }
        }
        else
        {
            this.setMovementActive(e.getMovementActive());
        }
        if (e.getMovementDeleted() == null)
        {
            if (e.getIsPropertyMovementDeletedRemoved() != null && e.getIsPropertyMovementDeletedRemoved())
            {
                this.setMovementDeleted(null);
            }
        }
        else
        {
            this.setMovementDeleted(e.getMovementDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(MovementConfirmationLineMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(MovementConfirmationLineMvoStateEvent stateEvent)
    {
        MovementConfirmationLineId stateEntityId = this.getMovementConfirmationLineId(); // Aggregate Id
        MovementConfirmationLineId eventEntityId = stateEvent.getStateEventId().getMovementConfirmationLineId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getMovementVersion();
        Long eventVersion = stateEvent.getStateEventId().getMovementVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getMovementVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementConfirmationLineMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementConfirmationLineMvoState extends AbstractMovementConfirmationLineMvoState
    {

        public SimpleMovementConfirmationLineMvoState() {
        }

        public SimpleMovementConfirmationLineMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementConfirmationLineMvoState(List<Event> events) {
            super(events);
        }

    }


}

