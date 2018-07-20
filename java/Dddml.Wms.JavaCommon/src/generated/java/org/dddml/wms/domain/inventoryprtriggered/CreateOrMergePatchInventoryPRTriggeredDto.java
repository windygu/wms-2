package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryPRTriggeredDto extends AbstractInventoryPRTriggeredCommandDto
{
    /**
     * Is Processed
     */
    private Boolean isProcessed;

    public Boolean getIsProcessed()
    {
        return this.isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed)
    {
        this.isProcessed = isProcessed;
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

    private Boolean isPropertyIsProcessedRemoved;

    public Boolean getIsPropertyIsProcessedRemoved()
    {
        return this.isPropertyIsProcessedRemoved;
    }

    public void setIsPropertyIsProcessedRemoved(Boolean removed)
    {
        this.isPropertyIsProcessedRemoved = removed;
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

    public void copyTo(AbstractInventoryPRTriggeredCommand.AbstractCreateOrMergePatchInventoryPRTriggered command)
    {
        ((AbstractInventoryPRTriggeredCommandDto) this).copyTo(command);
        command.setIsProcessed(this.getIsProcessed());
        command.setActive(this.getActive());
    }

    public InventoryPRTriggeredCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryPRTriggeredCommand.SimpleCreateInventoryPRTriggered command = new AbstractInventoryPRTriggeredCommand.SimpleCreateInventoryPRTriggered();
            copyTo((AbstractInventoryPRTriggeredCommand.AbstractCreateInventoryPRTriggered) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryPRTriggeredCommand.SimpleMergePatchInventoryPRTriggered command = new AbstractInventoryPRTriggeredCommand.SimpleMergePatchInventoryPRTriggered();
            copyTo((AbstractInventoryPRTriggeredCommand.SimpleMergePatchInventoryPRTriggered) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryPRTriggeredCommand.AbstractCreateInventoryPRTriggered command)
    {
        copyTo((AbstractInventoryPRTriggeredCommand.AbstractCreateOrMergePatchInventoryPRTriggered) command);
    }

    public void copyTo(AbstractInventoryPRTriggeredCommand.AbstractMergePatchInventoryPRTriggered command)
    {
        copyTo((AbstractInventoryPRTriggeredCommand.AbstractCreateOrMergePatchInventoryPRTriggered) command);
        command.setIsPropertyIsProcessedRemoved(this.getIsPropertyIsProcessedRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInventoryPRTriggeredDto extends CreateOrMergePatchInventoryPRTriggeredDto
    {
        public CreateInventoryPRTriggeredDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryPRTriggeredCommand.CreateInventoryPRTriggered toCreateInventoryPRTriggered()
        {
            return (InventoryPRTriggeredCommand.CreateInventoryPRTriggered) toCommand();
        }

    }

    public static class MergePatchInventoryPRTriggeredDto extends CreateOrMergePatchInventoryPRTriggeredDto
    {
        public MergePatchInventoryPRTriggeredDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered toMergePatchInventoryPRTriggered()
        {
            return (InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered) toCommand();
        }

    }

}

