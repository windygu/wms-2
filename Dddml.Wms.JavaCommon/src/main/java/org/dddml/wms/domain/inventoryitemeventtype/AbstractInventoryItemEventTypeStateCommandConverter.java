package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryItemEventTypeStateCommandConverter<TCreateInventoryItemEventType extends InventoryItemEventTypeCommand.CreateInventoryItemEventType, TMergePatchInventoryItemEventType extends InventoryItemEventTypeCommand.MergePatchInventoryItemEventType, TDeleteInventoryItemEventType extends InventoryItemEventTypeCommand.DeleteInventoryItemEventType>
{
    public InventoryItemEventTypeCommand toCreateOrMergePatchInventoryItemEventType(InventoryItemEventTypeState state)
    {
        //where TCreateInventoryItemEventType : ICreateInventoryItemEventType, new()
        //where TMergePatchInventoryItemEventType : IMergePatchInventoryItemEventType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryItemEventType(state);
        }
        else 
        {
            return toMergePatchInventoryItemEventType(state);
        }
    }

    public TDeleteInventoryItemEventType toDeleteInventoryItemEventType(InventoryItemEventTypeState state) //where TDeleteInventoryItemEventType : IDeleteInventoryItemEventType, new()
    {
        TDeleteInventoryItemEventType cmd = newDeleteInventoryItemEventType();
        cmd.setInventoryItemEventTypeId(state.getInventoryItemEventTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchInventoryItemEventType toMergePatchInventoryItemEventType(InventoryItemEventTypeState state) //where TMergePatchInventoryItemEventType : IMergePatchInventoryItemEventType, new()
    {
        TMergePatchInventoryItemEventType cmd = newMergePatchInventoryItemEventType();

        cmd.setVersion(state.getVersion());

        cmd.setInventoryItemEventTypeId(state.getInventoryItemEventTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateInventoryItemEventType toCreateInventoryItemEventType(InventoryItemEventTypeState state) //where TCreateInventoryItemEventType : ICreateInventoryItemEventType, new()
    {
        TCreateInventoryItemEventType cmd = newCreateInventoryItemEventType();

        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemEventTypeId(state.getInventoryItemEventTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateInventoryItemEventType newCreateInventoryItemEventType();

    protected abstract TMergePatchInventoryItemEventType newMergePatchInventoryItemEventType(); 

    protected abstract TDeleteInventoryItemEventType newDeleteInventoryItemEventType();

    public static class SimpleInventoryItemEventTypeStateCommandConverter extends AbstractInventoryItemEventTypeStateCommandConverter<AbstractInventoryItemEventTypeCommand.SimpleCreateInventoryItemEventType, AbstractInventoryItemEventTypeCommand.SimpleMergePatchInventoryItemEventType, AbstractInventoryItemEventTypeCommand.SimpleDeleteInventoryItemEventType>
    {
        @Override
        protected AbstractInventoryItemEventTypeCommand.SimpleCreateInventoryItemEventType newCreateInventoryItemEventType() {
            return new AbstractInventoryItemEventTypeCommand.SimpleCreateInventoryItemEventType();
        }

        @Override
        protected AbstractInventoryItemEventTypeCommand.SimpleMergePatchInventoryItemEventType newMergePatchInventoryItemEventType() {
            return new AbstractInventoryItemEventTypeCommand.SimpleMergePatchInventoryItemEventType();
        }

        @Override
        protected AbstractInventoryItemEventTypeCommand.SimpleDeleteInventoryItemEventType newDeleteInventoryItemEventType() {
            return new AbstractInventoryItemEventTypeCommand.SimpleDeleteInventoryItemEventType();
        }


    }

}

