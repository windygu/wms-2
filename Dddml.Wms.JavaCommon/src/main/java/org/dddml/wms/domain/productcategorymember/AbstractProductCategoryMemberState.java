package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.productcategorymember.ProductCategoryMemberStateEvent.*;

public abstract class AbstractProductCategoryMemberState implements ProductCategoryMemberState
{

    private ProductCategoryMemberId productCategoryMemberId;

    public ProductCategoryMemberId getProductCategoryMemberId()
    {
        return this.productCategoryMemberId;
    }

    public void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId)
    {
        this.productCategoryMemberId = productCategoryMemberId;
    }

    private java.sql.Timestamp thruDate;

    public java.sql.Timestamp getThruDate()
    {
        return this.thruDate;
    }

    public void setThruDate(java.sql.Timestamp thruDate)
    {
        this.thruDate = thruDate;
    }

    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    private Long sequenceNum;

    public Long getSequenceNum()
    {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
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

    public AbstractProductCategoryMemberState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setProductCategoryMemberId(((ProductCategoryMemberStateEvent) events.get(0)).getStateEventId().getProductCategoryMemberId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractProductCategoryMemberState() {
        this(false);
    }

    public AbstractProductCategoryMemberState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ProductCategoryMemberStateCreated) {
            when((ProductCategoryMemberStateCreated) e);
        } else if (e instanceof ProductCategoryMemberStateMergePatched) {
            when((ProductCategoryMemberStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ProductCategoryMemberStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setThruDate(e.getThruDate());
        this.setComments(e.getComments());
        this.setSequenceNum(e.getSequenceNum());
        this.setQuantity(e.getQuantity());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ProductCategoryMemberStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getThruDate() == null)
        {
            if (e.getIsPropertyThruDateRemoved() != null && e.getIsPropertyThruDateRemoved())
            {
                this.setThruDate(null);
            }
        }
        else
        {
            this.setThruDate(e.getThruDate());
        }
        if (e.getComments() == null)
        {
            if (e.getIsPropertyCommentsRemoved() != null && e.getIsPropertyCommentsRemoved())
            {
                this.setComments(null);
            }
        }
        else
        {
            this.setComments(e.getComments());
        }
        if (e.getSequenceNum() == null)
        {
            if (e.getIsPropertySequenceNumRemoved() != null && e.getIsPropertySequenceNumRemoved())
            {
                this.setSequenceNum(null);
            }
        }
        else
        {
            this.setSequenceNum(e.getSequenceNum());
        }
        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
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

    public void save()
    {
    }

    protected void throwOnWrongEvent(ProductCategoryMemberStateEvent stateEvent)
    {
        ProductCategoryMemberId stateEntityId = this.getProductCategoryMemberId(); // Aggregate Id
        ProductCategoryMemberId eventEntityId = stateEvent.getStateEventId().getProductCategoryMemberId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ProductCategoryMemberState.VERSION_NULL)) && !(eventVersion.compareTo(stateVersion) >= 0))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleProductCategoryMemberState extends AbstractProductCategoryMemberState
    {

        public SimpleProductCategoryMemberState() {
        }

        public SimpleProductCategoryMemberState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleProductCategoryMemberState(List<Event> events) {
            super(events);
        }

    }


}

