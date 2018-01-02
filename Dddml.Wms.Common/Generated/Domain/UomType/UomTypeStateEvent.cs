﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomType;

namespace Dddml.Wms.Domain.UomType
{

	public abstract class UomTypeStateEventBase : IUomTypeStateEvent
	{

		public virtual UomTypeStateEventId StateEventId { get; set; }

        public virtual string UomTypeId
        {
            get { return StateEventId.UomTypeId; }
            set { StateEventId.UomTypeId = value; }
        }

		public virtual string ParentTypeId { get; set; }

		public virtual string HasTable { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		UomTypeStateEventId IGlobalIdentity<UomTypeStateEventId>.GlobalId {
			get
			{
				return this.StateEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IUomTypeStateEvent.ReadOnly
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

        protected UomTypeStateEventBase()
        {
        }

        protected UomTypeStateEventBase(UomTypeStateEventId stateEventId)
        {
            this.StateEventId = stateEventId;
        }


        string IStateEventDto.StateEventType
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}

	public class UomTypeStateCreated : UomTypeStateEventBase, IUomTypeStateCreated
	{
		public UomTypeStateCreated () : this(new UomTypeStateEventId())
		{
		}

		public UomTypeStateCreated (UomTypeStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class UomTypeStateMergePatched : UomTypeStateEventBase, IUomTypeStateMergePatched
	{
		public virtual bool IsPropertyParentTypeIdRemoved { get; set; }

		public virtual bool IsPropertyHasTableRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public UomTypeStateMergePatched ()
		{
		}

		public UomTypeStateMergePatched (UomTypeStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class UomTypeStateDeleted : UomTypeStateEventBase, IUomTypeStateDeleted
	{
		public UomTypeStateDeleted ()
		{
		}

		public UomTypeStateDeleted (UomTypeStateEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }



	}



}
