﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentPackageDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentPackage;

namespace Dddml.Wms.Domain.ShipmentPackage
{

    public class ShipmentPackageStateEventDtoConverter
    {
        public virtual ShipmentPackageStateCreatedOrMergePatchedOrDeletedDto ToShipmentPackageStateEventDto(IShipmentPackageEvent stateEvent)
        {
            if (stateEvent.EventType == StateEventType.Created)
            {
                var e = (IShipmentPackageStateCreated)stateEvent;
                return ToShipmentPackageStateCreatedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.MergePatched)
            {
                var e = (IShipmentPackageStateMergePatched)stateEvent;
                return ToShipmentPackageStateMergePatchedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.Deleted)
            {
                var e = (IShipmentPackageStateDeleted)stateEvent;
                return ToShipmentPackageStateDeletedDto(e);
            }
            throw DomainError.Named("invalidEventType", String.Format("Invalid state event type: {0}", stateEvent.EventType));
        }

        public virtual ShipmentPackageStateCreatedDto ToShipmentPackageStateCreatedDto(IShipmentPackageStateCreated e)
        {
            var dto = new ShipmentPackageStateCreatedDto();
            dto.ShipmentPackageEventId = e.ShipmentPackageEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.ShipmentBoxTypeId = e.ShipmentBoxTypeId;
            dto.DateCreated = e.DateCreated;
            dto.BoxLength = e.BoxLength;
            dto.BoxHeight = e.BoxHeight;
            dto.BoxWidth = e.BoxWidth;
            dto.DimensionUomId = e.DimensionUomId;
            dto.Weight = e.Weight;
            dto.WeightUomId = e.WeightUomId;
            dto.InsuredValue = e.InsuredValue;
            dto.Active = e.Active;
            var shipmentPackageContentEvents = new List<ShipmentPackageContentStateCreatedDto>();
            foreach (var ee in e.ShipmentPackageContentEvents)
            {
                ShipmentPackageContentStateCreatedDto eeDto = ShipmentPackageContentStateEventDtoConverter.ToShipmentPackageContentStateCreatedDto(ee);
                shipmentPackageContentEvents.Add(eeDto);
            }
            dto.ShipmentPackageContentEvents = shipmentPackageContentEvents.ToArray();

            return dto;
        }

        public virtual ShipmentPackageStateMergePatchedDto ToShipmentPackageStateMergePatchedDto(IShipmentPackageStateMergePatched e)
        {
            var dto = new ShipmentPackageStateMergePatchedDto();
            dto.ShipmentPackageEventId = e.ShipmentPackageEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.ShipmentBoxTypeId = e.ShipmentBoxTypeId;
            dto.DateCreated = e.DateCreated;
            dto.BoxLength = e.BoxLength;
            dto.BoxHeight = e.BoxHeight;
            dto.BoxWidth = e.BoxWidth;
            dto.DimensionUomId = e.DimensionUomId;
            dto.Weight = e.Weight;
            dto.WeightUomId = e.WeightUomId;
            dto.InsuredValue = e.InsuredValue;
            dto.Active = e.Active;
            dto.IsPropertyShipmentBoxTypeIdRemoved = e.IsPropertyShipmentBoxTypeIdRemoved;
            dto.IsPropertyDateCreatedRemoved = e.IsPropertyDateCreatedRemoved;
            dto.IsPropertyBoxLengthRemoved = e.IsPropertyBoxLengthRemoved;
            dto.IsPropertyBoxHeightRemoved = e.IsPropertyBoxHeightRemoved;
            dto.IsPropertyBoxWidthRemoved = e.IsPropertyBoxWidthRemoved;
            dto.IsPropertyDimensionUomIdRemoved = e.IsPropertyDimensionUomIdRemoved;
            dto.IsPropertyWeightRemoved = e.IsPropertyWeightRemoved;
            dto.IsPropertyWeightUomIdRemoved = e.IsPropertyWeightUomIdRemoved;
            dto.IsPropertyInsuredValueRemoved = e.IsPropertyInsuredValueRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            var shipmentPackageContentEvents = new List<ShipmentPackageContentStateCreatedOrMergePatchedOrRemovedDto>();
            foreach (var ee in e.ShipmentPackageContentEvents)
            {
                ShipmentPackageContentStateCreatedOrMergePatchedOrRemovedDto eeDto = ShipmentPackageContentStateEventDtoConverter.ToShipmentPackageContentStateEventDto(ee);
                shipmentPackageContentEvents.Add(eeDto);
            }
            dto.ShipmentPackageContentEvents = shipmentPackageContentEvents.ToArray();


            return dto;
        }


        public virtual ShipmentPackageStateDeletedDto ToShipmentPackageStateDeletedDto(IShipmentPackageStateDeleted e)
        {
            var dto = new ShipmentPackageStateDeletedDto();
            dto.ShipmentPackageEventId = e.ShipmentPackageEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            var shipmentPackageContentEvents = new List<ShipmentPackageContentStateRemovedDto>();
            foreach (var ee in e.ShipmentPackageContentEvents)
            {
                ShipmentPackageContentStateRemovedDto eeDto = ShipmentPackageContentStateEventDtoConverter.ToShipmentPackageContentStateRemovedDto(ee);
                shipmentPackageContentEvents.Add(eeDto);
            }
            dto.ShipmentPackageContentEvents = shipmentPackageContentEvents.ToArray();


            return dto;
        }

        protected virtual ShipmentPackageContentStateEventDtoConverter ShipmentPackageContentStateEventDtoConverter
        {
            get
            {
                return new ShipmentPackageContentStateEventDtoConverter();
            }
        }


    }


}
