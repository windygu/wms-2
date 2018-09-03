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

    public interface IItemIssuanceStateDto
    {
        string ItemIssuanceSeqId
        {
            get;
            set;
        }

        string OrderId
        {
            get;
            set;
        }

        string OrderItemSeqId
        {
            get;
            set;
        }

        string ShipGroupSeqId
        {
            get;
            set;
        }

        string ProductId
        {
            get;
            set;
        }

        string LocatorId
        {
            get;
            set;
        }

        string AttributeSetInstanceId
        {
            get;
            set;
        }

        string ShipmentItemSeqId
        {
            get;
            set;
        }

        string FixedAssetId
        {
            get;
            set;
        }

        string MaintHistSeqId
        {
            get;
            set;
        }

        DateTime? IssuedDateTime
        {
            get;
            set;
        }

        string IssuedByUserLoginId
        {
            get;
            set;
        }

        decimal? Quantity
        {
            get;
            set;
        }

        decimal? CancelQuantity
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

        string ShipmentId
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

        IItemIssuanceState ToItemIssuanceState();

    }

}

