﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{

	public abstract class OrderShipGroupStateEventDtoBase : IEventDto, IOrderShipGroupStateCreated, IOrderShipGroupStateMergePatched, IOrderShipGroupStateRemoved
	{

        private OrderShipGroupEventId _orderShipGroupEventId;

		protected internal virtual OrderShipGroupEventId OrderShipGroupEventId 
        {
            get 
            {
                if (_orderShipGroupEventId == null) { _orderShipGroupEventId = new OrderShipGroupEventId(); }
                return _orderShipGroupEventId;
            }
            set
            {
                _orderShipGroupEventId = value;
            }
        }

        public virtual string ShipGroupSeqId
        {
            get { return OrderShipGroupEventId.ShipGroupSeqId; }
            set { OrderShipGroupEventId.ShipGroupSeqId = value; }
        }

		public virtual string ShipmentMethodTypeId { get; set; }

		public virtual string SupplierPartyId { get; set; }

		public virtual string VendorPartyId { get; set; }

		public virtual string CarrierPartyId { get; set; }

		public virtual string CarrierRoleTypeId { get; set; }

		public virtual string FacilityId { get; set; }

		public virtual string DestinationFacilityId { get; set; }

		public virtual string ContactMechId { get; set; }

		public virtual string TelecomContactMechId { get; set; }

		public virtual string TrackingNumber { get; set; }

		public virtual string ContactPartyId { get; set; }

		public virtual string VehiclePlateNumber { get; set; }

		public virtual string ShippingInstructions { get; set; }

		public virtual string MaySplit { get; set; }

		public virtual string GiftMessage { get; set; }

		public virtual string IsGift { get; set; }

		public virtual DateTime? ShipAfterDate { get; set; }

		public virtual DateTime? ShipByDate { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual DateTime? EstimatedDeliveryDate { get; set; }

		public virtual long? PickwaveId { get; set; }

		public virtual int? NumberOfPackages { get; set; }

		public virtual int? NumberOfContainers { get; set; }

		public virtual int? NumberOfPakagesPerContainer { get; set; }

		public virtual string OrderShipGroupStatusId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		OrderShipGroupEventId IGlobalIdentity<OrderShipGroupEventId>.GlobalId {
			get 
			{
				return this.OrderShipGroupEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IOrderShipGroupEvent.ReadOnly
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

		public virtual long Version { get; set; }

		public virtual bool? IsPropertyShipmentMethodTypeIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyShipmentMethodTypeIdRemoved
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

		public virtual bool? IsPropertySupplierPartyIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertySupplierPartyIdRemoved
        {
            get 
            {
                var b = this.IsPropertySupplierPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertySupplierPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVendorPartyIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyVendorPartyIdRemoved
        {
            get 
            {
                var b = this.IsPropertyVendorPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyVendorPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyCarrierPartyIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyCarrierPartyIdRemoved
        {
            get 
            {
                var b = this.IsPropertyCarrierPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyCarrierPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyCarrierRoleTypeIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyCarrierRoleTypeIdRemoved
        {
            get 
            {
                var b = this.IsPropertyCarrierRoleTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyCarrierRoleTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyFacilityIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyFacilityIdRemoved
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

		public virtual bool? IsPropertyDestinationFacilityIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyDestinationFacilityIdRemoved
        {
            get 
            {
                var b = this.IsPropertyDestinationFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDestinationFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyContactMechIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyContactMechIdRemoved
        {
            get 
            {
                var b = this.IsPropertyContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyTelecomContactMechIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyTelecomContactMechIdRemoved
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

        bool IOrderShipGroupStateMergePatched.IsPropertyTrackingNumberRemoved
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

        bool IOrderShipGroupStateMergePatched.IsPropertyContactPartyIdRemoved
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

        bool IOrderShipGroupStateMergePatched.IsPropertyVehiclePlateNumberRemoved
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

        bool IOrderShipGroupStateMergePatched.IsPropertyShippingInstructionsRemoved
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

		public virtual bool? IsPropertyMaySplitRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyMaySplitRemoved
        {
            get 
            {
                var b = this.IsPropertyMaySplitRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyMaySplitRemoved = value;
            }
        }

		public virtual bool? IsPropertyGiftMessageRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyGiftMessageRemoved
        {
            get 
            {
                var b = this.IsPropertyGiftMessageRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyGiftMessageRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsGiftRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyIsGiftRemoved
        {
            get 
            {
                var b = this.IsPropertyIsGiftRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyIsGiftRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipAfterDateRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyShipAfterDateRemoved
        {
            get 
            {
                var b = this.IsPropertyShipAfterDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyShipAfterDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipByDateRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyShipByDateRemoved
        {
            get 
            {
                var b = this.IsPropertyShipByDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyShipByDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedShipDateRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyEstimatedShipDateRemoved
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

        bool IOrderShipGroupStateMergePatched.IsPropertyEstimatedDeliveryDateRemoved
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

		public virtual bool? IsPropertyPickwaveIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyPickwaveIdRemoved
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

		public virtual bool? IsPropertyNumberOfPackagesRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyNumberOfPackagesRemoved
        {
            get 
            {
                var b = this.IsPropertyNumberOfPackagesRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyNumberOfPackagesRemoved = value;
            }
        }

		public virtual bool? IsPropertyNumberOfContainersRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyNumberOfContainersRemoved
        {
            get 
            {
                var b = this.IsPropertyNumberOfContainersRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyNumberOfContainersRemoved = value;
            }
        }

		public virtual bool? IsPropertyNumberOfPakagesPerContainerRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyNumberOfPakagesPerContainerRemoved
        {
            get 
            {
                var b = this.IsPropertyNumberOfPakagesPerContainerRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyNumberOfPakagesPerContainerRemoved = value;
            }
        }

		public virtual bool? IsPropertyOrderShipGroupStatusIdRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyOrderShipGroupStatusIdRemoved
        {
            get 
            {
                var b = this.IsPropertyOrderShipGroupStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyOrderShipGroupStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IOrderShipGroupStateMergePatched.IsPropertyActiveRemoved
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


        private OrderItemShipGroupAssociationStateCreatedOrMergePatchedOrRemovedDtos _orderItemShipGroupAssociationEvents = new OrderItemShipGroupAssociationStateCreatedOrMergePatchedOrRemovedDtos();

        public virtual OrderItemShipGroupAssociationStateCreatedOrMergePatchedOrRemovedDto[] OrderItemShipGroupAssociationEvents
        {
            get
            {
                return _orderItemShipGroupAssociationEvents.ToArray();
            }
            set
            {
                _orderItemShipGroupAssociationEvents.Clear();
                _orderItemShipGroupAssociationEvents.AddRange(value);
            }
        }



        private OrderItemShipGroupAssociationEventId NewOrderItemShipGroupAssociationEventId(string orderItemSeqId)
        {
            var eId = new OrderItemShipGroupAssociationEventId();
            eId.OrderId = this.OrderShipGroupEventId.OrderId;
            eId.OrderShipGroupShipGroupSeqId = this.OrderShipGroupEventId.ShipGroupSeqId;
            eId.OrderItemSeqId = orderItemSeqId;
            eId.OrderVersion = this.OrderShipGroupEventId.OrderVersion;
            return eId;
        }

        public virtual OrderItemShipGroupAssociationStateCreatedDto NewOrderItemShipGroupAssociationStateCreated(string orderItemSeqId)
        {
            var e = new OrderItemShipGroupAssociationStateCreatedDto();
            var eId = NewOrderItemShipGroupAssociationEventId(orderItemSeqId);
            e.OrderItemShipGroupAssociationEventId = eId;
            return e;
        }

        public virtual OrderItemShipGroupAssociationStateMergePatchedDto NewOrderItemShipGroupAssociationStateMergePatched(string orderItemSeqId)
        {
            var e = new OrderItemShipGroupAssociationStateMergePatchedDto();
            var eId = NewOrderItemShipGroupAssociationEventId(orderItemSeqId);
            e.OrderItemShipGroupAssociationEventId = eId;
            return e;
        }

        public virtual OrderItemShipGroupAssociationStateRemovedDto NewOrderItemShipGroupAssociationStateRemoved(string orderItemSeqId)
        {
            var e = new OrderItemShipGroupAssociationStateRemovedDto();
            var eId = NewOrderItemShipGroupAssociationEventId(orderItemSeqId);
            e.OrderItemShipGroupAssociationEventId = eId;
            return e;
        }

        IEnumerable<IOrderItemShipGroupAssociationStateCreated> IOrderShipGroupStateCreated.OrderItemShipGroupAssociationEvents
        {
            get { return this._orderItemShipGroupAssociationEvents; }
        }

        void IOrderShipGroupStateCreated.AddOrderItemShipGroupAssociationEvent(IOrderItemShipGroupAssociationStateCreated e)
        {
            this._orderItemShipGroupAssociationEvents.AddOrderItemShipGroupAssociationEvent(e);
        }

        IOrderItemShipGroupAssociationStateCreated IOrderShipGroupStateCreated.NewOrderItemShipGroupAssociationStateCreated(string orderItemSeqId)
        {
            return NewOrderItemShipGroupAssociationStateCreated(orderItemSeqId);
        }

        IEnumerable<IOrderItemShipGroupAssociationEvent> IOrderShipGroupStateMergePatched.OrderItemShipGroupAssociationEvents
        {
            get { return this._orderItemShipGroupAssociationEvents; }
        }

        void IOrderShipGroupStateMergePatched.AddOrderItemShipGroupAssociationEvent(IOrderItemShipGroupAssociationEvent e)
        {
            this._orderItemShipGroupAssociationEvents.AddOrderItemShipGroupAssociationEvent(e);
        }

        IOrderItemShipGroupAssociationStateCreated IOrderShipGroupStateMergePatched.NewOrderItemShipGroupAssociationStateCreated(string orderItemSeqId)
        {
            return NewOrderItemShipGroupAssociationStateCreated(orderItemSeqId);
        }

        IOrderItemShipGroupAssociationStateMergePatched IOrderShipGroupStateMergePatched.NewOrderItemShipGroupAssociationStateMergePatched(string orderItemSeqId)
        {
            return NewOrderItemShipGroupAssociationStateMergePatched(orderItemSeqId);
        }

        IOrderItemShipGroupAssociationStateRemoved IOrderShipGroupStateMergePatched.NewOrderItemShipGroupAssociationStateRemoved(string orderItemSeqId)
        {
            return NewOrderItemShipGroupAssociationStateRemoved(orderItemSeqId);
        }


        IEnumerable<IOrderItemShipGroupAssociationStateRemoved> IOrderShipGroupStateRemoved.OrderItemShipGroupAssociationEvents
        {
            get { return this._orderItemShipGroupAssociationEvents; }
        }

        void IOrderShipGroupStateRemoved.AddOrderItemShipGroupAssociationEvent(IOrderItemShipGroupAssociationStateRemoved e)
        {
            this._orderItemShipGroupAssociationEvents.AddOrderItemShipGroupAssociationEvent(e);
        }

        IOrderItemShipGroupAssociationStateRemoved IOrderShipGroupStateRemoved.NewOrderItemShipGroupAssociationStateRemoved(string orderItemSeqId)
        {
            return NewOrderItemShipGroupAssociationStateRemoved(orderItemSeqId);
        }



        OrderShipGroupEventId IOrderShipGroupEvent.OrderShipGroupEventId
        {
            get { return this.OrderShipGroupEventId; }
        }

        protected OrderShipGroupStateEventDtoBase()
        {
        }

        protected OrderShipGroupStateEventDtoBase(OrderShipGroupEventId stateEventId)
        {
            this.OrderShipGroupEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IEventDto.EventType 
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}


    public class OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto : OrderShipGroupStateEventDtoBase
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



	public class OrderShipGroupStateCreatedDto : OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto
	{
		public OrderShipGroupStateCreatedDto()
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


	public class OrderShipGroupStateMergePatchedDto : OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto
	{
		public OrderShipGroupStateMergePatchedDto()
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


	public class OrderShipGroupStateRemovedDto : OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto
	{
		public OrderShipGroupStateRemovedDto()
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
            return Dddml.Wms.Specialization.StateEventType.Removed;
        }

	}


    public partial class OrderShipGroupStateCreatedOrMergePatchedOrRemovedDtos : IEnumerable<IOrderShipGroupStateCreated>, IEnumerable<IOrderShipGroupStateMergePatched>, IEnumerable<IOrderShipGroupStateRemoved>
    {
        private List<OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto> _innerStateEvents = new List<OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto>();

        public virtual OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IOrderShipGroupStateCreated> IEnumerable<IOrderShipGroupStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IOrderShipGroupStateMergePatched> IEnumerable<IOrderShipGroupStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IOrderShipGroupStateRemoved> IEnumerable<IOrderShipGroupStateRemoved>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddOrderShipGroupEvent(IOrderShipGroupStateCreated e)
        {
            _innerStateEvents.Add((OrderShipGroupStateCreatedDto)e);
        }

        public void AddOrderShipGroupEvent(IOrderShipGroupEvent e)
        {
            _innerStateEvents.Add((OrderShipGroupStateCreatedOrMergePatchedOrRemovedDto)e);
        }

        public void AddOrderShipGroupEvent(IOrderShipGroupStateRemoved e)
        {
            _innerStateEvents.Add((OrderShipGroupStateRemovedDto)e);
        }

    }


}

