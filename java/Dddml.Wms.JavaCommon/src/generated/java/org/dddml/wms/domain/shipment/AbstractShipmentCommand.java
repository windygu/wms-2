package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentCommand extends AbstractCommand implements ShipmentCommand
{
    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchShipment extends AbstractShipmentCommand implements CreateOrMergePatchShipment
    {
        private String shipmentTypeId;

        public String getShipmentTypeId()
        {
            return this.shipmentTypeId;
        }

        public void setShipmentTypeId(String shipmentTypeId)
        {
            this.shipmentTypeId = shipmentTypeId;
        }

        private String primaryOrderId;

        public String getPrimaryOrderId()
        {
            return this.primaryOrderId;
        }

        public void setPrimaryOrderId(String primaryOrderId)
        {
            this.primaryOrderId = primaryOrderId;
        }

        private String primaryReturnId;

        public String getPrimaryReturnId()
        {
            return this.primaryReturnId;
        }

        public void setPrimaryReturnId(String primaryReturnId)
        {
            this.primaryReturnId = primaryReturnId;
        }

        private String primaryShipGroupSeqId;

        public String getPrimaryShipGroupSeqId()
        {
            return this.primaryShipGroupSeqId;
        }

        public void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId)
        {
            this.primaryShipGroupSeqId = primaryShipGroupSeqId;
        }

        private Boolean onlyOneOrder;

        public Boolean getOnlyOneOrder()
        {
            return this.onlyOneOrder;
        }

        public void setOnlyOneOrder(Boolean onlyOneOrder)
        {
            this.onlyOneOrder = onlyOneOrder;
        }

        private Boolean onlyOneOrderShipGroup;

        public Boolean getOnlyOneOrderShipGroup()
        {
            return this.onlyOneOrderShipGroup;
        }

        public void setOnlyOneOrderShipGroup(Boolean onlyOneOrderShipGroup)
        {
            this.onlyOneOrderShipGroup = onlyOneOrderShipGroup;
        }

        private String picklistBinId;

        public String getPicklistBinId()
        {
            return this.picklistBinId;
        }

        public void setPicklistBinId(String picklistBinId)
        {
            this.picklistBinId = picklistBinId;
        }

        private String bolNumber;

        public String getBolNumber()
        {
            return this.bolNumber;
        }

        public void setBolNumber(String bolNumber)
        {
            this.bolNumber = bolNumber;
        }

        private String sealNumber;

        public String getSealNumber()
        {
            return this.sealNumber;
        }

        public void setSealNumber(String sealNumber)
        {
            this.sealNumber = sealNumber;
        }

        private String vehicleId;

        public String getVehicleId()
        {
            return this.vehicleId;
        }

        public void setVehicleId(String vehicleId)
        {
            this.vehicleId = vehicleId;
        }

        private String externalOrderNumber;

        public String getExternalOrderNumber()
        {
            return this.externalOrderNumber;
        }

        public void setExternalOrderNumber(String externalOrderNumber)
        {
            this.externalOrderNumber = externalOrderNumber;
        }

        private String carrier;

        public String getCarrier()
        {
            return this.carrier;
        }

        public void setCarrier(String carrier)
        {
            this.carrier = carrier;
        }

        private java.sql.Timestamp dateShipped;

        public java.sql.Timestamp getDateShipped()
        {
            return this.dateShipped;
        }

        public void setDateShipped(java.sql.Timestamp dateShipped)
        {
            this.dateShipped = dateShipped;
        }

        private Boolean isCreatedFromPackingList;

        public Boolean getIsCreatedFromPackingList()
        {
            return this.isCreatedFromPackingList;
        }

        public void setIsCreatedFromPackingList(Boolean isCreatedFromPackingList)
        {
            this.isCreatedFromPackingList = isCreatedFromPackingList;
        }

        private Boolean isScheduleNeeded;

        public Boolean getIsScheduleNeeded()
        {
            return this.isScheduleNeeded;
        }

        public void setIsScheduleNeeded(Boolean isScheduleNeeded)
        {
            this.isScheduleNeeded = isScheduleNeeded;
        }

        private java.sql.Timestamp estimatedReadyDate;

        public java.sql.Timestamp getEstimatedReadyDate()
        {
            return this.estimatedReadyDate;
        }

        public void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate)
        {
            this.estimatedReadyDate = estimatedReadyDate;
        }

        private java.sql.Timestamp estimatedShipDate;

        public java.sql.Timestamp getEstimatedShipDate()
        {
            return this.estimatedShipDate;
        }

        public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
        {
            this.estimatedShipDate = estimatedShipDate;
        }

        private String estimatedShipWorkEffId;

        public String getEstimatedShipWorkEffId()
        {
            return this.estimatedShipWorkEffId;
        }

        public void setEstimatedShipWorkEffId(String estimatedShipWorkEffId)
        {
            this.estimatedShipWorkEffId = estimatedShipWorkEffId;
        }

        private java.sql.Timestamp estimatedArrivalDate;

        public java.sql.Timestamp getEstimatedArrivalDate()
        {
            return this.estimatedArrivalDate;
        }

        public void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate)
        {
            this.estimatedArrivalDate = estimatedArrivalDate;
        }

        private String estimatedArrivalWorkEffId;

        public String getEstimatedArrivalWorkEffId()
        {
            return this.estimatedArrivalWorkEffId;
        }

        public void setEstimatedArrivalWorkEffId(String estimatedArrivalWorkEffId)
        {
            this.estimatedArrivalWorkEffId = estimatedArrivalWorkEffId;
        }

        private java.sql.Timestamp latestCancelDate;

        public java.sql.Timestamp getLatestCancelDate()
        {
            return this.latestCancelDate;
        }

        public void setLatestCancelDate(java.sql.Timestamp latestCancelDate)
        {
            this.latestCancelDate = latestCancelDate;
        }

        private java.math.BigDecimal estimatedShipCost;

        public java.math.BigDecimal getEstimatedShipCost()
        {
            return this.estimatedShipCost;
        }

        public void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost)
        {
            this.estimatedShipCost = estimatedShipCost;
        }

        private String currencyUomId;

        public String getCurrencyUomId()
        {
            return this.currencyUomId;
        }

        public void setCurrencyUomId(String currencyUomId)
        {
            this.currencyUomId = currencyUomId;
        }

        private String handlingInstructions;

        public String getHandlingInstructions()
        {
            return this.handlingInstructions;
        }

        public void setHandlingInstructions(String handlingInstructions)
        {
            this.handlingInstructions = handlingInstructions;
        }

        private String originFacilityId;

        public String getOriginFacilityId()
        {
            return this.originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId)
        {
            this.originFacilityId = originFacilityId;
        }

        private String destinationFacilityId;

        public String getDestinationFacilityId()
        {
            return this.destinationFacilityId;
        }

        public void setDestinationFacilityId(String destinationFacilityId)
        {
            this.destinationFacilityId = destinationFacilityId;
        }

        private String originContactMechId;

        public String getOriginContactMechId()
        {
            return this.originContactMechId;
        }

        public void setOriginContactMechId(String originContactMechId)
        {
            this.originContactMechId = originContactMechId;
        }

        private String originTelecomNumberId;

        public String getOriginTelecomNumberId()
        {
            return this.originTelecomNumberId;
        }

        public void setOriginTelecomNumberId(String originTelecomNumberId)
        {
            this.originTelecomNumberId = originTelecomNumberId;
        }

        private String destinationContactMechId;

        public String getDestinationContactMechId()
        {
            return this.destinationContactMechId;
        }

        public void setDestinationContactMechId(String destinationContactMechId)
        {
            this.destinationContactMechId = destinationContactMechId;
        }

        private String destinationTelecomNumberId;

        public String getDestinationTelecomNumberId()
        {
            return this.destinationTelecomNumberId;
        }

        public void setDestinationTelecomNumberId(String destinationTelecomNumberId)
        {
            this.destinationTelecomNumberId = destinationTelecomNumberId;
        }

        private String partyIdTo;

        public String getPartyIdTo()
        {
            return this.partyIdTo;
        }

        public void setPartyIdTo(String partyIdTo)
        {
            this.partyIdTo = partyIdTo;
        }

        private String partyIdFrom;

        public String getPartyIdFrom()
        {
            return this.partyIdFrom;
        }

        public void setPartyIdFrom(String partyIdFrom)
        {
            this.partyIdFrom = partyIdFrom;
        }

        private java.math.BigDecimal additionalShippingCharge;

        public java.math.BigDecimal getAdditionalShippingCharge()
        {
            return this.additionalShippingCharge;
        }

        public void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge)
        {
            this.additionalShippingCharge = additionalShippingCharge;
        }

        private String addtlShippingChargeDesc;

        public String getAddtlShippingChargeDesc()
        {
            return this.addtlShippingChargeDesc;
        }

        public void setAddtlShippingChargeDesc(String addtlShippingChargeDesc)
        {
            this.addtlShippingChargeDesc = addtlShippingChargeDesc;
        }

        private Boolean f_B_1_;

        public Boolean getF_B_1_()
        {
            return this.f_B_1_;
        }

        public void setF_B_1_(Boolean f_B_1_)
        {
            this.f_B_1_ = f_B_1_;
        }

        private Boolean f_B_2_;

        public Boolean getF_B_2_()
        {
            return this.f_B_2_;
        }

        public void setF_B_2_(Boolean f_B_2_)
        {
            this.f_B_2_ = f_B_2_;
        }

        private Boolean f_B_3_;

        public Boolean getF_B_3_()
        {
            return this.f_B_3_;
        }

        public void setF_B_3_(Boolean f_B_3_)
        {
            this.f_B_3_ = f_B_3_;
        }

        private String f_C10_1_;

        public String getF_C10_1_()
        {
            return this.f_C10_1_;
        }

        public void setF_C10_1_(String f_C10_1_)
        {
            this.f_C10_1_ = f_C10_1_;
        }

        private String f_C10_2_;

        public String getF_C10_2_()
        {
            return this.f_C10_2_;
        }

        public void setF_C10_2_(String f_C10_2_)
        {
            this.f_C10_2_ = f_C10_2_;
        }

        private String f_C10_3_;

        public String getF_C10_3_()
        {
            return this.f_C10_3_;
        }

        public void setF_C10_3_(String f_C10_3_)
        {
            this.f_C10_3_ = f_C10_3_;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        public ShipmentImageCommand.CreateShipmentImage newCreateShipmentImage()
        {
            AbstractShipmentImageCommand.SimpleCreateShipmentImage c = new AbstractShipmentImageCommand.SimpleCreateShipmentImage();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentImageCommand.MergePatchShipmentImage newMergePatchShipmentImage()
        {
            AbstractShipmentImageCommand.SimpleMergePatchShipmentImage c = new AbstractShipmentImageCommand.SimpleMergePatchShipmentImage();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentImageCommand.RemoveShipmentImage newRemoveShipmentImage()
        {
            AbstractShipmentImageCommand.SimpleRemoveShipmentImage c = new AbstractShipmentImageCommand.SimpleRemoveShipmentImage();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentItemCommand.CreateShipmentItem newCreateShipmentItem()
        {
            AbstractShipmentItemCommand.SimpleCreateShipmentItem c = new AbstractShipmentItemCommand.SimpleCreateShipmentItem();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentItemCommand.MergePatchShipmentItem newMergePatchShipmentItem()
        {
            AbstractShipmentItemCommand.SimpleMergePatchShipmentItem c = new AbstractShipmentItemCommand.SimpleMergePatchShipmentItem();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentItemCommand.RemoveShipmentItem newRemoveShipmentItem()
        {
            AbstractShipmentItemCommand.SimpleRemoveShipmentItem c = new AbstractShipmentItemCommand.SimpleRemoveShipmentItem();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentReceiptCommand.CreateShipmentReceipt newCreateShipmentReceipt()
        {
            AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt c = new AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentReceiptCommand.MergePatchShipmentReceipt newMergePatchShipmentReceipt()
        {
            AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt c = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ShipmentReceiptCommand.RemoveShipmentReceipt newRemoveShipmentReceipt()
        {
            AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt c = new AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ItemIssuanceCommand.CreateItemIssuance newCreateItemIssuance()
        {
            AbstractItemIssuanceCommand.SimpleCreateItemIssuance c = new AbstractItemIssuanceCommand.SimpleCreateItemIssuance();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ItemIssuanceCommand.MergePatchItemIssuance newMergePatchItemIssuance()
        {
            AbstractItemIssuanceCommand.SimpleMergePatchItemIssuance c = new AbstractItemIssuanceCommand.SimpleMergePatchItemIssuance();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

        public ItemIssuanceCommand.RemoveItemIssuance newRemoveItemIssuance()
        {
            AbstractItemIssuanceCommand.SimpleRemoveItemIssuance c = new AbstractItemIssuanceCommand.SimpleRemoveItemIssuance();
            c.setShipmentId(this.getShipmentId());

            return c;
        }

    }

    public static abstract class AbstractCreateShipment extends AbstractCreateOrMergePatchShipment implements CreateShipment
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateShipmentImageCommandCollection createShipmentImageCommands = new SimpleCreateShipmentImageCommandCollection();

        public CreateShipmentImageCommandCollection getCreateShipmentImageCommands() {
            return this.createShipmentImageCommands;
        }

        public CreateShipmentImageCommandCollection getShipmentImages() {
            return this.createShipmentImageCommands; //shipmentImages;
        }

        private CreateShipmentItemCommandCollection createShipmentItemCommands = new SimpleCreateShipmentItemCommandCollection();

        public CreateShipmentItemCommandCollection getCreateShipmentItemCommands() {
            return this.createShipmentItemCommands;
        }

        public CreateShipmentItemCommandCollection getShipmentItems() {
            return this.createShipmentItemCommands; //shipmentItems;
        }

        private CreateShipmentReceiptCommandCollection createShipmentReceiptCommands = new SimpleCreateShipmentReceiptCommandCollection();

        public CreateShipmentReceiptCommandCollection getCreateShipmentReceiptCommands() {
            return this.createShipmentReceiptCommands;
        }

        public CreateShipmentReceiptCommandCollection getShipmentReceipts() {
            return this.createShipmentReceiptCommands; //shipmentReceipts;
        }

        private CreateItemIssuanceCommandCollection createItemIssuanceCommands = new SimpleCreateItemIssuanceCommandCollection();

        public CreateItemIssuanceCommandCollection getCreateItemIssuanceCommands() {
            return this.createItemIssuanceCommands;
        }

        public CreateItemIssuanceCommandCollection getItemIssuances() {
            return this.createItemIssuanceCommands; //itemIssuances;
        }

    }

    public static abstract class AbstractMergePatchShipment extends AbstractCreateOrMergePatchShipment implements MergePatchShipment
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private String purchaseShipmentAction;
 
        public String getPurchaseShipmentAction() {
            return this.purchaseShipmentAction;
        }

        public void setPurchaseShipmentAction(String purchaseShipmentAction) {
            this.purchaseShipmentAction = purchaseShipmentAction;
        }
                
        private String salesShipmentAction;
 
        public String getSalesShipmentAction() {
            return this.salesShipmentAction;
        }

        public void setSalesShipmentAction(String salesShipmentAction) {
            this.salesShipmentAction = salesShipmentAction;
        }
                
        private Boolean isPropertyShipmentTypeIdRemoved;

        public Boolean getIsPropertyShipmentTypeIdRemoved()
        {
            return this.isPropertyShipmentTypeIdRemoved;
        }

        public void setIsPropertyShipmentTypeIdRemoved(Boolean removed)
        {
            this.isPropertyShipmentTypeIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryOrderIdRemoved;

        public Boolean getIsPropertyPrimaryOrderIdRemoved()
        {
            return this.isPropertyPrimaryOrderIdRemoved;
        }

        public void setIsPropertyPrimaryOrderIdRemoved(Boolean removed)
        {
            this.isPropertyPrimaryOrderIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryReturnIdRemoved;

        public Boolean getIsPropertyPrimaryReturnIdRemoved()
        {
            return this.isPropertyPrimaryReturnIdRemoved;
        }

        public void setIsPropertyPrimaryReturnIdRemoved(Boolean removed)
        {
            this.isPropertyPrimaryReturnIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryShipGroupSeqIdRemoved;

        public Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved()
        {
            return this.isPropertyPrimaryShipGroupSeqIdRemoved;
        }

        public void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed)
        {
            this.isPropertyPrimaryShipGroupSeqIdRemoved = removed;
        }

        private Boolean isPropertyOnlyOneOrderRemoved;

        public Boolean getIsPropertyOnlyOneOrderRemoved()
        {
            return this.isPropertyOnlyOneOrderRemoved;
        }

        public void setIsPropertyOnlyOneOrderRemoved(Boolean removed)
        {
            this.isPropertyOnlyOneOrderRemoved = removed;
        }

        private Boolean isPropertyOnlyOneOrderShipGroupRemoved;

        public Boolean getIsPropertyOnlyOneOrderShipGroupRemoved()
        {
            return this.isPropertyOnlyOneOrderShipGroupRemoved;
        }

        public void setIsPropertyOnlyOneOrderShipGroupRemoved(Boolean removed)
        {
            this.isPropertyOnlyOneOrderShipGroupRemoved = removed;
        }

        private Boolean isPropertyPicklistBinIdRemoved;

        public Boolean getIsPropertyPicklistBinIdRemoved()
        {
            return this.isPropertyPicklistBinIdRemoved;
        }

        public void setIsPropertyPicklistBinIdRemoved(Boolean removed)
        {
            this.isPropertyPicklistBinIdRemoved = removed;
        }

        private Boolean isPropertyBolNumberRemoved;

        public Boolean getIsPropertyBolNumberRemoved()
        {
            return this.isPropertyBolNumberRemoved;
        }

        public void setIsPropertyBolNumberRemoved(Boolean removed)
        {
            this.isPropertyBolNumberRemoved = removed;
        }

        private Boolean isPropertySealNumberRemoved;

        public Boolean getIsPropertySealNumberRemoved()
        {
            return this.isPropertySealNumberRemoved;
        }

        public void setIsPropertySealNumberRemoved(Boolean removed)
        {
            this.isPropertySealNumberRemoved = removed;
        }

        private Boolean isPropertyVehicleIdRemoved;

        public Boolean getIsPropertyVehicleIdRemoved()
        {
            return this.isPropertyVehicleIdRemoved;
        }

        public void setIsPropertyVehicleIdRemoved(Boolean removed)
        {
            this.isPropertyVehicleIdRemoved = removed;
        }

        private Boolean isPropertyExternalOrderNumberRemoved;

        public Boolean getIsPropertyExternalOrderNumberRemoved()
        {
            return this.isPropertyExternalOrderNumberRemoved;
        }

        public void setIsPropertyExternalOrderNumberRemoved(Boolean removed)
        {
            this.isPropertyExternalOrderNumberRemoved = removed;
        }

        private Boolean isPropertyCarrierRemoved;

        public Boolean getIsPropertyCarrierRemoved()
        {
            return this.isPropertyCarrierRemoved;
        }

        public void setIsPropertyCarrierRemoved(Boolean removed)
        {
            this.isPropertyCarrierRemoved = removed;
        }

        private Boolean isPropertyDateShippedRemoved;

        public Boolean getIsPropertyDateShippedRemoved()
        {
            return this.isPropertyDateShippedRemoved;
        }

        public void setIsPropertyDateShippedRemoved(Boolean removed)
        {
            this.isPropertyDateShippedRemoved = removed;
        }

        private Boolean isPropertyIsCreatedFromPackingListRemoved;

        public Boolean getIsPropertyIsCreatedFromPackingListRemoved()
        {
            return this.isPropertyIsCreatedFromPackingListRemoved;
        }

        public void setIsPropertyIsCreatedFromPackingListRemoved(Boolean removed)
        {
            this.isPropertyIsCreatedFromPackingListRemoved = removed;
        }

        private Boolean isPropertyIsScheduleNeededRemoved;

        public Boolean getIsPropertyIsScheduleNeededRemoved()
        {
            return this.isPropertyIsScheduleNeededRemoved;
        }

        public void setIsPropertyIsScheduleNeededRemoved(Boolean removed)
        {
            this.isPropertyIsScheduleNeededRemoved = removed;
        }

        private Boolean isPropertyEstimatedReadyDateRemoved;

        public Boolean getIsPropertyEstimatedReadyDateRemoved()
        {
            return this.isPropertyEstimatedReadyDateRemoved;
        }

        public void setIsPropertyEstimatedReadyDateRemoved(Boolean removed)
        {
            this.isPropertyEstimatedReadyDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipDateRemoved;

        public Boolean getIsPropertyEstimatedShipDateRemoved()
        {
            return this.isPropertyEstimatedShipDateRemoved;
        }

        public void setIsPropertyEstimatedShipDateRemoved(Boolean removed)
        {
            this.isPropertyEstimatedShipDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipWorkEffIdRemoved;

        public Boolean getIsPropertyEstimatedShipWorkEffIdRemoved()
        {
            return this.isPropertyEstimatedShipWorkEffIdRemoved;
        }

        public void setIsPropertyEstimatedShipWorkEffIdRemoved(Boolean removed)
        {
            this.isPropertyEstimatedShipWorkEffIdRemoved = removed;
        }

        private Boolean isPropertyEstimatedArrivalDateRemoved;

        public Boolean getIsPropertyEstimatedArrivalDateRemoved()
        {
            return this.isPropertyEstimatedArrivalDateRemoved;
        }

        public void setIsPropertyEstimatedArrivalDateRemoved(Boolean removed)
        {
            this.isPropertyEstimatedArrivalDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedArrivalWorkEffIdRemoved;

        public Boolean getIsPropertyEstimatedArrivalWorkEffIdRemoved()
        {
            return this.isPropertyEstimatedArrivalWorkEffIdRemoved;
        }

        public void setIsPropertyEstimatedArrivalWorkEffIdRemoved(Boolean removed)
        {
            this.isPropertyEstimatedArrivalWorkEffIdRemoved = removed;
        }

        private Boolean isPropertyLatestCancelDateRemoved;

        public Boolean getIsPropertyLatestCancelDateRemoved()
        {
            return this.isPropertyLatestCancelDateRemoved;
        }

        public void setIsPropertyLatestCancelDateRemoved(Boolean removed)
        {
            this.isPropertyLatestCancelDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipCostRemoved;

        public Boolean getIsPropertyEstimatedShipCostRemoved()
        {
            return this.isPropertyEstimatedShipCostRemoved;
        }

        public void setIsPropertyEstimatedShipCostRemoved(Boolean removed)
        {
            this.isPropertyEstimatedShipCostRemoved = removed;
        }

        private Boolean isPropertyCurrencyUomIdRemoved;

        public Boolean getIsPropertyCurrencyUomIdRemoved()
        {
            return this.isPropertyCurrencyUomIdRemoved;
        }

        public void setIsPropertyCurrencyUomIdRemoved(Boolean removed)
        {
            this.isPropertyCurrencyUomIdRemoved = removed;
        }

        private Boolean isPropertyHandlingInstructionsRemoved;

        public Boolean getIsPropertyHandlingInstructionsRemoved()
        {
            return this.isPropertyHandlingInstructionsRemoved;
        }

        public void setIsPropertyHandlingInstructionsRemoved(Boolean removed)
        {
            this.isPropertyHandlingInstructionsRemoved = removed;
        }

        private Boolean isPropertyOriginFacilityIdRemoved;

        public Boolean getIsPropertyOriginFacilityIdRemoved()
        {
            return this.isPropertyOriginFacilityIdRemoved;
        }

        public void setIsPropertyOriginFacilityIdRemoved(Boolean removed)
        {
            this.isPropertyOriginFacilityIdRemoved = removed;
        }

        private Boolean isPropertyDestinationFacilityIdRemoved;

        public Boolean getIsPropertyDestinationFacilityIdRemoved()
        {
            return this.isPropertyDestinationFacilityIdRemoved;
        }

        public void setIsPropertyDestinationFacilityIdRemoved(Boolean removed)
        {
            this.isPropertyDestinationFacilityIdRemoved = removed;
        }

        private Boolean isPropertyOriginContactMechIdRemoved;

        public Boolean getIsPropertyOriginContactMechIdRemoved()
        {
            return this.isPropertyOriginContactMechIdRemoved;
        }

        public void setIsPropertyOriginContactMechIdRemoved(Boolean removed)
        {
            this.isPropertyOriginContactMechIdRemoved = removed;
        }

        private Boolean isPropertyOriginTelecomNumberIdRemoved;

        public Boolean getIsPropertyOriginTelecomNumberIdRemoved()
        {
            return this.isPropertyOriginTelecomNumberIdRemoved;
        }

        public void setIsPropertyOriginTelecomNumberIdRemoved(Boolean removed)
        {
            this.isPropertyOriginTelecomNumberIdRemoved = removed;
        }

        private Boolean isPropertyDestinationContactMechIdRemoved;

        public Boolean getIsPropertyDestinationContactMechIdRemoved()
        {
            return this.isPropertyDestinationContactMechIdRemoved;
        }

        public void setIsPropertyDestinationContactMechIdRemoved(Boolean removed)
        {
            this.isPropertyDestinationContactMechIdRemoved = removed;
        }

        private Boolean isPropertyDestinationTelecomNumberIdRemoved;

        public Boolean getIsPropertyDestinationTelecomNumberIdRemoved()
        {
            return this.isPropertyDestinationTelecomNumberIdRemoved;
        }

        public void setIsPropertyDestinationTelecomNumberIdRemoved(Boolean removed)
        {
            this.isPropertyDestinationTelecomNumberIdRemoved = removed;
        }

        private Boolean isPropertyPartyIdToRemoved;

        public Boolean getIsPropertyPartyIdToRemoved()
        {
            return this.isPropertyPartyIdToRemoved;
        }

        public void setIsPropertyPartyIdToRemoved(Boolean removed)
        {
            this.isPropertyPartyIdToRemoved = removed;
        }

        private Boolean isPropertyPartyIdFromRemoved;

        public Boolean getIsPropertyPartyIdFromRemoved()
        {
            return this.isPropertyPartyIdFromRemoved;
        }

        public void setIsPropertyPartyIdFromRemoved(Boolean removed)
        {
            this.isPropertyPartyIdFromRemoved = removed;
        }

        private Boolean isPropertyAdditionalShippingChargeRemoved;

        public Boolean getIsPropertyAdditionalShippingChargeRemoved()
        {
            return this.isPropertyAdditionalShippingChargeRemoved;
        }

        public void setIsPropertyAdditionalShippingChargeRemoved(Boolean removed)
        {
            this.isPropertyAdditionalShippingChargeRemoved = removed;
        }

        private Boolean isPropertyAddtlShippingChargeDescRemoved;

        public Boolean getIsPropertyAddtlShippingChargeDescRemoved()
        {
            return this.isPropertyAddtlShippingChargeDescRemoved;
        }

        public void setIsPropertyAddtlShippingChargeDescRemoved(Boolean removed)
        {
            this.isPropertyAddtlShippingChargeDescRemoved = removed;
        }

        private Boolean isPropertyF_B_1_Removed;

        public Boolean getIsPropertyF_B_1_Removed()
        {
            return this.isPropertyF_B_1_Removed;
        }

        public void setIsPropertyF_B_1_Removed(Boolean removed)
        {
            this.isPropertyF_B_1_Removed = removed;
        }

        private Boolean isPropertyF_B_2_Removed;

        public Boolean getIsPropertyF_B_2_Removed()
        {
            return this.isPropertyF_B_2_Removed;
        }

        public void setIsPropertyF_B_2_Removed(Boolean removed)
        {
            this.isPropertyF_B_2_Removed = removed;
        }

        private Boolean isPropertyF_B_3_Removed;

        public Boolean getIsPropertyF_B_3_Removed()
        {
            return this.isPropertyF_B_3_Removed;
        }

        public void setIsPropertyF_B_3_Removed(Boolean removed)
        {
            this.isPropertyF_B_3_Removed = removed;
        }

        private Boolean isPropertyF_C10_1_Removed;

        public Boolean getIsPropertyF_C10_1_Removed()
        {
            return this.isPropertyF_C10_1_Removed;
        }

        public void setIsPropertyF_C10_1_Removed(Boolean removed)
        {
            this.isPropertyF_C10_1_Removed = removed;
        }

        private Boolean isPropertyF_C10_2_Removed;

        public Boolean getIsPropertyF_C10_2_Removed()
        {
            return this.isPropertyF_C10_2_Removed;
        }

        public void setIsPropertyF_C10_2_Removed(Boolean removed)
        {
            this.isPropertyF_C10_2_Removed = removed;
        }

        private Boolean isPropertyF_C10_3_Removed;

        public Boolean getIsPropertyF_C10_3_Removed()
        {
            return this.isPropertyF_C10_3_Removed;
        }

        public void setIsPropertyF_C10_3_Removed(Boolean removed)
        {
            this.isPropertyF_C10_3_Removed = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private ShipmentImageCommandCollection shipmentImageCommands = new SimpleShipmentImageCommandCollection();

        public ShipmentImageCommandCollection getShipmentImageCommands()
        {
            return this.shipmentImageCommands;
        }

        private ShipmentItemCommandCollection shipmentItemCommands = new SimpleShipmentItemCommandCollection();

        public ShipmentItemCommandCollection getShipmentItemCommands()
        {
            return this.shipmentItemCommands;
        }

        private ShipmentReceiptCommandCollection shipmentReceiptCommands = new SimpleShipmentReceiptCommandCollection();

        public ShipmentReceiptCommandCollection getShipmentReceiptCommands()
        {
            return this.shipmentReceiptCommands;
        }

        private ItemIssuanceCommandCollection itemIssuanceCommands = new SimpleItemIssuanceCommandCollection();

        public ItemIssuanceCommandCollection getItemIssuanceCommands()
        {
            return this.itemIssuanceCommands;
        }

    }

    public static class SimpleCreateShipment extends AbstractCreateShipment
    {
    }

    
    public static class SimpleMergePatchShipment extends AbstractMergePatchShipment
    {
    }

    
	public static class SimpleDeleteShipment extends AbstractShipmentCommand implements DeleteShipment
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }

        private String shipmentTypeId;

        public String getShipmentTypeId() {
            return this.shipmentTypeId;
        }

        public void setShipmentTypeId(String shipmentTypeId) {
            this.shipmentTypeId = shipmentTypeId;
        }
	}

    
    public static class SimpleCreateShipmentImageCommandCollection implements CreateShipmentImageCommandCollection {
        private List<ShipmentImageCommand.CreateShipmentImage> innerCommands = new ArrayList<ShipmentImageCommand.CreateShipmentImage>();

        public void add(ShipmentImageCommand.CreateShipmentImage c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentImageCommand.CreateShipmentImage c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentImageCommand.CreateShipmentImage> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentImageCommandCollection implements ShipmentImageCommandCollection {
        private List<ShipmentImageCommand> innerCommands = new ArrayList<ShipmentImageCommand>();

        public void add(ShipmentImageCommand c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentImageCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentImageCommand> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateShipmentItemCommandCollection implements CreateShipmentItemCommandCollection {
        private List<ShipmentItemCommand.CreateShipmentItem> innerCommands = new ArrayList<ShipmentItemCommand.CreateShipmentItem>();

        public void add(ShipmentItemCommand.CreateShipmentItem c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentItemCommand.CreateShipmentItem c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentItemCommand.CreateShipmentItem> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentItemCommandCollection implements ShipmentItemCommandCollection {
        private List<ShipmentItemCommand> innerCommands = new ArrayList<ShipmentItemCommand>();

        public void add(ShipmentItemCommand c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentItemCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentItemCommand> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateShipmentReceiptCommandCollection implements CreateShipmentReceiptCommandCollection {
        private List<ShipmentReceiptCommand.CreateShipmentReceipt> innerCommands = new ArrayList<ShipmentReceiptCommand.CreateShipmentReceipt>();

        public void add(ShipmentReceiptCommand.CreateShipmentReceipt c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentReceiptCommand.CreateShipmentReceipt c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentReceiptCommand.CreateShipmentReceipt> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentReceiptCommandCollection implements ShipmentReceiptCommandCollection {
        private List<ShipmentReceiptCommand> innerCommands = new ArrayList<ShipmentReceiptCommand>();

        public void add(ShipmentReceiptCommand c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentReceiptCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentReceiptCommand> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateItemIssuanceCommandCollection implements CreateItemIssuanceCommandCollection {
        private List<ItemIssuanceCommand.CreateItemIssuance> innerCommands = new ArrayList<ItemIssuanceCommand.CreateItemIssuance>();

        public void add(ItemIssuanceCommand.CreateItemIssuance c) {
            innerCommands.add(c);
        }

        public void remove(ItemIssuanceCommand.CreateItemIssuance c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ItemIssuanceCommand.CreateItemIssuance> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleItemIssuanceCommandCollection implements ItemIssuanceCommandCollection {
        private List<ItemIssuanceCommand> innerCommands = new ArrayList<ItemIssuanceCommand>();

        public void add(ItemIssuanceCommand c) {
            innerCommands.add(c);
        }

        public void remove(ItemIssuanceCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ItemIssuanceCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

