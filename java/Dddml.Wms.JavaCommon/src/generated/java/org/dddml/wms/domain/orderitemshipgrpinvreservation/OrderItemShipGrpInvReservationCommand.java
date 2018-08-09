package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderItemShipGrpInvReservationCommand extends Command
{
    OrderItemShipGrpInvResId getOrderItemShipGrpInvResId();

    void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(OrderItemShipGrpInvReservationState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((OrderItemShipGrpInvReservationCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((OrderItemShipGrpInvReservationCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrderItemShipGrpInvReservationCommand c) {
        return ((c instanceof OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(OrderItemShipGrpInvReservationState.VERSION_NULL)));
    }

    interface CreateOrMergePatchOrderItemShipGrpInvReservation extends OrderItemShipGrpInvReservationCommand
    {
        String getReserveOrderEnumId();

        void setReserveOrderEnumId(String reserveOrderEnumId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.math.BigDecimal getQuantityNotAvailable();

        void setQuantityNotAvailable(java.math.BigDecimal quantityNotAvailable);

        java.sql.Timestamp getReservedDatetime();

        void setReservedDatetime(java.sql.Timestamp reservedDatetime);

        java.sql.Timestamp getCreatedDatetime();

        void setCreatedDatetime(java.sql.Timestamp createdDatetime);

        java.sql.Timestamp getPromisedDatetime();

        void setPromisedDatetime(java.sql.Timestamp promisedDatetime);

        java.sql.Timestamp getCurrentPromisedDate();

        void setCurrentPromisedDate(java.sql.Timestamp currentPromisedDate);

        String getPriority();

        void setPriority(String priority);

        Long getSequenceId();

        void setSequenceId(Long sequenceId);

        java.sql.Timestamp getOldPickStartDate();

        void setOldPickStartDate(java.sql.Timestamp oldPickStartDate);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrderItemShipGrpInvReservation extends CreateOrMergePatchOrderItemShipGrpInvReservation
    {
    }

    interface MergePatchOrderItemShipGrpInvReservation extends CreateOrMergePatchOrderItemShipGrpInvReservation
    {
        Boolean getIsPropertyReserveOrderEnumIdRemoved();

        void setIsPropertyReserveOrderEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyQuantityNotAvailableRemoved();

        void setIsPropertyQuantityNotAvailableRemoved(Boolean removed);

        Boolean getIsPropertyReservedDatetimeRemoved();

        void setIsPropertyReservedDatetimeRemoved(Boolean removed);

        Boolean getIsPropertyCreatedDatetimeRemoved();

        void setIsPropertyCreatedDatetimeRemoved(Boolean removed);

        Boolean getIsPropertyPromisedDatetimeRemoved();

        void setIsPropertyPromisedDatetimeRemoved(Boolean removed);

        Boolean getIsPropertyCurrentPromisedDateRemoved();

        void setIsPropertyCurrentPromisedDateRemoved(Boolean removed);

        Boolean getIsPropertyPriorityRemoved();

        void setIsPropertyPriorityRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyOldPickStartDateRemoved();

        void setIsPropertyOldPickStartDateRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteOrderItemShipGrpInvReservation extends OrderItemShipGrpInvReservationCommand
	{
	}

}

