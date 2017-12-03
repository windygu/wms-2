﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEntryMvo;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItemEntryMvo
{

	public partial class InventoryItemEntryMvoStateDtoWrapper : StateDtoWrapperBase, IInventoryItemEntryMvoStateDto, IInventoryItemEntryMvoState
	{

        internal static IList<string> _collectionFieldNames = new string[] {  };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IInventoryItemEntryMvoState _state;

        public InventoryItemEntryMvoStateDtoWrapper()
        {
            this._state = new InventoryItemEntryMvoState();
        }

		public InventoryItemEntryMvoStateDtoWrapper(IInventoryItemEntryMvoState state)
		{
            this._state = state;
		}

		public IInventoryItemEntryMvoState ToInventoryItemEntryMvoState()
		{
			return this._state;
		}

        public InventoryItemEntryIdDto InventoryItemEntryId
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemEntryId"))
                {
					return (_state.InventoryItemEntryId == null) ? null : new InventoryItemEntryIdDtoWrapper(_state.InventoryItemEntryId);
                }
                return null;
            }
            set
            {
                _state.InventoryItemEntryId = (value == null) ? null : value.ToInventoryItemEntryId();
            }
        }

        InventoryItemEntryId IInventoryItemEntryMvoStateProperties.InventoryItemEntryId
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemEntryId;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemEntryId = value;
            }
        }

		public virtual decimal? QuantityOnHand
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("QuantityOnHand"))
                {
                    return _state.QuantityOnHand;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.QuantityOnHand = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.QuantityOnHand
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).QuantityOnHand;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).QuantityOnHand = value;
            }
        }

		public virtual decimal? QuantityReserved
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("QuantityReserved"))
                {
                    return _state.QuantityReserved;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.QuantityReserved = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.QuantityReserved
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).QuantityReserved;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).QuantityReserved = value;
            }
        }

		public virtual decimal? QuantityOccupied
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("QuantityOccupied"))
                {
                    return _state.QuantityOccupied;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.QuantityOccupied = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.QuantityOccupied
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).QuantityOccupied;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).QuantityOccupied = value;
            }
        }

		public virtual decimal? QuantityVirtual
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("QuantityVirtual"))
                {
                    return _state.QuantityVirtual;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.QuantityVirtual = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.QuantityVirtual
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).QuantityVirtual;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).QuantityVirtual = value;
            }
        }

        public InventoryItemSourceVODto Source
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Source"))
                {
					return (_state.Source == null) ? null : new InventoryItemSourceVODtoWrapper(_state.Source);
                }
                return null;
            }
            set
            {
                _state.Source = (value == null) ? null : value.ToInventoryItemSourceVO();
            }
        }

        InventoryItemSourceVO IInventoryItemEntryMvoStateProperties.Source
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).Source;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).Source = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IInventoryItemEntryMvoStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IInventoryItemEntryMvoStateProperties).Version = value.Value;
                }
            }
        }

        long IInventoryItemEntryMvoStateProperties.Version
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).Version;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).Version = value;
            }
        }

		public virtual decimal? InventoryItemQuantityOnHand
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemQuantityOnHand"))
                {
                    return _state.InventoryItemQuantityOnHand;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemQuantityOnHand = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.InventoryItemQuantityOnHand
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityOnHand;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityOnHand = value;
            }
        }

		public virtual decimal? InventoryItemQuantityReserved
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemQuantityReserved"))
                {
                    return _state.InventoryItemQuantityReserved;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemQuantityReserved = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.InventoryItemQuantityReserved
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityReserved;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityReserved = value;
            }
        }

		public virtual decimal? InventoryItemQuantityOccupied
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemQuantityOccupied"))
                {
                    return _state.InventoryItemQuantityOccupied;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemQuantityOccupied = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.InventoryItemQuantityOccupied
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityOccupied;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityOccupied = value;
            }
        }

		public virtual decimal? InventoryItemQuantityVirtual
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemQuantityVirtual"))
                {
                    return _state.InventoryItemQuantityVirtual;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemQuantityVirtual = value.Value;
                }
            }
        }

        decimal IInventoryItemEntryMvoStateProperties.InventoryItemQuantityVirtual
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityVirtual;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemQuantityVirtual = value;
            }
        }

		public virtual string InventoryItemCreatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemCreatedBy"))
                {
                    return _state.InventoryItemCreatedBy;
                }
                return null;
            }
            set
            {
                _state.InventoryItemCreatedBy = value;
            }
        }

        string IInventoryItemEntryMvoStateProperties.InventoryItemCreatedBy
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemCreatedBy;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemCreatedBy = value;
            }
        }

		public virtual DateTime? InventoryItemCreatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemCreatedAt"))
                {
                    return _state.InventoryItemCreatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.InventoryItemCreatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemCreatedAt = value.Value;
                }
            }
        }

        DateTime IInventoryItemEntryMvoStateProperties.InventoryItemCreatedAt
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemCreatedAt;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemCreatedAt = value;
            }
        }

		public virtual string InventoryItemUpdatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemUpdatedBy"))
                {
                    return _state.InventoryItemUpdatedBy;
                }
                return null;
            }
            set
            {
                _state.InventoryItemUpdatedBy = value;
            }
        }

        string IInventoryItemEntryMvoStateProperties.InventoryItemUpdatedBy
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemUpdatedBy;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemUpdatedBy = value;
            }
        }

		public virtual DateTime? InventoryItemUpdatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemUpdatedAt"))
                {
                    return _state.InventoryItemUpdatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.InventoryItemUpdatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemUpdatedAt = value.Value;
                }
            }
        }

        DateTime IInventoryItemEntryMvoStateProperties.InventoryItemUpdatedAt
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemUpdatedAt;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemUpdatedAt = value;
            }
        }

		public virtual long? InventoryItemVersion
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InventoryItemVersion"))
                {
                    return _state.InventoryItemVersion;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.InventoryItemVersion = value.Value;
                }
            }
        }

        long IInventoryItemEntryMvoStateProperties.InventoryItemVersion
        {
            get 
            {
                return (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemVersion;
            }
            set 
            {
                (this._state as IInventoryItemEntryMvoStateProperties).InventoryItemVersion = value;
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

		InventoryItemEntryId IGlobalIdentity<InventoryItemEntryId>.GlobalId
		{
			get { return (_state as IInventoryItemEntryMvoState).GlobalId; }
		}

		#endregion

		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
            get { return (_state as IInventoryItemEntryMvoState).CreatedBy; }
            set { (_state as IInventoryItemEntryMvoState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IInventoryItemEntryMvoState).CreatedAt; }
            set { (_state as IInventoryItemEntryMvoState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IInventoryItemEntryMvoState).UpdatedBy; }
            set { (_state as IInventoryItemEntryMvoState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IInventoryItemEntryMvoState).UpdatedAt; }
            set { (_state as IInventoryItemEntryMvoState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
            get { return (_state as IInventoryItemEntryMvoStateProperties).InventoryItemVersion; }
		}

		#endregion

        bool IInventoryItemEntryMvoState.IsUnsaved
        {
            get { return this.InventoryItemVersion == InventoryItemEntryMvoState.VersionZero; }
        }

		void IInventoryItemEntryMvoState.When(IInventoryItemEntryMvoStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IInventoryItemEntryMvoState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IInventoryItemEntryMvoState.When(IInventoryItemEntryMvoStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IInventoryItemEntryMvoState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////

	}

    partial class InventoryItemEntryMvoStateDtoWrapperCollection : StateDtoWrapperCollectionBase<InventoryItemEntryMvoStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(InventoryItemEntryMvoStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

