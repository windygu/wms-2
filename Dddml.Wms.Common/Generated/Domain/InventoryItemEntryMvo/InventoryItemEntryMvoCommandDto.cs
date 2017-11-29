﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEntryMvo;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItemEntryMvo
{

	public abstract class InventoryItemEntryMvoCommandDtoBase : ICommandDto, ICreateInventoryItemEntryMvo, IMergePatchInventoryItemEntryMvo, IDeleteInventoryItemEntryMvo
	{

		InventoryItemEntryId IAggregateCommand<InventoryItemEntryId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteInventoryItemEntryMvo)this).InventoryItemEntryId;
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

		public virtual InventoryItemEntryIdDto InventoryItemEntryId { get; set; }

		public virtual decimal? QuantityOnHand { get; set; }

		public virtual decimal? QuantityReserved { get; set; }

		public virtual decimal? QuantityOccupied { get; set; }

		public virtual decimal? QuantityVirtual { get; set; }


		public virtual InventoryItemSourceVODto Source { get; set; }

        InventoryItemSourceVO ICreateOrMergePatchOrDeleteInventoryItemEntryMvo.Source
        {
            get 
            {
                return (this.Source == null) ? null : this.Source.ToInventoryItemSourceVO();
            }
            set 
            {
                this.Source = (value == null) ? null : new InventoryItemSourceVODtoWrapper(value);
            }
        }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual decimal? InventoryItemQuantityOnHand { get; set; }

		public virtual decimal? InventoryItemQuantityReserved { get; set; }

		public virtual decimal? InventoryItemQuantityOccupied { get; set; }

		public virtual decimal? InventoryItemQuantityVirtual { get; set; }

		public virtual string InventoryItemCreatedBy { get; set; }

		public virtual DateTime? InventoryItemCreatedAt { get; set; }

		public virtual string InventoryItemUpdatedBy { get; set; }

		public virtual DateTime? InventoryItemUpdatedAt { get; set; }


        InventoryItemEntryId IInventoryItemEntryMvoCommand.InventoryItemEntryId
        {
            get 
            {
                return this.InventoryItemEntryId.ToInventoryItemEntryId();
            }
            set 
            {
                this.InventoryItemEntryId = new InventoryItemEntryIdDtoWrapper(value);
            }
        }

		public virtual bool? IsPropertyQuantityOnHandRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyQuantityOnHandRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityOnHandRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityOnHandRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityReservedRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyQuantityReservedRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityReservedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityReservedRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityOccupiedRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyQuantityOccupiedRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityOccupiedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityOccupiedRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityVirtualRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyQuantityVirtualRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityVirtualRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityVirtualRemoved = value;
            }
        }

		public virtual bool? IsPropertySourceRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertySourceRemoved
        {
            get
            {
                var b = this.IsPropertySourceRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySourceRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyVersionRemoved
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

        bool IMergePatchInventoryItemEntryMvo.IsPropertyActiveRemoved
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

		public virtual bool? IsPropertyInventoryItemQuantityOnHandRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemQuantityOnHandRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemQuantityOnHandRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemQuantityOnHandRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemQuantityReservedRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemQuantityReservedRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemQuantityReservedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemQuantityReservedRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemQuantityOccupiedRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemQuantityOccupiedRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemQuantityOccupiedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemQuantityOccupiedRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemQuantityVirtualRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemQuantityVirtualRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemQuantityVirtualRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemQuantityVirtualRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemCreatedByRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemCreatedByRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemCreatedAtRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemCreatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemUpdatedByRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemUpdatedByRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemUpdatedAtRemoved { get; set; }

        bool IMergePatchInventoryItemEntryMvo.IsPropertyInventoryItemUpdatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemUpdatedAtRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteInventoryItemEntryMvoDto : InventoryItemEntryMvoCommandDtoBase
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



	public class CreateInventoryItemEntryMvoDto : CreateOrMergePatchOrDeleteInventoryItemEntryMvoDto
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


	public class MergePatchInventoryItemEntryMvoDto : CreateOrMergePatchOrDeleteInventoryItemEntryMvoDto
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

	public class DeleteInventoryItemEntryMvoDto : CreateOrMergePatchOrDeleteInventoryItemEntryMvoDto
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

    public static partial class InventoryItemEntryMvoCommandDtos
    {

    }

}
