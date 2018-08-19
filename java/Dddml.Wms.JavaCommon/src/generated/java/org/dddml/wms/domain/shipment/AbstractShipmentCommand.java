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

        private String statusId;

        public String getStatusId()
        {
            return this.statusId;
        }

        public void setStatusId(String statusId)
        {
            this.statusId = statusId;
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

        private Long primaryShipGroupSeqId;

        public Long getPrimaryShipGroupSeqId()
        {
            return this.primaryShipGroupSeqId;
        }

        public void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId)
        {
            this.primaryShipGroupSeqId = primaryShipGroupSeqId;
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

        private CreateShipmentImageCommands shipmentImages = new SimpleCreateShipmentImageCommands();

        public CreateShipmentImageCommands getShipmentImages()
        {
            return this.shipmentImages;
        }

        private CreateShipmentItemCommands shipmentItems = new SimpleCreateShipmentItemCommands();

        public CreateShipmentItemCommands getShipmentItems()
        {
            return this.shipmentItems;
        }

        private CreateShipmentReceiptCommands shipmentReceipts = new SimpleCreateShipmentReceiptCommands();

        public CreateShipmentReceiptCommands getShipmentReceipts()
        {
            return this.shipmentReceipts;
        }

        private CreateItemIssuanceCommands itemIssuances = new SimpleCreateItemIssuanceCommands();

        public CreateItemIssuanceCommands getItemIssuances()
        {
            return this.itemIssuances;
        }

    }

    public static abstract class AbstractMergePatchShipment extends AbstractCreateOrMergePatchShipment implements MergePatchShipment
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved()
        {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed)
        {
            this.isPropertyStatusIdRemoved = removed;
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

        private ShipmentImageCommands shipmentImageCommands = new SimpleShipmentImageCommands();

        public ShipmentImageCommands getShipmentImageCommands()
        {
            return this.shipmentImageCommands;
        }

        private ShipmentItemCommands shipmentItemCommands = new SimpleShipmentItemCommands();

        public ShipmentItemCommands getShipmentItemCommands()
        {
            return this.shipmentItemCommands;
        }

        private ShipmentReceiptCommands shipmentReceiptCommands = new SimpleShipmentReceiptCommands();

        public ShipmentReceiptCommands getShipmentReceiptCommands()
        {
            return this.shipmentReceiptCommands;
        }

        private ItemIssuanceCommands itemIssuanceCommands = new SimpleItemIssuanceCommands();

        public ItemIssuanceCommands getItemIssuanceCommands()
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
	}

    
    public static class SimpleCreateShipmentImageCommands implements CreateShipmentImageCommands
    {
        private List<ShipmentImageCommand.CreateShipmentImage> innerCommands = new ArrayList<ShipmentImageCommand.CreateShipmentImage>();

        public void add(ShipmentImageCommand.CreateShipmentImage c)
        {
            innerCommands.add(c);
        }

        public void remove(ShipmentImageCommand.CreateShipmentImage c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentImageCommand.CreateShipmentImage> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentImageCommands implements ShipmentImageCommands
    {
        private List<ShipmentImageCommand> innerCommands = new ArrayList<ShipmentImageCommand>();

        public void add(ShipmentImageCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(ShipmentImageCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentImageCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateShipmentItemCommands implements CreateShipmentItemCommands
    {
        private List<ShipmentItemCommand.CreateShipmentItem> innerCommands = new ArrayList<ShipmentItemCommand.CreateShipmentItem>();

        public void add(ShipmentItemCommand.CreateShipmentItem c)
        {
            innerCommands.add(c);
        }

        public void remove(ShipmentItemCommand.CreateShipmentItem c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentItemCommand.CreateShipmentItem> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentItemCommands implements ShipmentItemCommands
    {
        private List<ShipmentItemCommand> innerCommands = new ArrayList<ShipmentItemCommand>();

        public void add(ShipmentItemCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(ShipmentItemCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentItemCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateShipmentReceiptCommands implements CreateShipmentReceiptCommands
    {
        private List<ShipmentReceiptCommand.CreateShipmentReceipt> innerCommands = new ArrayList<ShipmentReceiptCommand.CreateShipmentReceipt>();

        public void add(ShipmentReceiptCommand.CreateShipmentReceipt c)
        {
            innerCommands.add(c);
        }

        public void remove(ShipmentReceiptCommand.CreateShipmentReceipt c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentReceiptCommand.CreateShipmentReceipt> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentReceiptCommands implements ShipmentReceiptCommands
    {
        private List<ShipmentReceiptCommand> innerCommands = new ArrayList<ShipmentReceiptCommand>();

        public void add(ShipmentReceiptCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(ShipmentReceiptCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentReceiptCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateItemIssuanceCommands implements CreateItemIssuanceCommands
    {
        private List<ItemIssuanceCommand.CreateItemIssuance> innerCommands = new ArrayList<ItemIssuanceCommand.CreateItemIssuance>();

        public void add(ItemIssuanceCommand.CreateItemIssuance c)
        {
            innerCommands.add(c);
        }

        public void remove(ItemIssuanceCommand.CreateItemIssuance c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ItemIssuanceCommand.CreateItemIssuance> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleItemIssuanceCommands implements ItemIssuanceCommands
    {
        private List<ItemIssuanceCommand> innerCommands = new ArrayList<ItemIssuanceCommand>();

        public void add(ItemIssuanceCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(ItemIssuanceCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<ItemIssuanceCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

