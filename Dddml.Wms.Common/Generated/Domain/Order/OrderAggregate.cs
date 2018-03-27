﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{
    public partial class OrderAggregate : AggregateBase, IOrderAggregate
    {

        readonly IOrderState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IOrderState State
        {
            get
            {
                return _state;
            }
        }

        public IList<IEvent> Changes
        {
            get
            {
                return _changes;
            }
        }

        #region IIdentity implementation

        string IGlobalIdentity<string>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public OrderAggregate(IOrderState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IOrderStateProperties)_state).Version == OrderState.VersionZero)
            {
                if (IsCommandCreate((IOrderCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (IsCommandCreate((IOrderCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IOrderCommand c)
        {
            return c.Version == OrderState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateOrder c)
        {
            IOrderStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchOrder c)
        {
            IOrderStateMergePatched e = Map(c);
            Apply(e);
        }


        protected virtual IOrderStateCreated Map(ICreateOrder c)
        {
			var stateEventId = new OrderEventId(c.OrderId, c.Version);
            IOrderStateCreated e = NewOrderStateCreated(stateEventId);
		
            e.OrderTypeId = c.OrderTypeId;
            e.OrderName = c.OrderName;
            e.ExternalId = c.ExternalId;
            e.SalesChannelEnumId = c.SalesChannelEnumId;
            e.OrderDate = c.OrderDate;
            e.Priority = c.Priority;
            e.EntryDate = c.EntryDate;
            e.PickSheetPrintedDate = c.PickSheetPrintedDate;
            e.StatusId = c.StatusId;
            e.CurrencyUom = c.CurrencyUom;
            e.SyncStatusId = c.SyncStatusId;
            e.BillingAccountId = c.BillingAccountId;
            e.OriginFacilityId = c.OriginFacilityId;
            e.WebSiteId = c.WebSiteId;
            e.ProductStoreId = c.ProductStoreId;
            e.TerminalId = c.TerminalId;
            e.TransactionId = c.TransactionId;
            e.AutoOrderShoppingListId = c.AutoOrderShoppingListId;
            e.NeedsInventoryIssuance = c.NeedsInventoryIssuance;
            e.IsRushOrder = c.IsRushOrder;
            e.InternalCode = c.InternalCode;
            e.RemainingSubTotal = c.RemainingSubTotal;
            e.GrandTotal = c.GrandTotal;
            e.InvoicePerShipment = c.InvoicePerShipment;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;

            foreach (ICreateOrderRole innerCommand in c.OrderRoles)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IOrderRoleStateCreated innerEvent = MapCreate(innerCommand, c, version, _state);
                e.AddOrderRoleEvent(innerEvent);
            }

            foreach (ICreateOrderItem innerCommand in c.OrderItems)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IOrderItemStateCreated innerEvent = MapCreate(innerCommand, c, version, _state);
                e.AddOrderItemEvent(innerEvent);
            }

            foreach (ICreateOrderShipGroup innerCommand in c.OrderShipGroups)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IOrderShipGroupStateCreated innerEvent = MapCreate(innerCommand, c, version, _state);
                e.AddOrderShipGroupEvent(innerEvent);
            }


            return e;
        }

        protected virtual IOrderStateMergePatched Map(IMergePatchOrder c)
        {
			var stateEventId = new OrderEventId(c.OrderId, c.Version);
            IOrderStateMergePatched e = NewOrderStateMergePatched(stateEventId);

            e.OrderTypeId = c.OrderTypeId;
            e.OrderName = c.OrderName;
            e.ExternalId = c.ExternalId;
            e.SalesChannelEnumId = c.SalesChannelEnumId;
            e.OrderDate = c.OrderDate;
            e.Priority = c.Priority;
            e.EntryDate = c.EntryDate;
            e.PickSheetPrintedDate = c.PickSheetPrintedDate;
            e.StatusId = c.StatusId;
            e.CurrencyUom = c.CurrencyUom;
            e.SyncStatusId = c.SyncStatusId;
            e.BillingAccountId = c.BillingAccountId;
            e.OriginFacilityId = c.OriginFacilityId;
            e.WebSiteId = c.WebSiteId;
            e.ProductStoreId = c.ProductStoreId;
            e.TerminalId = c.TerminalId;
            e.TransactionId = c.TransactionId;
            e.AutoOrderShoppingListId = c.AutoOrderShoppingListId;
            e.NeedsInventoryIssuance = c.NeedsInventoryIssuance;
            e.IsRushOrder = c.IsRushOrder;
            e.InternalCode = c.InternalCode;
            e.RemainingSubTotal = c.RemainingSubTotal;
            e.GrandTotal = c.GrandTotal;
            e.InvoicePerShipment = c.InvoicePerShipment;
            e.Active = c.Active;
            e.IsPropertyOrderTypeIdRemoved = c.IsPropertyOrderTypeIdRemoved;
            e.IsPropertyOrderNameRemoved = c.IsPropertyOrderNameRemoved;
            e.IsPropertyExternalIdRemoved = c.IsPropertyExternalIdRemoved;
            e.IsPropertySalesChannelEnumIdRemoved = c.IsPropertySalesChannelEnumIdRemoved;
            e.IsPropertyOrderDateRemoved = c.IsPropertyOrderDateRemoved;
            e.IsPropertyPriorityRemoved = c.IsPropertyPriorityRemoved;
            e.IsPropertyEntryDateRemoved = c.IsPropertyEntryDateRemoved;
            e.IsPropertyPickSheetPrintedDateRemoved = c.IsPropertyPickSheetPrintedDateRemoved;
            e.IsPropertyStatusIdRemoved = c.IsPropertyStatusIdRemoved;
            e.IsPropertyCurrencyUomRemoved = c.IsPropertyCurrencyUomRemoved;
            e.IsPropertySyncStatusIdRemoved = c.IsPropertySyncStatusIdRemoved;
            e.IsPropertyBillingAccountIdRemoved = c.IsPropertyBillingAccountIdRemoved;
            e.IsPropertyOriginFacilityIdRemoved = c.IsPropertyOriginFacilityIdRemoved;
            e.IsPropertyWebSiteIdRemoved = c.IsPropertyWebSiteIdRemoved;
            e.IsPropertyProductStoreIdRemoved = c.IsPropertyProductStoreIdRemoved;
            e.IsPropertyTerminalIdRemoved = c.IsPropertyTerminalIdRemoved;
            e.IsPropertyTransactionIdRemoved = c.IsPropertyTransactionIdRemoved;
            e.IsPropertyAutoOrderShoppingListIdRemoved = c.IsPropertyAutoOrderShoppingListIdRemoved;
            e.IsPropertyNeedsInventoryIssuanceRemoved = c.IsPropertyNeedsInventoryIssuanceRemoved;
            e.IsPropertyIsRushOrderRemoved = c.IsPropertyIsRushOrderRemoved;
            e.IsPropertyInternalCodeRemoved = c.IsPropertyInternalCodeRemoved;
            e.IsPropertyRemainingSubTotalRemoved = c.IsPropertyRemainingSubTotalRemoved;
            e.IsPropertyGrandTotalRemoved = c.IsPropertyGrandTotalRemoved;
            e.IsPropertyInvoicePerShipmentRemoved = c.IsPropertyInvoicePerShipmentRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;

            foreach (IOrderRoleCommand innerCommand in c.OrderRoleCommands)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IOrderRoleStateEvent innerEvent = Map(innerCommand, c, version, _state);
                e.AddOrderRoleEvent(innerEvent);
            }

            foreach (IOrderItemCommand innerCommand in c.OrderItemCommands)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IOrderItemStateEvent innerEvent = Map(innerCommand, c, version, _state);
                e.AddOrderItemEvent(innerEvent);
            }

            foreach (IOrderShipGroupCommand innerCommand in c.OrderShipGroupCommands)
            {
                ThrowOnInconsistentCommands(c, innerCommand);

                IOrderShipGroupStateEvent innerEvent = Map(innerCommand, c, version, _state);
                e.AddOrderShipGroupEvent(innerEvent);
            }


            return e;
        }


        protected void ThrowOnInconsistentCommands(IOrderCommand command, IOrderRoleCommand innerCommand)
        {

            var properties =  command as ICreateOrMergePatchOrDeleteOrder;
            var innerProperties = innerCommand as ICreateOrMergePatchOrRemoveOrderRole;
            if (properties == null || innerProperties == null) { return; }
            if (innerProperties.OrderId == default(string))
            {
                innerProperties.OrderId = properties.OrderId;
            }
            else
            {
                var outerOrderIdName = "OrderId";
                var outerOrderIdValue = properties.OrderId;
                var innerOrderIdName = "OrderId";
                var innerOrderIdValue = innerProperties.OrderId;
                ThrowOnInconsistentIds(innerProperties, innerOrderIdName, innerOrderIdValue, outerOrderIdName, outerOrderIdValue);
            }

        }// END ThrowOnInconsistentCommands /////////////////////


        protected void ThrowOnInconsistentCommands(IOrderCommand command, IOrderItemCommand innerCommand)
        {

            var properties =  command as ICreateOrMergePatchOrDeleteOrder;
            var innerProperties = innerCommand as ICreateOrMergePatchOrRemoveOrderItem;
            if (properties == null || innerProperties == null) { return; }
            if (innerProperties.OrderId == default(string))
            {
                innerProperties.OrderId = properties.OrderId;
            }
            else
            {
                var outerOrderIdName = "OrderId";
                var outerOrderIdValue = properties.OrderId;
                var innerOrderIdName = "OrderId";
                var innerOrderIdValue = innerProperties.OrderId;
                ThrowOnInconsistentIds(innerProperties, innerOrderIdName, innerOrderIdValue, outerOrderIdName, outerOrderIdValue);
            }

        }// END ThrowOnInconsistentCommands /////////////////////


        protected void ThrowOnInconsistentCommands(IOrderCommand command, IOrderShipGroupCommand innerCommand)
        {

            var properties =  command as ICreateOrMergePatchOrDeleteOrder;
            var innerProperties = innerCommand as ICreateOrMergePatchOrRemoveOrderShipGroup;
            if (properties == null || innerProperties == null) { return; }
            if (innerProperties.OrderId == default(string))
            {
                innerProperties.OrderId = properties.OrderId;
            }
            else
            {
                var outerOrderIdName = "OrderId";
                var outerOrderIdValue = properties.OrderId;
                var innerOrderIdName = "OrderId";
                var innerOrderIdValue = innerProperties.OrderId;
                ThrowOnInconsistentIds(innerProperties, innerOrderIdName, innerOrderIdValue, outerOrderIdName, outerOrderIdValue);
            }

        }// END ThrowOnInconsistentCommands /////////////////////


        protected virtual IOrderRoleStateEvent Map(IOrderRoleCommand c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            var create = (c.CommandType == CommandType.Create) ? (c as ICreateOrderRole) : null;
            if(create != null)
            {
                return MapCreate(create, outerCommand, version, outerState);
            }

            var merge = (c.CommandType == CommandType.MergePatch) ? (c as IMergePatchOrderRole) : null;
            if(merge != null)
            {
                return MapMergePatch(merge, outerCommand, version, outerState);
            }

            var remove = (c.CommandType == CommandType.Remove) ? (c as IRemoveOrderRole) : null;
            if (remove != null)
            {
                return MapRemove(remove, outerCommand, version);
            }
            throw new NotSupportedException();
        }


        protected virtual IOrderRoleStateCreated MapCreate(ICreateOrderRole c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderRoleEventId(c.OrderId, c.PartyRoleId, version);
            IOrderRoleStateCreated e = NewOrderRoleStateCreated(stateEventId);
            var s = outerState.OrderRoles.Get(c.PartyRoleId, true);

            e.Active = c.Active;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
            return e;

        }// END Map(ICreate... ////////////////////////////



        protected virtual IOrderRoleStateMergePatched MapMergePatch(IMergePatchOrderRole c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderRoleEventId(c.OrderId, c.PartyRoleId, version);
            IOrderRoleStateMergePatched e = NewOrderRoleStateMergePatched(stateEventId);
            var s = outerState.OrderRoles.Get(c.PartyRoleId);

            e.Active = c.Active;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
            return e;

        }// END Map(IMergePatch... ////////////////////////////


        protected virtual IOrderRoleStateRemoved MapRemove(IRemoveOrderRole c, IOrderCommand outerCommand, long version)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderRoleEventId(c.OrderId, c.PartyRoleId, version);
            IOrderRoleStateRemoved e = NewOrderRoleStateRemoved(stateEventId);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;

        }// END Map(IRemove... ////////////////////////////


        protected virtual IOrderItemStateEvent Map(IOrderItemCommand c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            var create = (c.CommandType == CommandType.Create) ? (c as ICreateOrderItem) : null;
            if(create != null)
            {
                return MapCreate(create, outerCommand, version, outerState);
            }

            var merge = (c.CommandType == CommandType.MergePatch) ? (c as IMergePatchOrderItem) : null;
            if(merge != null)
            {
                return MapMergePatch(merge, outerCommand, version, outerState);
            }

            throw new NotSupportedException();
        }


        protected virtual IOrderItemStateCreated MapCreate(ICreateOrderItem c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderItemEventId(c.OrderId, c.OrderItemSeqId, version);
            IOrderItemStateCreated e = NewOrderItemStateCreated(stateEventId);
            var s = outerState.OrderItems.Get(c.OrderItemSeqId, true);

            e.ProductId = c.ProductId;
            e.ExternalProductId = c.ExternalProductId;
            e.Quantity = c.Quantity;
            e.CancelQuantity = c.CancelQuantity;
            e.SelectedAmount = c.SelectedAmount;
            e.ExternalId = c.ExternalId;
            e.OrderItemTypeId = c.OrderItemTypeId;
            e.OrderItemGroupSeqId = c.OrderItemGroupSeqId;
            e.IsItemGroupPrimary = c.IsItemGroupPrimary;
            e.FromInventoryItemId = c.FromInventoryItemId;
            e.IsPromo = c.IsPromo;
            e.QuoteId = c.QuoteId;
            e.QuoteItemSeqId = c.QuoteItemSeqId;
            e.ShoppingListId = c.ShoppingListId;
            e.ShoppingListItemSeqId = c.ShoppingListItemSeqId;
            e.UnitPrice = c.UnitPrice;
            e.UnitListPrice = c.UnitListPrice;
            e.UnitAverageCost = c.UnitAverageCost;
            e.UnitRecurringPrice = c.UnitRecurringPrice;
            e.IsModifiedPrice = c.IsModifiedPrice;
            e.RecurringFreqUomId = c.RecurringFreqUomId;
            e.ItemDescription = c.ItemDescription;
            e.Comments = c.Comments;
            e.CorrespondingPoId = c.CorrespondingPoId;
            e.StatusId = c.StatusId;
            e.SyncStatusId = c.SyncStatusId;
            e.EstimatedShipDate = c.EstimatedShipDate;
            e.EstimatedDeliveryDate = c.EstimatedDeliveryDate;
            e.AutoCancelDate = c.AutoCancelDate;
            e.DontCancelSetDate = c.DontCancelSetDate;
            e.DontCancelSetBy = c.DontCancelSetBy;
            e.ShipBeforeDate = c.ShipBeforeDate;
            e.ShipAfterDate = c.ShipAfterDate;
            e.CancelBackOrderDate = c.CancelBackOrderDate;
            e.OverrideGlAccountId = c.OverrideGlAccountId;
            e.Active = c.Active;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
            return e;

        }// END Map(ICreate... ////////////////////////////



        protected virtual IOrderItemStateMergePatched MapMergePatch(IMergePatchOrderItem c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderItemEventId(c.OrderId, c.OrderItemSeqId, version);
            IOrderItemStateMergePatched e = NewOrderItemStateMergePatched(stateEventId);
            var s = outerState.OrderItems.Get(c.OrderItemSeqId);

            e.ProductId = c.ProductId;
            e.ExternalProductId = c.ExternalProductId;
            e.Quantity = c.Quantity;
            e.CancelQuantity = c.CancelQuantity;
            e.SelectedAmount = c.SelectedAmount;
            e.ExternalId = c.ExternalId;
            e.OrderItemTypeId = c.OrderItemTypeId;
            e.OrderItemGroupSeqId = c.OrderItemGroupSeqId;
            e.IsItemGroupPrimary = c.IsItemGroupPrimary;
            e.FromInventoryItemId = c.FromInventoryItemId;
            e.IsPromo = c.IsPromo;
            e.QuoteId = c.QuoteId;
            e.QuoteItemSeqId = c.QuoteItemSeqId;
            e.ShoppingListId = c.ShoppingListId;
            e.ShoppingListItemSeqId = c.ShoppingListItemSeqId;
            e.UnitPrice = c.UnitPrice;
            e.UnitListPrice = c.UnitListPrice;
            e.UnitAverageCost = c.UnitAverageCost;
            e.UnitRecurringPrice = c.UnitRecurringPrice;
            e.IsModifiedPrice = c.IsModifiedPrice;
            e.RecurringFreqUomId = c.RecurringFreqUomId;
            e.ItemDescription = c.ItemDescription;
            e.Comments = c.Comments;
            e.CorrespondingPoId = c.CorrespondingPoId;
            e.StatusId = c.StatusId;
            e.SyncStatusId = c.SyncStatusId;
            e.EstimatedShipDate = c.EstimatedShipDate;
            e.EstimatedDeliveryDate = c.EstimatedDeliveryDate;
            e.AutoCancelDate = c.AutoCancelDate;
            e.DontCancelSetDate = c.DontCancelSetDate;
            e.DontCancelSetBy = c.DontCancelSetBy;
            e.ShipBeforeDate = c.ShipBeforeDate;
            e.ShipAfterDate = c.ShipAfterDate;
            e.CancelBackOrderDate = c.CancelBackOrderDate;
            e.OverrideGlAccountId = c.OverrideGlAccountId;
            e.Active = c.Active;
            e.IsPropertyProductIdRemoved = c.IsPropertyProductIdRemoved;
            e.IsPropertyExternalProductIdRemoved = c.IsPropertyExternalProductIdRemoved;
            e.IsPropertyQuantityRemoved = c.IsPropertyQuantityRemoved;
            e.IsPropertyCancelQuantityRemoved = c.IsPropertyCancelQuantityRemoved;
            e.IsPropertySelectedAmountRemoved = c.IsPropertySelectedAmountRemoved;
            e.IsPropertyExternalIdRemoved = c.IsPropertyExternalIdRemoved;
            e.IsPropertyOrderItemTypeIdRemoved = c.IsPropertyOrderItemTypeIdRemoved;
            e.IsPropertyOrderItemGroupSeqIdRemoved = c.IsPropertyOrderItemGroupSeqIdRemoved;
            e.IsPropertyIsItemGroupPrimaryRemoved = c.IsPropertyIsItemGroupPrimaryRemoved;
            e.IsPropertyFromInventoryItemIdRemoved = c.IsPropertyFromInventoryItemIdRemoved;
            e.IsPropertyIsPromoRemoved = c.IsPropertyIsPromoRemoved;
            e.IsPropertyQuoteIdRemoved = c.IsPropertyQuoteIdRemoved;
            e.IsPropertyQuoteItemSeqIdRemoved = c.IsPropertyQuoteItemSeqIdRemoved;
            e.IsPropertyShoppingListIdRemoved = c.IsPropertyShoppingListIdRemoved;
            e.IsPropertyShoppingListItemSeqIdRemoved = c.IsPropertyShoppingListItemSeqIdRemoved;
            e.IsPropertyUnitPriceRemoved = c.IsPropertyUnitPriceRemoved;
            e.IsPropertyUnitListPriceRemoved = c.IsPropertyUnitListPriceRemoved;
            e.IsPropertyUnitAverageCostRemoved = c.IsPropertyUnitAverageCostRemoved;
            e.IsPropertyUnitRecurringPriceRemoved = c.IsPropertyUnitRecurringPriceRemoved;
            e.IsPropertyIsModifiedPriceRemoved = c.IsPropertyIsModifiedPriceRemoved;
            e.IsPropertyRecurringFreqUomIdRemoved = c.IsPropertyRecurringFreqUomIdRemoved;
            e.IsPropertyItemDescriptionRemoved = c.IsPropertyItemDescriptionRemoved;
            e.IsPropertyCommentsRemoved = c.IsPropertyCommentsRemoved;
            e.IsPropertyCorrespondingPoIdRemoved = c.IsPropertyCorrespondingPoIdRemoved;
            e.IsPropertyStatusIdRemoved = c.IsPropertyStatusIdRemoved;
            e.IsPropertySyncStatusIdRemoved = c.IsPropertySyncStatusIdRemoved;
            e.IsPropertyEstimatedShipDateRemoved = c.IsPropertyEstimatedShipDateRemoved;
            e.IsPropertyEstimatedDeliveryDateRemoved = c.IsPropertyEstimatedDeliveryDateRemoved;
            e.IsPropertyAutoCancelDateRemoved = c.IsPropertyAutoCancelDateRemoved;
            e.IsPropertyDontCancelSetDateRemoved = c.IsPropertyDontCancelSetDateRemoved;
            e.IsPropertyDontCancelSetByRemoved = c.IsPropertyDontCancelSetByRemoved;
            e.IsPropertyShipBeforeDateRemoved = c.IsPropertyShipBeforeDateRemoved;
            e.IsPropertyShipAfterDateRemoved = c.IsPropertyShipAfterDateRemoved;
            e.IsPropertyCancelBackOrderDateRemoved = c.IsPropertyCancelBackOrderDateRemoved;
            e.IsPropertyOverrideGlAccountIdRemoved = c.IsPropertyOverrideGlAccountIdRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
            return e;

        }// END Map(IMergePatch... ////////////////////////////



        protected virtual IOrderShipGroupStateEvent Map(IOrderShipGroupCommand c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            var create = (c.CommandType == CommandType.Create) ? (c as ICreateOrderShipGroup) : null;
            if(create != null)
            {
                return MapCreate(create, outerCommand, version, outerState);
            }

            var merge = (c.CommandType == CommandType.MergePatch) ? (c as IMergePatchOrderShipGroup) : null;
            if(merge != null)
            {
                return MapMergePatch(merge, outerCommand, version, outerState);
            }

            var remove = (c.CommandType == CommandType.Remove) ? (c as IRemoveOrderShipGroup) : null;
            if (remove != null)
            {
                return MapRemove(remove, outerCommand, version);
            }
            throw new NotSupportedException();
        }


        protected virtual IOrderShipGroupStateCreated MapCreate(ICreateOrderShipGroup c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderShipGroupEventId(c.OrderId, c.ShipGroupSeqId, version);
            IOrderShipGroupStateCreated e = NewOrderShipGroupStateCreated(stateEventId);
            var s = outerState.OrderShipGroups.Get(c.ShipGroupSeqId, true);

            e.ShipmentMethodTypeId = c.ShipmentMethodTypeId;
            e.SupplierPartyId = c.SupplierPartyId;
            e.VendorPartyId = c.VendorPartyId;
            e.CarrierPartyId = c.CarrierPartyId;
            e.CarrierRoleTypeId = c.CarrierRoleTypeId;
            e.FacilityId = c.FacilityId;
            e.ContactMechId = c.ContactMechId;
            e.TelecomContactMechId = c.TelecomContactMechId;
            e.TrackingNumber = c.TrackingNumber;
            e.ShippingInstructions = c.ShippingInstructions;
            e.MaySplit = c.MaySplit;
            e.GiftMessage = c.GiftMessage;
            e.IsGift = c.IsGift;
            e.ShipAfterDate = c.ShipAfterDate;
            e.ShipByDate = c.ShipByDate;
            e.EstimatedShipDate = c.EstimatedShipDate;
            e.EstimatedDeliveryDate = c.EstimatedDeliveryDate;
            e.PickwaveId = c.PickwaveId;
            e.Active = c.Active;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
            return e;

        }// END Map(ICreate... ////////////////////////////



        protected virtual IOrderShipGroupStateMergePatched MapMergePatch(IMergePatchOrderShipGroup c, IOrderCommand outerCommand, long version, IOrderState outerState)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderShipGroupEventId(c.OrderId, c.ShipGroupSeqId, version);
            IOrderShipGroupStateMergePatched e = NewOrderShipGroupStateMergePatched(stateEventId);
            var s = outerState.OrderShipGroups.Get(c.ShipGroupSeqId);

            e.ShipmentMethodTypeId = c.ShipmentMethodTypeId;
            e.SupplierPartyId = c.SupplierPartyId;
            e.VendorPartyId = c.VendorPartyId;
            e.CarrierPartyId = c.CarrierPartyId;
            e.CarrierRoleTypeId = c.CarrierRoleTypeId;
            e.FacilityId = c.FacilityId;
            e.ContactMechId = c.ContactMechId;
            e.TelecomContactMechId = c.TelecomContactMechId;
            e.TrackingNumber = c.TrackingNumber;
            e.ShippingInstructions = c.ShippingInstructions;
            e.MaySplit = c.MaySplit;
            e.GiftMessage = c.GiftMessage;
            e.IsGift = c.IsGift;
            e.ShipAfterDate = c.ShipAfterDate;
            e.ShipByDate = c.ShipByDate;
            e.EstimatedShipDate = c.EstimatedShipDate;
            e.EstimatedDeliveryDate = c.EstimatedDeliveryDate;
            e.PickwaveId = c.PickwaveId;
            e.Active = c.Active;
            e.IsPropertyShipmentMethodTypeIdRemoved = c.IsPropertyShipmentMethodTypeIdRemoved;
            e.IsPropertySupplierPartyIdRemoved = c.IsPropertySupplierPartyIdRemoved;
            e.IsPropertyVendorPartyIdRemoved = c.IsPropertyVendorPartyIdRemoved;
            e.IsPropertyCarrierPartyIdRemoved = c.IsPropertyCarrierPartyIdRemoved;
            e.IsPropertyCarrierRoleTypeIdRemoved = c.IsPropertyCarrierRoleTypeIdRemoved;
            e.IsPropertyFacilityIdRemoved = c.IsPropertyFacilityIdRemoved;
            e.IsPropertyContactMechIdRemoved = c.IsPropertyContactMechIdRemoved;
            e.IsPropertyTelecomContactMechIdRemoved = c.IsPropertyTelecomContactMechIdRemoved;
            e.IsPropertyTrackingNumberRemoved = c.IsPropertyTrackingNumberRemoved;
            e.IsPropertyShippingInstructionsRemoved = c.IsPropertyShippingInstructionsRemoved;
            e.IsPropertyMaySplitRemoved = c.IsPropertyMaySplitRemoved;
            e.IsPropertyGiftMessageRemoved = c.IsPropertyGiftMessageRemoved;
            e.IsPropertyIsGiftRemoved = c.IsPropertyIsGiftRemoved;
            e.IsPropertyShipAfterDateRemoved = c.IsPropertyShipAfterDateRemoved;
            e.IsPropertyShipByDateRemoved = c.IsPropertyShipByDateRemoved;
            e.IsPropertyEstimatedShipDateRemoved = c.IsPropertyEstimatedShipDateRemoved;
            e.IsPropertyEstimatedDeliveryDateRemoved = c.IsPropertyEstimatedDeliveryDateRemoved;
            e.IsPropertyPickwaveIdRemoved = c.IsPropertyPickwaveIdRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
            return e;

        }// END Map(IMergePatch... ////////////////////////////


        protected virtual IOrderShipGroupStateRemoved MapRemove(IRemoveOrderShipGroup c, IOrderCommand outerCommand, long version)
        {
            c.RequesterId = outerCommand.RequesterId;
			var stateEventId = new OrderShipGroupEventId(c.OrderId, c.ShipGroupSeqId, version);
            IOrderShipGroupStateRemoved e = NewOrderShipGroupStateRemoved(stateEventId);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;

        }// END Map(IRemove... ////////////////////////////

        private void ThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected OrderStateCreated NewOrderStateCreated(long version, string commandId, string requesterId)
        {
            var stateEventId = new OrderEventId(_state.OrderId, version);
            var e = NewOrderStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected OrderStateMergePatched NewOrderStateMergePatched(long version, string commandId, string requesterId)
        {
            var stateEventId = new OrderEventId(_state.OrderId, version);
            var e = NewOrderStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


////////////////////////

		private OrderStateCreated NewOrderStateCreated(OrderEventId stateEventId)
		{
			return new OrderStateCreated(stateEventId);			
		}

        private OrderStateMergePatched NewOrderStateMergePatched(OrderEventId stateEventId)
		{
			return new OrderStateMergePatched(stateEventId);
		}


		private OrderRoleStateCreated NewOrderRoleStateCreated(OrderRoleEventId stateEventId)
		{
			return new OrderRoleStateCreated(stateEventId);
		}

        private OrderRoleStateMergePatched NewOrderRoleStateMergePatched(OrderRoleEventId stateEventId)
		{
			return new OrderRoleStateMergePatched(stateEventId);
		}

        private OrderRoleStateRemoved NewOrderRoleStateRemoved(OrderRoleEventId stateEventId)
		{
			return new OrderRoleStateRemoved(stateEventId);
		}


		private OrderItemStateCreated NewOrderItemStateCreated(OrderItemEventId stateEventId)
		{
			return new OrderItemStateCreated(stateEventId);
		}

        private OrderItemStateMergePatched NewOrderItemStateMergePatched(OrderItemEventId stateEventId)
		{
			return new OrderItemStateMergePatched(stateEventId);
		}


		private OrderShipGroupStateCreated NewOrderShipGroupStateCreated(OrderShipGroupEventId stateEventId)
		{
			return new OrderShipGroupStateCreated(stateEventId);
		}

        private OrderShipGroupStateMergePatched NewOrderShipGroupStateMergePatched(OrderShipGroupEventId stateEventId)
		{
			return new OrderShipGroupStateMergePatched(stateEventId);
		}

        private OrderShipGroupStateRemoved NewOrderShipGroupStateRemoved(OrderShipGroupEventId stateEventId)
		{
			return new OrderShipGroupStateRemoved(stateEventId);
		}

    }

}

