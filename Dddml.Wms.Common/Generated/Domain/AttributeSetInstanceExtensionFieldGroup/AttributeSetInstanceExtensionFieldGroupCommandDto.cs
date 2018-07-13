﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstanceExtensionFieldGroupDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstanceExtensionFieldGroup;

namespace Dddml.Wms.Domain.AttributeSetInstanceExtensionFieldGroup
{

	public abstract class AttributeSetInstanceExtensionFieldGroupCommandDtoBase : ICommandDto, ICreateAttributeSetInstanceExtensionFieldGroup, IMergePatchAttributeSetInstanceExtensionFieldGroup, IDeleteAttributeSetInstanceExtensionFieldGroup
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldGroup)this).Id;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IAttributeSetInstanceExtensionFieldGroupCommand.Version
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

		public virtual string Id { get; set; }

		public virtual string FieldType { get; set; }

		public virtual int? FieldLength { get; set; }

		public virtual int? FieldCount { get; set; }

		public virtual string NameFormat { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyFieldTypeRemoved { get; set; }

        bool IMergePatchAttributeSetInstanceExtensionFieldGroup.IsPropertyFieldTypeRemoved
        {
            get
            {
                var b = this.IsPropertyFieldTypeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFieldTypeRemoved = value;
            }
        }

		public virtual bool? IsPropertyFieldLengthRemoved { get; set; }

        bool IMergePatchAttributeSetInstanceExtensionFieldGroup.IsPropertyFieldLengthRemoved
        {
            get
            {
                var b = this.IsPropertyFieldLengthRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFieldLengthRemoved = value;
            }
        }

		public virtual bool? IsPropertyFieldCountRemoved { get; set; }

        bool IMergePatchAttributeSetInstanceExtensionFieldGroup.IsPropertyFieldCountRemoved
        {
            get
            {
                var b = this.IsPropertyFieldCountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFieldCountRemoved = value;
            }
        }

		public virtual bool? IsPropertyNameFormatRemoved { get; set; }

        bool IMergePatchAttributeSetInstanceExtensionFieldGroup.IsPropertyNameFormatRemoved
        {
            get
            {
                var b = this.IsPropertyNameFormatRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyNameFormatRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchAttributeSetInstanceExtensionFieldGroup.IsPropertyDescriptionRemoved
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

        bool IMergePatchAttributeSetInstanceExtensionFieldGroup.IsPropertyActiveRemoved
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


    public class CreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldGroupDto : AttributeSetInstanceExtensionFieldGroupCommandDtoBase
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



	public class CreateAttributeSetInstanceExtensionFieldGroupDto : CreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldGroupDto
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


	public class MergePatchAttributeSetInstanceExtensionFieldGroupDto : CreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldGroupDto
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

	public class DeleteAttributeSetInstanceExtensionFieldGroupDto : CreateOrMergePatchOrDeleteAttributeSetInstanceExtensionFieldGroupDto
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

    public static partial class AttributeSetInstanceExtensionFieldGroupCommandDtos
    {

    }

}

