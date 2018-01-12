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
	public interface IOrderItemMvoState : IOrderItemMvoStateProperties, 
		IGlobalIdentity<OrderItemId>, 
		ICreated<string>, 
		IUpdated<string>, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IOrderItemMvoStateCreated e);

		void When(IOrderItemMvoStateMergePatched e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

