package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface WarehouseCommand extends Command
{
    String getWarehouseId();

    void setWarehouseId(String warehouseId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(WarehouseState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((WarehouseCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((WarehouseCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(WarehouseCommand c) {
        return ((c instanceof WarehouseCommand.CreateWarehouse) 
            && c.getVersion().equals(WarehouseState.VERSION_NULL));
    }

    interface CreateOrMergePatchWarehouse extends WarehouseCommand
    {
        String getWarehouseName();

        void setWarehouseName(String warehouseName);

        String getDescription();

        void setDescription(String description);

        Boolean getIsInTransit();

        void setIsInTransit(Boolean isInTransit);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateWarehouse extends CreateOrMergePatchWarehouse
    {
    }

    interface MergePatchWarehouse extends CreateOrMergePatchWarehouse
    {
        Boolean getIsPropertyWarehouseNameRemoved();

        void setIsPropertyWarehouseNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyIsInTransitRemoved();

        void setIsPropertyIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteWarehouse extends WarehouseCommand
	{
	}

}

