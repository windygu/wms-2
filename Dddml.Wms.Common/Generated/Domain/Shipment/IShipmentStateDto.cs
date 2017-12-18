﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

    public interface IShipmentStateDto
    {
        string ShipmentId
        {
            get;
            set;
        }

        string ShipmentTypeId
        {
            get;
            set;
        }

        string StatusId
        {
            get;
            set;
        }

        string PrimaryOrderId
        {
            get;
            set;
        }

        string PrimaryReturnId
        {
            get;
            set;
        }

        string PicklistBinId
        {
            get;
            set;
        }

        DateTime? EstimatedReadyDate
        {
            get;
            set;
        }

        DateTime? EstimatedShipDate
        {
            get;
            set;
        }

        string EstimatedShipWorkEffId
        {
            get;
            set;
        }

        DateTime? EstimatedArrivalDate
        {
            get;
            set;
        }

        string EstimatedArrivalWorkEffId
        {
            get;
            set;
        }

        DateTime? LatestCancelDate
        {
            get;
            set;
        }

        decimal? EstimatedShipCost
        {
            get;
            set;
        }

        string CurrencyUomId
        {
            get;
            set;
        }

        string HandlingInstructions
        {
            get;
            set;
        }

        string OriginFacilityId
        {
            get;
            set;
        }

        string DestinationFacilityId
        {
            get;
            set;
        }

        string OriginContactMechId
        {
            get;
            set;
        }

        string OriginTelecomNumberId
        {
            get;
            set;
        }

        string DestinationContactMechId
        {
            get;
            set;
        }

        string DestinationTelecomNumberId
        {
            get;
            set;
        }

        string PartyIdTo
        {
            get;
            set;
        }

        string PartyIdFrom
        {
            get;
            set;
        }

        decimal? AdditionalShippingCharge
        {
            get;
            set;
        }

        string AddtlShippingChargeDesc
        {
            get;
            set;
        }

        bool? Active
        {
            get;
            set;
        }

        long? Version
        {
            get;
            set;
        }

        string CreatedBy
        {
            get;
            set;
        }

        DateTime? CreatedAt
        {
            get;
            set;
        }

        string UpdatedBy
        {
            get;
            set;
        }

        DateTime? UpdatedAt
        {
            get;
            set;
        }

        IShipmentItemStateDto[] ShipmentItems
        {
            get;
            set;
        }

        IShipmentState ToShipmentState();

    }

}

