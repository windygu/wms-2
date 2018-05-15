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
	public interface IItemIssuanceState : IItemIssuanceStateProperties, 
		IGlobalIdentity<ShipmentItemIssuanceId>, 
		ILocalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IActive, 
		IEntityVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IItemIssuanceStateCreated e);

		void When(IItemIssuanceStateMergePatched e);

		void When(IItemIssuanceStateRemoved e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}
