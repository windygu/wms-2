package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryPostingRuleStateCommandConverter<TCreateInventoryPostingRule extends InventoryPostingRuleCommand.CreateInventoryPostingRule, TMergePatchInventoryPostingRule extends InventoryPostingRuleCommand.MergePatchInventoryPostingRule, TDeleteInventoryPostingRule extends InventoryPostingRuleCommand.DeleteInventoryPostingRule>
{
    public InventoryPostingRuleCommand toCreateOrMergePatchInventoryPostingRule(InventoryPostingRuleState state)
    {
        //where TCreateInventoryPostingRule : ICreateInventoryPostingRule, new()
        //where TMergePatchInventoryPostingRule : IMergePatchInventoryPostingRule, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryPostingRule(state);
        }
        else 
        {
            return toMergePatchInventoryPostingRule(state);
        }
    }

    public TDeleteInventoryPostingRule toDeleteInventoryPostingRule(InventoryPostingRuleState state) //where TDeleteInventoryPostingRule : IDeleteInventoryPostingRule, new()
    {
        TDeleteInventoryPostingRule cmd = newDeleteInventoryPostingRule();
        cmd.setInventoryPostingRuleId(state.getInventoryPostingRuleId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchInventoryPostingRule toMergePatchInventoryPostingRule(InventoryPostingRuleState state) //where TMergePatchInventoryPostingRule : IMergePatchInventoryPostingRule, new()
    {
        TMergePatchInventoryPostingRule cmd = newMergePatchInventoryPostingRule();

        cmd.setVersion(state.getVersion());

        cmd.setInventoryPostingRuleId(state.getInventoryPostingRuleId());
        cmd.setTrigger(state.getTrigger());
        cmd.setOutput(state.getOutput());
        cmd.setAccountName(state.getAccountName());
        cmd.setIsOutputNegated(state.getIsOutputNegated());
        cmd.setActive(state.getActive());
            
        if (state.getTrigger() == null) { cmd.setIsPropertyTriggerRemoved(true); }
        if (state.getOutput() == null) { cmd.setIsPropertyOutputRemoved(true); }
        if (state.getAccountName() == null) { cmd.setIsPropertyAccountNameRemoved(true); }
        if (state.getIsOutputNegated() == null) { cmd.setIsPropertyIsOutputNegatedRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateInventoryPostingRule toCreateInventoryPostingRule(InventoryPostingRuleState state) //where TCreateInventoryPostingRule : ICreateInventoryPostingRule, new()
    {
        TCreateInventoryPostingRule cmd = newCreateInventoryPostingRule();

        cmd.setVersion(state.getVersion());
        cmd.setInventoryPostingRuleId(state.getInventoryPostingRuleId());
        cmd.setTrigger(state.getTrigger());
        cmd.setOutput(state.getOutput());
        cmd.setAccountName(state.getAccountName());
        cmd.setIsOutputNegated(state.getIsOutputNegated());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateInventoryPostingRule newCreateInventoryPostingRule();

    protected abstract TMergePatchInventoryPostingRule newMergePatchInventoryPostingRule(); 

    protected abstract TDeleteInventoryPostingRule newDeleteInventoryPostingRule();

    public static class SimpleInventoryPostingRuleStateCommandConverter extends AbstractInventoryPostingRuleStateCommandConverter<AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule, AbstractInventoryPostingRuleCommand.SimpleMergePatchInventoryPostingRule, AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule>
    {
        @Override
        protected AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule newCreateInventoryPostingRule() {
            return new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        }

        @Override
        protected AbstractInventoryPostingRuleCommand.SimpleMergePatchInventoryPostingRule newMergePatchInventoryPostingRule() {
            return new AbstractInventoryPostingRuleCommand.SimpleMergePatchInventoryPostingRule();
        }

        @Override
        protected AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule newDeleteInventoryPostingRule() {
            return new AbstractInventoryPostingRuleCommand.SimpleDeleteInventoryPostingRule();
        }


    }

}

