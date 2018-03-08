package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractProductCategoryStateEvent extends AbstractStateEvent implements ProductCategoryStateEvent 
{
    private ProductCategoryEventId stateEventId;

    public ProductCategoryEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(ProductCategoryEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public String getProductCategoryId() {
        return getStateEventId().getProductCategoryId();
    }

    public void setProductCategoryId(String productCategoryId) {
        getStateEventId().setProductCategoryId(productCategoryId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractProductCategoryStateEvent() {
    }

    protected AbstractProductCategoryStateEvent(ProductCategoryEventId eventId) {
        this.stateEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractProductCategoryStateCreated extends AbstractProductCategoryStateEvent implements ProductCategoryStateEvent.ProductCategoryStateCreated
    {
        public AbstractProductCategoryStateCreated() {
            this(new ProductCategoryEventId());
        }

        public AbstractProductCategoryStateCreated(ProductCategoryEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractProductCategoryStateMergePatched extends AbstractProductCategoryStateEvent implements ProductCategoryStateEvent.ProductCategoryStateMergePatched
    {
        public AbstractProductCategoryStateMergePatched() {
            this(new ProductCategoryEventId());
        }

        public AbstractProductCategoryStateMergePatched(ProductCategoryEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyProductCategoryTypeIdRemoved;

        public Boolean getIsPropertyProductCategoryTypeIdRemoved() {
            return this.isPropertyProductCategoryTypeIdRemoved;
        }

        public void setIsPropertyProductCategoryTypeIdRemoved(Boolean removed) {
            this.isPropertyProductCategoryTypeIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryParentCategoryIdRemoved;

        public Boolean getIsPropertyPrimaryParentCategoryIdRemoved() {
            return this.isPropertyPrimaryParentCategoryIdRemoved;
        }

        public void setIsPropertyPrimaryParentCategoryIdRemoved(Boolean removed) {
            this.isPropertyPrimaryParentCategoryIdRemoved = removed;
        }

        private Boolean isPropertyCategoryNameRemoved;

        public Boolean getIsPropertyCategoryNameRemoved() {
            return this.isPropertyCategoryNameRemoved;
        }

        public void setIsPropertyCategoryNameRemoved(Boolean removed) {
            this.isPropertyCategoryNameRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyCategoryImageUrlRemoved;

        public Boolean getIsPropertyCategoryImageUrlRemoved() {
            return this.isPropertyCategoryImageUrlRemoved;
        }

        public void setIsPropertyCategoryImageUrlRemoved(Boolean removed) {
            this.isPropertyCategoryImageUrlRemoved = removed;
        }

        private Boolean isPropertyDetailScreenRemoved;

        public Boolean getIsPropertyDetailScreenRemoved() {
            return this.isPropertyDetailScreenRemoved;
        }

        public void setIsPropertyDetailScreenRemoved(Boolean removed) {
            this.isPropertyDetailScreenRemoved = removed;
        }

        private Boolean isPropertyShowInSelectRemoved;

        public Boolean getIsPropertyShowInSelectRemoved() {
            return this.isPropertyShowInSelectRemoved;
        }

        public void setIsPropertyShowInSelectRemoved(Boolean removed) {
            this.isPropertyShowInSelectRemoved = removed;
        }

        private Boolean isPropertyAttributeSetIdRemoved;

        public Boolean getIsPropertyAttributeSetIdRemoved() {
            return this.isPropertyAttributeSetIdRemoved;
        }

        public void setIsPropertyAttributeSetIdRemoved(Boolean removed) {
            this.isPropertyAttributeSetIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractProductCategoryStateDeleted extends AbstractProductCategoryStateEvent implements ProductCategoryStateEvent.ProductCategoryStateDeleted
    {
        public AbstractProductCategoryStateDeleted() {
            this(new ProductCategoryEventId());
        }

        public AbstractProductCategoryStateDeleted(ProductCategoryEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleProductCategoryStateCreated extends AbstractProductCategoryStateCreated
    {
        public SimpleProductCategoryStateCreated() {
        }

        public SimpleProductCategoryStateCreated(ProductCategoryEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleProductCategoryStateMergePatched extends AbstractProductCategoryStateMergePatched
    {
        public SimpleProductCategoryStateMergePatched() {
        }

        public SimpleProductCategoryStateMergePatched(ProductCategoryEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleProductCategoryStateDeleted extends AbstractProductCategoryStateDeleted
    {
        public SimpleProductCategoryStateDeleted() {
        }

        public SimpleProductCategoryStateDeleted(ProductCategoryEventId eventId) {
            super(eventId);
        }
    }

}

