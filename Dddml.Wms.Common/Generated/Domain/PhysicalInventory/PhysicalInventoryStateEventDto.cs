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

	public abstract class PhysicalInventoryStateEventDtoBase : IStateEventDto, IPhysicalInventoryStateCreated, IPhysicalInventoryStateMergePatched, IPhysicalInventoryStateDeleted
	{

        private PhysicalInventoryStateEventIdDto _stateEventId;

		protected internal virtual PhysicalInventoryStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new PhysicalInventoryStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual string DocumentNumber
        {
            get { return StateEventId.DocumentNumber; }
            set { StateEventId.DocumentNumber = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual string DocumentStatusId { get; set; }

		public virtual string WarehouseId { get; set; }

		public virtual bool? Posted { get; set; }

		public virtual bool? Processed { get; set; }

		public virtual string Processing { get; set; }

		public virtual string DocumentTypeId { get; set; }

		public virtual DateTime? MovementDate { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? IsApproved { get; set; }

		public virtual decimal? ApprovalAmount { get; set; }

		public virtual bool? IsQuantityUpdated { get; set; }

		public virtual string ReversalDocumentNumber { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		PhysicalInventoryStateEventId IGlobalIdentity<PhysicalInventoryStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToPhysicalInventoryStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IPhysicalInventoryStateEvent.ReadOnly
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

		public virtual bool? IsPropertyDocumentStatusIdRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyDocumentStatusIdRemoved
        {
            get 
            {
                var b = this.IsPropertyDocumentStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDocumentStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyWarehouseIdRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyWarehouseIdRemoved
        {
            get 
            {
                var b = this.IsPropertyWarehouseIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyWarehouseIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPostedRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyPostedRemoved
        {
            get 
            {
                var b = this.IsPropertyPostedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPostedRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessedRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyProcessedRemoved
        {
            get 
            {
                var b = this.IsPropertyProcessedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyProcessedRemoved = value;
            }
        }

		public virtual bool? IsPropertyProcessingRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyProcessingRemoved
        {
            get 
            {
                var b = this.IsPropertyProcessingRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyProcessingRemoved = value;
            }
        }

		public virtual bool? IsPropertyDocumentTypeIdRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyDocumentTypeIdRemoved
        {
            get 
            {
                var b = this.IsPropertyDocumentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDocumentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyMovementDateRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyMovementDateRemoved
        {
            get 
            {
                var b = this.IsPropertyMovementDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyMovementDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyIsApprovedRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyIsApprovedRemoved
        {
            get 
            {
                var b = this.IsPropertyIsApprovedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyIsApprovedRemoved = value;
            }
        }

		public virtual bool? IsPropertyApprovalAmountRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyApprovalAmountRemoved
        {
            get 
            {
                var b = this.IsPropertyApprovalAmountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyApprovalAmountRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsQuantityUpdatedRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyIsQuantityUpdatedRemoved
        {
            get 
            {
                var b = this.IsPropertyIsQuantityUpdatedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyIsQuantityUpdatedRemoved = value;
            }
        }

		public virtual bool? IsPropertyReversalDocumentNumberRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyReversalDocumentNumberRemoved
        {
            get 
            {
                var b = this.IsPropertyReversalDocumentNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyReversalDocumentNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IPhysicalInventoryStateMergePatched.IsPropertyActiveRemoved
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


        private PhysicalInventoryLineStateCreatedOrMergePatchedOrRemovedDtos _physicalInventoryLineEvents = new PhysicalInventoryLineStateCreatedOrMergePatchedOrRemovedDtos();

        public virtual PhysicalInventoryLineStateCreatedOrMergePatchedOrRemovedDto[] PhysicalInventoryLineEvents
        {
            get
            {
                return _physicalInventoryLineEvents.ToArray();
            }
            set
            {
                _physicalInventoryLineEvents.Clear();
                _physicalInventoryLineEvents.AddRange(value);
            }
        }



        private PhysicalInventoryLineStateEventIdDto NewPhysicalInventoryLineStateEventId(string lineNumber)
        {
            var eId = new PhysicalInventoryLineStateEventIdDto();
            eId.PhysicalInventoryDocumentNumber = this.StateEventId.DocumentNumber;
            eId.LineNumber = lineNumber;
            eId.PhysicalInventoryVersion = this.StateEventId.Version;
            return eId;
        }

        public virtual PhysicalInventoryLineStateCreatedDto NewPhysicalInventoryLineStateCreated(string lineNumber)
        {
            var e = new PhysicalInventoryLineStateCreatedDto();
            var eId = NewPhysicalInventoryLineStateEventId(lineNumber);
            e.StateEventId = eId;
            return e;
        }

        public virtual PhysicalInventoryLineStateMergePatchedDto NewPhysicalInventoryLineStateMergePatched(string lineNumber)
        {
            var e = new PhysicalInventoryLineStateMergePatchedDto();
            var eId = NewPhysicalInventoryLineStateEventId(lineNumber);
            e.StateEventId = eId;
            return e;
        }

        public virtual PhysicalInventoryLineStateRemovedDto NewPhysicalInventoryLineStateRemoved(string lineNumber)
        {
            var e = new PhysicalInventoryLineStateRemovedDto();
            var eId = NewPhysicalInventoryLineStateEventId(lineNumber);
            e.StateEventId = eId;
            return e;
        }

        IEnumerable<IPhysicalInventoryLineStateCreated> IPhysicalInventoryStateCreated.PhysicalInventoryLineEvents
        {
            get { return this._physicalInventoryLineEvents; }
        }

        void IPhysicalInventoryStateCreated.AddPhysicalInventoryLineEvent(IPhysicalInventoryLineStateCreated e)
        {
            this._physicalInventoryLineEvents.AddPhysicalInventoryLineEvent(e);
        }

        IPhysicalInventoryLineStateCreated IPhysicalInventoryStateCreated.NewPhysicalInventoryLineStateCreated(string lineNumber)
        {
            return NewPhysicalInventoryLineStateCreated(lineNumber);
        }

        IEnumerable<IPhysicalInventoryLineStateEvent> IPhysicalInventoryStateMergePatched.PhysicalInventoryLineEvents
        {
            get { return this._physicalInventoryLineEvents; }
        }

        void IPhysicalInventoryStateMergePatched.AddPhysicalInventoryLineEvent(IPhysicalInventoryLineStateEvent e)
        {
            this._physicalInventoryLineEvents.AddPhysicalInventoryLineEvent(e);
        }

        IPhysicalInventoryLineStateCreated IPhysicalInventoryStateMergePatched.NewPhysicalInventoryLineStateCreated(string lineNumber)
        {
            return NewPhysicalInventoryLineStateCreated(lineNumber);
        }

        IPhysicalInventoryLineStateMergePatched IPhysicalInventoryStateMergePatched.NewPhysicalInventoryLineStateMergePatched(string lineNumber)
        {
            return NewPhysicalInventoryLineStateMergePatched(lineNumber);
        }

        IPhysicalInventoryLineStateRemoved IPhysicalInventoryStateMergePatched.NewPhysicalInventoryLineStateRemoved(string lineNumber)
        {
            return NewPhysicalInventoryLineStateRemoved(lineNumber);
        }


        IEnumerable<IPhysicalInventoryLineStateRemoved> IPhysicalInventoryStateDeleted.PhysicalInventoryLineEvents
        {
            get { return this._physicalInventoryLineEvents; }
        }

        void IPhysicalInventoryStateDeleted.AddPhysicalInventoryLineEvent(IPhysicalInventoryLineStateRemoved e)
        {
            this._physicalInventoryLineEvents.AddPhysicalInventoryLineEvent(e);
        }

        IPhysicalInventoryLineStateRemoved IPhysicalInventoryStateDeleted.NewPhysicalInventoryLineStateRemoved(string lineNumber)
        {
            return NewPhysicalInventoryLineStateRemoved(lineNumber);
        }



        PhysicalInventoryStateEventId IPhysicalInventoryStateEvent.StateEventId
        {
            get { return this.StateEventId.ToPhysicalInventoryStateEventId(); }
        }

        protected PhysicalInventoryStateEventDtoBase()
        {
        }

        protected PhysicalInventoryStateEventDtoBase(PhysicalInventoryStateEventIdDto stateEventId)
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


    public class PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto : PhysicalInventoryStateEventDtoBase
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



	public class PhysicalInventoryStateCreatedDto : PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto
	{
		public PhysicalInventoryStateCreatedDto()
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


	public class PhysicalInventoryStateMergePatchedDto : PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto
	{
		public PhysicalInventoryStateMergePatchedDto()
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


	public class PhysicalInventoryStateDeletedDto : PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto
	{
		public PhysicalInventoryStateDeletedDto()
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


    public partial class PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IPhysicalInventoryStateCreated>, IEnumerable<IPhysicalInventoryStateMergePatched>, IEnumerable<IPhysicalInventoryStateDeleted>
    {
        private List<PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPhysicalInventoryStateCreated> IEnumerable<IPhysicalInventoryStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPhysicalInventoryStateMergePatched> IEnumerable<IPhysicalInventoryStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPhysicalInventoryStateDeleted> IEnumerable<IPhysicalInventoryStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddPhysicalInventoryEvent(IPhysicalInventoryStateCreated e)
        {
            _innerStateEvents.Add((PhysicalInventoryStateCreatedDto)e);
        }

        public void AddPhysicalInventoryEvent(IPhysicalInventoryStateEvent e)
        {
            _innerStateEvents.Add((PhysicalInventoryStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddPhysicalInventoryEvent(IPhysicalInventoryStateDeleted e)
        {
            _innerStateEvents.Add((PhysicalInventoryStateDeletedDto)e);
        }

    }


}

