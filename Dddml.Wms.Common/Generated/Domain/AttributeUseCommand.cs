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

	public abstract class AttributeUseCommandBase : IAttributeUseCommand
	{
		public virtual string AttributeId { get; set; }


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

		public virtual int? SequenceNumber { get; set; }

		public virtual bool? Active { get; set; }

		// Outer Id:

		public virtual string AttributeSetId { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateAttributeUse : AttributeUseCommandBase, ICreateAttributeUse
	{
		
		public CreateAttributeUse ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchAttributeUse :AttributeUseCommandBase, IMergePatchAttributeUse
	{

		public virtual bool IsPropertySequenceNumberRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchAttributeUse ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemoveAttributeUse : AttributeUseCommandBase, IRemoveAttributeUse
	{
		public RemoveAttributeUse ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }
	}

}
