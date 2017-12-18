﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentItemMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentItemMvo;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.ShipmentItemMvo
{

	public abstract class ShipmentItemMvoCommandDtoBase : ICommandDto, ICreateShipmentItemMvo, IMergePatchShipmentItemMvo, IDeleteShipmentItemMvo
	{

		ShipmentItemId IAggregateCommand<ShipmentItemId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteShipmentItemMvo)this).ShipmentItemId;
			}
		}


		long IAggregateCommand<ShipmentItemId, long>.AggregateVersion
		{
			get
			{
				return this.ShipmentVersion;
			}
		}

		public virtual long ShipmentVersion { get; set; }

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

		public virtual ShipmentItemIdDto ShipmentItemId { get; set; }

		public virtual string ProductId { get; set; }

		public virtual decimal? Quantity { get; set; }

		public virtual string ShipmentContentDescription { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string ShipmentShipmentTypeId { get; set; }

		public virtual string ShipmentStatusId { get; set; }

		public virtual string ShipmentPrimaryOrderId { get; set; }

		public virtual string ShipmentPrimaryReturnId { get; set; }

		public virtual string ShipmentPicklistBinId { get; set; }

		public virtual DateTime? ShipmentEstimatedReadyDate { get; set; }

		public virtual DateTime? ShipmentEstimatedShipDate { get; set; }

		public virtual string ShipmentEstimatedShipWorkEffId { get; set; }

		public virtual DateTime? ShipmentEstimatedArrivalDate { get; set; }

		public virtual string ShipmentEstimatedArrivalWorkEffId { get; set; }

		public virtual DateTime? ShipmentLatestCancelDate { get; set; }

		public virtual decimal? ShipmentEstimatedShipCost { get; set; }

		public virtual string ShipmentCurrencyUomId { get; set; }

		public virtual string ShipmentHandlingInstructions { get; set; }

		public virtual string ShipmentOriginFacilityId { get; set; }

		public virtual string ShipmentDestinationFacilityId { get; set; }

		public virtual string ShipmentOriginContactMechId { get; set; }

		public virtual string ShipmentOriginTelecomNumberId { get; set; }

		public virtual string ShipmentDestinationContactMechId { get; set; }

		public virtual string ShipmentDestinationTelecomNumberId { get; set; }

		public virtual string ShipmentPartyIdTo { get; set; }

		public virtual string ShipmentPartyIdFrom { get; set; }

		public virtual decimal? ShipmentAdditionalShippingCharge { get; set; }

		public virtual string ShipmentAddtlShippingChargeDesc { get; set; }

		public virtual string ShipmentCreatedBy { get; set; }

		public virtual DateTime? ShipmentCreatedAt { get; set; }

		public virtual string ShipmentUpdatedBy { get; set; }

		public virtual DateTime? ShipmentUpdatedAt { get; set; }

		public virtual bool? ShipmentActive { get; set; }


        ShipmentItemId IShipmentItemMvoCommand.ShipmentItemId
        {
            get 
            {
                return this.ShipmentItemId.ToShipmentItemId();
            }
            set 
            {
                this.ShipmentItemId = new ShipmentItemIdDtoWrapper(value);
            }
        }

		public virtual bool? IsPropertyProductIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyProductIdRemoved
        {
            get
            {
                var b = this.IsPropertyProductIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentContentDescriptionRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentContentDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentContentDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentContentDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyVersionRemoved
        {
            get
            {
                var b = this.IsPropertyVersionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVersionRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyActiveRemoved
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

		public virtual bool? IsPropertyShipmentShipmentTypeIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentShipmentTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentShipmentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentShipmentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentStatusIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentStatusIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPrimaryOrderIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentPrimaryOrderIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPrimaryOrderIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPrimaryOrderIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPrimaryReturnIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentPrimaryReturnIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPrimaryReturnIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPrimaryReturnIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPicklistBinIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentPicklistBinIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPicklistBinIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPicklistBinIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentEstimatedReadyDateRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentEstimatedReadyDateRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentEstimatedReadyDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentEstimatedReadyDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentEstimatedShipDateRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentEstimatedShipDateRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentEstimatedShipDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentEstimatedShipDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentEstimatedShipWorkEffIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentEstimatedShipWorkEffIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentEstimatedShipWorkEffIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentEstimatedShipWorkEffIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentEstimatedArrivalDateRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentEstimatedArrivalDateRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentEstimatedArrivalDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentEstimatedArrivalDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentEstimatedArrivalWorkEffIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentEstimatedArrivalWorkEffIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentEstimatedArrivalWorkEffIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentEstimatedArrivalWorkEffIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentLatestCancelDateRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentLatestCancelDateRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentLatestCancelDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentLatestCancelDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentEstimatedShipCostRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentEstimatedShipCostRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentEstimatedShipCostRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentEstimatedShipCostRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentCurrencyUomIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentCurrencyUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentCurrencyUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentCurrencyUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentHandlingInstructionsRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentHandlingInstructionsRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentHandlingInstructionsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentHandlingInstructionsRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentOriginFacilityIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentOriginFacilityIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentOriginFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentOriginFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentDestinationFacilityIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentDestinationFacilityIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentDestinationFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentDestinationFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentOriginContactMechIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentOriginContactMechIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentOriginContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentOriginContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentOriginTelecomNumberIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentOriginTelecomNumberIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentOriginTelecomNumberIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentOriginTelecomNumberIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentDestinationContactMechIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentDestinationContactMechIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentDestinationContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentDestinationContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentDestinationTelecomNumberIdRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentDestinationTelecomNumberIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentDestinationTelecomNumberIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentDestinationTelecomNumberIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPartyIdToRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentPartyIdToRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPartyIdToRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPartyIdToRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPartyIdFromRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentPartyIdFromRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPartyIdFromRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPartyIdFromRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentAdditionalShippingChargeRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentAdditionalShippingChargeRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentAdditionalShippingChargeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentAdditionalShippingChargeRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentAddtlShippingChargeDescRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentAddtlShippingChargeDescRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentAddtlShippingChargeDescRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentAddtlShippingChargeDescRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentCreatedByRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentCreatedByRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentCreatedAtRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentCreatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentUpdatedByRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentUpdatedByRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentUpdatedAtRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentUpdatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentUpdatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentActiveRemoved { get; set; }

        bool IMergePatchShipmentItemMvo.IsPropertyShipmentActiveRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentActiveRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteShipmentItemMvoDto : ShipmentItemMvoCommandDtoBase
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



	public class CreateShipmentItemMvoDto : CreateOrMergePatchOrDeleteShipmentItemMvoDto
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


	public class MergePatchShipmentItemMvoDto : CreateOrMergePatchOrDeleteShipmentItemMvoDto
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

	public class DeleteShipmentItemMvoDto : CreateOrMergePatchOrDeleteShipmentItemMvoDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class ShipmentItemMvoCommandDtos
    {

    }

}

