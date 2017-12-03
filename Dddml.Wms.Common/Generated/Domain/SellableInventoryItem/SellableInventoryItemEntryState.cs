﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItem
{

	public partial class SellableInventoryItemEntryState : SellableInventoryItemEntryStateProperties, ISellableInventoryItemEntryState
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }

        public virtual string CommandId { get; set; }


		#region IIdentity implementation

        private SellableInventoryItemEntryId _sellableInventoryItemEntryId = new SellableInventoryItemEntryId();

        public virtual SellableInventoryItemEntryId SellableInventoryItemEntryId 
        {
            get { return this._sellableInventoryItemEntryId; }
            set { this._sellableInventoryItemEntryId = value; }
        }

		SellableInventoryItemEntryId IGlobalIdentity<SellableInventoryItemEntryId>.GlobalId {
			get {
				return  this.SellableInventoryItemEntryId;
			}
		}

        long ILocalIdentity<long>.LocalId
        {
            get
            {
                return this.EntrySeqId;
            }
        }


        public override InventoryItemId SellableInventoryItemId {
			get {
				return this.SellableInventoryItemEntryId.SellableInventoryItemId;
			}
			set {
				this.SellableInventoryItemEntryId.SellableInventoryItemId = value;
			}
		}

        public override long EntrySeqId {
			get {
				return this.SellableInventoryItemEntryId.EntrySeqId;
			}
			set {
				this.SellableInventoryItemEntryId.EntrySeqId = value;
			}
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

        bool ISellableInventoryItemEntryState.IsUnsaved
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

        public SellableInventoryItemEntryState() : this(false)
        {
        }

        public SellableInventoryItemEntryState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(ISellableInventoryItemEntryStateCreated e)
		{
			ThrowOnWrongEvent(e);
            this.QuantitySellable = (e.QuantitySellable != null && e.QuantitySellable.HasValue) ? e.QuantitySellable.Value : default(decimal);

			this.SourceEventId = e.SourceEventId;

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}



		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
		}

        protected void ThrowOnWrongEvent(ISellableInventoryItemEntryStateEvent stateEvent)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("SellableInventoryItemEntry|");

            var stateEntityIdSellableInventoryItemId = (this as IGlobalIdentity<SellableInventoryItemEntryId>).GlobalId.SellableInventoryItemId;
            var eventEntityIdSellableInventoryItemId = stateEvent.StateEventId.SellableInventoryItemId;
            if (stateEntityIdSellableInventoryItemId != eventEntityIdSellableInventoryItemId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id SellableInventoryItemId {0} in state but entity id SellableInventoryItemId {1} in event", stateEntityIdSellableInventoryItemId, eventEntityIdSellableInventoryItemId);
            }
            id.Append(stateEntityIdSellableInventoryItemId).Append(",");

            var stateEntityIdEntrySeqId = (this as IGlobalIdentity<SellableInventoryItemEntryId>).GlobalId.EntrySeqId;
            var eventEntityIdEntrySeqId = stateEvent.StateEventId.EntrySeqId;
            if (stateEntityIdEntrySeqId != eventEntityIdEntrySeqId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id EntrySeqId {0} in state but entity id EntrySeqId {1} in event", stateEntityIdEntrySeqId, eventEntityIdEntrySeqId);
            }
            id.Append(stateEntityIdEntrySeqId).Append(",");

            id.Append("]");

            if (ForReapplying) { return; }
            var stateVersion = this.Version;
            var eventVersion = stateEvent.Version;
            if (SellableInventoryItemEntryState.VersionZero == eventVersion)
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

