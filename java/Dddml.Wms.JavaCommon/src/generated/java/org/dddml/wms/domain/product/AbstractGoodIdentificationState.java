package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.product.GoodIdentificationEvent.*;

public abstract class AbstractGoodIdentificationState implements GoodIdentificationState.SqlGoodIdentificationState
{

    private ProductGoodIdentificationId productGoodIdentificationId = new ProductGoodIdentificationId();

    public ProductGoodIdentificationId getProductGoodIdentificationId() {
        return this.productGoodIdentificationId;
    }

    public void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId) {
        this.productGoodIdentificationId = productGoodIdentificationId;
    }

    public String getProductId() {
        return this.getProductGoodIdentificationId().getProductId();
    }
        
    public void setProductId(String productId) {
        this.getProductGoodIdentificationId().setProductId(productId);
    }

    public String getGoodIdentificationTypeId() {
        return this.getProductGoodIdentificationId().getGoodIdentificationTypeId();
    }
        
    public void setGoodIdentificationTypeId(String goodIdentificationTypeId) {
        this.getProductGoodIdentificationId().setGoodIdentificationTypeId(goodIdentificationTypeId);
    }

    private String idValue;

    public String getIdValue()
    {
        return this.idValue;
    }

    public void setIdValue(String idValue)
    {
        this.idValue = idValue;
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


    public AbstractGoodIdentificationState() {
        this(false);
    }

    public AbstractGoodIdentificationState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof GoodIdentificationStateCreated) {
            when((GoodIdentificationStateCreated) e);
        } else if (e instanceof GoodIdentificationStateMergePatched) {
            when((GoodIdentificationStateMergePatched) e);
        } else if (e instanceof GoodIdentificationStateRemoved) {
            when((GoodIdentificationStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(GoodIdentificationStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setIdValue(e.getIdValue());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(GoodIdentificationStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getIdValue() == null)
        {
            if (e.getIsPropertyIdValueRemoved() != null && e.getIsPropertyIdValueRemoved())
            {
                this.setIdValue(null);
            }
        }
        else
        {
            this.setIdValue(e.getIdValue());
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

    public void when(GoodIdentificationStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(GoodIdentificationEvent event)
    {
        String stateEntityIdProductId = this.getProductGoodIdentificationId().getProductId();
        String eventEntityIdProductId = ((GoodIdentificationEvent.SqlGoodIdentificationEvent)event).getGoodIdentificationEventId().getProductId();
        if (!stateEntityIdProductId.equals(eventEntityIdProductId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ProductId %1$s in state but entity id ProductId %2$s in event", stateEntityIdProductId, eventEntityIdProductId);
        }

        String stateEntityIdGoodIdentificationTypeId = this.getProductGoodIdentificationId().getGoodIdentificationTypeId();
        String eventEntityIdGoodIdentificationTypeId = ((GoodIdentificationEvent.SqlGoodIdentificationEvent)event).getGoodIdentificationEventId().getGoodIdentificationTypeId();
        if (!stateEntityIdGoodIdentificationTypeId.equals(eventEntityIdGoodIdentificationTypeId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id GoodIdentificationTypeId %1$s in state but entity id GoodIdentificationTypeId %2$s in event", stateEntityIdGoodIdentificationTypeId, eventEntityIdGoodIdentificationTypeId);
        }

        if (getForReapplying()) { return; }

        GoodIdentificationStateEvent stateEvent = event instanceof GoodIdentificationStateEvent ? (GoodIdentificationStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? GoodIdentificationState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(GoodIdentificationState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleGoodIdentificationState extends AbstractGoodIdentificationState
    {

        public SimpleGoodIdentificationState() {
        }

        public SimpleGoodIdentificationState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

