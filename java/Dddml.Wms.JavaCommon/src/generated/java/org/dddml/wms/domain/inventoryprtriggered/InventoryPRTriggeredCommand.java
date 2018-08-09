package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InventoryPRTriggeredCommand extends Command
{
    InventoryPRTriggeredId getInventoryPRTriggeredId();

    void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(InventoryPRTriggeredState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((InventoryPRTriggeredCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((InventoryPRTriggeredCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InventoryPRTriggeredCommand c) {
        return ((c instanceof InventoryPRTriggeredCommand.CreateInventoryPRTriggered) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(InventoryPRTriggeredState.VERSION_NULL)));
    }

    interface CreateOrMergePatchInventoryPRTriggered extends InventoryPRTriggeredCommand
    {
        Boolean getIsProcessed();

        void setIsProcessed(Boolean isProcessed);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryPRTriggered extends CreateOrMergePatchInventoryPRTriggered
    {
    }

    interface MergePatchInventoryPRTriggered extends CreateOrMergePatchInventoryPRTriggered
    {
        Boolean getIsPropertyIsProcessedRemoved();

        void setIsPropertyIsProcessedRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteInventoryPRTriggered extends InventoryPRTriggeredCommand
	{
	}

}

