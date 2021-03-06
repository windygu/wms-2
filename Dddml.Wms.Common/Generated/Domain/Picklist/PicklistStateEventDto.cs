﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Picklist;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Picklist
{

	public abstract class PicklistStateEventDtoBase : IEventDto, IPicklistStateCreated, IPicklistStateMergePatched, IPicklistStateDeleted
	{

        private PicklistEventId _picklistEventId;

		protected internal virtual PicklistEventId PicklistEventId 
        {
            get 
            {
                if (_picklistEventId == null) { _picklistEventId = new PicklistEventId(); }
                return _picklistEventId;
            }
            set
            {
                _picklistEventId = value;
            }
        }

        public virtual string PicklistId
        {
            get { return PicklistEventId.PicklistId; }
            set { PicklistEventId.PicklistId = value; }
        }

        public virtual long Version
        {
            get { return PicklistEventId.Version; }
            set { PicklistEventId.Version = value; }
        }

		public virtual string Description { get; set; }

		public virtual string FacilityId { get; set; }

		public virtual string ShipmentMethodTypeId { get; set; }

		public virtual string StatusId { get; set; }

		public virtual DateTime? PicklistDate { get; set; }

		public virtual long? PickwaveId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		PicklistEventId IGlobalIdentity<PicklistEventId>.GlobalId {
			get 
			{
				return this.PicklistEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IPicklistEvent.ReadOnly
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

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyFacilityIdRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyFacilityIdRemoved
        {
            get 
            {
                var b = this.IsPropertyFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentMethodTypeIdRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyShipmentMethodTypeIdRemoved
        {
            get 
            {
                var b = this.IsPropertyShipmentMethodTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyShipmentMethodTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyStatusIdRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyStatusIdRemoved
        {
            get 
            {
                var b = this.IsPropertyStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPicklistDateRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyPicklistDateRemoved
        {
            get 
            {
                var b = this.IsPropertyPicklistDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPicklistDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyPickwaveIdRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyPickwaveIdRemoved
        {
            get 
            {
                var b = this.IsPropertyPickwaveIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPickwaveIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IPicklistStateMergePatched.IsPropertyActiveRemoved
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


        private PicklistRoleStateCreatedOrMergePatchedOrRemovedDtos _picklistRoleEvents = new PicklistRoleStateCreatedOrMergePatchedOrRemovedDtos();

        public virtual PicklistRoleStateCreatedOrMergePatchedOrRemovedDto[] PicklistRoleEvents
        {
            get
            {
                return _picklistRoleEvents.ToArray();
            }
            set
            {
                _picklistRoleEvents.Clear();
                _picklistRoleEvents.AddRange(value);
            }
        }



        private PicklistRoleEventId NewPicklistRoleEventId(PartyRoleId partyRoleId)
        {
            var eId = new PicklistRoleEventId();
            eId.PicklistId = this.PicklistEventId.PicklistId;
            eId.PartyRoleId = partyRoleId;
            eId.PicklistVersion = this.PicklistEventId.Version;
            return eId;
        }

        public virtual PicklistRoleStateCreatedDto NewPicklistRoleStateCreated(PartyRoleId partyRoleId)
        {
            var e = new PicklistRoleStateCreatedDto();
            var eId = NewPicklistRoleEventId(partyRoleId);
            e.PicklistRoleEventId = eId;
            return e;
        }

        public virtual PicklistRoleStateMergePatchedDto NewPicklistRoleStateMergePatched(PartyRoleId partyRoleId)
        {
            var e = new PicklistRoleStateMergePatchedDto();
            var eId = NewPicklistRoleEventId(partyRoleId);
            e.PicklistRoleEventId = eId;
            return e;
        }

        public virtual PicklistRoleStateRemovedDto NewPicklistRoleStateRemoved(PartyRoleId partyRoleId)
        {
            var e = new PicklistRoleStateRemovedDto();
            var eId = NewPicklistRoleEventId(partyRoleId);
            e.PicklistRoleEventId = eId;
            return e;
        }

        IEnumerable<IPicklistRoleStateCreated> IPicklistStateCreated.PicklistRoleEvents
        {
            get { return this._picklistRoleEvents; }
        }

        void IPicklistStateCreated.AddPicklistRoleEvent(IPicklistRoleStateCreated e)
        {
            this._picklistRoleEvents.AddPicklistRoleEvent(e);
        }

        IPicklistRoleStateCreated IPicklistStateCreated.NewPicklistRoleStateCreated(PartyRoleId partyRoleId)
        {
            return NewPicklistRoleStateCreated(partyRoleId);
        }

        IEnumerable<IPicklistRoleEvent> IPicklistStateMergePatched.PicklistRoleEvents
        {
            get { return this._picklistRoleEvents; }
        }

        void IPicklistStateMergePatched.AddPicklistRoleEvent(IPicklistRoleEvent e)
        {
            this._picklistRoleEvents.AddPicklistRoleEvent(e);
        }

        IPicklistRoleStateCreated IPicklistStateMergePatched.NewPicklistRoleStateCreated(PartyRoleId partyRoleId)
        {
            return NewPicklistRoleStateCreated(partyRoleId);
        }

        IPicklistRoleStateMergePatched IPicklistStateMergePatched.NewPicklistRoleStateMergePatched(PartyRoleId partyRoleId)
        {
            return NewPicklistRoleStateMergePatched(partyRoleId);
        }

        IPicklistRoleStateRemoved IPicklistStateMergePatched.NewPicklistRoleStateRemoved(PartyRoleId partyRoleId)
        {
            return NewPicklistRoleStateRemoved(partyRoleId);
        }


        IEnumerable<IPicklistRoleStateRemoved> IPicklistStateDeleted.PicklistRoleEvents
        {
            get { return this._picklistRoleEvents; }
        }

        void IPicklistStateDeleted.AddPicklistRoleEvent(IPicklistRoleStateRemoved e)
        {
            this._picklistRoleEvents.AddPicklistRoleEvent(e);
        }

        IPicklistRoleStateRemoved IPicklistStateDeleted.NewPicklistRoleStateRemoved(PartyRoleId partyRoleId)
        {
            return NewPicklistRoleStateRemoved(partyRoleId);
        }



        PicklistEventId IPicklistEvent.PicklistEventId
        {
            get { return this.PicklistEventId; }
        }

        protected PicklistStateEventDtoBase()
        {
        }

        protected PicklistStateEventDtoBase(PicklistEventId stateEventId)
        {
            this.PicklistEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IEventDto.EventType 
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}


    public class PicklistStateCreatedOrMergePatchedOrDeletedDto : PicklistStateEventDtoBase
    {
        private string _eventType;

        public virtual string EventType
        {
            get { return _eventType; }
            set { _eventType = value; }
        }

        protected override string GetEventType()
        {
            return this._eventType;
        }

    }



	public class PicklistStateCreatedDto : PicklistStateCreatedOrMergePatchedOrDeletedDto
	{
		public PicklistStateCreatedDto()
		{
		}

        public override string EventType
        {
            get { return this.GetEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class PicklistStateMergePatchedDto : PicklistStateCreatedOrMergePatchedOrDeletedDto
	{
		public PicklistStateMergePatchedDto()
		{
		}

        public override string EventType
        {
            get { return this.GetEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class PicklistStateDeletedDto : PicklistStateCreatedOrMergePatchedOrDeletedDto
	{
		public PicklistStateDeletedDto()
		{
		}

        public override string EventType
        {
            get { return this.GetEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }

	}


    public partial class PicklistStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IPicklistStateCreated>, IEnumerable<IPicklistStateMergePatched>, IEnumerable<IPicklistStateDeleted>
    {
        private List<PicklistStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<PicklistStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual PicklistStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<PicklistStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPicklistStateCreated> IEnumerable<IPicklistStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPicklistStateMergePatched> IEnumerable<IPicklistStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPicklistStateDeleted> IEnumerable<IPicklistStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddPicklistEvent(IPicklistStateCreated e)
        {
            _innerStateEvents.Add((PicklistStateCreatedDto)e);
        }

        public void AddPicklistEvent(IPicklistEvent e)
        {
            _innerStateEvents.Add((PicklistStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddPicklistEvent(IPicklistStateDeleted e)
        {
            _innerStateEvents.Add((PicklistStateDeletedDto)e);
        }

    }


}

