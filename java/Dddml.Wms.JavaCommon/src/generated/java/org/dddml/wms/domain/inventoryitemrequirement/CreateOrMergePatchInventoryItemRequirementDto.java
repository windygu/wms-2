package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemRequirementDto extends AbstractInventoryItemRequirementCommandDto
{
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private CreateOrMergePatchInventoryItemRequirementEntryDto[] entries;

    public CreateOrMergePatchInventoryItemRequirementEntryDto[] getEntries()
    {
        return this.entries;
    }

    public void setEntries(CreateOrMergePatchInventoryItemRequirementEntryDto[] entries)
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

    public void copyTo(AbstractInventoryItemRequirementCommand.AbstractCreateOrMergePatchInventoryItemRequirement command)
    {
        ((AbstractInventoryItemRequirementCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public InventoryItemRequirementCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryItemRequirementCommand.SimpleCreateInventoryItemRequirement command = new AbstractInventoryItemRequirementCommand.SimpleCreateInventoryItemRequirement();
            copyTo((AbstractInventoryItemRequirementCommand.AbstractCreateInventoryItemRequirement) command);
            if (this.getEntries() != null) {
                for (CreateOrMergePatchInventoryItemRequirementEntryDto cmd : this.getEntries()) {
                    command.getEntries().add((InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement command = new AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement();
            copyTo((AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement) command);
            if (this.getEntries() != null) {
                for (CreateOrMergePatchInventoryItemRequirementEntryDto cmd : this.getEntries()) {
                    command.getInventoryItemRequirementEntryCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryItemRequirementCommand.AbstractCreateInventoryItemRequirement command)
    {
        copyTo((AbstractInventoryItemRequirementCommand.AbstractCreateOrMergePatchInventoryItemRequirement) command);
    }

    public void copyTo(AbstractInventoryItemRequirementCommand.AbstractMergePatchInventoryItemRequirement command)
    {
        copyTo((AbstractInventoryItemRequirementCommand.AbstractCreateOrMergePatchInventoryItemRequirement) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInventoryItemRequirementDto extends CreateOrMergePatchInventoryItemRequirementDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryItemRequirementCommand.CreateInventoryItemRequirement toCreateInventoryItemRequirement()
        {
            return (InventoryItemRequirementCommand.CreateInventoryItemRequirement) toCommand();
        }

    }

    public static class MergePatchInventoryItemRequirementDto extends CreateOrMergePatchInventoryItemRequirementDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryItemRequirementCommand.MergePatchInventoryItemRequirement toMergePatchInventoryItemRequirement()
        {
            return (InventoryItemRequirementCommand.MergePatchInventoryItemRequirement) toCommand();
        }

    }

}

