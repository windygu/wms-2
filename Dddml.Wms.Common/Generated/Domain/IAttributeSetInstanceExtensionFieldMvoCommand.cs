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
	public interface IAttributeSetInstanceExtensionFieldMvoCommand : IAggregateCommand<AttributeSetInstanceExtensionFieldId, long>, ICommandDto
	{
		long AttrSetInstEFGroupVersion { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldMvo : IAttributeSetInstanceExtensionFieldMvoCommand
	{
		AttributeSetInstanceExtensionFieldId AttributeSetInstanceExtensionFieldId { get; set; }

		string Name { get; set; }

		string Type { get; set; }

		int? Length { get; set; }

		string Alias { get; set; }

		string Description { get; set; }

		long? Version { get; set; }

		bool? Active { get; set; }

		string AttrSetInstEFGroupFieldType { get; set; }

		int? AttrSetInstEFGroupFieldLength { get; set; }

		int? AttrSetInstEFGroupFieldCount { get; set; }

		string AttrSetInstEFGroupNameFormat { get; set; }

		string AttrSetInstEFGroupDescription { get; set; }

		string AttrSetInstEFGroupCreatedBy { get; set; }

		DateTime? AttrSetInstEFGroupCreatedAt { get; set; }

		string AttrSetInstEFGroupUpdatedBy { get; set; }

		DateTime? AttrSetInstEFGroupUpdatedAt { get; set; }

		bool? AttrSetInstEFGroupActive { get; set; }

		bool? AttrSetInstEFGroupDeleted { get; set; }


	}

	public interface ICreateAttributeSetInstanceExtensionFieldMvo : ICreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldMvo
	{
	}

	public interface IMergePatchAttributeSetInstanceExtensionFieldMvo : ICreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldMvo
	{

		bool IsPropertyNameRemoved { get; set; }

		bool IsPropertyTypeRemoved { get; set; }

		bool IsPropertyLengthRemoved { get; set; }

		bool IsPropertyAliasRemoved { get; set; }

		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyVersionRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupFieldTypeRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupFieldLengthRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupFieldCountRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupNameFormatRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupDescriptionRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupCreatedByRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupCreatedAtRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupUpdatedByRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupUpdatedAtRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupActiveRemoved { get; set; }

		bool IsPropertyAttrSetInstEFGroupDeletedRemoved { get; set; }


	}

	public interface IDeleteAttributeSetInstanceExtensionFieldMvo : ICreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldMvo
	{
	}


}

