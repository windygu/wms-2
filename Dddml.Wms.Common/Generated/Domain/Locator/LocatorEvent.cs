﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLocatorDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Locator;

namespace Dddml.Wms.Domain.Locator
{

	public abstract class LocatorEventBase : ILocatorEvent
	{

		public virtual LocatorEventId LocatorEventId { get; set; }

        public virtual string LocatorId
        {
            get { return LocatorEventId.LocatorId; }
            set { LocatorEventId.LocatorId = value; }
        }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		LocatorEventId IGlobalIdentity<LocatorEventId>.GlobalId {
			get
			{
				return this.LocatorEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool ILocatorEvent.ReadOnly
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

        protected LocatorEventBase()
        {
        }

        protected LocatorEventBase(LocatorEventId stateEventId)
        {
            this.LocatorEventId = stateEventId;
        }


        string IEventDto.EventType
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}

    public abstract class LocatorStateEventBase : LocatorEventBase, ILocatorStateEvent
    {

		public virtual string WarehouseId { get; set; }

		public virtual string ParentLocatorId { get; set; }

		public virtual string LocatorType { get; set; }

		public virtual string PriorityNumber { get; set; }

		public virtual bool? IsDefault { get; set; }

		public virtual string X { get; set; }

		public virtual string Y { get; set; }

		public virtual string Z { get; set; }

		public virtual string Description { get; set; }

		public virtual string LocatorTypeId { get; set; }

		public virtual bool? Active { get; set; }

        protected LocatorStateEventBase() : base()
        {
        }

        protected LocatorStateEventBase(LocatorEventId stateEventId) : base(stateEventId)
        {
        }

    }

	public class LocatorStateCreated : LocatorStateEventBase, ILocatorStateCreated
	{
		public LocatorStateCreated () : this(new LocatorEventId())
		{
		}

		public LocatorStateCreated (LocatorEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class LocatorStateMergePatched : LocatorStateEventBase, ILocatorStateMergePatched
	{
		public virtual bool IsPropertyWarehouseIdRemoved { get; set; }

		public virtual bool IsPropertyParentLocatorIdRemoved { get; set; }

		public virtual bool IsPropertyLocatorTypeRemoved { get; set; }

		public virtual bool IsPropertyPriorityNumberRemoved { get; set; }

		public virtual bool IsPropertyIsDefaultRemoved { get; set; }

		public virtual bool IsPropertyXRemoved { get; set; }

		public virtual bool IsPropertyYRemoved { get; set; }

		public virtual bool IsPropertyZRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyLocatorTypeIdRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public LocatorStateMergePatched ()
		{
		}

		public LocatorStateMergePatched (LocatorEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class LocatorStateDeleted : LocatorStateEventBase, ILocatorStateDeleted
	{
		public LocatorStateDeleted ()
		{
		}

		public LocatorStateDeleted (LocatorEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }



	}



}
