﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

    public partial class ShipmentStateDto : IShipmentStateDto
    {
        public virtual string ShipmentId
        {
            get;
            set;
        }

        public virtual string ShipmentTypeId
        {
            get;
            set;
        }

        public virtual string StatusId
        {
            get;
            set;
        }

        public virtual string PrimaryOrderId
        {
            get;
            set;
        }

        public virtual string PrimaryReturnId
        {
            get;
            set;
        }

        public virtual string PrimaryShipGroupSeqId
        {
            get;
            set;
        }

        public virtual bool? OnlyOneOrder
        {
            get;
            set;
        }

        public virtual bool? OnlyOneOrderShipGroup
        {
            get;
            set;
        }

        public virtual string PicklistBinId
        {
            get;
            set;
        }

        public virtual string BolNumber
        {
            get;
            set;
        }

        public virtual string SealNumber
        {
            get;
            set;
        }

        public virtual string VehicleId
        {
            get;
            set;
        }

        public virtual string ExternalOrderNumber
        {
            get;
            set;
        }

        public virtual string Carrier
        {
            get;
            set;
        }

        public virtual DateTime? DateShipped
        {
            get;
            set;
        }

        public virtual bool? IsCreatedFromPackingList
        {
            get;
            set;
        }

        public virtual bool? IsScheduleNeeded
        {
            get;
            set;
        }

        public virtual DateTime? EstimatedReadyDate
        {
            get;
            set;
        }

        public virtual DateTime? EstimatedShipDate
        {
            get;
            set;
        }

        public virtual string EstimatedShipWorkEffId
        {
            get;
            set;
        }

        public virtual DateTime? EstimatedArrivalDate
        {
            get;
            set;
        }

        public virtual string EstimatedArrivalWorkEffId
        {
            get;
            set;
        }

        public virtual DateTime? LatestCancelDate
        {
            get;
            set;
        }

        public virtual decimal? EstimatedShipCost
        {
            get;
            set;
        }

        public virtual string CurrencyUomId
        {
            get;
            set;
        }

        public virtual string HandlingInstructions
        {
            get;
            set;
        }

        public virtual string OriginFacilityId
        {
            get;
            set;
        }

        public virtual string DestinationFacilityId
        {
            get;
            set;
        }

        public virtual string OriginContactMechId
        {
            get;
            set;
        }

        public virtual string OriginTelecomNumberId
        {
            get;
            set;
        }

        public virtual string DestinationContactMechId
        {
            get;
            set;
        }

        public virtual string DestinationTelecomNumberId
        {
            get;
            set;
        }

        public virtual string PartyIdTo
        {
            get;
            set;
        }

        public virtual string PartyIdFrom
        {
            get;
            set;
        }

        public virtual decimal? AdditionalShippingCharge
        {
            get;
            set;
        }

        public virtual string AddtlShippingChargeDesc
        {
            get;
            set;
        }

        public virtual bool? Active
        {
            get;
            set;
        }

        public virtual long? Version
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

        public virtual ShipmentImageStateDto[] ShipmentImages
        {
            get;
            set;
        }

        IShipmentImageStateDto[] IShipmentStateDto.ShipmentImages
        {
            get { return this.ShipmentImages; }
            set { this.ShipmentImages = value.Select(e => ((ShipmentImageStateDto)e)).ToArray(); }
        }

        public virtual ShipmentItemStateDto[] ShipmentItems
        {
            get;
            set;
        }

        IShipmentItemStateDto[] IShipmentStateDto.ShipmentItems
        {
            get { return this.ShipmentItems; }
            set { this.ShipmentItems = value.Select(e => ((ShipmentItemStateDto)e)).ToArray(); }
        }

        public virtual ShipmentReceiptStateDto[] ShipmentReceipts
        {
            get;
            set;
        }

        IShipmentReceiptStateDto[] IShipmentStateDto.ShipmentReceipts
        {
            get { return this.ShipmentReceipts; }
            set { this.ShipmentReceipts = value.Select(e => ((ShipmentReceiptStateDto)e)).ToArray(); }
        }

        public virtual ItemIssuanceStateDto[] ItemIssuances
        {
            get;
            set;
        }

        IItemIssuanceStateDto[] IShipmentStateDto.ItemIssuances
        {
            get { return this.ItemIssuances; }
            set { this.ItemIssuances = value.Select(e => ((ItemIssuanceStateDto)e)).ToArray(); }
        }

        public virtual IShipmentState ToShipmentState()
        {
            var state = new ShipmentState(true);
            state.ShipmentId = this.ShipmentId;
            state.ShipmentTypeId = this.ShipmentTypeId;
            state.StatusId = this.StatusId;
            state.PrimaryOrderId = this.PrimaryOrderId;
            state.PrimaryReturnId = this.PrimaryReturnId;
            state.PrimaryShipGroupSeqId = this.PrimaryShipGroupSeqId;
            if (this.OnlyOneOrder != null && this.OnlyOneOrder.HasValue) { state.OnlyOneOrder = this.OnlyOneOrder.Value; }
            if (this.OnlyOneOrderShipGroup != null && this.OnlyOneOrderShipGroup.HasValue) { state.OnlyOneOrderShipGroup = this.OnlyOneOrderShipGroup.Value; }
            state.PicklistBinId = this.PicklistBinId;
            state.BolNumber = this.BolNumber;
            state.SealNumber = this.SealNumber;
            state.VehicleId = this.VehicleId;
            state.ExternalOrderNumber = this.ExternalOrderNumber;
            state.Carrier = this.Carrier;
            state.DateShipped = this.DateShipped;
            if (this.IsCreatedFromPackingList != null && this.IsCreatedFromPackingList.HasValue) { state.IsCreatedFromPackingList = this.IsCreatedFromPackingList.Value; }
            if (this.IsScheduleNeeded != null && this.IsScheduleNeeded.HasValue) { state.IsScheduleNeeded = this.IsScheduleNeeded.Value; }
            state.EstimatedReadyDate = this.EstimatedReadyDate;
            state.EstimatedShipDate = this.EstimatedShipDate;
            state.EstimatedShipWorkEffId = this.EstimatedShipWorkEffId;
            state.EstimatedArrivalDate = this.EstimatedArrivalDate;
            state.EstimatedArrivalWorkEffId = this.EstimatedArrivalWorkEffId;
            state.LatestCancelDate = this.LatestCancelDate;
            state.EstimatedShipCost = this.EstimatedShipCost;
            state.CurrencyUomId = this.CurrencyUomId;
            state.HandlingInstructions = this.HandlingInstructions;
            state.OriginFacilityId = this.OriginFacilityId;
            state.DestinationFacilityId = this.DestinationFacilityId;
            state.OriginContactMechId = this.OriginContactMechId;
            state.OriginTelecomNumberId = this.OriginTelecomNumberId;
            state.DestinationContactMechId = this.DestinationContactMechId;
            state.DestinationTelecomNumberId = this.DestinationTelecomNumberId;
            state.PartyIdTo = this.PartyIdTo;
            state.PartyIdFrom = this.PartyIdFrom;
            state.AdditionalShippingCharge = this.AdditionalShippingCharge;
            state.AddtlShippingChargeDesc = this.AddtlShippingChargeDesc;
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }
            if (this.ShipmentImages != null) { foreach (var s in this.ShipmentImages) { state.ShipmentImages.AddToSave(s.ToShipmentImageState()); } };
            if (this.ShipmentItems != null) { foreach (var s in this.ShipmentItems) { state.ShipmentItems.AddToSave(s.ToShipmentItemState()); } };
            if (this.ShipmentReceipts != null) { foreach (var s in this.ShipmentReceipts) { state.ShipmentReceipts.AddToSave(s.ToShipmentReceiptState()); } };
            if (this.ItemIssuances != null) { foreach (var s in this.ItemIssuances) { state.ItemIssuances.AddToSave(s.ToItemIssuanceState()); } };

            return state;
        }

        public virtual IPurchaseShipmentState ToPurchaseShipmentState()
        {
            var state = new PurchaseShipmentState(true);
            state.ShipmentId = this.ShipmentId;
            state.ShipmentTypeId = this.ShipmentTypeId;
            state.StatusId = this.StatusId;
            state.PrimaryOrderId = this.PrimaryOrderId;
            state.PrimaryReturnId = this.PrimaryReturnId;
            state.PrimaryShipGroupSeqId = this.PrimaryShipGroupSeqId;
            if (this.OnlyOneOrder != null && this.OnlyOneOrder.HasValue) { state.OnlyOneOrder = this.OnlyOneOrder.Value; }
            if (this.OnlyOneOrderShipGroup != null && this.OnlyOneOrderShipGroup.HasValue) { state.OnlyOneOrderShipGroup = this.OnlyOneOrderShipGroup.Value; }
            state.PicklistBinId = this.PicklistBinId;
            state.BolNumber = this.BolNumber;
            state.SealNumber = this.SealNumber;
            state.VehicleId = this.VehicleId;
            state.ExternalOrderNumber = this.ExternalOrderNumber;
            state.Carrier = this.Carrier;
            state.DateShipped = this.DateShipped;
            if (this.IsCreatedFromPackingList != null && this.IsCreatedFromPackingList.HasValue) { state.IsCreatedFromPackingList = this.IsCreatedFromPackingList.Value; }
            if (this.IsScheduleNeeded != null && this.IsScheduleNeeded.HasValue) { state.IsScheduleNeeded = this.IsScheduleNeeded.Value; }
            state.EstimatedReadyDate = this.EstimatedReadyDate;
            state.EstimatedShipDate = this.EstimatedShipDate;
            state.EstimatedShipWorkEffId = this.EstimatedShipWorkEffId;
            state.EstimatedArrivalDate = this.EstimatedArrivalDate;
            state.EstimatedArrivalWorkEffId = this.EstimatedArrivalWorkEffId;
            state.LatestCancelDate = this.LatestCancelDate;
            state.EstimatedShipCost = this.EstimatedShipCost;
            state.CurrencyUomId = this.CurrencyUomId;
            state.HandlingInstructions = this.HandlingInstructions;
            state.OriginFacilityId = this.OriginFacilityId;
            state.DestinationFacilityId = this.DestinationFacilityId;
            state.OriginContactMechId = this.OriginContactMechId;
            state.OriginTelecomNumberId = this.OriginTelecomNumberId;
            state.DestinationContactMechId = this.DestinationContactMechId;
            state.DestinationTelecomNumberId = this.DestinationTelecomNumberId;
            state.PartyIdTo = this.PartyIdTo;
            state.PartyIdFrom = this.PartyIdFrom;
            state.AdditionalShippingCharge = this.AdditionalShippingCharge;
            state.AddtlShippingChargeDesc = this.AddtlShippingChargeDesc;
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }
            if (this.ShipmentImages != null) { foreach (var s in this.ShipmentImages) { state.ShipmentImages.AddToSave(s.ToShipmentImageState()); } };
            if (this.ShipmentItems != null) { foreach (var s in this.ShipmentItems) { state.ShipmentItems.AddToSave(s.ToShipmentItemState()); } };
            if (this.ShipmentReceipts != null) { foreach (var s in this.ShipmentReceipts) { state.ShipmentReceipts.AddToSave(s.ToShipmentReceiptState()); } };
            if (this.ItemIssuances != null) { foreach (var s in this.ItemIssuances) { state.ItemIssuances.AddToSave(s.ToItemIssuanceState()); } };

            return state;
        }

        public virtual ISalesShipmentState ToSalesShipmentState()
        {
            var state = new SalesShipmentState(true);
            state.ShipmentId = this.ShipmentId;
            state.ShipmentTypeId = this.ShipmentTypeId;
            state.StatusId = this.StatusId;
            state.PrimaryOrderId = this.PrimaryOrderId;
            state.PrimaryReturnId = this.PrimaryReturnId;
            state.PrimaryShipGroupSeqId = this.PrimaryShipGroupSeqId;
            if (this.OnlyOneOrder != null && this.OnlyOneOrder.HasValue) { state.OnlyOneOrder = this.OnlyOneOrder.Value; }
            if (this.OnlyOneOrderShipGroup != null && this.OnlyOneOrderShipGroup.HasValue) { state.OnlyOneOrderShipGroup = this.OnlyOneOrderShipGroup.Value; }
            state.PicklistBinId = this.PicklistBinId;
            state.BolNumber = this.BolNumber;
            state.SealNumber = this.SealNumber;
            state.VehicleId = this.VehicleId;
            state.ExternalOrderNumber = this.ExternalOrderNumber;
            state.Carrier = this.Carrier;
            state.DateShipped = this.DateShipped;
            if (this.IsCreatedFromPackingList != null && this.IsCreatedFromPackingList.HasValue) { state.IsCreatedFromPackingList = this.IsCreatedFromPackingList.Value; }
            if (this.IsScheduleNeeded != null && this.IsScheduleNeeded.HasValue) { state.IsScheduleNeeded = this.IsScheduleNeeded.Value; }
            state.EstimatedReadyDate = this.EstimatedReadyDate;
            state.EstimatedShipDate = this.EstimatedShipDate;
            state.EstimatedShipWorkEffId = this.EstimatedShipWorkEffId;
            state.EstimatedArrivalDate = this.EstimatedArrivalDate;
            state.EstimatedArrivalWorkEffId = this.EstimatedArrivalWorkEffId;
            state.LatestCancelDate = this.LatestCancelDate;
            state.EstimatedShipCost = this.EstimatedShipCost;
            state.CurrencyUomId = this.CurrencyUomId;
            state.HandlingInstructions = this.HandlingInstructions;
            state.OriginFacilityId = this.OriginFacilityId;
            state.DestinationFacilityId = this.DestinationFacilityId;
            state.OriginContactMechId = this.OriginContactMechId;
            state.OriginTelecomNumberId = this.OriginTelecomNumberId;
            state.DestinationContactMechId = this.DestinationContactMechId;
            state.DestinationTelecomNumberId = this.DestinationTelecomNumberId;
            state.PartyIdTo = this.PartyIdTo;
            state.PartyIdFrom = this.PartyIdFrom;
            state.AdditionalShippingCharge = this.AdditionalShippingCharge;
            state.AddtlShippingChargeDesc = this.AddtlShippingChargeDesc;
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }
            if (this.ShipmentImages != null) { foreach (var s in this.ShipmentImages) { state.ShipmentImages.AddToSave(s.ToShipmentImageState()); } };
            if (this.ShipmentItems != null) { foreach (var s in this.ShipmentItems) { state.ShipmentItems.AddToSave(s.ToShipmentItemState()); } };
            if (this.ShipmentReceipts != null) { foreach (var s in this.ShipmentReceipts) { state.ShipmentReceipts.AddToSave(s.ToShipmentReceiptState()); } };
            if (this.ItemIssuances != null) { foreach (var s in this.ItemIssuances) { state.ItemIssuances.AddToSave(s.ToItemIssuanceState()); } };

            return state;
        }

    }

}

