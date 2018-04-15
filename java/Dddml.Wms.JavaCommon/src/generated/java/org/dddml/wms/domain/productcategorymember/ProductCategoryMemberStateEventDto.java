package org.dddml.wms.domain.productcategorymember;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class ProductCategoryMemberStateEventDto extends AbstractEvent
{

    private ProductCategoryMemberEventId productCategoryMemberEventId;

    ProductCategoryMemberEventId getStateEventId() {
        if (productCategoryMemberEventId == null) { productCategoryMemberEventId = new ProductCategoryMemberEventId(); }
        return productCategoryMemberEventId;
    }

    void setProductCategoryMemberEventId(ProductCategoryMemberEventId eventId) {
        this.productCategoryMemberEventId = eventId;
    }

    public ProductCategoryMemberId getProductCategoryMemberId() {
        return getStateEventId().getProductCategoryMemberId();
    }

    public void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId) {
        getStateEventId().setProductCategoryMemberId(productCategoryMemberId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private java.sql.Timestamp thruDate;

    public java.sql.Timestamp getThruDate() {
        return this.thruDate;
    }

    public void setThruDate(java.sql.Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    private String comments;

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private Long sequenceNum;

    public Long getSequenceNum() {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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


	public static class ProductCategoryMemberStateCreatedDto extends ProductCategoryMemberStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ProductCategoryMemberStateMergePatchedDto extends ProductCategoryMemberStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ProductCategoryMemberStateDeletedDto extends ProductCategoryMemberStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

