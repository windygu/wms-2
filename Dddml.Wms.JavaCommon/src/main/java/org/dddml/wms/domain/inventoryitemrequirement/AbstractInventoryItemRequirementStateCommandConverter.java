package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryItemRequirementStateCommandConverter<TCreateInventoryItemRequirement extends InventoryItemRequirementCommand.CreateInventoryItemRequirement, TMergePatchInventoryItemRequirement extends InventoryItemRequirementCommand.MergePatchInventoryItemRequirement, TDeleteInventoryItemRequirement extends InventoryItemRequirementCommand.DeleteInventoryItemRequirement, TCreateInventoryItemRequirementEntry extends InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry>
{
    public InventoryItemRequirementCommand toCreateOrMergePatchInventoryItemRequirement(InventoryItemRequirementState state)
    {
        //where TCreateInventoryItemRequirement : ICreateInventoryItemRequirement, new()
        //where TMergePatchInventoryItemRequirement : IMergePatchInventoryItemRequirement, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryItemRequirement(state);
        }
        else 
        {
            return toMergePatchInventoryItemRequirement(state);
        }
    }

    public TDeleteInventoryItemRequirement toDeleteInventoryItemRequirement(InventoryItemRequirementState state) //where TDeleteInventoryItemRequirement : IDeleteInventoryItemRequirement, new()
    {
        TDeleteInventoryItemRequirement cmd = newDeleteInventoryItemRequirement();
        cmd.setInventoryItemRequirementId(state.getInventoryItemRequirementId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchInventoryItemRequirement toMergePatchInventoryItemRequirement(InventoryItemRequirementState state) //where TMergePatchInventoryItemRequirement : IMergePatchInventoryItemRequirement, new()
    {
        TMergePatchInventoryItemRequirement cmd = newMergePatchInventoryItemRequirement();

        cmd.setVersion(state.getVersion());

        cmd.setInventoryItemRequirementId(state.getInventoryItemRequirementId());
            
        for (InventoryItemRequirementEntryState d : state.getEntries())
        {
            InventoryItemRequirementEntryCommand c = getInventoryItemRequirementEntryStateCommandConverter().toCreateOrMergePatchInventoryItemRequirementEntry(d);
            cmd.getInventoryItemRequirementEntryCommands().add(c);
        }
        return cmd;
    }

    public TCreateInventoryItemRequirement toCreateInventoryItemRequirement(InventoryItemRequirementState state) //where TCreateInventoryItemRequirement : ICreateInventoryItemRequirement, new()
    {
        TCreateInventoryItemRequirement cmd = newCreateInventoryItemRequirement();

        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemRequirementId(state.getInventoryItemRequirementId());
        for (InventoryItemRequirementEntryState d : state.getEntries())
        {
            InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry c = getInventoryItemRequirementEntryStateCommandConverter().toCreateInventoryItemRequirementEntry(d);
            cmd.getEntries().add(c);
        }
        return cmd;
    }

    protected abstract AbstractInventoryItemRequirementEntryStateCommandConverter<TCreateInventoryItemRequirementEntry>
        getInventoryItemRequirementEntryStateCommandConverter();

    protected abstract TCreateInventoryItemRequirement newCreateInventoryItemRequirement();

    protected abstract TMergePatchInventoryItemRequirement newMergePatchInventoryItemRequirement(); 

    protected abstract TDeleteInventoryItemRequirement newDeleteInventoryItemRequirement();

    public static class SimpleInventoryItemRequirementStateCommandConverter extends AbstractInventoryItemRequirementStateCommandConverter<AbstractInventoryItemRequirementCommand.SimpleCreateInventoryItemRequirement, AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement, AbstractInventoryItemRequirementCommand.SimpleDeleteInventoryItemRequirement, AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry>
    {
        @Override
        protected AbstractInventoryItemRequirementCommand.SimpleCreateInventoryItemRequirement newCreateInventoryItemRequirement() {
            return new AbstractInventoryItemRequirementCommand.SimpleCreateInventoryItemRequirement();
        }

        @Override
        protected AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement newMergePatchInventoryItemRequirement() {
            return new AbstractInventoryItemRequirementCommand.SimpleMergePatchInventoryItemRequirement();
        }

        @Override
        protected AbstractInventoryItemRequirementCommand.SimpleDeleteInventoryItemRequirement newDeleteInventoryItemRequirement() {
            return new AbstractInventoryItemRequirementCommand.SimpleDeleteInventoryItemRequirement();
        }

        @Override
        protected AbstractInventoryItemRequirementEntryStateCommandConverter<AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry> getInventoryItemRequirementEntryStateCommandConverter()
        {
            return new AbstractInventoryItemRequirementEntryStateCommandConverter.SimpleInventoryItemRequirementEntryStateCommandConverter();
        }


    }

}

