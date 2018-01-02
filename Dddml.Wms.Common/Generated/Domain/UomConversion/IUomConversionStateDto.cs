﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomConversionDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomConversion;

namespace Dddml.Wms.Domain.UomConversion
{

    public interface IUomConversionStateDto
    {

        UomConversionIdDto UomConversionId
        {
            get;
            set;
        }

        double? ConversionFactor
        {
            get;
            set;
        }

        string CustomMethodId
        {
            get;
            set;
        }

        long? DecimalScale
        {
            get;
            set;
        }

        string RoundingMode
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

        IUomConversionState ToUomConversionState();

    }

}
