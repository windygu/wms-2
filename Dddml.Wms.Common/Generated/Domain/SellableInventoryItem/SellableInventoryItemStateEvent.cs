﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItem
{

	public abstract class SellableInventoryItemStateEventBase : ISellableInventoryItemStateEvent
	{

		public virtual SellableInventoryItemStateEventId StateEventId { get; set; }

        public virtual InventoryItemId SellableInventoryItemId
        {
            get { return StateEventId.SellableInventoryItemId; }
            set { StateEventId.SellableInventoryItemId = value; }
        }

		public virtual decimal? QuantitySellable { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		SellableInventoryItemStateEventId IGlobalIdentity<SellableInventoryItemStateEventId>.GlobalId {
			get
			{
				return this.StateEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool ISellableInventoryItemStateEvent.ReadOnly
        {
            get
            {
                return this.StateEventReadOnly;
            }
            set
            {
                this.StateEventReadOnly = value;
            }
        }


		string ICreated<string>.CreatedBy {
			get {
				return this.CreatedBy;
			}
			set {
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt {
			get {
				return this.CreatedAt;
			}
			set {
				this.CreatedAt = value;
			}
		}

        protected SellableInventoryItemStateEventBase()
        {
        }

        protected SellableInventoryItemStateEventBase(SellableInventoryItemStateEventId stateEventId)
        {
            this.StateEventId = stateEventId;
        }

		protected ISellableInventoryItemEntryStateEventDao SellableInventoryItemEntryStateEventDao
		{
			get { return ApplicationContext.Current["SellableInventoryItemEntryStateEventDao"] as ISellableInventoryItemEntryStateEventDao; }
		}

        protected SellableInventoryItemEntryStateEventId NewSellableInventoryItemEntryStateEventId(long entrySeqId)
        {
            var stateEventId = new SellableInventoryItemEntryStateEventId(this.StateEventId.SellableInventoryItemId, entrySeqId, this.StateEventId.Version);
            return stateEventId;
        }


        protected void ThrowOnInconsistentEventIds(ISellableInventoryItemEntryStateEvent e)
        {
            ThrowOnInconsistentEventIds(this, e);
        }

		public static void ThrowOnInconsistentEventIds(ISellableInventoryItemStateEvent oe, ISellableInventoryItemEntryStateEvent e)
		{
			if (!oe.StateEventId.SellableInventoryItemId.Equals(e.StateEventId.SellableInventoryItemId))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id SellableInventoryItemId {0} but inner id SellableInventoryItemId {1}", 
					oe.StateEventId.SellableInventoryItemId, e.StateEventId.SellableInventoryItemId);
			}
		}



        string IStateEventDto.StateEventType
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}

	public class SellableInventoryItemStateCreated : SellableInventoryItemStateEventBase, ISellableInventoryItemStateCreated, ISaveable
	{
		public SellableInventoryItemStateCreated () : this(new SellableInventoryItemStateEventId())
		{
		}

		public SellableInventoryItemStateCreated (SellableInventoryItemStateEventId stateEventId) : base(stateEventId)
		{
		}

		private Dictionary<SellableInventoryItemEntryStateEventId, ISellableInventoryItemEntryStateCreated> _sellableInventoryItemEntryEvents = new Dictionary<SellableInventoryItemEntryStateEventId, ISellableInventoryItemEntryStateCreated>();
        
        private IEnumerable<ISellableInventoryItemEntryStateCreated> _readOnlySellableInventoryItemEntryEvents;

        public virtual IEnumerable<ISellableInventoryItemEntryStateCreated> SellableInventoryItemEntryEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
                    return this._sellableInventoryItemEntryEvents.Values;
                }
                else
                {
                    if (_readOnlySellableInventoryItemEntryEvents != null) { return _readOnlySellableInventoryItemEntryEvents; }
                    var eventDao = SellableInventoryItemEntryStateEventDao;
                    var eL = new List<ISellableInventoryItemEntryStateCreated>();
                    foreach (var e in eventDao.FindBySellableInventoryItemStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((ISellableInventoryItemEntryStateCreated)e);
                    }
                    return (_readOnlySellableInventoryItemEntryEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddSellableInventoryItemEntryEvent(e);
                    }
                }
                else { this._sellableInventoryItemEntryEvents.Clear(); }
            }
        }
    
		public virtual void AddSellableInventoryItemEntryEvent(ISellableInventoryItemEntryStateCreated e)
		{
			ThrowOnInconsistentEventIds(e);
			this._sellableInventoryItemEntryEvents[e.StateEventId] = e;
		}

        public virtual ISellableInventoryItemEntryStateCreated NewSellableInventoryItemEntryStateCreated(long entrySeqId)
        {
            var stateEvent = new SellableInventoryItemEntryStateCreated(NewSellableInventoryItemEntryStateEventId(entrySeqId));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (ISellableInventoryItemEntryStateCreated e in this.SellableInventoryItemEntryEvents) {
				SellableInventoryItemEntryStateEventDao.Save(e);
			}
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class SellableInventoryItemStateMergePatched : SellableInventoryItemStateEventBase, ISellableInventoryItemStateMergePatched, ISaveable
	{
		public virtual bool IsPropertyQuantitySellableRemoved { get; set; }


		public SellableInventoryItemStateMergePatched ()
		{
		}

		public SellableInventoryItemStateMergePatched (SellableInventoryItemStateEventId stateEventId) : base(stateEventId)
		{
		}

		private Dictionary<SellableInventoryItemEntryStateEventId, ISellableInventoryItemEntryStateEvent> _sellableInventoryItemEntryEvents = new Dictionary<SellableInventoryItemEntryStateEventId, ISellableInventoryItemEntryStateEvent>();

        private IEnumerable<ISellableInventoryItemEntryStateEvent> _readOnlySellableInventoryItemEntryEvents;
        
        public virtual IEnumerable<ISellableInventoryItemEntryStateEvent> SellableInventoryItemEntryEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
                    return this._sellableInventoryItemEntryEvents.Values;
                }
                else
                {
                    if (_readOnlySellableInventoryItemEntryEvents != null) { return _readOnlySellableInventoryItemEntryEvents; }
                    var eventDao = SellableInventoryItemEntryStateEventDao;
                    var eL = new List<ISellableInventoryItemEntryStateEvent>();
                    foreach (var e in eventDao.FindBySellableInventoryItemStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((ISellableInventoryItemEntryStateEvent)e);
                    }
                    return (_readOnlySellableInventoryItemEntryEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddSellableInventoryItemEntryEvent(e);
                    }
                }
                else { this._sellableInventoryItemEntryEvents.Clear(); }
            }
        }

		public virtual void AddSellableInventoryItemEntryEvent(ISellableInventoryItemEntryStateEvent e)
		{
			ThrowOnInconsistentEventIds(e);
			this._sellableInventoryItemEntryEvents[e.StateEventId] = e;
		}

        public virtual ISellableInventoryItemEntryStateCreated NewSellableInventoryItemEntryStateCreated(long entrySeqId)
        {
            var stateEvent = new SellableInventoryItemEntryStateCreated(NewSellableInventoryItemEntryStateEventId(entrySeqId));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (ISellableInventoryItemEntryStateEvent e in this.SellableInventoryItemEntryEvents) {
				SellableInventoryItemEntryStateEventDao.Save(e);
			}
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}




}

