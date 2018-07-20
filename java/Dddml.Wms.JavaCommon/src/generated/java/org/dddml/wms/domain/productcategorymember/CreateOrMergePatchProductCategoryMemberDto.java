package org.dddml.wms.domain.productcategorymember;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchProductCategoryMemberDto extends AbstractProductCategoryMemberCommandDto
{
    /**
     * Thru Date
     */
    private java.sql.Timestamp thruDate;

    public java.sql.Timestamp getThruDate()
    {
        return this.thruDate;
    }

    public void setThruDate(java.sql.Timestamp thruDate)
    {
        this.thruDate = thruDate;
    }

    /**
     * Comments
     */
    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    /**
     * Sequence Num
     */
    private Long sequenceNum;

    public Long getSequenceNum()
    {
        return this.sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum)
    {
        this.sequenceNum = sequenceNum;
    }

    /**
     * Quantity
     */
    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Active
     */
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

    public void copyTo(AbstractProductCategoryMemberCommand.AbstractCreateOrMergePatchProductCategoryMember command)
    {
        ((AbstractProductCategoryMemberCommandDto) this).copyTo(command);
        command.setThruDate(this.getThruDate());
        command.setComments(this.getComments());
        command.setSequenceNum(this.getSequenceNum());
        command.setQuantity(this.getQuantity());
        command.setActive(this.getActive());
    }

    public ProductCategoryMemberCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractProductCategoryMemberCommand.SimpleCreateProductCategoryMember command = new AbstractProductCategoryMemberCommand.SimpleCreateProductCategoryMember();
            copyTo((AbstractProductCategoryMemberCommand.AbstractCreateProductCategoryMember) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractProductCategoryMemberCommand.SimpleMergePatchProductCategoryMember command = new AbstractProductCategoryMemberCommand.SimpleMergePatchProductCategoryMember();
            copyTo((AbstractProductCategoryMemberCommand.SimpleMergePatchProductCategoryMember) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractProductCategoryMemberCommand.AbstractCreateProductCategoryMember command)
    {
        copyTo((AbstractProductCategoryMemberCommand.AbstractCreateOrMergePatchProductCategoryMember) command);
    }

    public void copyTo(AbstractProductCategoryMemberCommand.AbstractMergePatchProductCategoryMember command)
    {
        copyTo((AbstractProductCategoryMemberCommand.AbstractCreateOrMergePatchProductCategoryMember) command);
        command.setIsPropertyThruDateRemoved(this.getIsPropertyThruDateRemoved());
        command.setIsPropertyCommentsRemoved(this.getIsPropertyCommentsRemoved());
        command.setIsPropertySequenceNumRemoved(this.getIsPropertySequenceNumRemoved());
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateProductCategoryMemberDto extends CreateOrMergePatchProductCategoryMemberDto
    {
        public CreateProductCategoryMemberDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ProductCategoryMemberCommand.CreateProductCategoryMember toCreateProductCategoryMember()
        {
            return (ProductCategoryMemberCommand.CreateProductCategoryMember) toCommand();
        }

    }

    public static class MergePatchProductCategoryMemberDto extends CreateOrMergePatchProductCategoryMemberDto
    {
        public MergePatchProductCategoryMemberDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ProductCategoryMemberCommand.MergePatchProductCategoryMember toMergePatchProductCategoryMember()
        {
            return (ProductCategoryMemberCommand.MergePatchProductCategoryMember) toCommand();
        }

    }

}

