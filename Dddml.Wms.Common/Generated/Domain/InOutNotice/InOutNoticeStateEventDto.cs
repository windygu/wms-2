﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{

	public abstract class InOutNoticeStateEventDtoBase : IEventDto, IInOutNoticeStateCreated, IInOutNoticeStateMergePatched, IInOutNoticeStateDeleted
	{

        private InOutNoticeEventId _inOutNoticeEventId;

		protected internal virtual InOutNoticeEventId InOutNoticeEventId 
        {
            get 
            {
                if (_inOutNoticeEventId == null) { _inOutNoticeEventId = new InOutNoticeEventId(); }
                return _inOutNoticeEventId;
            }
            set
            {
                _inOutNoticeEventId = value;
            }
        }

        public virtual string InOutNoticeId
        {
            get { return InOutNoticeEventId.InOutNoticeId; }
            set { InOutNoticeEventId.InOutNoticeId = value; }
        }

        public virtual long Version
        {
            get { return InOutNoticeEventId.Version; }
            set { InOutNoticeEventId.Version = value; }
        }

		public virtual string WarehouseId { get; set; }

		public virtual string InOutNoticeType { get; set; }

		public virtual string TelecomContactMechId { get; set; }

		public virtual string TrackingNumber { get; set; }

		public virtual string ContactPartyId { get; set; }

		public virtual string VehiclePlateNumber { get; set; }

		public virtual string ShippingInstructions { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual DateTime? EstimatedDeliveryDate { get; set; }

		public virtual string StatusId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InOutNoticeEventId IGlobalIdentity<InOutNoticeEventId>.GlobalId {
			get 
			{
				return this.InOutNoticeEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IInOutNoticeEvent.ReadOnly
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

		public virtual bool? IsPropertyWarehouseIdRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyWarehouseIdRemoved
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

		public virtual bool? IsPropertyInOutNoticeTypeRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyInOutNoticeTypeRemoved
        {
            get 
            {
                var b = this.IsPropertyInOutNoticeTypeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyInOutNoticeTypeRemoved = value;
            }
        }

		public virtual bool? IsPropertyTelecomContactMechIdRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyTelecomContactMechIdRemoved
        {
            get 
            {
                var b = this.IsPropertyTelecomContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyTelecomContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyTrackingNumberRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyTrackingNumberRemoved
        {
            get 
            {
                var b = this.IsPropertyTrackingNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyTrackingNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyContactPartyIdRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyContactPartyIdRemoved
        {
            get 
            {
                var b = this.IsPropertyContactPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyContactPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVehiclePlateNumberRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyVehiclePlateNumberRemoved
        {
            get 
            {
                var b = this.IsPropertyVehiclePlateNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyVehiclePlateNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyShippingInstructionsRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyShippingInstructionsRemoved
        {
            get 
            {
                var b = this.IsPropertyShippingInstructionsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyShippingInstructionsRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedShipDateRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyEstimatedShipDateRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedShipDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedShipDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedDeliveryDateRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyEstimatedDeliveryDateRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedDeliveryDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedDeliveryDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyStatusIdRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyStatusIdRemoved
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

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IInOutNoticeStateMergePatched.IsPropertyActiveRemoved
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


        InOutNoticeEventId IInOutNoticeEvent.InOutNoticeEventId
        {
            get { return this.InOutNoticeEventId; }
        }

        protected InOutNoticeStateEventDtoBase()
        {
        }

        protected InOutNoticeStateEventDtoBase(InOutNoticeEventId stateEventId)
        {
            this.InOutNoticeEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IEventDto.EventType 
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}


    public class InOutNoticeStateCreatedOrMergePatchedOrDeletedDto : InOutNoticeStateEventDtoBase
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



	public class InOutNoticeStateCreatedDto : InOutNoticeStateCreatedOrMergePatchedOrDeletedDto
	{
		public InOutNoticeStateCreatedDto()
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


	public class InOutNoticeStateMergePatchedDto : InOutNoticeStateCreatedOrMergePatchedOrDeletedDto
	{
		public InOutNoticeStateMergePatchedDto()
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


	public class InOutNoticeStateDeletedDto : InOutNoticeStateCreatedOrMergePatchedOrDeletedDto
	{
		public InOutNoticeStateDeletedDto()
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


    public partial class InOutNoticeStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IInOutNoticeStateCreated>, IEnumerable<IInOutNoticeStateMergePatched>, IEnumerable<IInOutNoticeStateDeleted>
    {
        private List<InOutNoticeStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<InOutNoticeStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual InOutNoticeStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<InOutNoticeStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInOutNoticeStateCreated> IEnumerable<IInOutNoticeStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInOutNoticeStateMergePatched> IEnumerable<IInOutNoticeStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInOutNoticeStateDeleted> IEnumerable<IInOutNoticeStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddInOutNoticeEvent(IInOutNoticeStateCreated e)
        {
            _innerStateEvents.Add((InOutNoticeStateCreatedDto)e);
        }

        public void AddInOutNoticeEvent(IInOutNoticeEvent e)
        {
            _innerStateEvents.Add((InOutNoticeStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddInOutNoticeEvent(IInOutNoticeStateDeleted e)
        {
            _innerStateEvents.Add((InOutNoticeStateDeletedDto)e);
        }

    }


}

