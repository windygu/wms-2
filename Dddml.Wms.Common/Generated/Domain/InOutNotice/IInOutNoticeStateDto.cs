﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{

    public interface IInOutNoticeStateDto
    {
        string InOutNoticeId
        {
            get;
            set;
        }

        string WarehouseId
        {
            get;
            set;
        }

        string InOutNoticeType
        {
            get;
            set;
        }

        string TelecomContactMechId
        {
            get;
            set;
        }

        string TrackingNumber
        {
            get;
            set;
        }

        string ContactPartyId
        {
            get;
            set;
        }

        string VehiclePlateNumber
        {
            get;
            set;
        }

        string ShippingInstructions
        {
            get;
            set;
        }

        DateTime? EstimatedShipDate
        {
            get;
            set;
        }

        DateTime? EstimatedDeliveryDate
        {
            get;
            set;
        }

        string StatusId
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

        IInOutNoticeState ToInOutNoticeState();

    }

}

