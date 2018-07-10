using Dddml.Wms.Domain.InventoryItem;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.PhysicalInventory
{
    public partial class PhysicalInventoryAggregate : IPhysicalInventoryAggregate
    {
        public virtual void DocumentAction(string value, long version, string commandId, string requesterId)
        {
            var e = NewPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            DoDocumentAction(value, ts => e.DocumentStatusId = ts);
            Apply(e);
        }

        public void CountItem(string locatorId, string productId, IDictionary<string, object> attributeSetInstance, decimal countedQuantity, long version, string commandId, string requesterId)
        {
            string attributeSetInstanceId = attributeSetInstance["attributeSetInstanceId"] as string;
            if (String.IsNullOrWhiteSpace(attributeSetInstanceId))
            {
                //todo
            }
            var notNullAttrSetInstId = String.IsNullOrEmpty(attributeSetInstanceId) 
                ? InventoryItemIds.EmptyAttributeSetInstanceId : attributeSetInstanceId;
            var inventoryItemId = new InventoryItemId(productId, locatorId, notNullAttrSetInstId);
            var lineState = State.PhysicalInventoryLines.Get(inventoryItemId, false, true);

            var e = NewPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            if (lineState != null)
            {
                var lineE = e.NewPhysicalInventoryLineStateMergePatched(inventoryItemId);
                lineE.CountedQuantity = countedQuantity;
                e.AddPhysicalInventoryLineEvent(lineE);
                Apply(e);
            }
            else
            {
                var lineE = e.NewPhysicalInventoryLineStateCreated(inventoryItemId);
                lineE.CountedQuantity = countedQuantity;
                lineE.BookQuantity = 0;
                e.AddPhysicalInventoryLineEvent(lineE); 
                Apply(e);
            }
        }


    }
}
