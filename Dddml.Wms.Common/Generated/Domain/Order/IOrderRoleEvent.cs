﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{
	public interface IOrderRoleEvent : IEvent, IEventDto, IGlobalIdentity<OrderRoleEventId>, ICreated<string>
	{
		OrderRoleEventId OrderRoleEventId { get; }

        bool ReadOnly { get; set; }

		// Outer Id:
		//string OrderId { get; set; }

	}

    public interface IOrderRoleStateEvent : IOrderRoleEvent
    {
		long Version { get; set; }

		bool? Active { get; set; }

    }
   
	public interface IOrderRoleStateCreated : IOrderRoleStateEvent
	{
	
	}


	public interface IOrderRoleStateMergePatched : IOrderRoleStateEvent
	{
		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IOrderRoleStateRemoved : IOrderRoleStateEvent
	{
	}


}
