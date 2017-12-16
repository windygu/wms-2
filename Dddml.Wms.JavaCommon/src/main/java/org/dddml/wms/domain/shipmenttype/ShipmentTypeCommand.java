package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentTypeCommand extends Command
{
    String getShipmentTypeId();

    void setShipmentTypeId(String shipmentTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ShipmentTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ShipmentTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((ShipmentTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ShipmentTypeCommand c) {
        return ((c instanceof ShipmentTypeCommand.CreateShipmentType) 
            && c.getVersion().equals(ShipmentTypeState.VERSION_NULL));
    }

    interface CreateOrMergePatchShipmentType extends ShipmentTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentType extends CreateOrMergePatchShipmentType
    {
    }

    interface MergePatchShipmentType extends CreateOrMergePatchShipmentType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteShipmentType extends ShipmentTypeCommand
	{
	}

}

