﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public abstract class PhysicalInventoryLineCommandBase : IPhysicalInventoryLineCommand
	{
		public virtual InventoryItemId InventoryItemId { get; set; }


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

		public virtual decimal? BookQuantity { get; set; }

		public virtual decimal? CountedQuantity { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual long? ReversalLineNumber { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		// Outer Id:

		public virtual string PhysicalInventoryDocumentNumber { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreatePhysicalInventoryLine : PhysicalInventoryLineCommandBase, ICreatePhysicalInventoryLine
	{
		
		public CreatePhysicalInventoryLine ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchPhysicalInventoryLine :PhysicalInventoryLineCommandBase, IMergePatchPhysicalInventoryLine
	{

		public virtual bool IsPropertyBookQuantityRemoved { get; set; }

		public virtual bool IsPropertyCountedQuantityRemoved { get; set; }

		public virtual bool IsPropertyProcessedRemoved { get; set; }

		public virtual bool IsPropertyReversalLineNumberRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchPhysicalInventoryLine ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemovePhysicalInventoryLine : PhysicalInventoryLineCommandBase, IRemovePhysicalInventoryLine
	{
		public RemovePhysicalInventoryLine ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }
	}

}
