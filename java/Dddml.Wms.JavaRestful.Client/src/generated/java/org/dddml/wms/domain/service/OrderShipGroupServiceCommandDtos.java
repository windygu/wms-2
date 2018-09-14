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
    
    public static class CreatePOShipGroupDto {

        /**
         * Order Id
         */
        private String orderId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Ship Group Seq Id
         */
        private String shipGroupSeqId;

        public String getShipGroupSeqId() {
            return shipGroupSeqId;
        }

        public void setShipGroupSeqId(String shipGroupSeqId) {
            this.shipGroupSeqId = shipGroupSeqId;
        }

        /**
         * Estimated Delivery Date
         */
        private java.sql.Timestamp estimatedDeliveryDate;

        public java.sql.Timestamp getEstimatedDeliveryDate() {
            return estimatedDeliveryDate;
        }

        public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate) {
            this.estimatedDeliveryDate = estimatedDeliveryDate;
        }

        /**
         * Contact Party Id
         */
        private String contactPartyId;

        public String getContactPartyId() {
            return contactPartyId;
        }

        public void setContactPartyId(String contactPartyId) {
            this.contactPartyId = contactPartyId;
        }

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
         * Tracking Number
         */
        private String trackingNumber;

        public String getTrackingNumber() {
            return trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
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

    public static class CreateSOShipGroupDto {

        /**
         * Order Id
         */
        private String orderId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Ship Group Seq Id
         */
        private String shipGroupSeqId;

        public String getShipGroupSeqId() {
            return shipGroupSeqId;
        }

        public void setShipGroupSeqId(String shipGroupSeqId) {
            this.shipGroupSeqId = shipGroupSeqId;
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
         * Contact Party Id
         */
        private String contactPartyId;

        public String getContactPartyId() {
            return contactPartyId;
        }

        public void setContactPartyId(String contactPartyId) {
            this.contactPartyId = contactPartyId;
        }

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
         * Tracking Number
         */
        private String trackingNumber;

        public String getTrackingNumber() {
            return trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
        }

        /**
         * Vehicle Plate Number
         */
        private String vehiclePlateNumber;

        public String getVehiclePlateNumber() {
            return vehiclePlateNumber;
        }

        public void setVehiclePlateNumber(String vehiclePlateNumber) {
            this.vehiclePlateNumber = vehiclePlateNumber;
        }

        /**
         * Shipping Instructions
         */
        private String shippingInstructions;

        public String getShippingInstructions() {
            return shippingInstructions;
        }

        public void setShippingInstructions(String shippingInstructions) {
            this.shippingInstructions = shippingInstructions;
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
         * Order Id
         */
        private String orderId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Ship Group Seq Id
         */
        private String shipGroupSeqId;

        public String getShipGroupSeqId() {
            return shipGroupSeqId;
        }

        public void setShipGroupSeqId(String shipGroupSeqId) {
            this.shipGroupSeqId = shipGroupSeqId;
        }

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

    public static class ShipDto {

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

