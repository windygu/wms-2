﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public static partial class OrganizationStructureTypeStateDtoExtensions
	{

        public static IOrganizationStructureTypeCommand ToCreateOrMergePatchOrganizationStructureType(this OrganizationStructureTypeStateDto state)
        {
            return state.ToCreateOrMergePatchOrganizationStructureType<CreateOrganizationStructureTypeDto, MergePatchOrganizationStructureTypeDto>();
        }

        public static DeleteOrganizationStructureTypeDto ToDeleteOrganizationStructureType(this OrganizationStructureTypeStateDto state)
        {
            return state.ToDeleteOrganizationStructureType<DeleteOrganizationStructureTypeDto>();
        }

        public static MergePatchOrganizationStructureTypeDto ToMergePatchOrganizationStructureType(this OrganizationStructureTypeStateDto state)
        {
            return state.ToMergePatchOrganizationStructureType<MergePatchOrganizationStructureTypeDto>();
        }

        public static CreateOrganizationStructureTypeDto ToCreateOrganizationStructureType(this OrganizationStructureTypeStateDto state)
        {
            return state.ToCreateOrganizationStructureType<CreateOrganizationStructureTypeDto>();
        }
		

	}

}

