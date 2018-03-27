﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Picklist;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Picklist
{

	public partial class PicklistStateDtoWrapper : StateDtoWrapperBase, IPicklistStateDto, IPicklistState
	{

        internal static IList<string> _collectionFieldNames = new string[] { "PicklistRoles" };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IPicklistState _state;

        public PicklistStateDtoWrapper()
        {
            this._state = new PicklistState();
        }

		public PicklistStateDtoWrapper(IPicklistState state)
		{
            this._state = state;
		}

		public IPicklistState ToPicklistState()
		{
			return this._state;
		}

		public virtual string PicklistId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PicklistId"))
                {
                    return _state.PicklistId;
                }
                return null;
            }
            set
            {
                _state.PicklistId = value;
            }
        }

        string IPicklistStateProperties.PicklistId
        {
            get 
            {
                return (this._state as IPicklistStateProperties).PicklistId;
            }
            set 
            {
                (this._state as IPicklistStateProperties).PicklistId = value;
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

        string IPicklistStateProperties.Description
        {
            get 
            {
                return (this._state as IPicklistStateProperties).Description;
            }
            set 
            {
                (this._state as IPicklistStateProperties).Description = value;
            }
        }

		public virtual string FacilityId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("FacilityId"))
                {
                    return _state.FacilityId;
                }
                return null;
            }
            set
            {
                _state.FacilityId = value;
            }
        }

        string IPicklistStateProperties.FacilityId
        {
            get 
            {
                return (this._state as IPicklistStateProperties).FacilityId;
            }
            set 
            {
                (this._state as IPicklistStateProperties).FacilityId = value;
            }
        }

		public virtual string ShipmentMethodTypeId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ShipmentMethodTypeId"))
                {
                    return _state.ShipmentMethodTypeId;
                }
                return null;
            }
            set
            {
                _state.ShipmentMethodTypeId = value;
            }
        }

        string IPicklistStateProperties.ShipmentMethodTypeId
        {
            get 
            {
                return (this._state as IPicklistStateProperties).ShipmentMethodTypeId;
            }
            set 
            {
                (this._state as IPicklistStateProperties).ShipmentMethodTypeId = value;
            }
        }

		public virtual string StatusId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("StatusId"))
                {
                    return _state.StatusId;
                }
                return null;
            }
            set
            {
                _state.StatusId = value;
            }
        }

        string IPicklistStateProperties.StatusId
        {
            get 
            {
                return (this._state as IPicklistStateProperties).StatusId;
            }
            set 
            {
                (this._state as IPicklistStateProperties).StatusId = value;
            }
        }

		public virtual DateTime? PicklistDate
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PicklistDate"))
                {
                    return _state.PicklistDate;
                }
                return null;
            }
            set
            {
                _state.PicklistDate = value;
            }
        }

        DateTime? IPicklistStateProperties.PicklistDate
        {
            get 
            {
                return (this._state as IPicklistStateProperties).PicklistDate;
            }
            set 
            {
                (this._state as IPicklistStateProperties).PicklistDate = value;
            }
        }

		public virtual long? PickwaveId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PickwaveId"))
                {
                    return _state.PickwaveId;
                }
                return null;
            }
            set
            {
                _state.PickwaveId = value;
            }
        }

        long? IPicklistStateProperties.PickwaveId
        {
            get 
            {
                return (this._state as IPicklistStateProperties).PickwaveId;
            }
            set 
            {
                (this._state as IPicklistStateProperties).PickwaveId = value;
            }
        }

		public virtual bool? Active
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Active"))
                {
                    return (this._state as IPicklistStateProperties).Active;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IPicklistStateProperties).Active = value.Value;
                }
            }
        }

        bool IPicklistStateProperties.Active
        {
            get 
            {
                return (this._state as IPicklistStateProperties).Active;
            }
            set 
            {
                (this._state as IPicklistStateProperties).Active = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IPicklistStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IPicklistStateProperties).Version = value.Value;
                }
            }
        }

        long IPicklistStateProperties.Version
        {
            get 
            {
                return (this._state as IPicklistStateProperties).Version;
            }
            set 
            {
                (this._state as IPicklistStateProperties).Version = value;
            }
        }

		public virtual string CreatedByUserLogin
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("CreatedByUserLogin"))
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

		public virtual string LastModifiedByUserLogin
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("LastModifiedByUserLogin"))
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
			get { return (_state as IPicklistState).GlobalId; }
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
            get { return (_state as IPicklistState).CreatedBy; }
            set { (_state as IPicklistState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IPicklistState).CreatedAt; }
            set { (_state as IPicklistState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IPicklistState).UpdatedBy; }
            set { (_state as IPicklistState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IPicklistState).UpdatedAt; }
            set { (_state as IPicklistState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
            get { return (_state as IPicklistStateProperties).Version; }
		}

		#endregion

        bool IPicklistState.IsUnsaved
        {
            get { return this.Version == PicklistState.VersionZero; }
        }

        public virtual IPicklistRoleStateDto[] PicklistRoles
        {
            get 
            {
                if (!(this as IStateDtoWrapper).ReturnedFieldsContains("PicklistRoles"))
                {
                    return null;
                }
                var dtos = new List<IPicklistRoleStateDto>();
                if (this._state.PicklistRoles != null)
                {
                    foreach (var s in this._state.PicklistRoles)
                    {
                        var dto = new PicklistRoleStateDtoWrapper((PicklistRoleState)s);
                        var returnFS = CollectionUtils.DictionaryGetValueIgnoringCase(ReturnedFields, "PicklistRoles");
                        if (!String.IsNullOrWhiteSpace(returnFS))
                        {
                            (dto as IStateDtoWrapper).ReturnedFieldsString = returnFS;
                        }
                        else
                        {
                            (dto as IStateDtoWrapper).AllFieldsReturned = this.AllFieldsReturned;
                        }
                        dtos.Add(dto);
                    }
                }
                return dtos.ToArray();
            }
            set 
            {
                if (value == null) { value = new PicklistRoleStateDtoWrapper[0]; }
                var states = new List<IPicklistRoleState>();
                foreach (var s in value)
                {
                    states.Add(s.ToPicklistRoleState());
                }
                this._state.PicklistRoles = new DtoPicklistRoleStates(this._state, states);
            }
        }

        IPicklistRoleStates IPicklistState.PicklistRoles
        {
            get { return _state.PicklistRoles; }
            set { _state.PicklistRoles = value; }
        }

		void IPicklistState.When(IPicklistStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IPicklistState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IPicklistState.When(IPicklistStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IPicklistState.When(IPicklistStateDeleted e)
		{
            throw new NotSupportedException();
		}

		void IPicklistState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////

        public class DtoPicklistRoleStates : IPicklistRoleStates
        {

            private IPicklistState _outerState;

            private IEnumerable<IPicklistRoleState> _innerStates;

            public DtoPicklistRoleStates(IPicklistState outerState, IEnumerable<IPicklistRoleState> innerStates)
            {
                this._outerState = outerState;
                if (innerStates == null)
                {
                    this._innerStates = new IPicklistRoleState[] { };
                }
                else
                {
                    this._innerStates = innerStates;
                }
            }

            public IEnumerator<IPicklistRoleState> GetEnumerator()
            {
                return _innerStates.GetEnumerator();
            }

            System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
            {
                return _innerStates.GetEnumerator();
            }

            public IPicklistRoleState Get(PartyRoleId partyRoleId)
            {
                throw new NotSupportedException();
            }

            public IPicklistRoleState Get(PartyRoleId partyRoleId, bool forCreation)
            {
                throw new NotSupportedException();
            }

            public IPicklistRoleState Get(PartyRoleId partyRoleId, bool forCreation, bool nullAllowed)
            {
                throw new NotSupportedException();
            }

            public void Remove(IPicklistRoleState state)
            {
                throw new NotSupportedException();
            }

            public void AddToSave(IPicklistRoleState state)
            {
                throw new NotSupportedException();
            }

            public void Save()
            {
                throw new NotSupportedException();
            }
        }

	}

    partial class PicklistStateDtoWrapperCollection : StateDtoWrapperCollectionBase<PicklistStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(PicklistStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

