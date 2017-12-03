package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryPRTriggeredStateCommandConverter<TCreateInventoryPRTriggered extends InventoryPRTriggeredCommand.CreateInventoryPRTriggered, TMergePatchInventoryPRTriggered extends InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered, TDeleteInventoryPRTriggered extends InventoryPRTriggeredCommand.DeleteInventoryPRTriggered>
{
    public InventoryPRTriggeredCommand toCreateOrMergePatchInventoryPRTriggered(InventoryPRTriggeredState state)
    {
        //where TCreateInventoryPRTriggered : ICreateInventoryPRTriggered, new()
        //where TMergePatchInventoryPRTriggered : IMergePatchInventoryPRTriggered, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryPRTriggered(state);
        }
        else 
        {
            return toMergePatchInventoryPRTriggered(state);
        }
    }

    public TDeleteInventoryPRTriggered toDeleteInventoryPRTriggered(InventoryPRTriggeredState state) //where TDeleteInventoryPRTriggered : IDeleteInventoryPRTriggered, new()
    {
        TDeleteInventoryPRTriggered cmd = newDeleteInventoryPRTriggered();
        cmd.setInventoryPRTriggeredId(state.getInventoryPRTriggeredId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchInventoryPRTriggered toMergePatchInventoryPRTriggered(InventoryPRTriggeredState state) //where TMergePatchInventoryPRTriggered : IMergePatchInventoryPRTriggered, new()
    {
        TMergePatchInventoryPRTriggered cmd = newMergePatchInventoryPRTriggered();

        cmd.setVersion(state.getVersion());

        cmd.setInventoryPRTriggeredId(state.getInventoryPRTriggeredId());
        cmd.setIsProcessed(state.getIsProcessed());
            
        if (state.getIsProcessed() == null) { cmd.setIsPropertyIsProcessedRemoved(true); }
        return cmd;
    }

    public TCreateInventoryPRTriggered toCreateInventoryPRTriggered(InventoryPRTriggeredState state) //where TCreateInventoryPRTriggered : ICreateInventoryPRTriggered, new()
    {
        TCreateInventoryPRTriggered cmd = newCreateInventoryPRTriggered();

        cmd.setVersion(state.getVersion());
        cmd.setInventoryPRTriggeredId(state.getInventoryPRTriggeredId());
        cmd.setIsProcessed(state.getIsProcessed());
        return cmd;
    }

    protected abstract TCreateInventoryPRTriggered newCreateInventoryPRTriggered();

    protected abstract TMergePatchInventoryPRTriggered newMergePatchInventoryPRTriggered(); 

    protected abstract TDeleteInventoryPRTriggered newDeleteInventoryPRTriggered();

    public static class SimpleInventoryPRTriggeredStateCommandConverter extends AbstractInventoryPRTriggeredStateCommandConverter<AbstractInventoryPRTriggeredCommand.SimpleCreateInventoryPRTriggered, AbstractInventoryPRTriggeredCommand.SimpleMergePatchInventoryPRTriggered, AbstractInventoryPRTriggeredCommand.SimpleDeleteInventoryPRTriggered>
    {
        @Override
        protected AbstractInventoryPRTriggeredCommand.SimpleCreateInventoryPRTriggered newCreateInventoryPRTriggered() {
            return new AbstractInventoryPRTriggeredCommand.SimpleCreateInventoryPRTriggered();
        }

        @Override
        protected AbstractInventoryPRTriggeredCommand.SimpleMergePatchInventoryPRTriggered newMergePatchInventoryPRTriggered() {
            return new AbstractInventoryPRTriggeredCommand.SimpleMergePatchInventoryPRTriggered();
        }

        @Override
        protected AbstractInventoryPRTriggeredCommand.SimpleDeleteInventoryPRTriggered newDeleteInventoryPRTriggered() {
            return new AbstractInventoryPRTriggeredCommand.SimpleDeleteInventoryPRTriggered();
        }


    }

}

