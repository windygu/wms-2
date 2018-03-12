﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryLineMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventoryLineMvo;
using Dddml.Wms.Domain.PhysicalInventory;

namespace Dddml.Wms.Domain.PhysicalInventoryLineMvo
{

	public partial class PhysicalInventoryLineMvoStateDtoWrapper : StateDtoWrapperBase, IPhysicalInventoryLineMvoStateDto, IPhysicalInventoryLineMvoState
	{

        internal static IList<string> _collectionFieldNames = new string[] {  };

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(_collectionFieldNames, fieldName);
        }

		private IPhysicalInventoryLineMvoState _state;

        public PhysicalInventoryLineMvoStateDtoWrapper()
        {
            this._state = new PhysicalInventoryLineMvoState();
        }

		public PhysicalInventoryLineMvoStateDtoWrapper(IPhysicalInventoryLineMvoState state)
		{
            this._state = state;
		}

		public IPhysicalInventoryLineMvoState ToPhysicalInventoryLineMvoState()
		{
			return this._state;
		}

		public virtual PhysicalInventoryLineId PhysicalInventoryLineId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryLineId"))
                {
                    return _state.PhysicalInventoryLineId;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryLineId = value;
            }
        }

        PhysicalInventoryLineId IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryLineId
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryLineId;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryLineId = value;
            }
        }

		public virtual decimal? BookQuantity
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("BookQuantity"))
                {
                    return _state.BookQuantity;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.BookQuantity = value.Value;
                }
            }
        }

        decimal IPhysicalInventoryLineMvoStateProperties.BookQuantity
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).BookQuantity;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).BookQuantity = value;
            }
        }

		public virtual decimal? CountedQuantity
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("CountedQuantity"))
                {
                    return _state.CountedQuantity;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.CountedQuantity = value.Value;
                }
            }
        }

        decimal IPhysicalInventoryLineMvoStateProperties.CountedQuantity
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).CountedQuantity;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).CountedQuantity = value;
            }
        }

		public virtual bool? Processed
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Processed"))
                {
                    return _state.Processed;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.Processed = value.Value;
                }
            }
        }

        bool IPhysicalInventoryLineMvoStateProperties.Processed
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).Processed;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).Processed = value;
            }
        }

		public virtual string LineNumber
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("LineNumber"))
                {
                    return _state.LineNumber;
                }
                return null;
            }
            set
            {
                _state.LineNumber = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.LineNumber
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).LineNumber;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).LineNumber = value;
            }
        }

		public virtual long? ReversalLineNumber
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("ReversalLineNumber"))
                {
                    return _state.ReversalLineNumber;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.ReversalLineNumber = value.Value;
                }
            }
        }

        long IPhysicalInventoryLineMvoStateProperties.ReversalLineNumber
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).ReversalLineNumber;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).ReversalLineNumber = value;
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

        string IPhysicalInventoryLineMvoStateProperties.Description
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).Description;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).Description = value;
            }
        }

		public virtual long? Version
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("Version"))
                {
                    return (this._state as IPhysicalInventoryLineMvoStateProperties).Version;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    (this._state as IPhysicalInventoryLineMvoStateProperties).Version = value.Value;
                }
            }
        }

        long IPhysicalInventoryLineMvoStateProperties.Version
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).Version;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).Version = value;
            }
        }

		public virtual string PhysicalInventoryDocumentStatusId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryDocumentStatusId"))
                {
                    return _state.PhysicalInventoryDocumentStatusId;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryDocumentStatusId = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryDocumentStatusId
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryDocumentStatusId;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryDocumentStatusId = value;
            }
        }

		public virtual string PhysicalInventoryWarehouseId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryWarehouseId"))
                {
                    return _state.PhysicalInventoryWarehouseId;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryWarehouseId = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryWarehouseId
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryWarehouseId;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryWarehouseId = value;
            }
        }

		public virtual string PhysicalInventoryLocatorIdPattern
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryLocatorIdPattern"))
                {
                    return _state.PhysicalInventoryLocatorIdPattern;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryLocatorIdPattern = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryLocatorIdPattern
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryLocatorIdPattern;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryLocatorIdPattern = value;
            }
        }

		public virtual string PhysicalInventoryProductIdPattern
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryProductIdPattern"))
                {
                    return _state.PhysicalInventoryProductIdPattern;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryProductIdPattern = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryProductIdPattern
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryProductIdPattern;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryProductIdPattern = value;
            }
        }

		public virtual bool? PhysicalInventoryPosted
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryPosted"))
                {
                    return _state.PhysicalInventoryPosted;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryPosted = value.Value;
                }
            }
        }

        bool IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryPosted
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryPosted;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryPosted = value;
            }
        }

		public virtual bool? PhysicalInventoryProcessed
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryProcessed"))
                {
                    return _state.PhysicalInventoryProcessed;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryProcessed = value.Value;
                }
            }
        }

        bool IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryProcessed
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryProcessed;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryProcessed = value;
            }
        }

		public virtual string PhysicalInventoryProcessing
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryProcessing"))
                {
                    return _state.PhysicalInventoryProcessing;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryProcessing = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryProcessing
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryProcessing;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryProcessing = value;
            }
        }

		public virtual string PhysicalInventoryDocumentTypeId
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryDocumentTypeId"))
                {
                    return _state.PhysicalInventoryDocumentTypeId;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryDocumentTypeId = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryDocumentTypeId
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryDocumentTypeId;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryDocumentTypeId = value;
            }
        }

		public virtual DateTime? PhysicalInventoryMovementDate
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryMovementDate"))
                {
                    return _state.PhysicalInventoryMovementDate;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryMovementDate = value;
            }
        }

        DateTime? IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryMovementDate
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryMovementDate;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryMovementDate = value;
            }
        }

		public virtual string PhysicalInventoryDescription
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryDescription"))
                {
                    return _state.PhysicalInventoryDescription;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryDescription = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryDescription
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryDescription;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryDescription = value;
            }
        }

		public virtual bool? PhysicalInventoryIsApproved
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryIsApproved"))
                {
                    return _state.PhysicalInventoryIsApproved;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryIsApproved = value.Value;
                }
            }
        }

        bool IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryIsApproved
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryIsApproved;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryIsApproved = value;
            }
        }

		public virtual decimal? PhysicalInventoryApprovalAmount
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryApprovalAmount"))
                {
                    return _state.PhysicalInventoryApprovalAmount;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryApprovalAmount = value.Value;
                }
            }
        }

        decimal IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryApprovalAmount
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryApprovalAmount;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryApprovalAmount = value;
            }
        }

		public virtual bool? PhysicalInventoryIsQuantityUpdated
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryIsQuantityUpdated"))
                {
                    return _state.PhysicalInventoryIsQuantityUpdated;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryIsQuantityUpdated = value.Value;
                }
            }
        }

        bool IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryIsQuantityUpdated
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryIsQuantityUpdated;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryIsQuantityUpdated = value;
            }
        }

		public virtual string PhysicalInventoryReversalDocumentNumber
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryReversalDocumentNumber"))
                {
                    return _state.PhysicalInventoryReversalDocumentNumber;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryReversalDocumentNumber = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryReversalDocumentNumber
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryReversalDocumentNumber;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryReversalDocumentNumber = value;
            }
        }

		public virtual string PhysicalInventoryCreatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryCreatedBy"))
                {
                    return _state.PhysicalInventoryCreatedBy;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryCreatedBy = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryCreatedBy
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryCreatedBy;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryCreatedBy = value;
            }
        }

		public virtual DateTime? PhysicalInventoryCreatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryCreatedAt"))
                {
                    return _state.PhysicalInventoryCreatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.PhysicalInventoryCreatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryCreatedAt = value.Value;
                }
            }
        }

        DateTime IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryCreatedAt
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryCreatedAt;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryCreatedAt = value;
            }
        }

		public virtual string PhysicalInventoryUpdatedBy
		{
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryUpdatedBy"))
                {
                    return _state.PhysicalInventoryUpdatedBy;
                }
                return null;
            }
            set
            {
                _state.PhysicalInventoryUpdatedBy = value;
            }
        }

        string IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryUpdatedBy
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryUpdatedBy;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryUpdatedBy = value;
            }
        }

		public virtual DateTime? PhysicalInventoryUpdatedAt
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryUpdatedAt"))
                {
                    return _state.PhysicalInventoryUpdatedAt.Date < default(DateTime).Date.AddDays(1) ? (DateTime?)null : _state.PhysicalInventoryUpdatedAt;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryUpdatedAt = value.Value;
                }
            }
        }

        DateTime IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryUpdatedAt
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryUpdatedAt;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryUpdatedAt = value;
            }
        }

		public virtual bool? PhysicalInventoryActive
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryActive"))
                {
                    return _state.PhysicalInventoryActive;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryActive = value.Value;
                }
            }
        }

        bool IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryActive
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryActive;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryActive = value;
            }
        }

		public virtual long? PhysicalInventoryVersion
        {
            get
            {
                if ((this as IStateDtoWrapper).ReturnedFieldsContains("PhysicalInventoryVersion"))
                {
                    return _state.PhysicalInventoryVersion;
                }
                return null;
            }
            set
            {
                if (value != null && value.HasValue)
                {
                    _state.PhysicalInventoryVersion = value.Value;
                }
            }
        }

        long IPhysicalInventoryLineMvoStateProperties.PhysicalInventoryVersion
        {
            get 
            {
                return (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryVersion;
            }
            set 
            {
                (this._state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryVersion = value;
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

		PhysicalInventoryLineId IGlobalIdentity<PhysicalInventoryLineId>.GlobalId
		{
			get { return (_state as IPhysicalInventoryLineMvoState).GlobalId; }
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
            get { return (_state as IPhysicalInventoryLineMvoState).CreatedBy; }
            set { (_state as IPhysicalInventoryLineMvoState).CreatedBy = value; }
		}

		DateTime ICreated<string>.CreatedAt
		{
            get { return (_state as IPhysicalInventoryLineMvoState).CreatedAt; }
            set { (_state as IPhysicalInventoryLineMvoState).CreatedAt = value; }
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
            get { return (_state as IPhysicalInventoryLineMvoState).UpdatedBy; }
            set { (_state as IPhysicalInventoryLineMvoState).UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
            get { return (_state as IPhysicalInventoryLineMvoState).UpdatedAt; }
            set { (_state as IPhysicalInventoryLineMvoState).UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
            get { return (_state as IPhysicalInventoryLineMvoStateProperties).PhysicalInventoryVersion; }
		}

		#endregion

        bool IPhysicalInventoryLineMvoState.IsUnsaved
        {
            get { return this.PhysicalInventoryVersion == PhysicalInventoryLineMvoState.VersionZero; }
        }

		void IPhysicalInventoryLineMvoState.When(IPhysicalInventoryLineMvoStateCreated e)
		{
            throw new NotSupportedException();
		}

		bool IPhysicalInventoryLineMvoState.ForReapplying
		{
            get { throw new NotSupportedException(); }
		}

        public bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }

		void IPhysicalInventoryLineMvoState.When(IPhysicalInventoryLineMvoStateMergePatched e)
		{
            throw new NotSupportedException();
		}

		void IPhysicalInventoryLineMvoState.When(IPhysicalInventoryLineMvoStateDeleted e)
		{
            throw new NotSupportedException();
		}

		void IPhysicalInventoryLineMvoState.Mutate(IEvent e)
		{
            throw new NotSupportedException();
		}

        // //////////////////////////////////////////////////////////////

	}

    partial class PhysicalInventoryLineMvoStateDtoWrapperCollection : StateDtoWrapperCollectionBase<PhysicalInventoryLineMvoStateDtoWrapper>
    {

        protected override bool IsCollectionField(string fieldName)
        {
            return CollectionUtils.CollectionContainsIgnoringCase(PhysicalInventoryLineMvoStateDtoWrapper._collectionFieldNames, fieldName);
        }

    }

}

