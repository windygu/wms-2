﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{
	public interface IPhysicalInventoryState : IPhysicalInventoryStateProperties, 
		IGlobalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IPhysicalInventoryStateCreated e);

		void When(IPhysicalInventoryStateMergePatched e);

		void Mutate(IEvent e);


		IPhysicalInventoryLineStates PhysicalInventoryLines { get; set; }


        bool IsUnsaved { get; }

	}

}

