package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentItemStateCommandConverter<TCreateShipmentItem extends ShipmentItemCommand.CreateShipmentItem, TMergePatchShipmentItem extends ShipmentItemCommand.MergePatchShipmentItem, TRemoveShipmentItem extends ShipmentItemCommand.RemoveShipmentItem>
{
    public ShipmentItemCommand toCreateOrMergePatchShipmentItem(ShipmentItemState state)
    {
        //where TCreateShipmentItem : ICreateShipmentItem, new()
        //where TMergePatchShipmentItem : IMergePatchShipmentItem, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentItem(state);
        }
        else 
        {
            return toMergePatchShipmentItem(state);
        }
    }

    public TRemoveShipmentItem toRemoveShipmentItem(ShipmentItemState state) //where TRemoveShipmentItem : IRemoveShipmentItem, new()
    {
        TRemoveShipmentItem cmd = newRemoveShipmentItem();
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        return cmd;
    }

    public TMergePatchShipmentItem toMergePatchShipmentItem(ShipmentItemState state) //where TMergePatchShipmentItem : IMergePatchShipmentItem, new()
    {
        TMergePatchShipmentItem cmd = newMergePatchShipmentItem();

        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setQuantity(state.getQuantity());
        cmd.setShipmentContentDescription(state.getShipmentContentDescription());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
            
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getShipmentContentDescription() == null) { cmd.setIsPropertyShipmentContentDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentItem toCreateShipmentItem(ShipmentItemState state) //where TCreateShipmentItem : ICreateShipmentItem, new()
    {
        TCreateShipmentItem cmd = newCreateShipmentItem();

        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setQuantity(state.getQuantity());
        cmd.setShipmentContentDescription(state.getShipmentContentDescription());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
        return cmd;
    }

    protected abstract TCreateShipmentItem newCreateShipmentItem();

    protected abstract TMergePatchShipmentItem newMergePatchShipmentItem(); 

    protected abstract TRemoveShipmentItem newRemoveShipmentItem();

    public static class SimpleShipmentItemStateCommandConverter extends AbstractShipmentItemStateCommandConverter<AbstractShipmentItemCommand.SimpleCreateShipmentItem, AbstractShipmentItemCommand.SimpleMergePatchShipmentItem, AbstractShipmentItemCommand.SimpleRemoveShipmentItem>
    {
        @Override
        protected AbstractShipmentItemCommand.SimpleCreateShipmentItem newCreateShipmentItem() {
            return new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
        }

        @Override
        protected AbstractShipmentItemCommand.SimpleMergePatchShipmentItem newMergePatchShipmentItem() {
            return new AbstractShipmentItemCommand.SimpleMergePatchShipmentItem();
        }

        @Override
        protected AbstractShipmentItemCommand.SimpleRemoveShipmentItem newRemoveShipmentItem() {
            return new AbstractShipmentItemCommand.SimpleRemoveShipmentItem();
        }


    }

}

