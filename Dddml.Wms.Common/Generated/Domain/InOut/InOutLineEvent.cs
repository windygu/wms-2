﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;

namespace Dddml.Wms.Domain.InOut
{

	public abstract class InOutLineEventBase : IInOutLineEvent
	{

		public virtual InOutLineEventId InOutLineEventId { get; set; }

        public virtual string LineNumber
        {
            get { return InOutLineEventId.LineNumber; }
            set { InOutLineEventId.LineNumber = value; }
        }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InOutLineEventId IGlobalIdentity<InOutLineEventId>.GlobalId {
			get
			{
				return this.InOutLineEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IInOutLineEvent.ReadOnly
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

        protected InOutLineEventBase()
        {
        }

        protected InOutLineEventBase(InOutLineEventId stateEventId)
        {
            this.InOutLineEventId = stateEventId;
        }

		protected IInOutLineImageEventDao InOutLineImageEventDao
		{
			get { return ApplicationContext.Current["InOutLineImageEventDao"] as IInOutLineImageEventDao; }
		}

        protected InOutLineImageEventId NewInOutLineImageEventId(string sequenceId)
        {
            var stateEventId = new InOutLineImageEventId(this.InOutLineEventId.InOutDocumentNumber, this.InOutLineEventId.LineNumber, sequenceId, this.InOutLineEventId.InOutVersion);
            return stateEventId;
        }


        protected void ThrowOnInconsistentEventIds(IInOutLineImageEvent e)
        {
            ThrowOnInconsistentEventIds(this, e);
        }

		public static void ThrowOnInconsistentEventIds(IInOutLineEvent oe, IInOutLineImageEvent e)
		{
			if (!oe.InOutLineEventId.InOutDocumentNumber.Equals(e.InOutLineImageEventId.InOutDocumentNumber))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id InOutDocumentNumber {0} but inner id InOutDocumentNumber {1}", 
					oe.InOutLineEventId.InOutDocumentNumber, e.InOutLineImageEventId.InOutDocumentNumber);
			}
			if (!oe.InOutLineEventId.LineNumber.Equals(e.InOutLineImageEventId.InOutLineLineNumber))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id LineNumber {0} but inner id InOutLineLineNumber {1}", 
					oe.InOutLineEventId.LineNumber, e.InOutLineImageEventId.InOutLineLineNumber);
			}
		}



        string IEventDto.EventType
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}

    public abstract class InOutLineStateEventBase : InOutLineEventBase, IInOutLineStateEvent
    {

		public virtual string LocatorId { get; set; }

		public virtual string ProductId { get; set; }

		public virtual string AttributeSetInstanceId { get; set; }

		public virtual string DamageStatusId { get; set; }

		public virtual string Description { get; set; }

		public virtual string QuantityUomId { get; set; }

		public virtual decimal? MovementQuantity { get; set; }

		public virtual decimal? PickedQuantity { get; set; }

		public virtual bool? IsInvoiced { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual string RmaLineNumber { get; set; }

		public virtual string ReversalLineNumber { get; set; }

		public virtual bool? Active { get; set; }

        protected InOutLineStateEventBase() : base()
        {
        }

        protected InOutLineStateEventBase(InOutLineEventId stateEventId) : base(stateEventId)
        {
        }

    }

	public class InOutLineStateCreated : InOutLineStateEventBase, IInOutLineStateCreated, ISaveable
	{
		public InOutLineStateCreated () : this(new InOutLineEventId())
		{
		}

		public InOutLineStateCreated (InOutLineEventId stateEventId) : base(stateEventId)
		{
		}

		private Dictionary<InOutLineImageEventId, IInOutLineImageStateCreated> _inOutLineImageEvents = new Dictionary<InOutLineImageEventId, IInOutLineImageStateCreated>();
        
        private IEnumerable<IInOutLineImageStateCreated> _readOnlyInOutLineImageEvents;

        public virtual IEnumerable<IInOutLineImageStateCreated> InOutLineImageEvents
        {
            get
            {
                if (!EventReadOnly)
                {
                    return this._inOutLineImageEvents.Values;
                }
                else
                {
                    if (_readOnlyInOutLineImageEvents != null) { return _readOnlyInOutLineImageEvents; }
                    var eventDao = InOutLineImageEventDao;
                    var eL = new List<IInOutLineImageStateCreated>();
                    foreach (var e in eventDao.FindByInOutLineEventId(this.InOutLineEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IInOutLineImageStateCreated)e);
                    }
                    return (_readOnlyInOutLineImageEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddInOutLineImageEvent(e);
                    }
                }
                else { this._inOutLineImageEvents.Clear(); }
            }
        }
    
		public virtual void AddInOutLineImageEvent(IInOutLineImageStateCreated e)
		{
			ThrowOnInconsistentEventIds(e);
			this._inOutLineImageEvents[e.InOutLineImageEventId] = e;
		}

        public virtual IInOutLineImageStateCreated NewInOutLineImageStateCreated(string sequenceId)
        {
            var stateEvent = new InOutLineImageStateCreated(NewInOutLineImageEventId(sequenceId));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (IInOutLineImageStateCreated e in this.InOutLineImageEvents) {
				InOutLineImageEventDao.Save(e);
			}
		}

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class InOutLineStateMergePatched : InOutLineStateEventBase, IInOutLineStateMergePatched, ISaveable
	{
		public virtual bool IsPropertyLocatorIdRemoved { get; set; }

		public virtual bool IsPropertyProductIdRemoved { get; set; }

		public virtual bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		public virtual bool IsPropertyDamageStatusIdRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyQuantityUomIdRemoved { get; set; }

		public virtual bool IsPropertyMovementQuantityRemoved { get; set; }

		public virtual bool IsPropertyPickedQuantityRemoved { get; set; }

		public virtual bool IsPropertyIsInvoicedRemoved { get; set; }

		public virtual bool IsPropertyProcessedRemoved { get; set; }

		public virtual bool IsPropertyRmaLineNumberRemoved { get; set; }

		public virtual bool IsPropertyReversalLineNumberRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public InOutLineStateMergePatched ()
		{
		}

		public InOutLineStateMergePatched (InOutLineEventId stateEventId) : base(stateEventId)
		{
		}

		private Dictionary<InOutLineImageEventId, IInOutLineImageEvent> _inOutLineImageEvents = new Dictionary<InOutLineImageEventId, IInOutLineImageEvent>();

        private IEnumerable<IInOutLineImageEvent> _readOnlyInOutLineImageEvents;
        
        public virtual IEnumerable<IInOutLineImageEvent> InOutLineImageEvents
        {
            get
            {
                if (!EventReadOnly)
                {
                    return this._inOutLineImageEvents.Values;
                }
                else
                {
                    if (_readOnlyInOutLineImageEvents != null) { return _readOnlyInOutLineImageEvents; }
                    var eventDao = InOutLineImageEventDao;
                    var eL = new List<IInOutLineImageEvent>();
                    foreach (var e in eventDao.FindByInOutLineEventId(this.InOutLineEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IInOutLineImageEvent)e);
                    }
                    return (_readOnlyInOutLineImageEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddInOutLineImageEvent(e);
                    }
                }
                else { this._inOutLineImageEvents.Clear(); }
            }
        }

		public virtual void AddInOutLineImageEvent(IInOutLineImageEvent e)
		{
			ThrowOnInconsistentEventIds(e);
			this._inOutLineImageEvents[e.InOutLineImageEventId] = e;
		}

        public virtual IInOutLineImageStateCreated NewInOutLineImageStateCreated(string sequenceId)
        {
            var stateEvent = new InOutLineImageStateCreated(NewInOutLineImageEventId(sequenceId));
            return stateEvent;
        }

        public virtual IInOutLineImageStateMergePatched NewInOutLineImageStateMergePatched(string sequenceId)
        {
            var stateEvent = new InOutLineImageStateMergePatched(NewInOutLineImageEventId(sequenceId));
            return stateEvent;
        }

        public virtual IInOutLineImageStateRemoved NewInOutLineImageStateRemoved(string sequenceId)
        {
            var stateEvent = new InOutLineImageStateRemoved(NewInOutLineImageEventId(sequenceId));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (IInOutLineImageEvent e in this.InOutLineImageEvents) {
				InOutLineImageEventDao.Save(e);
			}
		}

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class InOutLineStateRemoved : InOutLineStateEventBase, IInOutLineStateRemoved, ISaveable
	{
		public InOutLineStateRemoved ()
		{
		}

		public InOutLineStateRemoved (InOutLineEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Removed;
        }

		private Dictionary<InOutLineImageEventId, IInOutLineImageStateRemoved> _inOutLineImageEvents = new Dictionary<InOutLineImageEventId, IInOutLineImageStateRemoved>();
		
        private IEnumerable<IInOutLineImageStateRemoved> _readOnlyInOutLineImageEvents;

        public virtual IEnumerable<IInOutLineImageStateRemoved> InOutLineImageEvents
        {
            get
            {
                if (!EventReadOnly)
                {
                    return this._inOutLineImageEvents.Values;
                }
                else
                {
                    if (_readOnlyInOutLineImageEvents != null) { return _readOnlyInOutLineImageEvents; }
                    var eventDao = InOutLineImageEventDao;
                    var eL = new List<IInOutLineImageStateRemoved>();
                    foreach (var e in eventDao.FindByInOutLineEventId(this.InOutLineEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IInOutLineImageStateRemoved)e);
                    }
                    return (_readOnlyInOutLineImageEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddInOutLineImageEvent(e);
                    }
                }
                else { this._inOutLineImageEvents.Clear(); }
            }
        }
	
		public virtual void AddInOutLineImageEvent(IInOutLineImageStateRemoved e)
		{
			ThrowOnInconsistentEventIds(e);
			this._inOutLineImageEvents[e.InOutLineImageEventId] = e;
		}

        public virtual IInOutLineImageStateRemoved NewInOutLineImageStateRemoved(string sequenceId)
        {
            var stateEvent = new InOutLineImageStateRemoved(NewInOutLineImageEventId(sequenceId));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (IInOutLineImageStateRemoved e in this.InOutLineImageEvents) {
				InOutLineImageEventDao.Save(e);
			}
		}


	}



}

