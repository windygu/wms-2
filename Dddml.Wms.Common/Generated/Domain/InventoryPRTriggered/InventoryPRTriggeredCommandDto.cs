﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{

	public abstract class InventoryPRTriggeredCommandDtoBase : ICommandDto, ICreateInventoryPRTriggered, IMergePatchInventoryPRTriggered, IDeleteInventoryPRTriggered
	{

		InventoryPRTriggeredId IAggregateCommand<InventoryPRTriggeredId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteInventoryPRTriggered)this).InventoryPRTriggeredId;
			}
		}


		long IAggregateCommand<InventoryPRTriggeredId, long>.AggregateVersion
		{
			get
			{
				return this.Version;
			}
		}

		public virtual long Version { get; set; }

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

		public virtual InventoryPRTriggeredIdDto InventoryPRTriggeredId { get; set; }

		public virtual bool? IsProcessed { get; set; }

		public virtual bool? Active { get; set; }


        InventoryPRTriggeredId IInventoryPRTriggeredCommand.InventoryPRTriggeredId
        {
            get 
            {
                return this.InventoryPRTriggeredId.ToInventoryPRTriggeredId();
            }
            set 
            {
                this.InventoryPRTriggeredId = new InventoryPRTriggeredIdDtoWrapper(value);
            }
        }

		public virtual bool? IsPropertyIsProcessedRemoved { get; set; }

        bool IMergePatchInventoryPRTriggered.IsPropertyIsProcessedRemoved
        {
            get
            {
                var b = this.IsPropertyIsProcessedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsProcessedRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchInventoryPRTriggered.IsPropertyActiveRemoved
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


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteInventoryPRTriggeredDto : InventoryPRTriggeredCommandDtoBase
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



	public class CreateInventoryPRTriggeredDto : CreateOrMergePatchOrDeleteInventoryPRTriggeredDto
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


	public class MergePatchInventoryPRTriggeredDto : CreateOrMergePatchOrDeleteInventoryPRTriggeredDto
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

	public class DeleteInventoryPRTriggeredDto : CreateOrMergePatchOrDeleteInventoryPRTriggeredDto
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

    public static partial class InventoryPRTriggeredCommandDtos
    {

    }

}

