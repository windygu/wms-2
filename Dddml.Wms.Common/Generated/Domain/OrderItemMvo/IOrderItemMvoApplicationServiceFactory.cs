﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderItemMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderItemMvo;
using Dddml.Wms.Domain.Order;

namespace Dddml.Wms.Domain.OrderItemMvo
{

    public partial interface IOrderItemMvoApplicationServiceFactory
    {

        IOrderItemMvoApplicationService OrderItemMvoApplicationService { get; }

        ICreateOrderItemMvo NewCreateOrderItemMvo();

        IMergePatchOrderItemMvo NewMergePatchOrderItemMvo();

        IDeleteOrderItemMvo NewDeleteOrderItemMvo();
    }


}

