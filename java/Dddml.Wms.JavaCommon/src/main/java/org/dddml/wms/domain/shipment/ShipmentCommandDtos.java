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

        private String estimatedShipWorkEffId;

        public String getEstimatedShipWorkEffId() {
            return this.estimatedShipWorkEffId;
        }

        public void setEstimatedShipWorkEffId(String estimatedShipWorkEffId) {
            this.estimatedShipWorkEffId = estimatedShipWorkEffId;
        }

        private java.sql.Timestamp estimatedArrivalDate;

        public java.sql.Timestamp getEstimatedArrivalDate() {
            return this.estimatedArrivalDate;
        }

        public void setEstimatedArrivalDate(java.sql.Timestamp estimatedArrivalDate) {
            this.estimatedArrivalDate = estimatedArrivalDate;
        }

        private String estimatedArrivalWorkEffId;

        public String getEstimatedArrivalWorkEffId() {
            return this.estimatedArrivalWorkEffId;
        }

        public void setEstimatedArrivalWorkEffId(String estimatedArrivalWorkEffId) {
            this.estimatedArrivalWorkEffId = estimatedArrivalWorkEffId;
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

        private ImportingShipmentItemDto[] shipmentItems;

        public ImportingShipmentItemDto[] getShipmentItems() {
            return this.shipmentItems;
        }

        public void setShipmentItems(ImportingShipmentItemDto[] shipmentItems) {
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
            cmd.setPrimaryOrderId(this.getPrimaryOrderId());
            cmd.setPrimaryReturnId(this.getPrimaryReturnId());
            cmd.setEstimatedReadyDate(this.getEstimatedReadyDate());
            cmd.setEstimatedShipDate(this.getEstimatedShipDate());
            cmd.setEstimatedShipWorkEffId(this.getEstimatedShipWorkEffId());
            cmd.setEstimatedArrivalDate(this.getEstimatedArrivalDate());
            cmd.setEstimatedArrivalWorkEffId(this.getEstimatedArrivalWorkEffId());
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
            cmd.setShipmentItems(this.getShipmentItems() == null ? null : java.util.Collections.unmodifiableSet(java.util.Arrays.stream(this.getShipmentItems()).map(p -> p.toImportingShipmentItem()).collect(java.util.stream.Collectors.toSet())));
            cmd.setShipmentId(this.getShipmentId());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

}
