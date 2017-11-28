package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemEventTypeDto extends AbstractInventoryItemEventTypeCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
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

    public void copyTo(AbstractInventoryItemEventTypeCommand.AbstractCreateOrMergePatchInventoryItemEventType command)
    {
        ((AbstractInventoryItemEventTypeCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public InventoryItemEventTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemEventTypeCommand.SimpleCreateInventoryItemEventType command = new AbstractInventoryItemEventTypeCommand.SimpleCreateInventoryItemEventType();
            copyTo((AbstractInventoryItemEventTypeCommand.AbstractCreateInventoryItemEventType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryItemEventTypeCommand.SimpleMergePatchInventoryItemEventType command = new AbstractInventoryItemEventTypeCommand.SimpleMergePatchInventoryItemEventType();
            copyTo((AbstractInventoryItemEventTypeCommand.SimpleMergePatchInventoryItemEventType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemEventTypeCommand.AbstractCreateInventoryItemEventType command)
    {
        copyTo((AbstractInventoryItemEventTypeCommand.AbstractCreateOrMergePatchInventoryItemEventType) command);
    }

    public void copyTo(AbstractInventoryItemEventTypeCommand.AbstractMergePatchInventoryItemEventType command)
    {
        copyTo((AbstractInventoryItemEventTypeCommand.AbstractCreateOrMergePatchInventoryItemEventType) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInventoryItemEventTypeDto extends CreateOrMergePatchInventoryItemEventTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemEventTypeCommand.CreateInventoryItemEventType toCreateInventoryItemEventType()
        {
            return (InventoryItemEventTypeCommand.CreateInventoryItemEventType) toCommand();
        }

    }

    public static class MergePatchInventoryItemEventTypeDto extends CreateOrMergePatchInventoryItemEventTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryItemEventTypeCommand.MergePatchInventoryItemEventType toMergePatchInventoryItemEventType()
        {
            return (InventoryItemEventTypeCommand.MergePatchInventoryItemEventType) toCommand();
        }

    }

}

