﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public abstract class AttributeValueMvoCommandDtoBase : ICommandDto, ICreateAttributeValueMvo, IMergePatchAttributeValueMvo, IDeleteAttributeValueMvo
	{

		AttributeValueId IAggregateCommand<AttributeValueId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeValueId;
			}
		}


		long IAggregateCommand<AttributeValueId, long>.AggregateVersion
		{
			get
			{
				return this.AttributeVersion;
			}
		}

		public virtual long AttributeVersion { get; set; }

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

		public virtual AttributeValueIdDto AttributeValueId { get; set; }

		public virtual string Name { get; set; }

		public virtual string Description { get; set; }

		public virtual string ReferenceId { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string AttributeName { get; set; }

		public virtual string AttributeOrganizationId { get; set; }

		public virtual string AttributeDescription { get; set; }

		public virtual bool? AttributeIsMandatory { get; set; }

		public virtual bool? AttributeIsInstanceAttribute { get; set; }

		public virtual string AttributeAttributeValueType { get; set; }

		public virtual int? AttributeAttributeValueLength { get; set; }

		public virtual bool? AttributeIsList { get; set; }

		public virtual string AttributeFieldName { get; set; }

		public virtual string AttributeReferenceId { get; set; }

		public virtual string AttributeCreatedBy { get; set; }

		public virtual DateTime? AttributeCreatedAt { get; set; }

		public virtual string AttributeUpdatedBy { get; set; }

		public virtual DateTime? AttributeUpdatedAt { get; set; }

		public virtual bool? AttributeActive { get; set; }

		public virtual bool? AttributeDeleted { get; set; }


        AttributeValueId ICreateOrMergePatchOrDeleteAttributeValueMvo.AttributeValueId
        {
            get 
            {
                return this.AttributeValueId.ToAttributeValueId();
            }
            set 
            {
                this.AttributeValueId = new AttributeValueIdDto(value);
            }
        }

		public virtual bool? IsPropertyNameRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyNameRemoved
        {
            get
            {
                var b = this.IsPropertyNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyReferenceIdRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyReferenceIdRemoved
        {
            get
            {
                var b = this.IsPropertyReferenceIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReferenceIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyVersionRemoved
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

        bool IMergePatchAttributeValueMvo.IsPropertyActiveRemoved
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

		public virtual bool? IsPropertyAttributeNameRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeNameRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeOrganizationIdRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeOrganizationIdRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeOrganizationIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeOrganizationIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeDescriptionRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeIsMandatoryRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeIsMandatoryRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeIsMandatoryRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeIsMandatoryRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeIsInstanceAttributeRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeIsInstanceAttributeRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeIsInstanceAttributeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeIsInstanceAttributeRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeAttributeValueTypeRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeAttributeValueTypeRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeAttributeValueTypeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeAttributeValueTypeRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeAttributeValueLengthRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeAttributeValueLengthRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeAttributeValueLengthRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeAttributeValueLengthRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeIsListRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeIsListRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeIsListRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeIsListRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeFieldNameRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeFieldNameRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeFieldNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeFieldNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeReferenceIdRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeReferenceIdRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeReferenceIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeReferenceIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeCreatedByRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeCreatedByRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeCreatedAtRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeCreatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeUpdatedByRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeUpdatedByRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeUpdatedAtRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeUpdatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeUpdatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeActiveRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeActiveRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeDeletedRemoved { get; set; }

        bool IMergePatchAttributeValueMvo.IsPropertyAttributeDeletedRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeDeletedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeDeletedRemoved = value;
            }
        }


        // //////////////////////////////////////////////
/*
        private IAttributeValueMvoCommand _innerCommand;

        internal ICommand ToCommand()
        {
            //if (this._innerCommand != null)
            //{
            //    return this._innerCommand;
            //}
            var cmdType = GetCommandType();
            if (cmdType == CommandType.Create)
            {
                var cmd = ToCreateAttributeValueMvo();
                this._innerCommand = cmd;
            }
            else if (cmdType == CommandType.MergePatch)
            {
                var cmd = ToMergePatchAttributeValueMvo();
                this._innerCommand = cmd;
            }
            else if (cmdType == CommandType.Delete)
            {
                var cmd = ToDeleteAttributeValueMvo();
                this._innerCommand = cmd;
            }
            else
            {
                throw DomainError.Named("invalidCommandType", String.Format("Invalid command type: {0}", cmdType));
            }
            return this._innerCommand;
        }

        internal DeleteAttributeValueMvo ToDeleteAttributeValueMvo()
        {
            var cmd = new DeleteAttributeValueMvo();
            cmd.CommandId = this.CommandId;
            cmd.RequesterId = this.RequesterId;

            cmd.AttributeValueId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeValueId;
            cmd.AttributeVersion = this.AttributeVersion;

            return cmd;
        }

        internal MergePatchAttributeValueMvo ToMergePatchAttributeValueMvo()
        {
            var cmd = new MergePatchAttributeValueMvo();
            cmd.CommandId = this.CommandId;
            cmd.RequesterId = this.RequesterId;

            cmd.AttributeVersion = this.AttributeVersion;

            cmd.AttributeValueId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeValueId;
            cmd.Name = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Name;
            cmd.Description = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Description;
            cmd.ReferenceId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).ReferenceId;
            cmd.Version = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Version;
            cmd.Active = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Active;
            cmd.AttributeName = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeName;
            cmd.AttributeOrganizationId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeOrganizationId;
            cmd.AttributeDescription = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeDescription;
            cmd.AttributeIsMandatory = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeIsMandatory;
            cmd.AttributeIsInstanceAttribute = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeIsInstanceAttribute;
            cmd.AttributeAttributeValueType = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeAttributeValueType;
            cmd.AttributeAttributeValueLength = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeAttributeValueLength;
            cmd.AttributeIsList = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeIsList;
            cmd.AttributeFieldName = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeFieldName;
            cmd.AttributeReferenceId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeReferenceId;
            cmd.AttributeCreatedBy = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeCreatedBy;
            cmd.AttributeCreatedAt = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeCreatedAt;
            cmd.AttributeUpdatedBy = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeUpdatedBy;
            cmd.AttributeUpdatedAt = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeUpdatedAt;
            cmd.AttributeActive = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeActive;
            cmd.AttributeDeleted = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeDeleted;
            
            cmd.IsPropertyNameRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyNameRemoved;
            cmd.IsPropertyDescriptionRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyDescriptionRemoved;
            cmd.IsPropertyReferenceIdRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyReferenceIdRemoved;
            cmd.IsPropertyVersionRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyVersionRemoved;
            cmd.IsPropertyActiveRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyActiveRemoved;
            cmd.IsPropertyAttributeNameRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeNameRemoved;
            cmd.IsPropertyAttributeOrganizationIdRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeOrganizationIdRemoved;
            cmd.IsPropertyAttributeDescriptionRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeDescriptionRemoved;
            cmd.IsPropertyAttributeIsMandatoryRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeIsMandatoryRemoved;
            cmd.IsPropertyAttributeIsInstanceAttributeRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeIsInstanceAttributeRemoved;
            cmd.IsPropertyAttributeAttributeValueTypeRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeAttributeValueTypeRemoved;
            cmd.IsPropertyAttributeAttributeValueLengthRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeAttributeValueLengthRemoved;
            cmd.IsPropertyAttributeIsListRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeIsListRemoved;
            cmd.IsPropertyAttributeFieldNameRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeFieldNameRemoved;
            cmd.IsPropertyAttributeReferenceIdRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeReferenceIdRemoved;
            cmd.IsPropertyAttributeCreatedByRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeCreatedByRemoved;
            cmd.IsPropertyAttributeCreatedAtRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeCreatedAtRemoved;
            cmd.IsPropertyAttributeUpdatedByRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeUpdatedByRemoved;
            cmd.IsPropertyAttributeUpdatedAtRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeUpdatedAtRemoved;
            cmd.IsPropertyAttributeActiveRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeActiveRemoved;
            cmd.IsPropertyAttributeDeletedRemoved = (this as IMergePatchAttributeValueMvo).IsPropertyAttributeDeletedRemoved;
            return cmd;
        }

        internal CreateAttributeValueMvo ToCreateAttributeValueMvo()
        {
            var cmd = new CreateAttributeValueMvo();
            cmd.CommandId = this.CommandId;
            cmd.RequesterId = this.RequesterId;

            cmd.AttributeVersion = this.AttributeVersion;

            cmd.AttributeValueId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeValueId;
            cmd.Name = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Name;
            cmd.Description = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Description;
            cmd.ReferenceId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).ReferenceId;
            cmd.Version = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Version;
            cmd.Active = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).Active;
            cmd.AttributeName = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeName;
            cmd.AttributeOrganizationId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeOrganizationId;
            cmd.AttributeDescription = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeDescription;
            cmd.AttributeIsMandatory = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeIsMandatory;
            cmd.AttributeIsInstanceAttribute = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeIsInstanceAttribute;
            cmd.AttributeAttributeValueType = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeAttributeValueType;
            cmd.AttributeAttributeValueLength = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeAttributeValueLength;
            cmd.AttributeIsList = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeIsList;
            cmd.AttributeFieldName = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeFieldName;
            cmd.AttributeReferenceId = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeReferenceId;
            cmd.AttributeCreatedBy = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeCreatedBy;
            cmd.AttributeCreatedAt = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeCreatedAt;
            cmd.AttributeUpdatedBy = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeUpdatedBy;
            cmd.AttributeUpdatedAt = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeUpdatedAt;
            cmd.AttributeActive = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeActive;
            cmd.AttributeDeleted = ((ICreateOrMergePatchOrDeleteAttributeValueMvo)this).AttributeDeleted;
            return cmd;
        }
*/
        // //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteAttributeValueMvoDto : AttributeValueMvoCommandDtoBase
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



	public class CreateAttributeValueMvoDto : CreateOrMergePatchOrDeleteAttributeValueMvoDto
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


	public class MergePatchAttributeValueMvoDto : CreateOrMergePatchOrDeleteAttributeValueMvoDto
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

	public class DeleteAttributeValueMvoDto : CreateOrMergePatchOrDeleteAttributeValueMvoDto
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





}

