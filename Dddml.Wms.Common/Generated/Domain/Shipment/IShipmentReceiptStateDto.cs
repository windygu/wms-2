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

    public interface IShipmentReceiptStateDto
    {
        string ReceiptSeqId
        {
            get;
            set;
        }

        string ProductId
        {
            get;
            set;
        }

        string ShipmentItemSeqId
        {
            get;
            set;
        }

        string RejectionReasonId
        {
            get;
            set;
        }

        string DamageStatusId
        {
            get;
            set;
        }

        string DamageReasonId
        {
            get;
            set;
        }

        string ItemDescription
        {
            get;
            set;
        }

        decimal? AcceptedQuantity
        {
            get;
            set;
        }

        decimal? RejectedQuantity
        {
            get;
            set;
        }

        decimal? DamagedQuantity
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

        IShipmentReceiptState ToShipmentReceiptState();

    }

}

