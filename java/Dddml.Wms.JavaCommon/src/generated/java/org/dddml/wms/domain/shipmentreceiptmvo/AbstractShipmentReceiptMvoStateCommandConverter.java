package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentReceiptMvoStateCommandConverter<TCreateShipmentReceiptMvo extends ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo, TMergePatchShipmentReceiptMvo extends ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo, TDeleteShipmentReceiptMvo extends ShipmentReceiptMvoCommand.DeleteShipmentReceiptMvo>
{
    public ShipmentReceiptMvoCommand toCreateOrMergePatchShipmentReceiptMvo(ShipmentReceiptMvoState state)
    {
        //where TCreateShipmentReceiptMvo : ICreateShipmentReceiptMvo, new()
        //where TMergePatchShipmentReceiptMvo : IMergePatchShipmentReceiptMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentReceiptMvo(state);
        }
        else 
        {
            return toMergePatchShipmentReceiptMvo(state);
        }
    }

    public TDeleteShipmentReceiptMvo toDeleteShipmentReceiptMvo(ShipmentReceiptMvoState state) //where TDeleteShipmentReceiptMvo : IDeleteShipmentReceiptMvo, new()
    {
        TDeleteShipmentReceiptMvo cmd = newDeleteShipmentReceiptMvo();
        cmd.setShipmentReceiptId(state.getShipmentReceiptId());
        cmd.setShipmentVersion(state.getShipmentVersion());

        return cmd;
    }

    public TMergePatchShipmentReceiptMvo toMergePatchShipmentReceiptMvo(ShipmentReceiptMvoState state) //where TMergePatchShipmentReceiptMvo : IMergePatchShipmentReceiptMvo, new()
    {
        TMergePatchShipmentReceiptMvo cmd = newMergePatchShipmentReceiptMvo();

        cmd.setShipmentVersion(state.getShipmentVersion());

        cmd.setShipmentReceiptId(state.getShipmentReceiptId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setDamageStatusId(state.getDamageStatusId());
        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setReceivedBy(state.getReceivedBy());
        cmd.setDatetimeReceived(state.getDatetimeReceived());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setAcceptedQuantity(state.getAcceptedQuantity());
        cmd.setRejectedQuantity(state.getRejectedQuantity());
        cmd.setDamagedQuantity(state.getDamagedQuantity());
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
        if (state.getShipmentItemSeqId() == null) { cmd.setIsPropertyShipmentItemSeqIdRemoved(true); }
        if (state.getRejectionReasonId() == null) { cmd.setIsPropertyRejectionReasonIdRemoved(true); }
        if (state.getDamageStatusId() == null) { cmd.setIsPropertyDamageStatusIdRemoved(true); }
        if (state.getDamageReasonId() == null) { cmd.setIsPropertyDamageReasonIdRemoved(true); }
        if (state.getReceivedBy() == null) { cmd.setIsPropertyReceivedByRemoved(true); }
        if (state.getDatetimeReceived() == null) { cmd.setIsPropertyDatetimeReceivedRemoved(true); }
        if (state.getItemDescription() == null) { cmd.setIsPropertyItemDescriptionRemoved(true); }
        if (state.getAcceptedQuantity() == null) { cmd.setIsPropertyAcceptedQuantityRemoved(true); }
        if (state.getRejectedQuantity() == null) { cmd.setIsPropertyRejectedQuantityRemoved(true); }
        if (state.getDamagedQuantity() == null) { cmd.setIsPropertyDamagedQuantityRemoved(true); }
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

    public TCreateShipmentReceiptMvo toCreateShipmentReceiptMvo(ShipmentReceiptMvoState state) //where TCreateShipmentReceiptMvo : ICreateShipmentReceiptMvo, new()
    {
        TCreateShipmentReceiptMvo cmd = newCreateShipmentReceiptMvo();

        cmd.setShipmentVersion(state.getShipmentVersion());
        cmd.setShipmentReceiptId(state.getShipmentReceiptId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setRejectionReasonId(state.getRejectionReasonId());
        cmd.setDamageStatusId(state.getDamageStatusId());
        cmd.setDamageReasonId(state.getDamageReasonId());
        cmd.setReceivedBy(state.getReceivedBy());
        cmd.setDatetimeReceived(state.getDatetimeReceived());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setAcceptedQuantity(state.getAcceptedQuantity());
        cmd.setRejectedQuantity(state.getRejectedQuantity());
        cmd.setDamagedQuantity(state.getDamagedQuantity());
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

    protected abstract TCreateShipmentReceiptMvo newCreateShipmentReceiptMvo();

    protected abstract TMergePatchShipmentReceiptMvo newMergePatchShipmentReceiptMvo(); 

    protected abstract TDeleteShipmentReceiptMvo newDeleteShipmentReceiptMvo();

    public static class SimpleShipmentReceiptMvoStateCommandConverter extends AbstractShipmentReceiptMvoStateCommandConverter<AbstractShipmentReceiptMvoCommand.SimpleCreateShipmentReceiptMvo, AbstractShipmentReceiptMvoCommand.SimpleMergePatchShipmentReceiptMvo, AbstractShipmentReceiptMvoCommand.SimpleDeleteShipmentReceiptMvo>
    {
        @Override
        protected AbstractShipmentReceiptMvoCommand.SimpleCreateShipmentReceiptMvo newCreateShipmentReceiptMvo() {
            return new AbstractShipmentReceiptMvoCommand.SimpleCreateShipmentReceiptMvo();
        }

        @Override
        protected AbstractShipmentReceiptMvoCommand.SimpleMergePatchShipmentReceiptMvo newMergePatchShipmentReceiptMvo() {
            return new AbstractShipmentReceiptMvoCommand.SimpleMergePatchShipmentReceiptMvo();
        }

        @Override
        protected AbstractShipmentReceiptMvoCommand.SimpleDeleteShipmentReceiptMvo newDeleteShipmentReceiptMvo() {
            return new AbstractShipmentReceiptMvoCommand.SimpleDeleteShipmentReceiptMvo();
        }


    }

}

