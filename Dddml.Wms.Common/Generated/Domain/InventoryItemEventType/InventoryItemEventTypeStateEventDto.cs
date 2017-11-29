﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEventTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEventType;

namespace Dddml.Wms.Domain.InventoryItemEventType
{

	public abstract class InventoryItemEventTypeStateEventDtoBase : IStateEventDto, IInventoryItemEventTypeStateCreated, IInventoryItemEventTypeStateMergePatched, IInventoryItemEventTypeStateDeleted
	{

        private InventoryItemEventTypeStateEventIdDto _stateEventId;

		protected internal virtual InventoryItemEventTypeStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new InventoryItemEventTypeStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual string InventoryItemEventTypeId
        {
            get { return StateEventId.InventoryItemEventTypeId; }
            set { StateEventId.InventoryItemEventTypeId = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InventoryItemEventTypeStateEventId IGlobalIdentity<InventoryItemEventTypeStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToInventoryItemEventTypeStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IInventoryItemEventTypeStateEvent.ReadOnly
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

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IInventoryItemEventTypeStateMergePatched.IsPropertyDescriptionRemoved
        {
            get 
            {
                var b = this.IsPropertyDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IInventoryItemEventTypeStateMergePatched.IsPropertyActiveRemoved
        {
            get 
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyActiveRemoved = value;
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


        InventoryItemEventTypeStateEventId IInventoryItemEventTypeStateEvent.StateEventId
        {
            get { return this.StateEventId.ToInventoryItemEventTypeStateEventId(); }
        }

        protected InventoryItemEventTypeStateEventDtoBase()
        {
        }

        protected InventoryItemEventTypeStateEventDtoBase(InventoryItemEventTypeStateEventIdDto stateEventId)
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


    public class InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto : InventoryItemEventTypeStateEventDtoBase
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



	public class InventoryItemEventTypeStateCreatedDto : InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryItemEventTypeStateCreatedDto()
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


	public class InventoryItemEventTypeStateMergePatchedDto : InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryItemEventTypeStateMergePatchedDto()
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


	public class InventoryItemEventTypeStateDeletedDto : InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryItemEventTypeStateDeletedDto()
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
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }

	}


    public partial class InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IInventoryItemEventTypeStateCreated>, IEnumerable<IInventoryItemEventTypeStateMergePatched>, IEnumerable<IInventoryItemEventTypeStateDeleted>
    {
        private List<InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryItemEventTypeStateCreated> IEnumerable<IInventoryItemEventTypeStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryItemEventTypeStateMergePatched> IEnumerable<IInventoryItemEventTypeStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryItemEventTypeStateDeleted> IEnumerable<IInventoryItemEventTypeStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddInventoryItemEventTypeEvent(IInventoryItemEventTypeStateCreated e)
        {
            _innerStateEvents.Add((InventoryItemEventTypeStateCreatedDto)e);
        }

        public void AddInventoryItemEventTypeEvent(IInventoryItemEventTypeStateEvent e)
        {
            _innerStateEvents.Add((InventoryItemEventTypeStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddInventoryItemEventTypeEvent(IInventoryItemEventTypeStateDeleted e)
        {
            _innerStateEvents.Add((InventoryItemEventTypeStateDeletedDto)e);
        }

    }


}
