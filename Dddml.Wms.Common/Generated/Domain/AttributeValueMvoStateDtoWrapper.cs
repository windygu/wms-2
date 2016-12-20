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

	public partial class AttributeValueMvoStateDtoWrapper : StateDtoWrapperBase, IAttributeValueMvoStateDto, IAttributeValueMvoState
	{

        internal static IList<string> _collectionFieldNames = new string[] {  };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IAttributeValueMvoState _state;

        public AttributeValueMvoStateDtoWrapper()
        {
            this._state = new AttributeValueMvoState();
        }

		public AttributeValueMvoStateDtoWrapper(IAttributeValueMvoState state)
		{
            this._state = state;
		}

		public IAttributeValueMvoState ToAttributeValueMvoState()
		{
			return this._state;
		}


        public AttributeValueIdDto AttributeValueId
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeValueId"))
                {
					return (_state.AttributeValueId == null) ? null : new AttributeValueIdDtoWrapper(_state.AttributeValueId);
                }
                return null;
            }
            set
            {
                _state.AttributeValueId = (value == null) ? null : value.ToAttributeValueId();
            }
        }


        AttributeValueId IAttributeValueMvoStateProperties.AttributeValueId
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeValueId;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeValueId = value;
            }
        }

		public virtual string Name
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Name"))
                {
                    return _state.Name;
                }
                return null;
            }
            set
            {
                _state.Name = value;
            }
        }

        string IAttributeValueMvoStateProperties.Name
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).Name;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).Name = value;
            }
        }

		public virtual string Description
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Description"))
                {
                    return _state.Description;
                }
                return null;
            }
            set
            {
                _state.Description = value;
            }
        }

        string IAttributeValueMvoStateProperties.Description
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).Description;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).Description = value;
            }
        }

		public virtual string ReferenceId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ReferenceId"))
                {
                    return _state.ReferenceId;
                }
                return null;
            }
            set
            {
                _state.ReferenceId = value;
            }
        }

        string IAttributeValueMvoStateProperties.ReferenceId
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).ReferenceId;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).ReferenceId = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IAttributeValueMvoStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IAttributeValueMvoStateProperties).Version = value.Value;
                }
            }
        }

        long IAttributeValueMvoStateProperties.Version
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).Version;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).Version = value;
            }
        }

		public virtual bool? Active
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Active"))
                {
                    return (this._state as IAttributeValueMvoStateProperties).Active;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IAttributeValueMvoStateProperties).Active = value.Value;
                }
            }
        }

        bool IAttributeValueMvoStateProperties.Active
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).Active;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).Active = value;
            }
        }

		public virtual string AttributeName
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeName"))
                {
                    return _state.AttributeName;
                }
                return null;
            }
            set
            {
                _state.AttributeName = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeName
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeName;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeName = value;
            }
        }

		public virtual string AttributeOrganizationId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeOrganizationId"))
                {
                    return _state.AttributeOrganizationId;
                }
                return null;
            }
            set
            {
                _state.AttributeOrganizationId = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeOrganizationId
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeOrganizationId;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeOrganizationId = value;
            }
        }

		public virtual string AttributeDescription
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeDescription"))
                {
                    return _state.AttributeDescription;
                }
                return null;
            }
            set
            {
                _state.AttributeDescription = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeDescription
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeDescription;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeDescription = value;
            }
        }

		public virtual bool? AttributeIsMandatory
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeIsMandatory"))
                {
                    return _state.AttributeIsMandatory;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeIsMandatory = value.Value;
                }
            }
        }

        bool IAttributeValueMvoStateProperties.AttributeIsMandatory
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeIsMandatory;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeIsMandatory = value;
            }
        }

		public virtual bool? AttributeIsInstanceAttribute
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeIsInstanceAttribute"))
                {
                    return _state.AttributeIsInstanceAttribute;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeIsInstanceAttribute = value.Value;
                }
            }
        }

        bool IAttributeValueMvoStateProperties.AttributeIsInstanceAttribute
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeIsInstanceAttribute;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeIsInstanceAttribute = value;
            }
        }

		public virtual string AttributeAttributeValueType
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeAttributeValueType"))
                {
                    return _state.AttributeAttributeValueType;
                }
                return null;
            }
            set
            {
                _state.AttributeAttributeValueType = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeAttributeValueType
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeAttributeValueType;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeAttributeValueType = value;
            }
        }

		public virtual int? AttributeAttributeValueLength
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeAttributeValueLength"))
                {
                    return _state.AttributeAttributeValueLength;
                }
                return null;
            }
            set
            {
                _state.AttributeAttributeValueLength = value;
            }
        }

        int? IAttributeValueMvoStateProperties.AttributeAttributeValueLength
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeAttributeValueLength;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeAttributeValueLength = value;
            }
        }

		public virtual bool? AttributeIsList
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeIsList"))
                {
                    return _state.AttributeIsList;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeIsList = value.Value;
                }
            }
        }

        bool IAttributeValueMvoStateProperties.AttributeIsList
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeIsList;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeIsList = value;
            }
        }

		public virtual string AttributeFieldName
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeFieldName"))
                {
                    return _state.AttributeFieldName;
                }
                return null;
            }
            set
            {
                _state.AttributeFieldName = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeFieldName
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeFieldName;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeFieldName = value;
            }
        }

		public virtual string AttributeReferenceId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeReferenceId"))
                {
                    return _state.AttributeReferenceId;
                }
                return null;
            }
            set
            {
                _state.AttributeReferenceId = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeReferenceId
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeReferenceId;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeReferenceId = value;
            }
        }

		public virtual string AttributeCreatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeCreatedBy"))
                {
                    return _state.AttributeCreatedBy;
                }
                return null;
            }
            set
            {
                _state.AttributeCreatedBy = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeCreatedBy
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeCreatedBy;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeCreatedBy = value;
            }
        }

		public virtual DateTime? AttributeCreatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeCreatedAt"))
                {
                    return _state.AttributeCreatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.AttributeCreatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeCreatedAt = value.Value;
                }
            }
        }

        DateTime IAttributeValueMvoStateProperties.AttributeCreatedAt
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeCreatedAt;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeCreatedAt = value;
            }
        }

		public virtual string AttributeUpdatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeUpdatedBy"))
                {
                    return _state.AttributeUpdatedBy;
                }
                return null;
            }
            set
            {
                _state.AttributeUpdatedBy = value;
            }
        }

        string IAttributeValueMvoStateProperties.AttributeUpdatedBy
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeUpdatedBy;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeUpdatedBy = value;
            }
        }

		public virtual DateTime? AttributeUpdatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeUpdatedAt"))
                {
                    return _state.AttributeUpdatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.AttributeUpdatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeUpdatedAt = value.Value;
                }
            }
        }

        DateTime IAttributeValueMvoStateProperties.AttributeUpdatedAt
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeUpdatedAt;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeUpdatedAt = value;
            }
        }

		public virtual bool? AttributeActive
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeActive"))
                {
                    return _state.AttributeActive;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeActive = value.Value;
                }
            }
        }

        bool IAttributeValueMvoStateProperties.AttributeActive
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeActive;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeActive = value;
            }
        }

		public virtual bool? AttributeDeleted
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeDeleted"))
                {
                    return _state.AttributeDeleted;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeDeleted = value.Value;
                }
            }
        }

        bool IAttributeValueMvoStateProperties.AttributeDeleted
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeDeleted;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeDeleted = value;
            }
        }

		public virtual long? AttributeVersion
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeVersion"))
                {
                    return _state.AttributeVersion;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.AttributeVersion = value.Value;
                }
            }
        }

        long IAttributeValueMvoStateProperties.AttributeVersion
        {
            get 
            {
                return (this._state as IAttributeValueMvoStateProperties).AttributeVersion;
            }
            set 
            {
                (this._state as IAttributeValueMvoStateProperties).AttributeVersion = value;
            }
        }

		public virtual string CreatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("CreatedBy"))
                {
                    return _state.CreatedBy;
                }
                return null;
            }
            set
            {
                _state.CreatedBy = value;
            }
        }
		public virtual DateTime? CreatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("CreatedAt"))
                {
                    return _state.CreatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.CreatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.CreatedAt = value.Value;
                }
            }
        }
		public virtual string UpdatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("UpdatedBy"))
                {
                    return _state.UpdatedBy;
                }
                return null;
            }
            set
            {
                _state.UpdatedBy = value;
            }
        }
		public virtual DateTime? UpdatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("UpdatedAt"))
                {
                    return _state.UpdatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.UpdatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.UpdatedAt = value.Value;
                }
            }
        }

		#region IIdentity implementation

		AttributeValueId IGlobalIdentity<AttributeValueId>.GlobalId
		{
			get { return (_state as IAttributeValueMvoState).GlobalId; }
		}

		#endregion


		#region IActive implementation

		bool IActive.IsActive()
		{
            return (_state as IActive).IsActive();
		}

		#endregion

		#region IDeleted implementation

		bool IDeleted.Deleted
		{
            get { return (_state as IDeleted).Deleted; }
		}

		#endregion

		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
            get { return (_state as IAttributeValueMvoState).CreatedBy; }
            set { (_state as IAttributeValueMvoState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IAttributeValueMvoState).CreatedAt; }
            set { (_state as IAttributeValueMvoState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IAttributeValueMvoState).UpdatedBy; }
            set { (_state as IAttributeValueMvoState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IAttributeValueMvoState).UpdatedAt; }
            set { (_state as IAttributeValueMvoState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
            get { return (_state as IAttributeValueMvoStateProperties).AttributeVersion; }
		}

		#endregion

        bool IAttributeValueMvoState.IsUnsaved
        {
            get { return this.AttributeVersion == AttributeValueMvoState.VersionZero; }
        }


		void IAttributeValueMvoState.When(IAttributeValueMvoStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IAttributeValueMvoState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IAttributeValueMvoState.When(IAttributeValueMvoStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IAttributeValueMvoState.When(IAttributeValueMvoStateDeleted e)
		{
            throw new NotSupportedException();
		}


		void IAttributeValueMvoState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////


	}

    partial class AttributeValueMvoStateDtoWrapperCollection : StateDtoWrapperCollectionBase<AttributeValueMvoStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(AttributeValueMvoStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

