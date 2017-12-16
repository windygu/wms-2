package org.dddml.wms.domain.shipmentitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentItemStateCommandConverter<TCreateShipmentItem extends ShipmentItemCommand.CreateShipmentItem, TMergePatchShipmentItem extends ShipmentItemCommand.MergePatchShipmentItem, TDeleteShipmentItem extends ShipmentItemCommand.DeleteShipmentItem>
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

    public TDeleteShipmentItem toDeleteShipmentItem(ShipmentItemState state) //where TDeleteShipmentItem : IDeleteShipmentItem, new()
    {
        TDeleteShipmentItem cmd = newDeleteShipmentItem();
        cmd.setShipmentItemId(state.getShipmentItemId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchShipmentItem toMergePatchShipmentItem(ShipmentItemState state) //where TMergePatchShipmentItem : IMergePatchShipmentItem, new()
    {
        TMergePatchShipmentItem cmd = newMergePatchShipmentItem();

        cmd.setVersion(state.getVersion());

        cmd.setShipmentItemId(state.getShipmentItemId());
        cmd.setProductId(state.getProductId());
        cmd.setQuantity(state.getQuantity());
        cmd.setShipmentContentDescription(state.getShipmentContentDescription());
        cmd.setActive(state.getActive());
            
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getShipmentContentDescription() == null) { cmd.setIsPropertyShipmentContentDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentItem toCreateShipmentItem(ShipmentItemState state) //where TCreateShipmentItem : ICreateShipmentItem, new()
    {
        TCreateShipmentItem cmd = newCreateShipmentItem();

        cmd.setVersion(state.getVersion());
        cmd.setShipmentItemId(state.getShipmentItemId());
        cmd.setProductId(state.getProductId());
        cmd.setQuantity(state.getQuantity());
        cmd.setShipmentContentDescription(state.getShipmentContentDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateShipmentItem newCreateShipmentItem();

    protected abstract TMergePatchShipmentItem newMergePatchShipmentItem(); 

    protected abstract TDeleteShipmentItem newDeleteShipmentItem();

    public static class SimpleShipmentItemStateCommandConverter extends AbstractShipmentItemStateCommandConverter<AbstractShipmentItemCommand.SimpleCreateShipmentItem, AbstractShipmentItemCommand.SimpleMergePatchShipmentItem, AbstractShipmentItemCommand.SimpleDeleteShipmentItem>
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
        protected AbstractShipmentItemCommand.SimpleDeleteShipmentItem newDeleteShipmentItem() {
            return new AbstractShipmentItemCommand.SimpleDeleteShipmentItem();
        }


    }

}

