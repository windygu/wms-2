using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.InventoryItem;
using Common.Logging;

namespace Dddml.Wms.Domain.Listeners
{
    public class InventoryItemEventListener : IAggregateEventListener<IInventoryItemAggregate, IInventoryItemState>
    {
        static readonly ILog _log = LogManager.GetLogger<InventoryItemEventListener>();

        public void EventAppended(AggregateEvent<IInventoryItemAggregate, IInventoryItemState> e)
        {
            if (!(e.Event != null && e.Event is IInventoryItemStateEvent))
            {
                return;
            }
            IInventoryItemStateEvent iiEvent = (IInventoryItemStateEvent)e.Event;
            IEnumerable<IInventoryItemEntryStateCreated> iiesCreated = null;
            if (iiEvent is IInventoryItemStateCreated)
            {
                iiesCreated = ((IInventoryItemStateCreated)iiEvent).InventoryItemEntryEvents;
            }
            else if (iiEvent is IInventoryItemStateMergePatched)
            {
                iiesCreated = ((IInventoryItemStateMergePatched)iiEvent).InventoryItemEntryEvents
                    .Where(ie => ie is IInventoryItemEntryStateCreated).Cast<IInventoryItemEntryStateCreated>();
            }
            if (iiesCreated == null)
            {
                return;
            }
            foreach (var iie in iiesCreated)
            {
                //_log.Debug(iie.QuantityOnHand);
            }
        }

    }
}
