package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inout.InOutLineEvent.*;

public abstract class AbstractInOutLineState implements InOutLineState, Saveable
{

    private InOutLineId inOutLineId = new InOutLineId();

    public InOutLineId getInOutLineId() {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineId inOutLineId) {
        this.inOutLineId = inOutLineId;
    }

    public String getInOutDocumentNumber() {
        return this.getInOutLineId().getInOutDocumentNumber();
    }
        
    public void setInOutDocumentNumber(String inOutDocumentNumber) {
        this.getInOutLineId().setInOutDocumentNumber(inOutDocumentNumber);
    }

    public String getLineNumber() {
        return this.getInOutLineId().getLineNumber();
    }
        
    public void setLineNumber(String lineNumber) {
        this.getInOutLineId().setLineNumber(lineNumber);
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

    private String damageStatusId;

    public String getDamageStatusId()
    {
        return this.damageStatusId;
    }

    public void setDamageStatusId(String damageStatusId)
    {
        this.damageStatusId = damageStatusId;
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

    private InOutLineImageStates inOutLineImages;

    public InOutLineImageStates getInOutLineImages()
    {
        return this.inOutLineImages;
    }

    public void setInOutLineImages(InOutLineImageStates inOutLineImages)
    {
        this.inOutLineImages = inOutLineImages;
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


    public AbstractInOutLineState() {
        this(false);
    }

    public AbstractInOutLineState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        inOutLineImages = new SimpleInOutLineImageStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InOutLineStateCreated) {
            when((InOutLineStateCreated) e);
        } else if (e instanceof InOutLineStateMergePatched) {
            when((InOutLineStateMergePatched) e);
        } else if (e instanceof InOutLineStateRemoved) {
            when((InOutLineStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InOutLineStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setLocatorId(e.getLocatorId());
        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setDamageStatusId(e.getDamageStatusId());
        this.setDescription(e.getDescription());
        this.setQuantityUomId(e.getQuantityUomId());
        this.setMovementQuantity(e.getMovementQuantity());
        this.setPickedQuantity(e.getPickedQuantity());
        this.setIsInvoiced(e.getIsInvoiced());
        this.setProcessed(e.getProcessed());
        this.setRmaLineNumber(e.getRmaLineNumber());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (InOutLineImageEvent.InOutLineImageStateCreated innerEvent : e.getInOutLineImageEvents()) {
            InOutLineImageState innerState = this.getInOutLineImages().get(innerEvent.getInOutLineImageEventId().getSequenceId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(InOutLineStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getLocatorId() == null)
        {
            if (e.getIsPropertyLocatorIdRemoved() != null && e.getIsPropertyLocatorIdRemoved())
            {
                this.setLocatorId(null);
            }
        }
        else
        {
            this.setLocatorId(e.getLocatorId());
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
        if (e.getDamageStatusId() == null)
        {
            if (e.getIsPropertyDamageStatusIdRemoved() != null && e.getIsPropertyDamageStatusIdRemoved())
            {
                this.setDamageStatusId(null);
            }
        }
        else
        {
            this.setDamageStatusId(e.getDamageStatusId());
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
        if (e.getQuantityUomId() == null)
        {
            if (e.getIsPropertyQuantityUomIdRemoved() != null && e.getIsPropertyQuantityUomIdRemoved())
            {
                this.setQuantityUomId(null);
            }
        }
        else
        {
            this.setQuantityUomId(e.getQuantityUomId());
        }
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
        if (e.getPickedQuantity() == null)
        {
            if (e.getIsPropertyPickedQuantityRemoved() != null && e.getIsPropertyPickedQuantityRemoved())
            {
                this.setPickedQuantity(null);
            }
        }
        else
        {
            this.setPickedQuantity(e.getPickedQuantity());
        }
        if (e.getIsInvoiced() == null)
        {
            if (e.getIsPropertyIsInvoicedRemoved() != null && e.getIsPropertyIsInvoicedRemoved())
            {
                this.setIsInvoiced(null);
            }
        }
        else
        {
            this.setIsInvoiced(e.getIsInvoiced());
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
        if (e.getRmaLineNumber() == null)
        {
            if (e.getIsPropertyRmaLineNumberRemoved() != null && e.getIsPropertyRmaLineNumberRemoved())
            {
                this.setRmaLineNumber(null);
            }
        }
        else
        {
            this.setRmaLineNumber(e.getRmaLineNumber());
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

        for (InOutLineImageEvent innerEvent : e.getInOutLineImageEvents()) {
            InOutLineImageState innerState = this.getInOutLineImages().get(innerEvent.getInOutLineImageEventId().getSequenceId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof InOutLineImageEvent.InOutLineImageStateRemoved)
            {
                //InOutLineImageEvent.InOutLineImageStateRemoved removed = (InOutLineImageEvent.InOutLineImageStateRemoved)innerEvent;
                this.getInOutLineImages().remove(innerState);
            }
        }
    }

    public void when(InOutLineStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (InOutLineImageState innerState : this.getInOutLineImages())
        {
            this.getInOutLineImages().remove(innerState);
        
            InOutLineImageEvent.InOutLineImageStateRemoved innerE = e.newInOutLineImageStateRemoved(innerState.getSequenceId());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addInOutLineImageEvent(innerE);
        }
    }

    public void save()
    {
        inOutLineImages.save();

    }

    protected void throwOnWrongEvent(InOutLineEvent event)
    {
        String stateEntityIdInOutDocumentNumber = this.getInOutLineId().getInOutDocumentNumber();
        String eventEntityIdInOutDocumentNumber = event.getInOutLineEventId().getInOutDocumentNumber();
        if (!stateEntityIdInOutDocumentNumber.equals(eventEntityIdInOutDocumentNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id InOutDocumentNumber %1$s in state but entity id InOutDocumentNumber %2$s in event", stateEntityIdInOutDocumentNumber, eventEntityIdInOutDocumentNumber);
        }

        String stateEntityIdLineNumber = this.getInOutLineId().getLineNumber();
        String eventEntityIdLineNumber = event.getInOutLineEventId().getLineNumber();
        if (!stateEntityIdLineNumber.equals(eventEntityIdLineNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id LineNumber %1$s in state but entity id LineNumber %2$s in event", stateEntityIdLineNumber, eventEntityIdLineNumber);
        }

        if (getForReapplying()) { return; }

        InOutLineStateEvent stateEvent = event instanceof InOutLineStateEvent ? (InOutLineStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? InOutLineState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(InOutLineState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleInOutLineState extends AbstractInOutLineState
    {

        public SimpleInOutLineState() {
        }

        public SimpleInOutLineState(boolean forReapplying) {
            super(forReapplying);
        }

    }

    static class SimpleInOutLineImageStates extends AbstractInOutLineImageStates
    {
        public SimpleInOutLineImageStates(AbstractInOutLineState outerState)
        {
            super(outerState);
        }
    }


}

