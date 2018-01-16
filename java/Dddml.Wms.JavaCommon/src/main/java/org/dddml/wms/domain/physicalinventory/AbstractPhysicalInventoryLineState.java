package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineStateEvent.*;

public abstract class AbstractPhysicalInventoryLineState implements PhysicalInventoryLineState
{

    private PhysicalInventoryLineId physicalInventoryLineId = new PhysicalInventoryLineId();

    public PhysicalInventoryLineId getPhysicalInventoryLineId() {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId) {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

    public String getPhysicalInventoryDocumentNumber() {
        return this.getPhysicalInventoryLineId().getPhysicalInventoryDocumentNumber();
    }
        
    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber) {
        this.getPhysicalInventoryLineId().setPhysicalInventoryDocumentNumber(physicalInventoryDocumentNumber);
    }

    public String getLineNumber() {
        return this.getPhysicalInventoryLineId().getLineNumber();
    }
        
    public void setLineNumber(String lineNumber) {
        this.getPhysicalInventoryLineId().setLineNumber(lineNumber);
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

    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity()
    {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity)
    {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity()
    {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity)
    {
        this.countedQuantity = countedQuantity;
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

    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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


    public AbstractPhysicalInventoryLineState() {
        this(false);
    }

    public AbstractPhysicalInventoryLineState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PhysicalInventoryLineStateCreated) {
            when((PhysicalInventoryLineStateCreated) e);
        } else if (e instanceof PhysicalInventoryLineStateMergePatched) {
            when((PhysicalInventoryLineStateMergePatched) e);
        } else if (e instanceof PhysicalInventoryLineStateRemoved) {
            when((PhysicalInventoryLineStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PhysicalInventoryLineStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setLocatorId(e.getLocatorId());
        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setBookQuantity(e.getBookQuantity());
        this.setCountedQuantity(e.getCountedQuantity());
        this.setProcessed(e.getProcessed());
        this.setReversalLineNumber(e.getReversalLineNumber());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PhysicalInventoryLineStateMergePatched e)
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
        if (e.getBookQuantity() == null)
        {
            if (e.getIsPropertyBookQuantityRemoved() != null && e.getIsPropertyBookQuantityRemoved())
            {
                this.setBookQuantity(null);
            }
        }
        else
        {
            this.setBookQuantity(e.getBookQuantity());
        }
        if (e.getCountedQuantity() == null)
        {
            if (e.getIsPropertyCountedQuantityRemoved() != null && e.getIsPropertyCountedQuantityRemoved())
            {
                this.setCountedQuantity(null);
            }
        }
        else
        {
            this.setCountedQuantity(e.getCountedQuantity());
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

    }

    public void when(PhysicalInventoryLineStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PhysicalInventoryLineStateEvent stateEvent)
    {
        String stateEntityIdPhysicalInventoryDocumentNumber = this.getPhysicalInventoryLineId().getPhysicalInventoryDocumentNumber();
        String eventEntityIdPhysicalInventoryDocumentNumber = stateEvent.getStateEventId().getPhysicalInventoryDocumentNumber();
        if (!stateEntityIdPhysicalInventoryDocumentNumber.equals(eventEntityIdPhysicalInventoryDocumentNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id PhysicalInventoryDocumentNumber %1$s in state but entity id PhysicalInventoryDocumentNumber %2$s in event", stateEntityIdPhysicalInventoryDocumentNumber, eventEntityIdPhysicalInventoryDocumentNumber);
        }

        String stateEntityIdLineNumber = this.getPhysicalInventoryLineId().getLineNumber();
        String eventEntityIdLineNumber = stateEvent.getStateEventId().getLineNumber();
        if (!stateEntityIdLineNumber.equals(eventEntityIdLineNumber))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id LineNumber %1$s in state but entity id LineNumber %2$s in event", stateEntityIdLineNumber, eventEntityIdLineNumber);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? PhysicalInventoryLineState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(PhysicalInventoryLineState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePhysicalInventoryLineState extends AbstractPhysicalInventoryLineState
    {

        public SimplePhysicalInventoryLineState() {
        }

        public SimplePhysicalInventoryLineState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

