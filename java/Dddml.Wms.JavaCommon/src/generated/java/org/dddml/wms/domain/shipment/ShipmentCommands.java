package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class ShipmentCommands
{
    private ShipmentCommands() {
    }

    public static class Import implements ShipmentCommand {

        public String getCommandType() {
            return "Import";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Shipment Type Id
         */
        private String shipmentTypeId;

        public String getShipmentTypeId() {
            return this.shipmentTypeId;
        }

        public void setShipmentTypeId(String shipmentTypeId) {
            this.shipmentTypeId = shipmentTypeId;
        }

        /**
         * Primary Order Id
         */
        private String primaryOrderId;

        public String getPrimaryOrderId() {
            return this.primaryOrderId;
        }

        public void setPrimaryOrderId(String primaryOrderId) {
            this.primaryOrderId = primaryOrderId;
        }

        /**
         * Primary Return Id
         */
        private String primaryReturnId;

        public String getPrimaryReturnId() {
            return this.primaryReturnId;
        }

        public void setPrimaryReturnId(String primaryReturnId) {
            this.primaryReturnId = primaryReturnId;
        }

        /**
         * Bill of lading
         */
        private String bolNumber;

        public String getBolNumber() {
            return this.bolNumber;
        }

        public void setBolNumber(String bolNumber) {
            this.bolNumber = bolNumber;
        }

        /**
         * Vehicle Id
         */
        private String vehicleId;

        public String getVehicleId() {
            return this.vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        /**
         * Seal Number
         */
        private String sealNumber;

        public String getSealNumber() {
            return this.sealNumber;
        }

        public void setSealNumber(String sealNumber) {
            this.sealNumber = sealNumber;
        }

        /**
         * Po Number
         */
        private String poNumber;

        public String getPoNumber() {
            return this.poNumber;
        }

        public void setPoNumber(String poNumber) {
            this.poNumber = poNumber;
        }

        /**
         * Carrier
         */
        private String carrier;

        public String getCarrier() {
            return this.carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        /**
         * Date Shipped
         */
        private java.sql.Timestamp dateShipped;

        public java.sql.Timestamp getDateShipped() {
            return this.dateShipped;
        }

        public void setDateShipped(java.sql.Timestamp dateShipped) {
            this.dateShipped = dateShipped;
        }

        /**
         * Estimated Ready Date
         */
        private java.sql.Timestamp estimatedReadyDate;

        public java.sql.Timestamp getEstimatedReadyDate() {
            return this.estimatedReadyDate;
        }

        public void setEstimatedReadyDate(java.sql.Timestamp estimatedReadyDate) {
            this.estimatedReadyDate = estimatedReadyDate;
        }

        /**
         * Estimated Ship Date
         */
        private java.sql.Timestamp estimatedShipDate;

        public java.sql.Timestamp getEstimatedShipDate() {
            return this.estimatedShipDate;
        }

        public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate) {
            this.estimatedShipDate = estimatedShipDate;
        }

        /**
         * Estimated Arrival Date
         */
        private java.sql.Timestamp estimatedArrivalDate;

        public java.sql.Timestamp getEstimatedArrivalDate() {
            return this.estimatedArrivalDate;
        }

        public void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate) {
            this.estimatedArrivalDate = estimatedArrivalDate;
        }

        /**
         * Latest Cancel Date
         */
        private java.sql.Timestamp latestCancelDate;

        public java.sql.Timestamp getLatestCancelDate() {
            return this.latestCancelDate;
        }

        public void setLatestCancelDate(java.sql.Timestamp latestCancelDate) {
            this.latestCancelDate = latestCancelDate;
        }

        /**
         * Estimated Ship Cost
         */
        private java.math.BigDecimal estimatedShipCost;

        public java.math.BigDecimal getEstimatedShipCost() {
            return this.estimatedShipCost;
        }

        public void setEstimatedShipCost(java.math.BigDecimal estimatedShipCost) {
            this.estimatedShipCost = estimatedShipCost;
        }

        /**
         * Currency Uom Id
         */
        private String currencyUomId;

        public String getCurrencyUomId() {
            return this.currencyUomId;
        }

        public void setCurrencyUomId(String currencyUomId) {
            this.currencyUomId = currencyUomId;
        }

        /**
         * Handling Instructions
         */
        private String handlingInstructions;

        public String getHandlingInstructions() {
            return this.handlingInstructions;
        }

        public void setHandlingInstructions(String handlingInstructions) {
            this.handlingInstructions = handlingInstructions;
        }

        /**
         * Origin Facility Id
         */
        private String originFacilityId;

        public String getOriginFacilityId() {
            return this.originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId) {
            this.originFacilityId = originFacilityId;
        }

        /**
         * Destination Facility Id
         */
        private String destinationFacilityId;

        public String getDestinationFacilityId() {
            return this.destinationFacilityId;
        }

        public void setDestinationFacilityId(String destinationFacilityId) {
            this.destinationFacilityId = destinationFacilityId;
        }

        /**
         * Party Id To
         */
        private String partyIdTo;

        public String getPartyIdTo() {
            return this.partyIdTo;
        }

        public void setPartyIdTo(String partyIdTo) {
            this.partyIdTo = partyIdTo;
        }

        /**
         * Party Id From
         */
        private String partyIdFrom;

        public String getPartyIdFrom() {
            return this.partyIdFrom;
        }

        public void setPartyIdFrom(String partyIdFrom) {
            this.partyIdFrom = partyIdFrom;
        }

        /**
         * Additional Shipping Charge
         */
        private java.math.BigDecimal additionalShippingCharge;

        public java.math.BigDecimal getAdditionalShippingCharge() {
            return this.additionalShippingCharge;
        }

        public void setAdditionalShippingCharge(java.math.BigDecimal additionalShippingCharge) {
            this.additionalShippingCharge = additionalShippingCharge;
        }

        /**
         * Addtl Shipping Charge Desc
         */
        private String addtlShippingChargeDesc;

        public String getAddtlShippingChargeDesc() {
            return this.addtlShippingChargeDesc;
        }

        public void setAddtlShippingChargeDesc(String addtlShippingChargeDesc) {
            this.addtlShippingChargeDesc = addtlShippingChargeDesc;
        }

        /**
         * Shipment Items
         */
        private List<ImportingShipmentItem> shipmentItems;

        public List<ImportingShipmentItem> getShipmentItems() {
            return this.shipmentItems;
        }

        public void setShipmentItems(List<ImportingShipmentItem> shipmentItems) {
            this.shipmentItems = shipmentItems;
        }

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class Ship implements ShipmentCommand {

        public String getCommandType() {
            return "Ship";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class ReceiveItem implements ShipmentCommand {

        public String getCommandType() {
            return "ReceiveItem";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Shipment Item Seq Id
         */
        private String shipmentItemSeqId;

        public String getShipmentItemSeqId() {
            return this.shipmentItemSeqId;
        }

        public void setShipmentItemSeqId(String shipmentItemSeqId) {
            this.shipmentItemSeqId = shipmentItemSeqId;
        }

        /**
         * Attribute Set Instance
         */
        private java.util.Map<String, Object> attributeSetInstance;

        public java.util.Map<String, Object> getAttributeSetInstance() {
            return this.attributeSetInstance;
        }

        public void setAttributeSetInstance(java.util.Map<String, Object> attributeSetInstance) {
            this.attributeSetInstance = attributeSetInstance;
        }

        /**
         * Rejection Reason Id
         */
        private String rejectionReasonId;

        public String getRejectionReasonId() {
            return this.rejectionReasonId;
        }

        public void setRejectionReasonId(String rejectionReasonId) {
            this.rejectionReasonId = rejectionReasonId;
        }

        /**
         * Damage Status Id
         */
        private String damageStatusId;

        public String getDamageStatusId() {
            return this.damageStatusId;
        }

        public void setDamageStatusId(String damageStatusId) {
            this.damageStatusId = damageStatusId;
        }

        /**
         * Damage Reason Id
         */
        private String damageReasonId;

        public String getDamageReasonId() {
            return this.damageReasonId;
        }

        public void setDamageReasonId(String damageReasonId) {
            this.damageReasonId = damageReasonId;
        }

        /**
         * Accepted Quantity
         */
        private java.math.BigDecimal acceptedQuantity;

        public java.math.BigDecimal getAcceptedQuantity() {
            return this.acceptedQuantity;
        }

        public void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity) {
            this.acceptedQuantity = acceptedQuantity;
        }

        /**
         * Rejected Quantity
         */
        private java.math.BigDecimal rejectedQuantity;

        public java.math.BigDecimal getRejectedQuantity() {
            return this.rejectedQuantity;
        }

        public void setRejectedQuantity(java.math.BigDecimal rejectedQuantity) {
            this.rejectedQuantity = rejectedQuantity;
        }

        /**
         * Damaged Quantity
         */
        private java.math.BigDecimal damagedQuantity;

        public java.math.BigDecimal getDamagedQuantity() {
            return this.damagedQuantity;
        }

        public void setDamagedQuantity(java.math.BigDecimal damagedQuantity) {
            this.damagedQuantity = damagedQuantity;
        }

        /**
         * Item Description
         */
        private String itemDescription;

        public String getItemDescription() {
            return this.itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class ConfirmAllItemsReceived implements ShipmentCommand {

        public String getCommandType() {
            return "ConfirmAllItemsReceived";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

}

