package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentItemMvoStateCommandConverter<TCreateShipmentItemMvo extends ShipmentItemMvoCommand.CreateShipmentItemMvo, TMergePatchShipmentItemMvo extends ShipmentItemMvoCommand.MergePatchShipmentItemMvo, TDeleteShipmentItemMvo extends ShipmentItemMvoCommand.DeleteShipmentItemMvo>
{
    public ShipmentItemMvoCommand toCreateOrMergePatchShipmentItemMvo(ShipmentItemMvoState state)
    {
        //where TCreateShipmentItemMvo : ICreateShipmentItemMvo, new()
        //where TMergePatchShipmentItemMvo : IMergePatchShipmentItemMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentItemMvo(state);
        }
        else 
        {
            return toMergePatchShipmentItemMvo(state);
        }
    }

    public TDeleteShipmentItemMvo toDeleteShipmentItemMvo(ShipmentItemMvoState state) //where TDeleteShipmentItemMvo : IDeleteShipmentItemMvo, new()
    {
        TDeleteShipmentItemMvo cmd = newDeleteShipmentItemMvo();
        cmd.setShipmentItemId(state.getShipmentItemId());
        cmd.setShipmentVersion(state.getShipmentVersion());

        return cmd;
    }

    public TMergePatchShipmentItemMvo toMergePatchShipmentItemMvo(ShipmentItemMvoState state) //where TMergePatchShipmentItemMvo : IMergePatchShipmentItemMvo, new()
    {
        TMergePatchShipmentItemMvo cmd = newMergePatchShipmentItemMvo();

        cmd.setShipmentVersion(state.getShipmentVersion());

        cmd.setShipmentItemId(state.getShipmentItemId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setQuantity(state.getQuantity());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setShipmentContentDescription(state.getShipmentContentDescription());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setShipmentShipmentTypeId(state.getShipmentShipmentTypeId());
        cmd.setShipmentStatusId(state.getShipmentStatusId());
        cmd.setShipmentPrimaryOrderId(state.getShipmentPrimaryOrderId());
        cmd.setShipmentPrimaryReturnId(state.getShipmentPrimaryReturnId());
        cmd.setShipmentPicklistBinId(state.getShipmentPicklistBinId());
        cmd.setShipmentEstimatedReadyDate(state.getShipmentEstimatedReadyDate());
        cmd.setShipmentEstimatedShipDate(state.getShipmentEstimatedShipDate());
        cmd.setShipmentEstimatedShipWorkEffId(state.getShipmentEstimatedShipWorkEffId());
        cmd.setShipmentEstimatedArrivalDate(state.getShipmentEstimatedArrivalDate());
        cmd.setShipmentEstimatedArrivalWorkEffId(state.getShipmentEstimatedArrivalWorkEffId());
        cmd.setShipmentLatestCancelDate(state.getShipmentLatestCancelDate());
        cmd.setShipmentEstimatedShipCost(state.getShipmentEstimatedShipCost());
        cmd.setShipmentCurrencyUomId(state.getShipmentCurrencyUomId());
        cmd.setShipmentHandlingInstructions(state.getShipmentHandlingInstructions());
        cmd.setShipmentOriginFacilityId(state.getShipmentOriginFacilityId());
        cmd.setShipmentDestinationFacilityId(state.getShipmentDestinationFacilityId());
        cmd.setShipmentOriginContactMechId(state.getShipmentOriginContactMechId());
        cmd.setShipmentOriginTelecomNumberId(state.getShipmentOriginTelecomNumberId());
        cmd.setShipmentDestinationContactMechId(state.getShipmentDestinationContactMechId());
        cmd.setShipmentDestinationTelecomNumberId(state.getShipmentDestinationTelecomNumberId());
        cmd.setShipmentPartyIdTo(state.getShipmentPartyIdTo());
        cmd.setShipmentPartyIdFrom(state.getShipmentPartyIdFrom());
        cmd.setShipmentAdditionalShippingCharge(state.getShipmentAdditionalShippingCharge());
        cmd.setShipmentAddtlShippingChargeDesc(state.getShipmentAddtlShippingChargeDesc());
        cmd.setShipmentShipperId(state.getShipmentShipperId());
        cmd.setShipmentCreatedBy(state.getShipmentCreatedBy());
        cmd.setShipmentCreatedAt(state.getShipmentCreatedAt());
        cmd.setShipmentUpdatedBy(state.getShipmentUpdatedBy());
        cmd.setShipmentUpdatedAt(state.getShipmentUpdatedAt());
        cmd.setShipmentActive(state.getShipmentActive());
            
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getTargetQuantity() == null) { cmd.setIsPropertyTargetQuantityRemoved(true); }
        if (state.getShipmentContentDescription() == null) { cmd.setIsPropertyShipmentContentDescriptionRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getShipmentShipmentTypeId() == null) { cmd.setIsPropertyShipmentShipmentTypeIdRemoved(true); }
        if (state.getShipmentStatusId() == null) { cmd.setIsPropertyShipmentStatusIdRemoved(true); }
        if (state.getShipmentPrimaryOrderId() == null) { cmd.setIsPropertyShipmentPrimaryOrderIdRemoved(true); }
        if (state.getShipmentPrimaryReturnId() == null) { cmd.setIsPropertyShipmentPrimaryReturnIdRemoved(true); }
        if (state.getShipmentPicklistBinId() == null) { cmd.setIsPropertyShipmentPicklistBinIdRemoved(true); }
        if (state.getShipmentEstimatedReadyDate() == null) { cmd.setIsPropertyShipmentEstimatedReadyDateRemoved(true); }
        if (state.getShipmentEstimatedShipDate() == null) { cmd.setIsPropertyShipmentEstimatedShipDateRemoved(true); }
        if (state.getShipmentEstimatedShipWorkEffId() == null) { cmd.setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(true); }
        if (state.getShipmentEstimatedArrivalDate() == null) { cmd.setIsPropertyShipmentEstimatedArrivalDateRemoved(true); }
        if (state.getShipmentEstimatedArrivalWorkEffId() == null) { cmd.setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(true); }
        if (state.getShipmentLatestCancelDate() == null) { cmd.setIsPropertyShipmentLatestCancelDateRemoved(true); }
        if (state.getShipmentEstimatedShipCost() == null) { cmd.setIsPropertyShipmentEstimatedShipCostRemoved(true); }
        if (state.getShipmentCurrencyUomId() == null) { cmd.setIsPropertyShipmentCurrencyUomIdRemoved(true); }
        if (state.getShipmentHandlingInstructions() == null) { cmd.setIsPropertyShipmentHandlingInstructionsRemoved(true); }
        if (state.getShipmentOriginFacilityId() == null) { cmd.setIsPropertyShipmentOriginFacilityIdRemoved(true); }
        if (state.getShipmentDestinationFacilityId() == null) { cmd.setIsPropertyShipmentDestinationFacilityIdRemoved(true); }
        if (state.getShipmentOriginContactMechId() == null) { cmd.setIsPropertyShipmentOriginContactMechIdRemoved(true); }
        if (state.getShipmentOriginTelecomNumberId() == null) { cmd.setIsPropertyShipmentOriginTelecomNumberIdRemoved(true); }
        if (state.getShipmentDestinationContactMechId() == null) { cmd.setIsPropertyShipmentDestinationContactMechIdRemoved(true); }
        if (state.getShipmentDestinationTelecomNumberId() == null) { cmd.setIsPropertyShipmentDestinationTelecomNumberIdRemoved(true); }
        if (state.getShipmentPartyIdTo() == null) { cmd.setIsPropertyShipmentPartyIdToRemoved(true); }
        if (state.getShipmentPartyIdFrom() == null) { cmd.setIsPropertyShipmentPartyIdFromRemoved(true); }
        if (state.getShipmentAdditionalShippingCharge() == null) { cmd.setIsPropertyShipmentAdditionalShippingChargeRemoved(true); }
        if (state.getShipmentAddtlShippingChargeDesc() == null) { cmd.setIsPropertyShipmentAddtlShippingChargeDescRemoved(true); }
        if (state.getShipmentShipperId() == null) { cmd.setIsPropertyShipmentShipperIdRemoved(true); }
        if (state.getShipmentCreatedBy() == null) { cmd.setIsPropertyShipmentCreatedByRemoved(true); }
        if (state.getShipmentCreatedAt() == null) { cmd.setIsPropertyShipmentCreatedAtRemoved(true); }
        if (state.getShipmentUpdatedBy() == null) { cmd.setIsPropertyShipmentUpdatedByRemoved(true); }
        if (state.getShipmentUpdatedAt() == null) { cmd.setIsPropertyShipmentUpdatedAtRemoved(true); }
        if (state.getShipmentActive() == null) { cmd.setIsPropertyShipmentActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentItemMvo toCreateShipmentItemMvo(ShipmentItemMvoState state) //where TCreateShipmentItemMvo : ICreateShipmentItemMvo, new()
    {
        TCreateShipmentItemMvo cmd = newCreateShipmentItemMvo();

        cmd.setShipmentVersion(state.getShipmentVersion());
        cmd.setShipmentItemId(state.getShipmentItemId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setQuantity(state.getQuantity());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setShipmentContentDescription(state.getShipmentContentDescription());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setShipmentShipmentTypeId(state.getShipmentShipmentTypeId());
        cmd.setShipmentStatusId(state.getShipmentStatusId());
        cmd.setShipmentPrimaryOrderId(state.getShipmentPrimaryOrderId());
        cmd.setShipmentPrimaryReturnId(state.getShipmentPrimaryReturnId());
        cmd.setShipmentPicklistBinId(state.getShipmentPicklistBinId());
        cmd.setShipmentEstimatedReadyDate(state.getShipmentEstimatedReadyDate());
        cmd.setShipmentEstimatedShipDate(state.getShipmentEstimatedShipDate());
        cmd.setShipmentEstimatedShipWorkEffId(state.getShipmentEstimatedShipWorkEffId());
        cmd.setShipmentEstimatedArrivalDate(state.getShipmentEstimatedArrivalDate());
        cmd.setShipmentEstimatedArrivalWorkEffId(state.getShipmentEstimatedArrivalWorkEffId());
        cmd.setShipmentLatestCancelDate(state.getShipmentLatestCancelDate());
        cmd.setShipmentEstimatedShipCost(state.getShipmentEstimatedShipCost());
        cmd.setShipmentCurrencyUomId(state.getShipmentCurrencyUomId());
        cmd.setShipmentHandlingInstructions(state.getShipmentHandlingInstructions());
        cmd.setShipmentOriginFacilityId(state.getShipmentOriginFacilityId());
        cmd.setShipmentDestinationFacilityId(state.getShipmentDestinationFacilityId());
        cmd.setShipmentOriginContactMechId(state.getShipmentOriginContactMechId());
        cmd.setShipmentOriginTelecomNumberId(state.getShipmentOriginTelecomNumberId());
        cmd.setShipmentDestinationContactMechId(state.getShipmentDestinationContactMechId());
        cmd.setShipmentDestinationTelecomNumberId(state.getShipmentDestinationTelecomNumberId());
        cmd.setShipmentPartyIdTo(state.getShipmentPartyIdTo());
        cmd.setShipmentPartyIdFrom(state.getShipmentPartyIdFrom());
        cmd.setShipmentAdditionalShippingCharge(state.getShipmentAdditionalShippingCharge());
        cmd.setShipmentAddtlShippingChargeDesc(state.getShipmentAddtlShippingChargeDesc());
        cmd.setShipmentShipperId(state.getShipmentShipperId());
        cmd.setShipmentCreatedBy(state.getShipmentCreatedBy());
        cmd.setShipmentCreatedAt(state.getShipmentCreatedAt());
        cmd.setShipmentUpdatedBy(state.getShipmentUpdatedBy());
        cmd.setShipmentUpdatedAt(state.getShipmentUpdatedAt());
        cmd.setShipmentActive(state.getShipmentActive());
        return cmd;
    }

    protected abstract TCreateShipmentItemMvo newCreateShipmentItemMvo();

    protected abstract TMergePatchShipmentItemMvo newMergePatchShipmentItemMvo(); 

    protected abstract TDeleteShipmentItemMvo newDeleteShipmentItemMvo();

    public static class SimpleShipmentItemMvoStateCommandConverter extends AbstractShipmentItemMvoStateCommandConverter<AbstractShipmentItemMvoCommand.SimpleCreateShipmentItemMvo, AbstractShipmentItemMvoCommand.SimpleMergePatchShipmentItemMvo, AbstractShipmentItemMvoCommand.SimpleDeleteShipmentItemMvo>
    {
        @Override
        protected AbstractShipmentItemMvoCommand.SimpleCreateShipmentItemMvo newCreateShipmentItemMvo() {
            return new AbstractShipmentItemMvoCommand.SimpleCreateShipmentItemMvo();
        }

        @Override
        protected AbstractShipmentItemMvoCommand.SimpleMergePatchShipmentItemMvo newMergePatchShipmentItemMvo() {
            return new AbstractShipmentItemMvoCommand.SimpleMergePatchShipmentItemMvo();
        }

        @Override
        protected AbstractShipmentItemMvoCommand.SimpleDeleteShipmentItemMvo newDeleteShipmentItemMvo() {
            return new AbstractShipmentItemMvoCommand.SimpleDeleteShipmentItemMvo();
        }


    }

}

