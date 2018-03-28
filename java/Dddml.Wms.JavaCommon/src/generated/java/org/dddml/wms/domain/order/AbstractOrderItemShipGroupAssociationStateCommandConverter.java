package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderItemShipGroupAssociationStateCommandConverter<TCreateOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation, TMergePatchOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation, TRemoveOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation>
{
    public OrderItemShipGroupAssociationCommand toCreateOrMergePatchOrderItemShipGroupAssociation(OrderItemShipGroupAssociationState state)
    {
        //where TCreateOrderItemShipGroupAssociation : ICreateOrderItemShipGroupAssociation, new()
        //where TMergePatchOrderItemShipGroupAssociation : IMergePatchOrderItemShipGroupAssociation, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderItemShipGroupAssociation(state);
        }
        else 
        {
            return toMergePatchOrderItemShipGroupAssociation(state);
        }
    }

    public TRemoveOrderItemShipGroupAssociation toRemoveOrderItemShipGroupAssociation(OrderItemShipGroupAssociationState state) //where TRemoveOrderItemShipGroupAssociation : IRemoveOrderItemShipGroupAssociation, new()
    {
        TRemoveOrderItemShipGroupAssociation cmd = newRemoveOrderItemShipGroupAssociation();
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        return cmd;
    }

    public TMergePatchOrderItemShipGroupAssociation toMergePatchOrderItemShipGroupAssociation(OrderItemShipGroupAssociationState state) //where TMergePatchOrderItemShipGroupAssociation : IMergePatchOrderItemShipGroupAssociation, new()
    {
        TMergePatchOrderItemShipGroupAssociation cmd = newMergePatchOrderItemShipGroupAssociation();

        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderShipGroupShipGroupSeqId(state.getOrderShipGroupShipGroupSeqId());
            
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getCancelQuantity() == null) { cmd.setIsPropertyCancelQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderItemShipGroupAssociation toCreateOrderItemShipGroupAssociation(OrderItemShipGroupAssociationState state) //where TCreateOrderItemShipGroupAssociation : ICreateOrderItemShipGroupAssociation, new()
    {
        TCreateOrderItemShipGroupAssociation cmd = newCreateOrderItemShipGroupAssociation();

        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderShipGroupShipGroupSeqId(state.getOrderShipGroupShipGroupSeqId());
        return cmd;
    }

    protected abstract TCreateOrderItemShipGroupAssociation newCreateOrderItemShipGroupAssociation();

    protected abstract TMergePatchOrderItemShipGroupAssociation newMergePatchOrderItemShipGroupAssociation(); 

    protected abstract TRemoveOrderItemShipGroupAssociation newRemoveOrderItemShipGroupAssociation();

    public static class SimpleOrderItemShipGroupAssociationStateCommandConverter extends AbstractOrderItemShipGroupAssociationStateCommandConverter<AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation, AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation, AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation>
    {
        @Override
        protected AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation newCreateOrderItemShipGroupAssociation() {
            return new AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation();
        }

        @Override
        protected AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation newMergePatchOrderItemShipGroupAssociation() {
            return new AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation();
        }

        @Override
        protected AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation newRemoveOrderItemShipGroupAssociation() {
            return new AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation();
        }


    }

}

