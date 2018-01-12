﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderShipment;

namespace Dddml.Wms.Domain.OrderShipment
{
	public interface IOrderShipmentState : IOrderShipmentStateProperties, 
		IGlobalIdentity<OrderShipmentId>, 
		ICreated<string>, 
		IUpdated<string>, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IOrderShipmentStateCreated e);

		void When(IOrderShipmentStateMergePatched e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

