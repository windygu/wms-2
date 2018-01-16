package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderShipmentStateCommandConverter<TCreateOrderShipment extends OrderShipmentCommand.CreateOrderShipment, TMergePatchOrderShipment extends OrderShipmentCommand.MergePatchOrderShipment, TDeleteOrderShipment extends OrderShipmentCommand.DeleteOrderShipment>
{
    public OrderShipmentCommand toCreateOrMergePatchOrderShipment(OrderShipmentState state)
    {
        //where TCreateOrderShipment : ICreateOrderShipment, new()
        //where TMergePatchOrderShipment : IMergePatchOrderShipment, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderShipment(state);
        }
        else 
        {
            return toMergePatchOrderShipment(state);
        }
    }

    public TDeleteOrderShipment toDeleteOrderShipment(OrderShipmentState state) //where TDeleteOrderShipment : IDeleteOrderShipment, new()
    {
        TDeleteOrderShipment cmd = newDeleteOrderShipment();
        cmd.setOrderShipmentId(state.getOrderShipmentId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchOrderShipment toMergePatchOrderShipment(OrderShipmentState state) //where TMergePatchOrderShipment : IMergePatchOrderShipment, new()
    {
        TMergePatchOrderShipment cmd = newMergePatchOrderShipment();

        cmd.setVersion(state.getVersion());

        cmd.setOrderShipmentId(state.getOrderShipmentId());
        cmd.setQuantity(state.getQuantity());
        cmd.setActive(state.getActive());
            
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderShipment toCreateOrderShipment(OrderShipmentState state) //where TCreateOrderShipment : ICreateOrderShipment, new()
    {
        TCreateOrderShipment cmd = newCreateOrderShipment();

        cmd.setVersion(state.getVersion());
        cmd.setOrderShipmentId(state.getOrderShipmentId());
        cmd.setQuantity(state.getQuantity());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateOrderShipment newCreateOrderShipment();

    protected abstract TMergePatchOrderShipment newMergePatchOrderShipment(); 

    protected abstract TDeleteOrderShipment newDeleteOrderShipment();

    public static class SimpleOrderShipmentStateCommandConverter extends AbstractOrderShipmentStateCommandConverter<AbstractOrderShipmentCommand.SimpleCreateOrderShipment, AbstractOrderShipmentCommand.SimpleMergePatchOrderShipment, AbstractOrderShipmentCommand.SimpleDeleteOrderShipment>
    {
        @Override
        protected AbstractOrderShipmentCommand.SimpleCreateOrderShipment newCreateOrderShipment() {
            return new AbstractOrderShipmentCommand.SimpleCreateOrderShipment();
        }

        @Override
        protected AbstractOrderShipmentCommand.SimpleMergePatchOrderShipment newMergePatchOrderShipment() {
            return new AbstractOrderShipmentCommand.SimpleMergePatchOrderShipment();
        }

        @Override
        protected AbstractOrderShipmentCommand.SimpleDeleteOrderShipment newDeleteOrderShipment() {
            return new AbstractOrderShipmentCommand.SimpleDeleteOrderShipment();
        }


    }

}

