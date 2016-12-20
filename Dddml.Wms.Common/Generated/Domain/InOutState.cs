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

	public partial class InOutState : InOutStateProperties, IInOutState, ISaveable
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }


		#region IIdentity implementation

		string IGlobalIdentity<string>.GlobalId
		{
			get
			{
				return this.DocumentNumber;
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

		long IAggregateVersioned<long>.AggregateVersion
		{
			get
			{
				return this.Version;
			}
		}


		#endregion

        bool IInOutState.IsUnsaved
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


        private IInOutLineStates _inOutLines;
      
        public virtual IInOutLineStates InOutLines
        {
            get
            {
                return this._inOutLines;
            }
            set
            {
                this._inOutLines = value;
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

        public InOutState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.DocumentNumber = ((IInOutStateEvent)events.First()).StateEventId.DocumentNumber;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.Version += 1;
                }
            }
        }

        public InOutState() : this(false)
        {
        }

        public InOutState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            _inOutLines = new InOutLineStates(this);

            InitializeProperties();
        }


		#region Saveable Implements

        public virtual void Save()
        {
            _inOutLines.Save();

        }


		#endregion


		public virtual void When(IInOutStateCreated e)
		{
			ThrowOnWrongEvent(e);
            this.IsSOTransaction = (e.IsSOTransaction != null && e.IsSOTransaction.HasValue) ? e.IsSOTransaction.Value : default(bool);

			this.DocumentStatus = e.DocumentStatus;

            this.Posted = (e.Posted != null && e.Posted.HasValue) ? e.Posted.Value : default(bool);

            this.Processing = (e.Processing != null && e.Processing.HasValue) ? e.Processing.Value : default(bool);

            this.Processed = (e.Processed != null && e.Processed.HasValue) ? e.Processed.Value : default(bool);

            this.DocumentType = (e.DocumentType != null && e.DocumentType.HasValue) ? e.DocumentType.Value : default(int);

			this.Description = e.Description;

			this.OrderNumber = e.OrderNumber;

			this.DateOrdered = e.DateOrdered;

            this.IsPrinted = (e.IsPrinted != null && e.IsPrinted.HasValue) ? e.IsPrinted.Value : default(bool);

			this.MovementType = e.MovementType;

			this.MovementDate = e.MovementDate;

			this.BusinessPartnerId = e.BusinessPartnerId;

			this.WarehouseId = e.WarehouseId;

			this.POReference = e.POReference;

            this.FreightAmount = (e.FreightAmount != null && e.FreightAmount.HasValue) ? e.FreightAmount.Value : default(Money);

			this.ShipperId = e.ShipperId;

            this.ChargeAmount = (e.ChargeAmount != null && e.ChargeAmount.HasValue) ? e.ChargeAmount.Value : default(Money);

			this.DatePrinted = e.DatePrinted;

			this.SalesRepresentative = e.SalesRepresentative;

            this.NumberOfPackages = (e.NumberOfPackages != null && e.NumberOfPackages.HasValue) ? e.NumberOfPackages.Value : default(int);

			this.PickDate = e.PickDate;

			this.ShipDate = e.ShipDate;

			this.TrackingNumber = e.TrackingNumber;

			this.DateReceived = e.DateReceived;

            this.IsInTransit = (e.IsInTransit != null && e.IsInTransit.HasValue) ? e.IsInTransit.Value : default(bool);

            this.IsApproved = (e.IsApproved != null && e.IsApproved.HasValue) ? e.IsApproved.Value : default(bool);

            this.IsInDispute = (e.IsInDispute != null && e.IsInDispute.HasValue) ? e.IsInDispute.Value : default(bool);

            this.Volume = (e.Volume != null && e.Volume.HasValue) ? e.Volume.Value : default(decimal);

            this.Weight = (e.Weight != null && e.Weight.HasValue) ? e.Weight.Value : default(decimal);

			this.RmaNumber = e.RmaNumber;

			this.ReversalNumber = e.ReversalNumber;

            this.IsDropShip = (e.IsDropShip != null && e.IsDropShip.HasValue) ? e.IsDropShip.Value : default(bool);

			this.DropShipBusinessPartnerId = e.DropShipBusinessPartnerId;

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;

			foreach (IInOutLineStateCreated innerEvent in e.InOutLineEvents) {
				IInOutLineState innerState = this.InOutLines.Get(innerEvent.GlobalId.SkuId, true);
				innerState.Mutate (innerEvent);
			}

		}


		public virtual void When(IInOutStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.IsSOTransaction == null)
			{
				if (e.IsPropertyIsSOTransactionRemoved)
				{
					this.IsSOTransaction = default(bool);
				}
			}
			else
			{
				this.IsSOTransaction = (e.IsSOTransaction != null && e.IsSOTransaction.HasValue) ? e.IsSOTransaction.Value : default(bool);
			}

			if (e.DocumentStatus == null)
			{
				if (e.IsPropertyDocumentStatusRemoved)
				{
					this.DocumentStatus = default(string);
				}
			}
			else
			{
				this.DocumentStatus = e.DocumentStatus;
			}

			if (e.Posted == null)
			{
				if (e.IsPropertyPostedRemoved)
				{
					this.Posted = default(bool);
				}
			}
			else
			{
				this.Posted = (e.Posted != null && e.Posted.HasValue) ? e.Posted.Value : default(bool);
			}

			if (e.Processing == null)
			{
				if (e.IsPropertyProcessingRemoved)
				{
					this.Processing = default(bool);
				}
			}
			else
			{
				this.Processing = (e.Processing != null && e.Processing.HasValue) ? e.Processing.Value : default(bool);
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

			if (e.DocumentType == null)
			{
				if (e.IsPropertyDocumentTypeRemoved)
				{
					this.DocumentType = default(int);
				}
			}
			else
			{
				this.DocumentType = (e.DocumentType != null && e.DocumentType.HasValue) ? e.DocumentType.Value : default(int);
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

			if (e.OrderNumber == null)
			{
				if (e.IsPropertyOrderNumberRemoved)
				{
					this.OrderNumber = default(string);
				}
			}
			else
			{
				this.OrderNumber = e.OrderNumber;
			}

			if (e.DateOrdered == null)
			{
				if (e.IsPropertyDateOrderedRemoved)
				{
					this.DateOrdered = default(DateTime?);
				}
			}
			else
			{
				this.DateOrdered = e.DateOrdered;
			}

			if (e.IsPrinted == null)
			{
				if (e.IsPropertyIsPrintedRemoved)
				{
					this.IsPrinted = default(bool);
				}
			}
			else
			{
				this.IsPrinted = (e.IsPrinted != null && e.IsPrinted.HasValue) ? e.IsPrinted.Value : default(bool);
			}

			if (e.MovementType == null)
			{
				if (e.IsPropertyMovementTypeRemoved)
				{
					this.MovementType = default(string);
				}
			}
			else
			{
				this.MovementType = e.MovementType;
			}

			if (e.MovementDate == null)
			{
				if (e.IsPropertyMovementDateRemoved)
				{
					this.MovementDate = default(DateTime?);
				}
			}
			else
			{
				this.MovementDate = e.MovementDate;
			}

			if (e.BusinessPartnerId == null)
			{
				if (e.IsPropertyBusinessPartnerIdRemoved)
				{
					this.BusinessPartnerId = default(string);
				}
			}
			else
			{
				this.BusinessPartnerId = e.BusinessPartnerId;
			}

			if (e.WarehouseId == null)
			{
				if (e.IsPropertyWarehouseIdRemoved)
				{
					this.WarehouseId = default(string);
				}
			}
			else
			{
				this.WarehouseId = e.WarehouseId;
			}

			if (e.POReference == null)
			{
				if (e.IsPropertyPOReferenceRemoved)
				{
					this.POReference = default(string);
				}
			}
			else
			{
				this.POReference = e.POReference;
			}

			if (e.FreightAmount == null)
			{
				if (e.IsPropertyFreightAmountRemoved)
				{
					this.FreightAmount = default(Money);
				}
			}
			else
			{
				this.FreightAmount = (e.FreightAmount != null && e.FreightAmount.HasValue) ? e.FreightAmount.Value : default(Money);
			}

			if (e.ShipperId == null)
			{
				if (e.IsPropertyShipperIdRemoved)
				{
					this.ShipperId = default(string);
				}
			}
			else
			{
				this.ShipperId = e.ShipperId;
			}

			if (e.ChargeAmount == null)
			{
				if (e.IsPropertyChargeAmountRemoved)
				{
					this.ChargeAmount = default(Money);
				}
			}
			else
			{
				this.ChargeAmount = (e.ChargeAmount != null && e.ChargeAmount.HasValue) ? e.ChargeAmount.Value : default(Money);
			}

			if (e.DatePrinted == null)
			{
				if (e.IsPropertyDatePrintedRemoved)
				{
					this.DatePrinted = default(DateTime?);
				}
			}
			else
			{
				this.DatePrinted = e.DatePrinted;
			}

			if (e.SalesRepresentative == null)
			{
				if (e.IsPropertySalesRepresentativeRemoved)
				{
					this.SalesRepresentative = default(string);
				}
			}
			else
			{
				this.SalesRepresentative = e.SalesRepresentative;
			}

			if (e.NumberOfPackages == null)
			{
				if (e.IsPropertyNumberOfPackagesRemoved)
				{
					this.NumberOfPackages = default(int);
				}
			}
			else
			{
				this.NumberOfPackages = (e.NumberOfPackages != null && e.NumberOfPackages.HasValue) ? e.NumberOfPackages.Value : default(int);
			}

			if (e.PickDate == null)
			{
				if (e.IsPropertyPickDateRemoved)
				{
					this.PickDate = default(DateTime?);
				}
			}
			else
			{
				this.PickDate = e.PickDate;
			}

			if (e.ShipDate == null)
			{
				if (e.IsPropertyShipDateRemoved)
				{
					this.ShipDate = default(DateTime?);
				}
			}
			else
			{
				this.ShipDate = e.ShipDate;
			}

			if (e.TrackingNumber == null)
			{
				if (e.IsPropertyTrackingNumberRemoved)
				{
					this.TrackingNumber = default(string);
				}
			}
			else
			{
				this.TrackingNumber = e.TrackingNumber;
			}

			if (e.DateReceived == null)
			{
				if (e.IsPropertyDateReceivedRemoved)
				{
					this.DateReceived = default(DateTime?);
				}
			}
			else
			{
				this.DateReceived = e.DateReceived;
			}

			if (e.IsInTransit == null)
			{
				if (e.IsPropertyIsInTransitRemoved)
				{
					this.IsInTransit = default(bool);
				}
			}
			else
			{
				this.IsInTransit = (e.IsInTransit != null && e.IsInTransit.HasValue) ? e.IsInTransit.Value : default(bool);
			}

			if (e.IsApproved == null)
			{
				if (e.IsPropertyIsApprovedRemoved)
				{
					this.IsApproved = default(bool);
				}
			}
			else
			{
				this.IsApproved = (e.IsApproved != null && e.IsApproved.HasValue) ? e.IsApproved.Value : default(bool);
			}

			if (e.IsInDispute == null)
			{
				if (e.IsPropertyIsInDisputeRemoved)
				{
					this.IsInDispute = default(bool);
				}
			}
			else
			{
				this.IsInDispute = (e.IsInDispute != null && e.IsInDispute.HasValue) ? e.IsInDispute.Value : default(bool);
			}

			if (e.Volume == null)
			{
				if (e.IsPropertyVolumeRemoved)
				{
					this.Volume = default(decimal);
				}
			}
			else
			{
				this.Volume = (e.Volume != null && e.Volume.HasValue) ? e.Volume.Value : default(decimal);
			}

			if (e.Weight == null)
			{
				if (e.IsPropertyWeightRemoved)
				{
					this.Weight = default(decimal);
				}
			}
			else
			{
				this.Weight = (e.Weight != null && e.Weight.HasValue) ? e.Weight.Value : default(decimal);
			}

			if (e.RmaNumber == null)
			{
				if (e.IsPropertyRmaNumberRemoved)
				{
					this.RmaNumber = default(string);
				}
			}
			else
			{
				this.RmaNumber = e.RmaNumber;
			}

			if (e.ReversalNumber == null)
			{
				if (e.IsPropertyReversalNumberRemoved)
				{
					this.ReversalNumber = default(string);
				}
			}
			else
			{
				this.ReversalNumber = e.ReversalNumber;
			}

			if (e.IsDropShip == null)
			{
				if (e.IsPropertyIsDropShipRemoved)
				{
					this.IsDropShip = default(bool);
				}
			}
			else
			{
				this.IsDropShip = (e.IsDropShip != null && e.IsDropShip.HasValue) ? e.IsDropShip.Value : default(bool);
			}

			if (e.DropShipBusinessPartnerId == null)
			{
				if (e.IsPropertyDropShipBusinessPartnerIdRemoved)
				{
					this.DropShipBusinessPartnerId = default(string);
				}
			}
			else
			{
				this.DropShipBusinessPartnerId = e.DropShipBusinessPartnerId;
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


			foreach (IInOutLineStateEvent innerEvent in e.InOutLineEvents)
            {
                IInOutLineState innerState = this.InOutLines.Get(innerEvent.GlobalId.SkuId);

                innerState.Mutate(innerEvent);
                var removed = innerEvent as IInOutLineStateRemoved;
                if (removed != null)
                {
                    this.InOutLines.Remove(innerState);
                }
          
            }

		}

		public virtual void When(IInOutStateDeleted e)
		{
			ThrowOnWrongEvent(e);

			this.Deleted = true;
			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;

            foreach (var innerState in this.InOutLines)
            {
                this.InOutLines.Remove(innerState);
                
                var innerE = e.NewInOutLineStateRemoved(innerState.SkuId);
                ((InOutLineStateEventBase)innerE).CreatedAt = e.CreatedAt;
                ((InOutLineStateEventBase)innerE).CreatedBy = e.CreatedBy;
                innerState.When(innerE);
                //e.AddInOutLineEvent(innerE);

            }

		}


		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
		}

        protected void ThrowOnWrongEvent(IInOutStateEvent stateEvent)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("InOut|");

            var stateEntityId = this.DocumentNumber; // Aggregate Id
            var eventEntityId = stateEvent.StateEventId.DocumentNumber; // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
            if (stateEntityId != eventEntityId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
            }
            id.Append(stateEntityId).Append(",");

            id.Append("]");

            var stateVersion = this.Version;
            var eventVersion = stateEvent.StateEventId.Version;
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}

