﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemRequirementEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemRequirementEntryMvo;
using Dddml.Wms.Domain.InventoryItemRequirement;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.InventoryItemRequirementEntryMvo
{

	public abstract class InventoryItemRequirementEntryMvoStateEventDtoBase : IStateEventDto, IInventoryItemRequirementEntryMvoStateCreated, IInventoryItemRequirementEntryMvoStateMergePatched
	{

        private InventoryItemRequirementEntryMvoStateEventIdDto _stateEventId;

		protected internal virtual InventoryItemRequirementEntryMvoStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new InventoryItemRequirementEntryMvoStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual InventoryItemRequirementEntryIdDto InventoryItemRequirementEntryId
        {
            get { return StateEventId.InventoryItemRequirementEntryId; }
            set { StateEventId.InventoryItemRequirementEntryId = value; }
        }

        public virtual long InventoryItemRequirementVersion
        {
            get { return StateEventId.InventoryItemRequirementVersion; }
            set { StateEventId.InventoryItemRequirementVersion = value; }
        }

		public virtual decimal? Quantity { get; set; }

		private InventoryPRTriggeredIdDto _sourceEventId = new InventoryPRTriggeredIdDto();

		public virtual InventoryPRTriggeredIdDto SourceEventId { get { return _sourceEventId; } set { _sourceEventId = value; } }

		InventoryPRTriggeredId IInventoryItemRequirementEntryMvoStateEvent.SourceEventId
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

		public virtual long? Version { get; set; }

		public virtual decimal? InventoryItemRequirementQuantity { get; set; }

		public virtual string InventoryItemRequirementCreatedBy { get; set; }

		public virtual DateTime? InventoryItemRequirementCreatedAt { get; set; }

		public virtual string InventoryItemRequirementUpdatedBy { get; set; }

		public virtual DateTime? InventoryItemRequirementUpdatedAt { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InventoryItemRequirementEntryMvoStateEventId IGlobalIdentity<InventoryItemRequirementEntryMvoStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToInventoryItemRequirementEntryMvoStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IInventoryItemRequirementEntryMvoStateEvent.ReadOnly
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

		public virtual bool? IsPropertyQuantityRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyQuantityRemoved
        {
            get 
            {
                var b = this.IsPropertyQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertySourceEventIdRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertySourceEventIdRemoved
        {
            get 
            {
                var b = this.IsPropertySourceEventIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertySourceEventIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyVersionRemoved
        {
            get 
            {
                var b = this.IsPropertyVersionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyVersionRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemRequirementQuantityRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyInventoryItemRequirementQuantityRemoved
        {
            get 
            {
                var b = this.IsPropertyInventoryItemRequirementQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyInventoryItemRequirementQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemRequirementCreatedByRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyInventoryItemRequirementCreatedByRemoved
        {
            get 
            {
                var b = this.IsPropertyInventoryItemRequirementCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyInventoryItemRequirementCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemRequirementCreatedAtRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyInventoryItemRequirementCreatedAtRemoved
        {
            get 
            {
                var b = this.IsPropertyInventoryItemRequirementCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyInventoryItemRequirementCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemRequirementUpdatedByRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyInventoryItemRequirementUpdatedByRemoved
        {
            get 
            {
                var b = this.IsPropertyInventoryItemRequirementUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyInventoryItemRequirementUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemRequirementUpdatedAtRemoved { get; set; }

        bool IInventoryItemRequirementEntryMvoStateMergePatched.IsPropertyInventoryItemRequirementUpdatedAtRemoved
        {
            get 
            {
                var b = this.IsPropertyInventoryItemRequirementUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyInventoryItemRequirementUpdatedAtRemoved = value;
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


        InventoryItemRequirementEntryMvoStateEventId IInventoryItemRequirementEntryMvoStateEvent.StateEventId
        {
            get { return this.StateEventId.ToInventoryItemRequirementEntryMvoStateEventId(); }
        }

        protected InventoryItemRequirementEntryMvoStateEventDtoBase()
        {
        }

        protected InventoryItemRequirementEntryMvoStateEventDtoBase(InventoryItemRequirementEntryMvoStateEventIdDto stateEventId)
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


    public class InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto : InventoryItemRequirementEntryMvoStateEventDtoBase
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



	public class InventoryItemRequirementEntryMvoStateCreatedDto : InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryItemRequirementEntryMvoStateCreatedDto()
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


	public class InventoryItemRequirementEntryMvoStateMergePatchedDto : InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryItemRequirementEntryMvoStateMergePatchedDto()
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


	public class InventoryItemRequirementEntryMvoStateDeletedDto : InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto
	{
		public InventoryItemRequirementEntryMvoStateDeletedDto()
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


    public partial class InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IInventoryItemRequirementEntryMvoStateCreated>, IEnumerable<IInventoryItemRequirementEntryMvoStateMergePatched>
    {
        private List<InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryItemRequirementEntryMvoStateCreated> IEnumerable<IInventoryItemRequirementEntryMvoStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInventoryItemRequirementEntryMvoStateMergePatched> IEnumerable<IInventoryItemRequirementEntryMvoStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }


        public void AddInventoryItemRequirementEntryMvoEvent(IInventoryItemRequirementEntryMvoStateCreated e)
        {
            _innerStateEvents.Add((InventoryItemRequirementEntryMvoStateCreatedDto)e);
        }

        public void AddInventoryItemRequirementEntryMvoEvent(IInventoryItemRequirementEntryMvoStateEvent e)
        {
            _innerStateEvents.Add((InventoryItemRequirementEntryMvoStateCreatedOrMergePatchedOrDeletedDto)e);
        }


    }


}
