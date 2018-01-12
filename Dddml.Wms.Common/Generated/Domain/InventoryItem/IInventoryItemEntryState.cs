﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItem
{
	public interface IInventoryItemEntryState : IInventoryItemEntryStateProperties, 
		IGlobalIdentity<InventoryItemEntryId>, 
		ILocalIdentity<long>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IEntityVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		string CommandId { get; set; }

		void When(IInventoryItemEntryStateCreated e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

