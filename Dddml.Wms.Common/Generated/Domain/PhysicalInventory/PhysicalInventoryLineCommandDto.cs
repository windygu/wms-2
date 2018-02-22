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

	public abstract class PhysicalInventoryLineCommandDtoBase : ICommandDto, ICreatePhysicalInventoryLine, IMergePatchPhysicalInventoryLine, IRemovePhysicalInventoryLine
	{

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

		public virtual InventoryItemIdDto InventoryItemId { get; set; }

		public virtual decimal? BookQuantity { get; set; }

		public virtual decimal? CountedQuantity { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual long? ReversalLineNumber { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string PhysicalInventoryDocumentNumber { get; set; }


        InventoryItemId IPhysicalInventoryLineCommand.InventoryItemId
        {
            get 
            {
                return this.InventoryItemId.ToInventoryItemId();
            }
            set 
            {
                this.InventoryItemId = new InventoryItemIdDtoWrapper(value);
            }
        }

		public virtual bool? IsPropertyBookQuantityRemoved { get; set; }

        bool IMergePatchPhysicalInventoryLine.IsPropertyBookQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyBookQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyBookQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyCountedQuantityRemoved { get; set; }

        bool IMergePatchPhysicalInventoryLine.IsPropertyCountedQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyCountedQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCountedQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessedRemoved { get; set; }

        bool IMergePatchPhysicalInventoryLine.IsPropertyProcessedRemoved
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

		public virtual bool? IsPropertyReversalLineNumberRemoved { get; set; }

        bool IMergePatchPhysicalInventoryLine.IsPropertyReversalLineNumberRemoved
        {
            get
            {
                var b = this.IsPropertyReversalLineNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReversalLineNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchPhysicalInventoryLine.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchPhysicalInventoryLine.IsPropertyActiveRemoved
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


    public class CreateOrMergePatchOrRemovePhysicalInventoryLineDto : PhysicalInventoryLineCommandDtoBase
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



	public class CreatePhysicalInventoryLineDto : CreateOrMergePatchOrRemovePhysicalInventoryLineDto
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


	public class MergePatchPhysicalInventoryLineDto : CreateOrMergePatchOrRemovePhysicalInventoryLineDto
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

	public class RemovePhysicalInventoryLineDto : CreateOrMergePatchOrRemovePhysicalInventoryLineDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}


    public partial class CreateOrMergePatchOrRemovePhysicalInventoryLineDtos : IPhysicalInventoryLineCommands, ICreatePhysicalInventoryLineCommands, IEnumerable<CreateOrMergePatchOrRemovePhysicalInventoryLineDto>
    {
        private List<CreateOrMergePatchOrRemovePhysicalInventoryLineDto> _innerCommands = new List<CreateOrMergePatchOrRemovePhysicalInventoryLineDto>();

        public virtual CreateOrMergePatchOrRemovePhysicalInventoryLineDto[] ToArray()
        {
            return _innerCommands.ToArray();
        }

        public virtual void Clear()
        {
            _innerCommands.Clear();
        }

        public virtual void AddRange(IEnumerable<CreateOrMergePatchOrRemovePhysicalInventoryLineDto> cs)
        {
            _innerCommands.AddRange(cs);
        }

        void IPhysicalInventoryLineCommands.Add(IPhysicalInventoryLineCommand c)
        {
            _innerCommands.Add((CreateOrMergePatchOrRemovePhysicalInventoryLineDto)c);
        }

        void IPhysicalInventoryLineCommands.Remove(IPhysicalInventoryLineCommand c)
        {
            _innerCommands.Remove((CreateOrMergePatchOrRemovePhysicalInventoryLineDto)c);
        }


        IEnumerator<CreateOrMergePatchOrRemovePhysicalInventoryLineDto> IEnumerable<CreateOrMergePatchOrRemovePhysicalInventoryLineDto>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        IEnumerator<IPhysicalInventoryLineCommand> IEnumerable<IPhysicalInventoryLineCommand>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        void ICreatePhysicalInventoryLineCommands.Add(ICreatePhysicalInventoryLine c)
        {
            _innerCommands.Add((CreatePhysicalInventoryLineDto)c);
        }

        void ICreatePhysicalInventoryLineCommands.Remove(ICreatePhysicalInventoryLine c)
        {
            _innerCommands.Remove((CreatePhysicalInventoryLineDto)c);
        }

        IEnumerator<ICreatePhysicalInventoryLine> IEnumerable<ICreatePhysicalInventoryLine>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

}

