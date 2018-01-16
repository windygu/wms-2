﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSet;

namespace Dddml.Wms.Domain.AttributeSet
{
	public interface IAttributeUseState : IAttributeUseStateProperties, 
		IGlobalIdentity<AttributeSetAttributeUseId>, 
		ILocalIdentity<string>, 
		ICreated<string>, 
		IUpdated<string>, 
		IDeleted, 
		IActive, 
		IEntityVersioned<long>,
		IState
	{

		bool ForReapplying { get; }

		void When(IAttributeUseStateCreated e);

		void When(IAttributeUseStateMergePatched e);

		void When(IAttributeUseStateRemoved e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

