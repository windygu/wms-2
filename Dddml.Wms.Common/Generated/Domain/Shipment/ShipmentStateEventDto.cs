﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

	public abstract class ShipmentStateEventDtoBase : IStateEventDto, IShipmentStateCreated, IShipmentStateMergePatched
	{

        private ShipmentStateEventIdDto _stateEventId;

		protected internal virtual ShipmentStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new ShipmentStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual string ShipmentId
        {
            get { return StateEventId.ShipmentId; }
            set { StateEventId.ShipmentId = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual string ShipmentTypeId { get; set; }

		public virtual string StatusId { get; set; }

		public virtual string PrimaryOrderId { get; set; }

		public virtual string PrimaryReturnId { get; set; }

		public virtual string PicklistBinId { get; set; }

		public virtual DateTime? EstimatedReadyDate { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual string EstimatedShipWorkEffId { get; set; }

		public virtual DateTime? EstimatedArrivalDate { get; set; }

		public virtual string EstimatedArrivalWorkEffId { get; set; }

		public virtual DateTime? LatestCancelDate { get; set; }

		public virtual decimal? EstimatedShipCost { get; set; }

		public virtual string CurrencyUomId { get; set; }

		public virtual string HandlingInstructions { get; set; }

		public virtual string OriginFacilityId { get; set; }

		public virtual string DestinationFacilityId { get; set; }

		public virtual string OriginContactMechId { get; set; }

		public virtual string OriginTelecomNumberId { get; set; }

		public virtual string DestinationContactMechId { get; set; }

		public virtual string DestinationTelecomNumberId { get; set; }

		public virtual string PartyIdTo { get; set; }

		public virtual string PartyIdFrom { get; set; }

		public virtual decimal? AdditionalShippingCharge { get; set; }

		public virtual string AddtlShippingChargeDesc { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		ShipmentStateEventId IGlobalIdentity<ShipmentStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToShipmentStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IShipmentStateEvent.ReadOnly
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

		public virtual bool? IsPropertyShipmentTypeIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyShipmentTypeIdRemoved
        {
            get 
            {
                var b = this.IsPropertyShipmentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyShipmentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyStatusIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyStatusIdRemoved
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

		public virtual bool? IsPropertyPrimaryOrderIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyPrimaryOrderIdRemoved
        {
            get 
            {
                var b = this.IsPropertyPrimaryOrderIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPrimaryOrderIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPrimaryReturnIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyPrimaryReturnIdRemoved
        {
            get 
            {
                var b = this.IsPropertyPrimaryReturnIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPrimaryReturnIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPicklistBinIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyPicklistBinIdRemoved
        {
            get 
            {
                var b = this.IsPropertyPicklistBinIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPicklistBinIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedReadyDateRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyEstimatedReadyDateRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedReadyDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedReadyDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedShipDateRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyEstimatedShipDateRemoved
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

		public virtual bool? IsPropertyEstimatedShipWorkEffIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyEstimatedShipWorkEffIdRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedShipWorkEffIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedShipWorkEffIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedArrivalDateRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyEstimatedArrivalDateRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedArrivalDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedArrivalDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedArrivalWorkEffIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyEstimatedArrivalWorkEffIdRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedArrivalWorkEffIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedArrivalWorkEffIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyLatestCancelDateRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyLatestCancelDateRemoved
        {
            get 
            {
                var b = this.IsPropertyLatestCancelDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyLatestCancelDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedShipCostRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyEstimatedShipCostRemoved
        {
            get 
            {
                var b = this.IsPropertyEstimatedShipCostRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEstimatedShipCostRemoved = value;
            }
        }

		public virtual bool? IsPropertyCurrencyUomIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyCurrencyUomIdRemoved
        {
            get 
            {
                var b = this.IsPropertyCurrencyUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyCurrencyUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyHandlingInstructionsRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyHandlingInstructionsRemoved
        {
            get 
            {
                var b = this.IsPropertyHandlingInstructionsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyHandlingInstructionsRemoved = value;
            }
        }

		public virtual bool? IsPropertyOriginFacilityIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyOriginFacilityIdRemoved
        {
            get 
            {
                var b = this.IsPropertyOriginFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyOriginFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDestinationFacilityIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyDestinationFacilityIdRemoved
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

		public virtual bool? IsPropertyOriginContactMechIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyOriginContactMechIdRemoved
        {
            get 
            {
                var b = this.IsPropertyOriginContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyOriginContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyOriginTelecomNumberIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyOriginTelecomNumberIdRemoved
        {
            get 
            {
                var b = this.IsPropertyOriginTelecomNumberIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyOriginTelecomNumberIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDestinationContactMechIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyDestinationContactMechIdRemoved
        {
            get 
            {
                var b = this.IsPropertyDestinationContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDestinationContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDestinationTelecomNumberIdRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyDestinationTelecomNumberIdRemoved
        {
            get 
            {
                var b = this.IsPropertyDestinationTelecomNumberIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDestinationTelecomNumberIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPartyIdToRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyPartyIdToRemoved
        {
            get 
            {
                var b = this.IsPropertyPartyIdToRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPartyIdToRemoved = value;
            }
        }

		public virtual bool? IsPropertyPartyIdFromRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyPartyIdFromRemoved
        {
            get 
            {
                var b = this.IsPropertyPartyIdFromRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPartyIdFromRemoved = value;
            }
        }

		public virtual bool? IsPropertyAdditionalShippingChargeRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyAdditionalShippingChargeRemoved
        {
            get 
            {
                var b = this.IsPropertyAdditionalShippingChargeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyAdditionalShippingChargeRemoved = value;
            }
        }

		public virtual bool? IsPropertyAddtlShippingChargeDescRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyAddtlShippingChargeDescRemoved
        {
            get 
            {
                var b = this.IsPropertyAddtlShippingChargeDescRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyAddtlShippingChargeDescRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IShipmentStateMergePatched.IsPropertyActiveRemoved
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


        private ShipmentItemStateCreatedOrMergePatchedOrRemovedDtos _shipmentItemEvents = new ShipmentItemStateCreatedOrMergePatchedOrRemovedDtos();

        public virtual ShipmentItemStateCreatedOrMergePatchedOrRemovedDto[] ShipmentItemEvents
        {
            get
            {
                return _shipmentItemEvents.ToArray();
            }
            set
            {
                _shipmentItemEvents.Clear();
                _shipmentItemEvents.AddRange(value);
            }
        }



        private ShipmentItemStateEventIdDto NewShipmentItemStateEventId(string shipmentItemSeqId)
        {
            var eId = new ShipmentItemStateEventIdDto();
            eId.ShipmentId = this.StateEventId.ShipmentId;
            eId.ShipmentItemSeqId = shipmentItemSeqId;
            eId.ShipmentVersion = this.StateEventId.Version;
            return eId;
        }

        public virtual ShipmentItemStateCreatedDto NewShipmentItemStateCreated(string shipmentItemSeqId)
        {
            var e = new ShipmentItemStateCreatedDto();
            var eId = NewShipmentItemStateEventId(shipmentItemSeqId);
            e.StateEventId = eId;
            return e;
        }

        public virtual ShipmentItemStateMergePatchedDto NewShipmentItemStateMergePatched(string shipmentItemSeqId)
        {
            var e = new ShipmentItemStateMergePatchedDto();
            var eId = NewShipmentItemStateEventId(shipmentItemSeqId);
            e.StateEventId = eId;
            return e;
        }

        public virtual ShipmentItemStateRemovedDto NewShipmentItemStateRemoved(string shipmentItemSeqId)
        {
            var e = new ShipmentItemStateRemovedDto();
            var eId = NewShipmentItemStateEventId(shipmentItemSeqId);
            e.StateEventId = eId;
            return e;
        }

        IEnumerable<IShipmentItemStateCreated> IShipmentStateCreated.ShipmentItemEvents
        {
            get { return this._shipmentItemEvents; }
        }

        void IShipmentStateCreated.AddShipmentItemEvent(IShipmentItemStateCreated e)
        {
            this._shipmentItemEvents.AddShipmentItemEvent(e);
        }

        IShipmentItemStateCreated IShipmentStateCreated.NewShipmentItemStateCreated(string shipmentItemSeqId)
        {
            return NewShipmentItemStateCreated(shipmentItemSeqId);
        }

        IEnumerable<IShipmentItemStateEvent> IShipmentStateMergePatched.ShipmentItemEvents
        {
            get { return this._shipmentItemEvents; }
        }

        void IShipmentStateMergePatched.AddShipmentItemEvent(IShipmentItemStateEvent e)
        {
            this._shipmentItemEvents.AddShipmentItemEvent(e);
        }

        IShipmentItemStateCreated IShipmentStateMergePatched.NewShipmentItemStateCreated(string shipmentItemSeqId)
        {
            return NewShipmentItemStateCreated(shipmentItemSeqId);
        }

        IShipmentItemStateMergePatched IShipmentStateMergePatched.NewShipmentItemStateMergePatched(string shipmentItemSeqId)
        {
            return NewShipmentItemStateMergePatched(shipmentItemSeqId);
        }

        IShipmentItemStateRemoved IShipmentStateMergePatched.NewShipmentItemStateRemoved(string shipmentItemSeqId)
        {
            return NewShipmentItemStateRemoved(shipmentItemSeqId);
        }


        ShipmentStateEventId IShipmentStateEvent.StateEventId
        {
            get { return this.StateEventId.ToShipmentStateEventId(); }
        }

        protected ShipmentStateEventDtoBase()
        {
        }

        protected ShipmentStateEventDtoBase(ShipmentStateEventIdDto stateEventId)
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


    public class ShipmentStateCreatedOrMergePatchedOrDeletedDto : ShipmentStateEventDtoBase
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



	public class ShipmentStateCreatedDto : ShipmentStateCreatedOrMergePatchedOrDeletedDto
	{
		public ShipmentStateCreatedDto()
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


	public class ShipmentStateMergePatchedDto : ShipmentStateCreatedOrMergePatchedOrDeletedDto
	{
		public ShipmentStateMergePatchedDto()
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


	public class ShipmentStateDeletedDto : ShipmentStateCreatedOrMergePatchedOrDeletedDto
	{
		public ShipmentStateDeletedDto()
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


    public partial class ShipmentStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IShipmentStateCreated>, IEnumerable<IShipmentStateMergePatched>
    {
        private List<ShipmentStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<ShipmentStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual ShipmentStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<ShipmentStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IShipmentStateCreated> IEnumerable<IShipmentStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IShipmentStateMergePatched> IEnumerable<IShipmentStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }


        public void AddShipmentEvent(IShipmentStateCreated e)
        {
            _innerStateEvents.Add((ShipmentStateCreatedDto)e);
        }

        public void AddShipmentEvent(IShipmentStateEvent e)
        {
            _innerStateEvents.Add((ShipmentStateCreatedOrMergePatchedOrDeletedDto)e);
        }


    }


}

