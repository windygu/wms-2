﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{

    public partial class PhysicalInventoryLineStateDto : IPhysicalInventoryLineStateDto
    {
        public virtual InventoryItemId InventoryItemId
        {
            get;
            set;
        }

        public virtual decimal? BookQuantity
        {
            get;
            set;
        }

        public virtual decimal? CountedQuantity
        {
            get;
            set;
        }

        public virtual bool? Processed
        {
            get;
            set;
        }

        public virtual string LineNumber
        {
            get;
            set;
        }

        public virtual string ReversalLineNumber
        {
            get;
            set;
        }

        public virtual string Description
        {
            get;
            set;
        }

        public virtual long? Version
        {
            get;
            set;
        }

        public virtual string PhysicalInventoryDocumentNumber
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

        public virtual IPhysicalInventoryLineState ToPhysicalInventoryLineState()
        {
            var state = new PhysicalInventoryLineState(true);
            state.InventoryItemId = this.InventoryItemId;
            if (this.BookQuantity != null && this.BookQuantity.HasValue) { state.BookQuantity = this.BookQuantity.Value; }
            if (this.CountedQuantity != null && this.CountedQuantity.HasValue) { state.CountedQuantity = this.CountedQuantity.Value; }
            if (this.Processed != null && this.Processed.HasValue) { state.Processed = this.Processed.Value; }
            state.LineNumber = this.LineNumber;
            state.ReversalLineNumber = this.ReversalLineNumber;
            state.Description = this.Description;
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.PhysicalInventoryDocumentNumber = this.PhysicalInventoryDocumentNumber;
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }

            return state;
        }

    }

}

