package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractProductCategoryMemberStateEvent extends AbstractStateEvent implements ProductCategoryMemberStateEvent 
{
    private ProductCategoryMemberStateEventId stateEventId;

    public ProductCategoryMemberStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(ProductCategoryMemberStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public ProductCategoryMemberId getProductCategoryMemberId() {
        return getStateEventId().getProductCategoryMemberId();
    }

    public void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId) {
        getStateEventId().setProductCategoryMemberId(productCategoryMemberId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractProductCategoryMemberStateEvent() {
    }

    protected AbstractProductCategoryMemberStateEvent(ProductCategoryMemberStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractProductCategoryMemberStateCreated extends AbstractProductCategoryMemberStateEvent implements ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated
    {
        public AbstractProductCategoryMemberStateCreated() {
            this(new ProductCategoryMemberStateEventId());
        }

        public AbstractProductCategoryMemberStateCreated(ProductCategoryMemberStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractProductCategoryMemberStateMergePatched extends AbstractProductCategoryMemberStateEvent implements ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched
    {
        public AbstractProductCategoryMemberStateMergePatched() {
            this(new ProductCategoryMemberStateEventId());
        }

        public AbstractProductCategoryMemberStateMergePatched(ProductCategoryMemberStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
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

        public SimpleProductCategoryMemberStateCreated(ProductCategoryMemberStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleProductCategoryMemberStateMergePatched extends AbstractProductCategoryMemberStateMergePatched
    {
        public SimpleProductCategoryMemberStateMergePatched() {
        }

        public SimpleProductCategoryMemberStateMergePatched(ProductCategoryMemberStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

