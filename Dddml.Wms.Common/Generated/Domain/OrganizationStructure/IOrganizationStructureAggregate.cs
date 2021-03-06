﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationStructureDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrganizationStructure;

namespace Dddml.Wms.Domain.OrganizationStructure
{

	public partial interface IOrganizationStructureAggregate : IGlobalIdentity<OrganizationStructureId>
	{
		IOrganizationStructureState State { get; }

		IList<IEvent> Changes { get; }

		void ThrowOnInvalidStateTransition (ICommand c);

		void Create (ICreateOrganizationStructure c);

		void MergePatch (IMergePatchOrganizationStructure c);

		void Delete (IDeleteOrganizationStructure c);


	}

}

