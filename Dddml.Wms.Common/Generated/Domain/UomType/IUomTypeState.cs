﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomType;

namespace Dddml.Wms.Domain.UomType
{
	public interface IUomTypeState : IUomTypeStateProperties, 
		IGlobalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IActive, 
		IAggregateVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		string CommandId { get; set; }

		void When(IUomTypeStateCreated e);

		void When(IUomTypeStateMergePatched e);

		void When(IUomTypeStateDeleted e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

