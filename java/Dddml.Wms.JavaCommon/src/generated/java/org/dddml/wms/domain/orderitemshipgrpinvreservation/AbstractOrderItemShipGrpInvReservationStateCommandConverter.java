package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderItemShipGrpInvReservationStateCommandConverter<TCreateOrderItemShipGrpInvReservation extends OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation, TMergePatchOrderItemShipGrpInvReservation extends OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation, TDeleteOrderItemShipGrpInvReservation extends OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation>
{
    public OrderItemShipGrpInvReservationCommand toCreateOrMergePatchOrderItemShipGrpInvReservation(OrderItemShipGrpInvReservationState state)
    {
        //where TCreateOrderItemShipGrpInvReservation : ICreateOrderItemShipGrpInvReservation, new()
        //where TMergePatchOrderItemShipGrpInvReservation : IMergePatchOrderItemShipGrpInvReservation, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderItemShipGrpInvReservation(state);
        }
        else 
        {
            return toMergePatchOrderItemShipGrpInvReservation(state);
        }
    }

    public TDeleteOrderItemShipGrpInvReservation toDeleteOrderItemShipGrpInvReservation(OrderItemShipGrpInvReservationState state) //where TDeleteOrderItemShipGrpInvReservation : IDeleteOrderItemShipGrpInvReservation, new()
    {
        TDeleteOrderItemShipGrpInvReservation cmd = newDeleteOrderItemShipGrpInvReservation();
        cmd.setOrderItemShipGrpInvResId(state.getOrderItemShipGrpInvResId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchOrderItemShipGrpInvReservation toMergePatchOrderItemShipGrpInvReservation(OrderItemShipGrpInvReservationState state) //where TMergePatchOrderItemShipGrpInvReservation : IMergePatchOrderItemShipGrpInvReservation, new()
    {
        TMergePatchOrderItemShipGrpInvReservation cmd = newMergePatchOrderItemShipGrpInvReservation();

        cmd.setVersion(state.getVersion());

        cmd.setOrderItemShipGrpInvResId(state.getOrderItemShipGrpInvResId());
        cmd.setReserveOrderEnumId(state.getReserveOrderEnumId());
        cmd.setQuantity(state.getQuantity());
        cmd.setQuantityNotAvailable(state.getQuantityNotAvailable());
        cmd.setReservedDatetime(state.getReservedDatetime());
        cmd.setCreatedDatetime(state.getCreatedDatetime());
        cmd.setPromisedDatetime(state.getPromisedDatetime());
        cmd.setCurrentPromisedDate(state.getCurrentPromisedDate());
        cmd.setPriority(state.getPriority());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setOldPickStartDate(state.getOldPickStartDate());
        cmd.setActive(state.getActive());
            
        if (state.getReserveOrderEnumId() == null) { cmd.setIsPropertyReserveOrderEnumIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getQuantityNotAvailable() == null) { cmd.setIsPropertyQuantityNotAvailableRemoved(true); }
        if (state.getReservedDatetime() == null) { cmd.setIsPropertyReservedDatetimeRemoved(true); }
        if (state.getCreatedDatetime() == null) { cmd.setIsPropertyCreatedDatetimeRemoved(true); }
        if (state.getPromisedDatetime() == null) { cmd.setIsPropertyPromisedDatetimeRemoved(true); }
        if (state.getCurrentPromisedDate() == null) { cmd.setIsPropertyCurrentPromisedDateRemoved(true); }
        if (state.getPriority() == null) { cmd.setIsPropertyPriorityRemoved(true); }
        if (state.getSequenceId() == null) { cmd.setIsPropertySequenceIdRemoved(true); }
        if (state.getOldPickStartDate() == null) { cmd.setIsPropertyOldPickStartDateRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderItemShipGrpInvReservation toCreateOrderItemShipGrpInvReservation(OrderItemShipGrpInvReservationState state) //where TCreateOrderItemShipGrpInvReservation : ICreateOrderItemShipGrpInvReservation, new()
    {
        TCreateOrderItemShipGrpInvReservation cmd = newCreateOrderItemShipGrpInvReservation();

        cmd.setVersion(state.getVersion());
        cmd.setOrderItemShipGrpInvResId(state.getOrderItemShipGrpInvResId());
        cmd.setReserveOrderEnumId(state.getReserveOrderEnumId());
        cmd.setQuantity(state.getQuantity());
        cmd.setQuantityNotAvailable(state.getQuantityNotAvailable());
        cmd.setReservedDatetime(state.getReservedDatetime());
        cmd.setCreatedDatetime(state.getCreatedDatetime());
        cmd.setPromisedDatetime(state.getPromisedDatetime());
        cmd.setCurrentPromisedDate(state.getCurrentPromisedDate());
        cmd.setPriority(state.getPriority());
        cmd.setSequenceId(state.getSequenceId());
        cmd.setOldPickStartDate(state.getOldPickStartDate());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateOrderItemShipGrpInvReservation newCreateOrderItemShipGrpInvReservation();

    protected abstract TMergePatchOrderItemShipGrpInvReservation newMergePatchOrderItemShipGrpInvReservation(); 

    protected abstract TDeleteOrderItemShipGrpInvReservation newDeleteOrderItemShipGrpInvReservation();

    public static class SimpleOrderItemShipGrpInvReservationStateCommandConverter extends AbstractOrderItemShipGrpInvReservationStateCommandConverter<AbstractOrderItemShipGrpInvReservationCommand.SimpleCreateOrderItemShipGrpInvReservation, AbstractOrderItemShipGrpInvReservationCommand.SimpleMergePatchOrderItemShipGrpInvReservation, AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation>
    {
        @Override
        protected AbstractOrderItemShipGrpInvReservationCommand.SimpleCreateOrderItemShipGrpInvReservation newCreateOrderItemShipGrpInvReservation() {
            return new AbstractOrderItemShipGrpInvReservationCommand.SimpleCreateOrderItemShipGrpInvReservation();
        }

        @Override
        protected AbstractOrderItemShipGrpInvReservationCommand.SimpleMergePatchOrderItemShipGrpInvReservation newMergePatchOrderItemShipGrpInvReservation() {
            return new AbstractOrderItemShipGrpInvReservationCommand.SimpleMergePatchOrderItemShipGrpInvReservation();
        }

        @Override
        protected AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation newDeleteOrderItemShipGrpInvReservation() {
            return new AbstractOrderItemShipGrpInvReservationCommand.SimpleDeleteOrderItemShipGrpInvReservation();
        }


    }

}

