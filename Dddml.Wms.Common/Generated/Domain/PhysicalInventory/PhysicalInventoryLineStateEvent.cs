﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public abstract class PhysicalInventoryLineStateEventBase : IPhysicalInventoryLineStateEvent
	{

		public virtual PhysicalInventoryLineStateEventId StateEventId { get; set; }

        public virtual string LineNumber
        {
            get { return StateEventId.LineNumber; }
            set { StateEventId.LineNumber = value; }
        }

		public virtual string LocatorId { get; set; }

		public virtual string ProductId { get; set; }

		public virtual string AttributeSetInstanceId { get; set; }

		public virtual decimal? BookQuantity { get; set; }

		public virtual decimal? CountedQuantity { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual long? ReversalLineNumber { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		PhysicalInventoryLineStateEventId IGlobalIdentity<PhysicalInventoryLineStateEventId>.GlobalId {
			get
			{
				return this.StateEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IPhysicalInventoryLineStateEvent.ReadOnly
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

        protected PhysicalInventoryLineStateEventBase()
        {
        }

        protected PhysicalInventoryLineStateEventBase(PhysicalInventoryLineStateEventId stateEventId)
        {
            this.StateEventId = stateEventId;
        }


        string IStateEventDto.StateEventType
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}

	public class PhysicalInventoryLineStateCreated : PhysicalInventoryLineStateEventBase, IPhysicalInventoryLineStateCreated
	{
		public PhysicalInventoryLineStateCreated () : this(new PhysicalInventoryLineStateEventId())
		{
		}

		public PhysicalInventoryLineStateCreated (PhysicalInventoryLineStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class PhysicalInventoryLineStateMergePatched : PhysicalInventoryLineStateEventBase, IPhysicalInventoryLineStateMergePatched
	{
		public virtual bool IsPropertyLocatorIdRemoved { get; set; }

		public virtual bool IsPropertyProductIdRemoved { get; set; }

		public virtual bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		public virtual bool IsPropertyBookQuantityRemoved { get; set; }

		public virtual bool IsPropertyCountedQuantityRemoved { get; set; }

		public virtual bool IsPropertyProcessedRemoved { get; set; }

		public virtual bool IsPropertyReversalLineNumberRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public PhysicalInventoryLineStateMergePatched ()
		{
		}

		public PhysicalInventoryLineStateMergePatched (PhysicalInventoryLineStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class PhysicalInventoryLineStateRemoved : PhysicalInventoryLineStateEventBase, IPhysicalInventoryLineStateRemoved
	{
		public PhysicalInventoryLineStateRemoved ()
		{
		}

		public PhysicalInventoryLineStateRemoved (PhysicalInventoryLineStateEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Removed;
        }



	}



}

