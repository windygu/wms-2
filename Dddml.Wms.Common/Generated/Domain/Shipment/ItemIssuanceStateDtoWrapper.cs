﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

	public partial class ItemIssuanceStateDtoWrapper : StateDtoWrapperBase, IItemIssuanceStateDto, IItemIssuanceState
	{

        internal static IList<string> _collectionFieldNames = new string[] {  };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IItemIssuanceState _state;

        public ItemIssuanceStateDtoWrapper()
        {
            this._state = new ItemIssuanceState();
        }

		public ItemIssuanceStateDtoWrapper(IItemIssuanceState state)
		{
            this._state = state;
		}

		public IItemIssuanceState ToItemIssuanceState()
		{
			return this._state;
		}

		public virtual string ItemIssuanceSeqId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ItemIssuanceSeqId"))
                {
                    return _state.ItemIssuanceSeqId;
                }
                return null;
            }
            set
            {
                _state.ItemIssuanceSeqId = value;
            }
        }

        string IItemIssuanceStateProperties.ItemIssuanceSeqId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).ItemIssuanceSeqId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).ItemIssuanceSeqId = value;
            }
        }

		public virtual string OrderId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("OrderId"))
                {
                    return _state.OrderId;
                }
                return null;
            }
            set
            {
                _state.OrderId = value;
            }
        }

        string IItemIssuanceStateProperties.OrderId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).OrderId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).OrderId = value;
            }
        }

		public virtual string OrderItemSeqId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("OrderItemSeqId"))
                {
                    return _state.OrderItemSeqId;
                }
                return null;
            }
            set
            {
                _state.OrderItemSeqId = value;
            }
        }

        string IItemIssuanceStateProperties.OrderItemSeqId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).OrderItemSeqId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).OrderItemSeqId = value;
            }
        }

		public virtual string ShipGroupSeqId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ShipGroupSeqId"))
                {
                    return _state.ShipGroupSeqId;
                }
                return null;
            }
            set
            {
                _state.ShipGroupSeqId = value;
            }
        }

        string IItemIssuanceStateProperties.ShipGroupSeqId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).ShipGroupSeqId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).ShipGroupSeqId = value;
            }
        }

		public virtual string ProductId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ProductId"))
                {
                    return _state.ProductId;
                }
                return null;
            }
            set
            {
                _state.ProductId = value;
            }
        }

        string IItemIssuanceStateProperties.ProductId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).ProductId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).ProductId = value;
            }
        }

		public virtual string LocatorId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("LocatorId"))
                {
                    return _state.LocatorId;
                }
                return null;
            }
            set
            {
                _state.LocatorId = value;
            }
        }

        string IItemIssuanceStateProperties.LocatorId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).LocatorId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).LocatorId = value;
            }
        }

		public virtual string AttributeSetInstanceId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("AttributeSetInstanceId"))
                {
                    return _state.AttributeSetInstanceId;
                }
                return null;
            }
            set
            {
                _state.AttributeSetInstanceId = value;
            }
        }

        string IItemIssuanceStateProperties.AttributeSetInstanceId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).AttributeSetInstanceId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).AttributeSetInstanceId = value;
            }
        }

		public virtual string ShipmentItemSeqId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ShipmentItemSeqId"))
                {
                    return _state.ShipmentItemSeqId;
                }
                return null;
            }
            set
            {
                _state.ShipmentItemSeqId = value;
            }
        }

        string IItemIssuanceStateProperties.ShipmentItemSeqId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).ShipmentItemSeqId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).ShipmentItemSeqId = value;
            }
        }

		public virtual string FixedAssetId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("FixedAssetId"))
                {
                    return _state.FixedAssetId;
                }
                return null;
            }
            set
            {
                _state.FixedAssetId = value;
            }
        }

        string IItemIssuanceStateProperties.FixedAssetId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).FixedAssetId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).FixedAssetId = value;
            }
        }

		public virtual string MaintHistSeqId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("MaintHistSeqId"))
                {
                    return _state.MaintHistSeqId;
                }
                return null;
            }
            set
            {
                _state.MaintHistSeqId = value;
            }
        }

        string IItemIssuanceStateProperties.MaintHistSeqId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).MaintHistSeqId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).MaintHistSeqId = value;
            }
        }

		public virtual DateTime? IssuedDateTime
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("IssuedDateTime"))
                {
                    return _state.IssuedDateTime;
                }
                return null;
            }
            set
            {
                _state.IssuedDateTime = value;
            }
        }

        DateTime? IItemIssuanceStateProperties.IssuedDateTime
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).IssuedDateTime;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).IssuedDateTime = value;
            }
        }

		public virtual string IssuedByUserLoginId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("IssuedByUserLoginId"))
                {
                    return _state.IssuedByUserLoginId;
                }
                return null;
            }
            set
            {
                _state.IssuedByUserLoginId = value;
            }
        }

        string IItemIssuanceStateProperties.IssuedByUserLoginId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).IssuedByUserLoginId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).IssuedByUserLoginId = value;
            }
        }

		public virtual decimal? Quantity
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Quantity"))
                {
                    return _state.Quantity;
                }
                return null;
            }
            set
            {
                _state.Quantity = value;
            }
        }

        decimal? IItemIssuanceStateProperties.Quantity
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).Quantity;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).Quantity = value;
            }
        }

		public virtual decimal? CancelQuantity
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("CancelQuantity"))
                {
                    return _state.CancelQuantity;
                }
                return null;
            }
            set
            {
                _state.CancelQuantity = value;
            }
        }

        decimal? IItemIssuanceStateProperties.CancelQuantity
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).CancelQuantity;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).CancelQuantity = value;
            }
        }

		public virtual bool? Active
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Active"))
                {
                    return (this._state as IItemIssuanceStateProperties).Active;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IItemIssuanceStateProperties).Active = value.Value;
                }
            }
        }

        bool IItemIssuanceStateProperties.Active
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).Active;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).Active = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IItemIssuanceStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IItemIssuanceStateProperties).Version = value.Value;
                }
            }
        }

        long IItemIssuanceStateProperties.Version
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).Version;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).Version = value;
            }
        }

		public virtual string ShipmentId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ShipmentId"))
                {
                    return _state.ShipmentId;
                }
                return null;
            }
            set
            {
                _state.ShipmentId = value;
            }
        }

        string IItemIssuanceStateProperties.ShipmentId
        {
            get 
            {
                return (this._state as IItemIssuanceStateProperties).ShipmentId;
            }
            set 
            {
                (this._state as IItemIssuanceStateProperties).ShipmentId = value;
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


		ShipmentItemIssuanceId IGlobalIdentity<ShipmentItemIssuanceId>.GlobalId {
			get { return (_state as IItemIssuanceState).GlobalId; }
		}

        string ILocalIdentity<string>.LocalId
        {
			get { return (_state as IItemIssuanceState).LocalId; }
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
            get { return (_state as IItemIssuanceState).CreatedBy; }
            set { (_state as IItemIssuanceState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IItemIssuanceState).CreatedAt; }
            set { (_state as IItemIssuanceState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IItemIssuanceState).UpdatedBy; }
            set { (_state as IItemIssuanceState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IItemIssuanceState).UpdatedAt; }
            set { (_state as IItemIssuanceState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IEntityVersioned<long>.EntityVersion
		{
            get { return (_state as IItemIssuanceStateProperties).Version; }
		}

		#endregion

        bool IItemIssuanceState.IsUnsaved
        {
            get { return this.Version == ItemIssuanceState.VersionZero; }
        }

		void IItemIssuanceState.When(IItemIssuanceStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IItemIssuanceState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IItemIssuanceState.When(IItemIssuanceStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IItemIssuanceState.When(IItemIssuanceStateRemoved e)
		{
            throw new NotSupportedException();
		}

		void IItemIssuanceState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////

	}

    partial class ItemIssuanceStateDtoWrapperCollection : StateDtoWrapperCollectionBase<ItemIssuanceStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(ItemIssuanceStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

