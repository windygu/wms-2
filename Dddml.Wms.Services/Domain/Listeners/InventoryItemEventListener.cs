using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common.Logging;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.SellableInventoryItem;

namespace Dddml.Wms.Domain.Listeners
{
    public class InventoryItemEventListener : IAggregateEventListener<IInventoryItemAggregate, IInventoryItemState>
    {
        static readonly ILog _log = LogManager.GetLogger<InventoryItemEventListener>();

        public virtual IInventoryPRTriggeredApplicationService InventoryPRTriggeredApplicationService
        {
            get;
            set;
        }

        public virtual IInventoryPostingRuleApplicationService InventoryPostingRuleApplicationService
        {
            get;
            set;
        }

        public virtual ISellableInventoryItemApplicationService SellableInventoryItemApplicationService
        {
            get;
            set;
        }

        public void EventAppended(AggregateEvent<IInventoryItemAggregate, IInventoryItemState> e)
        {
            if (!(e.Event != null && e.Event is IInventoryItemStateEvent))
            {
                return;
            }
            IInventoryItemStateEvent inventoryItemEvent = (IInventoryItemStateEvent)e.Event;
            IEnumerable<IInventoryItemEntryStateCreated> itemEntriesCreated = null;
            if (inventoryItemEvent is IInventoryItemStateCreated)
            {
                itemEntriesCreated = ((IInventoryItemStateCreated)inventoryItemEvent).InventoryItemEntryEvents;
            }
            else if (inventoryItemEvent is IInventoryItemStateMergePatched)
            {
                itemEntriesCreated = ((IInventoryItemStateMergePatched)inventoryItemEvent).InventoryItemEntryEvents
                    .Where(ie => ie is IInventoryItemEntryStateCreated).Cast<IInventoryItemEntryStateCreated>();
            }
            if (itemEntriesCreated == null)
            {
                return;
            }
            foreach (var iie in itemEntriesCreated)
            {
                foreach (var pr in GetPostingRules(iie.StateEventId.InventoryItemId))
                {
                    var quantitySellable = GetOutputQuantitySellable(pr, iie);
                    if (quantitySellable.Equals(0))
                    {
                        continue;
                    }
                    var tid = GetOrCreateInventoryPRTriggered(pr, iie);

                    var outputItemId = GetOutputInventoryItemId(pr, iie.StateEventId.InventoryItemId);
                    //_log.Debug(outputItemId.ProductId + ", " + outputItemId.LocatorId + ", " + outputItemId.AttributeSetInstanceId);

                    var sellableItem = GetOrCreateSellableInventoryItem(outputItemId);

                    // //////////////////////////////
                    UpdateSellableInventoryItem(quantitySellable, tid, sellableItem);
                }
            }
        }

        private void UpdateSellableInventoryItem(decimal quantitySellable, InventoryPRTriggeredId tid, ISellableInventoryItemState sellableItem)
        {
            InventoryItemId outputItemId = sellableItem.SellableInventoryItemId;

            var updateSellableItem = new MergePatchSellableInventoryItem();
            updateSellableItem.SellableInventoryItemId = outputItemId;
            updateSellableItem.Version = sellableItem.Version;
            updateSellableItem.CommandId = Guid.NewGuid().ToString();

            var createSellableEntry = updateSellableItem.NewCreateSellableInventoryItemEntry();
            createSellableEntry.EntrySeqId = DateTime.Now.Ticks;//todo ??
            createSellableEntry.QuantitySellable = quantitySellable;
            createSellableEntry.SourceEventId = tid;
            updateSellableItem.SellableInventoryItemEntryCommands.Add(createSellableEntry);
            SellableInventoryItemApplicationService.When(updateSellableItem);
        }

        private InventoryPRTriggeredId GetOrCreateInventoryPRTriggered(IInventoryPostingRuleState pr, IInventoryItemEntryStateCreated iie)
        {
            var createTriggered = new CreateInventoryPRTriggered();
            var sourceEntryId = new InventoryItemEntryId(iie.StateEventId.InventoryItemId, iie.StateEventId.EntrySeqId);
            string postingRuleId = pr.InventoryPostingRuleId;
            var tid = new InventoryPRTriggeredId(sourceEntryId, postingRuleId);
            createTriggered.InventoryPRTriggeredId = tid;
            createTriggered.CommandId = Guid.NewGuid().ToString();
            InventoryPRTriggeredApplicationService.When(createTriggered);
            return tid;//todo If existed??
        }

        private decimal GetOutputQuantitySellable(IInventoryPostingRuleState pr, IInventoryItemEntryStateCreated sourceEntry)
        {
            var accountName = pr.TriggerAccountName;
            decimal srcAmount = Convert.ToDecimal(ReflectUtils.GetPropertyValue(accountName, sourceEntry));
            return pr.IsOutputNegated ? -srcAmount : srcAmount;
        }

        private ISellableInventoryItemState GetOrCreateSellableInventoryItem(InventoryItemId inventoryItemId)
        {
            var s = SellableInventoryItemApplicationService.Get(inventoryItemId);
            if (s != null)
            {
                return s;
            }
            var createItem = new CreateSellableInventoryItem();
            createItem.SellableInventoryItemId = inventoryItemId;
            createItem.CommandId = Guid.NewGuid().ToString();
            SellableInventoryItemApplicationService.When(createItem);
            return SellableInventoryItemApplicationService.Get(inventoryItemId);//todo 优化？
        }

        private InventoryItemId GetOutputInventoryItemId(IInventoryPostingRuleState pr, InventoryItemId triggerItemId)
        {
            var productId = pr.OutputInventoryItemId.ProductId == InventoryItemIds.SameAsSource ?
                triggerItemId.ProductId : pr.OutputInventoryItemId.ProductId;
            var locatorId = pr.OutputInventoryItemId.LocatorId == InventoryItemIds.SameAsSource ? 
                triggerItemId.LocatorId : pr.OutputInventoryItemId.LocatorId;
            var attrInstSetId = pr.OutputInventoryItemId.AttributeSetInstanceId == InventoryItemIds.SameAsSource ? 
                triggerItemId.AttributeSetInstanceId : pr.OutputInventoryItemId.AttributeSetInstanceId;
            var outputItemId = new InventoryItemId(productId, locatorId, attrInstSetId);
            return outputItemId;
        }

        private IEnumerable<IInventoryPostingRuleState> GetPostingRules(InventoryItemId triggerItemId)
        {
            return InventoryPostingRuleApplicationService.GetByProperty("OutputAccountName", "QuantitySellable")
                .Where(pr =>
                    (pr.TriggerInventoryItemId.ProductId == InventoryItemIds.Wildcard || pr.TriggerInventoryItemId.ProductId == triggerItemId.ProductId) &&
                    (pr.TriggerInventoryItemId.LocatorId == InventoryItemIds.Wildcard || pr.TriggerInventoryItemId.LocatorId == triggerItemId.LocatorId) &&
                    (pr.TriggerInventoryItemId.AttributeSetInstanceId == InventoryItemIds.Wildcard || pr.TriggerInventoryItemId.AttributeSetInstanceId == triggerItemId.AttributeSetInstanceId)
                );
        }

    }
}
