package org.dddml.wms.domain.inventorypostingrule;

import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryPostingRuleDto extends AbstractInventoryPostingRuleCommandDto
{
    private InventoryItemIdDto trigger;

    public InventoryItemIdDto getTrigger()
    {
        return this.trigger;
    }

    public void setTrigger(InventoryItemIdDto trigger)
    {
        this.trigger = trigger;
    }

    private InventoryItemIdDto output;

    public InventoryItemIdDto getOutput()
    {
        return this.output;
    }

    public void setOutput(InventoryItemIdDto output)
    {
        this.output = output;
    }

    private Boolean isOutputNegated;

    public Boolean getIsOutputNegated()
    {
        return this.isOutputNegated;
    }

    public void setIsOutputNegated(Boolean isOutputNegated)
    {
        this.isOutputNegated = isOutputNegated;
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

    private Boolean isPropertyTriggerRemoved;

    public Boolean getIsPropertyTriggerRemoved()
    {
        return this.isPropertyTriggerRemoved;
    }

    public void setIsPropertyTriggerRemoved(Boolean removed)
    {
        this.isPropertyTriggerRemoved = removed;
    }

    private Boolean isPropertyOutputRemoved;

    public Boolean getIsPropertyOutputRemoved()
    {
        return this.isPropertyOutputRemoved;
    }

    public void setIsPropertyOutputRemoved(Boolean removed)
    {
        this.isPropertyOutputRemoved = removed;
    }

    private Boolean isPropertyIsOutputNegatedRemoved;

    public Boolean getIsPropertyIsOutputNegatedRemoved()
    {
        return this.isPropertyIsOutputNegatedRemoved;
    }

    public void setIsPropertyIsOutputNegatedRemoved(Boolean removed)
    {
        this.isPropertyIsOutputNegatedRemoved = removed;
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

    public void copyTo(AbstractInventoryPostingRuleCommand.AbstractCreateOrMergePatchInventoryPostingRule command)
    {
        ((AbstractInventoryPostingRuleCommandDto) this).copyTo(command);
        command.setTrigger((this.getTrigger() == null) ? null : this.getTrigger().toInventoryItemId());
        command.setOutput((this.getOutput() == null) ? null : this.getOutput().toInventoryItemId());
        command.setIsOutputNegated(this.getIsOutputNegated());
        command.setActive(this.getActive());
    }

    public InventoryPostingRuleCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule command = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
            copyTo((AbstractInventoryPostingRuleCommand.AbstractCreateInventoryPostingRule) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInventoryPostingRuleCommand.SimpleMergePatchInventoryPostingRule command = new AbstractInventoryPostingRuleCommand.SimpleMergePatchInventoryPostingRule();
            copyTo((AbstractInventoryPostingRuleCommand.SimpleMergePatchInventoryPostingRule) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInventoryPostingRuleCommand.AbstractCreateInventoryPostingRule command)
    {
        copyTo((AbstractInventoryPostingRuleCommand.AbstractCreateOrMergePatchInventoryPostingRule) command);
    }

    public void copyTo(AbstractInventoryPostingRuleCommand.AbstractMergePatchInventoryPostingRule command)
    {
        copyTo((AbstractInventoryPostingRuleCommand.AbstractCreateOrMergePatchInventoryPostingRule) command);
        command.setIsPropertyTriggerRemoved(this.getIsPropertyTriggerRemoved());
        command.setIsPropertyOutputRemoved(this.getIsPropertyOutputRemoved());
        command.setIsPropertyIsOutputNegatedRemoved(this.getIsPropertyIsOutputNegatedRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateInventoryPostingRuleDto extends CreateOrMergePatchInventoryPostingRuleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InventoryPostingRuleCommand.CreateInventoryPostingRule toCreateInventoryPostingRule()
        {
            return (InventoryPostingRuleCommand.CreateInventoryPostingRule) toCommand();
        }

    }

    public static class MergePatchInventoryPostingRuleDto extends CreateOrMergePatchInventoryPostingRuleDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InventoryPostingRuleCommand.MergePatchInventoryPostingRule toMergePatchInventoryPostingRule()
        {
            return (InventoryPostingRuleCommand.MergePatchInventoryPostingRule) toCommand();
        }

    }

}

