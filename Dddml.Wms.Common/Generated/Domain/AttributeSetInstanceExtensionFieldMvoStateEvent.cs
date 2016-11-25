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

	public abstract class AttributeSetInstanceExtensionFieldMvoStateEventBase : IAttributeSetInstanceExtensionFieldMvoStateEvent
	{

		public virtual AttributeSetInstanceExtensionFieldMvoStateEventId StateEventId { get; set; }

		public virtual string Name { get; set; }

		public virtual string Type { get; set; }

		public virtual int? Length { get; set; }

		public virtual string Alias { get; set; }

		public virtual string Description { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string AttrSetInstEFGroupFieldType { get; set; }

		public virtual int? AttrSetInstEFGroupFieldLength { get; set; }

		public virtual int? AttrSetInstEFGroupFieldCount { get; set; }

		public virtual string AttrSetInstEFGroupNameFormat { get; set; }

		public virtual string AttrSetInstEFGroupDescription { get; set; }

		public virtual string AttrSetInstEFGroupCreatedBy { get; set; }

		public virtual DateTime? AttrSetInstEFGroupCreatedAt { get; set; }

		public virtual string AttrSetInstEFGroupUpdatedBy { get; set; }

		public virtual DateTime? AttrSetInstEFGroupUpdatedAt { get; set; }

		public virtual bool? AttrSetInstEFGroupActive { get; set; }

		public virtual bool? AttrSetInstEFGroupDeleted { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

		AttributeSetInstanceExtensionFieldMvoStateEventId IGlobalIdentity<AttributeSetInstanceExtensionFieldMvoStateEventId>.GlobalId {
			get {
				return this.StateEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IAttributeSetInstanceExtensionFieldMvoStateEvent.ReadOnly
        {
            get
            {
                return this.StateEventReadOnly;
            }
            set
            {
                this.StateEventReadOnly = value;
            }
        }


		string ICreated<string>.CreatedBy {
			get {
				return this.CreatedBy;
			}
			set {
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt {
			get {
				return this.CreatedAt;
			}
			set {
				this.CreatedAt = value;
			}
		}

        protected AttributeSetInstanceExtensionFieldMvoStateEventBase()
        {
        }

        protected AttributeSetInstanceExtensionFieldMvoStateEventBase(AttributeSetInstanceExtensionFieldMvoStateEventId stateEventId)
        {
            this.StateEventId = stateEventId;
        }


        string IStateEventDto.StateEventType
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}

	public class AttributeSetInstanceExtensionFieldMvoStateCreated : AttributeSetInstanceExtensionFieldMvoStateEventBase, IAttributeSetInstanceExtensionFieldMvoStateCreated
	{
		public AttributeSetInstanceExtensionFieldMvoStateCreated ()
		{
		}

		public AttributeSetInstanceExtensionFieldMvoStateCreated (AttributeSetInstanceExtensionFieldMvoStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class AttributeSetInstanceExtensionFieldMvoStateMergePatched : AttributeSetInstanceExtensionFieldMvoStateEventBase, IAttributeSetInstanceExtensionFieldMvoStateMergePatched
	{
		public virtual bool IsPropertyNameRemoved { get; set; }

		public virtual bool IsPropertyTypeRemoved { get; set; }

		public virtual bool IsPropertyLengthRemoved { get; set; }

		public virtual bool IsPropertyAliasRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyVersionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupFieldTypeRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupFieldLengthRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupFieldCountRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupNameFormatRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupDescriptionRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupCreatedByRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupCreatedAtRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupUpdatedByRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupUpdatedAtRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupActiveRemoved { get; set; }

		public virtual bool IsPropertyAttrSetInstEFGroupDeletedRemoved { get; set; }


		public AttributeSetInstanceExtensionFieldMvoStateMergePatched ()
		{
		}

		public AttributeSetInstanceExtensionFieldMvoStateMergePatched (AttributeSetInstanceExtensionFieldMvoStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class AttributeSetInstanceExtensionFieldMvoStateDeleted : AttributeSetInstanceExtensionFieldMvoStateEventBase, IAttributeSetInstanceExtensionFieldMvoStateDeleted
	{
		public AttributeSetInstanceExtensionFieldMvoStateDeleted ()
		{
		}

		public AttributeSetInstanceExtensionFieldMvoStateDeleted (AttributeSetInstanceExtensionFieldMvoStateEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }



	}



}

