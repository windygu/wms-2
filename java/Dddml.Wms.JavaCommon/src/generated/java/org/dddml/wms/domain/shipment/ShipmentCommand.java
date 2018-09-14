package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentCommand extends Command
{
    String getShipmentId();

    void setShipmentId(String shipmentId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ShipmentState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ShipmentCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((ShipmentCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ShipmentCommand c) {
        return ((c instanceof ShipmentCommand.CreateShipment) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(ShipmentState.VERSION_NULL)));
    }

    interface CreateOrMergePatchShipment extends ShipmentCommand
    {
        String getShipmentTypeId();

        void setShipmentTypeId(String shipmentTypeId);

        String getPrimaryOrderId();

        void setPrimaryOrderId(String primaryOrderId);

        String getPrimaryReturnId();

        void setPrimaryReturnId(String primaryReturnId);

        String getPrimaryShipGroupSeqId();

        void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId);

        Boolean getOnlyOneOrder();

        void setOnlyOneOrder(Boolean onlyOneOrder);

        String getPicklistBinId();

        void setPicklistBinId(String picklistBinId);

        String getBolNumber();

        void setBolNumber(String bolNumber);

        String getSealNumber();

        void setSealNumber(String sealNumber);

        String getVehicleId();

        void setVehicleId(String vehicleId);

        String getExternalOrderNumber();

        void setExternalOrderNumber(String externalOrderNumber);

        String getCarrier();

        void setCarrier(String carrier);

        java.sql.Timestamp getDateShipped();

        void setDateShipped(java.sql.Timestamp dateShipped);

        java.sql.Timestamp getEstimatedReadyDate();

        void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate);

        java.sql.Timestamp getEstimatedShipDate();

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        String getEstimatedShipWorkEffId();

        void setEstimatedShipWorkEffId(String estimatedShipWorkEffId);

        java.sql.Timestamp getEstimatedArrivalDate();

        void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate);

        String getEstimatedArrivalWorkEffId();

        void setEstimatedArrivalWorkEffId(String estimatedArrivalWorkEffId);

        java.sql.Timestamp getLatestCancelDate();

        void setLatestCancelDate(java.sql.Timestamp latestCancelDate);

        java.math.BigDecimal getEstimatedShipCost();

        void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost);

        String getCurrencyUomId();

        void setCurrencyUomId(String currencyUomId);

        String getHandlingInstructions();

        void setHandlingInstructions(String handlingInstructions);

        String getOriginFacilityId();

        void setOriginFacilityId(String originFacilityId);

        String getDestinationFacilityId();

        void setDestinationFacilityId(String destinationFacilityId);

        String getOriginContactMechId();

        void setOriginContactMechId(String originContactMechId);

        String getOriginTelecomNumberId();

        void setOriginTelecomNumberId(String originTelecomNumberId);

        String getDestinationContactMechId();

        void setDestinationContactMechId(String destinationContactMechId);

        String getDestinationTelecomNumberId();

        void setDestinationTelecomNumberId(String destinationTelecomNumberId);

        String getPartyIdTo();

        void setPartyIdTo(String partyIdTo);

        String getPartyIdFrom();

        void setPartyIdFrom(String partyIdFrom);

        java.math.BigDecimal getAdditionalShippingCharge();

        void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge);

        String getAddtlShippingChargeDesc();

        void setAddtlShippingChargeDesc(String addtlShippingChargeDesc);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipment extends CreateOrMergePatchShipment
    {
        CreateShipmentImageCommands getShipmentImages();

        ShipmentImageCommand.CreateShipmentImage newCreateShipmentImage();

        CreateShipmentItemCommands getShipmentItems();

        ShipmentItemCommand.CreateShipmentItem newCreateShipmentItem();

        CreateShipmentReceiptCommands getShipmentReceipts();

        ShipmentReceiptCommand.CreateShipmentReceipt newCreateShipmentReceipt();

        CreateItemIssuanceCommands getItemIssuances();

        ItemIssuanceCommand.CreateItemIssuance newCreateItemIssuance();

    }

    interface MergePatchShipment extends CreateOrMergePatchShipment
    {
        Boolean getIsPropertyShipmentTypeIdRemoved();

        void setIsPropertyShipmentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryOrderIdRemoved();

        void setIsPropertyPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryReturnIdRemoved();

        void setIsPropertyPrimaryReturnIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyOnlyOneOrderRemoved();

        void setIsPropertyOnlyOneOrderRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinIdRemoved();

        void setIsPropertyPicklistBinIdRemoved(Boolean removed);

        Boolean getIsPropertyBolNumberRemoved();

        void setIsPropertyBolNumberRemoved(Boolean removed);

        Boolean getIsPropertySealNumberRemoved();

        void setIsPropertySealNumberRemoved(Boolean removed);

        Boolean getIsPropertyVehicleIdRemoved();

        void setIsPropertyVehicleIdRemoved(Boolean removed);

        Boolean getIsPropertyExternalOrderNumberRemoved();

        void setIsPropertyExternalOrderNumberRemoved(Boolean removed);

        Boolean getIsPropertyCarrierRemoved();

        void setIsPropertyCarrierRemoved(Boolean removed);

        Boolean getIsPropertyDateShippedRemoved();

        void setIsPropertyDateShippedRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedReadyDateRemoved();

        void setIsPropertyEstimatedReadyDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipDateRemoved();

        void setIsPropertyEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipWorkEffIdRemoved();

        void setIsPropertyEstimatedShipWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedArrivalDateRemoved();

        void setIsPropertyEstimatedArrivalDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedArrivalWorkEffIdRemoved();

        void setIsPropertyEstimatedArrivalWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyLatestCancelDateRemoved();

        void setIsPropertyLatestCancelDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipCostRemoved();

        void setIsPropertyEstimatedShipCostRemoved(Boolean removed);

        Boolean getIsPropertyCurrencyUomIdRemoved();

        void setIsPropertyCurrencyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyHandlingInstructionsRemoved();

        void setIsPropertyHandlingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyOriginFacilityIdRemoved();

        void setIsPropertyOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyDestinationFacilityIdRemoved();

        void setIsPropertyDestinationFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOriginContactMechIdRemoved();

        void setIsPropertyOriginContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyOriginTelecomNumberIdRemoved();

        void setIsPropertyOriginTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyDestinationContactMechIdRemoved();

        void setIsPropertyDestinationContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyDestinationTelecomNumberIdRemoved();

        void setIsPropertyDestinationTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyPartyIdToRemoved();

        void setIsPropertyPartyIdToRemoved(Boolean removed);

        Boolean getIsPropertyPartyIdFromRemoved();

        void setIsPropertyPartyIdFromRemoved(Boolean removed);

        Boolean getIsPropertyAdditionalShippingChargeRemoved();

        void setIsPropertyAdditionalShippingChargeRemoved(Boolean removed);

        Boolean getIsPropertyAddtlShippingChargeDescRemoved();

        void setIsPropertyAddtlShippingChargeDescRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        ShipmentImageCommands getShipmentImageCommands();

        ShipmentImageCommand.CreateShipmentImage newCreateShipmentImage();

        ShipmentImageCommand.MergePatchShipmentImage newMergePatchShipmentImage();

        ShipmentImageCommand.RemoveShipmentImage newRemoveShipmentImage();

        ShipmentItemCommands getShipmentItemCommands();

        ShipmentItemCommand.CreateShipmentItem newCreateShipmentItem();

        ShipmentItemCommand.MergePatchShipmentItem newMergePatchShipmentItem();

        ShipmentItemCommand.RemoveShipmentItem newRemoveShipmentItem();

        ShipmentReceiptCommands getShipmentReceiptCommands();

        ShipmentReceiptCommand.CreateShipmentReceipt newCreateShipmentReceipt();

        ShipmentReceiptCommand.MergePatchShipmentReceipt newMergePatchShipmentReceipt();

        ShipmentReceiptCommand.RemoveShipmentReceipt newRemoveShipmentReceipt();

        ItemIssuanceCommands getItemIssuanceCommands();

        ItemIssuanceCommand.CreateItemIssuance newCreateItemIssuance();

        ItemIssuanceCommand.MergePatchItemIssuance newMergePatchItemIssuance();

        ItemIssuanceCommand.RemoveItemIssuance newRemoveItemIssuance();

    }

	interface DeleteShipment extends ShipmentCommand
	{

        String getShipmentTypeId();

        void setShipmentTypeId(String shipmentTypeId);
	}

    interface CreateShipmentImageCommands extends Iterable<ShipmentImageCommand.CreateShipmentImage>
    {
        void add(ShipmentImageCommand.CreateShipmentImage c);

        void remove(ShipmentImageCommand.CreateShipmentImage c);

        void clear();
    }

    interface ShipmentImageCommands extends Iterable<ShipmentImageCommand>
    {
        void add(ShipmentImageCommand c);

        void remove(ShipmentImageCommand c);

        void clear();
    }

    interface CreateShipmentItemCommands extends Iterable<ShipmentItemCommand.CreateShipmentItem>
    {
        void add(ShipmentItemCommand.CreateShipmentItem c);

        void remove(ShipmentItemCommand.CreateShipmentItem c);

        void clear();
    }

    interface ShipmentItemCommands extends Iterable<ShipmentItemCommand>
    {
        void add(ShipmentItemCommand c);

        void remove(ShipmentItemCommand c);

        void clear();
    }

    interface CreateShipmentReceiptCommands extends Iterable<ShipmentReceiptCommand.CreateShipmentReceipt>
    {
        void add(ShipmentReceiptCommand.CreateShipmentReceipt c);

        void remove(ShipmentReceiptCommand.CreateShipmentReceipt c);

        void clear();
    }

    interface ShipmentReceiptCommands extends Iterable<ShipmentReceiptCommand>
    {
        void add(ShipmentReceiptCommand c);

        void remove(ShipmentReceiptCommand c);

        void clear();
    }

    interface CreateItemIssuanceCommands extends Iterable<ItemIssuanceCommand.CreateItemIssuance>
    {
        void add(ItemIssuanceCommand.CreateItemIssuance c);

        void remove(ItemIssuanceCommand.CreateItemIssuance c);

        void clear();
    }

    interface ItemIssuanceCommands extends Iterable<ItemIssuanceCommand>
    {
        void add(ItemIssuanceCommand c);

        void remove(ItemIssuanceCommand c);

        void clear();
    }

}

