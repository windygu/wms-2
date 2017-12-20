package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movementlinemvo.MovementLineMvoStateEvent.*;

public abstract class AbstractMovementLineMvoState implements MovementLineMvoState
{

    private MovementLineId movementLineId;

    public MovementLineId getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId)
    {
        this.movementLineId = movementLineId;
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

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
    }

    private String attributeSetInstanceIdFrom;

    public String getAttributeSetInstanceIdFrom()
    {
        return this.attributeSetInstanceIdFrom;
    }

    public void setAttributeSetInstanceIdFrom(String attributeSetInstanceIdFrom)
    {
        this.attributeSetInstanceIdFrom = attributeSetInstanceIdFrom;
    }

    private String attributeSetInstanceIdTo;

    public String getAttributeSetInstanceIdTo()
    {
        return this.attributeSetInstanceIdTo;
    }

    public void setAttributeSetInstanceIdTo(String attributeSetInstanceIdTo)
    {
        this.attributeSetInstanceIdTo = attributeSetInstanceIdTo;
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

    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    public AbstractMovementLineMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setMovementLineId(((MovementLineMvoStateEvent) events.get(0)).getStateEventId().getMovementLineId());
            for (Event e : events) {
                mutate(e);
                this.setMovementVersion(this.getMovementVersion() + 1);
            }
        }
    }


    public AbstractMovementLineMvoState() {
        this(false);
    }

    public AbstractMovementLineMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementLineMvoStateCreated) {
            when((MovementLineMvoStateCreated) e);
        } else if (e instanceof MovementLineMvoStateMergePatched) {
            when((MovementLineMvoStateMergePatched) e);
        } else if (e instanceof MovementLineMvoStateDeleted) {
            when((MovementLineMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementLineMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setMovementQuantity(e.getMovementQuantity());
        this.setProductId(e.getProductId());
        this.setLocatorIdFrom(e.getLocatorIdFrom());
        this.setLocatorIdTo(e.getLocatorIdTo());
        this.setAttributeSetInstanceIdFrom(e.getAttributeSetInstanceIdFrom());
        this.setAttributeSetInstanceIdTo(e.getAttributeSetInstanceIdTo());
        this.setProcessed(e.getProcessed());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        this.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
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

    public void when(MovementLineMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getMovementQuantity() == null)
        {
            if (e.getIsPropertyMovementQuantityRemoved() != null && e.getIsPropertyMovementQuantityRemoved())
            {
                this.setMovementQuantity(null);
            }
        }
        else
        {
            this.setMovementQuantity(e.getMovementQuantity());
        }
        if (e.getProductId() == null)
        {
            if (e.getIsPropertyProductIdRemoved() != null && e.getIsPropertyProductIdRemoved())
            {
                this.setProductId(null);
            }
        }
        else
        {
            this.setProductId(e.getProductId());
        }
        if (e.getLocatorIdFrom() == null)
        {
            if (e.getIsPropertyLocatorIdFromRemoved() != null && e.getIsPropertyLocatorIdFromRemoved())
            {
                this.setLocatorIdFrom(null);
            }
        }
        else
        {
            this.setLocatorIdFrom(e.getLocatorIdFrom());
        }
        if (e.getLocatorIdTo() == null)
        {
            if (e.getIsPropertyLocatorIdToRemoved() != null && e.getIsPropertyLocatorIdToRemoved())
            {
                this.setLocatorIdTo(null);
            }
        }
        else
        {
            this.setLocatorIdTo(e.getLocatorIdTo());
        }
        if (e.getAttributeSetInstanceIdFrom() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdFromRemoved() != null && e.getIsPropertyAttributeSetInstanceIdFromRemoved())
            {
                this.setAttributeSetInstanceIdFrom(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceIdFrom(e.getAttributeSetInstanceIdFrom());
        }
        if (e.getAttributeSetInstanceIdTo() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdToRemoved() != null && e.getIsPropertyAttributeSetInstanceIdToRemoved())
            {
                this.setAttributeSetInstanceIdTo(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceIdTo(e.getAttributeSetInstanceIdTo());
        }
        if (e.getProcessed() == null)
        {
            if (e.getIsPropertyProcessedRemoved() != null && e.getIsPropertyProcessedRemoved())
            {
                this.setProcessed(null);
            }
        }
        else
        {
            this.setProcessed(e.getProcessed());
        }
        if (e.getReversalLineNumber() == null)
        {
            if (e.getIsPropertyReversalLineNumberRemoved() != null && e.getIsPropertyReversalLineNumberRemoved())
            {
                this.setReversalLineNumber(null);
            }
        }
        else
        {
            this.setReversalLineNumber(e.getReversalLineNumber());
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

    public void when(MovementLineMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(MovementLineMvoStateEvent stateEvent)
    {
        MovementLineId stateEntityId = this.getMovementLineId(); // Aggregate Id
        MovementLineId eventEntityId = stateEvent.getStateEventId().getMovementLineId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getMovementVersion();
        Long eventVersion = stateEvent.getStateEventId().getMovementVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getMovementVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(MovementLineMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleMovementLineMvoState extends AbstractMovementLineMvoState
    {

        public SimpleMovementLineMvoState() {
        }

        public SimpleMovementLineMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleMovementLineMvoState(List<Event> events) {
            super(events);
        }

    }


}

