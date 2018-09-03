﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistBinDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistBin;

namespace Dddml.Wms.Domain.PicklistBin
{

	public abstract class PicklistBinCommandDtoBase : ICommandDto, ICreatePicklistBin, IMergePatchPicklistBin, IDeletePicklistBin
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeletePicklistBin)this).PicklistBinId;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IPicklistBinCommand.Version
        {
            get { return this.Version != null ? this.Version.Value : default(long); }
            set { this.Version = value; }
        }

		public virtual long? Version { get; set; }

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

		public virtual string PicklistBinId { get; set; }

		public virtual string PicklistId { get; set; }

		public virtual long? BinLocationNumber { get; set; }

		public virtual string PrimaryOrderId { get; set; }

		public virtual string PrimaryShipGroupSeqId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyPicklistIdRemoved { get; set; }

        bool IMergePatchPicklistBin.IsPropertyPicklistIdRemoved
        {
            get
            {
                var b = this.IsPropertyPicklistIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPicklistIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyBinLocationNumberRemoved { get; set; }

        bool IMergePatchPicklistBin.IsPropertyBinLocationNumberRemoved
        {
            get
            {
                var b = this.IsPropertyBinLocationNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyBinLocationNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyPrimaryOrderIdRemoved { get; set; }

        bool IMergePatchPicklistBin.IsPropertyPrimaryOrderIdRemoved
        {
            get
            {
                var b = this.IsPropertyPrimaryOrderIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPrimaryOrderIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPrimaryShipGroupSeqIdRemoved { get; set; }

        bool IMergePatchPicklistBin.IsPropertyPrimaryShipGroupSeqIdRemoved
        {
            get
            {
                var b = this.IsPropertyPrimaryShipGroupSeqIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPrimaryShipGroupSeqIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchPicklistBin.IsPropertyActiveRemoved
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

        ICreatePicklistItemCommands ICreatePicklistBin.PicklistItems
        {
            get
            {
                return this._picklistItems;
            }
        }

        IPicklistItemCommands IMergePatchPicklistBin.PicklistItemCommands
        {
            get
            {
                return this._picklistItems;
            }
        }

        public virtual CreatePicklistItemDto NewCreatePicklistItem()
        {
            var c = new CreatePicklistItemDto();
            c.PicklistBinId = this.PicklistBinId;

            return c;
        }

        ICreatePicklistItem ICreatePicklistBin.NewCreatePicklistItem()
        {
            return this.NewCreatePicklistItem();
        }

        ICreatePicklistItem IMergePatchPicklistBin.NewCreatePicklistItem()
        {
            return this.NewCreatePicklistItem();
        }

        public virtual MergePatchPicklistItemDto NewMergePatchPicklistItem()
        {
            var c = new MergePatchPicklistItemDto();
            c.PicklistBinId = this.PicklistBinId;

            return c;
        }

        IMergePatchPicklistItem IMergePatchPicklistBin.NewMergePatchPicklistItem()
        {
            return this.NewMergePatchPicklistItem();
        }

        public virtual RemovePicklistItemDto NewRemovePicklistItem()
        {
            var c = new RemovePicklistItemDto();
            c.PicklistBinId = this.PicklistBinId;

            return c;
        }

        IRemovePicklistItem IMergePatchPicklistBin.NewRemovePicklistItem()
        {
            return this.NewRemovePicklistItem();
        }

        private CreateOrMergePatchOrRemovePicklistItemDtos _picklistItems = new CreateOrMergePatchOrRemovePicklistItemDtos();

        public virtual CreateOrMergePatchOrRemovePicklistItemDto[] PicklistItems
        {
            get
            {
                return _picklistItems.ToArray();
            }
            set
            {
                _picklistItems.Clear();
                _picklistItems.AddRange(value);
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeletePicklistBinDto : PicklistBinCommandDtoBase
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



	public class CreatePicklistBinDto : CreateOrMergePatchOrDeletePicklistBinDto
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


	public class MergePatchPicklistBinDto : CreateOrMergePatchOrDeletePicklistBinDto
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

	public class DeletePicklistBinDto : CreateOrMergePatchOrDeletePicklistBinDto
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

    public static partial class PicklistBinCommandDtos
    {

    }

}

