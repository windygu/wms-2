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

	public abstract class AttributeSetInstanceExtensionFieldCommandBase : IAttributeSetInstanceExtensionFieldCommand
	{
		public virtual string Index { get; set; }


		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual string Name { get; set; }

		public virtual string Type { get; set; }

		public virtual int? Length { get; set; }

		public virtual string Alias { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		// Outer Id:

		public virtual string GroupId { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateAttributeSetInstanceExtensionField : AttributeSetInstanceExtensionFieldCommandBase, ICreateAttributeSetInstanceExtensionField
	{
		
		public CreateAttributeSetInstanceExtensionField ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchAttributeSetInstanceExtensionField :AttributeSetInstanceExtensionFieldCommandBase, IMergePatchAttributeSetInstanceExtensionField
	{

		public virtual bool IsPropertyNameRemoved { get; set; }

		public virtual bool IsPropertyTypeRemoved { get; set; }

		public virtual bool IsPropertyLengthRemoved { get; set; }

		public virtual bool IsPropertyAliasRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchAttributeSetInstanceExtensionField ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemoveAttributeSetInstanceExtensionField : AttributeSetInstanceExtensionFieldCommandBase, IRemoveAttributeSetInstanceExtensionField
	{
		public RemoveAttributeSetInstanceExtensionField ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }
	}

}
