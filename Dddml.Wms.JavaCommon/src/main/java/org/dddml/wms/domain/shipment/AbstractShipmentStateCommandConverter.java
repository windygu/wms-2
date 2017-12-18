package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentStateCommandConverter<TCreateShipment extends ShipmentCommand.CreateShipment, TMergePatchShipment extends ShipmentCommand.MergePatchShipment, TDeleteShipment extends ShipmentCommand.DeleteShipment, TCreateShipmentItem extends ShipmentItemCommand.CreateShipmentItem, TMergePatchShipmentItem extends ShipmentItemCommand.MergePatchShipmentItem, TRemoveShipmentItem extends ShipmentItemCommand.RemoveShipmentItem>
{
    public ShipmentCommand toCreateOrMergePatchShipment(ShipmentState state)
    {
        //where TCreateShipment : ICreateShipment, new()
        //where TMergePatchShipment : IMergePatchShipment, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipment(state);
        }
        else 
        {
            return toMergePatchShipment(state);
        }
    }

    public TDeleteShipment toDeleteShipment(ShipmentState state) //where TDeleteShipment : IDeleteShipment, new()
    {
        TDeleteShipment cmd = newDeleteShipment();
        cmd.setShipmentId(state.getShipmentId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchShipment toMergePatchShipment(ShipmentState state) //where TMergePatchShipment : IMergePatchShipment, new()
    {
        TMergePatchShipment cmd = newMergePatchShipment();

        cmd.setVersion(state.getVersion());

        cmd.setShipmentId(state.getShipmentId());
        cmd.setShipmentTypeId(state.getShipmentTypeId());
        cmd.setStatusId(state.getStatusId());
        cmd.setPrimaryOrderId(state.getPrimaryOrderId());
        cmd.setPrimaryReturnId(state.getPrimaryReturnId());
        cmd.setPicklistBinId(state.getPicklistBinId());
        cmd.setEstimatedReadyDate(state.getEstimatedReadyDate());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedShipWorkEffId(state.getEstimatedShipWorkEffId());
        cmd.setEstimatedArrivalDate(state.getEstimatedArrivalDate());
        cmd.setEstimatedArrivalWorkEffId(state.getEstimatedArrivalWorkEffId());
        cmd.setLatestCancelDate(state.getLatestCancelDate());
        cmd.setEstimatedShipCost(state.getEstimatedShipCost());
        cmd.setCurrencyUomId(state.getCurrencyUomId());
        cmd.setHandlingInstructions(state.getHandlingInstructions());
        cmd.setOriginFacilityId(state.getOriginFacilityId());
        cmd.setDestinationFacilityId(state.getDestinationFacilityId());
        cmd.setOriginContactMechId(state.getOriginContactMechId());
        cmd.setOriginTelecomNumberId(state.getOriginTelecomNumberId());
        cmd.setDestinationContactMechId(state.getDestinationContactMechId());
        cmd.setDestinationTelecomNumberId(state.getDestinationTelecomNumberId());
        cmd.setPartyIdTo(state.getPartyIdTo());
        cmd.setPartyIdFrom(state.getPartyIdFrom());
        cmd.setAdditionalShippingCharge(state.getAdditionalShippingCharge());
        cmd.setAddtlShippingChargeDesc(state.getAddtlShippingChargeDesc());
        cmd.setActive(state.getActive());
            
        if (state.getShipmentTypeId() == null) { cmd.setIsPropertyShipmentTypeIdRemoved(true); }
        if (state.getStatusId() == null) { cmd.setIsPropertyStatusIdRemoved(true); }
        if (state.getPrimaryOrderId() == null) { cmd.setIsPropertyPrimaryOrderIdRemoved(true); }
        if (state.getPrimaryReturnId() == null) { cmd.setIsPropertyPrimaryReturnIdRemoved(true); }
        if (state.getPicklistBinId() == null) { cmd.setIsPropertyPicklistBinIdRemoved(true); }
        if (state.getEstimatedReadyDate() == null) { cmd.setIsPropertyEstimatedReadyDateRemoved(true); }
        if (state.getEstimatedShipDate() == null) { cmd.setIsPropertyEstimatedShipDateRemoved(true); }
        if (state.getEstimatedShipWorkEffId() == null) { cmd.setIsPropertyEstimatedShipWorkEffIdRemoved(true); }
        if (state.getEstimatedArrivalDate() == null) { cmd.setIsPropertyEstimatedArrivalDateRemoved(true); }
        if (state.getEstimatedArrivalWorkEffId() == null) { cmd.setIsPropertyEstimatedArrivalWorkEffIdRemoved(true); }
        if (state.getLatestCancelDate() == null) { cmd.setIsPropertyLatestCancelDateRemoved(true); }
        if (state.getEstimatedShipCost() == null) { cmd.setIsPropertyEstimatedShipCostRemoved(true); }
        if (state.getCurrencyUomId() == null) { cmd.setIsPropertyCurrencyUomIdRemoved(true); }
        if (state.getHandlingInstructions() == null) { cmd.setIsPropertyHandlingInstructionsRemoved(true); }
        if (state.getOriginFacilityId() == null) { cmd.setIsPropertyOriginFacilityIdRemoved(true); }
        if (state.getDestinationFacilityId() == null) { cmd.setIsPropertyDestinationFacilityIdRemoved(true); }
        if (state.getOriginContactMechId() == null) { cmd.setIsPropertyOriginContactMechIdRemoved(true); }
        if (state.getOriginTelecomNumberId() == null) { cmd.setIsPropertyOriginTelecomNumberIdRemoved(true); }
        if (state.getDestinationContactMechId() == null) { cmd.setIsPropertyDestinationContactMechIdRemoved(true); }
        if (state.getDestinationTelecomNumberId() == null) { cmd.setIsPropertyDestinationTelecomNumberIdRemoved(true); }
        if (state.getPartyIdTo() == null) { cmd.setIsPropertyPartyIdToRemoved(true); }
        if (state.getPartyIdFrom() == null) { cmd.setIsPropertyPartyIdFromRemoved(true); }
        if (state.getAdditionalShippingCharge() == null) { cmd.setIsPropertyAdditionalShippingChargeRemoved(true); }
        if (state.getAddtlShippingChargeDesc() == null) { cmd.setIsPropertyAddtlShippingChargeDescRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (ShipmentItemState d : state.getShipmentItems())
        {
            ShipmentItemCommand c = getShipmentItemStateCommandConverter().toCreateOrMergePatchShipmentItem(d);
            cmd.getShipmentItemCommands().add(c);
        }
        return cmd;
    }

    public TCreateShipment toCreateShipment(ShipmentState state) //where TCreateShipment : ICreateShipment, new()
    {
        TCreateShipment cmd = newCreateShipment();

        cmd.setVersion(state.getVersion());
        cmd.setShipmentId(state.getShipmentId());
        cmd.setShipmentTypeId(state.getShipmentTypeId());
        cmd.setStatusId(state.getStatusId());
        cmd.setPrimaryOrderId(state.getPrimaryOrderId());
        cmd.setPrimaryReturnId(state.getPrimaryReturnId());
        cmd.setPicklistBinId(state.getPicklistBinId());
        cmd.setEstimatedReadyDate(state.getEstimatedReadyDate());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedShipWorkEffId(state.getEstimatedShipWorkEffId());
        cmd.setEstimatedArrivalDate(state.getEstimatedArrivalDate());
        cmd.setEstimatedArrivalWorkEffId(state.getEstimatedArrivalWorkEffId());
        cmd.setLatestCancelDate(state.getLatestCancelDate());
        cmd.setEstimatedShipCost(state.getEstimatedShipCost());
        cmd.setCurrencyUomId(state.getCurrencyUomId());
        cmd.setHandlingInstructions(state.getHandlingInstructions());
        cmd.setOriginFacilityId(state.getOriginFacilityId());
        cmd.setDestinationFacilityId(state.getDestinationFacilityId());
        cmd.setOriginContactMechId(state.getOriginContactMechId());
        cmd.setOriginTelecomNumberId(state.getOriginTelecomNumberId());
        cmd.setDestinationContactMechId(state.getDestinationContactMechId());
        cmd.setDestinationTelecomNumberId(state.getDestinationTelecomNumberId());
        cmd.setPartyIdTo(state.getPartyIdTo());
        cmd.setPartyIdFrom(state.getPartyIdFrom());
        cmd.setAdditionalShippingCharge(state.getAdditionalShippingCharge());
        cmd.setAddtlShippingChargeDesc(state.getAddtlShippingChargeDesc());
        cmd.setActive(state.getActive());
        for (ShipmentItemState d : state.getShipmentItems())
        {
            ShipmentItemCommand.CreateShipmentItem c = getShipmentItemStateCommandConverter().toCreateShipmentItem(d);
            cmd.getShipmentItems().add(c);
        }
        return cmd;
    }

    protected abstract AbstractShipmentItemStateCommandConverter<TCreateShipmentItem, TMergePatchShipmentItem, TRemoveShipmentItem>
        getShipmentItemStateCommandConverter();

    protected abstract TCreateShipment newCreateShipment();

    protected abstract TMergePatchShipment newMergePatchShipment(); 

    protected abstract TDeleteShipment newDeleteShipment();

    public static class SimpleShipmentStateCommandConverter extends AbstractShipmentStateCommandConverter<AbstractShipmentCommand.SimpleCreateShipment, AbstractShipmentCommand.SimpleMergePatchShipment, AbstractShipmentCommand.SimpleDeleteShipment, AbstractShipmentItemCommand.SimpleCreateShipmentItem, AbstractShipmentItemCommand.SimpleMergePatchShipmentItem, AbstractShipmentItemCommand.SimpleRemoveShipmentItem>
    {
        @Override
        protected AbstractShipmentCommand.SimpleCreateShipment newCreateShipment() {
            return new AbstractShipmentCommand.SimpleCreateShipment();
        }

        @Override
        protected AbstractShipmentCommand.SimpleMergePatchShipment newMergePatchShipment() {
            return new AbstractShipmentCommand.SimpleMergePatchShipment();
        }

        @Override
        protected AbstractShipmentCommand.SimpleDeleteShipment newDeleteShipment() {
            return new AbstractShipmentCommand.SimpleDeleteShipment();
        }

        @Override
        protected AbstractShipmentItemStateCommandConverter<AbstractShipmentItemCommand.SimpleCreateShipmentItem, AbstractShipmentItemCommand.SimpleMergePatchShipmentItem, AbstractShipmentItemCommand.SimpleRemoveShipmentItem> getShipmentItemStateCommandConverter()
        {
            return new AbstractShipmentItemStateCommandConverter.SimpleShipmentItemStateCommandConverter();
        }


    }

}

