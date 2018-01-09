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
using Dddml.Wms.Domain.InventoryItemRequirement;
using Dddml.Wms.Specialization.NHibernate;

namespace Dddml.Wms.Domain.Listeners
{
    public class InventoryItemEventListener : IAggregateEventListener<IInventoryItemAggregate, IInventoryItemState>
    {
        static readonly ILog _log = LogManager.GetLogger<InventoryItemEventListener>();

        private IIdGenerator<long, object, object> _seqIdGenerator = new TableIdGenerator();

        public IIdGenerator<long, object, object> SeqIdGenerator
        {
            get { return _seqIdGenerator; }
            set { _seqIdGenerator = value; }
        }

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

        public virtual IInventoryItemRequirementApplicationService InventoryItemRequirementApplicationService
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
                    var outputQuantity = GetOutputQuantity(pr, iie);
                    if (outputQuantity.Equals(0))
                    {
                        continue;
                    }
                    var tid = GetOrCreateInventoryPRTriggered(pr, iie);

                    var outputItemId = GetOutputInventoryItemId(pr, iie.StateEventId.InventoryItemId);
                    //_log.Debug(outputItemId.ProductId + ", " + outputItemId.LocatorId + ", " + outputItemId.AttributeSetInstanceId);

                    CreateOrUpdateOutputAccount(pr.OutputAccountName, outputQuantity, tid, outputItemId);
                }
            }
        }

        private void CreateOrUpdateOutputAccount(string outputAccountName, decimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemId outputItemId)
        {
            if (InventoryPostingRuleIds.OutputAccountNameSellableQuantity == outputAccountName)
            {
                CreateOrUpdateSellableInventoryItem(outputQuantity, tid, outputItemId);
            }
            else if (InventoryPostingRuleIds.OutputAccountNameRequiredQuantity == outputAccountName)
            {
                CreateOrUpdateInventoryItemRequirement(outputQuantity, tid, outputItemId);
            }
            else
            {
                throw new NotSupportedException(String.Format("outputAccountName = {0}", outputAccountName));
            }
        }

        private void CreateOrUpdateSellableInventoryItem(decimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemId outputItemId)
        {
            var itemState = SellableInventoryItemApplicationService.Get(outputItemId);
            if (itemState != null)
            {
                var updateItem = new MergePatchSellableInventoryItem();
                updateItem.SellableInventoryItemId = outputItemId;
                updateItem.Version = itemState.Version;
                updateItem.CommandId = Guid.NewGuid().ToString();

                var createEntry = updateItem.NewCreateSellableInventoryItemEntry();
                SetCreateSellableInventoryItemEntry(outputQuantity, tid, createEntry);
                updateItem.SellableInventoryItemEntryCommands.Add(createEntry);
                SellableInventoryItemApplicationService.When(updateItem);
            }
            else // is null
            {
                var createItem = new CreateSellableInventoryItem();
                createItem.SellableInventoryItemId = outputItemId;
                createItem.CommandId = Guid.NewGuid().ToString();

                var createEntry = createItem.NewCreateSellableInventoryItemEntry();
                SetCreateSellableInventoryItemEntry(outputQuantity, tid, createEntry);
                createItem.Entries.Add(createEntry);
                SellableInventoryItemApplicationService.When(createItem);
                //return SellableInventoryItemApplicationService.Get(outputItemId);
            }
        }

        private void SetCreateSellableInventoryItemEntry(decimal outputQuantity, InventoryPRTriggeredId tid, CreateSellableInventoryItemEntry createEntry)
        {
            createEntry.EntrySeqId = SeqIdGenerator.GetNextId();// DateTime.Now.Ticks;
            createEntry.SellableQuantity = outputQuantity;
            createEntry.SourceEventId = tid;
        }

        // ///////////////////////////////////


        private void CreateOrUpdateInventoryItemRequirement(decimal outputQuantity, InventoryPRTriggeredId tid, InventoryItemId outputItemId)
        {
            var itemState = InventoryItemRequirementApplicationService.Get(outputItemId);
            if (itemState != null)
            {
                var updateItem = new MergePatchInventoryItemRequirement();
                updateItem.InventoryItemRequirementId = outputItemId;
                updateItem.Version = itemState.Version;
                updateItem.CommandId = Guid.NewGuid().ToString();

                var createEntry = updateItem.NewCreateInventoryItemRequirementEntry();
                SetCreateInventoryItemRequirementEntry(outputQuantity, tid, createEntry);
                updateItem.InventoryItemRequirementEntryCommands.Add(createEntry);
                InventoryItemRequirementApplicationService.When(updateItem);
            }
            else // is null
            {
                var createItem = new CreateInventoryItemRequirement();
                createItem.InventoryItemRequirementId = outputItemId;
                createItem.CommandId = Guid.NewGuid().ToString();

                var createEntry = createItem.NewCreateInventoryItemRequirementEntry();
                SetCreateInventoryItemRequirementEntry(outputQuantity, tid, createEntry);
                createItem.Entries.Add(createEntry);
                InventoryItemRequirementApplicationService.When(createItem);
                //return InventoryItemRequirementApplicationService.Get(outputItemId);
            }
        }

        private void SetCreateInventoryItemRequirementEntry(decimal outputQuantity, InventoryPRTriggeredId tid, CreateInventoryItemRequirementEntry createEntry)
        {
            createEntry.EntrySeqId = SeqIdGenerator.GetNextId();//DateTime.Now.Ticks;
            createEntry.Quantity = outputQuantity;
            createEntry.SourceEventId = tid;
        }

        // ///////////////////////////////////

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

        private decimal GetOutputQuantity(IInventoryPostingRuleState pr, IInventoryItemEntryStateCreated sourceEntry)
        {
            var accountName = pr.TriggerAccountName;
            decimal srcAmount = Convert.ToDecimal(ReflectUtils.GetPropertyValue(accountName, sourceEntry));
            return pr.IsOutputNegated ? -srcAmount : srcAmount;
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
            return InventoryPostingRuleApplicationService.GetByProperty("OutputAccountName", InventoryPostingRuleIds.OutputAccountNameSellableQuantity)
                .Union(
                    InventoryPostingRuleApplicationService.GetByProperty("OutputAccountName", InventoryPostingRuleIds.OutputAccountNameRequiredQuantity)
                ).Where(pr =>
                    (pr.TriggerInventoryItemId.ProductId == InventoryItemIds.Wildcard || pr.TriggerInventoryItemId.ProductId == triggerItemId.ProductId) &&
                    (pr.TriggerInventoryItemId.LocatorId == InventoryItemIds.Wildcard || pr.TriggerInventoryItemId.LocatorId == triggerItemId.LocatorId) &&
                    (pr.TriggerInventoryItemId.AttributeSetInstanceId == InventoryItemIds.Wildcard || pr.TriggerInventoryItemId.AttributeSetInstanceId == triggerItemId.AttributeSetInstanceId)
                );
        }

    }
}
