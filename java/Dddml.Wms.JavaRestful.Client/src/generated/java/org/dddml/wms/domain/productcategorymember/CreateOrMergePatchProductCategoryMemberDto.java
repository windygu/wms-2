package org.dddml.wms.domain.productcategorymember;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchProductCategoryMemberDto extends AbstractProductCategoryMemberCommandDto
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

    public static class CreateProductCategoryMemberDto extends CreateOrMergePatchProductCategoryMemberDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchProductCategoryMemberDto extends CreateOrMergePatchProductCategoryMemberDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

