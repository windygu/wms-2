package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchSellableInventoryItemDto extends AbstractSellableInventoryItemCommandDto
{
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

    private CreateOrMergePatchSellableInventoryItemEntryDto[] entries;

    public CreateOrMergePatchSellableInventoryItemEntryDto[] getEntries()
    {
        return this.entries;
    }

    public void setEntries(CreateOrMergePatchSellableInventoryItemEntryDto[] entries)
    {
        this.entries = entries;
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

    public void copyTo(AbstractSellableInventoryItemCommand.AbstractCreateOrMergePatchSellableInventoryItem command)
    {
        ((AbstractSellableInventoryItemCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public SellableInventoryItemCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractSellableInventoryItemCommand.SimpleCreateSellableInventoryItem command = new AbstractSellableInventoryItemCommand.SimpleCreateSellableInventoryItem();
            copyTo((AbstractSellableInventoryItemCommand.AbstractCreateSellableInventoryItem) command);
            if (this.getEntries() != null) {
                for (CreateOrMergePatchSellableInventoryItemEntryDto cmd : this.getEntries()) {
                    command.getEntries().add((SellableInventoryItemEntryCommand.CreateSellableInventoryItemEntry) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem command = new AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem();
            copyTo((AbstractSellableInventoryItemCommand.SimpleMergePatchSellableInventoryItem) command);
            if (this.getEntries() != null) {
                for (CreateOrMergePatchSellableInventoryItemEntryDto cmd : this.getEntries()) {
                    command.getSellableInventoryItemEntryCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractSellableInventoryItemCommand.AbstractCreateSellableInventoryItem command)
    {
        copyTo((AbstractSellableInventoryItemCommand.AbstractCreateOrMergePatchSellableInventoryItem) command);
    }

    public void copyTo(AbstractSellableInventoryItemCommand.AbstractMergePatchSellableInventoryItem command)
    {
        copyTo((AbstractSellableInventoryItemCommand.AbstractCreateOrMergePatchSellableInventoryItem) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateSellableInventoryItemDto extends CreateOrMergePatchSellableInventoryItemDto
    {
        public CreateSellableInventoryItemDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public SellableInventoryItemCommand.CreateSellableInventoryItem toCreateSellableInventoryItem()
        {
            return (SellableInventoryItemCommand.CreateSellableInventoryItem) toCommand();
        }

    }

    public static class MergePatchSellableInventoryItemDto extends CreateOrMergePatchSellableInventoryItemDto
    {
        public MergePatchSellableInventoryItemDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public SellableInventoryItemCommand.MergePatchSellableInventoryItem toMergePatchSellableInventoryItem()
        {
            return (SellableInventoryItemCommand.MergePatchSellableInventoryItem) toCommand();
        }

    }

}

