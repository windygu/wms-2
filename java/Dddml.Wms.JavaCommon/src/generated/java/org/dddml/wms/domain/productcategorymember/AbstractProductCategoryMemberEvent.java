package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractProductCategoryMemberEvent extends AbstractEvent implements ProductCategoryMemberEvent.SqlProductCategoryMemberEvent 
{
    private ProductCategoryMemberEventId productCategoryMemberEventId;

    public ProductCategoryMemberEventId getProductCategoryMemberEventId() {
        return this.productCategoryMemberEventId;
    }

    public void setProductCategoryMemberEventId(ProductCategoryMemberEventId eventId) {
        this.productCategoryMemberEventId = eventId;
    }
    
    public ProductCategoryMemberId getProductCategoryMemberId() {
        return getProductCategoryMemberEventId().getProductCategoryMemberId();
    }

    public void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId) {
        getProductCategoryMemberEventId().setProductCategoryMemberId(productCategoryMemberId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getProductCategoryMemberEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getProductCategoryMemberEventId().setVersion(version);
    //}

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractProductCategoryMemberEvent() {
    }

    protected AbstractProductCategoryMemberEvent(ProductCategoryMemberEventId eventId) {
        this.productCategoryMemberEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractProductCategoryMemberStateEvent extends AbstractProductCategoryMemberEvent implements ProductCategoryMemberEvent.ProductCategoryMemberStateEvent {
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractProductCategoryMemberStateEvent(ProductCategoryMemberEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractProductCategoryMemberStateCreated extends AbstractProductCategoryMemberStateEvent implements ProductCategoryMemberEvent.ProductCategoryMemberStateCreated
    {
        public AbstractProductCategoryMemberStateCreated() {
            this(new ProductCategoryMemberEventId());
        }

        public AbstractProductCategoryMemberStateCreated(ProductCategoryMemberEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractProductCategoryMemberStateMergePatched extends AbstractProductCategoryMemberStateEvent implements ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched
    {
        public AbstractProductCategoryMemberStateMergePatched() {
            this(new ProductCategoryMemberEventId());
        }

        public AbstractProductCategoryMemberStateMergePatched(ProductCategoryMemberEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyThruDateRemoved;

        public Boolean getIsPropertyThruDateRemoved() {
            return this.isPropertyThruDateRemoved;
        }

        public void setIsPropertyThruDateRemoved(Boolean removed) {
            this.isPropertyThruDateRemoved = removed;
        }

        private Boolean isPropertyCommentsRemoved;

        public Boolean getIsPropertyCommentsRemoved() {
            return this.isPropertyCommentsRemoved;
        }

        public void setIsPropertyCommentsRemoved(Boolean removed) {
            this.isPropertyCommentsRemoved = removed;
        }

        private Boolean isPropertySequenceNumRemoved;

        public Boolean getIsPropertySequenceNumRemoved() {
            return this.isPropertySequenceNumRemoved;
        }

        public void setIsPropertySequenceNumRemoved(Boolean removed) {
            this.isPropertySequenceNumRemoved = removed;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static class SimpleProductCategoryMemberStateCreated extends AbstractProductCategoryMemberStateCreated
    {
        public SimpleProductCategoryMemberStateCreated() {
        }

        public SimpleProductCategoryMemberStateCreated(ProductCategoryMemberEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleProductCategoryMemberStateMergePatched extends AbstractProductCategoryMemberStateMergePatched
    {
        public SimpleProductCategoryMemberStateMergePatched() {
        }

        public SimpleProductCategoryMemberStateMergePatched(ProductCategoryMemberEventId eventId) {
            super(eventId);
        }
    }

}

