package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentPackageContentStateCommandConverter<TCreateShipmentPackageContent extends ShipmentPackageContentCommand.CreateShipmentPackageContent, TMergePatchShipmentPackageContent extends ShipmentPackageContentCommand.MergePatchShipmentPackageContent, TRemoveShipmentPackageContent extends ShipmentPackageContentCommand.RemoveShipmentPackageContent>
{
    public ShipmentPackageContentCommand toCreateOrMergePatchShipmentPackageContent(ShipmentPackageContentState state)
    {
        //where TCreateShipmentPackageContent : ICreateShipmentPackageContent, new()
        //where TMergePatchShipmentPackageContent : IMergePatchShipmentPackageContent, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentPackageContent(state);
        }
        else 
        {
            return toMergePatchShipmentPackageContent(state);
        }
    }

    public TRemoveShipmentPackageContent toRemoveShipmentPackageContent(ShipmentPackageContentState state) //where TRemoveShipmentPackageContent : IRemoveShipmentPackageContent, new()
    {
        TRemoveShipmentPackageContent cmd = newRemoveShipmentPackageContent();
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        return cmd;
    }

    public TMergePatchShipmentPackageContent toMergePatchShipmentPackageContent(ShipmentPackageContentState state) //where TMergePatchShipmentPackageContent : IMergePatchShipmentPackageContent, new()
    {
        TMergePatchShipmentPackageContent cmd = newMergePatchShipmentPackageContent();

        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSubProductId(state.getSubProductId());
        cmd.setSubProductQuantity(state.getSubProductQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentPackageId(state.getShipmentPackageId());
            
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getSubProductId() == null) { cmd.setIsPropertySubProductIdRemoved(true); }
        if (state.getSubProductQuantity() == null) { cmd.setIsPropertySubProductQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentPackageContent toCreateShipmentPackageContent(ShipmentPackageContentState state) //where TCreateShipmentPackageContent : ICreateShipmentPackageContent, new()
    {
        TCreateShipmentPackageContent cmd = newCreateShipmentPackageContent();

        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSubProductId(state.getSubProductId());
        cmd.setSubProductQuantity(state.getSubProductQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentPackageId(state.getShipmentPackageId());
        return cmd;
    }

    protected abstract TCreateShipmentPackageContent newCreateShipmentPackageContent();

    protected abstract TMergePatchShipmentPackageContent newMergePatchShipmentPackageContent(); 

    protected abstract TRemoveShipmentPackageContent newRemoveShipmentPackageContent();

    public static class SimpleShipmentPackageContentStateCommandConverter extends AbstractShipmentPackageContentStateCommandConverter<AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent, AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent, AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent>
    {
        @Override
        protected AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent newCreateShipmentPackageContent() {
            return new AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent();
        }

        @Override
        protected AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent newMergePatchShipmentPackageContent() {
            return new AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent();
        }

        @Override
        protected AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent newRemoveShipmentPackageContent() {
            return new AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent();
        }


    }

}

