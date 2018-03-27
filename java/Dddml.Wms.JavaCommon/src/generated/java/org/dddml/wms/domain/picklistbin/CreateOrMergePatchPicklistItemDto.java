package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPicklistItemDto extends AbstractPicklistItemCommandDto
{
    private String itemStatusId;

    public String getItemStatusId()
    {
        return this.itemStatusId;
    }

    public void setItemStatusId(String itemStatusId)
    {
        this.itemStatusId = itemStatusId;
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

    private Boolean isPropertyItemStatusIdRemoved;

    public Boolean getIsPropertyItemStatusIdRemoved()
    {
        return this.isPropertyItemStatusIdRemoved;
    }

    public void setIsPropertyItemStatusIdRemoved(Boolean removed)
    {
        this.isPropertyItemStatusIdRemoved = removed;
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

    public void copyTo(AbstractPicklistItemCommand.AbstractCreateOrMergePatchPicklistItem command)
    {
        ((AbstractPicklistItemCommandDto) this).copyTo(command);
        command.setItemStatusId(this.getItemStatusId());
        command.setQuantity(this.getQuantity());
        command.setActive(this.getActive());
    }

    public PicklistItemCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPicklistItemCommand.SimpleCreatePicklistItem command = new AbstractPicklistItemCommand.SimpleCreatePicklistItem();
            copyTo((AbstractPicklistItemCommand.AbstractCreatePicklistItem) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPicklistItemCommand.SimpleMergePatchPicklistItem command = new AbstractPicklistItemCommand.SimpleMergePatchPicklistItem();
            copyTo((AbstractPicklistItemCommand.SimpleMergePatchPicklistItem) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractPicklistItemCommand.SimpleRemovePicklistItem command = new AbstractPicklistItemCommand.SimpleRemovePicklistItem();
            ((AbstractPicklistItemCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPicklistItemCommand.AbstractCreatePicklistItem command)
    {
        copyTo((AbstractPicklistItemCommand.AbstractCreateOrMergePatchPicklistItem) command);
    }

    public void copyTo(AbstractPicklistItemCommand.AbstractMergePatchPicklistItem command)
    {
        copyTo((AbstractPicklistItemCommand.AbstractCreateOrMergePatchPicklistItem) command);
        command.setIsPropertyItemStatusIdRemoved(this.getIsPropertyItemStatusIdRemoved());
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePicklistItemDto extends CreateOrMergePatchPicklistItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PicklistItemCommand.CreatePicklistItem toCreatePicklistItem()
        {
            return (PicklistItemCommand.CreatePicklistItem) toCommand();
        }

    }

    public static class MergePatchPicklistItemDto extends CreateOrMergePatchPicklistItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PicklistItemCommand.MergePatchPicklistItem toMergePatchPicklistItem()
        {
            return (PicklistItemCommand.MergePatchPicklistItem) toCommand();
        }

    }

}

