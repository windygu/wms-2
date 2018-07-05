package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ProductCategoryMemberStateDto
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

}

