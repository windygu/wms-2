package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface InventoryPRTriggeredCommand extends Command
{
    InventoryPRTriggeredId getInventoryPRTriggeredId();

    void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId);

    Long getVersion();

    void setVersion(Long version);


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

