﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{

	public partial class InOutNoticeStateDtoWrapper : StateDtoWrapperBase, IInOutNoticeStateDto, IInOutNoticeState
	{

        internal static IList<string> _collectionFieldNames = new string[] {  };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IInOutNoticeState _state;

        public InOutNoticeStateDtoWrapper()
        {
            this._state = new InOutNoticeState();
        }

		public InOutNoticeStateDtoWrapper(IInOutNoticeState state)
		{
            this._state = state;
		}

		public IInOutNoticeState ToInOutNoticeState()
		{
			return this._state;
		}

		public virtual string InOutNoticeId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InOutNoticeId"))
                {
                    return _state.InOutNoticeId;
                }
                return null;
            }
            set
            {
                _state.InOutNoticeId = value;
            }
        }

        string IInOutNoticeStateProperties.InOutNoticeId
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).InOutNoticeId;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).InOutNoticeId = value;
            }
        }

		public virtual string WarehouseId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("WarehouseId"))
                {
                    return _state.WarehouseId;
                }
                return null;
            }
            set
            {
                _state.WarehouseId = value;
            }
        }

        string IInOutNoticeStateProperties.WarehouseId
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).WarehouseId;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).WarehouseId = value;
            }
        }

		public virtual string InOutNoticeType
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("InOutNoticeType"))
                {
                    return _state.InOutNoticeType;
                }
                return null;
            }
            set
            {
                _state.InOutNoticeType = value;
            }
        }

        string IInOutNoticeStateProperties.InOutNoticeType
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).InOutNoticeType;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).InOutNoticeType = value;
            }
        }

		public virtual string TelecomContactMechId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("TelecomContactMechId"))
                {
                    return _state.TelecomContactMechId;
                }
                return null;
            }
            set
            {
                _state.TelecomContactMechId = value;
            }
        }

        string IInOutNoticeStateProperties.TelecomContactMechId
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).TelecomContactMechId;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).TelecomContactMechId = value;
            }
        }

		public virtual string TrackingNumber
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("TrackingNumber"))
                {
                    return _state.TrackingNumber;
                }
                return null;
            }
            set
            {
                _state.TrackingNumber = value;
            }
        }

        string IInOutNoticeStateProperties.TrackingNumber
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).TrackingNumber;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).TrackingNumber = value;
            }
        }

		public virtual string ContactPartyId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ContactPartyId"))
                {
                    return _state.ContactPartyId;
                }
                return null;
            }
            set
            {
                _state.ContactPartyId = value;
            }
        }

        string IInOutNoticeStateProperties.ContactPartyId
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).ContactPartyId;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).ContactPartyId = value;
            }
        }

		public virtual string VehiclePlateNumber
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("VehiclePlateNumber"))
                {
                    return _state.VehiclePlateNumber;
                }
                return null;
            }
            set
            {
                _state.VehiclePlateNumber = value;
            }
        }

        string IInOutNoticeStateProperties.VehiclePlateNumber
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).VehiclePlateNumber;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).VehiclePlateNumber = value;
            }
        }

		public virtual string ShippingInstructions
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ShippingInstructions"))
                {
                    return _state.ShippingInstructions;
                }
                return null;
            }
            set
            {
                _state.ShippingInstructions = value;
            }
        }

        string IInOutNoticeStateProperties.ShippingInstructions
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).ShippingInstructions;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).ShippingInstructions = value;
            }
        }

		public virtual DateTime? EstimatedShipDate
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("EstimatedShipDate"))
                {
                    return _state.EstimatedShipDate;
                }
                return null;
            }
            set
            {
                _state.EstimatedShipDate = value;
            }
        }

        DateTime? IInOutNoticeStateProperties.EstimatedShipDate
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).EstimatedShipDate;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).EstimatedShipDate = value;
            }
        }

		public virtual DateTime? EstimatedDeliveryDate
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("EstimatedDeliveryDate"))
                {
                    return _state.EstimatedDeliveryDate;
                }
                return null;
            }
            set
            {
                _state.EstimatedDeliveryDate = value;
            }
        }

        DateTime? IInOutNoticeStateProperties.EstimatedDeliveryDate
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).EstimatedDeliveryDate;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).EstimatedDeliveryDate = value;
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

        string IInOutNoticeStateProperties.StatusId
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).StatusId;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).StatusId = value;
            }
        }

		public virtual bool? Active
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Active"))
                {
                    return (this._state as IInOutNoticeStateProperties).Active;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IInOutNoticeStateProperties).Active = value.Value;
                }
            }
        }

        bool IInOutNoticeStateProperties.Active
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).Active;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).Active = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IInOutNoticeStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IInOutNoticeStateProperties).Version = value.Value;
                }
            }
        }

        long IInOutNoticeStateProperties.Version
        {
            get 
            {
                return (this._state as IInOutNoticeStateProperties).Version;
            }
            set 
            {
                (this._state as IInOutNoticeStateProperties).Version = value;
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
			get { return (_state as IInOutNoticeState).GlobalId; }
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
            get { return (_state as IInOutNoticeState).CreatedBy; }
            set { (_state as IInOutNoticeState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IInOutNoticeState).CreatedAt; }
            set { (_state as IInOutNoticeState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IInOutNoticeState).UpdatedBy; }
            set { (_state as IInOutNoticeState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IInOutNoticeState).UpdatedAt; }
            set { (_state as IInOutNoticeState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
            get { return (_state as IInOutNoticeStateProperties).Version; }
		}

		#endregion

        bool IInOutNoticeState.IsUnsaved
        {
            get { return this.Version == InOutNoticeState.VersionZero; }
        }

		void IInOutNoticeState.When(IInOutNoticeStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IInOutNoticeState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IInOutNoticeState.When(IInOutNoticeStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IInOutNoticeState.When(IInOutNoticeStateDeleted e)
		{
            throw new NotSupportedException();
		}

		void IInOutNoticeState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////

	}

    partial class InOutNoticeStateDtoWrapperCollection : StateDtoWrapperCollectionBase<InOutNoticeStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(InOutNoticeStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

