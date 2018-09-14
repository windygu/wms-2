﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{

	public partial class InOutNoticeState : InOutNoticeStateProperties, IInOutNoticeState
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
				return this.InOutNoticeId;
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

        bool IInOutNoticeState.IsUnsaved
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

        public InOutNoticeState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.InOutNoticeId = ((IInOutNoticeEvent)events.First()).InOutNoticeEventId.InOutNoticeId;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.Version += 1;
                }
            }
        }

        public InOutNoticeState() : this(false)
        {
        }

        public InOutNoticeState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(IInOutNoticeStateCreated e)
		{
			ThrowOnWrongEvent(e);
			this.WarehouseId = e.WarehouseId;

			this.InOutNoticeType = e.InOutNoticeType;

			this.TelecomContactMechId = e.TelecomContactMechId;

			this.TrackingNumber = e.TrackingNumber;

			this.ContactPartyId = e.ContactPartyId;

			this.VehiclePlateNumber = e.VehiclePlateNumber;

			this.ShippingInstructions = e.ShippingInstructions;

			this.EstimatedShipDate = e.EstimatedShipDate;

			this.EstimatedDeliveryDate = e.EstimatedDeliveryDate;

			this.StatusId = e.StatusId;

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}


		public virtual void When(IInOutNoticeStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

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

			if (e.InOutNoticeType == null)
			{
				if (e.IsPropertyInOutNoticeTypeRemoved)
				{
					this.InOutNoticeType = default(string);
				}
			}
			else
			{
				this.InOutNoticeType = e.InOutNoticeType;
			}

			if (e.TelecomContactMechId == null)
			{
				if (e.IsPropertyTelecomContactMechIdRemoved)
				{
					this.TelecomContactMechId = default(string);
				}
			}
			else
			{
				this.TelecomContactMechId = e.TelecomContactMechId;
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

			if (e.ContactPartyId == null)
			{
				if (e.IsPropertyContactPartyIdRemoved)
				{
					this.ContactPartyId = default(string);
				}
			}
			else
			{
				this.ContactPartyId = e.ContactPartyId;
			}

			if (e.VehiclePlateNumber == null)
			{
				if (e.IsPropertyVehiclePlateNumberRemoved)
				{
					this.VehiclePlateNumber = default(string);
				}
			}
			else
			{
				this.VehiclePlateNumber = e.VehiclePlateNumber;
			}

			if (e.ShippingInstructions == null)
			{
				if (e.IsPropertyShippingInstructionsRemoved)
				{
					this.ShippingInstructions = default(string);
				}
			}
			else
			{
				this.ShippingInstructions = e.ShippingInstructions;
			}

			if (e.EstimatedShipDate == null)
			{
				if (e.IsPropertyEstimatedShipDateRemoved)
				{
					this.EstimatedShipDate = default(DateTime?);
				}
			}
			else
			{
				this.EstimatedShipDate = e.EstimatedShipDate;
			}

			if (e.EstimatedDeliveryDate == null)
			{
				if (e.IsPropertyEstimatedDeliveryDateRemoved)
				{
					this.EstimatedDeliveryDate = default(DateTime?);
				}
			}
			else
			{
				this.EstimatedDeliveryDate = e.EstimatedDeliveryDate;
			}

			if (e.StatusId == null)
			{
				if (e.IsPropertyStatusIdRemoved)
				{
					this.StatusId = default(string);
				}
			}
			else
			{
				this.StatusId = e.StatusId;
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

		public virtual void When(IInOutNoticeStateDeleted e)
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

        protected void ThrowOnWrongEvent(IInOutNoticeEvent e)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("InOutNotice|");

            var stateEntityId = this.InOutNoticeId; // Aggregate Id
            var eventEntityId = e.InOutNoticeEventId.InOutNoticeId;
            if (stateEntityId != eventEntityId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
            }
            id.Append(stateEntityId).Append(",");

            id.Append("]");

            var stateVersion = this.Version;
            var eventVersion = e.InOutNoticeEventId.Version;
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}

