package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentMethodTypeCommand extends Command
{
    String getShipmentMethodTypeId();

    void setShipmentMethodTypeId(String shipmentMethodTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ShipmentMethodTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ShipmentMethodTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((ShipmentMethodTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ShipmentMethodTypeCommand c) {
        return ((c instanceof ShipmentMethodTypeCommand.CreateShipmentMethodType) 
            && c.getVersion().equals(ShipmentMethodTypeState.VERSION_NULL));
    }

    interface CreateOrMergePatchShipmentMethodType extends ShipmentMethodTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Long getSequenceNum();

        void setSequenceNum(Long sequenceNum);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentMethodType extends CreateOrMergePatchShipmentMethodType
    {
    }

    interface MergePatchShipmentMethodType extends CreateOrMergePatchShipmentMethodType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceNumRemoved();

        void setIsPropertySequenceNumRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteShipmentMethodType extends ShipmentMethodTypeCommand
	{
	}

}

