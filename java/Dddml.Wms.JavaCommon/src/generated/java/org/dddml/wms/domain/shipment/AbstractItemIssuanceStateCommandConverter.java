package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractItemIssuanceStateCommandConverter<TCreateItemIssuance extends ItemIssuanceCommand.CreateItemIssuance, TMergePatchItemIssuance extends ItemIssuanceCommand.MergePatchItemIssuance, TRemoveItemIssuance extends ItemIssuanceCommand.RemoveItemIssuance>
{
    public ItemIssuanceCommand toCreateOrMergePatchItemIssuance(ItemIssuanceState state)
    {
        //where TCreateItemIssuance : ICreateItemIssuance, new()
        //where TMergePatchItemIssuance : IMergePatchItemIssuance, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateItemIssuance(state);
        }
        else 
        {
            return toMergePatchItemIssuance(state);
        }
    }

    public TRemoveItemIssuance toRemoveItemIssuance(ItemIssuanceState state) //where TRemoveItemIssuance : IRemoveItemIssuance, new()
    {
        TRemoveItemIssuance cmd = newRemoveItemIssuance();
        cmd.setItemIssuanceSeqId(state.getItemIssuanceSeqId());
        return cmd;
    }

    public TMergePatchItemIssuance toMergePatchItemIssuance(ItemIssuanceState state) //where TMergePatchItemIssuance : IMergePatchItemIssuance, new()
    {
        TMergePatchItemIssuance cmd = newMergePatchItemIssuance();

        cmd.setItemIssuanceSeqId(state.getItemIssuanceSeqId());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setFixedAssetId(state.getFixedAssetId());
        cmd.setMaintHistSeqId(state.getMaintHistSeqId());
        cmd.setIssuedDateTime(state.getIssuedDateTime());
        cmd.setIssuedByUserLoginId(state.getIssuedByUserLoginId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
            
        if (state.getOrderId() == null) { cmd.setIsPropertyOrderIdRemoved(true); }
        if (state.getOrderItemSeqId() == null) { cmd.setIsPropertyOrderItemSeqIdRemoved(true); }
        if (state.getShipGroupSeqId() == null) { cmd.setIsPropertyShipGroupSeqIdRemoved(true); }
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getLocatorId() == null) { cmd.setIsPropertyLocatorIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getShipmentItemSeqId() == null) { cmd.setIsPropertyShipmentItemSeqIdRemoved(true); }
        if (state.getFixedAssetId() == null) { cmd.setIsPropertyFixedAssetIdRemoved(true); }
        if (state.getMaintHistSeqId() == null) { cmd.setIsPropertyMaintHistSeqIdRemoved(true); }
        if (state.getIssuedDateTime() == null) { cmd.setIsPropertyIssuedDateTimeRemoved(true); }
        if (state.getIssuedByUserLoginId() == null) { cmd.setIsPropertyIssuedByUserLoginIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getCancelQuantity() == null) { cmd.setIsPropertyCancelQuantityRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateItemIssuance toCreateItemIssuance(ItemIssuanceState state) //where TCreateItemIssuance : ICreateItemIssuance, new()
    {
        TCreateItemIssuance cmd = newCreateItemIssuance();

        cmd.setItemIssuanceSeqId(state.getItemIssuanceSeqId());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setFixedAssetId(state.getFixedAssetId());
        cmd.setMaintHistSeqId(state.getMaintHistSeqId());
        cmd.setIssuedDateTime(state.getIssuedDateTime());
        cmd.setIssuedByUserLoginId(state.getIssuedByUserLoginId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setActive(state.getActive());
        cmd.setShipmentId(state.getShipmentId());
        return cmd;
    }

    protected abstract TCreateItemIssuance newCreateItemIssuance();

    protected abstract TMergePatchItemIssuance newMergePatchItemIssuance(); 

    protected abstract TRemoveItemIssuance newRemoveItemIssuance();

    public static class SimpleItemIssuanceStateCommandConverter extends AbstractItemIssuanceStateCommandConverter<AbstractItemIssuanceCommand.SimpleCreateItemIssuance, AbstractItemIssuanceCommand.SimpleMergePatchItemIssuance, AbstractItemIssuanceCommand.SimpleRemoveItemIssuance>
    {
        @Override
        protected AbstractItemIssuanceCommand.SimpleCreateItemIssuance newCreateItemIssuance() {
            return new AbstractItemIssuanceCommand.SimpleCreateItemIssuance();
        }

        @Override
        protected AbstractItemIssuanceCommand.SimpleMergePatchItemIssuance newMergePatchItemIssuance() {
            return new AbstractItemIssuanceCommand.SimpleMergePatchItemIssuance();
        }

        @Override
        protected AbstractItemIssuanceCommand.SimpleRemoveItemIssuance newRemoveItemIssuance() {
            return new AbstractItemIssuanceCommand.SimpleRemoveItemIssuance();
        }


    }

}

