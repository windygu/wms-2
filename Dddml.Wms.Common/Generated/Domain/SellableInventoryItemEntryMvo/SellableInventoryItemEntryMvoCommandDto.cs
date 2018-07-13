﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItemEntryMvo;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItemEntryMvo
{

	public abstract class SellableInventoryItemEntryMvoCommandDtoBase : ICommandDto, ICreateSellableInventoryItemEntryMvo, IMergePatchSellableInventoryItemEntryMvo, IDeleteSellableInventoryItemEntryMvo
	{

		SellableInventoryItemEntryId IAggregateCommand<SellableInventoryItemEntryId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteSellableInventoryItemEntryMvo)this).SellableInventoryItemEntryId;
			}
		}


		long IAggregateCommand<SellableInventoryItemEntryId, long>.AggregateVersion
		{
			get
			{
				return this.SellableInventoryItemVersion != null ? this.SellableInventoryItemVersion.Value : default(long);
			}
		}

        long ISellableInventoryItemEntryMvoCommand.SellableInventoryItemVersion
        {
            get { return this.SellableInventoryItemVersion != null ? this.SellableInventoryItemVersion.Value : default(long); }
            set { this.SellableInventoryItemVersion = value; }
        }

		public virtual long? SellableInventoryItemVersion { get; set; }

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

		public virtual SellableInventoryItemEntryId SellableInventoryItemEntryId { get; set; }

		public virtual decimal? SellableQuantity { get; set; }

		public virtual InventoryPRTriggeredId SourceEventId { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual decimal? SellableInventoryItemSellableQuantity { get; set; }

		public virtual string SellableInventoryItemCreatedBy { get; set; }

		public virtual DateTime? SellableInventoryItemCreatedAt { get; set; }

		public virtual string SellableInventoryItemUpdatedBy { get; set; }

		public virtual DateTime? SellableInventoryItemUpdatedAt { get; set; }

		public virtual bool? IsPropertySellableQuantityRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySellableQuantityRemoved
        {
            get
            {
                var b = this.IsPropertySellableQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySellableQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertySourceEventIdRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySourceEventIdRemoved
        {
            get
            {
                var b = this.IsPropertySourceEventIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySourceEventIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertyVersionRemoved
        {
            get
            {
                var b = this.IsPropertyVersionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVersionRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertySellableInventoryItemSellableQuantityRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySellableInventoryItemSellableQuantityRemoved
        {
            get
            {
                var b = this.IsPropertySellableInventoryItemSellableQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySellableInventoryItemSellableQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertySellableInventoryItemCreatedByRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySellableInventoryItemCreatedByRemoved
        {
            get
            {
                var b = this.IsPropertySellableInventoryItemCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySellableInventoryItemCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertySellableInventoryItemCreatedAtRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySellableInventoryItemCreatedAtRemoved
        {
            get
            {
                var b = this.IsPropertySellableInventoryItemCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySellableInventoryItemCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertySellableInventoryItemUpdatedByRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySellableInventoryItemUpdatedByRemoved
        {
            get
            {
                var b = this.IsPropertySellableInventoryItemUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySellableInventoryItemUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertySellableInventoryItemUpdatedAtRemoved { get; set; }

        bool IMergePatchSellableInventoryItemEntryMvo.IsPropertySellableInventoryItemUpdatedAtRemoved
        {
            get
            {
                var b = this.IsPropertySellableInventoryItemUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySellableInventoryItemUpdatedAtRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteSellableInventoryItemEntryMvoDto : SellableInventoryItemEntryMvoCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateSellableInventoryItemEntryMvoDto : CreateOrMergePatchOrDeleteSellableInventoryItemEntryMvoDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchSellableInventoryItemEntryMvoDto : CreateOrMergePatchOrDeleteSellableInventoryItemEntryMvoDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteSellableInventoryItemEntryMvoDto : CreateOrMergePatchOrDeleteSellableInventoryItemEntryMvoDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class SellableInventoryItemEntryMvoCommandDtos
    {

    }

}

