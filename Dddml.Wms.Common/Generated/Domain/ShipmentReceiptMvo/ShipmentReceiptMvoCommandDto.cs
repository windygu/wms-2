﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentReceiptMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentReceiptMvo;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.ShipmentReceiptMvo
{

	public abstract class ShipmentReceiptMvoCommandDtoBase : ICommandDto, ICreateShipmentReceiptMvo, IMergePatchShipmentReceiptMvo, IDeleteShipmentReceiptMvo
	{

		ShipmentReceiptId IAggregateCommand<ShipmentReceiptId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteShipmentReceiptMvo)this).ShipmentReceiptId;
			}
		}


		long IAggregateCommand<ShipmentReceiptId, long>.AggregateVersion
		{
			get
			{
				return this.ShipmentVersion != null ? this.ShipmentVersion.Value : default(long);
			}
		}

        long IShipmentReceiptMvoCommand.ShipmentVersion
        {
            get { return this.ShipmentVersion != null ? this.ShipmentVersion.Value : default(long); }
            set { this.ShipmentVersion = value; }
        }

		public virtual long? ShipmentVersion { get; set; }

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

		public virtual ShipmentReceiptId ShipmentReceiptId { get; set; }

		public virtual string ProductId { get; set; }

		public virtual string AttributeSetInstanceId { get; set; }

		public virtual string LocatorId { get; set; }

		public virtual string ShipmentItemSeqId { get; set; }

		public virtual string ShipmentPackageSeqId { get; set; }

		public virtual string OrderId { get; set; }

		public virtual string OrderItemSeqId { get; set; }

		public virtual string ReturnId { get; set; }

		public virtual string ReturnItemSeqId { get; set; }

		public virtual string RejectionReasonId { get; set; }

		public virtual string DamageStatusId { get; set; }

		public virtual string DamageReasonId { get; set; }

		public virtual string ReceivedBy { get; set; }

		public virtual DateTime? DatetimeReceived { get; set; }

		public virtual string ItemDescription { get; set; }

		public virtual decimal? AcceptedQuantity { get; set; }

		public virtual decimal? RejectedQuantity { get; set; }

		public virtual decimal? DamagedQuantity { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string ShipmentShipmentTypeId { get; set; }

		public virtual string ShipmentStatusId { get; set; }

		public virtual string ShipmentPrimaryOrderId { get; set; }

		public virtual string ShipmentPrimaryReturnId { get; set; }

		public virtual long? ShipmentPrimaryShipGroupSeqId { get; set; }

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

		public virtual bool? IsPropertyProductIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyProductIdRemoved
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

		public virtual bool? IsPropertyAttributeSetInstanceIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyAttributeSetInstanceIdRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeSetInstanceIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeSetInstanceIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyLocatorIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyLocatorIdRemoved
        {
            get
            {
                var b = this.IsPropertyLocatorIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyLocatorIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentItemSeqIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentItemSeqIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentItemSeqIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentItemSeqIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPackageSeqIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPackageSeqIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPackageSeqIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPackageSeqIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyOrderIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyOrderIdRemoved
        {
            get
            {
                var b = this.IsPropertyOrderIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOrderIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyOrderItemSeqIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyOrderItemSeqIdRemoved
        {
            get
            {
                var b = this.IsPropertyOrderItemSeqIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOrderItemSeqIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyReturnIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyReturnIdRemoved
        {
            get
            {
                var b = this.IsPropertyReturnIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReturnIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyReturnItemSeqIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyReturnItemSeqIdRemoved
        {
            get
            {
                var b = this.IsPropertyReturnItemSeqIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReturnItemSeqIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyRejectionReasonIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyRejectionReasonIdRemoved
        {
            get
            {
                var b = this.IsPropertyRejectionReasonIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyRejectionReasonIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDamageStatusIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyDamageStatusIdRemoved
        {
            get
            {
                var b = this.IsPropertyDamageStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDamageStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDamageReasonIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyDamageReasonIdRemoved
        {
            get
            {
                var b = this.IsPropertyDamageReasonIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDamageReasonIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyReceivedByRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyReceivedByRemoved
        {
            get
            {
                var b = this.IsPropertyReceivedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReceivedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyDatetimeReceivedRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyDatetimeReceivedRemoved
        {
            get
            {
                var b = this.IsPropertyDatetimeReceivedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDatetimeReceivedRemoved = value;
            }
        }

		public virtual bool? IsPropertyItemDescriptionRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyItemDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyItemDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyItemDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyAcceptedQuantityRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyAcceptedQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyAcceptedQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAcceptedQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyRejectedQuantityRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyRejectedQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyRejectedQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyRejectedQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyDamagedQuantityRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyDamagedQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyDamagedQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDamagedQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyVersionRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyActiveRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentShipmentTypeIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentStatusIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPrimaryOrderIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPrimaryReturnIdRemoved
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

		public virtual bool? IsPropertyShipmentPrimaryShipGroupSeqIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPrimaryShipGroupSeqIdRemoved
        {
            get
            {
                var b = this.IsPropertyShipmentPrimaryShipGroupSeqIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShipmentPrimaryShipGroupSeqIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShipmentPicklistBinIdRemoved { get; set; }

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPicklistBinIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentEstimatedReadyDateRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentEstimatedShipDateRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentEstimatedShipWorkEffIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentEstimatedArrivalDateRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentEstimatedArrivalWorkEffIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentLatestCancelDateRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentEstimatedShipCostRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentCurrencyUomIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentHandlingInstructionsRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentOriginFacilityIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentDestinationFacilityIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentOriginContactMechIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentOriginTelecomNumberIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentDestinationContactMechIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentDestinationTelecomNumberIdRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPartyIdToRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentPartyIdFromRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentAdditionalShippingChargeRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentAddtlShippingChargeDescRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentCreatedByRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentCreatedAtRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentUpdatedByRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentUpdatedAtRemoved
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

        bool IMergePatchShipmentReceiptMvo.IsPropertyShipmentActiveRemoved
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


    public class CreateOrMergePatchOrDeleteShipmentReceiptMvoDto : ShipmentReceiptMvoCommandDtoBase
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



	public class CreateShipmentReceiptMvoDto : CreateOrMergePatchOrDeleteShipmentReceiptMvoDto
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


	public class MergePatchShipmentReceiptMvoDto : CreateOrMergePatchOrDeleteShipmentReceiptMvoDto
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

	public class DeleteShipmentReceiptMvoDto : CreateOrMergePatchOrDeleteShipmentReceiptMvoDto
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

    public static partial class ShipmentReceiptMvoCommandDtos
    {

    }

}

