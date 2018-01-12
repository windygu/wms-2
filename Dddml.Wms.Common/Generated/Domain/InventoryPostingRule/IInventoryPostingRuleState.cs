﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPostingRuleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPostingRule
{
	public interface IInventoryPostingRuleState : IInventoryPostingRuleStateProperties, 
		IGlobalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IInventoryPostingRuleStateCreated e);

		void When(IInventoryPostingRuleStateMergePatched e);

		void When(IInventoryPostingRuleStateDeleted e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

