﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationStructureTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrganizationStructureType;

namespace Dddml.Wms.Domain.OrganizationStructureType
{
	public interface IOrganizationStructureTypeCommand : IAggregateCommand<string, long>, ICommandDto
	{
		long Version { get; set; }

		string Id { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteOrganizationStructureType : IOrganizationStructureTypeCommand
	{

		string Description { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateOrganizationStructureType : ICreateOrMergePatchOrDeleteOrganizationStructureType
	{
	}

	public interface IMergePatchOrganizationStructureType : ICreateOrMergePatchOrDeleteOrganizationStructureType
	{

		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IDeleteOrganizationStructureType : ICreateOrMergePatchOrDeleteOrganizationStructureType
	{
	}


}

