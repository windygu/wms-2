// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainServices.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.wms.domain.service;

import java.util.*;
import org.dddml.wms.domain.*;

public class OrderShipGroupServiceCommandDtos {

    private OrderShipGroupServiceCommandDtos() {
    }
    
    public static class CreatePOShipGroupsDto {

        /**
         * Telecom Contact Mech Id
         */
        private String telecomContactMechId;

        public String getTelecomContactMechId() {
            return telecomContactMechId;
        }

        public void setTelecomContactMechId(String telecomContactMechId) {
            this.telecomContactMechId = telecomContactMechId;
        }

        /**
         * Facility Id
         */
        private String facilityId;

        public String getFacilityId() {
            return facilityId;
        }

        public void setFacilityId(String facilityId) {
            this.facilityId = facilityId;
        }

        /**
         * Order Item Ship Group Associations
         */
        private OrderItemShipGroupAssociationInfo[] orderItemShipGroupAssociations;

        public OrderItemShipGroupAssociationInfo[] getOrderItemShipGroupAssociations() {
            return orderItemShipGroupAssociations;
        }

        public void setOrderItemShipGroupAssociations(OrderItemShipGroupAssociationInfo[] orderItemShipGroupAssociations) {
            this.orderItemShipGroupAssociations = orderItemShipGroupAssociations;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class CreateSOShipGroupsDto {

        /**
         * Telecom Contact Mech Id
         */
        private String telecomContactMechId;

        public String getTelecomContactMechId() {
            return telecomContactMechId;
        }

        public void setTelecomContactMechId(String telecomContactMechId) {
            this.telecomContactMechId = telecomContactMechId;
        }

        /**
         * Facility Id
         */
        private String facilityId;

        public String getFacilityId() {
            return facilityId;
        }

        public void setFacilityId(String facilityId) {
            this.facilityId = facilityId;
        }

        /**
         * Order Item Ship Group Associations
         */
        private OrderItemShipGroupAssociationInfo[] orderItemShipGroupAssociations;

        public OrderItemShipGroupAssociationInfo[] getOrderItemShipGroupAssociations() {
            return orderItemShipGroupAssociations;
        }

        public void setOrderItemShipGroupAssociations(OrderItemShipGroupAssociationInfo[] orderItemShipGroupAssociations) {
            this.orderItemShipGroupAssociations = orderItemShipGroupAssociations;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class UpdateOrderItemShipGroupAssociationDto {

        /**
         * Order Item Ship Group Association
         */
        private OrderItemShipGroupAssociationInfo orderItemShipGroupAssociation;

        public OrderItemShipGroupAssociationInfo getOrderItemShipGroupAssociation() {
            return orderItemShipGroupAssociation;
        }

        public void setOrderItemShipGroupAssociation(OrderItemShipGroupAssociationInfo orderItemShipGroupAssociation) {
            this.orderItemShipGroupAssociation = orderItemShipGroupAssociation;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class CreatePOShipmentDto {

        /**
         * Order Id Ship Group Seq Id Pairs
         */
        private OrderIdShipGroupSeqIdPair[] orderIdShipGroupSeqIdPairs;

        public OrderIdShipGroupSeqIdPair[] getOrderIdShipGroupSeqIdPairs() {
            return orderIdShipGroupSeqIdPairs;
        }

        public void setOrderIdShipGroupSeqIdPairs(OrderIdShipGroupSeqIdPair[] orderIdShipGroupSeqIdPairs) {
            this.orderIdShipGroupSeqIdPairs = orderIdShipGroupSeqIdPairs;
        }

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Is Shipped
         */
        private Boolean isShipped;

        public Boolean getIsShipped() {
            return isShipped;
        }

        public void setIsShipped(Boolean isShipped) {
            this.isShipped = isShipped;
        }

        /**
         * Origin Facility Id
         */
        private String originFacilityId;

        public String getOriginFacilityId() {
            return originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId) {
            this.originFacilityId = originFacilityId;
        }

        /**
         * Destination Facility Id
         */
        private String destinationFacilityId;

        public String getDestinationFacilityId() {
            return destinationFacilityId;
        }

        public void setDestinationFacilityId(String destinationFacilityId) {
            this.destinationFacilityId = destinationFacilityId;
        }

        /**
         * Origin Contact Mech Id
         */
        private String originContactMechId;

        public String getOriginContactMechId() {
            return originContactMechId;
        }

        public void setOriginContactMechId(String originContactMechId) {
            this.originContactMechId = originContactMechId;
        }

        /**
         * Destination Contact Mech Id
         */
        private String destinationContactMechId;

        public String getDestinationContactMechId() {
            return destinationContactMechId;
        }

        public void setDestinationContactMechId(String destinationContactMechId) {
            this.destinationContactMechId = destinationContactMechId;
        }

        /**
         * Handling Instructions
         */
        private String handlingInstructions;

        public String getHandlingInstructions() {
            return handlingInstructions;
        }

        public void setHandlingInstructions(String handlingInstructions) {
            this.handlingInstructions = handlingInstructions;
        }

        /**
         * Estimated Ship Date
         */
        private java.sql.Timestamp estimatedShipDate;

        public java.sql.Timestamp getEstimatedShipDate() {
            return estimatedShipDate;
        }

        public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate) {
            this.estimatedShipDate = estimatedShipDate;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class CreateSOShipmentDto {

        /**
         * Order Id Ship Group Seq Id Pairs
         */
        private OrderIdShipGroupSeqIdPair[] orderIdShipGroupSeqIdPairs;

        public OrderIdShipGroupSeqIdPair[] getOrderIdShipGroupSeqIdPairs() {
            return orderIdShipGroupSeqIdPairs;
        }

        public void setOrderIdShipGroupSeqIdPairs(OrderIdShipGroupSeqIdPair[] orderIdShipGroupSeqIdPairs) {
            this.orderIdShipGroupSeqIdPairs = orderIdShipGroupSeqIdPairs;
        }

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Origin Facility Id
         */
        private String originFacilityId;

        public String getOriginFacilityId() {
            return originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId) {
            this.originFacilityId = originFacilityId;
        }

        /**
         * Destination Facility Id
         */
        private String destinationFacilityId;

        public String getDestinationFacilityId() {
            return destinationFacilityId;
        }

        public void setDestinationFacilityId(String destinationFacilityId) {
            this.destinationFacilityId = destinationFacilityId;
        }

        /**
         * Origin Contact Mech Id
         */
        private String originContactMechId;

        public String getOriginContactMechId() {
            return originContactMechId;
        }

        public void setOriginContactMechId(String originContactMechId) {
            this.originContactMechId = originContactMechId;
        }

        /**
         * Destination Contact Mech Id
         */
        private String destinationContactMechId;

        public String getDestinationContactMechId() {
            return destinationContactMechId;
        }

        public void setDestinationContactMechId(String destinationContactMechId) {
            this.destinationContactMechId = destinationContactMechId;
        }

        /**
         * Handling Instructions
         */
        private String handlingInstructions;

        public String getHandlingInstructions() {
            return handlingInstructions;
        }

        public void setHandlingInstructions(String handlingInstructions) {
            this.handlingInstructions = handlingInstructions;
        }

        /**
         * Estimated Ship Date
         */
        private java.sql.Timestamp estimatedShipDate;

        public java.sql.Timestamp getEstimatedShipDate() {
            return estimatedShipDate;
        }

        public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate) {
            this.estimatedShipDate = estimatedShipDate;
        }

        /**
         * Is Schedule Needed
         */
        private Boolean isScheduleNeeded;

        public Boolean getIsScheduleNeeded() {
            return isScheduleNeeded;
        }

        public void setIsScheduleNeeded(Boolean isScheduleNeeded) {
            this.isScheduleNeeded = isScheduleNeeded;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class ShipPOShipmentDto {

        /**
         * Shipment Id
         */
        private String shipmentId;

        public String getShipmentId() {
            return shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
        }

        /**
         * Primary Order Id
         */
        private String primaryOrderId;

        public String getPrimaryOrderId() {
            return primaryOrderId;
        }

        public void setPrimaryOrderId(String primaryOrderId) {
            this.primaryOrderId = primaryOrderId;
        }

        /**
         * Primary Ship Group Seq Id
         */
        private String primaryShipGroupSeqId;

        public String getPrimaryShipGroupSeqId() {
            return primaryShipGroupSeqId;
        }

        public void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId) {
            this.primaryShipGroupSeqId = primaryShipGroupSeqId;
        }

        /**
         * Hint Shipment Items Enabled
         */
        private Boolean hintShipmentItemsEnabled;

        public Boolean getHintShipmentItemsEnabled() {
            return hintShipmentItemsEnabled;
        }

        public void setHintShipmentItemsEnabled(Boolean hintShipmentItemsEnabled) {
            this.hintShipmentItemsEnabled = hintShipmentItemsEnabled;
        }

        /**
         * Other Order Id Ship Group Seq Id Pairs
         */
        private OrderIdShipGroupSeqIdPair[] otherOrderIdShipGroupSeqIdPairs;

        public OrderIdShipGroupSeqIdPair[] getOtherOrderIdShipGroupSeqIdPairs() {
            return otherOrderIdShipGroupSeqIdPairs;
        }

        public void setOtherOrderIdShipGroupSeqIdPairs(OrderIdShipGroupSeqIdPair[] otherOrderIdShipGroupSeqIdPairs) {
            this.otherOrderIdShipGroupSeqIdPairs = otherOrderIdShipGroupSeqIdPairs;
        }

        /**
         * Origin Facility Id
         */
        private String originFacilityId;

        public String getOriginFacilityId() {
            return originFacilityId;
        }

        public void setOriginFacilityId(String originFacilityId) {
            this.originFacilityId = originFacilityId;
        }

        /**
         * Destination Facility Id
         */
        private String destinationFacilityId;

        public String getDestinationFacilityId() {
            return destinationFacilityId;
        }

        public void setDestinationFacilityId(String destinationFacilityId) {
            this.destinationFacilityId = destinationFacilityId;
        }

        /**
         * Origin Contact Mech Id
         */
        private String originContactMechId;

        public String getOriginContactMechId() {
            return originContactMechId;
        }

        public void setOriginContactMechId(String originContactMechId) {
            this.originContactMechId = originContactMechId;
        }

        /**
         * Destination Contact Mech Id
         */
        private String destinationContactMechId;

        public String getDestinationContactMechId() {
            return destinationContactMechId;
        }

        public void setDestinationContactMechId(String destinationContactMechId) {
            this.destinationContactMechId = destinationContactMechId;
        }

        /**
         * Handling Instructions
         */
        private String handlingInstructions;

        public String getHandlingInstructions() {
            return handlingInstructions;
        }

        public void setHandlingInstructions(String handlingInstructions) {
            this.handlingInstructions = handlingInstructions;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }


}

