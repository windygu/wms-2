package org.dddml.wms.domain.shipmentitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentItemCommand extends Command
{
    ShipmentItemId getShipmentItemId();

    void setShipmentItemId(ShipmentItemId shipmentItemId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ShipmentItemState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ShipmentItemCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((ShipmentItemCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ShipmentItemCommand c) {
        return ((c instanceof ShipmentItemCommand.CreateShipmentItem) 
            && c.getVersion().equals(ShipmentItemState.VERSION_NULL));
    }

    interface CreateOrMergePatchShipmentItem extends ShipmentItemCommand
    {
        String getProductId();

        void setProductId(String productId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        String getShipmentContentDescription();

        void setShipmentContentDescription(String shipmentContentDescription);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentItem extends CreateOrMergePatchShipmentItem
    {
    }

    interface MergePatchShipmentItem extends CreateOrMergePatchShipmentItem
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyShipmentContentDescriptionRemoved();

        void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteShipmentItem extends ShipmentItemCommand
	{
	}

}

