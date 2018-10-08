package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.movement.MovementLineEvent.*;

public abstract class AbstractMovementLineState implements MovementLineState
{

    private MovementLineId movementLineId = new MovementLineId();

    public MovementLineId getMovementLineId() {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId) {
        this.movementLineId = movementLineId;
    }

    public String getMovementDocumentNumber() {
        return this.getMovementLineId().getMovementDocumentNumber();
    }
        
    public void setMovementDocumentNumber(String movementDocumentNumber) {
        this.getMovementLineId().setMovementDocumentNumber(movementDocumentNumber);
    }

    public String getLineNumber() {
        return this.getMovementLineId().getLineNumber();
    }
        
    public void setLineNumber(String lineNumber) {
        this.getMovementLineId().setLineNumber(lineNumber);
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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
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


    public AbstractMovementLineState() {
        this(false);
    }

    public AbstractMovementLineState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof MovementLineStateCreated) {
            when((MovementLineStateCreated) e);
        } else if (e instanceof MovementLineStateMergePatched) {
            when((MovementLineStateMergePatched) e);
        } else if (e instanceof MovementLineStateRemoved) {
            when((MovementLineStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(MovementLineStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setMovementQuantity(e.getMovementQuantity());
        this.setProductId(e.getProductId());
        this.setLocatorIdFrom(e.getLocatorIdFrom());
        this.setLocatorIdTo(e.getLocatorIdTo());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setProcessed(e.getProcessed());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(MovementLineStateMergePatched e)
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
        if (e.getAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdRemoved() != null && e.getIsPropertyAttributeSetInstanceIdRemoved())
            {
                this.setAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
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

    }

    public void when(MovementLineStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(MovementLineEvent event)
    {
        String stateEntityIdMovementDocumentNumber = this.getMovementLineId().getMovementDocumentNumber();
        String eventEntityIdMovementDocumentNumber = ((MovementLineEvent.SqlMovementLineEvent)event).getMovementLineEventId().getMovementDocumentNumber();
        if (!stateEntityIdMovementDocumentNumber.equals(eventEntityIdMovementDocumentNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id MovementDocumentNumber %1$s in state but entity id MovementDocumentNumber %2$s in event", stateEntityIdMovementDocumentNumber, eventEntityIdMovementDocumentNumber);
        }

        String stateEntityIdLineNumber = this.getMovementLineId().getLineNumber();
        String eventEntityIdLineNumber = ((MovementLineEvent.SqlMovementLineEvent)event).getMovementLineEventId().getLineNumber();
        if (!stateEntityIdLineNumber.equals(eventEntityIdLineNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id LineNumber %1$s in state but entity id LineNumber %2$s in event", stateEntityIdLineNumber, eventEntityIdLineNumber);
        }

        if (getForReapplying()) { return; }

        MovementLineStateEvent stateEvent = event instanceof MovementLineStateEvent ? (MovementLineStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? MovementLineState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(MovementLineState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleMovementLineState extends AbstractMovementLineState
    {

        public SimpleMovementLineState() {
        }

        public SimpleMovementLineState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

