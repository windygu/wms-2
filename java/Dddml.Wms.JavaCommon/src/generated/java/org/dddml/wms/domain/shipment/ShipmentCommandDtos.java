package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class ShipmentCommandDtos
{
    private ShipmentCommandDtos() {
    }

    public static class ImportRequestContent {

        public String getCommandType() {
            return "Import";
        }

        private String shipmentTypeId;

        public String getShipmentTypeId() {
            return this.shipmentTypeId;
        }

        public void setShipmentTypeId(String shipmentTypeId) {
            this.shipmentTypeId = shipmentTypeId;
        }

        private String primaryOrderId;

        public String getPrimaryOrderId() {
            return this.primaryOrderId;
        }

        public void setPrimaryOrderId(String primaryOrderId) {
            this.primaryOrderId = primaryOrderId;
        }

        private String primaryReturnId;

        public String getPrimaryReturnId() {
            return this.primaryReturnId;
        }

        public void setPrimaryReturnId(String primaryReturnId) {
            this.primaryReturnId = primaryReturnId;
        }

        private String bolNumber;

        public String getBolNumber() {
            return this.bolNumber;
        }

        public void setBolNumber(String bolNumber) {
            this.bolNumber = bolNumber;
        }

        private String vehicleId;

        public String getVehicleId() {
            return this.vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        private String sealNumber;

        public String getSealNumber() {
            return this.sealNumber;
        }

        public void setSealNumber(String sealNumber) {
            this.sealNumber = sealNumber;
        }

        private String poNumber;

        public String getPoNumber() {
            return this.poNumber;
        }

        public void setPoNumber(String poNumber) {
            this.poNumber = poNumber;
        }

        private String carrier;

        public String getCarrier() {
            return this.carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        private java.sql.Timestamp dateShipped;

        public java.sql.Timestamp getDateShipped() {
            return this.dateShipped;
        }

        public void setDateShipped(java.sql.Timestamp dateShipped) {
            this.dateShipped = dateShipped;
        }

        private java.sql.Timestamp estimatedReadyDate;

        public java.sql.Timestamp getEstimatedReadyDate() {
            return this.estimatedReadyDate;
        }

        public void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate) {
            this.estimatedReadyDate = estimatedReadyDate;
        }

        private java.sql.Timestamp estimatedShipDate;

        public java.sql.Timestamp getEstimatedShipDate() {
            return this.estimatedShipDate;
        }

        public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate) {
            this.estimatedShipDate = estimatedShipDate;
        }

        private java.sql.Timestamp estimatedArrivalDate;

        public java.sql.Timestamp getEstimatedArrivalDate() {
            return this.estimatedArrivalDate;
        }

        public void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate) {
            this.estimatedArrivalDate = estimatedArrivalDate;
        }

        private java.sql.Timestamp latestCancelDate;

        public java.sql.Timestamp getLatestCancelDate() {
            return this.latestCancelDate;
        }

        public void setLatestCancelDate(java.sql.Timestamp latestCancelDate) {
            this.latestCancelDate = latestCancelDate;
        }

        private java.math.BigDecimal estimatedShipCost;

        public java.math.BigDecimal getEstimatedShipCost() {
            return this.estimatedShipCost;
        }

        public void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost) {
            this.estimatedShipCost = estimatedShipCost;
        }

        private String currencyUomId;

        public String getCurrencyUomId() {
            return this.currencyUomId;
        }

        public void setCurrencyUomId(String currencyUomId) {
            this.currencyUomId = currencyUomId;
        }

        private String handlingInstructions;

        public String getHandlingInstructions() {
            return this.handlingInstructions;
        }

        public void setHandlingInstructions(String handlingInstructions) {
            this.handlingInstructions = handlingInstructions;
        }

        private String originFacilityId;

        public String getOriginFacilityId() {
            return this.originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId) {
            this.originFacilityId = originFacilityId;
        }

        private String destinationFacilityId;

        public String getDestinationFacilityId() {
            return this.destinationFacilityId;
        }

        public void setDestinationFacilityId(String destinationFacilityId) {
            this.destinationFacilityId = destinationFacilityId;
        }

        private String partyIdTo;

        public String getPartyIdTo() {
            return this.partyIdTo;
        }

        public void setPartyIdTo(String partyIdTo) {
            this.partyIdTo = partyIdTo;
        }

        private String partyIdFrom;

        public String getPartyIdFrom() {
            return this.partyIdFrom;
        }

        public void setPartyIdFrom(String partyIdFrom) {
            this.partyIdFrom = partyIdFrom;
        }

        private java.math.BigDecimal additionalShippingCharge;

        public java.math.BigDecimal getAdditionalShippingCharge() {
            return this.additionalShippingCharge;
        }

        public void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge) {
            this.additionalShippingCharge = additionalShippingCharge;
        }

        private String addtlShippingChargeDesc;

        public String getAddtlShippingChargeDesc() {
            return this.addtlShippingChargeDesc;
        }

        public void setAddtlShippingChargeDesc(String addtlShippingChargeDesc) {
            this.addtlShippingChargeDesc = addtlShippingChargeDesc;
        }

        private ImportingShipmentItem[] shipmentItems;

        public ImportingShipmentItem[] getShipmentItems() {
            return this.shipmentItems;
        }

        public void setShipmentItems(ImportingShipmentItem[] shipmentItems) {
            this.shipmentItems = shipmentItems;
        }

        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

       public ShipmentCommands.Import toImport() {
            ShipmentCommands.Import cmd = new ShipmentCommands.Import();
            cmd.setShipmentTypeId(this.getShipmentTypeId());
            cmd.setPrimaryOrderId(this.getPrimaryOrderId());
            cmd.setPrimaryReturnId(this.getPrimaryReturnId());
            cmd.setBolNumber(this.getBolNumber());
            cmd.setVehicleId(this.getVehicleId());
            cmd.setSealNumber(this.getSealNumber());
            cmd.setPoNumber(this.getPoNumber());
            cmd.setCarrier(this.getCarrier());
            cmd.setDateShipped(this.getDateShipped());
            cmd.setEstimatedReadyDate(this.getEstimatedReadyDate());
            cmd.setEstimatedShipDate(this.getEstimatedShipDate());
            cmd.setEstimatedArrivalDate(this.getEstimatedArrivalDate());
            cmd.setLatestCancelDate(this.getLatestCancelDate());
            cmd.setEstimatedShipCost(this.getEstimatedShipCost());
            cmd.setCurrencyUomId(this.getCurrencyUomId());
            cmd.setHandlingInstructions(this.getHandlingInstructions());
            cmd.setOriginFacilityId(this.getOriginFacilityId());
            cmd.setDestinationFacilityId(this.getDestinationFacilityId());
            cmd.setPartyIdTo(this.getPartyIdTo());
            cmd.setPartyIdFrom(this.getPartyIdFrom());
            cmd.setAdditionalShippingCharge(this.getAdditionalShippingCharge());
            cmd.setAddtlShippingChargeDesc(this.getAddtlShippingChargeDesc());
            cmd.setShipmentItems(this.getShipmentItems() == null ? null : java.util.Collections.unmodifiableSet(new java.util.HashSet<ImportingShipmentItem>(java.util.Arrays.asList(this.getShipmentItems()))));
            cmd.setShipmentId(this.getShipmentId());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

    public static class ShipRequestContent {

        public String getCommandType() {
            return "Ship";
        }

        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

       public ShipmentCommands.Ship toShip() {
            ShipmentCommands.Ship cmd = new ShipmentCommands.Ship();
            cmd.setShipmentId(this.getShipmentId());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

    public static class ReceiveItemRequestContent {

        public String getCommandType() {
            return "ReceiveItem";
        }

        private String shipmentItemSeqId;

        public String getShipmentItemSeqId() {
            return this.shipmentItemSeqId;
        }

        public void setShipmentItemSeqId(String shipmentItemSeqId) {
            this.shipmentItemSeqId = shipmentItemSeqId;
        }

        private java.util.Map<String, Object> attributeSetInstance;

        public java.util.Map<String, Object> getAttributeSetInstance() {
            return this.attributeSetInstance;
        }

        public void setAttributeSetInstance(java.util.Map<String, Object> attributeSetInstance) {
            this.attributeSetInstance = attributeSetInstance;
        }

        private String rejectionReasonId;

        public String getRejectionReasonId() {
            return this.rejectionReasonId;
        }

        public void setRejectionReasonId(String rejectionReasonId) {
            this.rejectionReasonId = rejectionReasonId;
        }

        private String damageStatusId;

        public String getDamageStatusId() {
            return this.damageStatusId;
        }

        public void setDamageStatusId(String damageStatusId) {
            this.damageStatusId = damageStatusId;
        }

        private String damageReasonId;

        public String getDamageReasonId() {
            return this.damageReasonId;
        }

        public void setDamageReasonId(String damageReasonId) {
            this.damageReasonId = damageReasonId;
        }

        private java.math.BigDecimal acceptedQuantity;

        public java.math.BigDecimal getAcceptedQuantity() {
            return this.acceptedQuantity;
        }

        public void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity) {
            this.acceptedQuantity = acceptedQuantity;
        }

        private java.math.BigDecimal rejectedQuantity;

        public java.math.BigDecimal getRejectedQuantity() {
            return this.rejectedQuantity;
        }

        public void setRejectedQuantity(java.math.BigDecimal rejectedQuantity) {
            this.rejectedQuantity = rejectedQuantity;
        }

        private java.math.BigDecimal damagedQuantity;

        public java.math.BigDecimal getDamagedQuantity() {
            return this.damagedQuantity;
        }

        public void setDamagedQuantity(java.math.BigDecimal damagedQuantity) {
            this.damagedQuantity = damagedQuantity;
        }

        private String itemDescription;

        public String getItemDescription() {
            return this.itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

       public ShipmentCommands.ReceiveItem toReceiveItem() {
            ShipmentCommands.ReceiveItem cmd = new ShipmentCommands.ReceiveItem();
            cmd.setShipmentItemSeqId(this.getShipmentItemSeqId());
            cmd.setAttributeSetInstance(this.getAttributeSetInstance());
            cmd.setRejectionReasonId(this.getRejectionReasonId());
            cmd.setDamageStatusId(this.getDamageStatusId());
            cmd.setDamageReasonId(this.getDamageReasonId());
            cmd.setAcceptedQuantity(this.getAcceptedQuantity());
            cmd.setRejectedQuantity(this.getRejectedQuantity());
            cmd.setDamagedQuantity(this.getDamagedQuantity());
            cmd.setItemDescription(this.getItemDescription());
            cmd.setShipmentId(this.getShipmentId());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

    public static class ConfirmAllItemsReceivedRequestContent {

        public String getCommandType() {
            return "ConfirmAllItemsReceived";
        }

        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

       public ShipmentCommands.ConfirmAllItemsReceived toConfirmAllItemsReceived() {
            ShipmentCommands.ConfirmAllItemsReceived cmd = new ShipmentCommands.ConfirmAllItemsReceived();
            cmd.setShipmentId(this.getShipmentId());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

}

