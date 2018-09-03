﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistBinDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistBin;

namespace Dddml.Wms.Domain.PicklistBin
{

    public interface IPicklistBinStateDto
    {
        string PicklistBinId
        {
            get;
            set;
        }

        string PicklistId
        {
            get;
            set;
        }

        long? BinLocationNumber
        {
            get;
            set;
        }

        string PrimaryOrderId
        {
            get;
            set;
        }

        string PrimaryShipGroupSeqId
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

        IPicklistItemStateDto[] PicklistItems
        {
            get;
            set;
        }

        IPicklistBinState ToPicklistBinState();

    }

}

