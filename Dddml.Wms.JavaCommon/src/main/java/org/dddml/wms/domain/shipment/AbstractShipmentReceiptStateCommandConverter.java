package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentReceiptStateCommandConverter<TCreateShipmentReceipt extends ShipmentReceiptCommand.CreateShipmentReceipt, TMergePatchShipmentReceipt extends ShipmentReceiptCommand.MergePatchShipmentReceipt, TRemoveShipmentReceipt extends ShipmentReceiptCommand.RemoveShipmentReceipt>
{
    public ShipmentReceiptCommand toCreateOrMergePatchShipmentReceipt(ShipmentReceiptState state)
    {
        //where TCreateShipmentReceipt : ICreateShipmentReceipt, new()
        //where TMergePatchShipmentReceipt : IMergePatchShipmentReceipt, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentReceipt(state);
        }
        else 
        {
            return toMergePatchShipmentReceipt(state);
        }
    }

    public TRemoveShipmentReceipt toRemoveShipmentReceipt(ShipmentReceiptState state) //where TRemoveShipmentReceipt : IRemoveShipmentReceipt, new()
    {
        TRemoveShipmentReceipt cmd = newRemoveShipmentReceipt();
        cmd.setReceiptSeqId(state.getReceiptSeqId());
        return cmd;
    }

    public TMergePatchShipmentReceipt toMergePatchShipmentReceipt(ShipmentReceiptState state) //where TMergePatchShipmentReceipt : IMergePatchShipmentReceipt, new()
    {
        TMergePatchShipmentReceipt cmd = newMergePatchShipmentReceipt();

        cmd.setReceiptSeqId(state.getReceiptSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setRejectionId(state.getRejectionId());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setAcceptedQuantity(state.getAcceptedQuantity());
        cmd.setRejectedQuantity(state.getRejectedQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
            
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getShipmentItemSeqId() == null) { cmd.setIsPropertyShipmentItemSeqIdRemoved(true); }
        if (state.getRejectionId() == null) { cmd.setIsPropertyRejectionIdRemoved(true); }
        if (state.getItemDescription() == null) { cmd.setIsPropertyItemDescriptionRemoved(true); }
        if (state.getAcceptedQuantity() == null) { cmd.setIsPropertyAcceptedQuantityRemoved(true); }
        if (state.getRejectedQuantity() == null) { cmd.setIsPropertyRejectedQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentReceipt toCreateShipmentReceipt(ShipmentReceiptState state) //where TCreateShipmentReceipt : ICreateShipmentReceipt, new()
    {
        TCreateShipmentReceipt cmd = newCreateShipmentReceipt();

        cmd.setReceiptSeqId(state.getReceiptSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setRejectionId(state.getRejectionId());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setAcceptedQuantity(state.getAcceptedQuantity());
        cmd.setRejectedQuantity(state.getRejectedQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
        return cmd;
    }

    protected abstract TCreateShipmentReceipt newCreateShipmentReceipt();

    protected abstract TMergePatchShipmentReceipt newMergePatchShipmentReceipt(); 

    protected abstract TRemoveShipmentReceipt newRemoveShipmentReceipt();

    public static class SimpleShipmentReceiptStateCommandConverter extends AbstractShipmentReceiptStateCommandConverter<AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt, AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt, AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt>
    {
        @Override
        protected AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt newCreateShipmentReceipt() {
            return new AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt();
        }

        @Override
        protected AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt newMergePatchShipmentReceipt() {
            return new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
        }

        @Override
        protected AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt newRemoveShipmentReceipt() {
            return new AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt();
        }


    }

}

