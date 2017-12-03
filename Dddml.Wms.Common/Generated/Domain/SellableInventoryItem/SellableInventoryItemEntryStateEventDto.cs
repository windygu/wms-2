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

	public abstract class SellableInventoryItemEntryStateEventDtoBase : IStateEventDto, ISellableInventoryItemEntryStateCreated
	{

        private SellableInventoryItemEntryStateEventIdDto _stateEventId;

		protected internal virtual SellableInventoryItemEntryStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new SellableInventoryItemEntryStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual long EntrySeqId
        {
            get { return StateEventId.EntrySeqId; }
            set { StateEventId.EntrySeqId = value; }
        }

		public virtual decimal? QuantitySellable { get; set; }

		private InventoryPRTriggeredIdDto _sourceEventId = new InventoryPRTriggeredIdDto();

		public virtual InventoryPRTriggeredIdDto SourceEventId { get { return _sourceEventId; } set { _sourceEventId = value; } }

		InventoryPRTriggeredId ISellableInventoryItemEntryStateEvent.SourceEventId
		{ 
			get 
			{
				return this.SourceEventId == null ? null : this.SourceEventId.ToInventoryPRTriggeredId(); 
			} 
			set
			{
				if (value == null) { SourceEventId = null; } else { SourceEventId = new InventoryPRTriggeredIdDtoWrapper(value); }
			} 
		}

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		SellableInventoryItemEntryStateEventId IGlobalIdentity<SellableInventoryItemEntryStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToSellableInventoryItemEntryStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool ISellableInventoryItemEntryStateEvent.ReadOnly
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

		public virtual long Version { get; set; }

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


        SellableInventoryItemEntryStateEventId ISellableInventoryItemEntryStateEvent.StateEventId
        {
            get { return this.StateEventId.ToSellableInventoryItemEntryStateEventId(); }
        }

        protected SellableInventoryItemEntryStateEventDtoBase()
        {
        }

        protected SellableInventoryItemEntryStateEventDtoBase(SellableInventoryItemEntryStateEventIdDto stateEventId)
        {
            this.StateEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IStateEventDto.StateEventType 
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}


    public class SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto : SellableInventoryItemEntryStateEventDtoBase
    {
        private string _stateEventType;

        public virtual string StateEventType
        {
            get { return _stateEventType; }
            set { _stateEventType = value; }
        }

        protected override string GetStateEventType()
        {
            return this._stateEventType;
        }

    }



	public class SellableInventoryItemEntryStateCreatedDto : SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto
	{
		public SellableInventoryItemEntryStateCreatedDto()
		{
		}

        public override string StateEventType
        {
            get { return this.GetStateEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class SellableInventoryItemEntryStateMergePatchedDto : SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto
	{
		public SellableInventoryItemEntryStateMergePatchedDto()
		{
		}

        public override string StateEventType
        {
            get { return this.GetStateEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class SellableInventoryItemEntryStateRemovedDto : SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto
	{
		public SellableInventoryItemEntryStateRemovedDto()
		{
		}

        public override string StateEventType
        {
            get { return this.GetStateEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Removed;
        }

	}


    public partial class SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDtos : IEnumerable<ISellableInventoryItemEntryStateCreated>
    {
        private List<SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto> _innerStateEvents = new List<SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto>();

        public virtual SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<ISellableInventoryItemEntryStateCreated> IEnumerable<ISellableInventoryItemEntryStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }


        public void AddSellableInventoryItemEntryEvent(ISellableInventoryItemEntryStateCreated e)
        {
            _innerStateEvents.Add((SellableInventoryItemEntryStateCreatedDto)e);
        }

        public void AddSellableInventoryItemEntryEvent(ISellableInventoryItemEntryStateEvent e)
        {
            _innerStateEvents.Add((SellableInventoryItemEntryStateCreatedOrMergePatchedOrRemovedDto)e);
        }


    }


}

