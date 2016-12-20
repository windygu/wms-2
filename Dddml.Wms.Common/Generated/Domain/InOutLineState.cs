﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using NodaMoney;

namespace Dddml.Wms.Domain
{

	public partial class InOutLineState : InOutLineStateProperties, IInOutLineState
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }


		#region IIdentity implementation

        private InOutLineId _inOutLineId = new InOutLineId();

        public virtual InOutLineId InOutLineId 
        {
            get { return this._inOutLineId; }
            set { this._inOutLineId = value; }
        }

		InOutLineId IGlobalIdentity<InOutLineId>.GlobalId {
			get {
				return  this.InOutLineId;
			}
		}

        SkuId ILocalIdentity<SkuId>.LocalId
        {
            get
            {
                return this.SkuId;
            }
        }


        public override string InOutDocumentNumber {
			get {
				return this.InOutLineId.InOutDocumentNumber;
			}
			set {
				this.InOutLineId.InOutDocumentNumber = value;
			}
		}

        public override SkuId SkuId {
			get {
				return this.InOutLineId.SkuId;
			}
			set {
				this.InOutLineId.SkuId = value;
			}
		}

		#endregion



		#region IActive implementation

		bool IActive.IsActive()
		{
			return this.Active;
		}

		#endregion

		#region IDeleted implementation

		bool IDeleted.Deleted
		{
			get
			{
				return this.Deleted;
			}
		}

		#endregion

		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
			get
			{
				return this.CreatedBy;
			}
			set
			{
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt
		{
			get
			{
				return this.CreatedAt;
			}
			set
			{
				this.CreatedAt = value;
			}
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
			get { return this.UpdatedBy; }
			set { this.UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
			get { return this.UpdatedAt; }
			set { this.UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IEntityVersioned<long>.EntityVersion
		{
			get
			{
				return this.Version;
			}
		}


		#endregion

        bool IInOutLineState.IsUnsaved
        {
            get { return this.Version == VersionZero; }
        }

		public static long VersionZero
		{
			get
			{
				return (long)0;
			}
		}


        public virtual bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }
	
        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public InOutLineState() : this(false)
        {
        }

        public InOutLineState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(IInOutLineStateCreated e)
		{
			ThrowOnWrongEvent(e);
            this.LineNumber = (e.LineNumber != null && e.LineNumber.HasValue) ? e.LineNumber.Value : default(long);

			this.Description = e.Description;

			this.LocatorId = e.LocatorId;

			this.Product = e.Product;

			this.UomId = e.UomId;

            this.MovementQuantity = (e.MovementQuantity != null && e.MovementQuantity.HasValue) ? e.MovementQuantity.Value : default(decimal);

            this.ConfirmedQuantity = (e.ConfirmedQuantity != null && e.ConfirmedQuantity.HasValue) ? e.ConfirmedQuantity.Value : default(decimal);

            this.ScrappedQuantity = (e.ScrappedQuantity != null && e.ScrappedQuantity.HasValue) ? e.ScrappedQuantity.Value : default(decimal);

            this.TargetQuantity = (e.TargetQuantity != null && e.TargetQuantity.HasValue) ? e.TargetQuantity.Value : default(decimal);

            this.PickedQuantity = (e.PickedQuantity != null && e.PickedQuantity.HasValue) ? e.PickedQuantity.Value : default(decimal);

            this.IsInvoiced = (e.IsInvoiced != null && e.IsInvoiced.HasValue) ? e.IsInvoiced.Value : default(bool);

			this.AttributeSetInstanceId = e.AttributeSetInstanceId;

            this.IsDescription = (e.IsDescription != null && e.IsDescription.HasValue) ? e.IsDescription.Value : default(bool);

            this.Processed = (e.Processed != null && e.Processed.HasValue) ? e.Processed.Value : default(bool);

            this.QuantityEntered = (e.QuantityEntered != null && e.QuantityEntered.HasValue) ? e.QuantityEntered.Value : default(decimal);

            this.RmaLineNumber = (e.RmaLineNumber != null && e.RmaLineNumber.HasValue) ? e.RmaLineNumber.Value : default(long);

            this.ReversalLineNumber = (e.ReversalLineNumber != null && e.ReversalLineNumber.HasValue) ? e.ReversalLineNumber.Value : default(long);

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}


		public virtual void When(IInOutLineStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.LineNumber == null)
			{
				if (e.IsPropertyLineNumberRemoved)
				{
					this.LineNumber = default(long);
				}
			}
			else
			{
				this.LineNumber = (e.LineNumber != null && e.LineNumber.HasValue) ? e.LineNumber.Value : default(long);
			}

			if (e.Description == null)
			{
				if (e.IsPropertyDescriptionRemoved)
				{
					this.Description = default(string);
				}
			}
			else
			{
				this.Description = e.Description;
			}

			if (e.LocatorId == null)
			{
				if (e.IsPropertyLocatorIdRemoved)
				{
					this.LocatorId = default(string);
				}
			}
			else
			{
				this.LocatorId = e.LocatorId;
			}

			if (e.Product == null)
			{
				if (e.IsPropertyProductRemoved)
				{
					this.Product = default(string);
				}
			}
			else
			{
				this.Product = e.Product;
			}

			if (e.UomId == null)
			{
				if (e.IsPropertyUomIdRemoved)
				{
					this.UomId = default(string);
				}
			}
			else
			{
				this.UomId = e.UomId;
			}

			if (e.MovementQuantity == null)
			{
				if (e.IsPropertyMovementQuantityRemoved)
				{
					this.MovementQuantity = default(decimal);
				}
			}
			else
			{
				this.MovementQuantity = (e.MovementQuantity != null && e.MovementQuantity.HasValue) ? e.MovementQuantity.Value : default(decimal);
			}

			if (e.ConfirmedQuantity == null)
			{
				if (e.IsPropertyConfirmedQuantityRemoved)
				{
					this.ConfirmedQuantity = default(decimal);
				}
			}
			else
			{
				this.ConfirmedQuantity = (e.ConfirmedQuantity != null && e.ConfirmedQuantity.HasValue) ? e.ConfirmedQuantity.Value : default(decimal);
			}

			if (e.ScrappedQuantity == null)
			{
				if (e.IsPropertyScrappedQuantityRemoved)
				{
					this.ScrappedQuantity = default(decimal);
				}
			}
			else
			{
				this.ScrappedQuantity = (e.ScrappedQuantity != null && e.ScrappedQuantity.HasValue) ? e.ScrappedQuantity.Value : default(decimal);
			}

			if (e.TargetQuantity == null)
			{
				if (e.IsPropertyTargetQuantityRemoved)
				{
					this.TargetQuantity = default(decimal);
				}
			}
			else
			{
				this.TargetQuantity = (e.TargetQuantity != null && e.TargetQuantity.HasValue) ? e.TargetQuantity.Value : default(decimal);
			}

			if (e.PickedQuantity == null)
			{
				if (e.IsPropertyPickedQuantityRemoved)
				{
					this.PickedQuantity = default(decimal);
				}
			}
			else
			{
				this.PickedQuantity = (e.PickedQuantity != null && e.PickedQuantity.HasValue) ? e.PickedQuantity.Value : default(decimal);
			}

			if (e.IsInvoiced == null)
			{
				if (e.IsPropertyIsInvoicedRemoved)
				{
					this.IsInvoiced = default(bool);
				}
			}
			else
			{
				this.IsInvoiced = (e.IsInvoiced != null && e.IsInvoiced.HasValue) ? e.IsInvoiced.Value : default(bool);
			}

			if (e.AttributeSetInstanceId == null)
			{
				if (e.IsPropertyAttributeSetInstanceIdRemoved)
				{
					this.AttributeSetInstanceId = default(string);
				}
			}
			else
			{
				this.AttributeSetInstanceId = e.AttributeSetInstanceId;
			}

			if (e.IsDescription == null)
			{
				if (e.IsPropertyIsDescriptionRemoved)
				{
					this.IsDescription = default(bool);
				}
			}
			else
			{
				this.IsDescription = (e.IsDescription != null && e.IsDescription.HasValue) ? e.IsDescription.Value : default(bool);
			}

			if (e.Processed == null)
			{
				if (e.IsPropertyProcessedRemoved)
				{
					this.Processed = default(bool);
				}
			}
			else
			{
				this.Processed = (e.Processed != null && e.Processed.HasValue) ? e.Processed.Value : default(bool);
			}

			if (e.QuantityEntered == null)
			{
				if (e.IsPropertyQuantityEnteredRemoved)
				{
					this.QuantityEntered = default(decimal);
				}
			}
			else
			{
				this.QuantityEntered = (e.QuantityEntered != null && e.QuantityEntered.HasValue) ? e.QuantityEntered.Value : default(decimal);
			}

			if (e.RmaLineNumber == null)
			{
				if (e.IsPropertyRmaLineNumberRemoved)
				{
					this.RmaLineNumber = default(long);
				}
			}
			else
			{
				this.RmaLineNumber = (e.RmaLineNumber != null && e.RmaLineNumber.HasValue) ? e.RmaLineNumber.Value : default(long);
			}

			if (e.ReversalLineNumber == null)
			{
				if (e.IsPropertyReversalLineNumberRemoved)
				{
					this.ReversalLineNumber = default(long);
				}
			}
			else
			{
				this.ReversalLineNumber = (e.ReversalLineNumber != null && e.ReversalLineNumber.HasValue) ? e.ReversalLineNumber.Value : default(long);
			}

			if (e.Active == null)
			{
				if (e.IsPropertyActiveRemoved)
				{
					this.Active = default(bool);
				}
			}
			else
			{
				this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);
			}


			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;


		}

		public virtual void When(IInOutLineStateRemoved e)
		{
			ThrowOnWrongEvent(e);

			this.Deleted = true;
			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;

		}


		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
		}

        protected void ThrowOnWrongEvent(IInOutLineStateEvent stateEvent)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("InOutLine|");

            var stateEntityIdInOutDocumentNumber = (this as IGlobalIdentity<InOutLineId>).GlobalId.InOutDocumentNumber;
            var eventEntityIdInOutDocumentNumber = stateEvent.StateEventId.InOutDocumentNumber;
            if (stateEntityIdInOutDocumentNumber != eventEntityIdInOutDocumentNumber)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id InOutDocumentNumber {0} in state but entity id InOutDocumentNumber {1} in event", stateEntityIdInOutDocumentNumber, eventEntityIdInOutDocumentNumber);
            }
            id.Append(stateEntityIdInOutDocumentNumber).Append(",");

            var stateEntityIdSkuId = (this as IGlobalIdentity<InOutLineId>).GlobalId.SkuId;
            var eventEntityIdSkuId = stateEvent.StateEventId.SkuId;
            if (stateEntityIdSkuId != eventEntityIdSkuId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id SkuId {0} in state but entity id SkuId {1} in event", stateEntityIdSkuId, eventEntityIdSkuId);
            }
            id.Append(stateEntityIdSkuId).Append(",");

            id.Append("]");

            if (ForReapplying) { return; }
            var stateVersion = this.Version;
            var eventVersion = stateEvent.Version;
            if (InOutLineState.VersionZero == eventVersion)
            {
                eventVersion = stateEvent.Version = stateVersion;
            }
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}

