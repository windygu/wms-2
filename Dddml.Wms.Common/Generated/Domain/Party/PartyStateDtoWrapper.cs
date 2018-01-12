﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePartyDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Party;

namespace Dddml.Wms.Domain.Party
{

	public partial class PartyStateDtoWrapper : StateDtoWrapperBase, IPartyStateDto, IPartyState
	{

        internal static IList<string> _collectionFieldNames = new string[] {  };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IPartyState _state;

        public PartyStateDtoWrapper()
        {
            this._state = new PartyState();
        }

		public PartyStateDtoWrapper(IPartyState state)
		{
            this._state = state;
		}

		public IPartyState ToPartyState()
		{
			return this._state;
		}

		public virtual string PartyId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PartyId"))
                {
                    return _state.PartyId;
                }
                return null;
            }
            set
            {
                _state.PartyId = value;
            }
        }

        string IPartyStateProperties.PartyId
        {
            get 
            {
                return (this._state as IPartyStateProperties).PartyId;
            }
            set 
            {
                (this._state as IPartyStateProperties).PartyId = value;
            }
        }

		public virtual string PartyTypeId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PartyTypeId"))
                {
                    return _state.PartyTypeId;
                }
                return null;
            }
            set
            {
                _state.PartyTypeId = value;
            }
        }

        string IPartyStateProperties.PartyTypeId
        {
            get 
            {
                return (this._state as IPartyStateProperties).PartyTypeId;
            }
            set 
            {
                (this._state as IPartyStateProperties).PartyTypeId = value;
            }
        }

		public virtual string OrganizationName
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("OrganizationName"))
                {
                    return _state.OrganizationName;
                }
                return null;
            }
            set
            {
                _state.OrganizationName = value;
            }
        }

        string IPartyStateProperties.OrganizationName
        {
            get 
            {
                return (this._state as IPartyStateProperties).OrganizationName;
            }
            set 
            {
                (this._state as IPartyStateProperties).OrganizationName = value;
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

        string IPartyStateProperties.Description
        {
            get 
            {
                return (this._state as IPartyStateProperties).Description;
            }
            set 
            {
                (this._state as IPartyStateProperties).Description = value;
            }
        }

		public virtual string Type
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Type"))
                {
                    return _state.Type;
                }
                return null;
            }
            set
            {
                _state.Type = value;
            }
        }

        string IPartyStateProperties.Type
        {
            get 
            {
                return (this._state as IPartyStateProperties).Type;
            }
            set 
            {
                (this._state as IPartyStateProperties).Type = value;
            }
        }

		public virtual bool? IsSummary
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("IsSummary"))
                {
                    return _state.IsSummary;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.IsSummary = value.Value;
                }
            }
        }

        bool IPartyStateProperties.IsSummary
        {
            get 
            {
                return (this._state as IPartyStateProperties).IsSummary;
            }
            set 
            {
                (this._state as IPartyStateProperties).IsSummary = value;
            }
        }

		public virtual bool? Active
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Active"))
                {
                    return (this._state as IPartyStateProperties).Active;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IPartyStateProperties).Active = value.Value;
                }
            }
        }

        bool IPartyStateProperties.Active
        {
            get 
            {
                return (this._state as IPartyStateProperties).Active;
            }
            set 
            {
                (this._state as IPartyStateProperties).Active = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IPartyStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IPartyStateProperties).Version = value.Value;
                }
            }
        }

        long IPartyStateProperties.Version
        {
            get 
            {
                return (this._state as IPartyStateProperties).Version;
            }
            set 
            {
                (this._state as IPartyStateProperties).Version = value;
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

		string IGlobalIdentity<string>.GlobalId
		{
			get { return (_state as IPartyState).GlobalId; }
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
            get { return (_state as IPartyState).CreatedBy; }
            set { (_state as IPartyState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IPartyState).CreatedAt; }
            set { (_state as IPartyState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IPartyState).UpdatedBy; }
            set { (_state as IPartyState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IPartyState).UpdatedAt; }
            set { (_state as IPartyState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
            get { return (_state as IPartyStateProperties).Version; }
		}

		#endregion

        bool IPartyState.IsUnsaved
        {
            get { return this.Version == PartyState.VersionZero; }
        }

		void IPartyState.When(IPartyStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IPartyState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IPartyState.When(IPartyStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IPartyState.When(IPartyStateDeleted e)
		{
            throw new NotSupportedException();
		}

		void IPartyState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////

	}

    partial class PartyStateDtoWrapperCollection : StateDtoWrapperCollectionBase<PartyStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(PartyStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

