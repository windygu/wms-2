﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemRequirementDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemRequirement;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.InventoryItemRequirement
{

	public abstract class InventoryItemRequirementEntryEventBase : IInventoryItemRequirementEntryEvent
	{

        private InventoryItemRequirementEntryState _state;

        public virtual InventoryItemRequirementEntryState InventoryItemRequirementEntryState { get { return _state; } }

        public virtual InventoryItemRequirementEntryEventId InventoryItemRequirementEntryEventId
        {
            get
            {
                InventoryItemRequirementEntryEventId eventId = new InventoryItemRequirementEntryEventId(_state.InventoryItemRequirementId, _state.EntrySeqId, default(long));
                return eventId;
            }
            set
            {
                _state.InventoryItemRequirementId = value.InventoryItemRequirementId;
                _state.EntrySeqId = value.EntrySeqId;
            }
        }

        public virtual long EntrySeqId
        {
            get { return InventoryItemRequirementEntryEventId.EntrySeqId; }
            set { InventoryItemRequirementEntryEventId.EntrySeqId = value; }
        }

		public virtual string CreatedBy { get { return _state.CreatedBy; } set { _state.CreatedBy = value; } }

		public virtual DateTime CreatedAt { get { return _state.CreatedAt; } set { _state.CreatedAt = value; } }

        public virtual string CommandId { get { return _state.CommandId; } set { _state.CommandId = value; } }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InventoryItemRequirementEntryEventId IGlobalIdentity<InventoryItemRequirementEntryEventId>.GlobalId {
			get
			{
				return this.InventoryItemRequirementEntryEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IInventoryItemRequirementEntryEvent.ReadOnly
        {
            get
            {
                return this.EventReadOnly;
            }
            set
            {
                this.EventReadOnly = value;
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

        protected InventoryItemRequirementEntryEventBase() : this(new InventoryItemRequirementEntryState())
        {
        }

        protected InventoryItemRequirementEntryEventBase(InventoryItemRequirementEntryEventId stateEventId) : this(new InventoryItemRequirementEntryState())
        {
            this.InventoryItemRequirementEntryEventId = stateEventId;
        }

        protected InventoryItemRequirementEntryEventBase(InventoryItemRequirementEntryState state)
        {
            if (state == null) { throw new ArgumentNullException(); }
            this._state = state;
        }


        string IEventDto.EventType
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}

    public abstract class InventoryItemRequirementEntryStateEventBase : InventoryItemRequirementEntryEventBase, IInventoryItemRequirementEntryStateEvent
    {

        public virtual decimal? Quantity { get { return InventoryItemRequirementEntryState.Quantity; } set { InventoryItemRequirementEntryState.Quantity = (value != null && value.HasValue) ? value.Value : default(decimal); } }

        public virtual InventoryPRTriggeredId SourceEventId { get { return InventoryItemRequirementEntryState.SourceEventId; } set { InventoryItemRequirementEntryState.SourceEventId = value; } }

        protected InventoryItemRequirementEntryStateEventBase() : base()
        {
        }

        protected InventoryItemRequirementEntryStateEventBase(InventoryItemRequirementEntryEventId stateEventId) : base(stateEventId)
        {
        }

        protected InventoryItemRequirementEntryStateEventBase(InventoryItemRequirementEntryState state) : base(state)
        {
        }

    }

	public class InventoryItemRequirementEntryStateCreated : InventoryItemRequirementEntryStateEventBase, IInventoryItemRequirementEntryStateCreated
	{
		public InventoryItemRequirementEntryStateCreated () : this(new InventoryItemRequirementEntryEventId())
		{
		}

		public InventoryItemRequirementEntryStateCreated (InventoryItemRequirementEntryEventId stateEventId) : base(stateEventId)
		{
		}

        public InventoryItemRequirementEntryStateCreated(InventoryItemRequirementEntryState state) : base(state)
        {
        }


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}




}

