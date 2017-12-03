﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItem
{

    public partial class SellableInventoryItemStateDto : ISellableInventoryItemStateDto
    {

        public virtual InventoryItemIdDto SellableInventoryItemId
        {
            get;
            set;
        }

        public virtual decimal? QuantitySellable
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

        public virtual SellableInventoryItemEntryStateDto[] Entries
        {
            get;
            set;
        }

        ISellableInventoryItemEntryStateDto[] ISellableInventoryItemStateDto.Entries
        {
            get { return this.Entries; }
            set { this.Entries = value.Select(e => ((SellableInventoryItemEntryStateDto)e)).ToArray(); }
        }

        public virtual ISellableInventoryItemState ToSellableInventoryItemState()
        {
            var state = new SellableInventoryItemState(true);
            state.SellableInventoryItemId = (this.SellableInventoryItemId == null) ? null : this.SellableInventoryItemId.ToInventoryItemId();
            if (this.QuantitySellable != null && this.QuantitySellable.HasValue) { state.QuantitySellable = this.QuantitySellable.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }
            if (this.Entries != null) { foreach (var s in this.Entries) { state.Entries.AddToSave(s.ToSellableInventoryItemEntryState()); } };

            return state;
        }

    }

}

