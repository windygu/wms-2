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
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setShipmentPackageSeqId(state.getShipmentPackageSeqId());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setReturnId(state.getReturnId());
        cmd.setReturnItemSeqId(state.getReturnItemSeqId());
        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setDamageStatusId(state.getDamageStatusId());
        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setReceivedBy(state.getReceivedBy());
        cmd.setDatetimeReceived(state.getDatetimeReceived());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setAcceptedQuantity(state.getAcceptedQuantity());
        cmd.setRejectedQuantity(state.getRejectedQuantity());
        cmd.setDamagedQuantity(state.getDamagedQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
            
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getLocatorId() == null) { cmd.setIsPropertyLocatorIdRemoved(true); }
        if (state.getShipmentItemSeqId() == null) { cmd.setIsPropertyShipmentItemSeqIdRemoved(true); }
        if (state.getShipmentPackageSeqId() == null) { cmd.setIsPropertyShipmentPackageSeqIdRemoved(true); }
        if (state.getOrderId() == null) { cmd.setIsPropertyOrderIdRemoved(true); }
        if (state.getOrderItemSeqId() == null) { cmd.setIsPropertyOrderItemSeqIdRemoved(true); }
        if (state.getReturnId() == null) { cmd.setIsPropertyReturnIdRemoved(true); }
        if (state.getReturnItemSeqId() == null) { cmd.setIsPropertyReturnItemSeqIdRemoved(true); }
        if (state.getRejectionReasonId() == null) { cmd.setIsPropertyRejectionReasonIdRemoved(true); }
        if (state.getDamageStatusId() == null) { cmd.setIsPropertyDamageStatusIdRemoved(true); }
        if (state.getDamageReasonId() == null) { cmd.setIsPropertyDamageReasonIdRemoved(true); }
        if (state.getReceivedBy() == null) { cmd.setIsPropertyReceivedByRemoved(true); }
        if (state.getDatetimeReceived() == null) { cmd.setIsPropertyDatetimeReceivedRemoved(true); }
        if (state.getItemDescription() == null) { cmd.setIsPropertyItemDescriptionRemoved(true); }
        if (state.getAcceptedQuantity() == null) { cmd.setIsPropertyAcceptedQuantityRemoved(true); }
        if (state.getRejectedQuantity() == null) { cmd.setIsPropertyRejectedQuantityRemoved(true); }
        if (state.getDamagedQuantity() == null) { cmd.setIsPropertyDamagedQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentReceipt toCreateShipmentReceipt(ShipmentReceiptState state) //where TCreateShipmentReceipt : ICreateShipmentReceipt, new()
    {
        TCreateShipmentReceipt cmd = newCreateShipmentReceipt();

        cmd.setReceiptSeqId(state.getReceiptSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setShipmentPackageSeqId(state.getShipmentPackageSeqId());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setReturnId(state.getReturnId());
        cmd.setReturnItemSeqId(state.getReturnItemSeqId());
        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setDamageStatusId(state.getDamageStatusId());
        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setReceivedBy(state.getReceivedBy());
        cmd.setDatetimeReceived(state.getDatetimeReceived());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setAcceptedQuantity(state.getAcceptedQuantity());
        cmd.setRejectedQuantity(state.getRejectedQuantity());
        cmd.setDamagedQuantity(state.getDamagedQuantity());
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

