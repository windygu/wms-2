﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{

	public abstract class InventoryPRTriggeredStateEventDtoBase : IStateEventDto, IInventoryPRTriggeredStateCreated, IInventoryPRTriggeredStateMergePatched
	{

        private InventoryPRTriggeredStateEventIdDto _stateEventId;

		protected internal virtual InventoryPRTriggeredStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new InventoryPRTriggeredStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual InventoryPRTriggeredIdDto InventoryPRTriggeredId
        {
            get { return StateEventId.InventoryPRTriggeredId; }
            set { StateEventId.InventoryPRTriggeredId = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual bool? IsProcessed { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InventoryPRTriggeredStateEventId IGlobalIdentity<InventoryPRTriggeredStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToInventoryPRTriggeredStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IInventoryPRTriggeredStateEvent.ReadOnly
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

		public virtual bool? IsPropertyIsProcessedRemoved { get; set; }

        bool IInventoryPRTriggeredStateMergePatched.IsPropertyIsProcessedRemoved
        {
            get 
            {
                var b = this.IsPropertyIsProcessedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyIsProcessedRemoved = value;
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


        InventoryPRTriggeredStateEventId IInventoryPRTriggeredStateEvent.StateEventId
        {
            get { return this.StateEventId.ToInventoryPRTriggeredStateEventId(); }
        }

        protected InventoryPRTriggeredStateEventDtoBase()
        {
        }

        protected InventoryPRTriggeredStateEventDtoBase(InventoryPRTriggeredStateEventIdDto stateEventId)
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


    public class InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto : InventoryPRTriggeredStateEventDtoBase
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



	public class InventoryPRTriggeredStateCreatedDto : InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryPRTriggeredStateCreatedDto()
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


	public class InventoryPRTriggeredStateMergePatchedDto : InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryPRTriggeredStateMergePatchedDto()
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


	public class InventoryPRTriggeredStateDeletedDto : InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryPRTriggeredStateDeletedDto()
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


    public partial class InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IInventoryPRTriggeredStateCreated>, IEnumerable<IInventoryPRTriggeredStateMergePatched>
    {
        private List<InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryPRTriggeredStateCreated> IEnumerable<IInventoryPRTriggeredStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryPRTriggeredStateMergePatched> IEnumerable<IInventoryPRTriggeredStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }


        public void AddInventoryPRTriggeredEvent(IInventoryPRTriggeredStateCreated e)
        {
            _innerStateEvents.Add((InventoryPRTriggeredStateCreatedDto)e);
        }

        public void AddInventoryPRTriggeredEvent(IInventoryPRTriggeredStateEvent e)
        {
            _innerStateEvents.Add((InventoryPRTriggeredStateCreatedOrMergePatchedOrDeletedDto)e);
        }


    }


}

