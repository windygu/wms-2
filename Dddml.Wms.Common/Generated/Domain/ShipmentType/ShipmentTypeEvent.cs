﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentType;

namespace Dddml.Wms.Domain.ShipmentType
{

	public abstract class ShipmentTypeEventBase : IShipmentTypeEvent
	{

		public virtual ShipmentTypeEventId ShipmentTypeEventId { get; set; }

        public virtual string ShipmentTypeId
        {
            get { return ShipmentTypeEventId.ShipmentTypeId; }
            set { ShipmentTypeEventId.ShipmentTypeId = value; }
        }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		ShipmentTypeEventId IGlobalIdentity<ShipmentTypeEventId>.GlobalId {
			get
			{
				return this.ShipmentTypeEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IShipmentTypeEvent.ReadOnly
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

        protected ShipmentTypeEventBase()
        {
        }

        protected ShipmentTypeEventBase(ShipmentTypeEventId stateEventId)
        {
            this.ShipmentTypeEventId = stateEventId;
        }


        string IEventDto.EventType
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}

    public abstract class ShipmentTypeStateEventBase : ShipmentTypeEventBase, IShipmentTypeStateEvent
    {

		public virtual string ParentTypeId { get; set; }

		public virtual string HasTable { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

        protected ShipmentTypeStateEventBase() : base()
        {
        }

        protected ShipmentTypeStateEventBase(ShipmentTypeEventId stateEventId) : base(stateEventId)
        {
        }

    }

	public class ShipmentTypeStateCreated : ShipmentTypeStateEventBase, IShipmentTypeStateCreated
	{
		public ShipmentTypeStateCreated () : this(new ShipmentTypeEventId())
		{
		}

		public ShipmentTypeStateCreated (ShipmentTypeEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class ShipmentTypeStateMergePatched : ShipmentTypeStateEventBase, IShipmentTypeStateMergePatched
	{
		public virtual bool IsPropertyParentTypeIdRemoved { get; set; }

		public virtual bool IsPropertyHasTableRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public ShipmentTypeStateMergePatched ()
		{
		}

		public ShipmentTypeStateMergePatched (ShipmentTypeEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}




}

