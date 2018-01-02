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

    public partial class ShipmentReceiptMvoStateDto : IShipmentReceiptMvoStateDto
    {

        public virtual ShipmentReceiptIdDto ShipmentReceiptId
        {
            get;
            set;
        }

        public virtual string ProductId
        {
            get;
            set;
        }

        public virtual string ShipmentItemSeqId
        {
            get;
            set;
        }

        public virtual string RejectionReasonId
        {
            get;
            set;
        }

        public virtual string DamageStatusId
        {
            get;
            set;
        }

        public virtual string DamageReasonId
        {
            get;
            set;
        }

        public virtual string ItemDescription
        {
            get;
            set;
        }

        public virtual decimal? AcceptedQuantity
        {
            get;
            set;
        }

        public virtual decimal? RejectedQuantity
        {
            get;
            set;
        }

        public virtual decimal? DamagedQuantity
        {
            get;
            set;
        }

        public virtual long? Version
        {
            get;
            set;
        }

        public virtual bool? Active
        {
            get;
            set;
        }

        public virtual string ShipmentShipmentTypeId
        {
            get;
            set;
        }

        public virtual string ShipmentStatusId
        {
            get;
            set;
        }

        public virtual string ShipmentPrimaryOrderId
        {
            get;
            set;
        }

        public virtual string ShipmentPrimaryReturnId
        {
            get;
            set;
        }

        public virtual string ShipmentPicklistBinId
        {
            get;
            set;
        }

        public virtual DateTime? ShipmentEstimatedReadyDate
        {
            get;
            set;
        }

        public virtual DateTime? ShipmentEstimatedShipDate
        {
            get;
            set;
        }

        public virtual string ShipmentEstimatedShipWorkEffId
        {
            get;
            set;
        }

        public virtual DateTime? ShipmentEstimatedArrivalDate
        {
            get;
            set;
        }

        public virtual string ShipmentEstimatedArrivalWorkEffId
        {
            get;
            set;
        }

        public virtual DateTime? ShipmentLatestCancelDate
        {
            get;
            set;
        }

        public virtual decimal? ShipmentEstimatedShipCost
        {
            get;
            set;
        }

        public virtual string ShipmentCurrencyUomId
        {
            get;
            set;
        }

        public virtual string ShipmentHandlingInstructions
        {
            get;
            set;
        }

        public virtual string ShipmentOriginFacilityId
        {
            get;
            set;
        }

        public virtual string ShipmentDestinationFacilityId
        {
            get;
            set;
        }

        public virtual string ShipmentOriginContactMechId
        {
            get;
            set;
        }

        public virtual string ShipmentOriginTelecomNumberId
        {
            get;
            set;
        }

        public virtual string ShipmentDestinationContactMechId
        {
            get;
            set;
        }

        public virtual string ShipmentDestinationTelecomNumberId
        {
            get;
            set;
        }

        public virtual string ShipmentPartyIdTo
        {
            get;
            set;
        }

        public virtual string ShipmentPartyIdFrom
        {
            get;
            set;
        }

        public virtual decimal? ShipmentAdditionalShippingCharge
        {
            get;
            set;
        }

        public virtual string ShipmentAddtlShippingChargeDesc
        {
            get;
            set;
        }

        public virtual string ShipmentCreatedBy
        {
            get;
            set;
        }

        public virtual DateTime? ShipmentCreatedAt
        {
            get;
            set;
        }

        public virtual string ShipmentUpdatedBy
        {
            get;
            set;
        }

        public virtual DateTime? ShipmentUpdatedAt
        {
            get;
            set;
        }

        public virtual bool? ShipmentActive
        {
            get;
            set;
        }

        public virtual long? ShipmentVersion
        {
            get;
            set;
        }

        public virtual string CreatedBy
        {
            get;
            set;
        }

        public virtual DateTime? CreatedAt
        {
            get;
            set;
        }

        public virtual string UpdatedBy
        {
            get;
            set;
        }

        public virtual DateTime? UpdatedAt
        {
            get;
            set;
        }

        public virtual IShipmentReceiptMvoState ToShipmentReceiptMvoState()
        {
            var state = new ShipmentReceiptMvoState(true);
            state.ShipmentReceiptId = (this.ShipmentReceiptId == null) ? null : this.ShipmentReceiptId.ToShipmentReceiptId();
            state.ProductId = this.ProductId;
            state.ShipmentItemSeqId = this.ShipmentItemSeqId;
            state.RejectionReasonId = this.RejectionReasonId;
            state.DamageStatusId = this.DamageStatusId;
            state.DamageReasonId = this.DamageReasonId;
            state.ItemDescription = this.ItemDescription;
            state.AcceptedQuantity = this.AcceptedQuantity;
            state.RejectedQuantity = this.RejectedQuantity;
            state.DamagedQuantity = this.DamagedQuantity;
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            state.ShipmentShipmentTypeId = this.ShipmentShipmentTypeId;
            state.ShipmentStatusId = this.ShipmentStatusId;
            state.ShipmentPrimaryOrderId = this.ShipmentPrimaryOrderId;
            state.ShipmentPrimaryReturnId = this.ShipmentPrimaryReturnId;
            state.ShipmentPicklistBinId = this.ShipmentPicklistBinId;
            state.ShipmentEstimatedReadyDate = this.ShipmentEstimatedReadyDate;
            state.ShipmentEstimatedShipDate = this.ShipmentEstimatedShipDate;
            state.ShipmentEstimatedShipWorkEffId = this.ShipmentEstimatedShipWorkEffId;
            state.ShipmentEstimatedArrivalDate = this.ShipmentEstimatedArrivalDate;
            state.ShipmentEstimatedArrivalWorkEffId = this.ShipmentEstimatedArrivalWorkEffId;
            state.ShipmentLatestCancelDate = this.ShipmentLatestCancelDate;
            state.ShipmentEstimatedShipCost = this.ShipmentEstimatedShipCost;
            state.ShipmentCurrencyUomId = this.ShipmentCurrencyUomId;
            state.ShipmentHandlingInstructions = this.ShipmentHandlingInstructions;
            state.ShipmentOriginFacilityId = this.ShipmentOriginFacilityId;
            state.ShipmentDestinationFacilityId = this.ShipmentDestinationFacilityId;
            state.ShipmentOriginContactMechId = this.ShipmentOriginContactMechId;
            state.ShipmentOriginTelecomNumberId = this.ShipmentOriginTelecomNumberId;
            state.ShipmentDestinationContactMechId = this.ShipmentDestinationContactMechId;
            state.ShipmentDestinationTelecomNumberId = this.ShipmentDestinationTelecomNumberId;
            state.ShipmentPartyIdTo = this.ShipmentPartyIdTo;
            state.ShipmentPartyIdFrom = this.ShipmentPartyIdFrom;
            state.ShipmentAdditionalShippingCharge = this.ShipmentAdditionalShippingCharge;
            state.ShipmentAddtlShippingChargeDesc = this.ShipmentAddtlShippingChargeDesc;
            state.ShipmentCreatedBy = this.ShipmentCreatedBy;
            if (this.ShipmentCreatedAt != null && this.ShipmentCreatedAt.HasValue) { state.ShipmentCreatedAt = this.ShipmentCreatedAt.Value; }
            state.ShipmentUpdatedBy = this.ShipmentUpdatedBy;
            if (this.ShipmentUpdatedAt != null && this.ShipmentUpdatedAt.HasValue) { state.ShipmentUpdatedAt = this.ShipmentUpdatedAt.Value; }
            if (this.ShipmentActive != null && this.ShipmentActive.HasValue) { state.ShipmentActive = this.ShipmentActive.Value; }
            if (this.ShipmentVersion != null && this.ShipmentVersion.HasValue) { state.ShipmentVersion = this.ShipmentVersion.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }

            return state;
        }

    }

}

