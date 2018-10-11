package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.productcategory.ProductCategoryEvent.*;

public abstract class AbstractProductCategoryState implements ProductCategoryState.SqlProductCategoryState
{

    private String productCategoryId;

    public String getProductCategoryId()
    {
        return this.productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId)
    {
        this.productCategoryId = productCategoryId;
    }

    private String productCategoryTypeId;

    public String getProductCategoryTypeId()
    {
        return this.productCategoryTypeId;
    }

    public void setProductCategoryTypeId(String productCategoryTypeId)
    {
        this.productCategoryTypeId = productCategoryTypeId;
    }

    private String primaryParentCategoryId;

    public String getPrimaryParentCategoryId()
    {
        return this.primaryParentCategoryId;
    }

    public void setPrimaryParentCategoryId(String primaryParentCategoryId)
    {
        this.primaryParentCategoryId = primaryParentCategoryId;
    }

    private String categoryName;

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
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

    private String categoryImageUrl;

    public String getCategoryImageUrl()
    {
        return this.categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl)
    {
        this.categoryImageUrl = categoryImageUrl;
    }

    private String detailScreen;

    public String getDetailScreen()
    {
        return this.detailScreen;
    }

    public void setDetailScreen(String detailScreen)
    {
        this.detailScreen = detailScreen;
    }

    private Boolean showInSelect;

    public Boolean getShowInSelect()
    {
        return this.showInSelect;
    }

    public void setShowInSelect(Boolean showInSelect)
    {
        this.showInSelect = showInSelect;
    }

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
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

    public AbstractProductCategoryState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setProductCategoryId(((ProductCategoryEvent.SqlProductCategoryEvent) events.get(0)).getProductCategoryEventId().getProductCategoryId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractProductCategoryState() {
        this(false);
    }

    public AbstractProductCategoryState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getProductCategoryId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getProductCategoryId(), ((ProductCategoryState)obj).getProductCategoryId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ProductCategoryStateCreated) {
            when((ProductCategoryStateCreated) e);
        } else if (e instanceof ProductCategoryStateMergePatched) {
            when((ProductCategoryStateMergePatched) e);
        } else if (e instanceof ProductCategoryStateDeleted) {
            when((ProductCategoryStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ProductCategoryStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setProductCategoryTypeId(e.getProductCategoryTypeId());
        this.setPrimaryParentCategoryId(e.getPrimaryParentCategoryId());
        this.setCategoryName(e.getCategoryName());
        this.setDescription(e.getDescription());
        this.setCategoryImageUrl(e.getCategoryImageUrl());
        this.setDetailScreen(e.getDetailScreen());
        this.setShowInSelect(e.getShowInSelect());
        this.setAttributeSetId(e.getAttributeSetId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(ProductCategoryState s) {
        if (s == this) {
            return;
        }
        this.setProductCategoryTypeId(s.getProductCategoryTypeId());
        this.setPrimaryParentCategoryId(s.getPrimaryParentCategoryId());
        this.setCategoryName(s.getCategoryName());
        this.setDescription(s.getDescription());
        this.setCategoryImageUrl(s.getCategoryImageUrl());
        this.setDetailScreen(s.getDetailScreen());
        this.setShowInSelect(s.getShowInSelect());
        this.setAttributeSetId(s.getAttributeSetId());
        this.setActive(s.getActive());
    }

    public void when(ProductCategoryStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getProductCategoryTypeId() == null)
        {
            if (e.getIsPropertyProductCategoryTypeIdRemoved() != null && e.getIsPropertyProductCategoryTypeIdRemoved())
            {
                this.setProductCategoryTypeId(null);
            }
        }
        else
        {
            this.setProductCategoryTypeId(e.getProductCategoryTypeId());
        }
        if (e.getPrimaryParentCategoryId() == null)
        {
            if (e.getIsPropertyPrimaryParentCategoryIdRemoved() != null && e.getIsPropertyPrimaryParentCategoryIdRemoved())
            {
                this.setPrimaryParentCategoryId(null);
            }
        }
        else
        {
            this.setPrimaryParentCategoryId(e.getPrimaryParentCategoryId());
        }
        if (e.getCategoryName() == null)
        {
            if (e.getIsPropertyCategoryNameRemoved() != null && e.getIsPropertyCategoryNameRemoved())
            {
                this.setCategoryName(null);
            }
        }
        else
        {
            this.setCategoryName(e.getCategoryName());
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
        if (e.getCategoryImageUrl() == null)
        {
            if (e.getIsPropertyCategoryImageUrlRemoved() != null && e.getIsPropertyCategoryImageUrlRemoved())
            {
                this.setCategoryImageUrl(null);
            }
        }
        else
        {
            this.setCategoryImageUrl(e.getCategoryImageUrl());
        }
        if (e.getDetailScreen() == null)
        {
            if (e.getIsPropertyDetailScreenRemoved() != null && e.getIsPropertyDetailScreenRemoved())
            {
                this.setDetailScreen(null);
            }
        }
        else
        {
            this.setDetailScreen(e.getDetailScreen());
        }
        if (e.getShowInSelect() == null)
        {
            if (e.getIsPropertyShowInSelectRemoved() != null && e.getIsPropertyShowInSelectRemoved())
            {
                this.setShowInSelect(null);
            }
        }
        else
        {
            this.setShowInSelect(e.getShowInSelect());
        }
        if (e.getAttributeSetId() == null)
        {
            if (e.getIsPropertyAttributeSetIdRemoved() != null && e.getIsPropertyAttributeSetIdRemoved())
            {
                this.setAttributeSetId(null);
            }
        }
        else
        {
            this.setAttributeSetId(e.getAttributeSetId());
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

    public void when(ProductCategoryStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ProductCategoryEvent event)
    {
        String stateEntityId = this.getProductCategoryId(); // Aggregate Id
        String eventEntityId = ((ProductCategoryEvent.SqlProductCategoryEvent)event).getProductCategoryEventId().getProductCategoryId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((ProductCategoryEvent.SqlProductCategoryEvent)event).getProductCategoryEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getProductCategoryEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ProductCategoryState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleProductCategoryState extends AbstractProductCategoryState
    {

        public SimpleProductCategoryState() {
        }

        public SimpleProductCategoryState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleProductCategoryState(List<Event> events) {
            super(events);
        }

    }


}

