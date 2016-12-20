﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using NodaMoney;

namespace Dddml.Wms.Domain
{
	public interface IInOutState : IInOutStateProperties, 
		IGlobalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IInOutStateCreated e);

		void When(IInOutStateMergePatched e);

		void When(IInOutStateDeleted e);

		void Mutate(IEvent e);


		IInOutLineStates InOutLines { get; set; }


        bool IsUnsaved { get; }

	}
}

