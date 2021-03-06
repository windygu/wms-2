﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{

    public class OrderShipGroupStateEventDtoConverter
    {
        public virtual OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto ToOrderShipGroupStateEventDto(IOrderShipGroupEvent stateEvent)
        {
            if (stateEvent.EventType == StateEventType.Created)
            {
                var e = (IOrderShipGroupStateCreated)stateEvent;
                return ToOrderShipGroupStateCreatedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.MergePatched)
            {
                var e = (IOrderShipGroupStateMergePatched)stateEvent;
                return ToOrderShipGroupStateMergePatchedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.Removed)
            {
                var e = (IOrderShipGroupStateRemoved)stateEvent;
                return ToOrderShipGroupStateRemovedDto(e);
            }
            throw DomainError.Named("invalidEventType", String.Format("Invalid state event type: {0}", stateEvent.EventType));
        }

        public virtual OrderShipGroupStateCreatedDto ToOrderShipGroupStateCreatedDto(IOrderShipGroupStateCreated e)
        {
            var dto = new OrderShipGroupStateCreatedDto();
            dto.OrderShipGroupEventId = e.OrderShipGroupEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.Version = e.Version;
            dto.CommandId = e.CommandId;
            dto.ShipmentMethodTypeId = e.ShipmentMethodTypeId;
            dto.SupplierPartyId = e.SupplierPartyId;
            dto.VendorPartyId = e.VendorPartyId;
            dto.CarrierPartyId = e.CarrierPartyId;
            dto.CarrierRoleTypeId = e.CarrierRoleTypeId;
            dto.FacilityId = e.FacilityId;
            dto.DestinationFacilityId = e.DestinationFacilityId;
            dto.ContactMechId = e.ContactMechId;
            dto.TelecomContactMechId = e.TelecomContactMechId;
            dto.TrackingNumber = e.TrackingNumber;
            dto.ContactPartyId = e.ContactPartyId;
            dto.VehiclePlateNumber = e.VehiclePlateNumber;
            dto.ShippingInstructions = e.ShippingInstructions;
            dto.MaySplit = e.MaySplit;
            dto.GiftMessage = e.GiftMessage;
            dto.IsGift = e.IsGift;
            dto.ShipAfterDate = e.ShipAfterDate;
            dto.ShipByDate = e.ShipByDate;
            dto.EstimatedShipDate = e.EstimatedShipDate;
            dto.EstimatedDeliveryDate = e.EstimatedDeliveryDate;
            dto.PickwaveId = e.PickwaveId;
            dto.NumberOfPackages = e.NumberOfPackages;
            dto.NumberOfContainers = e.NumberOfContainers;
            dto.NumberOfPakagesPerContainer = e.NumberOfPakagesPerContainer;
            dto.OrderShipGroupStatusId = e.OrderShipGroupStatusId;
            dto.Active = e.Active;
            var orderItemShipGroupAssociationEvents = new List<OrderItemShipGroupAssociationStateCreatedDto>();
            foreach (var ee in e.OrderItemShipGroupAssociationEvents)
            {
                OrderItemShipGroupAssociationStateCreatedDto eeDto = OrderItemShipGroupAssociationStateEventDtoConverter.ToOrderItemShipGroupAssociationStateCreatedDto(ee);
                orderItemShipGroupAssociationEvents.Add(eeDto);
            }
            dto.OrderItemShipGroupAssociationEvents = orderItemShipGroupAssociationEvents.ToArray();

            return dto;
        }

        public virtual OrderShipGroupStateMergePatchedDto ToOrderShipGroupStateMergePatchedDto(IOrderShipGroupStateMergePatched e)
        {
            var dto = new OrderShipGroupStateMergePatchedDto();
            dto.OrderShipGroupEventId = e.OrderShipGroupEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.Version = e.Version;
            dto.CommandId = e.CommandId;
            dto.ShipmentMethodTypeId = e.ShipmentMethodTypeId;
            dto.SupplierPartyId = e.SupplierPartyId;
            dto.VendorPartyId = e.VendorPartyId;
            dto.CarrierPartyId = e.CarrierPartyId;
            dto.CarrierRoleTypeId = e.CarrierRoleTypeId;
            dto.FacilityId = e.FacilityId;
            dto.DestinationFacilityId = e.DestinationFacilityId;
            dto.ContactMechId = e.ContactMechId;
            dto.TelecomContactMechId = e.TelecomContactMechId;
            dto.TrackingNumber = e.TrackingNumber;
            dto.ContactPartyId = e.ContactPartyId;
            dto.VehiclePlateNumber = e.VehiclePlateNumber;
            dto.ShippingInstructions = e.ShippingInstructions;
            dto.MaySplit = e.MaySplit;
            dto.GiftMessage = e.GiftMessage;
            dto.IsGift = e.IsGift;
            dto.ShipAfterDate = e.ShipAfterDate;
            dto.ShipByDate = e.ShipByDate;
            dto.EstimatedShipDate = e.EstimatedShipDate;
            dto.EstimatedDeliveryDate = e.EstimatedDeliveryDate;
            dto.PickwaveId = e.PickwaveId;
            dto.NumberOfPackages = e.NumberOfPackages;
            dto.NumberOfContainers = e.NumberOfContainers;
            dto.NumberOfPakagesPerContainer = e.NumberOfPakagesPerContainer;
            dto.OrderShipGroupStatusId = e.OrderShipGroupStatusId;
            dto.Active = e.Active;
            dto.IsPropertyShipmentMethodTypeIdRemoved = e.IsPropertyShipmentMethodTypeIdRemoved;
            dto.IsPropertySupplierPartyIdRemoved = e.IsPropertySupplierPartyIdRemoved;
            dto.IsPropertyVendorPartyIdRemoved = e.IsPropertyVendorPartyIdRemoved;
            dto.IsPropertyCarrierPartyIdRemoved = e.IsPropertyCarrierPartyIdRemoved;
            dto.IsPropertyCarrierRoleTypeIdRemoved = e.IsPropertyCarrierRoleTypeIdRemoved;
            dto.IsPropertyFacilityIdRemoved = e.IsPropertyFacilityIdRemoved;
            dto.IsPropertyDestinationFacilityIdRemoved = e.IsPropertyDestinationFacilityIdRemoved;
            dto.IsPropertyContactMechIdRemoved = e.IsPropertyContactMechIdRemoved;
            dto.IsPropertyTelecomContactMechIdRemoved = e.IsPropertyTelecomContactMechIdRemoved;
            dto.IsPropertyTrackingNumberRemoved = e.IsPropertyTrackingNumberRemoved;
            dto.IsPropertyContactPartyIdRemoved = e.IsPropertyContactPartyIdRemoved;
            dto.IsPropertyVehiclePlateNumberRemoved = e.IsPropertyVehiclePlateNumberRemoved;
            dto.IsPropertyShippingInstructionsRemoved = e.IsPropertyShippingInstructionsRemoved;
            dto.IsPropertyMaySplitRemoved = e.IsPropertyMaySplitRemoved;
            dto.IsPropertyGiftMessageRemoved = e.IsPropertyGiftMessageRemoved;
            dto.IsPropertyIsGiftRemoved = e.IsPropertyIsGiftRemoved;
            dto.IsPropertyShipAfterDateRemoved = e.IsPropertyShipAfterDateRemoved;
            dto.IsPropertyShipByDateRemoved = e.IsPropertyShipByDateRemoved;
            dto.IsPropertyEstimatedShipDateRemoved = e.IsPropertyEstimatedShipDateRemoved;
            dto.IsPropertyEstimatedDeliveryDateRemoved = e.IsPropertyEstimatedDeliveryDateRemoved;
            dto.IsPropertyPickwaveIdRemoved = e.IsPropertyPickwaveIdRemoved;
            dto.IsPropertyNumberOfPackagesRemoved = e.IsPropertyNumberOfPackagesRemoved;
            dto.IsPropertyNumberOfContainersRemoved = e.IsPropertyNumberOfContainersRemoved;
            dto.IsPropertyNumberOfPakagesPerContainerRemoved = e.IsPropertyNumberOfPakagesPerContainerRemoved;
            dto.IsPropertyOrderShipGroupStatusIdRemoved = e.IsPropertyOrderShipGroupStatusIdRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            var orderItemShipGroupAssociationEvents = new List<OrderItemShipGroupAssociationStateCreatedOrMergePatchedOrRemovedDto>();
            foreach (var ee in e.OrderItemShipGroupAssociationEvents)
            {
                OrderItemShipGroupAssociationStateCreatedOrMergePatchedOrRemovedDto eeDto = OrderItemShipGroupAssociationStateEventDtoConverter.ToOrderItemShipGroupAssociationStateEventDto(ee);
                orderItemShipGroupAssociationEvents.Add(eeDto);
            }
            dto.OrderItemShipGroupAssociationEvents = orderItemShipGroupAssociationEvents.ToArray();


            return dto;
        }


        public virtual OrderShipGroupStateRemovedDto ToOrderShipGroupStateRemovedDto(IOrderShipGroupStateRemoved e)
        {
            var dto = new OrderShipGroupStateRemovedDto();
            dto.OrderShipGroupEventId = e.OrderShipGroupEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.Version = e.Version;
            dto.CommandId = e.CommandId;
            var orderItemShipGroupAssociationEvents = new List<OrderItemShipGroupAssociationStateRemovedDto>();
            foreach (var ee in e.OrderItemShipGroupAssociationEvents)
            {
                OrderItemShipGroupAssociationStateRemovedDto eeDto = OrderItemShipGroupAssociationStateEventDtoConverter.ToOrderItemShipGroupAssociationStateRemovedDto(ee);
                orderItemShipGroupAssociationEvents.Add(eeDto);
            }
            dto.OrderItemShipGroupAssociationEvents = orderItemShipGroupAssociationEvents.ToArray();


            return dto;
        }

        protected virtual OrderItemShipGroupAssociationStateEventDtoConverter OrderItemShipGroupAssociationStateEventDtoConverter
        {
            get
            {
                return new OrderItemShipGroupAssociationStateEventDtoConverter();
            }
        }


    }


}

