﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderRoleMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderRoleMvo;
using Dddml.Wms.Domain.Order;

namespace Dddml.Wms.Domain.OrderRoleMvo
{

    public partial class OrderRoleMvoStateDto : IOrderRoleMvoStateDto
    {
        public virtual OrderRoleId OrderRoleId
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

        public virtual string OrderOrderTypeId
        {
            get;
            set;
        }

        public virtual string OrderOrderName
        {
            get;
            set;
        }

        public virtual string OrderExternalId
        {
            get;
            set;
        }

        public virtual string OrderSalesChannelEnumId
        {
            get;
            set;
        }

        public virtual DateTime? OrderOrderDate
        {
            get;
            set;
        }

        public virtual string OrderPriority
        {
            get;
            set;
        }

        public virtual DateTime? OrderEntryDate
        {
            get;
            set;
        }

        public virtual DateTime? OrderPickSheetPrintedDate
        {
            get;
            set;
        }

        public virtual string OrderStatusId
        {
            get;
            set;
        }

        public virtual string OrderCurrencyUom
        {
            get;
            set;
        }

        public virtual string OrderSyncStatusId
        {
            get;
            set;
        }

        public virtual string OrderBillingAccountId
        {
            get;
            set;
        }

        public virtual string OrderOriginFacilityId
        {
            get;
            set;
        }

        public virtual string OrderWebSiteId
        {
            get;
            set;
        }

        public virtual string OrderProductStoreId
        {
            get;
            set;
        }

        public virtual string OrderTerminalId
        {
            get;
            set;
        }

        public virtual string OrderTransactionId
        {
            get;
            set;
        }

        public virtual string OrderAutoOrderShoppingListId
        {
            get;
            set;
        }

        public virtual string OrderNeedsInventoryIssuance
        {
            get;
            set;
        }

        public virtual string OrderIsRushOrder
        {
            get;
            set;
        }

        public virtual string OrderInternalCode
        {
            get;
            set;
        }

        public virtual decimal? OrderRemainingSubTotal
        {
            get;
            set;
        }

        public virtual decimal? OrderGrandTotal
        {
            get;
            set;
        }

        public virtual string OrderInvoicePerShipment
        {
            get;
            set;
        }

        public virtual string OrderCreatedBy
        {
            get;
            set;
        }

        public virtual DateTime? OrderCreatedAt
        {
            get;
            set;
        }

        public virtual string OrderUpdatedBy
        {
            get;
            set;
        }

        public virtual DateTime? OrderUpdatedAt
        {
            get;
            set;
        }

        public virtual bool? OrderActive
        {
            get;
            set;
        }

        public virtual long? OrderVersion
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

        public virtual IOrderRoleMvoState ToOrderRoleMvoState()
        {
            var state = new OrderRoleMvoState(true);
            state.OrderRoleId = this.OrderRoleId;
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            state.OrderOrderTypeId = this.OrderOrderTypeId;
            state.OrderOrderName = this.OrderOrderName;
            state.OrderExternalId = this.OrderExternalId;
            state.OrderSalesChannelEnumId = this.OrderSalesChannelEnumId;
            state.OrderOrderDate = this.OrderOrderDate;
            state.OrderPriority = this.OrderPriority;
            state.OrderEntryDate = this.OrderEntryDate;
            state.OrderPickSheetPrintedDate = this.OrderPickSheetPrintedDate;
            state.OrderStatusId = this.OrderStatusId;
            state.OrderCurrencyUom = this.OrderCurrencyUom;
            state.OrderSyncStatusId = this.OrderSyncStatusId;
            state.OrderBillingAccountId = this.OrderBillingAccountId;
            state.OrderOriginFacilityId = this.OrderOriginFacilityId;
            state.OrderWebSiteId = this.OrderWebSiteId;
            state.OrderProductStoreId = this.OrderProductStoreId;
            state.OrderTerminalId = this.OrderTerminalId;
            state.OrderTransactionId = this.OrderTransactionId;
            state.OrderAutoOrderShoppingListId = this.OrderAutoOrderShoppingListId;
            state.OrderNeedsInventoryIssuance = this.OrderNeedsInventoryIssuance;
            state.OrderIsRushOrder = this.OrderIsRushOrder;
            state.OrderInternalCode = this.OrderInternalCode;
            state.OrderRemainingSubTotal = this.OrderRemainingSubTotal;
            state.OrderGrandTotal = this.OrderGrandTotal;
            state.OrderInvoicePerShipment = this.OrderInvoicePerShipment;
            state.OrderCreatedBy = this.OrderCreatedBy;
            if (this.OrderCreatedAt != null && this.OrderCreatedAt.HasValue) { state.OrderCreatedAt = this.OrderCreatedAt.Value; }
            state.OrderUpdatedBy = this.OrderUpdatedBy;
            if (this.OrderUpdatedAt != null && this.OrderUpdatedAt.HasValue) { state.OrderUpdatedAt = this.OrderUpdatedAt.Value; }
            if (this.OrderActive != null && this.OrderActive.HasValue) { state.OrderActive = this.OrderActive.Value; }
            if (this.OrderVersion != null && this.OrderVersion.HasValue) { state.OrderVersion = this.OrderVersion.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }

            return state;
        }

    }

}
