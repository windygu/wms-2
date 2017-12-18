﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEntryMvo;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItemEntryMvo
{

	public abstract class InventoryItemEntryMvoCommandBase : IInventoryItemEntryMvoCommand
	{
		public virtual InventoryItemEntryId InventoryItemEntryId { get; set; }


		InventoryItemEntryId IAggregateCommand<InventoryItemEntryId, long>.AggregateId
		{
			get
			{
				return this.InventoryItemEntryId;
			}
		}


		long IAggregateCommand<InventoryItemEntryId, long>.AggregateVersion
		{
			get
			{
				return this.InventoryItemVersion;
			}
		}

		public virtual long InventoryItemVersion { get; set; }

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

		public virtual decimal? QuantityOnHand { get; set; }

		public virtual decimal? QuantityInTransit { get; set; }

		public virtual decimal? QuantityReserved { get; set; }

		public virtual decimal? QuantityOccupied { get; set; }

		public virtual decimal? QuantityVirtual { get; set; }

		public virtual InventoryItemSourceVO Source { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual decimal? InventoryItemQuantityOnHand { get; set; }

		public virtual decimal? InventoryItemQuantityInTransit { get; set; }

		public virtual decimal? InventoryItemQuantityReserved { get; set; }

		public virtual decimal? InventoryItemQuantityOccupied { get; set; }

		public virtual decimal? InventoryItemQuantityVirtual { get; set; }

		public virtual string InventoryItemCreatedBy { get; set; }

		public virtual DateTime? InventoryItemCreatedAt { get; set; }

		public virtual string InventoryItemUpdatedBy { get; set; }

		public virtual DateTime? InventoryItemUpdatedAt { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateInventoryItemEntryMvo : InventoryItemEntryMvoCommandBase, ICreateInventoryItemEntryMvo
	{
		
		public CreateInventoryItemEntryMvo ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchInventoryItemEntryMvo :InventoryItemEntryMvoCommandBase, IMergePatchInventoryItemEntryMvo
	{

		public virtual bool IsPropertyQuantityOnHandRemoved { get; set; }

		public virtual bool IsPropertyQuantityInTransitRemoved { get; set; }

		public virtual bool IsPropertyQuantityReservedRemoved { get; set; }

		public virtual bool IsPropertyQuantityOccupiedRemoved { get; set; }

		public virtual bool IsPropertyQuantityVirtualRemoved { get; set; }

		public virtual bool IsPropertySourceRemoved { get; set; }

		public virtual bool IsPropertyVersionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemQuantityOnHandRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemQuantityInTransitRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemQuantityReservedRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemQuantityOccupiedRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemQuantityVirtualRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemCreatedByRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemCreatedAtRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemUpdatedByRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemUpdatedAtRemoved { get; set; }


		public MergePatchInventoryItemEntryMvo ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteInventoryItemEntryMvo : InventoryItemEntryMvoCommandBase, IDeleteInventoryItemEntryMvo
	{
		public DeleteInventoryItemEntryMvo ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }

	}

    public static partial class InventoryItemEntryMvoCommands
    {
    }

}
