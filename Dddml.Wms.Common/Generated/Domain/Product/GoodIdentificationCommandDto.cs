﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Product;

namespace Dddml.Wms.Domain.Product
{

	public abstract class GoodIdentificationCommandDtoBase : ICommandDto, ICreateGoodIdentification, IMergePatchGoodIdentification, IRemoveGoodIdentification
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

		public virtual string GoodIdentificationTypeId { get; set; }

		public virtual string IdValue { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string ProductId { get; set; }

		public virtual bool? IsPropertyIdValueRemoved { get; set; }

        bool IMergePatchGoodIdentification.IsPropertyIdValueRemoved
        {
            get
            {
                var b = this.IsPropertyIdValueRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIdValueRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchGoodIdentification.IsPropertyActiveRemoved
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


    public class CreateOrMergePatchOrRemoveGoodIdentificationDto : GoodIdentificationCommandDtoBase
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



	public class CreateGoodIdentificationDto : CreateOrMergePatchOrRemoveGoodIdentificationDto
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


	public class MergePatchGoodIdentificationDto : CreateOrMergePatchOrRemoveGoodIdentificationDto
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

	public class RemoveGoodIdentificationDto : CreateOrMergePatchOrRemoveGoodIdentificationDto
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


    public partial class CreateOrMergePatchOrRemoveGoodIdentificationDtos : IGoodIdentificationCommands, ICreateGoodIdentificationCommands, IEnumerable<CreateOrMergePatchOrRemoveGoodIdentificationDto>
    {
        private List<CreateOrMergePatchOrRemoveGoodIdentificationDto> _innerCommands = new List<CreateOrMergePatchOrRemoveGoodIdentificationDto>();

        public virtual CreateOrMergePatchOrRemoveGoodIdentificationDto[] ToArray()
        {
            return _innerCommands.ToArray();
        }

        public virtual void Clear()
        {
            _innerCommands.Clear();
        }

        public virtual void AddRange(IEnumerable<CreateOrMergePatchOrRemoveGoodIdentificationDto> cs)
        {
            _innerCommands.AddRange(cs);
        }

        void IGoodIdentificationCommands.Add(IGoodIdentificationCommand c)
        {
            _innerCommands.Add((CreateOrMergePatchOrRemoveGoodIdentificationDto)c);
        }

        void IGoodIdentificationCommands.Remove(IGoodIdentificationCommand c)
        {
            _innerCommands.Remove((CreateOrMergePatchOrRemoveGoodIdentificationDto)c);
        }


        IEnumerator<CreateOrMergePatchOrRemoveGoodIdentificationDto> IEnumerable<CreateOrMergePatchOrRemoveGoodIdentificationDto>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        IEnumerator<IGoodIdentificationCommand> IEnumerable<IGoodIdentificationCommand>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        void ICreateGoodIdentificationCommands.Add(ICreateGoodIdentification c)
        {
            _innerCommands.Add((CreateGoodIdentificationDto)c);
        }

        void ICreateGoodIdentificationCommands.Remove(ICreateGoodIdentification c)
        {
            _innerCommands.Remove((CreateGoodIdentificationDto)c);
        }

        IEnumerator<ICreateGoodIdentification> IEnumerable<ICreateGoodIdentification>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

}

