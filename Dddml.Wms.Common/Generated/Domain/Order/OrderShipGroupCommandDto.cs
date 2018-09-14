﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{

	public abstract class OrderShipGroupCommandDtoBase : ICommandDto, ICreateOrderShipGroup, IMergePatchOrderShipGroup, IRemoveOrderShipGroup
	{

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual string ShipGroupSeqId { get; set; }

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

		public virtual string MaySplit { get; set; }

		public virtual string GiftMessage { get; set; }

		public virtual string IsGift { get; set; }

		public virtual DateTime? ShipAfterDate { get; set; }

		public virtual DateTime? ShipByDate { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual DateTime? EstimatedDeliveryDate { get; set; }

		public virtual long? PickwaveId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string OrderId { get; set; }

		public virtual bool? IsPropertyShipmentMethodTypeIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyShipmentMethodTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentMethodTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentMethodTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertySupplierPartyIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertySupplierPartyIdRemoved
        {
            get
            {
                var b = this.IsPropertySupplierPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySupplierPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVendorPartyIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyVendorPartyIdRemoved
        {
            get
            {
                var b = this.IsPropertyVendorPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVendorPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyCarrierPartyIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyCarrierPartyIdRemoved
        {
            get
            {
                var b = this.IsPropertyCarrierPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCarrierPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyCarrierRoleTypeIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyCarrierRoleTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyCarrierRoleTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCarrierRoleTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyFacilityIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyFacilityIdRemoved
        {
            get
            {
                var b = this.IsPropertyFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDestinationFacilityIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyDestinationFacilityIdRemoved
        {
            get
            {
                var b = this.IsPropertyDestinationFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDestinationFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyContactMechIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyContactMechIdRemoved
        {
            get
            {
                var b = this.IsPropertyContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyTelecomContactMechIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyTelecomContactMechIdRemoved
        {
            get
            {
                var b = this.IsPropertyTelecomContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTelecomContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyTrackingNumberRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyTrackingNumberRemoved
        {
            get
            {
                var b = this.IsPropertyTrackingNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTrackingNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyMaySplitRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyMaySplitRemoved
        {
            get
            {
                var b = this.IsPropertyMaySplitRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMaySplitRemoved = value;
            }
        }

		public virtual bool? IsPropertyGiftMessageRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyGiftMessageRemoved
        {
            get
            {
                var b = this.IsPropertyGiftMessageRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyGiftMessageRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsGiftRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyIsGiftRemoved
        {
            get
            {
                var b = this.IsPropertyIsGiftRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsGiftRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipAfterDateRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyShipAfterDateRemoved
        {
            get
            {
                var b = this.IsPropertyShipAfterDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipAfterDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipByDateRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyShipByDateRemoved
        {
            get
            {
                var b = this.IsPropertyShipByDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipByDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedShipDateRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyEstimatedShipDateRemoved
        {
            get
            {
                var b = this.IsPropertyEstimatedShipDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyEstimatedShipDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedDeliveryDateRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyEstimatedDeliveryDateRemoved
        {
            get
            {
                var b = this.IsPropertyEstimatedDeliveryDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyEstimatedDeliveryDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyPickwaveIdRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyPickwaveIdRemoved
        {
            get
            {
                var b = this.IsPropertyPickwaveIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPickwaveIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchOrderShipGroup.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }

        ICreateOrderItemShipGroupAssociationCommands ICreateOrderShipGroup.OrderItemShipGroupAssociations
        {
            get
            {
                return this._orderItemShipGroupAssociations;
            }
        }

        IOrderItemShipGroupAssociationCommands IMergePatchOrderShipGroup.OrderItemShipGroupAssociationCommands
        {
            get
            {
                return this._orderItemShipGroupAssociations;
            }
        }

        public virtual CreateOrderItemShipGroupAssociationDto NewCreateOrderItemShipGroupAssociation()
        {
            var c = new CreateOrderItemShipGroupAssociationDto();
            c.OrderId = this.OrderId;

            c.OrderShipGroupShipGroupSeqId = this.ShipGroupSeqId;

            return c;
        }

        ICreateOrderItemShipGroupAssociation ICreateOrderShipGroup.NewCreateOrderItemShipGroupAssociation()
        {
            return this.NewCreateOrderItemShipGroupAssociation();
        }

        ICreateOrderItemShipGroupAssociation IMergePatchOrderShipGroup.NewCreateOrderItemShipGroupAssociation()
        {
            return this.NewCreateOrderItemShipGroupAssociation();
        }

        public virtual MergePatchOrderItemShipGroupAssociationDto NewMergePatchOrderItemShipGroupAssociation()
        {
            var c = new MergePatchOrderItemShipGroupAssociationDto();
            c.OrderId = this.OrderId;

            c.OrderShipGroupShipGroupSeqId = this.ShipGroupSeqId;

            return c;
        }

        IMergePatchOrderItemShipGroupAssociation IMergePatchOrderShipGroup.NewMergePatchOrderItemShipGroupAssociation()
        {
            return this.NewMergePatchOrderItemShipGroupAssociation();
        }

        public virtual RemoveOrderItemShipGroupAssociationDto NewRemoveOrderItemShipGroupAssociation()
        {
            var c = new RemoveOrderItemShipGroupAssociationDto();
            c.OrderId = this.OrderId;

            c.OrderShipGroupShipGroupSeqId = this.ShipGroupSeqId;

            return c;
        }

        IRemoveOrderItemShipGroupAssociation IMergePatchOrderShipGroup.NewRemoveOrderItemShipGroupAssociation()
        {
            return this.NewRemoveOrderItemShipGroupAssociation();
        }

        private CreateOrMergePatchOrRemoveOrderItemShipGroupAssociationDtos _orderItemShipGroupAssociations = new CreateOrMergePatchOrRemoveOrderItemShipGroupAssociationDtos();

        public virtual CreateOrMergePatchOrRemoveOrderItemShipGroupAssociationDto[] OrderItemShipGroupAssociations
        {
            get
            {
                return _orderItemShipGroupAssociations.ToArray();
            }
            set
            {
                _orderItemShipGroupAssociations.Clear();
                _orderItemShipGroupAssociations.AddRange(value);
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrRemoveOrderShipGroupDto : OrderShipGroupCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateOrderShipGroupDto : CreateOrMergePatchOrRemoveOrderShipGroupDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchOrderShipGroupDto : CreateOrMergePatchOrRemoveOrderShipGroupDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemoveOrderShipGroupDto : CreateOrMergePatchOrRemoveOrderShipGroupDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}


    public partial class CreateOrMergePatchOrRemoveOrderShipGroupDtos : IOrderShipGroupCommands, ICreateOrderShipGroupCommands, IEnumerable<CreateOrMergePatchOrRemoveOrderShipGroupDto>
    {
        private List<CreateOrMergePatchOrRemoveOrderShipGroupDto> _innerCommands = new List<CreateOrMergePatchOrRemoveOrderShipGroupDto>();

        public virtual CreateOrMergePatchOrRemoveOrderShipGroupDto[] ToArray()
        {
            return _innerCommands.ToArray();
        }

        public virtual void Clear()
        {
            _innerCommands.Clear();
        }

        public virtual void AddRange(IEnumerable<CreateOrMergePatchOrRemoveOrderShipGroupDto> cs)
        {
            _innerCommands.AddRange(cs);
        }

        void IOrderShipGroupCommands.Add(IOrderShipGroupCommand c)
        {
            _innerCommands.Add((CreateOrMergePatchOrRemoveOrderShipGroupDto)c);
        }

        void IOrderShipGroupCommands.Remove(IOrderShipGroupCommand c)
        {
            _innerCommands.Remove((CreateOrMergePatchOrRemoveOrderShipGroupDto)c);
        }


        IEnumerator<CreateOrMergePatchOrRemoveOrderShipGroupDto> IEnumerable<CreateOrMergePatchOrRemoveOrderShipGroupDto>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        IEnumerator<IOrderShipGroupCommand> IEnumerable<IOrderShipGroupCommand>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        void ICreateOrderShipGroupCommands.Add(ICreateOrderShipGroup c)
        {
            _innerCommands.Add((CreateOrderShipGroupDto)c);
        }

        void ICreateOrderShipGroupCommands.Remove(ICreateOrderShipGroup c)
        {
            _innerCommands.Remove((CreateOrderShipGroupDto)c);
        }

        IEnumerator<ICreateOrderShipGroup> IEnumerable<ICreateOrderShipGroup>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

}

