﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public abstract class PhysicalInventoryCommandDtoBase : ICommandDto, ICreatePhysicalInventory, IMergePatchPhysicalInventory, IDeletePhysicalInventory
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeletePhysicalInventory)this).DocumentNumber;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
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

		public virtual string DocumentNumber { get; set; }

		public virtual string WarehouseId { get; set; }

		public virtual string LocatorIdPattern { get; set; }

		public virtual string ProductIdPattern { get; set; }

		public virtual bool? Posted { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual string Processing { get; set; }

		public virtual string DocumentTypeId { get; set; }

		public virtual DateTime? MovementDate { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? IsApproved { get; set; }

		public virtual decimal? ApprovalAmount { get; set; }

		public virtual bool? IsQuantityUpdated { get; set; }

		public virtual string ReversalDocumentNumber { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyWarehouseIdRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyWarehouseIdRemoved
        {
            get
            {
                var b = this.IsPropertyWarehouseIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyWarehouseIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyLocatorIdPatternRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyLocatorIdPatternRemoved
        {
            get
            {
                var b = this.IsPropertyLocatorIdPatternRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyLocatorIdPatternRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductIdPatternRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyProductIdPatternRemoved
        {
            get
            {
                var b = this.IsPropertyProductIdPatternRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductIdPatternRemoved = value;
            }
        }

		public virtual bool? IsPropertyPostedRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyPostedRemoved
        {
            get
            {
                var b = this.IsPropertyPostedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPostedRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessedRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyProcessedRemoved
        {
            get
            {
                var b = this.IsPropertyProcessedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProcessedRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessingRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyProcessingRemoved
        {
            get
            {
                var b = this.IsPropertyProcessingRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProcessingRemoved = value;
            }
        }

		public virtual bool? IsPropertyDocumentTypeIdRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyDocumentTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyDocumentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDocumentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementDateRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyMovementDateRemoved
        {
            get
            {
                var b = this.IsPropertyMovementDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMovementDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsApprovedRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyIsApprovedRemoved
        {
            get
            {
                var b = this.IsPropertyIsApprovedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsApprovedRemoved = value;
            }
        }

		public virtual bool? IsPropertyApprovalAmountRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyApprovalAmountRemoved
        {
            get
            {
                var b = this.IsPropertyApprovalAmountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyApprovalAmountRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsQuantityUpdatedRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyIsQuantityUpdatedRemoved
        {
            get
            {
                var b = this.IsPropertyIsQuantityUpdatedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsQuantityUpdatedRemoved = value;
            }
        }

		public virtual bool? IsPropertyReversalDocumentNumberRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyReversalDocumentNumberRemoved
        {
            get
            {
                var b = this.IsPropertyReversalDocumentNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReversalDocumentNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchPhysicalInventory.IsPropertyActiveRemoved
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

        ICreatePhysicalInventoryLineCommands ICreatePhysicalInventory.PhysicalInventoryLines
        {
            get
            {
                return this._physicalInventoryLines;
            }
        }

        IPhysicalInventoryLineCommands IMergePatchPhysicalInventory.PhysicalInventoryLineCommands
        {
            get
            {
                return this._physicalInventoryLines;
            }
        }

        public virtual CreatePhysicalInventoryLineDto NewCreatePhysicalInventoryLine()
        {
            var c = new CreatePhysicalInventoryLineDto();
            c.PhysicalInventoryDocumentNumber = this.DocumentNumber;

            return c;
        }

        ICreatePhysicalInventoryLine ICreatePhysicalInventory.NewCreatePhysicalInventoryLine()
        {
            return this.NewCreatePhysicalInventoryLine();
        }

        ICreatePhysicalInventoryLine IMergePatchPhysicalInventory.NewCreatePhysicalInventoryLine()
        {
            return this.NewCreatePhysicalInventoryLine();
        }

        public virtual MergePatchPhysicalInventoryLineDto NewMergePatchPhysicalInventoryLine()
        {
            var c = new MergePatchPhysicalInventoryLineDto();
            c.PhysicalInventoryDocumentNumber = this.DocumentNumber;

            return c;
        }

        IMergePatchPhysicalInventoryLine IMergePatchPhysicalInventory.NewMergePatchPhysicalInventoryLine()
        {
            return this.NewMergePatchPhysicalInventoryLine();
        }

        public virtual RemovePhysicalInventoryLineDto NewRemovePhysicalInventoryLine()
        {
            var c = new RemovePhysicalInventoryLineDto();
            c.PhysicalInventoryDocumentNumber = this.DocumentNumber;

            return c;
        }

        IRemovePhysicalInventoryLine IMergePatchPhysicalInventory.NewRemovePhysicalInventoryLine()
        {
            return this.NewRemovePhysicalInventoryLine();
        }

        private CreateOrMergePatchOrRemovePhysicalInventoryLineDtos _physicalInventoryLines = new CreateOrMergePatchOrRemovePhysicalInventoryLineDtos();

        public virtual CreateOrMergePatchOrRemovePhysicalInventoryLineDto[] PhysicalInventoryLines
        {
            get
            {
                return _physicalInventoryLines.ToArray();
            }
            set
            {
                _physicalInventoryLines.Clear();
                _physicalInventoryLines.AddRange(value);
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeletePhysicalInventoryDto : PhysicalInventoryCommandDtoBase
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



	public class CreatePhysicalInventoryDto : CreateOrMergePatchOrDeletePhysicalInventoryDto
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


	public class MergePatchPhysicalInventoryDto : CreateOrMergePatchOrDeletePhysicalInventoryDto
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

	public class DeletePhysicalInventoryDto : CreateOrMergePatchOrDeletePhysicalInventoryDto
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

    public static partial class PhysicalInventoryCommandDtos
    {

        public class DocumentActionRequestContent : ICommandDto
        {

            public string CommandType
            {
                get { return "DocumentAction"; }
            }

            public string Value { get; set; }

            public string DocumentNumber { get; set; }

            public long Version { get; set; }

            public string CommandId { get; set; }

            public string RequesterId { get; set; }

            public PhysicalInventoryCommands.DocumentAction ToDocumentAction()
            {
                var cmd = new PhysicalInventoryCommands.DocumentAction();
                cmd.Value = this.Value;
                cmd.DocumentNumber = this.DocumentNumber;
                cmd.Version = this.Version;
                cmd.CommandId = this.CommandId;
                cmd.RequesterId = this.RequesterId;
                return cmd;
            }

        }

    }

}

