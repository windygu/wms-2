package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractProductCategoryMemberCommand extends AbstractCommand implements ProductCategoryMemberCommand
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchProductCategoryMember extends AbstractProductCategoryMemberCommand implements CreateOrMergePatchProductCategoryMember
    {
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

    }

    public static abstract class AbstractCreateProductCategoryMember extends AbstractCreateOrMergePatchProductCategoryMember implements CreateProductCategoryMember
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchProductCategoryMember extends AbstractCreateOrMergePatchProductCategoryMember implements MergePatchProductCategoryMember
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyThruDateRemoved;

        public Boolean getIsPropertyThruDateRemoved()
        {
            return this.isPropertyThruDateRemoved;
        }

        public void setIsPropertyThruDateRemoved(Boolean removed)
        {
            this.isPropertyThruDateRemoved = removed;
        }

        private Boolean isPropertyCommentsRemoved;

        public Boolean getIsPropertyCommentsRemoved()
        {
            return this.isPropertyCommentsRemoved;
        }

        public void setIsPropertyCommentsRemoved(Boolean removed)
        {
            this.isPropertyCommentsRemoved = removed;
        }

        private Boolean isPropertySequenceNumRemoved;

        public Boolean getIsPropertySequenceNumRemoved()
        {
            return this.isPropertySequenceNumRemoved;
        }

        public void setIsPropertySequenceNumRemoved(Boolean removed)
        {
            this.isPropertySequenceNumRemoved = removed;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved()
        {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed)
        {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

    }

    public static class SimpleCreateProductCategoryMember extends AbstractCreateProductCategoryMember
    {
    }

    
    public static class SimpleMergePatchProductCategoryMember extends AbstractMergePatchProductCategoryMember
    {
    }

    
	public static class SimpleDeleteProductCategoryMember extends AbstractProductCategoryMemberCommand implements DeleteProductCategoryMember
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

