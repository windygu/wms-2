package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderShipmentCommand extends Command
{
    OrderShipmentId getOrderShipmentId();

    void setOrderShipmentId(OrderShipmentId orderShipmentId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(OrderShipmentState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((OrderShipmentCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((OrderShipmentCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrderShipmentCommand c) {
        return ((c instanceof OrderShipmentCommand.CreateOrderShipment) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(OrderShipmentState.VERSION_NULL)));
    }

    interface CreateOrMergePatchOrderShipment extends OrderShipmentCommand
    {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrderShipment extends CreateOrMergePatchOrderShipment
    {
    }

    interface MergePatchOrderShipment extends CreateOrMergePatchOrderShipment
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteOrderShipment extends OrderShipmentCommand
	{
	}

}

