﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateItemIssuanceMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ItemIssuanceMvo;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.ItemIssuanceMvo
{

    public partial interface IItemIssuanceMvoApplicationServiceFactory
    {

        IItemIssuanceMvoApplicationService ItemIssuanceMvoApplicationService { get; }

        ICreateItemIssuanceMvo NewCreateItemIssuanceMvo();

        IMergePatchItemIssuanceMvo NewMergePatchItemIssuanceMvo();

        IDeleteItemIssuanceMvo NewDeleteItemIssuanceMvo();
    }


}
