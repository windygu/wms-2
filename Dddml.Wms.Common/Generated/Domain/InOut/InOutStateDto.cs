﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;

namespace Dddml.Wms.Domain.InOut
{

    public partial class InOutStateDto : IInOutStateDto
    {
        public virtual string DocumentNumber
        {
            get;
            set;
        }

        public virtual string DocumentStatusId
        {
            get;
            set;
        }

        public virtual bool? Posted
        {
            get;
            set;
        }

        public virtual bool? Processed
        {
            get;
            set;
        }

        public virtual string Processing
        {
            get;
            set;
        }

        public virtual string DocumentTypeId
        {
            get;
            set;
        }

        public virtual string Description
        {
            get;
            set;
        }

        public virtual string OrderId
        {
            get;
            set;
        }

        public virtual DateTime? DateOrdered
        {
            get;
            set;
        }

        public virtual bool? IsPrinted
        {
            get;
            set;
        }

        public virtual string MovementTypeId
        {
            get;
            set;
        }

        public virtual DateTime? MovementDate
        {
            get;
            set;
        }

        public virtual string BusinessPartnerId
        {
            get;
            set;
        }

        public virtual string WarehouseId
        {
            get;
            set;
        }

        public virtual string POReference
        {
            get;
            set;
        }

        public virtual decimal? FreightAmount
        {
            get;
            set;
        }

        public virtual string ShipperId
        {
            get;
            set;
        }

        public virtual decimal? ChargeAmount
        {
            get;
            set;
        }

        public virtual DateTime? DatePrinted
        {
            get;
            set;
        }

        public virtual string CreatedFrom
        {
            get;
            set;
        }

        public virtual string SalesRepresentativeId
        {
            get;
            set;
        }

        public virtual int? NumberOfPackages
        {
            get;
            set;
        }

        public virtual DateTime? PickDate
        {
            get;
            set;
        }

        public virtual DateTime? ShipDate
        {
            get;
            set;
        }

        public virtual string TrackingNumber
        {
            get;
            set;
        }

        public virtual DateTime? DateReceived
        {
            get;
            set;
        }

        public virtual bool? IsInTransit
        {
            get;
            set;
        }

        public virtual bool? IsApproved
        {
            get;
            set;
        }

        public virtual bool? IsInDispute
        {
            get;
            set;
        }

        public virtual string RmaDocumentNumber
        {
            get;
            set;
        }

        public virtual string ReversalDocumentNumber
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

        public virtual InOutLineStateDto[] InOutLines
        {
            get;
            set;
        }

        IInOutLineStateDto[] IInOutStateDto.InOutLines
        {
            get { return this.InOutLines; }
            set { this.InOutLines = value.Select(e => ((InOutLineStateDto)e)).ToArray(); }
        }

        public virtual IInOutState ToInOutState()
        {
            var state = new InOutState(true);
            state.DocumentNumber = this.DocumentNumber;
            state.DocumentStatusId = this.DocumentStatusId;
            if (this.Posted != null && this.Posted.HasValue) { state.Posted = this.Posted.Value; }
            if (this.Processed != null && this.Processed.HasValue) { state.Processed = this.Processed.Value; }
            state.Processing = this.Processing;
            state.DocumentTypeId = this.DocumentTypeId;
            state.Description = this.Description;
            state.OrderId = this.OrderId;
            state.DateOrdered = this.DateOrdered;
            if (this.IsPrinted != null && this.IsPrinted.HasValue) { state.IsPrinted = this.IsPrinted.Value; }
            state.MovementTypeId = this.MovementTypeId;
            state.MovementDate = this.MovementDate;
            state.BusinessPartnerId = this.BusinessPartnerId;
            state.WarehouseId = this.WarehouseId;
            state.POReference = this.POReference;
            if (this.FreightAmount != null && this.FreightAmount.HasValue) { state.FreightAmount = this.FreightAmount.Value; }
            state.ShipperId = this.ShipperId;
            if (this.ChargeAmount != null && this.ChargeAmount.HasValue) { state.ChargeAmount = this.ChargeAmount.Value; }
            state.DatePrinted = this.DatePrinted;
            state.CreatedFrom = this.CreatedFrom;
            state.SalesRepresentativeId = this.SalesRepresentativeId;
            if (this.NumberOfPackages != null && this.NumberOfPackages.HasValue) { state.NumberOfPackages = this.NumberOfPackages.Value; }
            state.PickDate = this.PickDate;
            state.ShipDate = this.ShipDate;
            state.TrackingNumber = this.TrackingNumber;
            state.DateReceived = this.DateReceived;
            if (this.IsInTransit != null && this.IsInTransit.HasValue) { state.IsInTransit = this.IsInTransit.Value; }
            if (this.IsApproved != null && this.IsApproved.HasValue) { state.IsApproved = this.IsApproved.Value; }
            if (this.IsInDispute != null && this.IsInDispute.HasValue) { state.IsInDispute = this.IsInDispute.Value; }
            state.RmaDocumentNumber = this.RmaDocumentNumber;
            state.ReversalDocumentNumber = this.ReversalDocumentNumber;
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }
            if (this.InOutLines != null) { foreach (var s in this.InOutLines) { state.InOutLines.AddToSave(s.ToInOutLineState()); } };

            return state;
        }

    }

}

