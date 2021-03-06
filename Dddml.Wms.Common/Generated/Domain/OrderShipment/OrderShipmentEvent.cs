﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderShipment;

namespace Dddml.Wms.Domain.OrderShipment
{

	public abstract class OrderShipmentEventBase : IOrderShipmentEvent
	{

		public virtual OrderShipmentEventId OrderShipmentEventId { get; set; }

        public virtual OrderShipmentId OrderShipmentId
        {
            get { return OrderShipmentEventId.OrderShipmentId; }
            set { OrderShipmentEventId.OrderShipmentId = value; }
        }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		OrderShipmentEventId IGlobalIdentity<OrderShipmentEventId>.GlobalId {
			get
			{
				return this.OrderShipmentEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IOrderShipmentEvent.ReadOnly
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

        protected OrderShipmentEventBase()
        {
        }

        protected OrderShipmentEventBase(OrderShipmentEventId stateEventId)
        {
            this.OrderShipmentEventId = stateEventId;
        }


        string IEventDto.EventType
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}

    public abstract class OrderShipmentStateEventBase : OrderShipmentEventBase, IOrderShipmentStateEvent
    {

		public virtual decimal? Quantity { get; set; }

		public virtual bool? Active { get; set; }

        protected OrderShipmentStateEventBase() : base()
        {
        }

        protected OrderShipmentStateEventBase(OrderShipmentEventId stateEventId) : base(stateEventId)
        {
        }

    }

	public class OrderShipmentStateCreated : OrderShipmentStateEventBase, IOrderShipmentStateCreated
	{
		public OrderShipmentStateCreated () : this(new OrderShipmentEventId())
		{
		}

		public OrderShipmentStateCreated (OrderShipmentEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class OrderShipmentStateMergePatched : OrderShipmentStateEventBase, IOrderShipmentStateMergePatched
	{
		public virtual bool IsPropertyQuantityRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public OrderShipmentStateMergePatched ()
		{
		}

		public OrderShipmentStateMergePatched (OrderShipmentEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}




}

