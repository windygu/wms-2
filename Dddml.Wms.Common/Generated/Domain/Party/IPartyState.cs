﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePartyDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Party;

namespace Dddml.Wms.Domain.Party
{
	public interface IPartyState : IPartyStateProperties, 
		IGlobalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IPartyStateCreated e);

		void When(IPartyStateMergePatched e);

		void When(IPartyStateDeleted e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

    public interface IOrganizationState : IPartyState
    {
    }

    public interface IPersonState : IPartyState
    {
    }

}

