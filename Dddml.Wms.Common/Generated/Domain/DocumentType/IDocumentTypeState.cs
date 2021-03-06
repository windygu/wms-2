﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDocumentTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.DocumentType;

namespace Dddml.Wms.Domain.DocumentType
{
	public interface IDocumentTypeState : IDocumentTypeStateProperties, 
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

		void When(IDocumentTypeStateCreated e);

		void When(IDocumentTypeStateMergePatched e);

		void When(IDocumentTypeStateDeleted e);

		void Mutate(IEvent e);


        bool IsUnsaved { get; }

	}

}

