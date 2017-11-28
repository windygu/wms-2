package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface InventoryItemEventTypeCommand extends Command
{
    String getInventoryItemEventTypeId();

    void setInventoryItemEventTypeId(String inventoryItemEventTypeId);

    Long getVersion();

    void setVersion(Long version);


    interface CreateOrMergePatchInventoryItemEventType extends InventoryItemEventTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItemEventType extends CreateOrMergePatchInventoryItemEventType
    {
    }

    interface MergePatchInventoryItemEventType extends CreateOrMergePatchInventoryItemEventType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteInventoryItemEventType extends InventoryItemEventTypeCommand
	{
	}

}

